package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CustomersController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Customers.list(params), model:[customersCount: Customers.count()]
    }

    def show(Customers customers) {
        respond customers
    }

    def create() {
        respond new Customers(params)
    }

    @Transactional
    def save(Customers customers) {
        if (customers == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customers.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customers.errors, view:'create'
            return
        }

        customers.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customers.label', default: 'Customers'), customers.id])
                redirect customers
            }
            '*' { respond customers, [status: CREATED] }
        }
    }

    def edit(Customers customers) {
        respond customers
    }

    @Transactional
    def update(Customers customers) {
        if (customers == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customers.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customers.errors, view:'edit'
            return
        }

        customers.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customers.label', default: 'Customers'), customers.id])
                redirect customers
            }
            '*'{ respond customers, [status: OK] }
        }
    }

    @Transactional
    def delete(Customers customers) {

        if (customers == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        customers.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customers.label', default: 'Customers'), customers.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customers.label', default: 'Customers'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
