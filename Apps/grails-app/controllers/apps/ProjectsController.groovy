package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class ProjectsController {

	def springSecurityService
	def appsService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	static fProd = "/opt/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
        params.max = Math.min(max ?: 100, 200)
		
		/*
		def user = springSecurityService.currentUser
		
		if (user != null) {
			def projectsList = Projects.findAllByUser(user)
			respond projectsList
		} else {
			def projectsList = Projects.findAll()
			respond projectsList
		}*/
		
        respond Projects.list(params), model:[projectsCount: Projects.count()]
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(Projects projects) {
		def tasks = Tasks.findAllByProject(projects)
		[projects:projects, tasks:tasks]
        //respond projects
    }

    def create() {
        respond new Projects(params)
    }

    @Transactional
    def save(Projects projects) {
        if (projects == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (projects.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond projects.errors, view:'create'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\PROJECTS_"+projects.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProjectsPhoto(file, projects)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/PROJECTS_"+projects.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProjectsPhoto(file, projects)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/PROJECTS_"+projects.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProjectsPhoto(file, projects)
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
		
        projects.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'projects.label', default: 'Projects'), projects.id])
                redirect projects
            }
            '*' { respond projects, [status: CREATED] }
        }
    }

    def edit(Projects projects) {
        respond projects
    }

    @Transactional
    def update(Projects projects) {
        if (projects == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (projects.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond projects.errors, view:'edit'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\PROJECTS_"+projects.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProjectsPhoto(file, projects)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/PROJECTS_"+projects.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProjectsPhoto(file, projects)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/PROJECTS_"+projects.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadProjectsPhoto(file, projects)
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
		
        projects.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'projects.label', default: 'Projects'), projects.id])
                redirect projects
            }
            '*'{ respond projects, [status: OK] }
        }
    }

    @Transactional
    def delete(Projects projects) {

        if (projects == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        projects.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'projects.label', default: 'Projects'), projects.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'projects.label', default: 'Projects'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
