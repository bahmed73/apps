package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CustomerFeedbackController {

    def springSecurityService
	def appsService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	static fProd = "/opt/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"


	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		
		def user = springSecurityService.currentUser
		
		if (user != null) {
			def customerFeedbackList = CustomerFeedback.findAllByUser(user)
			respond customerFeedbackList
		} else {
			def customerFeedbackList = CustomerFeedback.findAll()
			respond customerFeedbackList
		}
		
        //respond CustomerFeedback.list(params), model:[customerFeedbackCount: CustomerFeedback.count()]
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(CustomerFeedback customerFeedback) {
        respond customerFeedback
    }

    def create() {
        respond new CustomerFeedback(params)
    }

    @Transactional
    def save(CustomerFeedback customerFeedback) {
        if (customerFeedback == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerFeedback.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerFeedback.errors, view:'create'
            return
        }

        customerFeedback.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerFeedback.label', default: 'CustomerFeedback'), customerFeedback.id])
                redirect customerFeedback
            }
            '*' { respond customerFeedback, [status: CREATED] }
        }
    }

    def edit(CustomerFeedback customerFeedback) {
        respond customerFeedback
    }

    @Transactional
    def update(CustomerFeedback customerFeedback) {
        if (customerFeedback == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerFeedback.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerFeedback.errors, view:'edit'
            return
        }

        customerFeedback.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerFeedback.label', default: 'CustomerFeedback'), customerFeedback.id])
                redirect customerFeedback
            }
            '*'{ respond customerFeedback, [status: OK] }
        }
    }

    @Transactional
    def delete(CustomerFeedback customerFeedback) {

        if (customerFeedback == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        customerFeedback.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerFeedback.label', default: 'CustomerFeedback'), customerFeedback.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerFeedback.label', default: 'CustomerFeedback'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
