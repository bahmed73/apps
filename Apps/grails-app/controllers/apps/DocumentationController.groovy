package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class DocumentationController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	static fProd = "/opt/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
        params.max = Math.min(max ?: 100, 200)
		
		def user = springSecurityService.currentUser
		
		if (user != null) {
			def documentationList = Documentation.findAllByUser(user)
			respond documentationList
		} else {
			def documentationList = Documentation.findAll()
			respond documentationList
		}
		
        //respond Documentation.list(params), model:[documentationCount: Documentation.count()]
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(Documentation documentation) {
        respond documentation
    }

    def create() {
        respond new Documentation(params)
    }

    @Transactional
    def save(Documentation documentation) {
        if (documentation == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (documentation.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond documentation.errors, view:'create'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				documentation.filename = transferFile.getOriginalFilename()
				documentation.testBytes = transferFile.getBytes()
			}
			else {
			   log.info "file is empty"
			}
		} catch (Exception e) {
				e.printStackTrace( )
				log.info "caught exception: " + e.getMessage()
				log.info "caught exception: " + e
		}
		
        documentation.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'documentation.label', default: 'Documentation'), documentation.id])
                redirect documentation
            }
            '*' { respond documentation, [status: CREATED] }
        }
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
	def download(long id) {
		Documentation documentInstance = Documentation.get(id)
		if ( documentInstance == null) {
			flash.message = "Document not found."
			redirect (action:'list')
		} else {
			response.setContentType("APPLICATION/OCTET-STREAM")
			response.setHeader("Content-Disposition", "Attachment;Filename=\"${documentInstance.filename}\"")
			def outputStream = response.getOutputStream()
			outputStream << documentInstance.testBytes
			outputStream.flush()
			outputStream.close()
		}
	}
	
    def edit(Documentation documentation) {
        respond documentation
    }

    @Transactional
    def update(Documentation documentation) {
        if (documentation == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (documentation.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond documentation.errors, view:'edit'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				documentation.filename = transferFile.getOriginalFilename()
				documentation.testBytes = transferFile.getBytes()
			}
			else {
			   log.info "file is empty"
			}
		} catch (Exception e) {
				e.printStackTrace( )
				log.info "caught exception: " + e.getMessage()
				log.info "caught exception: " + e
		}
		
        documentation.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'documentation.label', default: 'Documentation'), documentation.id])
                redirect documentation
            }
            '*'{ respond documentation, [status: OK] }
        }
    }

    @Transactional
    def delete(Documentation documentation) {

        if (documentation == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        documentation.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'documentation.label', default: 'Documentation'), documentation.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentation.label', default: 'Documentation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
