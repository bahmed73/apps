package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CheckoutController {

	def paymentService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured('IS_AUTHENTICATED_ANONYMOUSLY')
    def index(Integer max) {
		System.out.println("from stripe?" + params)
		
		if (params.stripeToken != null) {
			paymentService.homepageCheckout(params)
			redirect(controller: "register")
		} else {
		
        	params.max = Math.min(max ?: 10, 100)
			respond Checkout.list(params), model:[checkoutCount: Checkout.count()]
			return
		}
		
    }

    def show(Checkout checkout) {
        respond checkout
    }

    def create() {
        respond new Checkout(params)
    }

	def transaction() {
		
	}
	
	def checkout() {
		System.out.println("Inside checkout")
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
	
    @Transactional
    def save(Checkout checkout) {
        if (checkout == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (checkout.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond checkout.errors, view:'create'
            return
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

    def edit(Checkout checkout) {
        respond checkout
    }

    @Transactional
    def update(Checkout checkout) {
        if (checkout == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (checkout.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond checkout.errors, view:'edit'
            return
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
