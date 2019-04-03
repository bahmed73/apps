package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
@Secured('ROLE_ADMIN')
class UserRoleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UserRole.list(params), model:[userRoleCount: UserRole.count()]
    }

    def show(UserRole userRole) {
        respond userRole
    }

    def create() {
        respond new UserRole(params)
    }

    @Transactional
    def save(UserRole userRole) {
        if (userRole == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (userRole.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond userRole.errors, view:'create'
            return
        }

        userRole.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userRole.label', default: 'UserRole'), userRole.id])
                redirect action:"index", method:"GET"
            }
            '*' { respond userRole, [status: CREATED] }
        }
    }

    def edit(UserRole userRole) {
        respond userRole
    }

    @Transactional
    def update(UserRole userRole) {
        if (userRole == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (userRole.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond userRole.errors, view:'edit'
            return
        }

        userRole.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'userRole.label', default: 'UserRole'), userRole.id])
                redirect userRole
            }
            '*'{ respond userRole, [status: OK] }
        }
    }

    @Transactional
    def delete(UserRole userRole) {

        if (userRole == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        userRole.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'userRole.label', default: 'UserRole'), userRole.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userRole.label', default: 'UserRole'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
