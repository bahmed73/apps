package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

//@Transactional(readOnly = true)
@Secured('ROLE_ADMIN')
class StudentController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Student.list(params), model:[studentCount: Student.count()]
    }

    def show(Student student) {
        respond student
    }

    def create() {
        respond new Student(params)
    }

    @Transactional
    def save(Student student) {
        if (student == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (student.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond student.errors, view:'create'
            return
        }

        student.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'student.label', default: 'Student'), student.id])
                redirect student
            }
            '*' { respond student, [status: CREATED] }
        }
    }

    def edit(Student student) {
        respond student
    }

    @Transactional
    def update(Student student) {
        if (student == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (student.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond student.errors, view:'edit'
            return
        }

        student.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'student.label', default: 'Student'), student.id])
                redirect student
            }
            '*'{ respond student, [status: OK] }
        }
    }

    @Transactional
    def delete(Student student) {

        if (student == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        student.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'student.label', default: 'Student'), student.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'student.label', default: 'Student'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
