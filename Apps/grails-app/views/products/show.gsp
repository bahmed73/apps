<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'products.label', default: 'Products')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-products" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div style="float:left;width:650px">
        <div id="show-products" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <asset:image src="PRODUCTS_${products.id}-03"/>
            <h1><b>Product:</b></h1>
            <h1><i><f:display bean="products" property="name"/></i></h1>
            <h1><f:display bean="products" property="price"/></h1>
            
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

            <g:form resource="${this.products}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.products}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
        </div>
    </body>
</html>
