package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

//@Transactional(readOnly = true)
@Secured('ROLE_ADMIN')
class TeacherController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Teacher.list(params), model:[teacherCount: Teacher.count()]
    }

    def show(Teacher teacher) {
        respond teacher
    }

    def create() {
        respond new Teacher(params)
    }

    @Transactional
    def save(Teacher teacher) {
        if (teacher == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (teacher.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond teacher.errors, view:'create'
            return
        }

        teacher.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'teacher.label', default: 'Teacher'), teacher.id])
                redirect teacher
            }
            '*' { respond teacher, [status: CREATED] }
        }
    }

    def edit(Teacher teacher) {
        respond teacher
    }

    @Transactional
    def update(Teacher teacher) {
        if (teacher == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (teacher.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond teacher.errors, view:'edit'
            return
        }

        teacher.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'teacher.label', default: 'Teacher'), teacher.id])
                redirect teacher
            }
            '*'{ respond teacher, [status: OK] }
        }
    }

    @Transactional
    def delete(Teacher teacher) {

        if (teacher == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        teacher.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'teacher.label', default: 'Teacher'), teacher.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'teacher.label', default: 'Teacher'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
