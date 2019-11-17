package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class MeetingController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
        params.max = Math.min(max ?: 100, 200)
        respond Meeting.list(params), model:[meetingCount: Meeting.count()]
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(Meeting meeting) {
        respond meeting
    }

    def create() {
        respond new Meeting(params)
    }

    @Transactional
    def save(Meeting meeting) {
        if (meeting == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (meeting.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond meeting.errors, view:'create'
            return
        }

        meeting.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'meeting.label', default: 'Meeting'), meeting.id])
                redirect meeting
            }
            '*' { respond meeting, [status: CREATED] }
        }
    }

    def edit(Meeting meeting) {
        respond meeting
    }

    @Transactional
    def update(Meeting meeting) {
        if (meeting == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (meeting.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond meeting.errors, view:'edit'
            return
        }

        meeting.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'meeting.label', default: 'Meeting'), meeting.id])
                redirect meeting
            }
            '*'{ respond meeting, [status: OK] }
        }
    }

    @Transactional
    def delete(Meeting meeting) {

        if (meeting == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        meeting.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'meeting.label', default: 'Meeting'), meeting.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'meeting.label', default: 'Meeting'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
