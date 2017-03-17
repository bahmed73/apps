package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DiscountController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Discount.list(params), model:[discountCount: Discount.count()]
    }

    def show(Discount discount) {
        respond discount
    }

    def create() {
        respond new Discount(params)
    }

    @Transactional
    def save(Discount discount) {
        if (discount == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (discount.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond discount.errors, view:'create'
            return
        }

        discount.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'discount.label', default: 'Discount'), discount.id])
                redirect discount
            }
            '*' { respond discount, [status: CREATED] }
        }
    }

    def edit(Discount discount) {
        respond discount
    }

    @Transactional
    def update(Discount discount) {
        if (discount == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (discount.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond discount.errors, view:'edit'
            return
        }

        discount.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'discount.label', default: 'Discount'), discount.id])
                redirect discount
            }
            '*'{ respond discount, [status: OK] }
        }
    }

    @Transactional
    def delete(Discount discount) {

        if (discount == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        discount.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'discount.label', default: 'Discount'), discount.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'discount.label', default: 'Discount'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
