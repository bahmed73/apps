package apps

class PickupBook {

   //Long id
	Date createTime = new Date()
	Date updateTime = new Date()
    String pickupName
	String pickupPhone
	String pickupAddress
	String pickupEmail
	String pickupNote
	DonateBook donateBook
	
    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                updateTime(nullable:false)
                pickupName(nullable:false, maxSize:500)
				pickupPhone(nullable:false, maxSize:500)
				pickupAddress(nullable:false, maxSize:500)
				pickupEmail(nullable:false, maxSize:500)
				pickupNote(nullable:true, maxSize:100000)
				donateBook(nullable:false)
				
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
