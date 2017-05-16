package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AppController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		
		def appViews = View.findAll()
		System.out.println("appViews = " + appViews)
		
		
		def appList2 = App.list(params)
		System.out.println("appList2 = " + appList2)
		
        respond App.list(params), model:[appCount: App.count()]
    }

    def show(App app) {
		addView(app, request.getRemoteAddr())
        respond app
    }

    def create() {
        respond new App(params)
    }

    @Transactional
    def save(App app) {
        if (app == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (app.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond app.errors, view:'create'
            return
        }

        app.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'app.label', default: 'App'), app.id])
                redirect app
            }
            '*' { respond app, [status: CREATED] }
        }
    }

    def edit(App app) {
        respond app
    }

    @Transactional
    def update(App app) {
        if (app == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (app.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond app.errors, view:'edit'
            return
        }

        app.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'app.label', default: 'App'), app.id])
                redirect app
            }
            '*'{ respond app, [status: OK] }
        }
    }

    @Transactional
    def delete(App app) {

        if (app == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        app.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'app.label', default: 'App'), app.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'app.label', default: 'App'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
	protected void addView(App app, String ip) {
		def view = new View()
		view.status = 1
		view.app = app
		view.createTime = new Date()
		view.ip = ip
		
		view.save flush:true
	}
}
