<!DOCTYPE HTML>
<html>
	<head>
		<meta name="description" content="bookly.love - books" />
<meta name="keywords" content="Books, Publish, Marketing, pdf, text, images, image, video, photo, distribute, distribution, Garments, Art, Clothing, Jewelry, startup, online store, entrepreneur" />
<meta http-equiv="window-target" content="_top" />
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="PUBLIC">
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<title><f:display bean="book" property="name"/></title>
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
		border: 2px solid #78789b;
		  border-width: 2px;
		  border-radius: 25px;
		  margin: 5px;
		  padding: 20px;
		  background-color: #d23b2a;
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
		  background-color: #d23b2a;
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
		
		p:hover, h1:hover, a:hover {
		  background-color: black;
		}
		</style>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		  <!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-0PKFTJLWYP"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'G-0PKFTJLWYP');
</script>
		  
	</head>
	<body class="homepage" onload="testEffect()">
	<script type="text/javascript">
	function testEffect() {
	      // Most effect types need no options passed by default
	      var options = {};
	           // Run the effect
	      $( "#block1" ).effect( "bounce", options, 500, callback );
	      $( "#block2" ).effect( "explode", options, 500, callback );
	      $( "#block3" ).effect( "pulsate", options, 500, callback );
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
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v5.0&appId=261449270414&autoLogAppEvents=1"></script>
		<!-- Header Wrapper -->
			<div id="header-wrapper">
				<div class="container">
					
					<div class="row">
						<div class="12u">

							<!-- Banner -->
								<section id="banner">
									
										<g:link class="list" action="index" controller="blogCategory"><span class="image image-full"><asset:image src="bookly.gif"/></span></g:link>
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
												<li><button class="button"><g:link controller="book" action="edit" id="${book.id}"><span style="color:#feff00">Edit Book</span></g:link></button></li>
												<li><button class="button"><g:link controller="book" action="index"><span style="color:#feff00">Show Books</span></g:link></button></li>
												<li><button class="button"><g:link controller="chapter" action="index"><span style="color:#feff00">Show Chapters</span></g:link></button></li>
												<li><button class="button"><g:link controller="blogCategory" action="index"><span style="color:#feff00">Show Categories</span></g:link></button></li>
												<li><button class="button"><div class="fb-share-button" data-href="${createLink(action: 'show', controller: 'book', id: book.id)}" data-layout="button" data-size="small"><a target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fbookly.love%2F&amp;src=sdkpreparse" class="fb-xfbml-parse-ignore"><span style="color:#feff00">Share</span></a></div></button></li>
												<li><button class="button"><a href="https://twitter.com/share?ref_src=twsrc%5Etfw" class="twitter-share-button" data-show-count="false"><span style="color:#feff00">Tweet</span></a><script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script></button></li>
												<li><button class="button"><g:form resource="${this.book}" method="DELETE" controller="book" action="delete">
												    <fieldset class="buttons">
									                	<input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
									                </fieldset>
									                
									            </g:form>
									            </button>
									            </li>
												<br><br>
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
														<span style="font-size:35px;color:#000000"><f:display bean="book" property="name"/></span>
													</header>
													<br><br>
													<span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;"><f:display bean="book" property="description"/></span>
													<br><br>
													<br><br>
													
													<span style="font-size:25px;color:#000000">
													Category:</span> 
													<br><br>
													
													<p><g:link controller="blogCategory" action="show" id="${book.blogCategory.id}"><br><span style="font-size:20px;color:#ffffff;font-family: Arial, Helvetica, sans-serif;">${book.blogCategory.name}</span></g:link></p>
													
												</section>
											</div>
											<div>
												<section class="box">
												<header>
												<g:if test="${book.imageThree}">
													<div style="border: 2px solid #e5e1e1;">
													<p><img src="data:image/png;base64,${book.imageThree?.encodeBase64()}" width="250px"/></p>
													<br>
													<br>
													
													</div>
													
												</g:if>
												<br><br>
													<p>
													<g:link class="list" action="export" controller="book" id="${book.id}"><span style="color:#ffffff;font-size:40px;">Download</span></g:link>
													</p>
													<br>
													
													
													<br><br>
													
												</header>
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
											<div class="12u">
												<section class="box">
												<header>
													<g:if test="${chapters}">
													<span style="font-size:25px;color:#000000">
													Chapters:</span>
													<br><br>
													<g:each in="${chapters}" status="i" var="chapterInstance">
													<div class="3u" style="float:left;height:400px;width:275px;">
													<p style="float:left;height:350px;width:250px;"><g:link controller="chapter" action="show" id="${chapterInstance.id}"><span style="color:#ffffff;font-size:20px;"><br><img src="data:image/png;base64,${chapterInstance.imageOne?.encodeBase64()}"/><br><br>${chapterInstance.name}</span></g:link></p>
													</div>
													</g:each>
													</g:if>
													<br><br>
													
												</header>
													
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