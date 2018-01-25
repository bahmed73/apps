package apps

class Student {

    //Long id
    Date createTime
    String studentName
    String description
    Date updateTime
    String skill1
	String skill2
	String skill3
	String skill4
	String skill5
	User user
	byte[] imageOne
	byte[] imageTwo
	byte[] imageThree

    static constraints = {
        //id(nullable:true)
        createTime(nullable:false)
        studentName(nullable:false, maxSize:500)
        description(nullable:true, maxSize:50000)
        updateTime(nullable:false)
        skill1(nullable:true)
		skill2(nullable:true)
		skill3(nullable:true)
		skill4(nullable:true)
		skill5(nullable:true)
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
