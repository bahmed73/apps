package apps

class ProductView {

    //Long id
        Integer status
        Date createTime
        String ip
        Products products
		User user

    static constraints = {
                //id(nullable:true)
                status(nullable:false)
                createTime(nullable:false)
                ip(nullable:false, maxSize:20)
                products(nullable:false)
				user(nullable:false)
    }

        static mapping = {
                version false
                //table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
