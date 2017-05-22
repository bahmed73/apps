<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main"/>
	<title>Stripe Checkout</title>
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	
	<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
	
	<style type="text/css">
		.container{
			padding:30px;
		}
		.form-group{
			margin:10px 0px;;
		}
		label{
			display:block;
			font-weight:bold;
		}
		label span{
			font-size:11px;
			font-weight:normal;
			display:block;
		}
	</style>
</head>
<body>

	<div class="container">
		<g:form action="checkout" method="post" id="checkout_form" name="checkout_form">
			
			<!-- * Important * you will need to set a hidden form input after retrieving the Stripe Token-->
			<input type="hidden" name="stripeToken" value="" id="stripeToken"/>
			
			<div class="form-group">
				<label>Amount</label>
				<input type="text" name="amount" value="" id="amount" size="7"/>
			</div>
			<div class="form-group">
				<label>Credit Cart # <span>(for testing purposes use 4242424242424242)</span></label>
				<input type="text" name="cc_number" value="4242424242424242" id="cc_number"/>
			</div>
			<div class="form-group">
				<label>CVC <span>(Any 3 numbers)</span></label>
				<input type="text" name="cvc" value="" id="cvc" size="3"/>
			</div>
			<div class="form-group">
				<label>Expiration <span>(MM/YYYY)</span></label>
				<input type="text" name="exp_month" value="" id="exp_month" size="2"/>
					 / 
				<input type="text" name="exp_year" value="" id="exp_year"/>
			</div>
		</g:form>

		<!-- Placing outside the form as we are going to manually submit the form after recieving the Stripe Token from Stripes web service -->
		<div class="form-group">
			<input type="submit" name="submit" size="4" id="submit" value="Stripe Checkout"/>
		</div>
		
	</div>
	

<script type="text/javascript">
			
$(document).ready(function(){

	var $tokenInput = $('#stripeToken'),
		$cardNumberInput = $('#cc_number'),
		$cardCvcInput = $('#cvc'),
		$cardExpMonth = $('#exp_month'),
		$cardExpYear = $('#exp_year'),
		$checkoutForm = $('#checkout_form');

	Stripe.setPublishableKey("YOUR STRIPE PUBLISHABLE KEY");

	$('#submit').click(checkCreditCardValues);
	
	function checkout(){
		console.info('submit form, process payment, create transaction', $checkoutForm);
		$checkoutForm.submit();
	}

	function setStripeTokenInput(code, token){
		console.info("retrieved token : ", token)
		//set hidden stripe token input
		$tokenInput.val(token.id)
		checkout();
	}

	 /**
	 	* IMPORTANT *
	    This is the somewhat tricky part, you will receive a token object in 
	    the callback function arguments.  You want to take this token and set
	    a hidden form input that later will get passed to the server side
	**/
	
	function getStripeToken(){
		console.info('get stripe token')
		Stripe.card.createToken({
		    number    : $cardNumberInput.val(),
		    cvc       : $cardCvcInput.val(),
		    exp_month : $cardExpMonth.val(),
		    exp_year  : $cardExpYear.val()
		}, setStripeTokenInput);
	}


	function checkCreditCardValues(){
		if($cardNumberInput.val() != "" &&
				$cardCvcInput.val() != "" &&
				$cardExpMonth.val() != "" &&
				$cardExpYear.val() != ""){
			getStripeToken();
		}else{
			alert('Please make sure all credit card information is provided')
		}
	}
	
})
</script>			
</body>
</html>