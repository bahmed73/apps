package apps

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import twitter4j.*
import twitter4j.auth.*

import grails.plugin.springsecurity.annotation.Secured
@Secured('ROLE_ADMIN')

class ProductController {

	static scope = 'session'
	
	def springSecurityService
	def twitterService
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	static final String consumerKey = "qq1Mr7tLmzDSsUcGtBZmvM35d"
	static final String consumerSecret = "huFnBilI98zuGZH4IicZsWOgs7w2b2OHJ9NtQhtedTkZ3XrLzM"
	
	
    def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond AppType.list(params), model:[appTypeCount: AppType.count()]
		/*System.out.println("1")
		
        params.max = Math.min(max ?: 10, 100)
		System.out.println("2")
		
		def productViews = ProductView.findAll()
		System.out.println("3: productViews = " + productViews)
		
		
		def productList2 = Product.list(params)
		System.out.println("4: productList2 = " + productList2)
		
		def test="test"
		
        respond Product.list(params), model:[productCount: Product.count(), productViews: productViews, productList2: productList2, test:test]
        */
    }

	
	def premium() {
		log.info "inside premium"
	}
	
	def help() {
		log.info "inside help"
	}
	
	def loop() {
		System.out.println("inside loop")
		log.info "inside loop"
	}
	
	def mom() {
		System.out.println("inside mom")
		log.info "inside mom"
	}
	
	def dad() {
		System.out.println("inside dad")
		log.info "inside dad"
	}
	
	def demo() {
		System.out.println("inside demo")
		log.info "inside demo"
	}
	
	def demo2() {
		System.out.println("inside demo2")
		log.info "inside demo2"
	}
	
	def demo3() {
		System.out.println("inside demo3")
		log.info "inside demo3"
	}
	
	def demo4() {
		System.out.println("inside demo4")
		log.info "inside demo4"
	}
	
	def demo5() {
		System.out.println("inside demo5")
		log.info "inside demo5"
	}
	
	def demo6() {
		System.out.println("inside demo6")
		log.info "inside demo6"
	}
	
	def male() {
		System.out.println("inside male")
		log.info "inside male"
	}
	
	def female() {
		System.out.println("inside female")
		log.info "inside female"
	}
	
	def seller() {
		log.info "inside seller"
		
		System.out.println("from stripe?" + params)
		
		if (params.stripeToken != null) {
			redirect controller:"register"
		}
	}
	
	@Secured('IS_AUTHENTICATED_ANONYMOUSLY')
	def mytweetmark() {
		log.info "inside mytweetmark"
		
		System.out.println("from stripe?" + params)
		
		if (params.stripeToken != null) {
			redirect uri:"http://www.mytweetmark.com"
		}
	}
	
	@Secured('IS_AUTHENTICATED_ANONYMOUSLY')
	def homecookme() {
		log.info "inside homecookme"
		
		System.out.println("from stripe?" + params)
		
		if (params.stripeToken != null) {
			redirect uri:"http://www.homecook.me"
		}
	}
	
	def listing() {
		System.out.println("listing")
		def user = springSecurityService.currentUser
		System.out.println("username = " + user.username)
		
		def productRefererList = ProductReferer.findAllByUser(user)
		def productRefererInstanceTotal = ProductReferer.countByUser(user)
		def productRefererInstanceList = ProductReferer.findAllByUser(user)
		
		def productRefererMap
		
		if (productRefererList != null && !productRefererList.isEmpty()) {
			System.out.println("we have referers")
			productRefererMap = new HashMap<String, Integer>()
			for (int i=0; i<productRefererList.size(); i++ ) {
					def referer
					if (productRefererList.get(i).referer.contains("http://")) {
							referer = productRefererList.get(i).referer.substring(7)
					}

					def index = referer.indexOf('/')

					if (index > 0) {
							referer = referer.substring(0, index)
					}

					if (productRefererMap.get(referer)!=null) {
							//exists, increment count
							def countRef = productRefererMap.get(referer)
							productRefererMap.remove(referer)
							productRefererMap.put(referer, countRef+1)
					} else {
							productRefererMap.put(referer, 1)
					}
			}
		}
		System.out.println("productRefererMap = " + productRefererMap.size())
		System.out.println("productRefererInstanceTotal = " + productRefererInstanceTotal)
		System.out.println("productRefererInstanceList = " + productRefererInstanceList.size())
		//respond productRefererMap, model:[productRefererMap: productRefererMap, productRefererInstanceTotal: productRefererInstanceTotal, productRefererInstanceList: productRefererInstanceList]
	}
	
    def show(Product product) {
		addProductView(product, request.getRemoteAddr())
        respond product
    }

    def create() {
        respond new Product(params)
    }
	
	def shelf() {
		App app = App.findByName("foodal")
		 
		if (app != null) {
			addView(app, request.getRemoteAddr())
		}
	}
	
	def analytics() {
		System.out.println("inside analytics")
		App app = App.findByName("foodal")
		
		if (app != null) {
			addView(app, request.getRemoteAddr())
		}
	}
	
	def checkout() {
		log.info "inside checkout"
		App app = App.findByName("foodal")
		
		if (app != null) {
			addView(app, request.getRemoteAddr())
		}
	}

	def twitter() {
		System.out.println("inside twitter")
		log.info "inside twitter"
	}
	
	def software() {
		System.out.println("inside software")
		log.info "inside software"
	}
	
	def twitterLoggedIn() {
		System.out.println("inside twitter loggedin")
		log.info "inside twitter logged in"
		
		try {
			Twitter twitter = new TwitterFactory().getInstance()
			twitter.setOAuthConsumer(consumerKey, consumerSecret)
			RequestToken requestToken = twitter.getOAuthRequestToken()
			
			System.out.println("inside twitter loggedIn!: requestToken  = " + requestToken)
			log.info "inside twitter user data: loggedIn! requestToken = " + requestToken
			
			session.token = requestToken.getToken()
			session.tokenSecret = requestToken.getTokenSecret()
			session.twitter = twitter
			session.requestToken = requestToken
			redirect(url:requestToken.getAuthorizationURL())
			
		} catch (Exception e) {
			System.out.println("Caught exception in Twitter login: " + e.getMessage())
			log.info "Caught exception in Twitter login: " + e.getMessage()
		}
		
		
	}
	
	@Transactional
	def twitterTrump() {
		System.out.println("inside twitter trump: loggedIn!")
		log.info "inside twitter trump: loggedIn!"
		
		def searchResults = twitterService.trump(session.twitter)
		
		session.searchResults = searchResults
		
		//render (view: "twitterUserData", bean: searchResults)
		respond searchResults, model:[searchCount:searchResults.size()]
	}
	
	@Transactional
	def twitterHillary() {
		System.out.println("inside twitter hillary: loggedIn!")
		log.info "inside twitter hillary: loggedIn!"
		
		def searchResults = twitterService.hillary(session.twitter)
		
		session.searchResults = searchResults
		
		//render (view: "twitterUserData", bean: searchResults)
		respond searchResults, model:[searchCount:searchResults.size()]
	}
	
	@Transactional
	def twitterThiel() {
		System.out.println("inside twitter thiel: loggedIn!")
		log.info "inside twitter thiel: loggedIn!"
		
		def searchResults = twitterService.thiel(session.twitter)
		
		session.searchResults = searchResults
		
		//render (view: "twitterUserData", bean: searchResults)
		respond searchResults, model:[searchCount:searchResults.size()]
	}

	
	@Transactional
	def twitterHeadline() {
		System.out.println("inside twitter headline: loggedIn!")
		log.info "inside twitter headline: loggedIn!"
		
		def searchResults = twitterService.headline(session.twitter)
		
		session.searchResults = searchResults
		
		//render (view: "twitterUserData", bean: searchResults)
		respond searchResults, model:[searchCount:searchResults.size()]
	}
	
	@Transactional
	def twitterVenture() {
		System.out.println("inside twitter venture: loggedIn!")
		log.info "inside twitter venture: loggedIn!"
		
		def searchResults = twitterService.venture(session.twitter)
		
		session.searchResults = searchResults
		
		//render (view: "twitterUserData", bean: searchResults)
		respond searchResults, model:[searchCount:searchResults.size()]
	}
	
	@Transactional
	def twitterEntertainment() {
		System.out.println("inside twitter entertainment: loggedIn!")
		log.info "inside twitter entertainment: loggedIn!"
		
		def searchResults = twitterService.entertainment(session.twitter)
		
		session.searchResults = searchResults
		
		//render (view: "twitterUserData", bean: searchResults)
		respond searchResults, model:[searchCount:searchResults.size()]
	}
	
	@Transactional
	def twitterDefense() {
		System.out.println("inside twitter defense: loggedIn!")
		log.info "inside twitter defense: loggedIn!"
		
		def searchResults = twitterService.defense(session.twitter)
		
		session.searchResults = searchResults
		
		//render (view: "twitterUserData", bean: searchResults)
		respond searchResults, model:[searchCount:searchResults.size()]
	}
	
	@Transactional
	def twitterYoga() {
		System.out.println("inside twitter yoga: loggedIn!")
		log.info "inside twitter yoga: loggedIn!"
		
		def searchResults = twitterService.yoga(session.twitter)
		
		session.searchResults = searchResults
		
		//render (view: "twitterUserData", bean: searchResults)
		respond searchResults, model:[searchCount:searchResults.size()]
	}
	
	@Transactional
	def twitterUserData() {
		System.out.println("inside twitter user data: loggedIn!")
		log.info "inside twitter user data: loggedIn!"
		
		def searchResults = twitterService.search("#russiagate", session.twitter)
		
		session.searchTerm = "#russiagate"
		session.searchResults = searchResults
		
		//render (view: "twitterUserData", bean: searchResults)
		respond searchResults, model:[searchTerm: "#russiagate", searchCount:searchResults.size()]
	}
	
	@Transactional
	def twitterg20() {
		System.out.println("inside twitter g20: loggedIn!")
		log.info "inside twitter g20: loggedIn!"
		
		def searchResults = twitterService.search("#g20", session.twitter)
		
		session.searchTerm = "#g20"
		session.searchResults = searchResults
		
		//render (view: "twitterUserData", bean: searchResults)
		respond searchResults, model:[searchTerm: "#g20", searchCount:searchResults.size()]
	}
	
	@Transactional
	def twitterBrics() {
		System.out.println("inside twitter brics: loggedIn!")
		log.info "inside twitter brics: loggedIn!"
		
		def searchResults = twitterService.search("#brics", session.twitter)
		
		session.searchTerm = "#brics"
		session.searchResults = searchResults
		
		//render (view: "twitterUserData", bean: searchResults)
		respond searchResults, model:[searchTerm: "#brics", searchCount:searchResults.size()]
	}
	
	@Transactional
	def twitterPanamaPapers() {
		System.out.println("inside twitter panama papers: loggedIn!")
		log.info "inside twitter panama papers: loggedIn!"
		
		def searchResults = twitterService.search("#panamapapers", session.twitter)
		
		session.searchTerm = "#panamapapers"
		session.searchResults = searchResults
		
		//render (view: "twitterUserData", bean: searchResults)
		respond searchResults, model:[searchTerm: "#panamapapers", searchCount:searchResults.size()]
	} 
	
	def retweet() {
	
		if (params.id != null) {
			System.out.println("inside twitter retweet!")
			log.info "inside twitter retweet"
			twitterService.retweet(params.id, session.twitter)
		}
		
		redirect(uri: request.getHeader('referer') )
	}
	
	def favorite() {
		
		if (params.id != null) {
			System.out.println("inside twitter favorite")
			log.info "inside twitter favorite"
			twitterService.favorite(params.id, session.twitter)
		}
		redirect(uri: request.getHeader('referer') )
	}
	
	def requestLogin = {
		System.out.println("inside requestLogin")
		log.info "inside requestLogin"
	}
	
	def processLogin = {
		System.out.println("inside processLogin")
		log.info "inside processLogin"
		
		if (!session.requestToken) {
			flash.message = "User twitter request token not available.";
			session.requestToken = null
			session.twitter = null
			redirect(uri:"/")
			return
		} else {
			System.out.println("requestToken = " + session.requestToken)
			log.info "requestToken = "+ session.requestToken
			try {
				AccessToken accessToken = session.twitter.getOAuthAccessToken(session.requestToken, params.oauth_verifier)
				
				System.out.println("accessToken = " + accessToken)
				log.info "accessToken = "+ accessToken
				
				def twitterUser = session.twitter.verifyCredentials()
				
				System.out.println("user is authenticated = " + twitterUser)
				log.info "user is authenticated = "+ twitterUser
				
				redirect(action:"twitterUserData")

			} catch (Exception e) {
				System.out.println("Caught exception in processLogin: " + e.getMessage())
				log.info "Caught exception in processLogin: " + e.getMessage()
			}
		}
	}
	
    @Transactional
    def save(Product product) {
        if (product == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (product.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond product.errors, view:'create'
            return
        }

        product.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'product.label', default: 'Product'), product.id])
                redirect product
            }
            '*' { respond product, [status: CREATED] }
        }
    }

    def edit(Product product) {
        respond product
    }

    @Transactional
    def update(Product product) {
        if (product == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (product.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond product.errors, view:'edit'
            return
        }

        product.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'product.label', default: 'Product'), product.id])
                redirect product
            }
            '*'{ respond product, [status: OK] }
        }
    }

    @Transactional
    def delete(Product product) {

        if (product == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        product.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'product.label', default: 'Product'), product.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
	protected void addView(App app, String ip) {
		def view = new View()
		view.status = 1
		view.app = app
		view.createTime = new Date()
		view.ip = ip
		
		view.save flush:true
	}
	
	protected void addProductView(Product product, String ip) {
		def view = new ProductView()
		view.status = 1
		view.product = product
		view.createTime = new Date()
		view.ip = ip
		
		view.save flush:true
	}
}
