<!DOCTYPE HTML>
<html>
	<head>
		<meta name="description" content="Erika Tovar - Loverth." />
<meta name="keywords" content="Art, Clothing, Jewelry, startup, yoga, meditation, logos, online store, books, entrepreneur" />
<meta http-equiv="window-target" content="_top" />
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="PUBLIC">
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<title>Erika Tovar - Loverth.</title>
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
		  border: 2px solid #fb7b77;
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
	      $( "#block1" ).effect( "pulsate", options, 500, callback );
	      $( "#block2" ).effect( "shake", options, 500, callback );
	      $( "#block3" ).effect( "puff", options, 500, callback );
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
      <g:link class="list" action="index" controller="category"><asset:image src="loverth-2.png"/></g:link>
    </div>
    
    <div class="item">
      <g:link class="list" action="index" controller="blogCategory"><asset:image src="loverth.png"/></g:link>
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
												<li><button class="button"><g:link url="/"><span style="color:#feff00">Home</span></g:link></button></li>
												<li><button class="button"><g:link controller="category" action="index"><span style="color:#feff00">Category</span></g:link></button></li>
												<li><button class="button"><g:link controller="blogCategory" action="index"><span style="color:#feff00">Blog Category</span></g:link></button></li>
												<li><button class="button"><g:link controller="photos" action="create"><span style="color:#feff00">Create a Photo</span></g:link></button></li>
												<!--<li><a href="left-sidebar.html">Login</a></li>-->
											</ul>
										</nav>
							<!-- Intro -->
							<div class="row">
							<div class="12u">
							<g:if test="${categoryExpando}">
							<span style="font-size:25px;color:#000000">
													Photos By Category:</span>
													<br><br>
							<g:each in="${categoryExpando}" status="i" var="expandoInstance">
							<g:set var="category" value="${expandoInstance.category}" />
							<g:set var="photos" value="${expandoInstance.photos}" />	
									
												<section>
										
											
												<div class="row">
														<div>
														<p><g:link controller="category" action="show" id="${category.id}"><span style="color:#000000;font-size:20px;"><img src="data:image/png;base64,${category.imageOne?.encodeBase64()}" width="250" height="250"/><br>${category.name}</span></g:link></p>
														</div>
														<br><br>
														<g:if test="${photos}">
														<g:each in="${photos}" status="j" var="photosInstance">
														<div class="1u" style="float:left;color:#000000;font-size:14px;height:200px;width:200px;">
														<g:link controller="photos" action="show" id="${photosInstance.id}"><img src="data:image/png;base64,${photosInstance.imageOne?.encodeBase64()}" width="100" height="100"/><br>${photosInstance.name}</g:link>
														
														<br><br>
														</div>
														</g:each>
														</g:if>
														<br><br>
												</div>
											
									</section>
									<br><br>
								
							</g:each>
							</g:if>
							</div>
							</div>
							<br><br>
							<div class="row">
							<div class="12u">
							<g:if test="${productsExpando}">
							<span style="font-size:25px;color:#000000">
													Photos By Product:</span>
													<br><br>
							<g:each in="${productsExpando}" status="i" var="expandoInstance">
							<g:set var="products" value="${expandoInstance.products}" />
							<g:set var="photos" value="${expandoInstance.photos}" />	
									
												<section>
										
											
												<div class="row">
														<div>
														<p><g:link controller="products" action="show" id="${products.id}"><span style="color:#000000;font-size:20px;"><img src="data:image/png;base64,${products.imageOne?.encodeBase64()}" width="250" height="250"/><br>${products.name}</span></g:link></p>
														</div>
														<br><br>
														<g:if test="${photos}">
														<g:each in="${photos}" status="j" var="photosInstance">
														<div class="1u" style="float:left;color:#000000;font-size:14px;height:200px;width:200px;">
														<g:link controller="photos" action="show" id="${photosInstance.id}"><img src="data:image/png;base64,${photosInstance.imageOne?.encodeBase64()}" width="100" height="100"/><br>${photosInstance.name}</g:link>
														
														<br><br>
														</div>
														</g:each>
														</g:if>
														<br><br>
												</div>
											
									</section>
									<br><br>
								
							</g:each>
							</g:if>
							</div>
							</div>
							<br><br>
							
							<div class="row">
							<div class="12u">
							<g:if test="${blogExpando}">
							<span style="font-size:25px;color:#000000">
													Photos By Blog:</span>
													<br><br>
							<g:each in="${blogExpando}" status="i" var="expandoInstance">
							<g:set var="blog" value="${expandoInstance.blog}" />
							<g:set var="photos" value="${expandoInstance.photos}" />	
									
												<section>
										
											
												<div class="row">
														<div>
														<p><g:link controller="blog" action="show" id="${blog.id}"><span style="color:#000000;font-size:20px;"><img src="data:image/png;base64,${blog.imageOne?.encodeBase64()}" width="250" height="250"/><br>${blog.name}</span></g:link></p>
														</div>
														<br><br>
														<g:if test="${photos}">
														<g:each in="${photos}" status="j" var="photosInstance">
														<div class="1u" style="float:left;color:#000000;font-size:14px;height:200px;width:200px;">
														<g:link controller="photos" action="show" id="${photosInstance.id}"><img src="data:image/png;base64,${photosInstance.imageOne?.encodeBase64()}" width="100" height="100"/><br>${photosInstance.name}</g:link>
														<br><br>
														</div>
														</g:each>
														</g:if>
														<br><br>
												</div>
											
									</section>
									<br><br>
								
							</g:each>
							</g:if>
							</div>
							</div>
							<br><br>
							
							<div class="12u">
							<br><br>
							<g:if test="${photosList}">
							<span style="font-size:25px;color:#000000">
													All Photos:</span>
													<br><br>
							<g:each in="${photosList}" status="i" var="photosInstance">
								
									<section>
												<div class="3u" style="float:left;height:400px;width:300px;">
														<img src="data:image/png;base64,${photosInstance.imageOne?.encodeBase64()}"/>
														<br><br>
														<span style="font-size:16px;color:#000000">${photosInstance.name}</span>
														<br><br>
														<g:if test="${photosInstance.category}">
														<span style="font-size:16px;color:#000000;">Category: <g:link action="show" controller="category" id="${photosInstance.category.id}"><span style="font-size:16px;color:#000000">${photosInstance.category.name}</span></g:link></span>
														<br><br>
														</g:if>
														<g:if test="${photosInstance.blog}">
														<span style="font-size:16px;color:#000000;">Blog: <g:link action="show" controller="blog" id="${photosInstance.blog.id}"><span style="font-size:16px;color:#000000">${photosInstance.blog.name}</span></g:link></span>
														<br><br>
														</g:if>
														<g:if test="${photosInstance.products}">
														<span style="font-size:16px;color:#000000;">Product: <g:link action="show" controller="products" id="${photosInstance.products.id}"><span style="font-size:16px;color:#000000">${photosInstance.products.name}</span></g:link></span>
														<br><br>
														</g:if>
														<button class="button"><g:link controller="photos" action="show" id="${photosInstance.id}"><span style="color:#feff00;">View bigger photo...</span></g:link></button>
														<br><br>
												</div>
									</section>			
									
								
								
							</g:each>
							</g:if>
							
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