package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PhotoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Photo.list(params), model:[photoCount: Photo.count()]
    }

    def show(Photo photo) {
        respond photo
    }

    def create() {
        respond new Photo(params)
    }

    @Transactional
    def save(Photo photo) {
        if (photo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (photo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond photo.errors, view:'create'
            return
        }

        photo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'photo.label', default: 'Photo'), photo.id])
                redirect photo
            }
            '*' { respond photo, [status: CREATED] }
        }
    }

    def edit(Photo photo) {
        respond photo
    }

    @Transactional
    def update(Photo photo) {
        if (photo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (photo.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond photo.errors, view:'edit'
            return
        }

        photo.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'photo.label', default: 'Photo'), photo.id])
                redirect photo
            }
            '*'{ respond photo, [status: OK] }
        }
    }

    @Transactional
    def delete(Photo photo) {

        if (photo == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        photo.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'photo.label', default: 'Photo'), photo.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'photo.label', default: 'Photo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
