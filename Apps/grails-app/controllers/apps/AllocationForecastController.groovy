package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
import com.jameskleeh.excel.ExcelBuilder

@Secured('ROLE_ADMIN')
class AllocationForecastController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond AllocationForecast.list(params), model:[allocationForecastCount: AllocationForecast.count()]
    }

	def export() {
		System.out.println("inside export")
		def filename = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images\\test.xlsx"
		File file = new File(filename)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def allocationForecastList = AllocationForecast.findAllByUser(user)
		
		ExcelBuilder.output(new FileOutputStream(file)) {
			sheet {
				if (allocationForecastList!=null && !allocationForecastList.isEmpty()) {
					for (int i=0; i<allocationForecastList.size(); i++) {
						row(allocationForecastList.get(i).name, allocationForecastList.get(i).beginTime.toString(), allocationForecastList.get(i).endTime.toString(), allocationForecastList.get(i).beginQuantity, allocationForecastList.get(i).endQuantity, allocationForecastList.get(i).beginPrice, allocationForecastList.get(i).endPrice)
					}
				} else {
					row("china", "beginTime", "endTime", 5, 6, "\$5", "\$5")
					row("china", "beginTime", "endTime", 5, 6, "\$5", "\$5")
				}
			}
		}
		
		//render (file: new File(result), fileName: "TemplateSQL.met", contentType: "text/met")
		
		response.setContentType("application/octet-stream")
		response.setHeader("Content-disposition", "attachment; filename=\"" + filename + "\"")
		response.outputStream << file.newInputStream()
		return
	}
	
    def show(AllocationForecast allocationForecast) {
        respond allocationForecast
    }

    def create() {
        respond new AllocationForecast(params)
    }

    @Transactional
    def save(AllocationForecast allocationForecast) {
        if (allocationForecast == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (allocationForecast.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond allocationForecast.errors, view:'create'
            return
        }

        allocationForecast.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'allocationForecast.label', default: 'AllocationForecast'), allocationForecast.id])
                redirect allocationForecast
            }
            '*' { respond allocationForecast, [status: CREATED] }
        }
    }

    def edit(AllocationForecast allocationForecast) {
        respond allocationForecast
    }

    @Transactional
    def update(AllocationForecast allocationForecast) {
        if (allocationForecast == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (allocationForecast.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond allocationForecast.errors, view:'edit'
            return
        }

        allocationForecast.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'allocationForecast.label', default: 'AllocationForecast'), allocationForecast.id])
                redirect allocationForecast
            }
            '*'{ respond allocationForecast, [status: OK] }
        }
    }

    @Transactional
    def delete(AllocationForecast allocationForecast) {

        if (allocationForecast == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        allocationForecast.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'allocationForecast.label', default: 'AllocationForecast'), allocationForecast.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'allocationForecast.label', default: 'AllocationForecast'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
