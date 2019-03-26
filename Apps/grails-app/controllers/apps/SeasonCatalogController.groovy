package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
import com.jameskleeh.excel.ExcelBuilder

@Secured('ROLE_ADMIN')
class SeasonCatalogController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SeasonCatalog.list(params), model:[seasonCatalogCount: SeasonCatalog.count()]
    }

	def export() {
		System.out.println("inside export")
		def filename = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images\\test.xlsx"
		File file = new File(filename)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def seasonCatalogList = SeasonCatalog.findAllByUser(user)
		
		ExcelBuilder.output(new FileOutputStream(file)) {
			sheet {
				if (seasonCatalogList!=null && !seasonCatalogList.isEmpty()) {
					for (int i=0; i<seasonCatalogList.size(); i++) {
						row(seasonCatalogList.get(i).name, seasonCatalogList.get(i).beginTime.toString(), seasonCatalogList.get(i).endTime.toString(), seasonCatalogList.get(i).beginQuantity, seasonCatalogList.get(i).endQuantity, seasonCatalogList.get(i).beginPrice, seasonCatalogList.get(i).endPrice)
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
	
    def show(SeasonCatalog seasonCatalog) {
        respond seasonCatalog
    }

    def create() {
        respond new SeasonCatalog(params)
    }

    @Transactional
    def save(SeasonCatalog seasonCatalog) {
        if (seasonCatalog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (seasonCatalog.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond seasonCatalog.errors, view:'create'
            return
        }

        seasonCatalog.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'seasonCatalog.label', default: 'SeasonCatalog'), seasonCatalog.id])
                redirect seasonCatalog
            }
            '*' { respond seasonCatalog, [status: CREATED] }
        }
    }

    def edit(SeasonCatalog seasonCatalog) {
        respond seasonCatalog
    }

    @Transactional
    def update(SeasonCatalog seasonCatalog) {
        if (seasonCatalog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (seasonCatalog.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond seasonCatalog.errors, view:'edit'
            return
        }

        seasonCatalog.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'seasonCatalog.label', default: 'SeasonCatalog'), seasonCatalog.id])
                redirect seasonCatalog
            }
            '*'{ respond seasonCatalog, [status: OK] }
        }
    }

    @Transactional
    def delete(SeasonCatalog seasonCatalog) {

        if (seasonCatalog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        seasonCatalog.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'seasonCatalog.label', default: 'SeasonCatalog'), seasonCatalog.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'seasonCatalog.label', default: 'SeasonCatalog'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
