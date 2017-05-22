package apps

class AppReferer {

    Date createTime
	String referer
    App app
	
    static constraints = {
		createTime(nullable:false)
		referer(nullable:false, maxSize:1000)
		app(nullable:false)
                
    }

        static mapping = {
                version false
                //table 'app'
                //id generator:'sequence', params:[sequence:'app_seq']
        }
}
