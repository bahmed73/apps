package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class NotesController {

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
			def notesList = Notes.findAllByUser(user)
			respond notesList
		} else {
			def notesList = Notes.findAll()
			respond notesList
		}
		*/
        respond Notes.list(params), model:[notesCount: Notes.count()]
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(Notes notes) {
        respond notes
    }

    def create() {
        respond new Notes(params)
    }

    @Transactional
    def save(Notes notes) {
        if (notes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (notes.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond notes.errors, view:'create'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\NOTES_"+notes.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadNotesPhoto(file, notes)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/NOTES_"+notes.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadNotesPhoto(file, notes)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/NOTES_"+notes.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadNotesPhoto(file, notes)
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
		
        notes.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'notes.label', default: 'Notes'), notes.id])
                redirect notes
            }
            '*' { respond notes, [status: CREATED] }
        }
    }

    def edit(Notes notes) {
        respond notes
    }

    @Transactional
    def update(Notes notes) {
        if (notes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (notes.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond notes.errors, view:'edit'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\NOTES_"+notes.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadNotesPhoto(file, notes)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/NOTES_"+notes.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadNotesPhoto(file, notes)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/NOTES_"+notes.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadNotesPhoto(file, notes)
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
		
        notes.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'notes.label', default: 'Notes'), notes.id])
                redirect notes
            }
            '*'{ respond notes, [status: OK] }
        }
    }

    @Transactional
    def delete(Notes notes) {

        if (notes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        notes.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'notes.label', default: 'Notes'), notes.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'notes.label', default: 'Notes'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
