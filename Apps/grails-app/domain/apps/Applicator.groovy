package apps

class Applicator {

    //Long id
        Date createTime
        String name
        String address
		String phone
		String website
        Date updateTime


    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                address(nullable:true, maxSize:1000)
				phone(nullable:true, maxSize:100)
				website(nullable:true, maxSize:1000)
                updateTime(nullable:false)
    }

        static mapping = {
                version false
				//table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
