package apps

class TargetInventory {

    Date createTime
	String name
	String description
	Date updateTime
	Date beginTime
	Date endTime
	Long quantity
	String price
	Products products
	User user
	
    static constraints = {
		createTime(nullable:false)
		name(nullable:false, maxSize:500)
		description(nullable:false, maxSize:50000)
		updateTime(nullable:false)
		beginTime(nullable:false)
		endTime(nullable:false)
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
