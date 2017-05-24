package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
import com.jameskleeh.excel.ExcelBuilder

@Secured('ROLE_ADMIN')
class ProductViewController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def productViewList = ProductView.findAllByUser(user)
		
        respond productViewList
    }

	def export() {
		System.out.println("inside export")
		def filename = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images\\test.xlsx"
		File file = new File(filename)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def productViewList = ProductView.findAllByUser(user)
		
		ExcelBuilder.output(new FileOutputStream(file)) {
			sheet {
				if (productViewList!=null && !productViewList.isEmpty()) {
					for (int i=0; i<productViewList.size(); i++) {
						row(productViewList.get(i).ip, productViewList.get(i).products.name)
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
	
    def show(ProductView productView) {
        respond productView
    }

    def create() {
        respond new ProductView(params)
    }

    @Transactional
    def save(ProductView productView) {
        if (productView == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (productView.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond productView.errors, view:'create'
            return
        }

        productView.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'productView.label', default: 'ProductView'), productView.id])
                redirect productView
            }
            '*' { respond productView, [status: CREATED] }
        }
    }

    def edit(ProductView productView) {
        respond productView
    }

    @Transactional
    def update(ProductView productView) {
        if (productView == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (productView.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond productView.errors, view:'edit'
            return
        }

        productView.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'productView.label', default: 'ProductView'), productView.id])
                redirect productView
            }
            '*'{ respond productView, [status: OK] }
        }
    }

    @Transactional
    def delete(ProductView productView) {

        if (productView == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        productView.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'productView.label', default: 'ProductView'), productView.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'productView.label', default: 'ProductView'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
