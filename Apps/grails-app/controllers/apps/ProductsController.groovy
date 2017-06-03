package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import java.security.Principal
//import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
//@Transactional(readOnly = true)
class ProductsController {

	def appsService
	def springSecurityService
	def mailService
	def paymentService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def productsList = Products.findAllByUser(user)
        respond productsList
    }

	@Secured(['ROLE_ANONYMOUS', 'ROLE_ADMIN'])
    def show(Products products) {
		
		System.out.println("show products, params = " + params)
		
		if (params.stripeToken != null) {
			System.out.println("stripe token = " + params.stripeToken)
			paymentService.productCheckout(params)
		}
		if (products == null) {
			redirect action:"index", method:"GET"
			return
		}
		def user = products.user
		
		appsService.addProductView(products, request.getRemoteAddr(), user)
		appsService.trackProductReferer(request.getHeader("REFERER"), products, user)
		def productViews = ProductView.countByProducts(products)
        respond products, model:[productViews: productViews]
    }

    def create() {
        respond new Products(params)
    }

	def checkout() {
		System.out.println("Inside products.checkout")	
	}
	
    @Transactional
    def save(Products products) {
        if (products == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (products.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond products.errors, view:'create'
            return
        }

		Principal principal = request.getUserPrincipal();
        System.out.println("principal name" + principal.getName())
		
		def user = User.findByUsername(principal.getName())
		products.user = user
		
        products.save flush:true

		/*
		mailService.sendMail {
			to "bilal.ahmed@foodal.co"
			from "bilal.ahmed@foodal.co"
			subject "New Product"
			text "A new product has been created"
		}*/
		
		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				println "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images\\PRODUCTS_"+products.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProductPhoto(file)
						break
				case grails.util.Environment.TEST:
						fileName = "/usr/share/tomcat/webapps/ROOT/assets/PRODUCTS_"+products.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProductPhoto(file)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = "/usr/share/tomcat/webapps/ROOT/assets/PRODUCTS_"+products.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProductPhoto(file)
						break
				}

			}
			else {
			   println "file is empty"
			}
		} catch (Exception e) {
				e.printStackTrace( )
		}
		
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'products.label', default: 'Products'), products.id])
                redirect products
            }
            '*' { respond products, [status: CREATED] }
        }
    }

    def edit(Products products) {
		
		def user = springSecurityService.currentUser
		log.info "username = " + user.username
		
		if (products.user == user) {
			respond products
		} else {
		flash.message ="Access denied."
			redirect action:"index", method:"GET"
			return
		}
    }

    @Transactional
    def update(Products products) {
        if (products == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (products.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond products.errors, view:'edit'
            return
        }

		Principal principal = request.getUserPrincipal();
		log.info "principal name" + principal.getName()
		
		def user = User.findByUsername(principal.getName())
		
		if (products.user != user) {
			flash.message ="Access denied."
			redirect action:"index", method:"GET"
			return
		}
		
		products.user = user
		
        products.save flush:true

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images\\PRODUCTS_"+products.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProductPhoto(file)
						break
				case grails.util.Environment.TEST:
						fileName = "/usr/share/tomcat/webapps/ROOT/assets/PRODUCTS_"+products.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProductPhoto(file)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = "/usr/share/tomcat/webapps/ROOT/assets/PRODUCTS_"+products.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProductPhoto(file)
						break
				}

			}
			else {
			   log.info "file is empty"
			}
		} catch (Exception e) {
				e.printStackTrace()
				log.info "Exception in edit products"
		} 
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'products.label', default: 'Products'), products.id])
                redirect products
            }
            '*'{ respond products, [status: OK] }
        }
    }

    @Transactional
    def delete(Products products) {

        if (products == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		if (products.user != user) {
			flash.message ="Access denied."
			redirect action:"index", method:"GET"
			return
		}
		
        products.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'products.label', default: 'Products'), products.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'products.label', default: 'Products'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
