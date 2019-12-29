<!DOCTYPE HTML>
<html>
	<head>
		<meta name="description" content="Building agile development and lean startup tools, for entrepreneurs, venture capital, startups and project manager." />
<meta name="keywords" content="lean startup, customer development, agile development, agile sprints, agile back log, agile backlog, venture capital, startups, entrepreneur, entrepreneurship, customer feedback loop, product development, product roadmap, project management, product backlog" />
<meta http-equiv="window-target" content="_top" />
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="PUBLIC">
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<title>Shop - Real-time Twitter feeds</title>
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
		
		<!-- Global Site Tag (gtag.js) - Google Analytics -->
		<script async src="https://www.googletagmanager.com/gtag/js?id=UA-154739766-1"></script>
		<script>
		  window.dataLayer = window.dataLayer || [];
		  function gtag(){dataLayer.push(arguments);}
		  gtag('js', new Date());
		
		  gtag('config', 'UA-154739766-1');
		</script>
		
		<style>
		  p {
		  border: 2px solid #e5e1e1;
		  border-width: 2px;
		  margin: 5px;
		  padding: 10px;
		  background-color: #5f6469;
		  color: #fdeba9;
		}
		.button {
		  display: inline-block;
		  padding: 15px 25px;
		  font-size: 15px;
		  cursor: pointer;
		  text-align: center;
		  text-decoration: none;
		  outline: none;
		  color: #fdeba9;
		  background-color: #000000;
		  border: none;
		  border-radius: 15px;
		  box-shadow: 0 9px #999;
		}

		.button:hover {background-color: #a3a6a3}
		
		.button:active {
		  background-color: #3e8e41;
		  box-shadow: 0 5px #666;
		  transform: translateY(4px);
		}
		  </style>
		  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		  <link rel="stylesheet" href="/resources/demos/style.css">
		  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	</head>
	<body class="homepage" onload="testEffect()">
	<script type="text/javascript">
	function testEffect() {
		var options = {};
        // Run the effect
   		$( "#block3" ).effect( "shake", options, 1000, callback );
		$( "#block1" )
	    .animate({
	      width: "90%"
	    }, {
	      queue: false,
	      duration: 3000
	    })
	    .animate({ fontSize: "24px" }, 1500 )
	    .animate({ borderRightWidth: "15px" }, 1500 );
		$( "#block2" )
	    .animate({ width: "90%" }, 1000 )
	    .animate({ fontSize: "24px" }, 1000 )
	    .animate({ borderLeftWidth: "15px" }, 1000 );
		}

	function callback() {
	      setTimeout(function() {
	        $( "#block3" ).removeAttr( "style" ).hide().fadeIn();
	      }, 1000 );
	    };
	</script>
	
		<!-- Header Wrapper -->
			<div id="header-wrapper">
				<div class="container">
					
					<div class="row">
						<div id="block3" class="12u">

							<!-- Banner -->
								<section id="banner">
									<a href="http://taote.shop">
										<span class="image image-full"><asset:image src="customerdevelopment-2.png"/></span>
										<header>
											<h2>twitter</h2>
											<!--span class="byline">welcome!</span-->
										</header>
									</a>
									
								</section>
								
						</div>
					</div>
					
								<!-- Nav -->
										<nav id="nav">
											<ul>
												<li><button class="button"><g:link url="/">Home</g:link></button></li>
												<li><button class="button"><g:link controller="product" action="shelf">Dashboard</g:link></button></li>
												<li><button class="button"><g:link controller="sprint" action="index">Agile Development</g:link></button></li>
												<li><button class="button"><g:link controller="customerDevelopment" action="index">Lean Startup</g:link></button></li>
												<sec:ifLoggedIn>
												<li><button class="button"><g:form controller="logout">                        
    													<g:submitButton name="logout" value="Logout" />
													</g:form></button></li>
													</sec:ifLoggedIn>
												<!--<li><a href="left-sidebar.html">Login</a></li>-->
											</ul>
										</nav>
							<!-- Intro -->
							<div class="row">
						<div class="12u">
								<section>
									<div>
										<div class="row">
										
										<div class="6u">
													<section class="box">
													<!-- <a href="http://www.mytweetmark.com" class="image image-full"><asset:image src="foodal-homepage-16.png"/></a> -->
													<header>
														<span style="font-size:35px;color:#000;">Lean Startup!</span>
													</header>
													<p>
													<div>
													<ul style="list-style-type:disc; margin:50px;font-size:20px;">
													<li><span style="font-size:28px;color:#000;">Find some really cool interesting people.</span></li>
													<li><span style="font-size:28px;color:#000;">Find out what news many others are reading.</span></li>
													<li><span style="font-size:28px;color:#000;">You never know what you might find.</span></li>
													<li><span style="font-size:28px;color:#000;">Connect with them on Twitter. Let's get started!</span></li>
													</ul>
													</div>
													</p>
													<br><br>
													<footer class="actions">
														 <g:link controller="product" action="twitterLoggedIn"><asset:image src="sign-in-with-twitter-gray.png"/></g:link>
														<br><br>
													</footer>
												</section>
											</div>
										<div class="6u">
												<section class="box">
													<g:link controller="product" action="twitterLoggedIn"><asset:image src="logoshop5.png"  width="250" heignt="250"/></g:link>
													<!--header>
														<h3>Aptent veroeros et aliquam</h3>
														<span class="byline">Posted 45 minutes ago</span>
													</header>
													<p>Lorem ipsum dolor sit amet sit veroeros sed et blandit consequat sed veroeros lorem et blandit  adipiscing feugiat phasellus tempus hendrerit, tortor vitae mattis tempor, sapien sem feugiat sapien, id suscipit magna felis nec elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos lorem ipsum dolor sit amet.</p>
													<footer class="actions">
														<a href="#" class="button fa fa-file-text">Continue Reading</a>
														<a href="#" class="button alt fa fa-comment">33 comments</a>
													</footer-->
												</section>
											</div>
											
										</div>
									</div>
								</section>

						</div>
					</div>
				</div>
			</div>
		
		<!-- Main Wrapper -->
			<div id="main-wrapper">
				<div class="container">
					<div class="row">
						<div class="12u">
							
							<!-- Portfolio -->
								<section>
									
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
						<a href="/"><asset:image src="logoshop5.png" width="150px" height="150px"/></a>
						<br><br>
						
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
									<ul class="divided">
										<li>
											<h3>Oakland, California</h3>
											
										</li>
										<li>
											<h3><a href="bilal@mytweetmark.com">bilal@mytweetmark.com</a></h3>
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
										<li><a href="https://facebook.com/dotshopper/"><h3>On Facebook</h3></a></li>
										<li><a href="http://bilalahmed.org"><h3>Our Website</h3></a></li>
									</ul>
								</section>
				
							</div>
							 
							<div class="4u">
							<section>
									<header>
										<h2>And more...</h2>
									</header>
									<ul class="divided">
										<li><a href="https://www.youtube.com/user/bahmed73"><h3>On YouTube</h3></a></li>
										<li><a href="https://twitter.com/taoteshop"><h3>On Twitter</h3></a></li>
										<!--li><a href="#">Sem feugiat sapien id suscipit magna felis nec</a></li>
										<li><a href="#">Elit class aptent taciti sociosqu ad litora</a></li-->
									</ul>
								</section>
								
							
							</div>
						</div>
						<div class="row">
							<div class="10u">
							
								<!-- Copyright -->
									<div id="copyright">
										<ul class="links">
											<li>&copy; 2020 Shop 	</li>
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