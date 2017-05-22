package apps

class Products {

    //Long id
        Date createTime
        String name
        String description
        Date updateTime
        String productSize
		String productColor
		String price
		String shippingInfo
		String returnPolicy
		User user

    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:false)
                productSize(nullable:true)
				productColor(nullable:true)
				price(nullable:false)
				shippingInfo(nullable:true)
				returnPolicy(nullable:true)
				user(nullable:false)
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
