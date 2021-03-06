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

	static fProd = "/opt/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
	def search() {
		System.out.println("inside search")
		def searchTerm = params.search
		
		if (searchTerm != null) {
			System.out.println("search term = " + searchTerm)
			
			def productsList = Products.findAllByDescriptionIlike("%"+searchTerm+"%")
			def blogsList = Blog.findAllByDescriptionIlike("%"+searchTerm+"%")
			[productsList:productsList, blogsList:blogsList]
			//respond productsList
		}
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
        def categoryList = Category.findAll([sort: "categoryOrder", order: "desc"])
		def categoryExpando = new ArrayList()
		
		for (int i=0; i<categoryList.size();i++) {
			def products = Products.findAllByCategory(categoryList.getAt(i), [sort: "productsOrder", order: "desc"])
			
			def expando = new Expando()
			expando.category = categoryList.getAt(i)
			expando.products = products
			categoryExpando.add(expando)
		}
		[categoryExpando: categoryExpando]
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
		
		if (products == null) {
			redirect action:"index", method:"GET"
			return
		}
		
		if (products.price != null) {
			
			def productPrice = products.price
			
			int x = productPrice.indexOf("\$")
			
			if (x > -1) {
				productPrice = productPrice.substring(x+1)
			}
			
			int y = productPrice.indexOf(",")
			
			if (y > -1) {
				productPrice = productPrice.replace(",", "")
			}
			
			products.price = productPrice
		}
		
		log.info "product is not null"
		def user = products.user
		
		appsService.addProductView(products, request.getRemoteAddr(), user)
		
		log.info "added product views"
		
		appsService.trackProductReferer(request.getHeader("REFERER"), products, user)
		
		log.info "added product referers"
		
		def productViews = ProductView.countByProducts(products)
		
		def photos = Photos.findAllByProducts(products, [sort: "photoOrder", order: "desc"])
		
		def videos = Videos.findAllByProducts(products)
		
		[products:products, productViews:productViews, photos:photos, videos:videos]
		
        //respond products, model:[productViews: productViews]
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
		
		if (products.price != null) {
		
			def productPrice = products.price
			
			int x = productPrice.indexOf("\$")
			
			if (x > -1) {
				productPrice = productPrice.substring(x+1)
			}
			
			int y = productPrice.indexOf(",")
			
			if (y > -1) {
				productPrice = productPrice.replace(",", "")
			}
			
			products.price = productPrice
		}
		
		
	
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
		
		respond products
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
		
		products.user = user
		
		if (products.price != null) {
			
				def productPrice = products.price
				
				int x = productPrice.indexOf("\$")
				
				if (x > -1) {
					productPrice = productPrice.substring(x+1)
				}
				
				int y = productPrice.indexOf(",")
				
				if (y > -1) {
					productPrice = productPrice.replace(",", "")
				}
				
				products.price = productPrice
			}
        
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
		
		//set all photos for this product to null
		
		def photos = Photos.findAllByProducts(products)
		
		if (photos != null) {
			for (int i=0; i<photos.size(); i++) {
				def photo = photos.get(i)
				photo.products = null
				photo.save flush:true
			}
		} 
		
		def productReferers = ProductReferer.findAllByProducts(products)
		
		if (productReferers != null) {
			for (int j=0;j<productReferers.size(); j++) {
				def productReferer = productReferers.get(j)
				productReferer.delete flush:true
			}
		}
		
		def productViews = ProductView.findAllByProducts(products)
		
		if (productViews != null) {
			for (int j=0;j<productViews.size(); j++) {
				def productView = productViews.get(j)
				productView.delete flush:true
			}
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
