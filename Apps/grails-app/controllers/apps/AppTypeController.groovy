package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AppTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond AppType.list(params), model:[appTypeCount: AppType.count()]
    }

    def show(AppType appType) {
        respond appType
    }

    def create() {
        respond new AppType(params)
    }

    @Transactional
    def save(AppType appType) {
        if (appType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (appType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond appType.errors, view:'create'
            return
        }

        appType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'appType.label', default: 'AppType'), appType.id])
                redirect appType
            }
            '*' { respond appType, [status: CREATED] }
        }
    }

    def edit(AppType appType) {
        respond appType
    }

    @Transactional
    def update(AppType appType) {
        if (appType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (appType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond appType.errors, view:'edit'
            return
        }

        appType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'appType.label', default: 'AppType'), appType.id])
                redirect appType
            }
            '*'{ respond appType, [status: OK] }
        }
    }

    @Transactional
    def delete(AppType appType) {

        if (appType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        appType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'appType.label', default: 'AppType'), appType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'appType.label', default: 'AppType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
