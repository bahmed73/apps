package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProductsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Products.list(params), model:[productsCount: Products.count()]
    }

    def show(Products products) {
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
