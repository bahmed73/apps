package apps

class Tweet {

	String userScreenName
	String tweetId
	String tweettText
	String createdAt
	String userName
	String followersCount
	String friendsCount
	String location
	String miniProfileImageURL
	
	static constraints = {
		//id(nullable:true)
		userScreenName(nullable:false)
		tweetId(nullable:false)
		tweetText(nullable:false)
		createdAt(nullable:false)
		userName(nullable:false)
		followersCount(nullable:false)
		friendsCount(nullable:false)
		location(nullable:false)
		miniProfileImageURL(nullable:false, maxSize:2048)
	}
	
    static mapping = {
                version false
				//table 'question'
                //id generator:'sequence', params:[sequence:'question_seq']
        }
}
