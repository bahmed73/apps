package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CouponController {

	def springSecurityService
    def appsService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	static fProd = "/opt/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"
	
	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def index(Integer max) {
        params.max = Math.min(max ?: 50, 100)
		
		def user = springSecurityService.currentUser
		
		if (user != null) {
			def couponList = Coupon.findAllByUser(user)
			respond couponList
		} else {
			def couponList = Coupon.findAll()
			respond couponList
		}
		
        respond Coupon.list(params), model:[couponCount: Coupon.count()]
    }

	@Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS'])
    def show(Coupon coupon) {
        respond coupon
    }

    def create() {
        respond new Coupon(params)
    }

    @Transactional
    def save(Coupon coupon) {
        if (coupon == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (coupon.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond coupon.errors, view:'create'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\COUPON_"+coupon.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadCouponPhoto(file, coupon)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/COUPON_"+coupon.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadCouponPhoto(file, coupon)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/COUPON_"+coupon.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadCouponPhoto(file, coupon)
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
		
        coupon.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'coupon.label', default: 'Coupon'), coupon.id])
                redirect coupon
            }
            '*' { respond coupon, [status: CREATED] }
        }
    }

    def edit(Coupon coupon) {
        respond coupon
    }

    @Transactional
    def update(Coupon coupon) {
        if (coupon == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (coupon.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond coupon.errors, view:'edit'
            return
        }

		try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				log.info "file is not empty, transferring"
				String fileName

				switch (grails.util.Environment.current) {
				case grails.util.Environment.DEVELOPMENT:
						fileName = fTest + "\\COUPON_"+coupon.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadCouponPhoto(file, coupon)
						break
				case grails.util.Environment.TEST:
						fileName = fProd + "/COUPON_"+coupon.id
						System.out.println("fileName = " + fileName)
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadCouponPhoto(file, coupon)
						break
				case grails.util.Environment.PRODUCTION:
						fileName = fProd + "/COUPON_"+coupon.id
						log.info "fileName = " + fileName
						File file = new File(fileName)
						transferFile.transferTo( file )
						appsService.uploadCouponPhoto(file, coupon)
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

		
        coupon.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'coupon.label', default: 'Coupon'), coupon.id])
                redirect coupon
            }
            '*'{ respond coupon, [status: OK] }
        }
    }

    @Transactional
    def delete(Coupon coupon) {

        if (coupon == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        coupon.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'coupon.label', default: 'Coupon'), coupon.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'coupon.label', default: 'Coupon'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
