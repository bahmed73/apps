package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class InsectController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Insect.list(params), model:[insectCount: Insect.count()]
    }

    def show(Insect insect) {
        respond insect
    }

    def create() {
        respond new Insect(params)
    }

    @Transactional
    def save(Insect insect) {
        if (insect == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (insect.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond insect.errors, view:'create'
            return
        }

        insect.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'insect.label', default: 'Insect'), insect.id])
                redirect insect
            }
            '*' { respond insect, [status: CREATED] }
        }
    }

    def edit(Insect insect) {
        respond insect
    }

    @Transactional
    def update(Insect insect) {
        if (insect == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (insect.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond insect.errors, view:'edit'
            return
        }

        insect.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'insect.label', default: 'Insect'), insect.id])
                redirect insect
            }
            '*'{ respond insect, [status: OK] }
        }
    }

    @Transactional
    def delete(Insect insect) {

        if (insect == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        insect.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'insect.label', default: 'Insect'), insect.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'insect.label', default: 'Insect'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
