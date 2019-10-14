package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class InsectController {

	def appsService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
	static fProd = "/opt/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Insect.list(params), model:[insectCount: Insect.count()]
    }

    def show(Insect insect) {
        respond insect
    }

    def create() {
        respond new Insect(params)
    }

    @Transactional
    def save(Insect insect) {
        if (insect == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (insect.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond insect.errors, view:'create'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\INSECT_"+insect.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadInsectPhoto(file, insect)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/INSECT_"+insect.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadInsectPhoto(file, insect)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/INSECT_"+insect.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadInsectPhoto(file, insect)
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
		
        insect.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'insect.label', default: 'Insect'), insect.id])
                redirect insect
            }
            '*' { respond insect, [status: CREATED] }
        }
    }

    def edit(Insect insect) {
        respond insect
    }

    @Transactional
    def update(Insect insect) {
        if (insect == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (insect.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond insect.errors, view:'edit'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\INSECT_"+insect.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadInsectPhoto(file, insect)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/INSECT_"+insect.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadInsectPhoto(file, insect)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/INSECT_"+insect.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadInsectPhoto(file, insect)
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
		
        insect.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'insect.label', default: 'Insect'), insect.id])
                redirect insect
            }
            '*'{ respond insect, [status: OK] }
        }
    }

    @Transactional
    def delete(Insect insect) {

        if (insect == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        insect.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'insect.label', default: 'Insect'), insect.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'insect.label', default: 'Insect'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
