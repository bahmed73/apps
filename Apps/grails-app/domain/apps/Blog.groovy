package apps

class Blog {

    //Long id
	Date createTime
	String name
	String description
	Date updateTime
    User user

    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:false)
                user(nullable:false)
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
