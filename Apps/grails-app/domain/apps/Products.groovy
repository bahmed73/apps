package apps

class Products {

    //Long id
        Integer status
        Date createTime
        String name
        String description
        Date updateTime
        App app
		String frontImage
		String backImage
		String logo
		String productSize
		String productColor
		String price
		String shippingInfo
		String returnPolicy

    static constraints = {
                //id(nullable:true)
                status(nullable:true)
                createTime(nullable:true)
                name(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:true)
                app(nullable:true)
				frontImage(nullable:true)
				backImage(nullable:true)
				logo(nullable:true)
				productSize(nullable:true)
				productColor(nullable:true)
				price(nullable:true)
				shippingInfo(nullable:true)
				returnPolicy(nullable:true)
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
