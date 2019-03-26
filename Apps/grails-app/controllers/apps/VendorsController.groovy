package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
import com.jameskleeh.excel.ExcelBuilder

@Secured('ROLE_ADMIN')
class VendorsController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Vendors.list(params), model:[vendorsCount: Vendors.count()]
    }

	def export() {
		System.out.println("inside export")
		def filename = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images\\test.xlsx"
		File file = new File(filename)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def vendorsList = Vendors.findAllByUser(user)
		
		ExcelBuilder.output(new FileOutputStream(file)) {
			sheet {
				if (vendorsList!=null && !vendorsList.isEmpty()) {
					for (int i=0; i<vendorsList.size(); i++) {
						row(vendorsList.get(i).name, vendorsList.get(i).address, vendorsList.get(i).phone, vendorsList.get(i).beginTime.toString(), vendorsList.get(i).endTime.toString(), vendorsList.get(i).beginQuantity, vendorsList.get(i).endQuantity, vendorsList.get(i).beginPrice, vendorsList.get(i).endPrice)
					}
				} else {
					row("china", "address", "phone", "beginTime", "endTime", 5, 6, "\$5", "\$5")
					row("china", "address", "phone", "beginTime", "endTime", 5, 6, "\$5", "\$5")
				}
			}
		}
		
		//render (file: new File(result), fileName: "TemplateSQL.met", contentType: "text/met")
		
		response.setContentType("application/octet-stream")
		response.setHeader("Content-disposition", "attachment; filename=\"" + filename + "\"")
		response.outputStream << file.newInputStream()
		return
	}
	
    def show(Vendors vendors) {
        respond vendors
    }

    def create() {
        respond new Vendors(params)
    }

    @Transactional
    def save(Vendors vendors) {
        if (vendors == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (vendors.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond vendors.errors, view:'create'
            return
        }

        vendors.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendors.label', default: 'Vendors'), vendors.id])
                redirect vendors
            }
            '*' { respond vendors, [status: CREATED] }
        }
    }

    def edit(Vendors vendors) {
        respond vendors
    }

    @Transactional
    def update(Vendors vendors) {
        if (vendors == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (vendors.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond vendors.errors, view:'edit'
            return
        }

        vendors.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendors.label', default: 'Vendors'), vendors.id])
                redirect vendors
            }
            '*'{ respond vendors, [status: OK] }
        }
    }

    @Transactional
    def delete(Vendors vendors) {

        if (vendors == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        vendors.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendors.label', default: 'Vendors'), vendors.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendors.label', default: 'Vendors'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
