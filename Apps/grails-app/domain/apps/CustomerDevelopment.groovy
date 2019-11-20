package apps

class CustomerDevelopment {

    //Long id
        Date createTime
        String name
        String description
        Date updateTime
        User user
		Projects project
		String duration
		String priority
		Sprint sprint
		Backlog backlog
		String feedback
		
    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:false)
				user(nullable:false)
				project(nullable:false)
				duration(nullable:true, maxSize:500)
				priority(nullable:true, maxSize:500)
				sprint(nullable:true)
				backlog(nullable:true)
				feedback(nullable:true, maxSize:50000)
    }
}
