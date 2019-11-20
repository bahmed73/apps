package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
import com.jameskleeh.excel.ExcelBuilder

@Secured('ROLE_ADMIN')
class CustomersController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Customers.list(params), model:[customersCount: Customers.count()]
    }

	def export() {
		System.out.println("inside export")
		def filename = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images\\test.xlsx"
		File file = new File(filename)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def customersList = Customers.findAllByUser(user)
		
		ExcelBuilder.output(new FileOutputStream(file)) {
			sheet {
				if (customersList!=null && !customersList.isEmpty()) {
					for (int i=0; i<customersList.size(); i++) {
						row(customersList.get(i).name, customersList.get(i).address, customersList.get(i).phone)
					}
				} else {
					row("china", "address", "phone")
					row("china", "address", "phone")
				}
			}
		}
		
		//render (file: new File(result), fileName: "TemplateSQL.met", contentType: "text/met")
		
		response.setContentType("application/octet-stream")
		response.setHeader("Content-disposition", "attachment; filename=\"" + filename + "\"")
		response.outputStream << file.newInputStream()
		return
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(Customers customers) {
        respond customers
    }

    def create() {
        respond new Customers(params)
    }

    @Transactional
    def save(Customers customers) {
        if (customers == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customers.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customers.errors, view:'create'
            return
        }

        customers.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customers.label', default: 'Customers'), customers.id])
                redirect customers
            }
            '*' { respond customers, [status: CREATED] }
        }
    }

    def edit(Customers customers) {
        respond customers
    }

    @Transactional
    def update(Customers customers) {
        if (customers == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (customers.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond customers.errors, view:'edit'
            return
        }

        customers.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customers.label', default: 'Customers'), customers.id])
                redirect customers
            }
            '*'{ respond customers, [status: OK] }
        }
    }

    @Transactional
    def delete(Customers customers) {

        if (customers == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        customers.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customers.label', default: 'Customers'), customers.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customers.label', default: 'Customers'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
