package apps

import grails.util.Environment
import java.util.Base64
import java.nio.charset.Charset

class FoodalTagLib {
    static defaultEncodeAs = [taglib:'html']
	static namespace = "foodal"
	
	private final Charset UTF8_CHARSET = Charset.forName("UTF-8");
	
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
	
	//static filename = "/usr/share/tomcat/webapps/ROOT/assets/"
	static fProd = "/usr/share/tomcat/webapps/ROOT/assets/images"
	static fTest = "C:\\development\\workspace\\Apps\\grails-app\\assets\\images"
	
	
	/*
	 * Base 64 encoded, utf-8 string returned as a result, from file, to bytes, to string.
	 */
	
	
	/*
	 * <img src="data:image/png;base64,<foodal:pImage numb='${products.id}' resize='3'/>"/>
	 */
	
	def pImage = { attrs, body ->
		
		def filename
		
		if (Environment.current == Environment.DEVELOPMENT) {
			filename = fTest	
		} else {
			filename = fProd
		}
		
		log.info "inside pImage tag: filename = " + filename
		
		def resize = attrs.resize ? attrs.resize: 1;
		log.info "resize = " + resize
		
		def numb = attrs.numb ? attrs.numb: 1;
		log.info "numb = " + numb
		
		def pFile = filename + "PRODUCTS_" + numb + "-0" + resize
		log.info "pFile = " + pFile
		
		def file = new File(pFile)
		def img = file.bytes
		
		
		//out << "<img src='"
		
		def base64 = Base64.getEncoder().encode(img);
		//def base64 = Base64.getDecoder().decode(img)
		//out << base64
		
		def utf8 = new String(base64, UTF8_CHARSET)
		
		response.contentType = "image/png"
		response.contentLength = utf8.size()
		
		out << utf8
		  
		//out << img
		//out << "'/>"
		out.flush()
		
	}
	
	/*
	 * <img src="data:image/png;base64,<foodal:bImage numb='${blog.id}' resize='3'/>"/>
	 */
	
	def bImage = { attrs, body -> 
		
		def filename
		
		if (Environment.current == Environment.DEVELOPMENT) {
			filename = fTest
		} else {
			filename = fProd
		}
		
		log.info "inside bImage tag: filename = " + filename
		
		def resize = attrs.resize ? attrs.resize: 1;
		log.info "resize = " + resize
		
		def numb = attrs.numb ? attrs.numb: 1;
		log.info "numb = " + numb
		
		def bFile = filename + "BLOG_" + numb + "-0" + resize
		log.info "bFile = " + bFile
		
		
		def file = new File(bFile)
		def img = file.bytes
		
		//out << "<img src='"
		
		def base64 = Base64.getEncoder().encode(img);
		//def base64 = Base64.getDecoder().decode(img)
		//out << base64
		
		def utf8 = new String(base64, UTF8_CHARSET)
		
		response.contentType = "image/png"
		response.contentLength = utf8.size()
		
		out << utf8
		  
		//out << img
		//out << "'/>"
		out.flush()
	}
}
