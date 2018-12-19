package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TreeWellnessController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TreeWellness.list(params), model:[treeWellnessCount: TreeWellness.count()]
    }

    def show(TreeWellness treeWellness) {
        respond treeWellness
    }

    def create() {
        respond new TreeWellness(params)
    }

    @Transactional
    def save(TreeWellness treeWellness) {
        if (treeWellness == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (treeWellness.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond treeWellness.errors, view:'create'
            return
        }

        treeWellness.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'treeWellness.label', default: 'TreeWellness'), treeWellness.id])
                redirect treeWellness
            }
            '*' { respond treeWellness, [status: CREATED] }
        }
    }

    def edit(TreeWellness treeWellness) {
        respond treeWellness
    }

    @Transactional
    def update(TreeWellness treeWellness) {
        if (treeWellness == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (treeWellness.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond treeWellness.errors, view:'edit'
            return
        }

        treeWellness.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'treeWellness.label', default: 'TreeWellness'), treeWellness.id])
                redirect treeWellness
            }
            '*'{ respond treeWellness, [status: OK] }
        }
    }

    @Transactional
    def delete(TreeWellness treeWellness) {

        if (treeWellness == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        treeWellness.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'treeWellness.label', default: 'TreeWellness'), treeWellness.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'treeWellness.label', default: 'TreeWellness'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
