package apps

class Tasks {

    //Long id
        Date createTime
        String name
        String description
        Date updateTime
        byte[] imageOne
		byte[] imageTwo
		byte[] imageThree
		User user
		Projects project
		String duration
		String priority
		Sprint sprint
		Backlog backlog

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
				project(nullable:false)
				duration(nullable:true, maxSize:500)
				priority(nullable:true, maxSize:500)
				sprint(nullable:true)
				backlog(nullable:true)
				
    }
}
