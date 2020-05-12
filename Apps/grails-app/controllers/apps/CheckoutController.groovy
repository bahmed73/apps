package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ANONYMOUS')
class CheckoutController {

	def paymentService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured('ROLE_ADMIN')
	def index(Integer max) {
		def checkoutList = Checkout.findAll()
		[checkoutList:checkoutList]
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
	def buyNow(Products products) {
		System.out.println("Inside buy now")
		def shoppingCart = session.shoppingCart
		
		if (shoppingCart == null) {
			shoppingCart = new ArrayList()
		}
		shoppingCart.add(products)
		session.shoppingCart = shoppingCart
		
		forward(controller: "checkout", action: "create", model:Checkout)
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
	def reset() {
		session.shoppingCart = null
		//redirect(controller: "checkout", action:"create")
		//forward(controller: "checkout", action: "create", model:Checkout)
		render(view: "checkout")
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
	def checkout(Products products) {
		def shoppingCart = session.shoppingCart
		
		if (shoppingCart == null) {
			//redirect(controller: "checkout", action:"checkout")
			//forward(controller: "checkout", action: "checkout", model:Checkout)
			render(view: "checkout")
		} else {
			//redirect(controller: "checkout", action:"create")
			forward(controller: "checkout", action: "create", model:Checkout)
		}
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
	def addToShoppingCart(Products products) {
	
		def shoppingCart = session.shoppingCart
		
		if (shoppingCart == null) {
			shoppingCart = new ArrayList()
		}
		shoppingCart.add(products)
		session.shoppingCart = shoppingCart
		//redirect(controller: "products", action:"show", id:products.id)
		forward(controller: "products", action: "show", id:products.id, model:Products)
		
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(Checkout checkout) {
        respond checkout
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def create() {
		System.out.println("inside create")
		
		int price = 0
		
		if (session.shoppingCart != null) {
			System.out.println("inside create: shopping cart is not null")
			
			for (int i=0; i<session.shoppingCart.size(); i++) {
				def productPrice = session.shoppingCart.getAt(i).price
				int x = productPrice.indexOf("\$")
					
				if (x > -1) {
					productPrice = productPrice.substring(x+1)
				}
				
				int y = productPrice.indexOf(",")
				
				if (y > -1) {
					productPrice = productPrice.replace(",", "")
				}
				
				price = price + Integer.valueOf(productPrice)
				
			}
		}
		
		params.amount = String.valueOf(price)
		
		System.out.println("inside create: shopping cart is not null: " + price)
		
		
        respond new Checkout(params)
    }

	def transaction() {
		
	}
	
	def productCheckout() {
		System.out.println("Inside product checkout")
		log.info "Order received"
		
		/*
		mailService.sendMail {
			to "bilal@mytweetmark.com"
			from "bilal.ahmed@foodal.co"
			subject "Order received"
			text "Please validate transaction."
		}
		*/
		
		/*try {
			def amount = Double.parseDouble(params.amount)
			def token = params.stripeToken
			
			System.out.println("amount = " + amount)
			System.out.println("token = " + token)
			
			if(amount && token){
				println "\n\nSTRIPE API KEY : ${Stripe.apiKey} -> TOKEN : ${token} -> AMOUNT : ${amount}\n\n"
				//convert amount into cents
				def amountInCents = (amount * 100) as Integer
				System.out.println("amount in cents: " + amountInCents)
				
				paymentService.charge(token, amountInCents)
				flash.message = "Successfully charged Stripe"
			}

		
		} catch (Exception e) {
			flash.message = "Something went wrong ..."
			println("Status is: " + e.printStackTrace());
		}*/
	}
	
	
    @Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def save(Checkout checkout) {
		
		System.out.println("inside Checkout.save")
		
        if (checkout == null) {
			System.out.println("checkout is null")
			
            //notFound()
            return
        }

        if (checkout.hasErrors()) {
			System.out.println("checkout has errors")
			System.out.println(checkout.errors)
			
            respond checkout.errors, view:'create'
            return
        }

		if (session.shoppingCart != null) {
			def cartProducts = new StringBuffer()
			int price = 0
			
			for (int i=0;i<session.shoppingCart.size(); i++) {
				cartProducts.append(session.shoppingCart.get(i).name + " ")	
				
				def productPrice = session.shoppingCart.getAt(i).price
				int x = productPrice.indexOf("\$")
					
				if (x > -1) {
					productPrice = productPrice.substring(x+1)
				}
				
				int y = productPrice.indexOf(",")
				
				if (y > -1) {
					productPrice = productPrice.replace(",", "")
				}
				
				price = price + Integer.valueOf(productPrice)
			}
			checkout.shoppingCart = cartProducts
			checkout.amount = String.valueOf(price)
		}
		
		if (checkout.domesticShipment == true) {
			def totalAmount = Integer.valueOf(checkout.amount) + 15;
			checkout.amount = String.valueOf(totalAmount)
		}
		
		if (checkout.internationalShipment == true) {
			def totalAmount = Integer.valueOf(checkout.amount) + 25;
			checkout.amount = String.valueOf(totalAmount)
		}
		
		checkout.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'checkout.label', default: 'Checkout'), checkout.id])
                redirect checkout
            }
            '*' { respond checkout, [status: CREATED] }
        }
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
	def processCheckout(Checkout checkout) {
		
		System.out.println("Inside process checkout")
		String token = request.getParameter("stripeToken");
		
		System.out.println("Inside process checkout: token = " + token)
		System.out.println("Inside process checkout: amount = " + checkout.amount)
		
		checkout.stripeToken = token
		checkout.save flush:true
		
		int price = Integer.valueOf(checkout.amount) 
		
		def processPayment = paymentService.charge(checkout.stripeToken, price)
		//def processPayment = true
		
		if (processPayment == true) {
			render(view: "success")	
		}	else {
			render(view: "failure")
		}	
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
	def success() {
		
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
	def failure() {
		
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def edit(Checkout checkout) {
        respond checkout
    }

    @Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def update(Checkout checkout) {
        if (checkout == null) {
            //transactionStatus.setRollbackOnly()
            //notFound()
            return
        }

        if (checkout.hasErrors()) {
            //transactionStatus.setRollbackOnly()
            respond checkout.errors, view:'edit'
            return
        }

		if (session.shoppingCart != null) {
			def cartProducts = new StringBuffer()
			
			int price = 0
			
			for (int i=0;i<session.shoppingCart.size(); i++) {
				cartProducts.append(session.shoppingCart.get(i).name + " ")
				
				def productPrice = session.shoppingCart.getAt(i).price
				int x = productPrice.indexOf("\$")
					
				if (x > -1) {
					productPrice = productPrice.substring(x+1)
				}
				
				int y = productPrice.indexOf(",")
				
				if (y > -1) {
					productPrice = productPrice.replace(",", "")
				}
				
				price = price + Integer.valueOf(productPrice)
			}
			checkout.shoppingCart = cartProducts
			checkout.amount = String.valueOf(price)
		}
		
		if (checkout.domesticShipment == true) {
			def totalAmount = Integer.valueOf(checkout.amount) + 15;
			checkout.amount = String.valueOf(totalAmount)
		}
		
		if (checkout.internationalShipment == true) {
			def totalAmount = Integer.valueOf(checkout.amount) + 25;
			checkout.amount = String.valueOf(totalAmount)
		}
		
        checkout.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'checkout.label', default: 'Checkout'), checkout.id])
                redirect checkout
            }
            '*'{ respond checkout, [status: OK] }
        }
    }

    @Transactional
    def delete(Checkout checkout) {

        if (checkout == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        checkout.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'checkout.label', default: 'Checkout'), checkout.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'checkout.label', default: 'Checkout'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
