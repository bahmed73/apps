package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class TargetInventoryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TargetInventory.list(params), model:[targetInventoryCount: TargetInventory.count()]
    }

    def show(TargetInventory targetInventory) {
        respond targetInventory
    }

    def create() {
        respond new TargetInventory(params)
    }

    @Transactional
    def save(TargetInventory targetInventory) {
        if (targetInventory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (targetInventory.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond targetInventory.errors, view:'create'
            return
        }

        targetInventory.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'targetInventory.label', default: 'TargetInventory'), targetInventory.id])
                redirect targetInventory
            }
            '*' { respond targetInventory, [status: CREATED] }
        }
    }

    def edit(TargetInventory targetInventory) {
        respond targetInventory
    }

    @Transactional
    def update(TargetInventory targetInventory) {
        if (targetInventory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (targetInventory.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond targetInventory.errors, view:'edit'
            return
        }

        targetInventory.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'targetInventory.label', default: 'TargetInventory'), targetInventory.id])
                redirect targetInventory
            }
            '*'{ respond targetInventory, [status: OK] }
        }
    }

    @Transactional
    def delete(TargetInventory targetInventory) {

        if (targetInventory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        targetInventory.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'targetInventory.label', default: 'TargetInventory'), targetInventory.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'targetInventory.label', default: 'TargetInventory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
