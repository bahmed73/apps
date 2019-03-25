package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class VendorsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Vendors.list(params), model:[vendorsCount: Vendors.count()]
    }

    def show(Vendors vendors) {
        respond vendors
    }

    def create() {
        respond new Vendors(params)
    }

    @Transactional
    def save(Vendors vendors) {
        if (vendors == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (vendors.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond vendors.errors, view:'create'
            return
        }

        vendors.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendors.label', default: 'Vendors'), vendors.id])
                redirect vendors
            }
            '*' { respond vendors, [status: CREATED] }
        }
    }

    def edit(Vendors vendors) {
        respond vendors
    }

    @Transactional
    def update(Vendors vendors) {
        if (vendors == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (vendors.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond vendors.errors, view:'edit'
            return
        }

        vendors.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendors.label', default: 'Vendors'), vendors.id])
                redirect vendors
            }
            '*'{ respond vendors, [status: OK] }
        }
    }

    @Transactional
    def delete(Vendors vendors) {

        if (vendors == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        vendors.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendors.label', default: 'Vendors'), vendors.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendors.label', default: 'Vendors'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
