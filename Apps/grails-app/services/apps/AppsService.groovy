package apps

import grails.transaction.Transactional
import ij.ImagePlus

@Transactional
class AppsService {

	def imagingService
	
    def serviceMethod() {

    }
	
	//trackProductReferer(request.getHeader("REFERER"), products)
	def trackProductReferer(String referer, Products products, User user) {
		
		try {
		
			if (referer!=null && !referer.equals("") && products!=null) {
				def productRefererInstance = new ProductReferer()
				productRefererInstance.referer=referer
				productRefererInstance.createTime=new Date()
				productRefererInstance.products = products
				productRefererInstance.user = user
				if(!productRefererInstance.hasErrors() && productRefererInstance.save()) {
					System.out.println("productRefererInstance saved")
				} else {
					System.out.println("productRefererInstance not saved")
				}
						  
			}
		} catch (Exception e) {
			e.printStackTrace()
		}
	}
	
	//trackBLogReferer(request.getHeader("REFERER"), blog)
	def trackBlogReferer(String referer, Blog blog, User user) {
		
		try {
		
			if (referer!=null && !referer.equals("") && blog!=null) {
				def blogRefererInstance = new BlogReferer()
				blogRefererInstance.referer=referer
				blogRefererInstance.createTime=new Date()
				blogRefererInstance.blog = blog
				blogRefererInstance.user = user
				if(!blogRefererInstance.hasErrors() && blogRefererInstance.save()) {
					System.out.println("blogRefererInstance saved")
				} else {
					System.out.println("blogRefererInstance not saved")
				}
						  
			}
		} catch (Exception e) {
			e.printStackTrace()
		}
	}
	
	//trackProductReferer(request.getHeader("REFERER"), products)
	def trackAppReferer(String referer, App app) {
		
		try {
		
			if (referer!=null && !referer.equals("") && app!=null) {
				def appRefererInstance = new AppReferer()
				appRefererInstance.referer=referer
				appRefererInstance.createTime=new Date()
				appRefererInstance.app = app
				if(!appRefererInstance.hasErrors() && appRefererInstance.save()) {
					System.out.println("appRefererInstance saved")
				} else {
					System.out.println("appRefererInstance not saved")
				}
						  
			}
		} catch (Exception e) {
			e.printStackTrace()
		}
	}
	
	def addView(App app, String ip) {
		def view = new View()
		view.status = 1
		view.app = app
		view.createTime = new Date()
		view.ip = ip
		
		view.save flush:true
	}
	
	def addProductView(Products products, String ip, User user) {
		def view = new ProductView()
		view.status = 1
		view.products = products
		view.createTime = new Date()
		view.ip = ip
		view.user = user
		
		view.save flush:true
	}
	
	def addBlogView(Blog blog, String ip, User user) {
		def view = new BlogView()
		view.blog = blog
		view.createTime = new Date()
		view.ip = ip
		view.user = user
		
		view.save flush:true
	}
	
	def uploadProductPhoto(File file, Products products) {
		log.info "inside uploadProductPhoto"
		
		String fileName = file.getAbsolutePath()
		
		log.info "fileName = " + fileName
		
		ImagePlus image = imagingService.openImagePlus(fileName);
		try {
			def output = imagingService.generate100x100(image, fileName, true);
			
			def files = new File(output)
			products.imageOne = files.bytes
			
			output = imagingService.generate50x50(image, fileName, true);
			
			files = new File(output)
			products.imageTwo = files.bytes
			
			output = imagingService.generate400x400(image, fileName);
			
			files = new File(output)
			products.imageThree = files.bytes
			
		} catch (Exception e) {
			
			log.info"uploadProductPhoto: error generating images"
			e.printStackTrace()
			
		}
		
	}
	
	def uploadBlogPhoto(File file, Blog blog) {
		log.info "inside uploadBlogPhoto"
		
		String fileName = file.getAbsolutePath()
		
		log.info "fileName = " + fileName
		
		ImagePlus image = imagingService.openImagePlus(fileName);
		try {
			def output = imagingService.generate100x100(image, fileName, true);
			
			def files = new File(output)
			blog.imageOne = files.bytes
			
			output = imagingService.generate50x50(image, fileName, true);
			
			files = new File(output)
			blog.imageTwo = files.bytes
			
			output = imagingService.generate400x400(image, fileName);
			
			files = new File(output)
			blog.imageThree = files.bytes
			
		} catch (Exception e) {
			
			log.info"uploadBlogPhoto: error generating images"
			e.printStackTrace()
			
		}
		
	}
	
	def uploadInsectPhoto(File file, Insect insect) {
		log.info "inside uploadInsectPhoto"
		
		String fileName = file.getAbsolutePath()
		
		log.info "fileName = " + fileName
		
		ImagePlus image = imagingService.openImagePlus(fileName);
		try {
			def output = imagingService.generate100x100(image, fileName, true);
			
			def files = new File(output)
			insect.imageOne = files.bytes
			
			output = imagingService.generate50x50(image, fileName, true);
			
			files = new File(output)
			insect.imageTwo = files.bytes
			
			output = imagingService.generate400x400(image, fileName);
			
			files = new File(output)
			insect.imageThree = files.bytes
			
		} catch (Exception e) {
			
			log.info"uploadInsectPhoto: error generating images"
			e.printStackTrace()
			
		}
		
	}

	def uploadDiseasePhoto(File file, Disease disease) {
		log.info "inside uploadBlogPhoto"
		
		String fileName = file.getAbsolutePath()
		
		log.info "fileName = " + fileName
		
		ImagePlus image = imagingService.openImagePlus(fileName);
		try {
			def output = imagingService.generate100x100(image, fileName, true);
			
			def files = new File(output)
			disease.imageOne = files.bytes
			
			output = imagingService.generate50x50(image, fileName, true);
			
			files = new File(output)
			disease.imageTwo = files.bytes
			
			output = imagingService.generate400x400(image, fileName);
			
			files = new File(output)
			disease.imageThree = files.bytes
			
		} catch (Exception e) {
			
			log.info"uploadDiseasePhoto: error generating images"
			e.printStackTrace()
			
		}
		
	}
}
