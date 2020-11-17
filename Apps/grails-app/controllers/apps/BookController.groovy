package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import groovy.util.logging.Log;

@Secured('ROLE_ADMIN')
class BookController {

	def springSecurityService
	def appsService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	static fProd = "/opt/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
		def categoryList = BlogCategory.findAll([sort: "categoryOrder", order: "desc"])
		def categoryExpando = new ArrayList()
		
		for (int i=0; i<categoryList.size();i++) {
			def books = Book.findAllByBlogCategory(categoryList.getAt(i), [sort: "createTime", order: "desc"])
			
			def expando = new Expando()
			expando.category = categoryList.getAt(i)
			expando.books = books
			categoryExpando.add(expando)
		}
		[categoryExpando: categoryExpando]
    }

	@Transactional
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(Book book) {
        respond book
    }

    def create() {
        respond new Book(params)
    }

    @Transactional
    def save(Book book) {
        if (book == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (book.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond book.errors, view:'create'
            return
        }

		def user = springSecurityService.currentUser
		
		log.info "inside save book: username = " + user.username
		book.user = user
		
        book.save flush:true

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\BOOK_"+book.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBookPhoto(file, book)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/BOOK_"+book.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBookPhoto(file, book)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/BOOK_"+book.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBookPhoto(file, book)
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
                flash.message = message(code: 'default.created.message', args: [message(code: 'book.label', default: 'Book'), book.id])
                redirect book
            }
            '*' { respond book, [status: CREATED] }
        }
    }

    def edit(Book book) {
        respond book
    }

    @Transactional
    def update(Book book) {
        if (book == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (book.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond book.errors, view:'edit'
            return
        }

		def user = springSecurityService.currentUser
		
		log.info "inside save book: username = " + user.username
		book.user = user
		
        book.save flush:true

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\BOOK_"+book.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBookPhoto(file, book)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/BOOK_"+book.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBookPhoto(file, book)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/BOOK_"+book.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBookPhoto(file, book)
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
                flash.message = message(code: 'default.updated.message', args: [message(code: 'book.label', default: 'Book'), book.id])
                redirect book
            }
            '*'{ respond book, [status: OK] }
        }
    }

    @Transactional
    def delete(Book book) {

        if (book == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        book.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'book.label', default: 'Book'), book.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'book.label', default: 'Book'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
