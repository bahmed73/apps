package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class DistributorController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Distributor.list(params), model:[distributorCount: Distributor.count()]
    }

    def show(Distributor distributor) {
        respond distributor
    }

    def create() {
        respond new Distributor(params)
    }

    @Transactional
    def save(Distributor distributor) {
        if (distributor == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (distributor.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond distributor.errors, view:'create'
            return
        }

        distributor.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'distributor.label', default: 'Distributor'), distributor.id])
                redirect distributor
            }
            '*' { respond distributor, [status: CREATED] }
        }
    }

    def edit(Distributor distributor) {
        respond distributor
    }

    @Transactional
    def update(Distributor distributor) {
        if (distributor == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (distributor.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond distributor.errors, view:'edit'
            return
        }

        distributor.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'distributor.label', default: 'Distributor'), distributor.id])
                redirect distributor
            }
            '*'{ respond distributor, [status: OK] }
        }
    }

    @Transactional
    def delete(Distributor distributor) {

        if (distributor == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        distributor.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'distributor.label', default: 'Distributor'), distributor.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'distributor.label', default: 'Distributor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
