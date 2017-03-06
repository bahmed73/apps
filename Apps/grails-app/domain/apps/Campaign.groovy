package apps

class Campaign {

//Long id
        Integer status
        Date createTime
        String name
        String description
        Date updateTime
        Date endTime
        App app

    static constraints = {
                //id(nullable:true)
                status(nullable:false)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:false, maxSize:50000)
                updateTime(nullable:false)
                endTime(nullable:false)
                app(nullable:false)
    }

        static mapping = {
                version false
                //table 'campaign'
                //i d generator:'sequence', params:[sequence:'campaign_seq']
        }
}
