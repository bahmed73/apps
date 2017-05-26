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
	
	def uploadProductPhoto(File file) {
		println "inside uploadProductPhoto"
		
		String fileName = file.getAbsolutePath()
		
		println "inside $fileName"
		
		ImagePlus image = imagingService.openImagePlus(fileName);
		try {
			imagingService.generate100x100(image, fileName, true);
			imagingService.generate50x50(image, fileName, true);
			imagingService.generateOriginal(image, fileName);
		} catch (Exception e) {
			
			log.error("uploadProductPhoto: error generating images")
			println "uploadProductPhoto: error generating images"
			e.printStackTrace()
			
		}
		
	}
	
	def uploadBlogPhoto(File file) {
		println "inside uploadBlogPhoto"
		
		String fileName = file.getAbsolutePath()
		
		println "inside $fileName"
		
		ImagePlus image = imagingService.openImagePlus(fileName);
		try {
			imagingService.generate100x100(image, fileName, true);
			imagingService.generate50x50(image, fileName, true);
			imagingService.generateOriginal(image, fileName);
		} catch (Exception e) {
			
			log.error("uploadBlogPhoto: error generating images")
			println "uploadBlogPhoto: error generating images"
			e.printStackTrace()
			
		}
		
	}

}
