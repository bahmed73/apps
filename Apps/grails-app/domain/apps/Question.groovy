package apps

class Question {

//Long id
        Integer status
        Date createTime
        String name
        String description
        Date updateTime
        App app

    static constraints = {
                //id(nullable:true)
                status(nullable:false)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:false)
                app(nullable:false)
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
