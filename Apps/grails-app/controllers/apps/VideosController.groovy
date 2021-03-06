package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class VideosController {

	def springSecurityService
	def appsService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
	static fProd = "/opt/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
        params.max = Math.min(max ?: 500, 500)
		
		/*
		def user = springSecurityService.currentUser
		
		if (user != null) {
			def videoList = Videos.findAllByUser(user)
			respond videoList
		} else {
			def videoList = Videos.findAll()
			respond videoList
		}
		*/
        respond Videos.list(params), model:[videosCount: Videos.count()]
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
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
