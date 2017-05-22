package apps

import grails.transaction.Transactional

@Transactional
class AppsService {

    def serviceMethod() {

    }
	
	//trackProductReferer(request.getHeader("REFERER"), products)
	def trackProductReferer(String referer, Products products) {
		
		try {
		
			if (referer!=null && !referer.equals("") && products!=null) {
				def productRefererInstance = new ProductReferer()
				productRefererInstance.referer=referer
				productRefererInstance.createTime=new Date()
				productRefererInstance.products = products
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
	
	def addProductView(Products products, String ip) {
		def view = new ProductView()
		view.status = 1
		view.products = products
		view.createTime = new Date()
		view.ip = ip
		
		view.save flush:true
	}
}
