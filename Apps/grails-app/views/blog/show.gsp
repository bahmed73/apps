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
		var options = {};
        // Run the effect
   		$( "#block3" ).effect( "pulsate", options, 500, callback );
   
		$( "#block1" )
	    .animate({
	      width: "90%"
	    }, {
	      queue: false,
	      duration: 9000
	    })
	    .animate({ fontSize: "24px" }, 3500 )
	    .animate({ borderRightWidth: "15px" }, 3500 );
		$( "#block2" )
	    .animate({ width: "90%" }, 3000 )
	    .animate({ fontSize: "24px" }, 3000 )
	    .animate({ borderLeftWidth: "15px" }, 3000 );
		}

	function callback() {
	      setTimeout(function() {
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
						<div id="block3" class="12u">

							<!-- Banner -->
								<section id="banner">
									
										<span class="image image-full"><asset:image src="taim_banner_3.png"/></span>
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
												<li><g:link url="/">Home</g:link></li>
												<li><g:link controller="blog" action="edit" id="${blog.id}">Edit Blog</g:link></li>
												<li><g:link controller="blog" action="index">Show Blogs</g:link></li>
												<!--<li><a href="left-sidebar.html">Login</a></li>-->
											</ul>
										</nav>
							<!-- Intro -->
														<div class="row">
						<div class="12u">
								<section>
									<div>
										<div class="row" style="border-style:solid; border-color:grey; border-width:1px;">
											<div id="block2" class="6u">
													<section class="box">
													<!-- <a href="http://www.mytweetmark.com" class="image image-full"><asset:image src="foodal-homepage-16.png"/></a> -->
													<header>
														<span style="font-size:40px;color:#9b9ea9"><f:display bean="blog" property="name"/></span>
													</header>
													<br><br>
													<p style="font-size:26px;color:#8a7e7e;font-family:'Palatino';"><f:display bean="blog" property="description"/></p>
													<br><br>
													<a href="https://twitter.com/share?ref_src=twsrc%5Etfw" class="twitter-share-button" data-show-count="false">Tweet</a><script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
													<div class="fb-share-button" data-href="https://developers.facebook.com/docs/plugins/" data-layout="button" data-size="small"><a target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&amp;src=sdkpreparse" class="fb-xfbml-parse-ignore">Share</a></div>
												</section>
											</div>
											<div class="6u">
												<section class="box">
												<div id="block1" style="border-style:solid; border-color:grey; border-width:1px;margin:1px;font-size:2px">
													<div style="border: 20px dotted #e1f3f9;">
													<img src="data:image/png;base64,${blog.imageThree?.encodeBase64()}"/>
													</div>
												</div>
													<br><br>
													<p style="font-size:14px;">Copy and paste the browser link above for your social media marketing, e.g. paste as facebook post.</p>
													<br>
													<footer class="actions">
														<a href="mailto:bilal@mytweetmark.com" class="button fa fa-file-text">Email us today!</a>
														<br><br>
													</footer>	
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
											
												Oakland<br />
																							California
											
										</li>
										<li>
											<h3>Mail</h3>
											<a href="mailto:bilal@mytweetmark.com">bilal@mytweetmark.com</a>
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
										<li><a href="https://facebook.com/mytweetmark/">On Facebook</a></li>
										<li><a href="http://bilalahmed.org">Our Website</a></li>
									</ul>
								</section>
				
							</div>
							<div class="4u">
							<section>
									<header>
										<h2>And more...</h2>
									</header>
									<ul class="divided">
										<li><a href="https://www.youtube.com/user/bahmed73">On YouTube</a></li>
										<li><a href="https://twitter.com/mytweetmark">On Twitter</a></li>
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
											<li>&copy; 2019 Shop  	</li>
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