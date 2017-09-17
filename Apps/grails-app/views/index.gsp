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
		
		<!-- Global Site Tag (gtag.js) - Google Analytics -->
		<script async src="https://www.googletagmanager.com/gtag/js?id=UA-106312202-1"></script>
		<script>
		  window.dataLayer = window.dataLayer || [];
		  function gtag(){dataLayer.push(arguments)};
		  gtag('js', new Date());
		
		  gtag('config', 'UA-106312202-1');
		</script>
		
		<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Effects - Effect demo</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <style>
    .toggler { width: 500px; height: 200px; position: relative; }
    #button { padding: .5em 1em; text-decoration: none; }
    #effect2 { width: 500px; height: 170px; padding: 0.4em; position: relative; }
    #effect2 h3 { margin: 0; padding: 0.4em; text-align: center; }
    #effect3 { width: 500px; height: 170px; padding: 0.4em; position: relative; }
    #effect3 h3 { margin: 0; padding: 0.4em; text-align: center; }
    #effect4 { width: 500px; height: 170px; padding: 0.4em; position: relative; }
    #effect4 h3 { margin: 0; padding: 0.4em; text-align: center; }
    .ui-effects-transfer { border: 2px dotted gray; }
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    // run the currently selected effect
    function runEffect3() {
      // get effect type from
      var selectedEffect = "shake";
 
      // Most effect types need no options passed by default
      var options = {};
      // some effects have required parameters
      if ( selectedEffect === "scale" ) {
        options = { percent: 50 };
      } else if ( selectedEffect === "transfer" ) {
        options = { to: "#button3", className: "ui-effects-transfer" };
      } else if ( selectedEffect === "size" ) {
        options = { to: { width: 300, height: 150 } };
      }
 
      // Run the effect
      $( "#effect3" ).effect( selectedEffect, options, 500, callback );
    };
 
    // Callback function to bring a hidden box back
    function callback() {
      setTimeout(function() {
        $( "#effect3" ).removeAttr( "style" ).hide().fadeIn();
      }, 1000 );
    };

 // run the currently selected effect
    function runEffect2() {
      // get effect type from
      var selectedEffect = "bounce";
 
      // Most effect types need no options passed by default
      var options = {};
      // some effects have required parameters
      if ( selectedEffect === "bounce" ) {
        options = { percent: 50, to: { width: 300, height: 150 } };
      } else if ( selectedEffect === "transfer" ) {
        options = { to: "#button2", className: "ui-effects-transfer" };
      } else if ( selectedEffect === "size" ) {
        options = { to: { width: 300, height: 150 } };
      }
 
      // Run the effect
      $( "#effect2" ).effect( selectedEffect, options, 500, callback );
    };
 
    // Callback function to bring a hidden box back
    function callback() {
      setTimeout(function() {
        $( "#effect2" ).removeAttr( "style" ).hide().fadeIn();
      }, 1000 );
    };
    
    // Set effect from select menu value
    $( "#button3" ).on( "click", function() {
      runEffect3();
      return false;
    });

 // Set effect from select menu value
    $( "#button2" ).on( "click", function() {
      runEffect2();
      return false;
    });

    // run the currently selected effect
    function runEffect4() {
      // get effect type from
      var selectedEffect = "pulsate";
 
      // Most effect types need no options passed by default
      var options = {};
      // some effects have required parameters
      if ( selectedEffect === "scale" ) {
        options = { percent: 50, to: { width: 300, height: 150 } };
      } else if ( selectedEffect === "transfer" ) {
        options = { to: "#button4", className: "ui-effects-transfer" };
      } else if ( selectedEffect === "size" ) {
        options = { to: { width: 300, height: 150 } };
      }
 
      // Run the effect
      $( "#effect4" ).effect( selectedEffect, options, 500, callback );
    };
 
    // Callback function to bring a hidden box back
    function callback() {
      setTimeout(function() {
        $( "#effect4" ).removeAttr( "style" ).hide().fadeIn();
      }, 1000 );
    };

 // Set effect from select menu value
    $( "#button4" ).on( "click", function() {
      runEffect4();
      return false;
    });
    
    
  } );
  </script>
		
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
									<a href="http://foodal.co/product/software">
										<span class="image image-full"><asset:image src="if-wallpaper.png"/></span>
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
										<button id="button3" class="ui-state-default ui-corner-all">Try #if?</button>
										<button id="button2" class="ui-state-default ui-corner-all">Farmers Markets</button>
										<button id="button4" class="ui-state-default ui-corner-all">Real-time News</button>
											<ul>
												<li><g:link controller="product" action="software">#if? Programming</g:link></li>
												<li><g:link controller="product" action="premium">Premium News</g:link></li>
												<li><g:link controller="product" action="seller">Seller Shelf</g:link></li>
												<li><g:link controller="product" action="shelf">Login</g:link></li>
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
														<span style="font-size:35px;">Welcome to Foodal!</span>
													</header>
													<div class="toggler">
  													<div id="effect3" class="ui-widget-content ui-corner-all">
  														<span style="font-size:25px;">
	  													<ul>
														<li>#if? Programming Tests:</li>
														<li><g:link controller="product" action="demo">X Point</g:link></li>
														<li><g:link controller="product" action="demo2">Y Point</g:link></li>
														<li><g:link controller="product" action="demo3">Z Point</g:link></li>
														<li>Hit Spin Button.</li>
														<!--<li><a href="left-sidebar.html">Login</a></li>-->
														</ul>
														</span>
  													</div>
													</div>
													
													<header>
														<span style="font-size:35px;">Local Business</span>
													</header>
													
													<div class="toggler">
  													<div id="effect2" class="ui-widget-content ui-corner-all">
  													<span style="font-size:25px;">
  													<ul>
													<li>Farmers Markets:</li>
													<li>Upload products.</p></li>
													<li>Analytics.</li>
													<li>Monthly subscription is $50.</li> 
													<li><g:link controller="product" action="seller"><span style="color:#8a7e7e;">Let's get started!</span></g:link></li>
													</ul>
													</span>
													</div>
													</div>
													
												</section>
											</div>
											<div class="6u">
												<section class="box">
												<header>
														<span style="font-size:35px;">News:</span>
													</header>
													
												<div class="toggler">
  													<div id="effect4" class="ui-widget-content ui-corner-all">
  													<span style="font-size:25px;">
  													<ul>
													<li>Real-time News:</li>
													<li>CNN, nytimes, nypost, foxnews.</p></li>
													<li>G20, BRICS, Panama Papers.</li>
													<li>Start now with $5.</li> 
													<li><g:link controller="product" action="premium"><span style="color:#8a7e7e;">See News.</span></g:link></li>
													</ul>
													</span>
													</div>
													</div>
													
													<header>
														<span style="font-size:35px;">Contact Us:</span>
													</header>
													
													<div class="toggler">
  													<div id="effect2" class="ui-widget-content ui-corner-all">
  													<span style="font-size:25px;">
  													
  													<br>
													<p style="font-size:20px;">Questions? Email us today and get started.</p>
													<br>
													<footer class="actions">
														<a href="mailto:bilal@mytweetmark.com" class="button fa fa-file-text">Email us today!</a>
														<br><br>
														
													</footer>
													</span>
													</div>
													</div>
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
								<span style="font-size:40px;color:white">Also visit:</span>
									
									<div>
										<div class="row">
											<div class="4u" >
												<section class="box">
													<a href="http://www.homecook.me/farmerMarket/all" class="image image-full"><asset:image src="client-profile.png"/></a>
												
													<p><a href="http://www.homecook.me/farmerMarket/all">Alphabetical customer listing</a></p>
												
												</section>
											</div>
											<div class="4u">
												<section class="box">
													<a href="https://github.com/bahmed73/apps" class="image image-full"><asset:image src="foodal-hoodie.png"/></a>
													<p><a href="https://github.com/bahmed73/apps">On GitHub</a></p>
												</section>
											</div>
											<div class="4u">
												<section class="box">
													<a href="http://www.mytweetmark.com" class="image image-full"><asset:image src="gutfeeling.png"/></a>
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
									<!--  </ul> -->
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
										<li><a href="https://angel.co/foodal">On AngelList</a></li>
										<li><a href="https://www.facebook.com/foodalCo/">On Facebook</a></li>
									</ul>
								</section>

							</div>
							<div class="4u">
							<section>
									<header>
										<h2>And more...</h2>
									</header>
									<ul class="divided">
										<li><a href="https://linkedin.com/in/bahmed73">On LinkedIn</a></li>
										<li><a href="https://twitter.com/foodal_">On Twitter</a></li>
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