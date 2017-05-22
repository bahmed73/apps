package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
//import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class AppRefererController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond AppReferer.list(params), model:[appRefererCount: AppReferer.count()]
    }

    def show(AppReferer appReferer) {
        respond appReferer
    }

    def create() {
        respond new AppReferer(params)
    }

    @Transactional
    def save(AppReferer appReferer) {
        if (appReferer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (appReferer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond appReferer.errors, view:'create'
            return
        }

        appReferer.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'appReferer.label', default: 'AppReferer'), appReferer.id])
                redirect appReferer
            }
            '*' { respond appReferer, [status: CREATED] }
        }
    }

    def edit(AppReferer appReferer) {
        respond appReferer
    }

    @Transactional
    def update(AppReferer appReferer) {
        if (appReferer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (appReferer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond appReferer.errors, view:'edit'
            return
        }

        appReferer.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'appReferer.label', default: 'AppReferer'), appReferer.id])
                redirect appReferer
            }
            '*'{ respond appReferer, [status: OK] }
        }
    }

    @Transactional
    def delete(AppReferer appReferer) {

        if (appReferer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        appReferer.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'appReferer.label', default: 'AppReferer'), appReferer.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'appReferer.label', default: 'AppReferer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
