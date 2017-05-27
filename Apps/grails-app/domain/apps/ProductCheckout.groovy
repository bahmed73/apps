package apps

class ProductCheckout {

    //Long id
        Date createTime
        String stripeToken
		String stripeEmail
		String stripeBillingName
		
		
    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                stripeToken(nullable:false)
				stripeEmail(nullable:true)
				stripeBillingName(nullable:true)
				
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
