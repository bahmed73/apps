package apps

class Discount {

    //Long id
        Integer status
        Date createTime
        String name
        String description
        Date updateTime
		String percentage
		String amount
        App app

    static constraints = {
                //id(nullable:true)
                status(nullable:false)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:false)
                app(nullable:false)
				percentage(nullable:true)
				amount(nullable:true)
				
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
