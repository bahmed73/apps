package apps

class Coupon {

    //Long id
        Date createTime
        String name
        String description
        Date updateTime
        byte[] imageOne
		byte[] imageTwo
		byte[] imageThree
		User user
		Date eventDate
		String eventLink
		
    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:false)
				imageOne(nullable:true, maxSize: 1024 * 1024 * 2)
				imageTwo(nullable:true, maxSize: 1024 * 1024 * 2)
				imageThree(nullable:true, maxSize: 1024 * 1024 * 2)
				user(nullable:true)
				eventDate(nullable:true)
				eventLink(nullable:true, maxSize:500)
    }

        static mapping = {
                version false
				//sort createTime: "asc"
				//table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
