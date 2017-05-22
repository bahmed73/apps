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
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Products.list(params), model:[productsCount: Products.count()]
    }

    def show(Products products) {
		appsService.addProductView(products, request.getRemoteAddr())
		appsService.trackProductReferer(request.getHeader("REFERER"), products)
        respond products
    }

    def create() {
        respond new Products(params)
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
				case grails.util.Environment.PRODUCTION:
						fileName = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images\\PRODUCTS_"+products.id
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
        respond products
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
		System.out.println("principal name" + principal.getName())
		
		def user = User.findByUsername(principal.getName())
		products.user = user
		
        products.save flush:true

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				println "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.TEST:
						fileName = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images\\PRODUCTS_"+products.id
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProductPhoto(file)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images\\PRODUCTS_"+products.id
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
