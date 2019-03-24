package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class AllocationForecastController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond AllocationForecast.list(params), model:[allocationForecastCount: AllocationForecast.count()]
    }

    def show(AllocationForecast allocationForecast) {
        respond allocationForecast
    }

    def create() {
        respond new AllocationForecast(params)
    }

    @Transactional
    def save(AllocationForecast allocationForecast) {
        if (allocationForecast == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (allocationForecast.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond allocationForecast.errors, view:'create'
            return
        }

        allocationForecast.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'allocationForecast.label', default: 'AllocationForecast'), allocationForecast.id])
                redirect allocationForecast
            }
            '*' { respond allocationForecast, [status: CREATED] }
        }
    }

    def edit(AllocationForecast allocationForecast) {
        respond allocationForecast
    }

    @Transactional
    def update(AllocationForecast allocationForecast) {
        if (allocationForecast == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (allocationForecast.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond allocationForecast.errors, view:'edit'
            return
        }

        allocationForecast.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'allocationForecast.label', default: 'AllocationForecast'), allocationForecast.id])
                redirect allocationForecast
            }
            '*'{ respond allocationForecast, [status: OK] }
        }
    }

    @Transactional
    def delete(AllocationForecast allocationForecast) {

        if (allocationForecast == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        allocationForecast.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'allocationForecast.label', default: 'AllocationForecast'), allocationForecast.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'allocationForecast.label', default: 'AllocationForecast'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
