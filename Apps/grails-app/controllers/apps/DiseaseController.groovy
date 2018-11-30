package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class DiseaseController {

	def appsService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	static fProd = "/opt/tomcat/apache-tomcat-9.0.13/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Disease.list(params), model:[diseaseCount: Disease.count()]
    }

    def show(Disease disease) {
        respond disease
    }

    def create() {
        respond new Disease(params)
    }

    @Transactional
    def save(Disease disease) {
        if (disease == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (disease.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond disease.errors, view:'create'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\DISEASE_"+disease.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadDiseasePhoto(file, disease)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/DISEASE_"+disease.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadDiseasePhoto(file, disease)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/DISEASE_"+disease.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadDiseasePhoto(file, disease)
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
		
        disease.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'disease.label', default: 'Disease'), disease.id])
                redirect disease
            }
            '*' { respond disease, [status: CREATED] }
        }
    }

    def edit(Disease disease) {
        respond disease
    }

    @Transactional
    def update(Disease disease) {
        if (disease == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (disease.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond disease.errors, view:'edit'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\DISEASE_"+disease.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadDiseasePhoto(file, disease)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/DISEASE_"+disease.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadDiseasePhoto(file, disease)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/DISEASE_"+disease.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadDiseasePhoto(file, disease)
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
		
        disease.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'disease.label', default: 'Disease'), disease.id])
                redirect disease
            }
            '*'{ respond disease, [status: OK] }
        }
    }

    @Transactional
    def delete(Disease disease) {

        if (disease == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        disease.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'disease.label', default: 'Disease'), disease.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'disease.label', default: 'Disease'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
