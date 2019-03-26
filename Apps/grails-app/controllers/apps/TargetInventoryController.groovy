package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
import com.jameskleeh.excel.ExcelBuilder

@Secured('ROLE_ADMIN')
class TargetInventoryController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TargetInventory.list(params), model:[targetInventoryCount: TargetInventory.count()]
    }
	
	def export() {
		System.out.println("inside export")
		def filename = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images\\test.xlsx"
		File file = new File(filename)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def targetInventoryList = TargetInventory.findAllByUser(user)
		
		ExcelBuilder.output(new FileOutputStream(file)) {
			sheet {
				if (targetInventoryList!=null && !targetInventoryList.isEmpty()) {
					for (int i=0; i<targetInventoryList.size(); i++) {
						row(targetInventoryList.get(i).name, targetInventoryList.get(i).beginTime.toString(), targetInventoryList.get(i).endTime.toString(), targetInventoryList.get(i).quantity, targetInventoryList.get(i).price)
					}
				} else {
					row("china", "beginTime", "endTime", 5, "\$5")
					row("china", "beginTime", "endTime", 5, "\$5")
				}
			}
		}
		
		//render (file: new File(result), fileName: "TemplateSQL.met", contentType: "text/met")
		
		response.setContentType("application/octet-stream")
		response.setHeader("Content-disposition", "attachment; filename=\"" + filename + "\"")
		response.outputStream << file.newInputStream()
		return
	}

    def show(TargetInventory targetInventory) {
        respond targetInventory
    }

    def create() {
        respond new TargetInventory(params)
    }

    @Transactional
    def save(TargetInventory targetInventory) {
        if (targetInventory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (targetInventory.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond targetInventory.errors, view:'create'
            return
        }

        targetInventory.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'targetInventory.label', default: 'TargetInventory'), targetInventory.id])
                redirect targetInventory
            }
            '*' { respond targetInventory, [status: CREATED] }
        }
    }

    def edit(TargetInventory targetInventory) {
        respond targetInventory
    }

    @Transactional
    def update(TargetInventory targetInventory) {
        if (targetInventory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (targetInventory.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond targetInventory.errors, view:'edit'
            return
        }

        targetInventory.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'targetInventory.label', default: 'TargetInventory'), targetInventory.id])
                redirect targetInventory
            }
            '*'{ respond targetInventory, [status: OK] }
        }
    }

    @Transactional
    def delete(TargetInventory targetInventory) {

        if (targetInventory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        targetInventory.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'targetInventory.label', default: 'TargetInventory'), targetInventory.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'targetInventory.label', default: 'TargetInventory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
