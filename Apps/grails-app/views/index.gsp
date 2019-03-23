<!DOCTYPE HTML>
<html>
	<head>
		<meta name="description" content="Shop - Bring your store business online." />
<meta name="keywords" content="shop, buy, sell, organic, health, nutrient, california, blogger, socialmedia, socialmedia blogger, social media blogger, facebook, facebook feed, twitter, twitter update, twitter" />
<meta http-equiv="window-target" content="_top" />
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="PUBLIC">
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<title>Shop - Bring your store business online.</title>
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
    .toggler { width: 300px; height: 200px; position: relative; }
    #effect { width: 300px; height: 170px; padding: 0.4em; position: relative; }
    #effect h3 { margin: 0; padding: 0.4em; text-align: center; }
    #effect2 { width: 300px; height: 170px; padding: 0.4em; position: relative; }
    #effect2 h3 { margin: 0; padding: 0.4em; text-align: center; }
    #effect3 { width: 300px; height: 170px; padding: 0.4em; position: relative; }
    #effect3 h3 { margin: 0; padding: 0.4em; text-align: center; }
    #effect4 { width: 300px; height: 170px; padding: 0.4em; position: relative; }
    #effect4 h3 { margin: 0; padding: 0.4em; text-align: center; }
    .ui-effects-transfer { border: 2px dotted gray; }
    label {
    display: inline-block;
    width: 5em;
  }
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {

	  $( document ).tooltip();
	  
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

    $( "#button" ).on( "click", function() {
        runEffect();
        return false;
      });

 // run the currently selected effect
    function runEffect() {
      // get effect type from
      var selectedEffect = "pulsate";
 
      // Most effect types need no options passed by default
      var options = {};
      // some effects have required parameters
      if ( selectedEffect === "scale" ) {
        options = { percent: 50, to: { width: 300, height: 150 } };
      } else if ( selectedEffect === "transfer" ) {
        options = { to: "#button", className: "ui-effects-transfer" };
      } else if ( selectedEffect === "size" ) {
        options = { to: { width: 300, height: 150 } };
      }
 
      // Run the effect
      $( "#effect" ).effect( selectedEffect, options, 500, callback );
    };
 
    // Callback function to bring a hidden box back
    function callback() {
      setTimeout(function() {
        $( "#effect4" ).removeAttr( "style" ).hide().fadeIn();
      }, 1000 );
    };
      
    $( "#resizable4" ).resizable({
    	  ghost: true,
    	  animate: true
    });
    $( "#resizable5" ).resizable({
    	  ghost: true,
    	  animate: true
    });
    $( "#resizable6" ).resizable({
    	  ghost: true,
    	  animate: true
    });
    $( "#resizable7" ).resizable({
    	  ghost: true,
    	  animate: true
    });
    $( "#resizable" ).resizable({
    	  ghost: true,
    	  animate: true
    });
    $( "#resizable2" ).resizable({
    	  ghost: true,
    	  animate: true
    });
    $( "#resizable3" ).resizable({
    	  ghost: true,
    	  animate: true
    });

    var ghost = $( "resizable" ).resizable( "option", "ghost" );
    
 	// Setter
 	$( "resizable" ).resizable( "option", "ghost", true );

	var ghost2 = $( "resizable2" ).resizable( "option", "ghost" );
    
 	// Setter
 	$( "resizable2" ).resizable( "option", "ghost", true );

	var ghost3 = $( "resizable3" ).resizable( "option", "ghost" );
    
 	// Setter
 	$( "resizable3" ).resizable( "option", "ghost", true );

	var ghost4 = $( "resizable4" ).resizable( "option", "ghost" );
    
 	// Setter
 	$( "resizable4" ).resizable( "option", "ghost", true );

	var ghost5 = $( "resizable5" ).resizable( "option", "ghost" );
    
 	// Setter
 	$( "resizable5" ).resizable( "option", "ghost", true );

	var ghost6 = $( "resizable6" ).resizable( "option", "ghost" );
    
 	// Setter
 	$( "resizable6" ).resizable( "option", "ghost", true );

	var ghost7 = $( "resizable7" ).resizable( "option", "ghost" );
    
 	// Setter
 	$( "resizable7" ).resizable( "option", "ghost", true );

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
									
										<span class="image image-full" title="Shop - Bring your store business online."><asset:image src="shop-11.png"/></span>
										<header>
											<h2>Shop</h2> 
											<span class="byline">Bring your store business online.</span>
										</header>
									
									
								</section>
								
						</div>
					</div>
								<div>	
								<!-- Nav -->
										<nav id="nav">
										<!-- 
										<button id="button3" class="ui-state-default ui-corner-all" title="Buy Tea.">Tea</button>
										<button id="button2" class="ui-state-default ui-corner-all" title="Tea Retreat.">Bed and Breakfast</button>
										<button id="button4" class="ui-state-default ui-corner-all" title="Residence Program.">Residence</button>
										<button id="button" class="ui-state-default ui-corner-all" title="Please feel free to email us.">Contact Us</button>
										 -->
											<ul>
												<!--  <li><g:link controller="product" action="software">#if? Programming</g:link></li>
												<li><g:link controller="product" action="premium">Premium News</g:link></li>
												<li><g:link controller="product" action="seller">Seller Shelf</g:link></li>-->
												<li><g:link controller="product" action="shelf">Login</g:link></li>
												<li><g:link controller="register">Sign up</g:link></li>
												<!--<li><a href="left-sidebar.html">Login</a></li>-->
											</ul>
											
										</nav>
										</div>
							<!-- Intro -->
							<div class="row">
						<div class="12u">
								<section>
									<div>
										<div class="row">
										<div class="6u">
													<section class="box">
													<asset:image src="shop-2.png"/>
													<header>
														<span style="font-size:35px;color:#878282">Understand your inventory</span>
													</header>
													</section>
													</div>
											<div class="6u">
													<section class="box">
													<asset:image src="shop-3.png"/>
													<header>
														<span style="font-size:35px;color:#878282">Select products to put on shelf</span>
													</header>
													</section>
													</div>
											<div class="6u">
													<section class="box">
													<asset:image src="shop-4.png"/>
													<header>
														<span style="font-size:35px;color:#878282">Run marketing campaigns</span>
													</header>
													<!-- <a href="http://www.mytweetmark.com" class="image image-full"><asset:image src="foodal-homepage-16.png"/></a> -->
													<!-- 
													<header>
														<span style="font-size:35px;color:#878282">Bed and Breakfast</span>
													</header>
													
													<div id="effect2" class="ui-widget-content ui-corner-all">
													<div id="resizable6" class="ui-widget-content">
  													<span style="font-size:25px;">
  													<p style="font-size:20px;">Rent a room for the night and enjoy our tea.</p>
  													<ul>
													<li><g:img dir="images" file="kettle.png" width="100" height="100"/></li>
													</ul>
													</span>
													</div>
													</div>
													
													<header>
														<span style="font-size:35px;color:#878282">Buy Tea</span>
													</header>
													
													<div id="effect3" class="ui-widget-content ui-corner-all">
													<div id="resizable7" class="ui-widget-content">
  													
  														<span style="font-size:25px;">
  														<p style="font-size:20px;">Buy tea with five elements, earth, water, fire, wood and metal.</p>
	  													<ul>
														<li><g:img dir="images" file="batao.png" width="100" height="100"/> </li>
														</ul>
														</span>
  													</div>
													</div>
												 -->	
												</section>
											</div>
											<div class="6u">
												<section class="box">
												<asset:image src="shop-5.png"/>
												<header>
														<span style="font-size:35px;color:#878282">View buying conversion on analytics</span>
													</header>
												<!-- 
												<header>
														<span style="font-size:35px;color:#878282">Residence program</span>
													</header>
													
												
  													<div id="effect4" class="ui-widget-content ui-corner-all">
  													<div id="resizable5" class="ui-widget-content">
  													<span style="font-size:25px;">
  													<p style="font-size:20px;">Come live with the master and learn dao teachings.</p>
  													<ul>
														<li><g:img dir="images" file="flame.png" width="100" height="100"/> </li>
														</ul>
													</span>
													</div>
													</div>
													
													<header>
														<span style="font-size:35px;color:#878282">Contact Us</span>
													</header>
													
													<div id="effect" class="ui-widget-content ui-corner-all">
													<div id="resizable4" class="ui-widget-content">
  													<span style="font-size:25px;">
  													
  													<p style="font-size:20px;">Questions? Email us today and get started.</p>
  													
													<br>
													<footer class="actions">
														<a href="mailto:webmaster@mauget.com" class="fa fa-flag fa-2x pull-left">Email!</a>
														
													</footer>
													</span>
													</div>
													</div>
											</div>
										</div>
									</div>
									 -->
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
						<div class="row">
							<div class="4u">
								<section>
								<div style="margin:20px">
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
											<p><a href="bilal@mytweetmark.com">bilal@mytweetmark.com</a></p>
										</li>
										<!--li>
											<h3>Phone</h3>
											<p>(800) 000-0000</p>
										</li-->
									</ul>
									</div>
									
								</section>
								
							</div>
							<!-- 
							<div class="4u">

								<section>
									<header>
										<h2>More about us</h2>
									</header>
									<ul class="divided">
										<li><a href="https://mauget.com/about-mauget/">On YouTube</a></li>
										<li><a href="https://www.facebook.com/Mauget-464784170389171/">On Twitter</a></li>
									</ul>
								</section>
				
							</div>
							 -->
							<div class="4u">
							<section>
							<div style="margin:20px">
									<header>
										<h2>And more...</h2>
									</header>
									<ul class="divided">
										<li><a href="https://www.youtube.com/user/bahmed73">On YouTube</a></li>
										<li><a href="https://twitter.com/mytweetmark">On Twitter</a></li>
										<!--li><a href="#">Sem feugiat sapien id suscipit magna felis nec</a></li>
										<li><a href="#">Elit class aptent taciti sociosqu ad litora</a></li-->
									</ul>
									</div>
								</section>
								
							
							</div>
						</div>
						<div class="row">
							<div class="12u">
							
								<!-- Copyright -->
									<div id="copyright">
										<ul class="links">
											<li>&copy; 2019 Shop 	</li>
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