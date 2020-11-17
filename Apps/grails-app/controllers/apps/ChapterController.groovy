package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import groovy.util.logging.Log;

@Secured('ROLE_ADMIN')
class ChapterController {

	def springSecurityService
	def appsService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	static fProd = "/opt/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
		def bookList = Book.findAll([sort: "createTime", order: "desc"])
		def bookExpando = new ArrayList()
		
		for (int i=0; i<bookList.size();i++) {
			def chapters = bookList.get(i).chapters
			
			def expando = new Expando()
			expando.book = bookList.getAt(i)
			expando.chapters = chapters
			bookExpando.add(expando)
		}
		[bookExpando: bookExpando]
    }

	@Transactional
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(Chapter chapter) {
        respond chapter
    }

    def create() {
        respond new Chapter(params)
    }

    @Transactional
    def save(Chapter chapter) {
        if (chapter == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (chapter.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond chapter.errors, view:'create'
            return
        }

		def user = springSecurityService.currentUser
		
		log.info "inside save chapter: username = " + user.username
		chapter.user = user
		
        chapter.save flush:true

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\CHAPTER_"+chapter.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadChapterPhoto(file, chapter)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/CHAPTER_"+chapter.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadChapterPhoto(file, chapter)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/CHAPTER_"+chapter.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadChapterPhoto(file, chapter)
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
                flash.message = message(code: 'default.created.message', args: [message(code: 'chapter.label', default: 'Chapter'), chapter.id])
                redirect chapter
            }
            '*' { respond chapter, [status: CREATED] }
        }
    }

    def edit(Chapter chapter) {
        respond chapter
    }

    @Transactional
    def update(Chapter chapter) {
        if (chapter == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (chapter.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond chapter.errors, view:'edit'
            return
        }

		def user = springSecurityService.currentUser
		
		log.info "inside save chapter: username = " + user.username
		chapter.user = user
		
        chapter.save flush:true

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\CHAPTER_"+chapter.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadChapterPhoto(file, chapter)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/CHAPTER_"+chapter.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadChapterPhoto(file, chapter)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/CHAPTER_"+chapter.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadChapterPhoto(file, chapter)
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
                flash.message = message(code: 'default.updated.message', args: [message(code: 'chapter.label', default: 'Chapter'), chapter.id])
                redirect chapter
            }
            '*'{ respond chapter, [status: OK] }
        }
    }

    @Transactional
    def delete(Chapter chapter) {

        if (chapter == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        chapter.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'chapter.label', default: 'Chapter'), chapter.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'chapter.label', default: 'Chapter'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
