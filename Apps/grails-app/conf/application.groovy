

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
	[pattern: '/product/mention',access: ['permitAll']],
	[pattern: '/tweet/index',access: ['permitAll']],
	[pattern: '/tweet/show',access: ['permitAll']],
	[pattern: '/product/premium',access: ['permitAll']],
	[pattern: '/product/seller',access: ['permitAll']],
	[pattern: '/tweet/archiveG20',access: ['permitAll']],
	[pattern: '/tweet/archiveBrics',access: ['permitAll']],
	[pattern: '/tweet/archivePanamaPapers',access: ['permitAll']],
	[pattern: '/tweet/archiveRussiaGate',access: ['permitAll']],
	[pattern: '/tweet/archiveDefense',access: ['permitAll']],
	[pattern: '/tweet/archiveTrump',access: ['permitAll']],
	[pattern: '/tweet/archiveStartups',access: ['permitAll']],
	[pattern: '/tweet/archiveYoga',access: ['permitAll']],
	[pattern: '/product/processLogin',access: ['permitAll']],
	[pattern: '/checkout/productCheckout',access: ['permitAll']],
	[pattern: '/product/help',access: ['permitAll']],
	[pattern: '/product/software',access: ['permitAll']],
	[pattern: '/product/loop',access: ['permitAll']],
	[pattern: '/product/mom',access: ['permitAll']],
	[pattern: '/product/dad',access: ['permitAll']],
	[pattern: '/product/male',access: ['permitAll']],
	[pattern: '/product/female',access: ['permitAll']],
	[pattern: '/product/demo',access: ['permitAll']],
	[pattern: '/product/demo2',access: ['permitAll']],
	[pattern: '/product/demo3',access: ['permitAll']],
	[pattern: '/product/demo4',access: ['permitAll']],
	[pattern: '/product/demo5',access: ['permitAll']],
	[pattern: '/product/demo6',access: ['permitAll']],
	[pattern: '/product/m',access: ['permitAll']],
	[pattern: '/product/n',access: ['permitAll']],
	[pattern: '/product/o',access: ['permitAll']],
	[pattern: '/product/p',access: ['permitAll']],
	[pattern: '/product/q',access: ['permitAll']],
	[pattern: '/product/r',access: ['permitAll']],
	[pattern: '/product/i',access: ['permitAll']],
	[pattern: '/product/j',access: ['permitAll']],
	[pattern: '/product/k',access: ['permitAll']],
	[pattern: '/product/l',access: ['permitAll']],
	[pattern: '/product/a',access: ['permitAll']],
	[pattern: '/product/b',access: ['permitAll']],
	[pattern: '/product/c',access: ['permitAll']],
	[pattern: '/product/d',access: ['permitAll']],
	[pattern: '/product/e',access: ['permitAll']],
	[pattern: '/product/f',access: ['permitAll']],
	[pattern: '/product/g',access: ['permitAll']],
	[pattern: '/product/h',access: ['permitAll']],
	[pattern: '/product/analogue',access: ['permitAll']],
	[pattern: '/product/circuit',access: ['permitAll']],
	[pattern: '/product/levitation',access: ['permitAll']],
	[pattern: '/product/birth',access: ['permitAll']],
	[pattern: '/product/magnet',access: ['permitAll']],
	[pattern: '/product/demo7',access: ['permitAll']],
	[pattern: '/product/demo8',access: ['permitAll']],
	[pattern: '/product/day1',access: ['permitAll']],
	[pattern: '/product/day2',access: ['permitAll']],
	[pattern: '/product/day3',access: ['permitAll']],
	[pattern: '/product/day4',access: ['permitAll']],
	[pattern: '/product/day5',access: ['permitAll']],
	[pattern: '/product/day6',access: ['permitAll']],
	[pattern: '/product/day7',access: ['permitAll']],
	[pattern: '/product/day8',access: ['permitAll']],
	[pattern: '/product/day9',access: ['permitAll']],
	[pattern: '/product/day10',access: ['permitAll']],
	[pattern: '/product/day11',access: ['permitAll']],
	[pattern: '/product/day12',access: ['permitAll']],
	[pattern: '/product/day13',access: ['permitAll']],
	[pattern: '/product/day14',access: ['permitAll']],
	[pattern: '/product/day15',access: ['permitAll']],
	[pattern: '/product/day16',access: ['permitAll']],
	[pattern: '/product/day17',access: ['permitAll']],
	[pattern: '/product/day18',access: ['permitAll']],
	[pattern: '/product/day19',access: ['permitAll']],
	[pattern: '/product/day20',access: ['permitAll']],
	[pattern: '/product/day21',access: ['permitAll']],
	[pattern: '/product/day22',access: ['permitAll']],
	[pattern: '/product/day23',access: ['permitAll']],
	[pattern: '/product/day24',access: ['permitAll']],
	[pattern: '/product/day25',access: ['permitAll']],
	[pattern: '/product/day26',access: ['permitAll']],
	[pattern: '/product/day27',access: ['permitAll']],
	[pattern: '/product/day28',access: ['permitAll']],
	[pattern: '/product/day29',access: ['permitAll']],
	[pattern: '/product/day30',access: ['permitAll']],
	[pattern: '/product/vedanta',access: ['permitAll']],
	[pattern: '/product/day31',access: ['permitAll']],
	[pattern: '/product/day32',access: ['permitAll']],
	[pattern: '/product/day33',access: ['permitAll']],
	[pattern: '/product/day34',access: ['permitAll']],
	[pattern: '/product/day35',access: ['permitAll']],
	[pattern: '/product/day36',access: ['permitAll']],
	[pattern: '/product/day37',access: ['permitAll']],
	[pattern: '/product/day38',access: ['permitAll']],
	[pattern: '/product/day39',access: ['permitAll']],
	[pattern: '/product/day40',access: ['permitAll']],
	[pattern: '/product/time',access: ['permitAll']],
	[pattern: '/product/day41',access: ['permitAll']],
	[pattern: '/product/day42',access: ['permitAll']],
	[pattern: '/product/day43',access: ['permitAll']],
	[pattern: '/product/day44',access: ['permitAll']],
	[pattern: '/product/day45',access: ['permitAll']],
	[pattern: '/product/day46',access: ['permitAll']],
	[pattern: '/product/day47',access: ['permitAll']],
	[pattern: '/product/day48',access: ['permitAll']],
	[pattern: '/product/day49',access: ['permitAll']],
	[pattern: '/product/day50',access: ['permitAll']],
	[pattern: '/product/day51',access: ['permitAll']],
	[pattern: '/product/day52',access: ['permitAll']],
	[pattern: '/product/school',access: ['permitAll']],
	[pattern: '/products/search',access: ['permitAll']]
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
	[pattern: '/product/mention',access: ['permitAll']],
	[pattern: '/tweet/index',access: ['permitAll']],
	[pattern: '/tweet/show',access: ['permitAll']],
	[pattern: '/product/premium',access: ['permitAll']],
	[pattern: '/product/seller',access: ['permitAll']],
	[pattern: '/tweet/archiveG20',access: ['permitAll']],
	[pattern: '/tweet/archiveBrics',access: ['permitAll']],
	[pattern: '/tweet/archivePanamaPapers',access: ['permitAll']],
	[pattern: '/tweet/archiveRussiaGate',access: ['permitAll']],
	[pattern: '/tweet/archiveDefense',access: ['permitAll']],
	[pattern: '/tweet/archiveTrump',access: ['permitAll']],
	[pattern: '/tweet/archiveStartups',access: ['permitAll']],
	[pattern: '/tweet/archiveYoga',access: ['permitAll']],
	[pattern: '/product/processLogin',access: ['permitAll']],
	[pattern: '/checkout/productCheckout',access: ['permitAll']],
	[pattern: '/product/help',access: ['permitAll']],
	[pattern: '/product/software',access: ['permitAll']],
	[pattern: '/product/loop',access: ['permitAll']],
	[pattern: '/product/mom',access: ['permitAll']],
	[pattern: '/product/dad',access: ['permitAll']],
	[pattern: '/product/male',access: ['permitAll']],
	[pattern: '/product/female',access: ['permitAll']],
	[pattern: '/product/demo',access: ['permitAll']],
	[pattern: '/product/demo2',access: ['permitAll']],
	[pattern: '/product/demo3',access: ['permitAll']],
	[pattern: '/product/demo4',access: ['permitAll']],
	[pattern: '/product/demo5',access: ['permitAll']],
	[pattern: '/product/demo6',access: ['permitAll']],
	[pattern: '/product/m',access: ['permitAll']],
	[pattern: '/product/n',access: ['permitAll']],
	[pattern: '/product/o',access: ['permitAll']],
	[pattern: '/product/p',access: ['permitAll']],
	[pattern: '/product/q',access: ['permitAll']],
	[pattern: '/product/r',access: ['permitAll']],
	[pattern: '/product/i',access: ['permitAll']],
	[pattern: '/product/j',access: ['permitAll']],
	[pattern: '/product/k',access: ['permitAll']],
	[pattern: '/product/l',access: ['permitAll']],
	[pattern: '/product/a',access: ['permitAll']],
	[pattern: '/product/b',access: ['permitAll']],
	[pattern: '/product/c',access: ['permitAll']],
	[pattern: '/product/d',access: ['permitAll']],
	[pattern: '/product/e',access: ['permitAll']],
	[pattern: '/product/f',access: ['permitAll']],
	[pattern: '/product/g',access: ['permitAll']],
	[pattern: '/product/h',access: ['permitAll']],
	[pattern: '/product/analogue',access: ['permitAll']],
	[pattern: '/product/circuit',access: ['permitAll']],
	[pattern: '/product/levitation',access: ['permitAll']],
	[pattern: '/product/birth',access: ['permitAll']],
	[pattern: '/product/magnet',access: ['permitAll']],
	[pattern: '/product/demo7',access: ['permitAll']],
	[pattern: '/product/demo8',access: ['permitAll']],
	[pattern: '/product/day1',access: ['permitAll']],
	[pattern: '/product/day2',access: ['permitAll']],
	[pattern: '/product/day3',access: ['permitAll']],
	[pattern: '/product/day4',access: ['permitAll']],
	[pattern: '/product/day5',access: ['permitAll']],
	[pattern: '/product/day6',access: ['permitAll']],
	[pattern: '/product/day7',access: ['permitAll']],
	[pattern: '/product/day8',access: ['permitAll']],
	[pattern: '/product/day9',access: ['permitAll']],
	[pattern: '/product/day10',access: ['permitAll']],
	[pattern: '/product/day11',access: ['permitAll']],
	[pattern: '/product/day12',access: ['permitAll']],
	[pattern: '/product/day13',access: ['permitAll']],
	[pattern: '/product/day14',access: ['permitAll']],
	[pattern: '/product/day15',access: ['permitAll']],
	[pattern: '/product/day16',access: ['permitAll']],
	[pattern: '/product/day17',access: ['permitAll']],
	[pattern: '/product/day18',access: ['permitAll']],
	[pattern: '/product/day19',access: ['permitAll']],
	[pattern: '/product/day20',access: ['permitAll']],
	[pattern: '/product/day21',access: ['permitAll']],
	[pattern: '/product/day22',access: ['permitAll']],
	[pattern: '/product/day23',access: ['permitAll']],
	[pattern: '/product/day24',access: ['permitAll']],
	[pattern: '/product/day25',access: ['permitAll']],
	[pattern: '/product/day26',access: ['permitAll']],
	[pattern: '/product/day27',access: ['permitAll']],
	[pattern: '/product/day28',access: ['permitAll']],
	[pattern: '/product/day29',access: ['permitAll']],
	[pattern: '/product/day30',access: ['permitAll']],
	[pattern: '/product/vedanta',access: ['permitAll']],
	[pattern: '/product/day31',access: ['permitAll']],
	[pattern: '/product/day32',access: ['permitAll']],
	[pattern: '/product/day33',access: ['permitAll']],
	[pattern: '/product/day34',access: ['permitAll']],
	[pattern: '/product/day35',access: ['permitAll']],
	[pattern: '/product/day36',access: ['permitAll']],
	[pattern: '/product/day37',access: ['permitAll']],
	[pattern: '/product/day38',access: ['permitAll']],
	[pattern: '/product/day39',access: ['permitAll']],
	[pattern: '/product/day40',access: ['permitAll']],
	[pattern: '/product/time',access: ['permitAll']],
	[pattern: '/product/day41',access: ['permitAll']],
	[pattern: '/product/day42',access: ['permitAll']],
	[pattern: '/product/day43',access: ['permitAll']],
	[pattern: '/product/day44',access: ['permitAll']],
	[pattern: '/product/day45',access: ['permitAll']],
	[pattern: '/product/day46',access: ['permitAll']],
	[pattern: '/product/day47',access: ['permitAll']],
	[pattern: '/product/day48',access: ['permitAll']],
	[pattern: '/product/day49',access: ['permitAll']],
	[pattern: '/product/day50',access: ['permitAll']],
	[pattern: '/product/day51',access: ['permitAll']],
	[pattern: '/product/day52',access: ['permitAll']],
	[pattern: '/product/school',access: ['permitAll']],
	[pattern: '/products/search',access: ['permitAll']]
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
	[pattern: '/product/mention',access: ['permitAll']],
	[pattern: '/tweet/index',access: ['permitAll']],
	[pattern: '/tweet/show',access: ['permitAll']],
	[pattern: '/product/premium',access: ['permitAll']],
	[pattern: '/product/seller',access: ['permitAll']],
	[pattern: '/tweet/archiveG20',access: ['permitAll']],
	[pattern: '/tweet/archiveBrics',access: ['permitAll']],
	[pattern: '/tweet/archivePanamaPapers',access: ['permitAll']],
	[pattern: '/tweet/archiveRussiaGate',access: ['permitAll']],
	[pattern: '/tweet/archiveDefense',access: ['permitAll']],
	[pattern: '/tweet/archiveTrump',access: ['permitAll']],
	[pattern: '/tweet/archiveStartups',access: ['permitAll']],
	[pattern: '/tweet/archiveYoga',access: ['permitAll']],
	[pattern: '/product/processLogin',access: ['permitAll']],
	[pattern: '/checkout/productCheckout',access: ['permitAll']],
	[pattern: '/product/help',access: ['permitAll']],
	[pattern: '/product/software',access: ['permitAll']],
	[pattern: '/product/loop',access: ['permitAll']],
	[pattern: '/product/mom',access: ['permitAll']],
	[pattern: '/product/dad',access: ['permitAll']],
	[pattern: '/product/male',access: ['permitAll']],
	[pattern: '/product/female',access: ['permitAll']],
	[pattern: '/product/demo',access: ['permitAll']],
	[pattern: '/product/demo2',access: ['permitAll']],
	[pattern: '/product/demo3',access: ['permitAll']],
	[pattern: '/product/demo4',access: ['permitAll']],
	[pattern: '/product/demo5',access: ['permitAll']],
	[pattern: '/product/demo6',access: ['permitAll']],
	[pattern: '/product/m',access: ['permitAll']],
	[pattern: '/product/n',access: ['permitAll']],
	[pattern: '/product/o',access: ['permitAll']],
	[pattern: '/product/p',access: ['permitAll']],
	[pattern: '/product/q',access: ['permitAll']],
	[pattern: '/product/r',access: ['permitAll']],
	[pattern: '/product/i',access: ['permitAll']],
	[pattern: '/product/j',access: ['permitAll']],
	[pattern: '/product/k',access: ['permitAll']],
	[pattern: '/product/l',access: ['permitAll']],
	[pattern: '/product/a',access: ['permitAll']],
	[pattern: '/product/b',access: ['permitAll']],
	[pattern: '/product/c',access: ['permitAll']],
	[pattern: '/product/d',access: ['permitAll']],
	[pattern: '/product/e',access: ['permitAll']],
	[pattern: '/product/f',access: ['permitAll']],
	[pattern: '/product/g',access: ['permitAll']],
	[pattern: '/product/h',access: ['permitAll']],
	[pattern: '/product/analogue',access: ['permitAll']],
	[pattern: '/product/circuit',access: ['permitAll']],
	[pattern: '/product/levitation',access: ['permitAll']],
	[pattern: '/product/birth',access: ['permitAll']],
	[pattern: '/product/magnet',access: ['permitAll']],
	[pattern: '/product/demo7',access: ['permitAll']],
	[pattern: '/product/demo8',access: ['permitAll']],
	[pattern: '/product/day1',access: ['permitAll']],
	[pattern: '/product/day2',access: ['permitAll']],
	[pattern: '/product/day3',access: ['permitAll']],
	[pattern: '/product/day4',access: ['permitAll']],
	[pattern: '/product/day5',access: ['permitAll']],
	[pattern: '/product/day6',access: ['permitAll']],
	[pattern: '/product/day7',access: ['permitAll']],
	[pattern: '/product/day8',access: ['permitAll']],
	[pattern: '/product/day9',access: ['permitAll']],
	[pattern: '/product/day10',access: ['permitAll']],
	[pattern: '/product/day11',access: ['permitAll']],
	[pattern: '/product/day12',access: ['permitAll']],
	[pattern: '/product/day13',access: ['permitAll']],
	[pattern: '/product/day14',access: ['permitAll']],
	[pattern: '/product/day15',access: ['permitAll']],
	[pattern: '/product/day16',access: ['permitAll']],
	[pattern: '/product/day17',access: ['permitAll']],
	[pattern: '/product/day18',access: ['permitAll']],
	[pattern: '/product/day19',access: ['permitAll']],
	[pattern: '/product/day20',access: ['permitAll']],
	[pattern: '/product/day21',access: ['permitAll']],
	[pattern: '/product/day22',access: ['permitAll']],
	[pattern: '/product/day23',access: ['permitAll']],
	[pattern: '/product/day24',access: ['permitAll']],
	[pattern: '/product/day25',access: ['permitAll']],
	[pattern: '/product/day26',access: ['permitAll']],
	[pattern: '/product/day27',access: ['permitAll']],
	[pattern: '/product/day28',access: ['permitAll']],
	[pattern: '/product/day29',access: ['permitAll']],
	[pattern: '/product/day30',access: ['permitAll']],
	[pattern: '/product/vedanta',access: ['permitAll']],
	[pattern: '/product/day31',access: ['permitAll']],
	[pattern: '/product/day32',access: ['permitAll']],
	[pattern: '/product/day33',access: ['permitAll']],
	[pattern: '/product/day34',access: ['permitAll']],
	[pattern: '/product/day35',access: ['permitAll']],
	[pattern: '/product/day36',access: ['permitAll']],
	[pattern: '/product/day37',access: ['permitAll']],
	[pattern: '/product/day38',access: ['permitAll']],
	[pattern: '/product/day39',access: ['permitAll']],
	[pattern: '/product/day40',access: ['permitAll']],
	[pattern: '/product/time',access: ['permitAll']],
	[pattern: '/product/day41',access: ['permitAll']],
	[pattern: '/product/day42',access: ['permitAll']],
	[pattern: '/product/day43',access: ['permitAll']],
	[pattern: '/product/day44',access: ['permitAll']],
	[pattern: '/product/day45',access: ['permitAll']],
	[pattern: '/product/day46',access: ['permitAll']],
	[pattern: '/product/day47',access: ['permitAll']],
	[pattern: '/product/day48',access: ['permitAll']],
	[pattern: '/product/day49',access: ['permitAll']],
	[pattern: '/product/day50',access: ['permitAll']],
	[pattern: '/product/day51',access: ['permitAll']],
	[pattern: '/product/day52',access: ['permitAll']],
	[pattern: '/product/school',access: ['permitAll']],
	[pattern: '/products/search',access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.ui.register.postRegisterUrl = '/product/shelf'
grails.plugin.springsecurity.ui.register.defaultRoleNames = ['INNER_CIRCLE']
grails.plugin.springsecurity.ui.register.emailFrom = 'The Promise Revealed'
grails.plugin.springsecurity.ui.register.emailSubject = 'Welcome to the promise revealed!'
grails.plugin.springsecurity.ui.register.emailBody = 'Login to get details on The Promise Revealed'
