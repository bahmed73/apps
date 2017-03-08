package apps

class View {

    //Long id
        Integer status
        Date createTime
        String ip
        App app

    static constraints = {
                //id(nullable:true)
                status(nullable:false)
                createTime(nullable:false)
                ip(nullable:false, maxSize:20)
                app(nullable:false)
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
