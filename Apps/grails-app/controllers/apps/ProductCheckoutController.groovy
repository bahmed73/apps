package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
import com.jameskleeh.excel.ExcelBuilder

@Secured('ROLE_ADMIN')
class ProductCheckoutController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ProductCheckout.list(params), model:[productCheckoutCount: ProductCheckout.count()]
    }

    def show(ProductCheckout productCheckout) {
        respond productCheckout
    }

    def create() {
        respond new ProductCheckout(params)
    }

    @Transactional
    def save(ProductCheckout productCheckout) {
        if (productCheckout == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (productCheckout.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond productCheckout.errors, view:'create'
            return
        }

        productCheckout.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'productCheckout.label', default: 'ProductCheckout'), productCheckout.id])
                redirect productCheckout
            }
            '*' { respond productCheckout, [status: CREATED] }
        }
    }

    def edit(ProductCheckout productCheckout) {
        respond productCheckout
    }

    @Transactional
    def update(ProductCheckout productCheckout) {
        if (productCheckout == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (productCheckout.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond productCheckout.errors, view:'edit'
            return
        }

        productCheckout.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'productCheckout.label', default: 'ProductCheckout'), productCheckout.id])
                redirect productCheckout
            }
            '*'{ respond productCheckout, [status: OK] }
        }
    }

    @Transactional
    def delete(ProductCheckout productCheckout) {

        if (productCheckout == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        productCheckout.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'productCheckout.label', default: 'ProductCheckout'), productCheckout.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'productCheckout.label', default: 'ProductCheckout'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
