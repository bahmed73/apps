package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import groovy.util.logging.Log;

@Secured('ROLE_ADMIN')
class BlogController {

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
			def blogs = Blog.findAllByBlogCategory(categoryList.getAt(i), [sort: "blogOrder", order: "desc"])
			
			def expando = new Expando()
			expando.category = categoryList.getAt(i)
			expando.blogs = blogs
			categoryExpando.add(expando)
		}
		[categoryExpando: categoryExpando]
    }

	@Transactional
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(Blog blog) {
        if (blog == null) {
			redirect action:"index", method:"GET"
			return
		}
		def user = blog.user
		
		appsService.addBlogView(blog, request.getRemoteAddr(), user)
		appsService.trackBlogReferer(request.getHeader("REFERER"), blog, user)
		def blogViews = BlogView.countByBlog(blog)
		def photos = Photos.findAllByBlog(blog, [sort: "photoOrder", order: "desc"])
		
		[blog:blog, blogViews:blogViews, photos:photos]
        //respond blog, model:[blogViews: blogViews]
    }

    def create() {
        respond new Blog(params)
    }

    @Transactional
    def save(Blog blog) {
        if (blog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (blog.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond blog.errors, view:'create'
            return
        }

		def user = springSecurityService.currentUser
		
		log.info "inside save blog: username = " + user.username
		blog.user = user
		
        blog.save flush:true

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\BLOG_"+blog.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBlogPhoto(file, blog)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/BLOG_"+blog.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBlogPhoto(file, blog)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/BLOG_"+blog.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBlogPhoto(file, blog)
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
                flash.message = message(code: 'default.created.message', args: [message(code: 'blog.label', default: 'Blog'), blog.id])
                redirect blog
            }
            '*' { respond blog, [status: CREATED] }
        }
    }

    def edit(Blog blog) {
		respond blog
    }

    @Transactional
    def update(Blog blog) {
        if (blog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (blog.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond blog.errors, view:'edit'
            return
        }

		def user = springSecurityService.currentUser
		
		log.info "inside update blog: username = " + user.username
		blog.user = user
		
        blog.save flush:true

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\BLOG_"+blog.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBlogPhoto(file, blog)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/BLOG_"+blog.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBlogPhoto(file, blog)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/BLOG_"+blog.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadBlogPhoto(file, blog)
						break
				}

			}
			else {
			   log.info "file is empty"
			}
		} catch (Exception e) {
				e.printStackTrace( )
				log.info "caught exception: " + e
		}
		
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'blog.label', default: 'Blog'), blog.id])
                redirect blog
            }
            '*'{ respond blog, [status: OK] }
        }
    }

    @Transactional
    def delete(Blog blog) {

        if (blog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

		def user = springSecurityService.currentUser
		
		if (blog.user != user) {
			flash.message ="Access denied."
			redirect action:"index", method:"GET"
			return
		}
		
		def blogReferers = BlogReferer.findAllByBlog(blog)
		
		if (blogReferers != null) {
			for (int j=0;j<blogReferers.size(); j++) {
				def blogReferer = blogReferers.get(j)
				blogReferer.delete flush:true
			}
		}
		
		def blogViews = BlogView.findAllByBlog(blog)
		
		if (blogViews != null) {
			for (int j=0;j<blogViews.size(); j++) {
				def blogView = blogViews.get(j)
				blogView.delete flush:true
			}
		}
		
        blog.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'blog.label', default: 'Blog'), blog.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'blog.label', default: 'Blog'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
