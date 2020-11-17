package apps

class Book {

   //Long id
	Date createTime
	String name
	String subtitle
	String author
	String copyright
	String description
	Date updateTime
    User user
	byte[] imageOne
	byte[] imageTwo
	byte[] imageThree
	BlogCategory blogCategory
	
    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
				subtitle(nullable:false, maxSize:500)
				author(nullable:false, maxSize:500)
				copyright(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:false)
                user(nullable:false)
				imageOne(nullable:true, maxSize: 1024 * 1024 * 2)
				imageTwo(nullable:true, maxSize: 1024 * 1024 * 2)
				imageThree(nullable:true, maxSize: 1024 * 1024 * 2)
				blogCategory(nullable:false)
				
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
		
		static hasMany = [chapters:Chapter]
}
