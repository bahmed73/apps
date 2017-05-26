package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class BlogController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Blog.list(params), model:[blogCount: Blog.count()]
    }

    def show(Blog blog) {
        respond blog
    }

    def create() {
        respond new Blog(params)
    }

    @Transactional
    def save(Blog blog) {
        if (blog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (blog.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond blog.errors, view:'create'
            return
        }

		def user = springSecurityService.currentUser
		
		System.out.println("username = " + user.username)
		blog.user = user
		
        blog.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'blog.label', default: 'Blog'), blog.id])
                redirect blog
            }
            '*' { respond blog, [status: CREATED] }
        }
    }

    def edit(Blog blog) {
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		if (blog.user == user) {
			respond blog
		} else {
			flash.message ="Access denied."
			redirect action:"index", method:"GET"
			return
		}
    }

    @Transactional
    def update(Blog blog) {
        if (blog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (blog.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond blog.errors, view:'edit'
            return
        }

		def user = springSecurityService.currentUser
		
		System.out.println("username = " + user.username)
		blog.user = user
		
        blog.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'blog.label', default: 'Blog'), blog.id])
                redirect blog
            }
            '*'{ respond blog, [status: OK] }
        }
    }

    @Transactional
    def delete(Blog blog) {

        if (blog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		if (blog.user != user) {
			flash.message ="Access denied."
			redirect action:"index", method:"GET"
			return
		}
		
        blog.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'blog.label', default: 'Blog'), blog.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'blog.label', default: 'Blog'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
