package apps

class Inventory {

	Date createTime
	String name
	String description
	Date updateTime
	Long quantity
	String price
	Products products
	User user
	
    static constraints = {
		createTime(nullable:false)
		name(nullable:false, maxSize:500)
		description(nullable:true, maxSize:50000)
		updateTime(nullable:false)
		quantity(nullable:false)
		price(nullable:false, maxSize:50)
		products(nullable:false)
		user(nullable:false)
    }
	
	static mapping = {
		version false
		//table 'question'
		//id generator:'sequence', params:[sequence:'question_seq']
	}
}
