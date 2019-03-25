package apps

class Customers {

    //Long id
        Date createTime
        String name
        String address
		String phone
		String website
        Date updateTime
		Date beginTime
		Date endTime
		Long beginQuantity
		Long endQuantity
		String beginPrice
		String endPrice


    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                address(nullable:true, maxSize:1000)
				phone(nullable:true, maxSize:100)
				website(nullable:true, maxSize:1000)
                updateTime(nullable:false)
				beginTime(nullable:false)
				endTime(nullable:false)
				beginQuantity(nullable:false)
				endQuantity(nullable:false)
				beginPrice(nullable:false, maxSize:50)
				endPrice(nullable:false, maxSize:50)
    }

        static mapping = {
                version false
				//table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}