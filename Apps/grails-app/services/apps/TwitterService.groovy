package apps

import twitter4j.*
import twitter4j.http.*
import twitter4j.auth.*
import twitter4j.conf.*
import java.util.*

import grails.transaction.Transactional

@Transactional
class TwitterService {

	static public final int numberOfTweets = 50
	
    def serviceMethod() {

    }
	
	public def search(String term, Twitter twitter) {
		
		log.info "inside twitter.search: term = " + term
		
		List resultList = new ArrayList()
		
		Query query = new Query(term)
		query.setCount(numberOfTweets)
		
		def result = twitter.search(query)
		
		if (result != null) {
			
			List tweets = result.getTweets()
			tweets.each {tweet ->   
				
				//def tweetString = tweet.user.getScreenName() + "says " + tweet.getText() + " on " + tweet.getCreatedAt()
				
				
				def expandoObj = new Expando()
				expandoObj.userScreenName = tweet.user.getScreenName()
				expandoObj.text = tweet.getText()
				expandoObj.createdAt = tweet.getCreatedAt()
				expandoObj.userName = tweet.user.getName()
				expandoObj.userNumFollowers = tweet.user.getFollowersCount()
				expandoObj.userNumFollowing = tweet.user.getFriendsCount() 
				expandoObj.userLocation = tweet.user.getLocation()
				expandoObj.userMiniProfileURL = tweet.user.getMiniProfileImageURL()
				resultList.add(expandoObj)
				
				//resultList.add(tweetString)
			}
		}
		
		log.info "twitter.search count = " + resultList.size()
		
		return resultList
	}
	
	public def headline(Twitter twitter) {
		
		log.info "inside twitter.headline"
		
		List resultList = new ArrayList()
		
		def result = twitter.getUserTimeline("nytimes")
		result.addAll(twitter.getUserTimeline("cnn"))
		result.addAll(twitter.getUserTimeline("nypost"))
		result.addAll(twitter.getUserTimeline("rt_com"))
		result.addAll(twitter.getUserTimeline("xhnews"))
		result.addAll(twitter.getUserTimeline("moscowtimes"))
		result.addAll(twitter.getUserTimeline("foxnews"))
		
		if (result != null) {
			
			for (int i=0;i<result.size();i++) {
			
				def tweet = result.get(i)
				
				//def tweetString = tweet.user.getScreenName() + "says " + tweet.getText() + " on " + tweet.getCreatedAt()
				
				
				def expandoObj = new Expando()
				expandoObj.userScreenName = tweet.user.getScreenName()
				expandoObj.text = tweet.getText()
				expandoObj.createdAt = tweet.getCreatedAt()
				expandoObj.userName = tweet.user.getName()
				expandoObj.userNumFollowers = tweet.user.getFollowersCount()
				expandoObj.userNumFollowing = tweet.user.getFriendsCount()
				expandoObj.userLocation = tweet.user.getLocation()
				expandoObj.userMiniProfileURL = tweet.user.getMiniProfileImageURL()
				resultList.add(expandoObj)
				
				//resultList.add(tweetString)
			}
		}
		
		log.info "twitter.search count = " + resultList.size()
		
		return resultList
	}

}
