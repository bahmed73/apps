<!DOCTYPE HTML>
<html>
	<head>
		<meta name="description" content="Erika Tovar - Loverth." />
<meta name="keywords" content="Art, Clothing, Jewelry, startup, yoga, meditation, logos, online store, books, entrepreneur" />
<meta http-equiv="window-target" content="_top" />
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="PUBLIC">
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<title>Checkout.</title>
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
		  border: 2px solid #fb7b77;
		  border-width: 2px;
		  margin: 5px;
		  padding: 10px;
		  background-color: #ffffff;
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
		
		input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.containerment {
  display: block;
  position: relative;
  padding-left: 35px;
  margin-bottom: 12px;
  cursor: pointer;
  font-size: 22px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Hide the browser's default checkbox */
.containerment input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
  height: 0;
  width: 0;
}

/* Create a custom checkbox */
.checkmark {
  position: absolute;
  top: 0;
  left: 0;
  height: 25px;
  width: 25px;
  background-color: #eee;
}

/* On mouse-over, add a grey background color */
.containerment:hover input ~ .checkmark {
  background-color: #ccc;
}

/* When the checkbox is checked, add a blue background */
.containerment input:checked ~ .checkmark {
  background-color: #2196F3;
}

/* Create the checkmark/indicator (hidden when not checked) */
.checkmark:after {
  content: "";
  position: absolute;
  display: none;
}

/* Show the checkmark when checked */
.containerment input:checked ~ .checkmark:after {
  display: block;
}

/* Style the checkmark/indicator */
.containerment .checkmark:after {
  left: 9px;
  top: 5px;
  width: 5px;
  height: 10px;
  border: solid white;
  border-width: 0 3px 3px 0;
  -webkit-transform: rotate(45deg);
  -ms-transform: rotate(45deg);
  transform: rotate(45deg);
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
	
		<!-- Header Wrapper -->
			<div id="header-wrapper">
				<div class="container">
					
					<div class="row">
						<div class="12u">

							<!-- Banner -->
								<section id="banner">
									
										<g:link class="list" action="index" controller="category"><span class="image image-full"><asset:image src="loverth.png"/></span></g:link>
										<header>
										<!-- 
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
												<li><button class="button"><g:link url="/"><span style="color:#feff00">Home</span></g:link></button></li>
												<!--<li><a href="left-sidebar.html">Login</a></li>-->
											</ul>
										</nav>
							<!-- Intro -->
							
							<div class="row">
							<div class="6u" style="font-size:18px;color:#000000;border-radius: 5px;padding: 20px;">
							<header>
														<span style="font-size:25px;">Checkout:</span>
													</header>
													<br>
													<span style="font-size:20px;">Please validate all required fields.</span>
													<br><br>
													<p>
							User name:<br>
							<f:display bean="checkout" property="userName" /><br><br>
							Email address:<br>
							<f:display bean="checkout" property="emailAddress" /><br><br>
							Mailing Address:<br>
							<f:display bean="checkout" property="address" /><br><br>
							Phone Number:<br>
							<f:display bean="checkout" property="phoneNumber" /><br><br>
							<span style="font-size:24px;color:#16e01b;border:2px solid #e5e1e1">
							Card Amount to be charged. Includes Shipping:<br>
							$<f:display bean="checkout" property="amount" /></span><br><br>
							Use Paypal:<br>
							<f:display bean="checkout" property="usePaypal" /><br><br>
							Use same mailing address for credit card mailing address:<br>
							<f:display bean="checkout" property="sameAddress" /><br><br>
							Domestic Shipment:<br>
							<f:display bean="checkout" property="domesticShipment" /><br><br>
							International Shipment:<br>
							<f:display bean="checkout" property="internationalShipment" /><br><br>
							
					            <button class="button"><span style="color:#feff00">Process Checkout: </span><g:form controller="checkout" action="processCheckout" id="${checkout.id}">
														<script
											  			src="https://checkout.stripe.com/checkout.js" class="stripe-button"
											  			data-key="pk_live_51HQzyoFM8FxBwW6pjn8JJjcSDSg7Zwud4UiVn0H7Opro8SO6W9sy7D5dbhg3AD85wwLGz3K0kUX5gETxAPkN8Ljm00UTOCcWIR"
											  			data-amount="<f:display bean="checkout" property="amount"/>00"
											  			data-name="loverth"
											  			data-description="Purchase"
											  			data-zip-code="true"
											  			data-shipping-address="true"
											  			data-billing-address="true"
											  			
											  			
											  			data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
											  			data-locale="auto">
														</script>
														</g:form></button>
								<button class="button"><g:link controller="checkout" action="edit" id="${checkout.id}"><span style="color:#feff00">Edit Checkout Payment Details</span></g:link></button>
					            
							</p>
							</div>
							
							<div class="6u">
							<header>
														<span style="font-size:25px;color:#000000;border-radius: 5px;padding: 20px;">Shopping Cart:</span>
													</header>
													<br><br>
							<g:if test="${session.shoppingCart}">
														<g:each in="${session.shoppingCart}" status="j" var="productsInstance">
														<div class="3u" style="float:left;margin:10px">
														<g:link controller="products" action="show" id="${productsInstance.id}"><img src="data:image/png;base64,${productsInstance.imageOne?.encodeBase64()}" width="100" height="100"/></g:link>
														<br>
														<span style="color:#000000;font-size:12px;">${productsInstance.name} - ${productsInstance.price}</span>
														</div>
														</g:each>
														</g:if>
							</div>				
										
							<div style="margin:20px;padding:20px;">		
							<button class="button"><g:link controller="checkout" action="reset"><span style="color:#feff00">Reset Shopping Cart</span></g:link></button>
												</div>
							</div>
							<br><br>							
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