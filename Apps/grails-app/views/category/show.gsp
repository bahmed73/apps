<!DOCTYPE HTML>
<html>
	<head>
		<meta name="description" content="Erika Tovar - Loverth." />
<meta name="keywords" content="Art, Clothing, Jewelry, startup, yoga, meditation, logos, online store, books, entrepreneur" />
<meta http-equiv="window-target" content="_top" />
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="PUBLIC">
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<title><f:display bean="category" property="name"/></title>
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
		<script>
		  $( function() {
		    $( "#dialog" ).dialog();
		  } );
		  </script>
		
		<!--<noscript>
			<asset:stylesheet src="skel-noscript.css"/>
			<asset:stylesheet src="style.css"/>
			<asset:stylesheet src="style-desktop.css"/>
	
		</noscript>-->
		<!--[if lte IE 8]><asset:javascript src="html5shiv.js"/><asset:stylesheet src="ie8.css"/><![endif]-->
		<style>
		p {
		  background-color: #ffffff;
		  border-width: 2px;
		  margin: 5px;
		  padding: 10px;
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
		  background-color: #fb7b77;
		  border: none;
		  border-radius: 15px;
		  box-shadow: 0 9px #78789b;
		}

		.button:hover {background-color: #000000}
		
		.button:active {
		  background-color: #1d10d2;
		  box-shadow: 0 5px #666;
		  transform: translateY(4px);
		}
		</style>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	</head>
	<body class="homepage" onload="testEffect()">
	<script type="text/javascript">
	function testEffect() {
	      // Most effect types need no options passed by default
	      var options = {};
	           // Run the effect
	      $( "#block1" ).effect( "bounce", options, 500, callback );
	      $( "#block2" ).effect( "pulsate", options, 500, callback );
	      $( "#block3" ).effect( "shake", options, 500, callback );
	    };
	 
	    // Callback function to bring a hidden box back
	    function callback() {
	      setTimeout(function() {
	        $( "#block1" ).removeAttr( "style" ).hide().fadeIn();
	        $( "#block2" ).removeAttr( "style" ).hide().fadeIn();
	        $( "#block3" ).removeAttr( "style" ).hide().fadeIn();
	      }, 1000 );
	    };
	</script>
	<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.2&appId=261449270414&autoLogAppEvents=1"></script>
	
		<!-- Header Wrapper -->
			<div id="header-wrapper">
				<div class="container">
					
					<div class="row">
						<div class="12u">

							<!-- Banner -->
								<section id="banner">
									
										<g:link class="list" action="index" controller="category"><span class="image image-full"><asset:image src="loverth.png"/></span></g:link>
										<header>
											<!--  <h2>Foodal</h2>-->
											<!--span class="byline">welcome!</span-->
										</header>
									
									
								</section>
								
						</div>
					</div>
					
								<!-- Nav -->
										<nav id="nav">
											<ul>
												<li><button class="button"><g:link url="/"><span style="color:#feff00">Home</span></g:link></button></li>
												<li><button class="button"><g:link controller="category" action="edit" id="${category.id}"><span style="color:#feff00">Edit Category</span></g:link></button></li>
												<li><button class="button"><g:link controller="category" action="index"><span style="color:#feff00">Show Categories</span></g:link></button></li>
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
														<span style="font-size:35px;color:#000000"><f:display bean="category" property="name"/></span>
													</header>
													<br><br>
													<br><br>
													<p><span style="color:#000000;">Share our product category pages on Twitter or Facebook. </span></p>
													<br><br>
													<br><br>
													<a href="https://twitter.com/share?ref_src=twsrc%5Etfw" class="twitter-share-button" data-show-count="false">Tweet</a><script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
													<div class="fb-share-button" data-href="https://developers.facebook.com/docs/plugins/" data-layout="button" data-size="small"><a target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&amp;src=sdkpreparse" class="fb-xfbml-parse-ignore">Share</a></div>
													
												</section>
											</div>
											<div class="6u">
												<section class="box">
												<header>
													<img src="data:image/png;base64,${category.imageThree?.encodeBase64()}"/>
												</header>
													
												</section>
											</div>
											
											<div class="12u">
												<section class="box">
												<header>
													<g:if test="${products}">
													<span style="font-size:25px;color:#000000">
													Products:</span>
													<br><br>
													<g:each in="${products}" status="i" var="productsInstance">
													<div class="3u" style="float:left;height:300px;width:300px;">
													<g:link controller="products" action="show" id="${productsInstance.id}"><span style="color:#000000;font-size:16px;"><img src="data:image/png;base64,${productsInstance.imageOne?.encodeBase64()}"/><br>${productsInstance.name} - ${productsInstance.price}</span></g:link>
													</div>
													</g:each>
													</g:if>
													<br><br>
													
												</header>
													
												</section>
											</div>
											<div class="8u">
												<section class="box">
													<g:if test="${videos}">
													<span style="font-size:25px;color:#000000">
													Videos:</span>
													<br><br>
													<g:each in="${videos}" status="i" var="videosInstance">
													
													<p><g:link controller="videos" action="show" id="${videosInstance.id}"><span style="color:#000000;">${videosInstance.name}</span></g:link></p>
													<br>	
													</g:each>
													</g:if>
													<br><br>
												</section>
											</div>
											
											
											<div class="12u">
												<section class="box">
													<span style="font-size:18px;color:#000000">Description: <f:display bean="category" property="description"/></span>
													<br><br>
													
												</section>
											</div>
											<div class="12u">
												<section class="box">
													<g:if test="${photos}">
													<span style="font-size:25px;color:#000000">
													Photos:</span>
													<br><br>
													<g:each in="${photos}" status="i" var="photosInstance">
													<div class="3u" style="float:left;height:300px;width:300px;">
													<g:link controller="photos" action="show" id="${photosInstance.id}"><span style="color:#000000;font-size:20px;"><img src="data:image/png;base64,${photosInstance.imageOne?.encodeBase64()}"/><br>${photosInstance.name}</span></g:link>
													<br><br>
													</div>	
													</g:each>
													</g:if>
													<br><br>
													
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
		<g:render template="/footer" />

	</body>
</html>