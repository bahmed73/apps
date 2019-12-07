package apps

class CustomerFeedback {

   //Long id
        Date createTime
        String name
        String description
        Date updateTime
        User user
		Projects project
		Customer customer
		CustomerDevelopment customerDevelopment
		String question1 = "Metrics: How would you feel if you no longer used our product?"
		String question2 = "Recommendation: Have you recommended our product to anyone?"
		String question3 = "Referrer: How did you discover our product?"
		String question4 = "Alternatives: What product would you use, if ours is not available?"
		String question5 = "Benefits: What are the primary benefits, using our product?"
		String question6 = "Audience: What type of person would be using our product?"
		String question7 = "Improvement: How can we improve our product to meet your needs?"
		
    static constraints = {
                //id(nullable:true)
                createTime(nullable:false)
                name(nullable:false, maxSize:500)
                description(nullable:true, maxSize:50000)
                updateTime(nullable:false)
				user(nullable:false)
				project(nullable:false)
				customer(nullable:false)
				customerDevelopment(nullable:false)
				question1(nullable:false, maxSize:50000)
				question2(nullable:false, maxSize:50000)
				question3(nullable:false, maxSize:50000)
				question4(nullable:false, maxSize:50000)
				question5(nullable:false, maxSize:50000)
				question6(nullable:false, maxSize:50000)
				question7(nullable:false, maxSize:50000)
				
    }
}
