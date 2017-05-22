package apps

class Checkout {

    //Long id
        Date createTime
        Products products
        String stripeToken
		Double amount
		
    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                products(nullable:false)
                stripeToken(nullable:false)
				amount(nullable:false)
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
