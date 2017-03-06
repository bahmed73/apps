package apps

class Answer {

 //Long id
        Integer status
        Date createTime
        String name
        String description
        Date updateTime
        App app
		Question question

    static constraints = {
                //id(nullable:true)
                status(nullable:false)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:false)
                app(nullable:false)
				question(nullable:false)
    }

        static mapping = {
                version false
                //table 'answer'
                //id generator:'sequence', params:[sequence:'answer_seq']
        }
}
