package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured
import com.jameskleeh.excel.ExcelBuilder

@Secured('ROLE_ADMIN')
class GoalSeekController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond GoalSeek.list(params), model:[goalSeekCount: GoalSeek.count()]
    }

	def export() {
		System.out.println("inside export")
		def filename = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images\\test.xlsx"
		File file = new File(filename)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def goalSeekList = GoalSeek.findAllByUser(user)
		
		ExcelBuilder.output(new FileOutputStream(file)) {
			sheet {
				if (goalSeekList!=null && !goalSeekList.isEmpty()) {
					for (int i=0; i<goalSeekList.size(); i++) {
						row(goalSeekList.get(i).name, goalSeekList.get(i).beginTime.toString(), goalSeekList.get(i).endTime.toString(), goalSeekList.get(i).beginQuantity, goalSeekList.get(i).endQuantity, goalSeekList.get(i).beginPrice, goalSeekList.get(i).endPrice)
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
	
    def show(GoalSeek goalSeek) {
        respond goalSeek
    }

    def create() {
        respond new GoalSeek(params)
    }

    @Transactional
    def save(GoalSeek goalSeek) {
        if (goalSeek == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (goalSeek.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond goalSeek.errors, view:'create'
            return
        }

        goalSeek.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'goalSeek.label', default: 'GoalSeek'), goalSeek.id])
                redirect goalSeek
            }
            '*' { respond goalSeek, [status: CREATED] }
        }
    }

    def edit(GoalSeek goalSeek) {
        respond goalSeek
    }

    @Transactional
    def update(GoalSeek goalSeek) {
        if (goalSeek == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (goalSeek.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond goalSeek.errors, view:'edit'
            return
        }

        goalSeek.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'goalSeek.label', default: 'GoalSeek'), goalSeek.id])
                redirect goalSeek
            }
            '*'{ respond goalSeek, [status: OK] }
        }
    }

    @Transactional
    def delete(GoalSeek goalSeek) {

        if (goalSeek == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        goalSeek.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'goalSeek.label', default: 'GoalSeek'), goalSeek.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'goalSeek.label', default: 'GoalSeek'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
