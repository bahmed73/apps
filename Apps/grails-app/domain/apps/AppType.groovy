package apps

class AppType {

	//Long id
        Integer status
        Date createTime
        String name
        Date updateTime

    static constraints = {
                //id(nullable:true)
                status(nullable:false)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                updateTime(nullable:false)
    }

        static mapping = {
                version false
                //table 'app_type'
                //id generator:'sequence', params:[sequence:'app_type_seq']
        }
}
