package apps

import grails.transaction.Transactional
import com.stripe.model.Charge
import com.stripe.exception.CardException

@Transactional
class PaymentService {

    def serviceMethod() {

    }
	
	def charge(String stripeToken, Double amount) {
        def amountInCents = (amount * 100) as Integer

        def chargeParams = [
            'amount': amountInCents, 
            'currency': 'usd', 
            'card': stripeToken, 
            'description': 'customer@sample.org'
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
