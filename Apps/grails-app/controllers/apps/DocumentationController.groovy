package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class DocumentationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
        params.max = Math.min(max ?: 100, 200)
        respond Documentation.list(params), model:[documentationCount: Documentation.count()]
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(Documentation documentation) {
        respond documentation
    }

    def create() {
        respond new Documentation(params)
    }

    @Transactional
    def save(Documentation documentation) {
        if (documentation == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (documentation.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond documentation.errors, view:'create'
            return
        }

        documentation.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'documentation.label', default: 'Documentation'), documentation.id])
                redirect documentation
            }
            '*' { respond documentation, [status: CREATED] }
        }
    }

    def edit(Documentation documentation) {
        respond documentation
    }

    @Transactional
    def update(Documentation documentation) {
        if (documentation == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (documentation.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond documentation.errors, view:'edit'
            return
        }

        documentation.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'documentation.label', default: 'Documentation'), documentation.id])
                redirect documentation
            }
            '*'{ respond documentation, [status: OK] }
        }
    }

    @Transactional
    def delete(Documentation documentation) {

        if (documentation == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        documentation.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'documentation.label', default: 'Documentation'), documentation.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentation.label', default: 'Documentation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
