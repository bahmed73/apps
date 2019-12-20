package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CustomerDevelopmentController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
        params.max = Math.min(max ?: 100, 200)
		
		def user = springSecurityService.currentUser
		
		if (user != null) {
			def customerDevelopmentList = CustomerDevelopment.findAllByUser(user)
			respond customerDevelopmentList
		} else {
			def customerDevelopmentList = CustomerDevelopment.findAll()
			respond customerDevelopmentList
		}
		
        //respond CustomerDevelopment.list(params), model:[customerDevelopmentCount: CustomerDevelopment.count()]
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(CustomerDevelopment customerDevelopment) {
        respond customerDevelopment
    }

    def create() {
        respond new CustomerDevelopment(params)
    }

    @Transactional
    def save(CustomerDevelopment customerDevelopment) {
        if (customerDevelopment == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerDevelopment.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerDevelopment.errors, view:'create'
            return
        }

        customerDevelopment.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerDevelopment.label', default: 'CustomerDevelopment'), customerDevelopment.id])
                redirect customerDevelopment
            }
            '*' { respond customerDevelopment, [status: CREATED] }
        }
    }

    def edit(CustomerDevelopment customerDevelopment) {
        respond customerDevelopment
    }

    @Transactional
    def update(CustomerDevelopment customerDevelopment) {
        if (customerDevelopment == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customerDevelopment.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customerDevelopment.errors, view:'edit'
            return
        }

        customerDevelopment.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerDevelopment.label', default: 'CustomerDevelopment'), customerDevelopment.id])
                redirect customerDevelopment
            }
            '*'{ respond customerDevelopment, [status: OK] }
        }
    }

    @Transactional
    def delete(CustomerDevelopment customerDevelopment) {

        if (customerDevelopment == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        customerDevelopment.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerDevelopment.label', default: 'CustomerDevelopment'), customerDevelopment.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerDevelopment.label', default: 'CustomerDevelopment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
