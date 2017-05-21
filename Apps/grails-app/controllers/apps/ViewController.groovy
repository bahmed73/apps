package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
@Secured('ROLE_ADMIN')

class ViewController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond View.list(params), model:[viewCount: View.count()]
    }

    def show(View view) {
        respond view
    }

    def create() {
        respond new View(params)
    }

    @Transactional
    def save(View view) {
        if (view == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (view.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond view.errors, view:'create'
            return
        }

        view.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'view.label', default: 'View'), view.id])
                redirect view
            }
            '*' { respond view, [status: CREATED] }
        }
    }

    def edit(View view) {
        respond view
    }

    @Transactional
    def update(View view) {
        if (view == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (view.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond view.errors, view:'edit'
            return
        }

        view.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'view.label', default: 'View'), view.id])
                redirect view
            }
            '*'{ respond view, [status: OK] }
        }
    }

    @Transactional
    def delete(View view) {

        if (view == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        view.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'view.label', default: 'View'), view.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'view.label', default: 'View'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
