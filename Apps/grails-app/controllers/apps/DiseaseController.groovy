package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class DiseaseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Disease.list(params), model:[diseaseCount: Disease.count()]
    }

    def show(Disease disease) {
        respond disease
    }

    def create() {
        respond new Disease(params)
    }

    @Transactional
    def save(Disease disease) {
        if (disease == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (disease.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond disease.errors, view:'create'
            return
        }

        disease.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'disease.label', default: 'Disease'), disease.id])
                redirect disease
            }
            '*' { respond disease, [status: CREATED] }
        }
    }

    def edit(Disease disease) {
        respond disease
    }

    @Transactional
    def update(Disease disease) {
        if (disease == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (disease.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond disease.errors, view:'edit'
            return
        }

        disease.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'disease.label', default: 'Disease'), disease.id])
                redirect disease
            }
            '*'{ respond disease, [status: OK] }
        }
    }

    @Transactional
    def delete(Disease disease) {

        if (disease == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        disease.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'disease.label', default: 'Disease'), disease.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'disease.label', default: 'Disease'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
