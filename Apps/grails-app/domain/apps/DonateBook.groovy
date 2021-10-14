package apps

class DonateBook {

   //Long id
	Date createTime = new Date()
	String name
	String subtitle
	String author
	String description
	Date updateTime = new Date()
    byte[] imageOne
	byte[] imageTwo
	byte[] imageThree
	String ownerName
	String ownerPhone
	String ownerAddress
	String ownerEmail
	
    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
				subtitle(nullable:false, maxSize:500)
				author(nullable:false, maxSize:500)
				description(nullable:true, maxSize:100000)
                updateTime(nullable:false)
                imageOne(nullable:true, maxSize: 1024 * 1024 * 2)
				imageTwo(nullable:true, maxSize: 1024 * 1024 * 2)
				imageThree(nullable:true, maxSize: 1024 * 1024 * 2)
				ownerName(nullable:false, maxSize:500)
				ownerPhone(nullable:false, maxSize:500)
				ownerAddress(nullable:false, maxSize:500)
				ownerEmail(nullable:false, maxSize:500)
				
				
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
