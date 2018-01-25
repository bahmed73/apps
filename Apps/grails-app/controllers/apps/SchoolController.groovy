package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

//@Transactional(readOnly = true)
@Secured('ROLE_ADMIN')
class SchoolController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond School.list(params), model:[schoolCount: School.count()]
    }

    def show(School school) {
        respond school
    }

    def create() {
        respond new School(params)
    }

    @Transactional
    def save(School school) {
        if (school == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (school.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond school.errors, view:'create'
            return
        }

        school.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'school.label', default: 'School'), school.id])
                redirect school
            }
            '*' { respond school, [status: CREATED] }
        }
    }

    def edit(School school) {
        respond school
    }

    @Transactional
    def update(School school) {
        if (school == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (school.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond school.errors, view:'edit'
            return
        }

        school.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'school.label', default: 'School'), school.id])
                redirect school
            }
            '*'{ respond school, [status: OK] }
        }
    }

    @Transactional
    def delete(School school) {

        if (school == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        school.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'school.label', default: 'School'), school.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'school.label', default: 'School'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
