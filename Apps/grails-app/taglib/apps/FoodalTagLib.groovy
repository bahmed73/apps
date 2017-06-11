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
	
	def tLink = { attrs, body -> 
		
		def text = attrs.text ? attrs.text: "";
		log.info "text = " + text
		
		def returnLink = ""
		def returnText = ""
		def textAfter = ""
		def remainingText = ""
		
		if (text.contains("http")) {
			
			
			def index = text.indexOf(" http")
			returnText = text.substring(0, index)
			textAfter = text.substring(index, text.length())
			index = textAfter.indexOf(" ")
			if (index > 0) {
				returnLink = textAfter.substring(0, index) 
				returnText+=" <a href='" + returnLink + "'></a>"
				remainingText = textAfter.substring(index, textAfter.length())
				
				if (remainingText.contains("http")) {
					returnText += recurse(remainingText)
				} else {
					returnText+= remainingText
				}
				log.info "returnText = " + returnText
				out << body() << returnText
			}
		} else {
			log.info "text = " + text
			out << body() << text
		}
		
	}
	
	private def recurse(String text) {
		
		log.info "recurse = " + text
		
		def returnLink = ""
		def returnText = ""
		def textAfter = ""
		def remainingText = ""
		
		def index = text.indexOf(" http")
		returnText = text.substring(0, index)
		textAfter = text.substring(index, text.length())
		index = textAfter.indexOf(" ")
		if (index > 0) {
			returnLink = textAfter.substring(0, index)
			returnText+=" <a href='" + returnLink + "'></a>"
			remainingText = textAfter.substring(index, textAfter.length())
			returnText+= remainingText
			
			log.info "recurse returnText = " + returnText
			
			return returnText
		} else {
			log.info "recurse text = " + text
			return text
		}
	}
	
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
