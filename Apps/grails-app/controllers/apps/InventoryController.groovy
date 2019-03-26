package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
import com.jameskleeh.excel.ExcelBuilder

@Secured('ROLE_ADMIN')
class InventoryController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Inventory.list(params), model:[inventoryCount: Inventory.count()]
    }

	def export() {
		System.out.println("inside export")
		def filename = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images\\test.xlsx"
		File file = new File(filename)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def inventoryList = Inventory.findAllByUser(user)
		
		ExcelBuilder.output(new FileOutputStream(file)) {
			sheet {
				if (inventoryList!=null && !inventoryList.isEmpty()) {
					for (int i=0; i<inventoryList.size(); i++) {
						row(inventoryList.get(i).name, inventoryList.get(i).products.name, inventoryList.get(i).quantity, inventoryList.get(i).price, inventoryList.get(i).description)
					}
				} else {
					row("china", "india", 5, "\$5", "description")
					row("russia", "pakistan", 5, "\$5", "description")
				}
			}
		}
		
		//render (file: new File(result), fileName: "TemplateSQL.met", contentType: "text/met")
		
		response.setContentType("application/octet-stream")
		response.setHeader("Content-disposition", "attachment; filename=\"" + filename + "\"")
		response.outputStream << file.newInputStream()
		return
	}
	
    def show(Inventory inventory) {
        respond inventory
    }

    def create() {
        respond new Inventory(params)
    }

    @Transactional
    def save(Inventory inventory) {
        if (inventory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (inventory.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond inventory.errors, view:'create'
            return
        }

        inventory.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'inventory.label', default: 'Inventory'), inventory.id])
                redirect inventory
            }
            '*' { respond inventory, [status: CREATED] }
        }
    }

    def edit(Inventory inventory) {
        respond inventory
    }

    @Transactional
    def update(Inventory inventory) {
        if (inventory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (inventory.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond inventory.errors, view:'edit'
            return
        }

        inventory.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'inventory.label', default: 'Inventory'), inventory.id])
                redirect inventory
            }
            '*'{ respond inventory, [status: OK] }
        }
    }

    @Transactional
    def delete(Inventory inventory) {

        if (inventory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        inventory.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'inventory.label', default: 'Inventory'), inventory.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'inventory.label', default: 'Inventory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
