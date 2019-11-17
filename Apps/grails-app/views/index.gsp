<!DOCTYPE HTML>
<html>
	<head>
		<meta name="description" content="Shop - Bring your store business online. Start with our project management tools." />
<meta name="keywords" content="agile development, sprint planning, lean startup, customer development, product development, product roadmap, project management, product backlog" />
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
		    $( "#menu2" ).menu();
		  } );
		  </script>
		  <style>
		  .ui-menu { width: 400px; }
		  </style>
	</head>
	<body class="homepage" onload="testEffect()">
	<script type="text/javascript">
	function testEffect() {
		var options = {};
        // Run the effect
   		$( "#block3" ).effect( "pulsate", options, 1000, callback );
   
		$( "#block1" )
	    .animate({
	      width: "90%"
	    }, {
	      queue: false,
	      duration: 6000
	    })
	    .animate({ fontSize: "24px" }, 4500 )
	    .animate({ borderRightWidth: "15px" }, 4500 );
		$( "#block2" )
	    .animate({ width: "90%" }, 4000 )
	    .animate({ fontSize: "24px" }, 4000 )
	    .animate({ borderLeftWidth: "15px" }, 4000 );
		$( "#block3" )
	    .animate({
	      width: "90%"
	    }, {
	      queue: false,
	      duration: 6000
	    })
	    .animate({ fontSize: "24px" }, 5500 )
	    .animate({ borderRightWidth: "15px" }, 5500 );
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
						<div class="12u">
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
    <li data-target="#myCarousel" data-slide-to="4"></li>
    <li data-target="#myCarousel" data-slide-to="5"></li>
    <li data-target="#myCarousel" data-slide-to="6"></li>
    <li data-target="#myCarousel" data-slide-to="7"></li>
    <li data-target="#myCarousel" data-slide-to="8"></li>
    <li data-target="#myCarousel" data-slide-to="9"></li>
    
    
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <g:link class="list" action="index" controller="projects"><asset:image src="project-management.png"/></g:link>
    </div>
    
    <div class="item">
      <g:link class="list" action="shelf" controller="product"><asset:image src="project-management-2.png"/></g:link>
    </div>
    
    <div class="item">
      <g:link class="list" action="shelf" controller="product"><asset:image src="project-management-3.png"/></g:link>
    </div>
    
    <div class="item">
      <g:link class="list" action="shelf" controller="product"><asset:image src="project-management-4.png"/></g:link>
    </div>
    
    <div class="item">
      <g:link controller="projects" action="index"><asset:image src="taim_banner_6.png"/></g:link>
    </div>
    
    <div class="item">
      <g:link controller="tasks" action="index"><asset:image src="taim_banner_7.png"/></g:link>
    </div>
    
    <div class="item">
      <g:link controller="notes" action="index"><asset:image src="taim_banner_8.png"/></g:link>
    </div>

	<div class="item">
      <g:link controller="sprint" action="index"><asset:image src="project-management-5.png"/></g:link>
    </div>
    
    <div class="item">
      <g:link controller="meeting" action="index"><asset:image src="project-management-6.png"/></g:link>
    </div>
    
    <div class="item">
      <g:link controller="backlog" action="index"><asset:image src="project-management-7.png"/></g:link>
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
												<!--  <li><g:link controller="product" action="analytics">Analytics</g:link></li>
												<li><g:link controller="product" action="sales">Sales</g:link></li>-->
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
													<div id="block2">
													<header>
														<span style="font-size:35px;color:#878282">Create projects, tasks, notes, agile development sprint planning, meetings and backlog.</span>
													</header>
													<br><br>
													<ul id="menu2">
													<li><div><g:link class="list" action="index" controller="projects"><span style="color:#8a7e7e;font-size:20px"><asset:image src="goal-1.png" width="125"/> Projects</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="tasks"><span style="color:#8a7e7e;font-size:20px"><asset:image src="goal-2.png" width="125"/> Tasks</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="notes"><span style="color:#8a7e7e;font-size:20px"><asset:image src="goal-3.png" width="125"/> Notes</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="sprint"><span style="color:#8a7e7e;font-size:20px"><asset:image src="goal-4.png" width="125"/> Sprint Planning</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="meeting"><span style="color:#8a7e7e;font-size:20px"><asset:image src="goal-5.png" width="125"/> Meetings</span></g:link></div></li>
													<li>-</li>
													<li><div><g:link class="list" action="index" controller="backlog"><span style="color:#8a7e7e;font-size:20px"><asset:image src="goal-6.png" width="125"/> Agile Backlog</span></g:link></div></li>
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
													For casual users, we offer tracking projects, tasks and notes. For advanced users, weekly agile development sprint planning, business requirements document and product roadmap tools for the team.
													</div>
													
													<div style="margin:20px">
													You can also download your product backlog in pdf format. We love agile development however hope to provide you with simpler project management experience.
													</div>
													
													<div style="margin:20px">
													You can also track your Agile Development Sprint Planning, Meeting Notes and Agile Backlog with us.
													</div>
													
													<div style="margin:20px">
													Please contact us if you love Lean Startup, Customer Development - We would love your feedback and add you to our user group testing team.
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