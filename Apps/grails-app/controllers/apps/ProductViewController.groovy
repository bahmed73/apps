package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
@Secured('ROLE_ADMIN')

class ProductViewController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def productViewList = ProductView.findAllByUser(user)
		
        respond productViewList
    }

    def show(ProductView productView) {
        respond productView
    }

    def create() {
        respond new ProductView(params)
    }

    @Transactional
    def save(ProductView productView) {
        if (productView == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (productView.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond productView.errors, view:'create'
            return
        }

        productView.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'productView.label', default: 'ProductView'), productView.id])
                redirect productView
            }
            '*' { respond productView, [status: CREATED] }
        }
    }

    def edit(ProductView productView) {
        respond productView
    }

    @Transactional
    def update(ProductView productView) {
        if (productView == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (productView.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond productView.errors, view:'edit'
            return
        }

        productView.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'productView.label', default: 'ProductView'), productView.id])
                redirect productView
            }
            '*'{ respond productView, [status: OK] }
        }
    }

    @Transactional
    def delete(ProductView productView) {

        if (productView == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        productView.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'productView.label', default: 'ProductView'), productView.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'productView.label', default: 'ProductView'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
