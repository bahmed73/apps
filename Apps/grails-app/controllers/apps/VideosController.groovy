package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class VideosController {

	def appsService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
	static fProd = "/opt/tomcat/apache-tomcat-9.0.13/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Videos.list(params), model:[videosCount: Videos.count()]
    }

    def show(Videos videos) {
        respond videos
    }

    def create() {
        respond new Videos(params)
    }

    @Transactional
    def save(Videos videos) {
        if (videos == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (videos.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond videos.errors, view:'create'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\VIDEOS_"+videos.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadVideosVideo(file, videos)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/VIDEOS_"+videos.id
						System.out.println("fileName = " + videos)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadVideosVideo(file, videos)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/VIDEOS_"+videos.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadVideosVideo(file, videos)
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
		
        videos.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'videos.label', default: 'Videos'), videos.id])
                redirect videos
            }
            '*' { respond videos, [status: CREATED] }
        }
    }

    def edit(Videos videos) {
        respond videos
    }

    @Transactional
    def update(Videos videos) {
        if (videos == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (videos.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond videos.errors, view:'edit'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\VIDEOS_"+videos.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadVideosVideo(file, videos)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/VIDEOS_"+videos.id
						System.out.println("fileName = " + videos)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadVideosVideo(file, videos)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/VIDEOS_"+videos.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadVideosVideo(file, videos)
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

		
        videos.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'videos.label', default: 'Videos'), videos.id])
                redirect videos
            }
            '*'{ respond videos, [status: OK] }
        }
    }

    @Transactional
    def delete(Videos videos) {

        if (videos == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        videos.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'videos.label', default: 'Videos'), videos.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'videos.label', default: 'Videos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
