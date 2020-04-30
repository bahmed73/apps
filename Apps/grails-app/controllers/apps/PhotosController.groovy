package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class PhotosController {

	def springSecurityService
	def appsService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	static fProd = "/opt/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
		
        //params.max = Math.min(max ?: 500, 500)
		
		/*
		def user = springSecurityService.currentUser
		
		if (user != null) {
			def photoList = Photos.findAllByUser(user)
			respond photoList
		} else {
			def photoList = Photos.findAll()
			respond photoList
		}
		*/
		
		def photosList = Photos.findAll()
        
		def categoryList = Category.findAll([sort: "categoryOrder", order: "desc"])
		def categoryExpando = new ArrayList()
		
		for (int i=0; i<categoryList.size();i++) {
			def photos = Photos.findAllByCategory(categoryList.getAt(i), [sort: "photoOrder", order: "desc"])
			
			def expando = new Expando()
			expando.category = categoryList.getAt(i)
			expando.photos = photos
			categoryExpando.add(expando)
		}
		
		def productsList = Products.findAll([sort: "productsOrder", order: "desc"])
		def productsExpando = new ArrayList()
		
		for (int i=0; i<productsList.size();i++) {
			def photos = Photos.findAllByProducts(productsList.getAt(i), [sort: "photoOrder", order: "desc"])
			
			def expando = new Expando()
			expando.products = productsList.getAt(i)
			expando.photos = photos
			productsExpando.add(expando)
		}
		
		def blogList = Blog.findAll([sort: "blogOrder", order: "desc"])
		def blogExpando = new ArrayList()
		
		for (int i=0; i<blogList.size();i++) {
			def photos = Photos.findAllByBlog(blogList.getAt(i), [sort: "photoOrder", order: "desc"])
			
			def expando = new Expando()
			expando.blog = blogList.getAt(i)
			expando.photos = photos
			blogExpando.add(expando)
		}
		
		[photosList:photosList, categoryExpando: categoryExpando, productsExpando: productsExpando, blogExpando: blogExpando]
		//respond Photos.list(params), model:[photosCount: Photos.count()]
		
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(Photos photos) {
        respond photos
    }

    def create() {
        respond new Photos(params)
    }

    @Transactional
    def save(Photos photos) {
        if (photos == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (photos.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond photos.errors, view:'create'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\PHOTOS_"+photos.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadPhotosPhoto(file, photos)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/PHOTOS_"+photos.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadPhotosPhoto(file, photos)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/PHOTOS_"+photos.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadPhotosPhoto(file, photos)
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
		
        photos.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'photos.label', default: 'Photos'), photos.id])
                redirect photos
            }
            '*' { respond photos, [status: CREATED] }
        }
    }

    def edit(Photos photos) {
        respond photos
    }

    @Transactional
    def update(Photos photos) {
        if (photos == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (photos.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond photos.errors, view:'edit'
            return
        }
		
		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\PHOTOS_"+photos.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadPhotosPhoto(file, photos)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/PHOTOS_"+photos.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadPhotosPhoto(file, photos)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/PHOTOS_"+photos.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadPhotosPhoto(file, photos)
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

        photos.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'photos.label', default: 'Photos'), photos.id])
                redirect photos
            }
            '*'{ respond photos, [status: OK] }
        }
    }

    @Transactional
    def delete(Photos photos) {

        if (photos == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        photos.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'photos.label', default: 'Photos'), photos.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'photos.label', default: 'Photos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
