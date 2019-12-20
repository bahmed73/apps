package apps

class Documentation {

    //Long id
        Date createTime
        String name
        String description
        Date updateTime
		String filename
		byte[] testBytes
		User user

    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:false)
				filename(nullable:true)
				testBytes(nullable:true, maxSize: 1073741824)
				user(nullable:true)
    }
}
