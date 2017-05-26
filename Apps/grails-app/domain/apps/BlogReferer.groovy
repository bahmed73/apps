package apps

class BlogReferer {

    Date createTime
	String referer
    Blog blog
	User user
	
    static constraints = {
		createTime(nullable:false)
		referer(nullable:false, maxSize:1000)
		blog(nullable:false)
		user(nullable:false)
                
    }

        static mapping = {
                version false
                //table 'app'
                //id generator:'sequence', params:[sequence:'app_seq']
        }
}
