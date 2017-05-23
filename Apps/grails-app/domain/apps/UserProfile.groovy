package apps

class UserProfile {

    //Long id
        Date createTime
        User user
		String firstName
		String lastName
		String email
		String address
		String website
		String facebook
		String twitter
		String phone
		String subscription

    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                user(nullable:false)
				firstName(nullable:true)
				lastName(nullable:true)
				email(nullable:true)
				address(nullable:true)
				website(nullable:true)
				facebook(nullable:true)
				twitter(nullable:true)
				phone(nullable:true)
				subscription(nullable:true)
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
