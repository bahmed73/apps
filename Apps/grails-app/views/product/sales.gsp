<!DOCTYPE HTML>
<html>
	<head>
		<meta name="description" content="Erika Tovar - Loverth." />
<meta name="keywords" content="Art, Clothing, Jewelry, startup, yoga, meditation, logos, online store, books, entrepreneur" />
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
  </head>
  
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
		  <script>
  $( function() {
    $( "#draggable" ).draggable();
  } );
  </script>
	</head>
	<body class="homepage" onload="testEffect()">
	<script type="text/javascript">
	function testEffect() {
		var options = {};
        // Run the effect
   		$( "#block3" ).effect( "bounce", options, 1000, callback );
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
									
										<span class="image image-full"><asset:image src="loverth.png"/></span>
										<!-- 
										<header>
											<h2>Shop</h2> 
											<span class="byline">Bring your store business online.</span>
											 -->
										</header>
									
								</section>
								
						</div>
					</div>
					
								<!-- Nav -->
										<nav id="nav">
											<ul>
												<li><g:link url="/">Home</g:link></li>
												<li><g:link controller="product" action="shelf">Dashboard</g:link></li>
												<li><g:link controller="product" action="analytics">Analytics</g:link></li>
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
														<span style="font-size:35px;color:#878282">Sales</span>
														<g:form controller="logout">                        
    													<g:submitButton name="logout" value="Logout" />
													</g:form>
													
													</header>
													<br><br>
													<div id="block2">
													<ul id="menu">
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
													
													</div>
													<br><br>
													<g:form controller="logout">                        
    													<g:submitButton name="logout" value="Logout" />
													</g:form>
													<br><br>
													
												</section>
											</div>
											<div class="6u">
												<section class="box">
												<div id="block1" style="border-style:solid; border-color:grey; border-width:1px;margin:1px;font-size:20px;color:#000000">
													<br>
													<div style="margin:20px">
													1. Create inventory of your products you are selling. 
													<br><br>
													2. Track your vendors and customers.
													<br><br>
													3. Measure your season catalog, allocation forecast, target inventory and goal seek.
													</div>
													<br>
													<div id="draggable" class="ui-widget-content">
														<div style="margin-left:93px">
														<p>"Drag me around"</p>
														<asset:image src="advertising.png" width="300" height="300"/>
														</div>
													</div>
													</div>
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
									<span style="font-size:40px;color:white">Also visit:</span>
									<!-- 
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
					 -->
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