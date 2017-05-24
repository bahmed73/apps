package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
//import grails.plugin.springsecurity.annotation.Secured
import com.jameskleeh.excel.ExcelBuilder

@Secured('ROLE_ADMIN')
class ProductRefererController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def productRefererList = ProductReferer.findAllByUser(user)
		
		respond productRefererList
	}

	def export() {
		System.out.println("inside export")
		def filename = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images\\test.xlsx"
		File file = new File(filename)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def productRefererList = ProductReferer.findAllByUser(user)
		
		ExcelBuilder.output(new FileOutputStream(file)) {
			sheet {
				if (productRefererList!=null && !productRefererList.isEmpty()) {
					for (int i=0; i<productRefererList.size(); i++) {
						row(productRefererList.get(i).referer, productRefererList.get(i).products.name)
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
	
    def show(ProductReferer productReferer) {
        respond productReferer
    }

    def create() {
        respond new ProductReferer(params)
    }

    @Transactional
    def save(ProductReferer productReferer) {
        if (productReferer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (productReferer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond productReferer.errors, view:'create'
            return
        }

        productReferer.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'productReferer.label', default: 'ProductReferer'), productReferer.id])
                redirect productReferer
            }
            '*' { respond productReferer, [status: CREATED] }
        }
    }

    def edit(ProductReferer productReferer) {
        respond productReferer
    }

    @Transactional
    def update(ProductReferer productReferer) {
        if (productReferer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (productReferer.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond productReferer.errors, view:'edit'
            return
        }

        productReferer.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'productReferer.label', default: 'ProductReferer'), productReferer.id])
                redirect productReferer
            }
            '*'{ respond productReferer, [status: OK] }
        }
    }

    @Transactional
    def delete(ProductReferer productReferer) {

        if (productReferer == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        productReferer.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'productReferer.label', default: 'ProductReferer'), productReferer.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'productReferer.label', default: 'ProductReferer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
