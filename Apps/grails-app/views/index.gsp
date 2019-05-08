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
		
		<meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		  <link rel="stylesheet" href="/resources/demos/style.css">
		  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		  <script>
		  $( function() {
		    $( "#menu" ).menu();
		  } );
		  </script>
		  <style>
		  .ui-menu { width: 400px; }
		  </style>
	</head>
	<body class="homepage" onload="testEffect()">
	<script type="text/javascript">
	function testEffect() {
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
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <g:link class="list" action="shelf" controller="product"><asset:image src="taim_banner_3.png"/></g:link>
    </div>

    <div class="item">
      <g:link controller="product" action="analytics"><asset:image src="taim_banner_2.png"/></g:link>
    </div>

    <div class="item">
      <g:link controller="product" action="sales"><asset:image src="taim_banner_1.png"/></g:link>
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
												<li><g:link class="list" action="shelf" controller="product"><span>Dashboard</span></g:link></li>
												<li><g:link controller="product" action="analytics">Analytics</g:link></li>
												<li><g:link controller="product" action="sales">Sales</g:link></li>
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
														<span style="font-size:35px;color:#878282">Get Started today!</span>
													</header>
													
													<br><br>
													<div id="block2">
													
													<ul id="menu">
													<li><div><g:link class="list" action="index" controller="photos"><span style="color:#8a7e7e;font-size:20px">Photos</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="videos"><span style="color:#8a7e7e;font-size:20px">Videos</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="products"><span style="color:#8a7e7e;font-size:20px">Products</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link controller="coupon" action="index"><span style="color:#8a7e7e;font-size:20px">Marketing</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link controller="product" action="analytics"><span style="color:#8a7e7e;font-size:20px">Analytics</span></g:link></div>
													<ul>
													<li><div><g:link class="list" action="index" controller="productView"><span style="color:#8a7e7e;">Product Views</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="export" controller="productView"><span style="color:#8a7e7e;">Download Report: Product Views</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="productReferer"><span style="color:#8a7e7e;">Product Referers</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="export" controller="productReferer"><span style="color:#8a7e7e;">Download Report: Product Referers</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="blogView"><span style="color:#8a7e7e;">Blog Views</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="export" controller="blogView"><span style="color:#8a7e7e;">Download Report: Blog Views</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="blogReferer"><span style="color:#8a7e7e;">Blog Referer</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="export" controller="blogReferer"><span style="color:#8a7e7e;">Download Report: Blog Referers</span></g:link></div></li>
													</ul>
													</li>
													<li>-</li>
													<li><div><g:link controller="blog" action="index"><span style="color:#8a7e7e;font-size:20px">Blog</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link controller="product" action="sales"><span style="color:#8a7e7e;font-size:20px">Sales</span></g:link></div>
													<ul>
													<li><div><g:link class="list" action="index" controller="inventory"><span style="color:#8a7e7e;">Inventory</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="export" controller="inventory"><span style="color:#8a7e7e;">Download Report: Inventory</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="seasonCatalog"><span style="color:#8a7e7e;">Season Catalog</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="export" controller="seasonCatalog"><span style="color:#8a7e7e;">Download Report: Season Catalog</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="allocationForecast"><span style="color:#8a7e7e;">Allocation Forecast</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="export" controller="allocationForecast"><span style="color:#8a7e7e;">Download Report: Allocation Forecast</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="goalSeek"><span style="color:#8a7e7e;">Goal Seek</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="export" controller="goalSeek"><span style="color:#8a7e7e;">Download Report: Goal Seek</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="targetInventory"><span style="color:#8a7e7e;">Target Inventory</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="export" controller="targetInventory"><span style="color:#8a7e7e;">Download Report: Target Inventory</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="customers"><span style="color:#8a7e7e;">Customers</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="export" controller="customers"><span style="color:#8a7e7e;">Download Report: Customers</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="vendors"><span style="color:#8a7e7e;">Vendors</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="export" controller="vendors"><span style="color:#8a7e7e;">Download Report: Vendors</span></g:link></div></li>
													</ul>
													</li>
													
													</ul>
													</div>
													<br>
													<br>
													
												</section>
											</div>
										<div class="6u">
										<br><br><br>
										<div>
												<section class="box">
													
													<div id="block1" style="border-style:solid; border-color:grey; border-width:1px;margin:1px;font-size:20px">
													<br>
													<div style="margin:20px">
													<header>
														<span style="font-size:35px;color:#878282">Product Stream:</span>
													</header>
													<br><br>
													Checkout our blog, <g:link action="show" controller="blog" id="163">Microcosmic Epitome.</g:link>
													<br><br>
													Checkout our blog, <g:link action="show" controller="blog" id="162">Microcosmic Diet.</g:link>
													<br><br>
													Checkout our blog, <g:link action="show" controller="blog" id="161">Bird Diet.</g:link>
													<br><br>
													Checkout our blog, <g:link action="show" controller="blog" id="129">12 Meridians.</g:link>
													<br><br>
													Checkout our blog, <g:link action="show" controller="blog" id="98">Yellow Empress.</g:link>
													<br><br>
													Check out video, <g:link action="show" controller="videos" id="78">latest from Burial and Four tet.</g:link>
													<br><br>
													Check out <g:link action="show" controller="videos" id="66">video of Nipsey Hussle and Eminem.</g:link>
													<br><br>
													Check our <g:link action="show" controller="blog" id="33">blog on Cultivation.</g:link>
													<br><br>
													Checkout our blog, <g:link action="show" controller="blog" id="65">Vegan Hot Girl.</g:link>
													<br><br>
													Checkout our blog, <g:link action="show" controller="blog" id="97">Diamond Sutras.</g:link>
													</div>
													<br>
														
													</div>
													<!-- 
													<footer class="actions">
														<g:link controller="product" action="analytics" class="button fa fa-file-text">Please view our analytics.</g:link>
														<br><br>
														<g:link class="list" action="index" controller="products" class="button alt fa fa-comment">Please view our products.</g:link>
													</footer>
													 -->
												</section>
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
											<p><a href="bilal@mytweetmark.com">bilal@mytweetmark.com</a></p>
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