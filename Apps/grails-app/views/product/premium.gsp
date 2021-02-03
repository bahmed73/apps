<!DOCTYPE HTML>
<html>
	<head>
		<meta name="description" content="Building agile development and lean startup tools, for entrepreneurs, venture capital, startups and project manager." />
<meta name="keywords" content="lean startup, customer development, agile development, agile sprints, agile back log, agile backlog, venture capital, startups, entrepreneur, entrepreneurship, customer feedback loop, product development, product roadmap, project management, product backlog" />
<meta http-equiv="window-target" content="_top" />
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="PUBLIC">
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  min-width: 250px;
}

/* Include the padding and border in an element's total width and height */
* {
  box-sizing: border-box;
}

/* Remove margins and padding from the list */
ul {
  margin: 0;
  padding: 0;
}

/* Style the list items */
ul li {
  cursor: pointer;
  position: relative;
  padding: 12px 8px 12px 40px;
  list-style-type: none;
  background: #eee;
  font-size: 18px;
  transition: 0.2s;
  
  /* make the list items unselectable */
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Set all odd list items to a different color (zebra-stripes) */
ul li:nth-child(odd) {
  background: #f9f9f9;
}

/* Darker background-color on hover */
ul li:hover {
  background: #ddd;
}

/* When clicked on, add a background color and strike out text */
ul li.checked {
  background: #888;
  color: #fff;
  text-decoration: line-through;
}

/* Add a "checked" mark when clicked on */
ul li.checked::before {
  content: '';
  position: absolute;
  border-color: #fff;
  border-style: solid;
  border-width: 0 2px 2px 0;
  top: 10px;
  left: 16px;
  transform: rotate(45deg);
  height: 15px;
  width: 7px;
}

/* Style the close button */
.close {
  position: absolute;
  right: 0;
  top: 0;
  padding: 12px 16px 12px 16px;
}

.close:hover {
  background-color: #78789b;
  color: white;
}

/* Style the header */
.header {
  background-color: #78789b;
  padding: 30px 40px;
  color: white;
  text-align: center;
}

/* Clear floats after the header */
.header:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the input */
input {
  margin: 0;
  border: none;
  border-radius: 0;
  width: 75%;
  padding: 10px;
  float: left;
  font-size: 16px;
}

/* Style the "Add" button */
.addBtn {
  padding: 10px;
  width: 25%;
  background: #d9d9d9;
  color: #555;
  float: left;
  text-align: center;
  font-size: 16px;
  cursor: pointer;
  transition: 0.3s;
  border-radius: 0;
}

.addBtn:hover {
  background-color: #bbb;
}
</style>
	<title>Shop - Product Development TODO List</title>
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
		<script async src="https://www.googletagmanager.com/gtag/js?id=UA-154739766-1"></script>
		<script>
		  window.dataLayer = window.dataLayer || [];
		  function gtag(){dataLayer.push(arguments);}
		  gtag('js', new Date());
		
		  gtag('config', 'UA-154739766-1');
		</script>
		
		
	</head>
	<style>
		  p {
		  border: 2px solid #e5e1e1;
		  border-width: 2px;
		  margin: 5px;
		  padding: 10px;
		  background-color: #5f6469;
		  color: #fdeba9;
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
		  background-color: #000000;
		  border: none;
		  border-radius: 15px;
		  box-shadow: 0 9px #999;
		}

		.button:hover {background-color: #a3a6a3}
		
		.button:active {
		  background-color: #3e8e41;
		  box-shadow: 0 5px #666;
		  transform: translateY(4px);
		}
		  </style>
		  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		  <link rel="stylesheet" href="/resources/demos/style.css">
		  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	</head>
	<body class="homepage" onload="testEffect()">
	<script type="text/javascript">
	function testEffect() {
		var options = {};
        // Run the effect
   		$( "#block3" ).effect( "shake", options, 1000, callback );
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
									<a href="http://taote.shop">
										<span class="image image-full"><asset:image src="todolist.png"/></span>
										
									</a>
									
								</section>
								
						</div>
					</div>
					
								<!-- Nav -->
										<nav id="nav">
											
												<div style="padding:2px;padding-top:15px;"><button class="button"><g:link url="/">Home</g:link></button></div>
												<!--<li><a href="left-sidebar.html">Login</a></li>-->
											
										</nav>
							<!-- Intro -->
							<div class="row">
						<div class="12u">
								<section>
									<div id="myDIV" class="header">
									  <span style="margin:5px;font-size:24px;">Product Development TODO List - Add or delete, mark or unmark tasks.</span>
									  <br>
									  <br>
									  <input type="text" id="myInput" placeholder="Add TODO task...">
									  <span onclick="newElement()" class="addBtn">Add</span>
									</div>
									
									<div style="color:#000">
									<ul id="myUL">
										<li class="checked">Talk to shop</li>
									  	<li>Buy a domain name for your website</li>
									  	<li>Buy a cloud server</li>
									  	<li>Setup source control</li>
									  	<li>Create a logo</li>
									  	<li>Pick favorite websites</li>
									  	<li>Pick color palette</li>
									  	<li>Create social media accounts</li>
									  	<li>Sign up on shop</li>
									  	<li>Create a project</li>
									  	<li>Create a blog</li>
									  	<li>Create a user guide</li>
									  	<li>Write an executive summary</li>
									  	<li>Do customer development</li>
									  	<li>Iterate on product development</li>	
									  	<li>Pitch to venture capitals</li>								  	
									</ul>
									</div>
									<script>
									// Create a "close" button and append it to each list item
									var myNodelist = document.getElementsByTagName("LI");
									var i;
									for (i = 0; i < myNodelist.length; i++) {
									  var span = document.createElement("SPAN");
									  var txt = document.createTextNode("\u00D7");
									  span.className = "close";
									  span.appendChild(txt);
									  myNodelist[i].appendChild(span);
									}
									
									// Click on a close button to hide the current list item
									var close = document.getElementsByClassName("close");
									var i;
									for (i = 0; i < close.length; i++) {
									  close[i].onclick = function() {
									    var div = this.parentElement;
									    div.style.display = "none";
									  }
									}
									
									// Add a "checked" symbol when clicking on a list item
									var list = document.querySelector('ul');
									list.addEventListener('click', function(ev) {
									  if (ev.target.tagName === 'LI') {
									    ev.target.classList.toggle('checked');
									  }
									}, false);
									
									// Create a new list item when clicking on the "Add" button
									function newElement() {
									  var li = document.createElement("li");
									  var inputValue = document.getElementById("myInput").value;
									  var t = document.createTextNode(inputValue);
									  li.appendChild(t);
									  if (inputValue === '') {
									    alert("You must write something!");
									  } else {
									    document.getElementById("myUL").appendChild(li);
									  }
									  document.getElementById("myInput").value = "";
									
									  var span = document.createElement("SPAN");
									  var txt = document.createTextNode("\u00D7");
									  span.className = "close";
									  span.appendChild(txt);
									  li.appendChild(span);
									
									  for (i = 0; i < close.length; i++) {
									    close[i].onclick = function() {
									      var div = this.parentElement;
									      div.style.display = "none";
									    }
									  }
									}
									</script>
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
						<a href="/"><asset:image src="logoshop5.png" width="150px" height="150px"/></a>
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
									
											<h3>Oakland, California</h3>
											
										
											<h3><a href="bilal@mytweetmark.com">bilal@mytweetmark.com</a></h3>
										
										<!--li>
											<h3>Phone</h3>
											<p>(800) 000-0000</p>
										</li-->
									
								</section>
								

							</div>
							
							<div class="4u">

								<section>
									<header>
										<h2>More about us</h2>
									</header>
									
										<a href="https://facebook.com/dotshopper/"><h3>On Facebook</h3></a>
										<a href="http://bilalahmed.org"><h3>Our Website</h3></a>
									
								</section>
				
							</div>
							 
							<div class="4u">
							<section>
									<header>
										<h2>And more...</h2>
									</header>
									
										<a href="https://www.youtube.com/user/bahmed73"><h3>On YouTube</h3></a>
										<a href="https://twitter.com/taoteshop"><h3>On Twitter</h3></a>
										<!--li><a href="#">Sem feugiat sapien id suscipit magna felis nec</a></li>
										<li><a href="#">Elit class aptent taciti sociosqu ad litora</a></li-->
									
								</section>
								
							
							</div>
						</div>
						<div class="row">
							<div class="10u">
							
								<!-- Copyright -->
									<div id="copyright">
										
											&copy; 2020 Shop 	
											<!--li>Images: <a href="http://facebook.com/homecookme">Homecookme</a></li>
											<li>Design: <a href="http://dalliusdesign.com">Dallius</a></li-->
										
									</div>

							</div>
						</div>
					</section>
				
			</div>

	</body>
</html>