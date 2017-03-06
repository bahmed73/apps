package apps

class App {

//Long id
        Integer status
        Date createTime
        String name
        String description
        Date updateTime
        AppType appType

    static constraints = {
                //id(nullable:true)
                status(nullable:false)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:false, maxSize:50000)
                updateTime(nullable:false)
                appType(nullable:false)
    }

        static mapping = {
                version false
                //table 'app'
                //id generator:'sequence', params:[sequence:'app_seq']
        }
}
