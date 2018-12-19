package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ApplicatorController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Applicator.list(params), model:[applicatorCount: Applicator.count()]
    }

    def show(Applicator applicator) {
        respond applicator
    }

    def create() {
        respond new Applicator(params)
    }

    @Transactional
    def save(Applicator applicator) {
        if (applicator == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (applicator.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond applicator.errors, view:'create'
            return
        }

        applicator.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'applicator.label', default: 'Applicator'), applicator.id])
                redirect applicator
            }
            '*' { respond applicator, [status: CREATED] }
        }
    }

    def edit(Applicator applicator) {
        respond applicator
    }

    @Transactional
    def update(Applicator applicator) {
        if (applicator == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (applicator.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond applicator.errors, view:'edit'
            return
        }

        applicator.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'applicator.label', default: 'Applicator'), applicator.id])
                redirect applicator
            }
            '*'{ respond applicator, [status: OK] }
        }
    }

    @Transactional
    def delete(Applicator applicator) {

        if (applicator == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        applicator.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'applicator.label', default: 'Applicator'), applicator.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'applicator.label', default: 'Applicator'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
