package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class SprintController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
        params.max = Math.min(max ?: 100, 200)
        respond Sprint.list(params), model:[sprintCount: Sprint.count()]
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(Sprint sprint) {
        respond sprint
    }

    def create() {
        respond new Sprint(params)
    }

    @Transactional
    def save(Sprint sprint) {
        if (sprint == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (sprint.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond sprint.errors, view:'create'
            return
        }

        sprint.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sprint.label', default: 'Sprint'), sprint.id])
                redirect sprint
            }
            '*' { respond sprint, [status: CREATED] }
        }
    }

    def edit(Sprint sprint) {
        respond sprint
    }

    @Transactional
    def update(Sprint sprint) {
        if (sprint == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (sprint.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond sprint.errors, view:'edit'
            return
        }

        sprint.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sprint.label', default: 'Sprint'), sprint.id])
                redirect sprint
            }
            '*'{ respond sprint, [status: OK] }
        }
    }

    @Transactional
    def delete(Sprint sprint) {

        if (sprint == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        sprint.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sprint.label', default: 'Sprint'), sprint.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sprint.label', default: 'Sprint'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
