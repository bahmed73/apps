<!DOCTYPE HTML>
<html>
	<head>
		<meta name="description" content="Shop - Bring your store business online." />
<meta name="keywords" content="shop local, store business, store, shop, local, local tree, trees, local business, injection, insects, fertilizer, farm, farm market, business, farm business, organic, health, nutrient, california, blogger, socialmedia, socialmedia blogger, social media blogger, facebook, facebook feed, twitter, twitter update, twitter" />
<meta http-equiv="window-target" content="_top" />
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="PUBLIC">
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<title>Shop - Bring your store business online.</title>
	<asset:stylesheet src="skel-noscript.css"/>
	<asset:stylesheet src="style.css"/>
	<asset:stylesheet src="style-desktop.css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
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
	<style>
		p {
		  border: 20px dotted #e5e1e1;
		  background-color: #e1f3f9;
		  border-radius: 10px;
		  border-width: 5px;
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
	      $( "#block1" ).effect( "pulsate", options, 500, callback );
	      $( "#block2" ).effect( "shake", options, 500, callback );
	      $( "#block3" ).effect( "bounce", options, 500, callback );
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
	
				<!-- Header Wrapper -->
			<div id="header-wrapper">
				<div class="container">
					
					<div class="row">
						<div class="12u">
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <g:link class="list" action="index" controller="photos"><asset:image src="homepage-1.png"/></g:link>
    </div>
    
    <div class="item">
      <g:link class="list" action="index" controller="photos"><asset:image src="homepage-2.png"/></g:link>
    </div>
    
    
      </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
						
						</div>
					</div>					
								<!-- Nav -->
										<nav id="nav">
											<ul>
												<li><g:link url="/">Home</g:link></li>
												<li><g:link controller="videos" action="create">Create a Video</g:link></li>
												<!--<li><a href="left-sidebar.html">Login</a></li>-->
											</ul>
										</nav>
							<!-- Intro -->
							
							<g:if test="${videosList}">
							<g:each in="${videosList}" status="i" var="videosInstance">
								<div class="row">
								<div class="12u">
									<section>
										<div>
											<div class="row">
												<div id="block1" class="6u">
														<section class="box">
														<header>
														<span style="font-size:35px;color:#9b9ea9">${videosInstance.name}</span>
														</header>
														<br><br>
														<p style="font-size:20px;color:#8a7e7e;">Description: ${videosInstance.description}</p>
														<br><br>
														<p style="font-size:18px;"><g:link controller="videos" action="show" id="${videosInstance.id}"><span style="color:#8a7e7e;">Watch the video...</span></g:link></p>
														</section>
												</div>
												<div id="block2" class="6u">
														<section class="box">
														<iframe width="210" height="162" src="https://www.youtube.com/embed/${videosInstance.videoUrl}" frameborder="0" allowfullscreen></iframe>
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
													<g:link controller="videos" action="create"><span style="font-size:28px;color:#8a7e7e;">Please create a video.</span></g:link>
													</header>
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
						<a href="/"><asset:image src="logo-150.jpg" width="150px" height="150px"/></a>
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
											<h3>Mount Shasta, California</h3>
											
										</li>
										<li>
											<h3><a href="rob@thepromiserevealed.com">rob@thepromiserevealed.com</a></h3>
										</li>
										<li><a href="https://www.youtube.com/channel/UCdi75MbXf2IxDpncWkCehyg"><h3>On YouTube</h3></a></li>
									</ul>
								</section>
								

							</div>
							
							<div class="4u">

								<section>
									<header>
										<h2>More about us</h2>
									</header>
									<ul class="divided">
										<li><h3>(530) 918-8236</h3></li>
										<li><a href="thepromiserevealed.com"><h3>Our Website</h3></a></li>
										<li><a href="https://www.eventbrite.com/e/meet-the-venusians-mt-shasta-summer-conference-2020-tickets-89345987253"><h3>Attend Mount Shasta Summer Conference</h3></a></li>
									</ul>
								</section>
				
							</div>
							 
							<div class="4u">
							<section>
									<header>
										<h2>And more...</h2>
									</header>
									<ul class="divided">
										<li><a href="https://www.facebook.com/PromiseRevealed/"><h3>Robert Potter Facebook</h3></a></li>
										<li><a href="https://www.facebook.com/Mt-Shasta-Summer-Conference-428207090637794/"><h3>Mount Shasta Summer Conference Facebook</h3></a></li>
										<li><a href="https://www.instagram.com/thepromiserevealed/"><h3>Promise Revealed Instagram</h3></a></li>
										<li><a href="https://twitter.com/ROBERTP35959598"><h3>Promise Revealed Twitter</h3></a></li>
										
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
											<li>&copy; 2020 thepromiserevealed.com 	</li>
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