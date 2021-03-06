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
				expandoObj.id = tweet.getId()
				expandoObj.text = tweet.getText()
				expandoObj.createdAt = tweet.getCreatedAt()
				expandoObj.userName = tweet.user.getName()
				expandoObj.userNumFollowers = tweet.user.getFollowersCount()
				expandoObj.userNumFollowing = tweet.user.getFriendsCount() 
				expandoObj.userLocation = tweet.user.getLocation()
				expandoObj.userMiniProfileURL = tweet.user.getMiniProfileImageURL()
				addTweet(expandoObj)
				resultList.add(expandoObj)
				
				//resultList.add(tweetString)
			}
		}
		
		log.info "twitter.search count = " + resultList.size()
		
		return resultList
	}
	
	public def hillary(Twitter twitter) {
		
		def term = "@hillaryclinton @realdonaldtrump"
		log.info "inside twitter.search: term = " + term
		
		List resultList = new ArrayList()
		
		Query query = new Query(term)
		query.setCount(100)
		
		def result = twitter.search(query)
		
		if (result != null) {
			
			List tweets = result.getTweets()
			tweets.each {tweet ->
				
				//def tweetString = tweet.user.getScreenName() + "says " + tweet.getText() + " on " + tweet.getCreatedAt()
				
				
				def expandoObj = new Expando()
				expandoObj.userScreenName = tweet.user.getScreenName()
				expandoObj.id = tweet.getId()
				expandoObj.text = tweet.getText()
				expandoObj.createdAt = tweet.getCreatedAt()
				expandoObj.userName = tweet.user.getName()
				expandoObj.userNumFollowers = tweet.user.getFollowersCount()
				expandoObj.userNumFollowing = tweet.user.getFriendsCount()
				expandoObj.userLocation = tweet.user.getLocation()
				expandoObj.userMiniProfileURL = tweet.user.getMiniProfileImageURL()
				addTweet(expandoObj)
				resultList.add(expandoObj)
				
				//resultList.add(tweetString)
			}
		}
		
		log.info "twitter.hillary count = " + resultList.size()
		
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
				expandoObj.id = tweet.getId()
				expandoObj.text = tweet.getText()
				expandoObj.createdAt = tweet.getCreatedAt()
				expandoObj.userName = tweet.user.getName()
				expandoObj.userNumFollowers = tweet.user.getFollowersCount()
				expandoObj.userNumFollowing = tweet.user.getFriendsCount()
				expandoObj.userLocation = tweet.user.getLocation()
				expandoObj.userMiniProfileURL = tweet.user.getMiniProfileImageURL()
				addTweet(expandoObj)
				resultList.add(expandoObj)
				
				//resultList.add(tweetString)
			}
		}
		
		log.info "twitter.search count = " + resultList.size()
		
		return resultList
	}
	
	public def thiel(Twitter twitter) {
		
		log.info "inside twitter.thiel"
		
		List resultList = new ArrayList()
		
		def result = twitter.getUserTimeline("jebbush")
		result.addAll(twitter.getUserTimeline("fmanjoo"))
		result.addAll(twitter.getUserTimeline("ditzkoff"))
		
		if (result != null) {
			
			for (int i=0;i<result.size();i++) {
			
				def tweet = result.get(i)
				
				//def tweetString = tweet.user.getScreenName() + "says " + tweet.getText() + " on " + tweet.getCreatedAt()
				
				
				def expandoObj = new Expando()
				expandoObj.userScreenName = tweet.user.getScreenName()
				expandoObj.id = tweet.getId()
				expandoObj.text = tweet.getText()
				expandoObj.createdAt = tweet.getCreatedAt()
				expandoObj.userName = tweet.user.getName()
				expandoObj.userNumFollowers = tweet.user.getFollowersCount()
				expandoObj.userNumFollowing = tweet.user.getFriendsCount()
				expandoObj.userLocation = tweet.user.getLocation()
				expandoObj.userMiniProfileURL = tweet.user.getMiniProfileImageURL()
				addTweet(expandoObj)
				resultList.add(expandoObj)
				
				//resultList.add(tweetString)
			}
		}
		
		log.info "twitter.thiel count = " + resultList.size()
		
		return resultList
	}
	
	public def trump(Twitter twitter) {
		
		log.info "inside twitter.trump"
		
		List resultList = new ArrayList()
		
		def result = twitter.getUserTimeline("nytimes")
		result.addAll(twitter.getUserTimeline("cnn"))
		result.addAll(twitter.getUserTimeline("nypost"))
		result.addAll(twitter.getUserTimeline("rt_com"))
		result.addAll(twitter.getUserTimeline("xhnews"))
		result.addAll(twitter.getUserTimeline("moscowtimes"))
		result.addAll(twitter.getUserTimeline("foxnews"))
		result.addAll(twitter.getUserTimeline("bpolitics"))
		result.addAll(twitter.getUserTimeline("polito"))
		
		if (result != null) {
			
			for (int i=0;i<result.size();i++) {
			
				def tweet = result.get(i)
				def text = tweet.getText().toLowerCase()
				
				if (text.contains("trump") == true) {
				
					def expandoObj = new Expando()
					expandoObj.userScreenName = tweet.user.getScreenName()
					expandoObj.id = tweet.getId()
					expandoObj.text = tweet.getText()
					expandoObj.createdAt = tweet.getCreatedAt()
					expandoObj.userName = tweet.user.getName()
					expandoObj.userNumFollowers = tweet.user.getFollowersCount()
					expandoObj.userNumFollowing = tweet.user.getFriendsCount()
					expandoObj.userLocation = tweet.user.getLocation()
					expandoObj.userMiniProfileURL = tweet.user.getMiniProfileImageURL()
					addTweet(expandoObj)
					resultList.add(expandoObj)
				}
				
				//resultList.add(tweetString)
			}
		}
		
		log.info "twitter.search count = " + resultList.size()
		
		return resultList
	}

	public def venture(Twitter twitter) {
		
		log.info "inside twitter.venture"
		
		List resultList = new ArrayList()
		
		def result = twitter.getUserTimeline("founding")
		result.addAll(twitter.getUserTimeline("foundersspace"))
		result.addAll(twitter.getUserTimeline("angellist"))
		result.addAll(twitter.getUserTimeline("ycombinator"))
		result.addAll(twitter.getUserTimeline("a16z"))
		result.addAll(twitter.getUserTimeline("500startups"))
		result.addAll(twitter.getUserTimeline("sfnewtech"))
		result.addAll(twitter.getUserTimeline("sfbeta"))
		result.addAll(twitter.getUserTimeline("leanstartup"))
		result.addAll(twitter.getUserTimeline("thestartupbook_"))
		result.addAll(twitter.getUserTimeline("thevcbook"))
		result.addAll(twitter.getUserTimeline("thesocialbook_"))
		result.addAll(twitter.getUserTimeline("thefounderbook"))
		result.addAll(twitter.getUserTimeline("theenthandbook"))
		
		if (result != null) {
			
			for (int i=0;i<result.size();i++) {
			
				def tweet = result.get(i)
				
				//def tweetString = tweet.user.getScreenName() + "says " + tweet.getText() + " on " + tweet.getCreatedAt()
				
				
				def expandoObj = new Expando()
				expandoObj.userScreenName = tweet.user.getScreenName()
				expandoObj.id = tweet.getId()
				expandoObj.text = tweet.getText()
				expandoObj.createdAt = tweet.getCreatedAt()
				expandoObj.userName = tweet.user.getName()
				expandoObj.userNumFollowers = tweet.user.getFollowersCount()
				expandoObj.userNumFollowing = tweet.user.getFriendsCount()
				expandoObj.userLocation = tweet.user.getLocation()
				expandoObj.userMiniProfileURL = tweet.user.getMiniProfileImageURL()
				addTweet(expandoObj)
				resultList.add(expandoObj)
				
				//resultList.add(tweetString)
			}
		}
		
		log.info "twitter.venture count = " + resultList.size()
		
		return resultList
	}
	
	public def entertainment(Twitter twitter) {
		
		log.info "inside twitter.entertainment"
		
		List resultList = new ArrayList()
		
		def result = twitter.getUserTimeline("snoopdogg")
		result.addAll(twitter.getUserTimeline("diddy"))
		result.addAll(twitter.getUserTimeline("hillaryclinton"))
		result.addAll(twitter.getUserTimeline("barackobama"))
		result.addAll(twitter.getUserTimeline("siliconhbo"))
		result.addAll(twitter.getUserTimeline("whoismrrobot"))
		result.addAll(twitter.getUserTimeline("god"))
		result.addAll(twitter.getUserTimeline("jesus"))
		result.addAll(twitter.getUserTimeline("funnyordie"))
		
		if (result != null) {
			
			for (int i=0;i<result.size();i++) {
			
				def tweet = result.get(i)
				
				//def tweetString = tweet.user.getScreenName() + "says " + tweet.getText() + " on " + tweet.getCreatedAt()
				
				
				def expandoObj = new Expando()
				expandoObj.userScreenName = tweet.user.getScreenName()
				expandoObj.id = tweet.getId()
				expandoObj.text = tweet.getText()
				expandoObj.createdAt = tweet.getCreatedAt()
				expandoObj.userName = tweet.user.getName()
				expandoObj.userNumFollowers = tweet.user.getFollowersCount()
				expandoObj.userNumFollowing = tweet.user.getFriendsCount()
				expandoObj.userLocation = tweet.user.getLocation()
				expandoObj.userMiniProfileURL = tweet.user.getMiniProfileImageURL()
				addTweet(expandoObj)
				resultList.add(expandoObj)
				
				//resultList.add(tweetString)
			}
		}
		
		log.info "twitter.entertainment count = " + resultList.size()
		
		return resultList
	}
	
	public def defense(Twitter twitter) {
		
		log.info "inside twitter.defense"
		
		List resultList = new ArrayList()
		
		def result = twitter.getUserTimeline("gendavegoldfein")
		result.addAll(twitter.getUserTimeline("usairforce"))
		result.addAll(twitter.getUserTimeline("pacaf"))
		result.addAll(twitter.getUserTimeline("nasa"))
		result.addAll(twitter.getUserTimeline("deptofdefense"))
		result.addAll(twitter.getUserTimeline("airmobilitycmd"))
		result.addAll(twitter.getUserTimeline("usaf_acc"))
		result.addAll(twitter.getUserTimeline("us_stratcom"))
		result.addAll(twitter.getUserTimeline("thejointstaff"))
		result.addAll(twitter.getUserTimeline("lockheedmartin"))
		result.addAll(twitter.getUserTimeline("cjtfoir"))
		result.addAll(twitter.getUserTimeline("af_academy"))
		result.addAll(twitter.getUserTimeline("usnato"))
		result.addAll(twitter.getUserTimeline("afspace"))
		result.addAll(twitter.getUserTimeline("space_station"))
		result.addAll(twitter.getUserTimeline("pacificcommand"))
		
		if (result != null) {
			
			for (int i=0;i<result.size();i++) {
			
				def tweet = result.get(i)
				
				//def tweetString = tweet.user.getScreenName() + "says " + tweet.getText() + " on " + tweet.getCreatedAt()
				
				
				def expandoObj = new Expando()
				expandoObj.userScreenName = tweet.user.getScreenName()
				expandoObj.id = tweet.getId()
				expandoObj.text = tweet.getText()
				expandoObj.createdAt = tweet.getCreatedAt()
				expandoObj.userName = tweet.user.getName()
				expandoObj.userNumFollowers = tweet.user.getFollowersCount()
				expandoObj.userNumFollowing = tweet.user.getFriendsCount()
				expandoObj.userLocation = tweet.user.getLocation()
				expandoObj.userMiniProfileURL = tweet.user.getMiniProfileImageURL()
				addTweet(expandoObj)
				resultList.add(expandoObj)
				
				//resultList.add(tweetString)
			}
		}
		
		log.info "twitter.defense count = " + resultList.size()
		
		return resultList
	}
	
	public def yoga(Twitter twitter) {
		
		log.info "inside twitter.yoga"
		
		List resultList = new ArrayList()
		
		def result = twitter.getUserTimeline("thesecretbookom")
		result.addAll(twitter.getUserTimeline("thesacredbookom"))
		result.addAll(twitter.getUserTimeline("thegurubook"))
		result.addAll(twitter.getUserTimeline("thecookbookom"))
		result.addAll(twitter.getUserTimeline("thegodbook_"))
		result.addAll(twitter.getUserTimeline("nadabinduguru"))
		result.addAll(twitter.getUserTimeline("jnanayogaguru"))
		result.addAll(twitter.getUserTimeline("sadhanaguru"))
		result.addAll(twitter.getUserTimeline("astralyogaguru"))
		result.addAll(twitter.getUserTimeline("koranguru"))
		
		if (result != null) {
			
			for (int i=0;i<result.size();i++) {
			
				def tweet = result.get(i)
				
				//def tweetString = tweet.user.getScreenName() + "says " + tweet.getText() + " on " + tweet.getCreatedAt()
				
				
				def expandoObj = new Expando()
				expandoObj.userScreenName = tweet.user.getScreenName()
				expandoObj.id = tweet.getId()
				expandoObj.text = tweet.getText()
				expandoObj.createdAt = tweet.getCreatedAt()
				expandoObj.userName = tweet.user.getName()
				expandoObj.userNumFollowers = tweet.user.getFollowersCount()
				expandoObj.userNumFollowing = tweet.user.getFriendsCount()
				expandoObj.userLocation = tweet.user.getLocation()
				expandoObj.userMiniProfileURL = tweet.user.getMiniProfileImageURL()
				addTweet(expandoObj)
				resultList.add(expandoObj)
				
				//resultList.add(tweetString)
			}
		}
		
		log.info "twitter.yoga count = " + resultList.size()
		
		return resultList
	}
	
	public def retweet(tweetId, twitter) {
		
		log.info "inside twitter.retweet"
		
		twitter.retweetStatus(Long.valueOf(tweetId))
	}
	
	public def mention(userName, twitter) {
		
		log.info "inside twitter.mention"
		
		twitter.updateStatus(".@"+userName+" would love to connect for #agiledevelopment and #leanstartup - #customerdevelopment. Contact us please.")
	}
	
	public def favorite(tweetId, twitter) {
		
		log.info "inside twitter.favorite"
		
		twitter.createFavorite(Long.valueOf(tweetId))
	}
	
	def addTweet(expando) {
		
		def tweet = new Tweet()
		
		tweet.userScreenName = expando.userScreenName
		tweet.tweetId = expando.id
		tweet.tweettText = expando.text
		tweet.createdAt = expando.createdAt
		tweet.userName = expando.userName
		tweet.followersCount = expando.userNumFollowers
		tweet.friendsCount = expando.userNumFollowing
		tweet.location = expando.userLocation
		tweet.miniProfileImageURL = expando.userMiniProfileURL
		
		tweet.save flush:true
	}
	
	def addTweet(userScreenName, tweetId, tweettText, createdAt, userName, followersCount, friendsCount, location, miniProfileImageURL) {
		
		def tweet = new Tweet()
		
		tweet.userScreenName = userScreenName
		tweet.tweetId = tweetId 
		tweet.tweettText = tweettText 
		tweet.createdAt = createdAt 
		tweet.userName = userName
		tweet.followersCount = followersCount
		tweet.friendsCount = friendsCount
		tweet.location = location
		tweet.miniProfileImageURL = miniProfileImageURL
		
		tweet.save flush:true
	}
}
