package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
//import grails.plugin.springsecurity.annotation.Secured
import com.jameskleeh.excel.ExcelBuilder

@Secured('ROLE_ADMIN')
class BlogRefererController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def blogRefererList = BlogReferer.findAllByUser(user)
		
        respond blogRefererList
    }

    def show(BlogReferer blogReferer) {
        respond blogReferer
    }

    def create() {
        respond new BlogReferer(params)
    }

    @Transactional
    def save(BlogReferer blogReferer) {
        if (blogReferer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (blogReferer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond blogReferer.errors, view:'create'
            return
        }

        blogReferer.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'blogReferer.label', default: 'BlogReferer'), blogReferer.id])
                redirect blogReferer
            }
            '*' { respond blogReferer, [status: CREATED] }
        }
    }

    def edit(BlogReferer blogReferer) {
        respond blogReferer
    }

    @Transactional
    def update(BlogReferer blogReferer) {
        if (blogReferer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (blogReferer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond blogReferer.errors, view:'edit'
            return
        }

        blogReferer.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'blogReferer.label', default: 'BlogReferer'), blogReferer.id])
                redirect blogReferer
            }
            '*'{ respond blogReferer, [status: OK] }
        }
    }

    @Transactional
    def delete(BlogReferer blogReferer) {

        if (blogReferer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        blogReferer.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'blogReferer.label', default: 'BlogReferer'), blogReferer.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'blogReferer.label', default: 'BlogReferer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
