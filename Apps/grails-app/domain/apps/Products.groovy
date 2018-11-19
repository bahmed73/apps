package apps

class Products {

    //Long id
        Date createTime
        String name
        String description
        Date updateTime
        String scientificName
		String usage
		String other
		String packaging
		User user
		byte[] imageOne
		byte[] imageTwo
		byte[] imageThree

    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:false)
                scientificName(nullable:true)
				usage(nullable:true)
				other(nullable:true)
				packaging(nullable:true)
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
