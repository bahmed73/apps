package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class TreeWellnessController {

    def appsService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
	static fProd = "/opt/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TreeWellness.list(params), model:[treeWellnessCount: TreeWellness.count()]
    }

    def show(TreeWellness treeWellness) {
        respond treeWellness
    }

    def create() {
        respond new TreeWellness(params)
    }

    @Transactional
    def save(TreeWellness treeWellness) {
        if (treeWellness == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (treeWellness.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond treeWellness.errors, view:'create'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\TREEWELLNESS_"+treeWellness.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadTreeWellnessPhoto(file, treeWellness)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/TREEWELLNESS_"+treeWellness.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadTreeWellnessPhoto(file, treeWellness)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/TREEWELLNESS_"+treeWellness.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadTreeWellnessPhoto(file, treeWellness)
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
		
        treeWellness.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'treeWellness.label', default: 'TreeWellness'), treeWellness.id])
                redirect treeWellness
            }
            '*' { respond treeWellness, [status: CREATED] }
        }
    }

    def edit(TreeWellness treeWellness) {
        respond treeWellness
    }

    @Transactional
    def update(TreeWellness treeWellness) {
        if (treeWellness == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (treeWellness.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond treeWellness.errors, view:'edit'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\TREEWELLNESS_"+treeWellness.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadTreeWellnessPhoto(file, treeWellness)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/TREEWELLNESS_"+treeWellness.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadTreeWellnessPhoto(file, treeWellness)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/TREEWELLNESS_"+treeWellness.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadTreeWellnessPhoto(file, treeWellness)
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
		
        treeWellness.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'treeWellness.label', default: 'TreeWellness'), treeWellness.id])
                redirect treeWellness
            }
            '*'{ respond treeWellness, [status: OK] }
        }
    }

    @Transactional
    def delete(TreeWellness treeWellness) {

        if (treeWellness == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        treeWellness.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'treeWellness.label', default: 'TreeWellness'), treeWellness.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'treeWellness.label', default: 'TreeWellness'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
