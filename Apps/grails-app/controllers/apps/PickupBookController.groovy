package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import groovy.util.logging.Log;

@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
class PickupBookController {

	def springSecurityService
	def appsService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	static fProd = "/opt/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PickupBook.list(params), model:[pickupBookCount: PickupBook.count()]
    }

    def show(PickupBook pickupBook) {
        respond pickupBook
    }

    def create() {
        respond new PickupBook(params)
    }

    @Transactional
    def save(PickupBook pickupBook) {
        if (pickupBook == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pickupBook.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pickupBook.errors, view:'create'
            return
        }

        pickupBook.save flush:true

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\PICKUPBOOK_"+pickupBook.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadPickupBookPhoto(file, pickupBook)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/PICKUPBOOK_"+pickupBook.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadPickupBookPhoto(file, pickupBook)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/PICKUPBOOK_"+pickupBook.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadPickupBookPhoto(file, pickupBook)
						break
				}

			}
			else {
			   log.info "file is empty"
			}
		} catch (Exception e) {
				e.printStackTrace( )
				log.info e
		}

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pickupBook.label', default: 'PickupBook'), pickupBook.id])
                redirect pickupBook
            }
            '*' { respond pickupBook, [status: CREATED] }
        }
    }

    def edit(PickupBook pickupBook) {
        respond pickupBook
    }

    @Transactional
    def update(PickupBook pickupBook) {
        if (pickupBook == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pickupBook.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pickupBook.errors, view:'edit'
            return
        }

        pickupBook.save flush:true

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\PICKUPBOOK_"+pickupBook.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadPickupBookPhoto(file, pickupBook)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/PICKUPBOOK_"+pickupBook.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadPickupBookPhoto(file, pickupBook)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/PICKUPBOOK_"+pickupBook.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadPickupBookPhoto(file, pickupBook)
						break
				}

			}
			else {
			   log.info "file is empty"
			}
		} catch (Exception e) {
				e.printStackTrace( )
				log.info e
		}

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pickupBook.label', default: 'PickupBook'), pickupBook.id])
                redirect pickupBook
            }
            '*'{ respond pickupBook, [status: OK] }
        }
    }

    @Transactional
    def delete(PickupBook pickupBook) {

        if (pickupBook == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        pickupBook.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pickupBook.label', default: 'PickupBook'), pickupBook.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pickupBook.label', default: 'PickupBook'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
