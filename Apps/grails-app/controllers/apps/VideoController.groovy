package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class VideoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Video.list(params), model:[videoCount: Video.count()]
    }

    def show(Video video) {
        respond video
    }

    def create() {
        respond new Video(params)
    }

    @Transactional
    def save(Video video) {
        if (video == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (video.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond video.errors, view:'create'
            return
        }

        video.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'video.label', default: 'Video'), video.id])
                redirect video
            }
            '*' { respond video, [status: CREATED] }
        }
    }

    def edit(Video video) {
        respond video
    }

    @Transactional
    def update(Video video) {
        if (video == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (video.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond video.errors, view:'edit'
            return
        }

        video.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'video.label', default: 'Video'), video.id])
                redirect video
            }
            '*'{ respond video, [status: OK] }
        }
    }

    @Transactional
    def delete(Video video) {

        if (video == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        video.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'video.label', default: 'Video'), video.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'video.label', default: 'Video'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
