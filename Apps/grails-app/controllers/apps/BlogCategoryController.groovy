package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class BlogCategoryController {

	def appsService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	static fProd = "/opt/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
        //params.max = Math.min(max ?: 100, 100)
        //respond BlogCategory.list(params), model:[blogCategoryCount: BlogCategory.count()]
		def blogCategoryList = BlogCategory.findAll([sort: "categoryOrder", order: "desc"])
		respond blogCategoryList
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(BlogCategory blogCategory) {
		
		def books = Book.findAllByBlogCategory(blogCategory, [sort: "createTime", order: "desc"])
		[blogCategory:blogCategory, books:books]
        //respond blogCategory
    }

    def create() {
        respond new BlogCategory(params)
    }

    @Transactional
    def save(BlogCategory blogCategory) {
        if (blogCategory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (blogCategory.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond blogCategory.errors, view:'create'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\BLOG_CATEGORY_"+blogCategory.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBlogCategoryPhoto(file, blogCategory)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/BLOG_CATEGORY_"+blogCategory.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBlogCategoryPhoto(file, blogCategory)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/BLOG_CATEGORY_"+blogCategory.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBlogCategoryPhoto(file, blogCategory)
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
		
        blogCategory.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'blogCategory.label', default: 'BlogCategory'), blogCategory.id])
                redirect blogCategory
            }
            '*' { respond blogCategory, [status: CREATED] }
        }
    }

    def edit(BlogCategory blogCategory) {
        respond blogCategory
    }

    @Transactional
    def update(BlogCategory blogCategory) {
        if (blogCategory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (blogCategory.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond blogCategory.errors, view:'edit'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\BLOG_CATEGORY_"+blogCategory.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBlogCategoryPhoto(file, blogCategory)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/BLOG_CATEGORY_"+blogCategory.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBlogCategoryPhoto(file, blogCategory)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/BLOG_CATEGORY_"+blogCategory.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBlogCategoryPhoto(file, blogCategory)
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

        blogCategory.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'blogCategory.label', default: 'BlogCategory'), blogCategory.id])
                redirect blogCategory
            }
            '*'{ respond blogCategory, [status: OK] }
        }
    }

    @Transactional
    def delete(BlogCategory blogCategory) {

        if (blogCategory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        blogCategory.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'blogCategory.label', default: 'BlogCategory'), blogCategory.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'blogCategory.label', default: 'BlogCategory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
