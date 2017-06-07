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
		System.out.println("inside checkout")
		App app = App.findByName("foodal")
		
		if (app != null) {
			addView(app, request.getRemoteAddr())
		}
	}

	def twitter() {
		System.out.println("inside twitter")
		log.info "inside twitter"
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
	
	def twitterUserData() {
		System.out.println("inside twitter user data: loggedIn!")
		log.info "inside twitter user data: loggedIn!"
		
		def searchResults = twitterService.search("#russiagate", session.twitter)
		
		log.info "searchResults Count = " + searchResults.size()
		
		render (view: "twitterUserData", bean: searchResults)
		//respond searchResults, model:[searchTerm: "#russiagate", searchCount:searchResults.size()]
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
