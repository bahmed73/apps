package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class UserProfileController {

	def springSecurityService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def userProfileList = UserProfile.findAllByUser(user)
		
        respond userProfileList
    }

    def show(UserProfile userProfile) {
        respond userProfile
    }

    def create() {
        respond new UserProfile(params)
    }

    @Transactional
    def save(UserProfile userProfile) {
        if (userProfile == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (userProfile.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond userProfile.errors, view:'create'
            return
        }

		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		if (userProfile.user != user) {
			flash.message ="Access denied."
			redirect action:"index", method:"GET"
			return
		}
		
        userProfile.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userProfile.label', default: 'UserProfile'), userProfile.id])
                redirect userProfile
            }
            '*' { respond userProfile, [status: CREATED] }
        }
    }

    def edit(UserProfile userProfile) {
        respond userProfile
    }

    @Transactional
    def update(UserProfile userProfile) {
        if (userProfile == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (userProfile.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond userProfile.errors, view:'edit'
            return
        }

		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		if (userProfile.user != user) {
			flash.message ="Access denied."
			redirect action:"index", method:"GET"
			return
		}
		
        userProfile.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'userProfile.label', default: 'UserProfile'), userProfile.id])
                redirect userProfile
            }
            '*'{ respond userProfile, [status: OK] }
        }
    }

    @Transactional
    def delete(UserProfile userProfile) {

        if (userProfile == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        userProfile.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'userProfile.label', default: 'UserProfile'), userProfile.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userProfile.label', default: 'UserProfile'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
