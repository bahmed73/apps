<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'campaign.label', default: 'Campaign')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <div>
    <section class="row colset-2-its">
        <a href="#show-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="svg" role="presentation" style="float:center;">
        		<div class="grails-logo-container">
            		<asset:image src="Product-7.png" class="grails-logo" width="900" height="275"/>
            		<!--  <asset:image src="surveys.png" class="grails-logo"/> -->
        	</div>
    		</div>
    		
    	<br><br>	
        
        <div id="list-campaign" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${campaignList}" properties="['name', 'description', 'createTime']" />

            <div class="pagination">
                <g:paginate total="${campaignCount ?: 0}" />
            </div>
        </div>
        
        <div class="svg" role="presentation" style="float:center;">
        		<div class="grails-logo-container">
            		<asset:image src="Product-6.png" class="grails-logo" width="900" height="275"/>
            		<!--  <asset:image src="surveys.png" class="grails-logo"/> -->
        	</div>
    		</div>
        </section>
        </div>
    </body>
</html>