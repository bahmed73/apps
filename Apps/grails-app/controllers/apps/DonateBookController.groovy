package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import groovy.util.logging.Log;

@Secured('ROLE_ANONYMOUS')
class DonateBookController {

	def springSecurityService
	def appsService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	static fProd = "/opt/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\Users\\Bilal Ahmed\\eclipse-workspace\\apps\\Apps\\grails-app\\assets\\images"
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DonateBook.list(params), model:[donateBookCount: DonateBook.count()]
    }

    def show(DonateBook donateBook) {
        respond donateBook
    }

    def create() {
        respond new DonateBook(params)
    }

    @Transactional
    def save(DonateBook donateBook) {
        if (donateBook == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (donateBook.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond donateBook.errors, view:'create'
            return
        }

        donateBook.save flush:true

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\DONATEBOOK_"+donateBook.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadDonateBookPhoto(file, donateBook)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/DONATEBOOK_"+donateBook.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadDonateBookPhoto(file, donateBook)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/DONATEBOOK_"+donateBook.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadDonateBookPhoto(file, donateBook)
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
                flash.message = message(code: 'default.created.message', args: [message(code: 'donateBook.label', default: 'DonateBook'), donateBook.id])
                redirect donateBook
            }
            '*' { respond donateBook, [status: CREATED] }
        }
    }

    def edit(DonateBook donateBook) {
        respond donateBook
    }

    @Transactional
    def update(DonateBook donateBook) {
        if (donateBook == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (donateBook.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond donateBook.errors, view:'edit'
            return
        }

        donateBook.save flush:true

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\DONATEBOOK_"+donateBook.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadDonateBookPhoto(file, donateBook)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/DONATEBOOK_"+donateBook.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadDonateBookPhoto(file, donateBook)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/DONATEBOOK_"+donateBook.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadDonateBookPhoto(file, donateBook)
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
                flash.message = message(code: 'default.updated.message', args: [message(code: 'donateBook.label', default: 'DonateBook'), donateBook.id])
                redirect donateBook
            }
            '*'{ respond donateBook, [status: OK] }
        }
    }

    @Transactional
    def delete(DonateBook donateBook) {

        if (donateBook == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        donateBook.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'donateBook.label', default: 'DonateBook'), donateBook.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'donateBook.label', default: 'DonateBook'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
