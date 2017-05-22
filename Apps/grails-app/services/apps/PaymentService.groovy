package apps

import grails.transaction.Transactional
import com.stripe.model.*
import com.stripe.exception.*

@Transactional
class PaymentService {

	//Set Stripe Secret/Api Key
	def stripeSecret = "sk_test_5i1QWnJC2wtuzSZ9s4nUcpVU"
	def stripePublishable = "pk_test_VBLyN579809ToN0y2VA4VXG8"
	
    def serviceMethod() {

    }
	
	def charge(String stripeToken, Double amount) {
        def amountInCents = (amount * 100) as Integer

        def chargeParams = [
            'amount': amountInCents, 
            'currency': 'usd', 
            'card': stripeToken, 
            'description': 'bilal.ahmed@foodal.co'
        ]

        def status
        Charge chargeStatus
        try {
            chargeStatus = Charge.create(chargeParams)
            println chargeStatus
            status = 'Your purchase was successful.'
        } catch(CardException) {
            println status
            status = 'There was an error processing your credit card.'
        }

        return
    }
}
