package apps

class AppType {

	//Long id
        Date createTime
        String name
        Date updateTime

    static constraints = {
                //id(nullable:true)
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
