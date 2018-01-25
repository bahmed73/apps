package apps

class School {

    //Long id
    Date createTime
    String schoolName
    String description
    Date updateTime
    String schoolAddress
	String schoolAddress2
	String city
	String state
	String country
	User user
	byte[] imageOne
	byte[] imageTwo
	byte[] imageThree

    static constraints = {
        //id(nullable:true)
        createTime(nullable:false)
        schoolName(nullable:false, maxSize:500)
        description(nullable:true, maxSize:50000)
        updateTime(nullable:false)
        schoolAddress(nullable:true)
		schoolAddress2(nullable:true)
		city(nullable:false)
		state(nullable:true)
		country(nullable:true)
		user(nullable:false)
		imageOne(nullable:true, maxSize: 1024 * 1024 * 2)
		imageTwo(nullable:true, maxSize: 1024 * 1024 * 2)
		imageThree(nullable:true, maxSize: 1024 * 1024 * 2)
    }

    static mapping = {
        version false
		//table 'question'
        //id generator:'sequence', params:[sequence:'question_seq']
    }
}
