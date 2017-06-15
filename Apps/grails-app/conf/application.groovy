

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'apps.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'apps.UserRole'
grails.plugin.springsecurity.authority.className = 'apps.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern: '/product/twitter',        access: ['permitAll']],
	[pattern: '/product/twitterLoggedIn',access: ['permitAll']],
	[pattern: '/product/twitterUserData',access: ['permitAll']],
	[pattern: '/product/twitterg20',access: ['permitAll']],
	[pattern: '/product/twitterBrics',access: ['permitAll']],
	[pattern: '/product/twitterPanamaPapers',access: ['permitAll']],
	[pattern: '/product/twitterHeadline',access: ['permitAll']],
	[pattern: '/product/twitterTrump',access: ['permitAll']],
	[pattern: '/product/twitterVenture',access: ['permitAll']],
	[pattern: '/product/twitterEntertainment',access: ['permitAll']],
	[pattern: '/product/twitterDefense',access: ['permitAll']],
	[pattern: '/product/twitterYoga',access: ['permitAll']],
	[pattern: '/product/twitterHillary',access: ['permitAll']],
	[pattern: '/product/twitterThiel',access: ['permitAll']],
	[pattern: '/product/retweet',access: ['permitAll']],
	[pattern: '/product/favorite',access: ['permitAll']],
	[pattern: '/tweet/index',access: ['permitAll']],
	[pattern: '/tweet/show',access: ['permitAll']],
	[pattern: '/product/premium',access: ['permitAll']],
	[pattern: '/product/processLogin',access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]



// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'apps.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'apps.UserRole'
grails.plugin.springsecurity.authority.className = 'apps.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern: '/product/twitter',        access: ['permitAll']],
	[pattern: '/product/twitterLoggedIn',access: ['permitAll']],
	[pattern: '/product/twitterUserData',access: ['permitAll']],
	[pattern: '/product/twitterg20',access: ['permitAll']],
	[pattern: '/product/twitterBrics',access: ['permitAll']],
	[pattern: '/product/twitterPanamaPapers',access: ['permitAll']],
	[pattern: '/product/twitterHeadline',access: ['permitAll']],
	[pattern: '/product/twitterTrump',access: ['permitAll']],
	[pattern: '/product/twitterVenture',access: ['permitAll']],
	[pattern: '/product/twitterEntertainment',access: ['permitAll']],
	[pattern: '/product/twitterDefense',access: ['permitAll']],
	[pattern: '/product/twitterYoga',access: ['permitAll']],
	[pattern: '/product/twitterHillary',access: ['permitAll']],
	[pattern: '/product/twitterThiel',access: ['permitAll']],
	[pattern: '/product/retweet',access: ['permitAll']],
	[pattern: '/product/favorite',access: ['permitAll']],
	[pattern: '/tweet/index',access: ['permitAll']],
	[pattern: '/tweet/show',access: ['permitAll']],
	[pattern: '/product/premium',access: ['permitAll']],
	[pattern: '/product/processLogin',access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]



// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'apps.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'apps.UserRole'
grails.plugin.springsecurity.authority.className = 'apps.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern: '/product/twitter',        access: ['permitAll']],
	[pattern: '/product/twitterLoggedIn',access: ['permitAll']],
	[pattern: '/product/twitterUserData',access: ['permitAll']],
	[pattern: '/product/twitterg20',access: ['permitAll']],
	[pattern: '/product/twitterBrics',access: ['permitAll']],
	[pattern: '/product/twitterPanamaPapers',access: ['permitAll']],
	[pattern: '/product/twitterHeadline',access: ['permitAll']],
	[pattern: '/product/twitterTrump',access: ['permitAll']],
	[pattern: '/product/twitterVenture',access: ['permitAll']],
	[pattern: '/product/twitterEntertainment',access: ['permitAll']],
	[pattern: '/product/twitterDefense',access: ['permitAll']],
	[pattern: '/product/twitterYoga',access: ['permitAll']],
	[pattern: '/product/twitterHillary',access: ['permitAll']],
	[pattern: '/product/twitterThiel',access: ['permitAll']],
	[pattern: '/product/retweet',access: ['permitAll']],
	[pattern: '/product/favorite',access: ['permitAll']],
	[pattern: '/tweet/index',access: ['permitAll']],
	[pattern: '/tweet/show',access: ['permitAll']],
	[pattern: '/product/premium',access: ['permitAll']],
	[pattern: '/product/processLogin',access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.ui.register.defaultRoleNames = ['ROLE_ADMIN']
grails.plugin.springsecurity.ui.register.emailSubject = 'Welcome to Foodal!'
