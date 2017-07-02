<!DOCTYPE HTML>
<html>
	<head>
		<meta name="description" content="foodal" />
<meta name="keywords" content="foodal, local, local food, food, local business, farmers, farmers market, farmer market, farmers markets, market, markets, farm, farm market, business, farm business, organic, health, nutrient,california local markets,california markets,local farmers market,local farmers markets,local farmer markets,local market,local markets,local farmers, farmers,local california,california,local, local business, chef, food chef, featured chef, food, home cook, cook, home, recipe, home recipe, food recipe, cook recipe, spiritual, spirit, blogger, socialmedia, socialmedia blogger, social media blogger, facebook, facebook feed, twitter, twitter update, twitter, twitter hash, twitter hashtag, hash, hashtag,viral,mytweetmark,mytweetmark.com,myhash, brand,share posts,post information,organize bookmarks,share bookmarks,share knowledge,organize bookmarks,categorize bookmarks,email bookmarks, share bookmarks and posts, share posts and bookmarks, share with friends,tweet,twitter" />
<meta http-equiv="window-target" content="_top" />
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="PUBLIC">
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<title>Foodal - Promote your local food business and farmers markets.</title>
	<asset:stylesheet src="skel-noscript.css"/>
	<asset:stylesheet src="style.css"/>
	<asset:stylesheet src="style-desktop.css"/>
	
<LINK REL="SHORTCUT ICON"
       HREF="${createLinkTo(dir:'images', file:'favicon.ico')}">
<link rel="icon" href="${createLinkTo(dir:'images', file:'favicon.ico')}"/>
<g:javascript library="scriptaculous" />    

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>

		<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,900,300italic" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Alegreya+SC:700,400|Alegreya+Sans' rel='stylesheet' type='text/css'>
		<asset:javascript src="jquery.min.js"/>
		<asset:javascript src="jquery.dropotron.min.js"/>
		<asset:javascript src="config.js"/>
		<asset:javascript src="skel.min.js"/>
		<asset:javascript src="skel-panels.min.js"/>
		
		<!--<noscript>
			<asset:stylesheet src="skel-noscript.css"/>
			<asset:stylesheet src="style.css"/>
			<asset:stylesheet src="style-desktop.css"/>
	
		</noscript>-->
		<!--[if lte IE 8]><asset:javascript src="html5shiv.js"/><asset:stylesheet src="ie8.css"/><![endif]-->
	</head>
	<body class="homepage">
	<a href="/#"><asset:image src="favicon.png" class="grails-logo"/></a>
		<!-- Header Wrapper -->
			<div id="header-wrapper">
				<div class="container">
					
					<div class="row">
						<div class="12u">

							<!-- Banner -->
								<section id="banner">
									<a href="http://www.homecook.me/farmerMarket/list">
										<span class="image image-full"><asset:image src="foodal-homepage.png"/></span>
										<header>
											<h2>Foodal</h2>
											<!--span class="byline">welcome!</span-->
										</header>
									</a>
									
								</section>
								
						</div>
					</div>
					
								<!-- Nav -->
										<nav id="nav">
											<ul>
												<li><g:link controller="product" action="twitterg20">G20</g:link></li>
												<li><g:link controller="product" action="twitterBrics">Brics</g:link></li>
												<li><g:link controller="product" action="twitterPanamaPapers">Panama Papers</g:link></li>
												<li><g:link controller="product" action="twitterUserData">Russia Gate</g:link></li>
												<li><g:link controller="product" action="twitterTrump">Trump</g:link></li>
												<li><g:link controller="product" action="twitterHeadline">Headlines</g:link></li>
												<li><g:link controller="product" action="twitterVenture">Venture</g:link></li>
												<li><g:link controller="product" action="twitterEntertainment">Entertainment</g:link></li>
												<li><g:link controller="product" action="twitterDefense">Defense</g:link></li>
												<li><g:link controller="product" action="twitterYoga">Yoga</g:link></li>
												<li><g:link controller="product" action="twitterHillary">Hillary</g:link></li>
												<li><g:link controller="tweet" action="index">Archived</g:link></li>
												<!--<li><a href="left-sidebar.html">Login</a></li>-->
											</ul>
										</nav>
							<!-- Intro -->
							<g:if test="${session.searchResults}">
							<div class="row">
								<div class="12u">
									<section>
										<div>
											<div class="row">
												<div class="6u">
														<section class="box">
														<header>
														<span style="font-size:35px;">Twitter Thiel: </span>
														<g:link controller="product" action="twitterThiel"><asset:image src="reload.png"/></g:link>
														</header>
														</section>
												</div>
											</div>
										</div>
									</section>
								</div>
								</div>
							<g:each in="${session.searchResults}" status="i" var="tweet">
								<div class="row">
								<div class="12u">
									<section>
										<div>
											<div class="row">
												<div class="6u">
														<section class="box">
														<header>
														<span style="font-size:35px;">Tweet: ${tweet.text}</span>
														<br>
														<g:link controller="product" action="retweet" id="${tweet.id}"><asset:image src="retweet.png"/></g:link>
														<g:link controller="product" action="favorite" id ="${tweet.id}"><asset:image src="favorite.png"/></g:link>
														</header>
														</section>
												</div>
												<div class="6u">
														<section class="box">
														<p style="font-size:24px;color:#8a7e7e;">User: <g:link url="https://twitter.com/${tweet.userScreenName}"><span style="color:#8a7e7e;">${tweet.userScreenName}</span></g:link></p>
														<br><br>
														<p style="font-size:18px;">Created At: ${tweet.createdAt}</p>
														</section>
												</div>
											</div>
										</div>
									</section>
								</div>
								</div>
							</g:each>
							</g:if>
							<g:else>
							<div class="row">
								<div class="12u">
									<section>
									<div>
										<div class="row">
										
										<div class="6u">
													<section class="box">
													<!-- <a href="http://www.mytweetmark.com" class="image image-full"><asset:image src="foodal-homepage-16.png"/></a> -->
													<header>
													No results found.
													</header>
													<footer class="actions">
														 <g:link controller="product" action="twitterThiel"><asset:image src="reload.png"/></g:link>
														<br><br>
													</footer>
													</section>
										</div>
									</div>
									</section>
								</div>
							</div>
							</g:else>
				        	</div>
				        	</div>			
		
		<!-- Main Wrapper -->
			<div id="main-wrapper">
				<div class="container">
					<div class="row">
						<div class="12u">
							
							<!-- Portfolio -->
								<section>
									<span style="font-size:40px;color:white">Also visit:</span>
									
									<div>
										<div class="row">
											<div class="4u" >
												<section class="box">
													<a href="http://www.homecook.me/farmerMarket/all" class="image image-full"><asset:image src="foodal-hat.png"/></a>
												
													<p><a href="http://www.homecook.me/farmerMarket/all">Alphabetical customer listing</a></p>
												
												</section>
											</div>
											<div class="4u">
												<section class="box">
													<a href="http://www.homecook.me/homecookme" class="image image-full"><asset:image src="foodal-hoodie.png"/></a>
													<p><a href="http://www.homecook.me/homecookme">Local food API and programming</a></p>
												</section>
											</div>
											<div class="4u">
												<section class="box">
													<a href="http://www.mytweetmark.com" class="image image-full"><asset:image src="foodal-pen.png"/></a>
													<p><a href="http://www.mytweetmark.com">Twitter marketing tool</a></p>
												</section>
											</div>
										</div>
										
											
					</div>
					<div class="row">
						<div class="12u">

							<!-- Blog >
								<section>
									<header class="major">
										<h2>The Blog</h2>
									</header>
									<div>
										<div class="row">
											<div class="6u">
												<section class="box">
													<a href="http://facebook.com/homecookme" class="image image-full"><img src="${createLinkTo(dir:'images', file:'pic08.jpg')}" alt="" /></a>
													<header>
														<h3>Magna tempus consequat lorem</h3>
														<span class="byline">Posted 45 minutes ago</span>
													</header>
													<p>Lorem ipsum dolor sit amet sit veroeros sed et blandit consequat sed veroeros lorem et blandit  adipiscing feugiat phasellus tempus hendrerit, tortor vitae mattis tempor, sapien sem feugiat sapien, id suscipit magna felis nec elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos lorem ipsum dolor sit amet.</p>
													<footer class="actions">
														<a href="#" class="button fa fa-file-text">Continue Reading</a>
														<a href="#" class="button alt fa fa-comment">33 comments</a>
													</footer>
												</section>
											</div>
											<div class="6u">
												<section class="box">
													<a href="http://facebook.com/homecookme" class="image image-full"><img src="images/pic09.jpg" alt="" /></a>
													<header>
														<h3>Aptent veroeros et aliquam</h3>
														<span class="byline">Posted 45 minutes ago</span>
													</header>
													<p>Lorem ipsum dolor sit amet sit veroeros sed et blandit consequat sed veroeros lorem et blandit  adipiscing feugiat phasellus tempus hendrerit, tortor vitae mattis tempor, sapien sem feugiat sapien, id suscipit magna felis nec elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos lorem ipsum dolor sit amet.</p>
													<footer class="actions">
														<a href="#" class="button fa fa-file-text">Continue Reading</a>
														<a href="#" class="button alt fa fa-comment">33 comments</a>
													</footer>
												</section>
											</div>
										</div>
									</div>
								</section>
							
						</div>
					</div>
				</div>
			</div-->

		<!-- Footer Wrapper -->
			<div id="footer-wrapper">
				
				<!-- Footer -->
					<!--section id="footer" class="container">
						<div class="row">
							<div class="8u">

								<section>
									<header>
										<h2>Blandit nisl adipiscing</h2>
									</header>
									<ul class="dates">
										<li>
											<span class="date">Jan <strong>27</strong></span>
											<h3><a href="#">Lorem dolor sit amet veroeros</a></h3>
											<p>Ipsum dolor sit amet veroeros consequat blandit ipsum phasellus lorem consequat etiam.</p>
										</li>
										<li>
											<span class="date">Jan <strong>23</strong></span>
											<h3><a href="#">Ipsum sed blandit nisl consequat</a></h3>
											<p>Blandit phasellus lorem ipsum dolor tempor sapien tortor hendrerit adipiscing feugiat lorem.</p>
										</li>
										<li>
											<span class="date">Jan <strong>15</strong></span>
											<h3><a href="#">Magna tempus lorem feugiat</a></h3>
											<p>Dolore consequat sed phasellus lorem sed etiam nullam dolor etiam sed amet sit consequat.</p>
										</li>
										<li>
											<span class="date">Jan <strong>12</strong></span>
											<h3><a href="#">Dolore tempus ipsum feugiat nulla</a></h3>
											<p>Feugiat lorem dolor sed nullam tempus lorem ipsum dolor sit amet nullam consequat.</p>
										</li>
										<li>
											<span class="date">Jan <strong>10</strong></span>
											<h3><a href="#">Blandit tempus aliquam?</a></h3>
											<p>Feugiat sed tempus blandit tempus adipiscing nisl lorem ipsum dolor sit amet dolore.</p>
										</li>
									</ul>
								</section>
							
							</div>
							<div class="4u">
							
								<section>
									<header>
										<h2>What's this all about?</h2>
									</header>
									<a href="http://facebook.com/homecookme" class="image image-full"><img src="images/pic10.jpg" alt="" /></a>
									<p>
										This is <a href="http://html5up.net/Homecook.me/">Homecook.me</a> a free, fully responsive HTML5 site template by 
										<a href="http://n33.co">AJ</a> for <a href="http://html5up.net/">HTML5 UP</a> It's released for free under
										the <a href="http://html5up.net/license/">CCA</a> license so feel free to use it for any personal or commercial project &ndash;
										just don't forget to credit us! <strong>PS:</strong> The awesome placeholder artwork used in this design is courtesy of <a href="http://facebook.com/homecookme/">Homecookme</a>.
									</p>
									<footer>
										<a href="#" class="button">Find out more</a>
									</footer>
								</section>
							
							</div>
						</div-->
						<div class="row">
							<div class="4u">
<section>
									<header>
										<h2>Connect with us</h2>
									</header>
									<!--  <ul class="social">-->
										<!--  <li><a class="fa fa-facebook solo" href="https://www.facebook.com/foodalCo/"><span>Facebook</span></a></li>
										<li><a class="fa fa-twitter solo" href="https://twitter.com/foodal_"><span>Twitter</span></a></li>
										<li><a class="fa fa-linkedin solo" href="https://www.linkedin.com/company-beta/18041812/"><span>LinkedIn</span></a></li>-->
										<!--li><a class="fa fa-google-plus solo" href="#"><span>Google+</span></a></li-->
									<!--  </ul>-->
									<ul class="contact">
										<li>
											<h3>Address</h3>
											<p>
												Oakland<br />
																							California
											</p>
										</li>
										<li>
											<h3>Mail</h3>
											<p><a href="mailto:bilal@mytweetmark.com">bilal@mytweetmark.com</a></p>
										</li>
										<!--li>
											<h3>Phone</h3>
											<p>(800) 000-0000</p>
										</li-->
									</ul>
								</section>
								

							</div>
							<div class="4u">

								<section>
									<header>
										<h2>More about us</h2>
									</header>
									<ul class="divided">
										<li><a href="http://www.homecook.me/images/survey.doc">Survey</a></li>
										<li><a href="http://www.homecook.me/users/privacy">Privacy</a></li>
									</ul>
								</section>

							</div>
							<div class="4u">
							<section>
									<header>
										<h2>And more...</h2>
									</header>
									<ul class="divided">
										<li><a href="http://www.foundersspace.com/news-announcements/startup-splotlight-mytweetmark/">On FoundersSpace</a></li>
										<li><a href="http://www.homecook.me/users/tos">Terms</a></li>
										<!--li><a href="#">Sem feugiat sapien id suscipit magna felis nec</a></li>
										<li><a href="#">Elit class aptent taciti sociosqu ad litora</a></li-->
									</ul>
								</section>
								
							
							</div>
						</div>
						<div class="row">
							<div class="12u">
							
								<!-- Copyright -->
									<div id="copyright">
										<ul class="links">
											<li>&copy; 2017 foodal.co 	</li>
											<!--li>Images: <a href="http://facebook.com/homecookme">Homecookme</a></li>
											<li>Design: <a href="http://dalliusdesign.com">Dallius</a></li-->
										</ul>
									</div>

							</div>
						</div>
					</section>
				
			</div>

	</body>
</html>