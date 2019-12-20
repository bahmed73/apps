package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class BacklogController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
        params.max = Math.min(max ?: 100, 200)
		
		def user = springSecurityService.currentUser
		
		if (user != null) {
			def backlogList = Backlog.findAllByUser(user)
			respond backlogList
		} else {
			def backlogList = Backlog.findAll()
			respond backlogList
		}
		
        //respond Backlog.list(params), model:[backlogCount: Backlog.count()]
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(Backlog backlog) {
        respond backlog
    }

    def create() {
        respond new Backlog(params)
    }

    @Transactional
    def save(Backlog backlog) {
        if (backlog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (backlog.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond backlog.errors, view:'create'
            return
        }

        backlog.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'backlog.label', default: 'Backlog'), backlog.id])
                redirect backlog
            }
            '*' { respond backlog, [status: CREATED] }
        }
    }

    def edit(Backlog backlog) {
        respond backlog
    }

    @Transactional
    def update(Backlog backlog) {
        if (backlog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (backlog.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond backlog.errors, view:'edit'
            return
        }

        backlog.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'backlog.label', default: 'Backlog'), backlog.id])
                redirect backlog
            }
            '*'{ respond backlog, [status: OK] }
        }
    }

    @Transactional
    def delete(Backlog backlog) {

        if (backlog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        backlog.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'backlog.label', default: 'Backlog'), backlog.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'backlog.label', default: 'Backlog'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
