package apps

import grails.transaction.Transactional
import com.stripe.model.*
import com.stripe.exception.*
import com.stripe.Stripe

@Transactional
class PaymentService {

	def stripeSecret = "sk_test_5i1QWnJC2wtuzSZ9s4nUcpVU"
	def stripePublishable = "pk_test_VBLyN579809ToN0y2VA4VXG8"
	
	def stripeProductSecret = "sk_live_JTBjE2udFzOGJpABo18JFSLR"
	def stripeProductPublisher = "pk_live_XG5V3QMNoSvnijnOBH1SRO2I"
	
    def serviceMethod() {

    }
	
	def charge(String stripeToken, Double amount) {
		System.out.println("payment service: stripe token = " + stripeToken)
		System.out.println("payment service: amount = " + amount)
		
		Stripe.apiKey = 'sk_live_yv77aXREWPsDHLZf8xgaOUjJ00TUXdfMYU'
		
		def amountInCents = (amount * 100) as Integer
		//test
		//stripeToken = "tok_amex"
		
        def chargeParams = [
            'amount': amountInCents, 
            'currency': 'usd', 
            'source': stripeToken, 
            'description': 'rob@thepromiserevealed.com'
        ]

        def status
        Charge chargeStatus
        try {
            chargeStatus = Charge.create(chargeParams)
            System.out.println("payment service: amount = " + chargeStatus)
		
            status = 'Your purchase was successful.'
			return true
        } catch(CardException ce) {
		ce.printStackTrace()
            println status
			status = 'There was an error processing your credit card.'
			return false
        } catch(Exception e) {
		e.printStackTrace()
            println status
            status = 'There was an error processing your credit card.'
			return false
        }

		System.out.println("Error processing stripe payment")
        return false
    }
	
	def homepageCheckout(params) {
		def checkout = new Checkout()
		checkout.createTime = new Date()
		checkout.stripeToken = params.stripeToken
		checkout.stripeEmail = params.stripeEmail
		checkout.stripeBillingName = params.stripeBillingName
		
		checkout.save flush:true
	}
	
	def productCheckout(params) {
		def checkout = new ProductCheckout()
		checkout.createTime = new Date()
		checkout.stripeToken = params.stripeToken
		checkout.stripeEmail = params.stripeEmail
		checkout.stripeBillingName = params.stripeBillingName
		
		checkout.save flush:true
	}
}
