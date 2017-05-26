package apps

class BlogView {

    //Long id
        Date createTime
        String ip
        Blog blog
		User user

    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                ip(nullable:false, maxSize:20)
                blog(nullable:false)
				user(nullable:false)
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
