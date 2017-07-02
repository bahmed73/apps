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
		Stripe.apiKey = "sk_test_5i1QWnJC2wtuzSZ9s4nUcpVU"
		
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
