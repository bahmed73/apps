package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class SeasonCatalogController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SeasonCatalog.list(params), model:[seasonCatalogCount: SeasonCatalog.count()]
    }

    def show(SeasonCatalog seasonCatalog) {
        respond seasonCatalog
    }

    def create() {
        respond new SeasonCatalog(params)
    }

    @Transactional
    def save(SeasonCatalog seasonCatalog) {
        if (seasonCatalog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (seasonCatalog.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond seasonCatalog.errors, view:'create'
            return
        }

        seasonCatalog.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'seasonCatalog.label', default: 'SeasonCatalog'), seasonCatalog.id])
                redirect seasonCatalog
            }
            '*' { respond seasonCatalog, [status: CREATED] }
        }
    }

    def edit(SeasonCatalog seasonCatalog) {
        respond seasonCatalog
    }

    @Transactional
    def update(SeasonCatalog seasonCatalog) {
        if (seasonCatalog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (seasonCatalog.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond seasonCatalog.errors, view:'edit'
            return
        }

        seasonCatalog.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'seasonCatalog.label', default: 'SeasonCatalog'), seasonCatalog.id])
                redirect seasonCatalog
            }
            '*'{ respond seasonCatalog, [status: OK] }
        }
    }

    @Transactional
    def delete(SeasonCatalog seasonCatalog) {

        if (seasonCatalog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        seasonCatalog.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'seasonCatalog.label', default: 'SeasonCatalog'), seasonCatalog.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'seasonCatalog.label', default: 'SeasonCatalog'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
