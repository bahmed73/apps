package apps

class Notes {

    //Long id
        Date createTime
        String name
        String description
        Date updateTime
        byte[] imageOne
		byte[] imageTwo
		byte[] imageThree
		User user
		Tasks task

    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:false)
				imageOne(nullable:true, maxSize: 1024 * 1024 * 2)
				imageTwo(nullable:true, maxSize: 1024 * 1024 * 2)
				imageThree(nullable:true, maxSize: 1024 * 1024 * 2)
				user(nullable:false)
				task(nullable:false)
				
    }
}
