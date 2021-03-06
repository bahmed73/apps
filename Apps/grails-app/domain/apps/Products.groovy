package apps

class Products {

    //Long id
        Date createTime
        String name
        String description
        Date updateTime
        String other
		String price
		User user
		byte[] imageOne
		byte[] imageTwo
		byte[] imageThree
		Category category
		Integer productsOrder

    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:false)
                other(nullable:true, maxSize:5000)
				price(nullable:true, maxSize:50)
				user(nullable:false)
				imageOne(nullable:true, maxSize: 1024 * 1024 * 2)
				imageTwo(nullable:true, maxSize: 1024 * 1024 * 2)
				imageThree(nullable:true, maxSize: 1024 * 1024 * 2)
				category(nullable:true)
				productsOrder(nullable:true)
    }

        static mapping = {
                version false
				//table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
