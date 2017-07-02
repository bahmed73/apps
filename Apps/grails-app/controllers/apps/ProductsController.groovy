package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import groovy.util.logging.Log;

import java.security.Principal
//import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
//@Transactional(readOnly = true)
class ProductsController {

	def appsService
	def springSecurityService
	def mailService
	def paymentService
	def twitterService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	static fProd = "/root/tomcat/apache-tomcat-9.0.0.M21/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def productsList = Products.findAllByUser(user)
        respond productsList
    }
	
	def twitterUserData() {
		System.out.println("inside twitter user data: loggedIn!")
		log.info "inside twitter user data: loggedIn!"
		
		def searchResults = twitterService.search("#russiagate", session.twitter)
		
		//render (view: "twitterUserData", bean: searchResults)
		respond searchResults, model:[searchTerm: "#russiagate", searchCount:searchResults.size()]
	}

	@Transactional
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
	def show(Products products) {
		
		log.info "show products, params = " + params
		
		if (params.stripeToken != null) {
			log.info "stripe token = " + params.stripeToken
			paymentService.productCheckout(params)
		}
		if (products == null) {
			redirect action:"index", method:"GET"
			return
		}
		
		log.info "product is not null"
		def user = products.user
		
		appsService.addProductView(products, request.getRemoteAddr(), user)
		
		log.info "added product views"
		
		appsService.trackProductReferer(request.getHeader("REFERER"), products, user)
		
		log.info "added product referers"
		
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
		log.info "inside products.save"
		
        if (products == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }
		log.info "products is not null"
        if (products.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond products.errors, view:'create'
            return
        }

		Principal principal = request.getUserPrincipal();
        log.info "principal name" + principal.getName()
		
		def user = User.findByUsername(principal.getName())
		products.user = user
		
        
		/*
		mailService.sendMail {
			to "bilal@mytweetmark.com"
			from "bilal.ahmed@foodal.co"
			subject "New Product"
			text "A new product has been created"
		}*/
		
		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\PRODUCTS_"+products.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProductPhoto(file, products)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/PRODUCTS_"+products.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProductPhoto(file, products)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/PRODUCTS_"+products.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProductPhoto(file, products)
						break
				}

			}
			else {
			   log.info "file is empty"
			}
		} catch (Exception e) {
				e.printStackTrace( )
				log.info "caught exception: " + e.getMessage()
				log.info "caught exception: " + e
		}
		
		products.save flush:true
		
		
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
		log.info "inside update"
		
        if (products == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }
		
		log.info "products.id = " + products.id

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
		
        
		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\PRODUCTS_"+products.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProductPhoto(file, products)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/PRODUCTS_"+products.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProductPhoto(file, products)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/PRODUCTS_"+products.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProductPhoto(file, products)
						break
				}

			}
			else {
			   log.info "file is empty"
			}
		} catch (Exception e) {
				e.printStackTrace()
				log.info "Exception in edit products: " + e
		} 
		
		products.save flush:true
		
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
