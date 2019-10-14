package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class TasksController {

	def springSecurityService
	def appsService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	static fProd = "/opt/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		
		def user = springSecurityService.currentUser
		
		if (user != null) {
			def tasksList = Tasks.findAllByUser(user)
			respond tasksList
		} else {
			def tasksList = Tasks.findAll()
			respond tasksList
		}
		
        respond Tasks.list(params), model:[tasksCount: Tasks.count()]
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(Tasks tasks) {
        respond tasks
    }

    def create() {
        respond new Tasks(params)
    }

    @Transactional
    def save(Tasks tasks) {
        if (tasks == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tasks.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tasks.errors, view:'create'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\TASKS_"+tasks.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadTasksPhoto(file, tasks)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/TASKS_"+tasks.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadTasksPhoto(file, tasks)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/TASKS_"+tasks.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadTasksPhoto(file, tasks)
						break
				}

			}
			else {
			   log.info "file is empty"
			}
		} catch (Exception e) {
				e.printStackTrace( )
				log.info "caught exception: " + e.getMessage()
				log.info "caught exception: " + e
		}
		
        tasks.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tasks.label', default: 'Tasks'), tasks.id])
                redirect tasks
            }
            '*' { respond tasks, [status: CREATED] }
        }
    }

    def edit(Tasks tasks) {
        respond tasks
    }

    @Transactional
    def update(Tasks tasks) {
        if (tasks == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tasks.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tasks.errors, view:'edit'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\TASKS_"+tasks.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadTasksPhoto(file, tasks)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/TASKS_"+tasks.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadTasksPhoto(file, tasks)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/TASKS_"+tasks.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadTasksPhoto(file, tasks)
						break
				}

			}
			else {
			   log.info "file is empty"
			}
		} catch (Exception e) {
				e.printStackTrace( )
				log.info "caught exception: " + e.getMessage()
				log.info "caught exception: " + e
		}
		
        tasks.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tasks.label', default: 'Tasks'), tasks.id])
                redirect tasks
            }
            '*'{ respond tasks, [status: OK] }
        }
    }

    @Transactional
    def delete(Tasks tasks) {

        if (tasks == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        tasks.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tasks.label', default: 'Tasks'), tasks.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tasks.label', default: 'Tasks'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
