package apps

class AllocationForecast {

    Date createTime
	String name
	String description
	Date updateTime
	Date beginTime
	Date endTime
	Long beginQuantity
	Long endQuantity
	String beginPrice
	String endPrice
	Products products
	User user
	
    static constraints = {
		createTime(nullable:false)
		name(nullable:false, maxSize:500)
		description(nullable:false, maxSize:50000)
		updateTime(nullable:false)
		beginTime(nullable:false)
		endTime(nullable:false)
		beginQuantity(nullable:false)
		endQuantity(nullable:false)
		beginPrice(nullable:false, maxSize:50)
		endPrice(nullable:false, maxSize:50)
		products(nullable:false)
		user(nullable:false)
    }
	
	static mapping = {
		version false
		//table 'question'
		//id generator:'sequence', params:[sequence:'question_seq']
	}
}
