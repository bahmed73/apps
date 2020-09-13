package apps

import grails.transaction.Transactional
import com.stripe.model.*
import com.stripe.exception.*
import com.stripe.Stripe

@Transactional
class PaymentService {

	def stripeSecret = "sk_test_51HQzyoFM8FxBwW6pjKljoQhsYxgLEkf2iJdWX0EJIqN47m3Q0ufG5XLWL1WENvOKyuvVZBnI3nY4DUwWPlKMkRzv00Tyjf9McH"
	def stripePublishable = "pk_test_51HQzyoFM8FxBwW6pNugCzicxrTx4Eax2Sdy78JmHlY06183wr6m1Tg9Rl4gOQ41WMawHk4kLHhYmGKgLKijPXKVk002pPqfS3N"
	
	def stripeProductSecret = "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"
	def stripeProductPublisher = "pk_live_51HQzyoFM8FxBwW6pjn8JJjcSDSg7Zwud4UiVn0H7Opro8SO6W9sy7D5dbhg3AD85wwLGz3K0kUX5gETxAPkN8Ljm00UTOCcWIR"
	
    def serviceMethod() {

    }
	
	def charge(String stripeToken, Double amount) {
		System.out.println("payment service: stripe token = " + stripeToken)
		System.out.println("payment service: amount = " + amount)
		
		Stripe.apiKey = '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'
		
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
