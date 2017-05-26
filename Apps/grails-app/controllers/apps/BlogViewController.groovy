package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
//import grails.plugin.springsecurity.annotation.Secured
import com.jameskleeh.excel.ExcelBuilder

@Secured('ROLE_ADMIN')
class BlogViewController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def blogViewList = BlogView.findAllByUser(user)
		
        respond blogViewList
    }

	def export() {
		System.out.println("inside export")
		def filename = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images\\test.xlsx"
		File file = new File(filename)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def blogViewList = BlogView.findAllByUser(user)
		
		ExcelBuilder.output(new FileOutputStream(file)) {
			sheet {
				if (blogViewList!=null && !blogViewList.isEmpty()) {
					for (int i=0; i<blogViewList.size(); i++) {
						row(blogViewList.get(i).ip, blogViewList.get(i).blog.name)
					}
				} else {
					row("china", "india")
					row("russia", "pakistan")
				}
			}
		}
		
		//render (file: new File(result), fileName: "TemplateSQL.met", contentType: "text/met")
		
		response.setContentType("application/octet-stream")
		response.setHeader("Content-disposition", "attachment; filename=\"" + filename + "\"")
		response.outputStream << file.newInputStream()
		return
	}
	
    def show(BlogView blogView) {
        respond blogView
    }

    def create() {
        respond new BlogView(params)
    }

    @Transactional
    def save(BlogView blogView) {
        if (blogView == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (blogView.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond blogView.errors, view:'create'
            return
        }

        blogView.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'blogView.label', default: 'BlogView'), blogView.id])
                redirect blogView
            }
            '*' { respond blogView, [status: CREATED] }
        }
    }

    def edit(BlogView blogView) {
        respond blogView
    }

    @Transactional
    def update(BlogView blogView) {
        if (blogView == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (blogView.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond blogView.errors, view:'edit'
            return
        }

        blogView.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'blogView.label', default: 'BlogView'), blogView.id])
                redirect blogView
            }
            '*'{ respond blogView, [status: OK] }
        }
    }

    @Transactional
    def delete(BlogView blogView) {

        if (blogView == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        blogView.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'blogView.label', default: 'BlogView'), blogView.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'blogView.label', default: 'BlogView'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
