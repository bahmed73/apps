package apps

class Customer {

     //Long id
        Date createTime
        String name
        String address
		String phone
		String website
        Date updateTime
		User user
		CustomerDevelopment customerDevelopment
		String feedback


    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                address(nullable:true, maxSize:1000)
				phone(nullable:true, maxSize:100)
				website(nullable:true, maxSize:1000)
                updateTime(nullable:false)
				user(nullable:false)
				customerDevelopment(nullable:true)
				feedback(nullable:true, maxSize:50000)
    }

        static mapping = {
                version false
				//table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
