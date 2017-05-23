<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'products.label', default: 'Products')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
    <div>
     <section class="row colset-2-its">
        <a href="#show-products" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <sec:ifLoggedIn>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        </sec:ifLoggedIn>
        <div id="show-products" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div style="float: left; border:1px solid #ccc;zoom:1;">
            <div style="float:left; margin:30px;">
            <div style="float:left;margin:10px;border:1px solid #ccc;zoom:1;">
             <div style="float: left; font-size:16px;margin:25px;margin-left:50px;">
            <asset:image src="PRODUCTS_${products.id}-03"/>
            </div>
            <h1>Name: <i><b><f:display bean="products" property="name"/></i></b></h1>
            <h1>Price: <i><b>$<f:display bean="products" property="price"/></i></b></h1>
            <h1>Views: ${productViews}</h1>
            </div>
            <br><br>
            <div style="float:left">
            <br>
            <h4>Description: <f:display bean="products" property="description"/></h4><br>
            <h4>Size: <f:display bean="products" property="productSize"/></h4><br>
            <h4>Color: <f:display bean="products" property="productColor"/></h4>
            <br>
            <h2>Shipping Info: <f:display bean="products" property="shippingInfo"/></h2>
            <h2>Return Policy: <f:display bean="products" property="returnPolicy"/></h2>
            <br>
            </div>
            <div style="float:left">
            <br>
            <form action="checkout" controller="checkout" method="POST">
			<script
  			src="https://checkout.stripe.com/checkout.js" class="stripe-button"
  			data-key="pk_test_VBLyN579809ToN0y2VA4VXG8"
  			data-amount="${products.price}"
  			data-name="foodal"
  			data-description="${products.name}"
  			data-zip-code="true"
  			data-shipping-address="true"
  			data-billing-address="true"
  			
  			
  			data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
  			data-locale="auto">
			</script>
			</form>

			<br><br>
			</div>
			</div>
			<sec:ifLoggedIn>
            <g:form resource="${this.products}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.products}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
            </sec:ifLoggedIn>
            </div>
            
           
            
        </div>
        </section>
        </div>
    </body>
</html>
