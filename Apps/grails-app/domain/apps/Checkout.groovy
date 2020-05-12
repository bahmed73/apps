package apps

class Checkout {

    //Long id
        Date createTime = new Date()
        String shoppingCart = ""
		String userName
		String emailAddress
		String address
		String phoneNumber
		String amount
		String paymentToken
		Boolean usePaypal = false
		Boolean sameAddress = false
		Boolean domesticShipment = true
		Boolean internationalShipment = false
		String stripeToken = ""
		String stripeEmail = "stripe_email"
		String stripeBillingName = "stripe_billing_name"
		
    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
				shoppingCart(nullable:true)
                userName(nullable:false)
				emailAddress(nullable:false)
				address(nullable:false)
				phoneNumber(nullable:false)
				amount(nullable:false)
				paymentToken(nullable:true)
				usePaypal(nullable:false)
				sameAddress(nullable:false)
				domesticShipment(nullable:false)
				internationalShipment(nullable:false)
				stripeToken(nullable:false)
				stripeEmail(nullable:false)
				stripeBillingName(nullable:false)
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
