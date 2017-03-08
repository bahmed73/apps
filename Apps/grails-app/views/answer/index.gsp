<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'answer.label', default: 'Answer')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div>
        <section class="row colset-2-its">
        <a href="#show-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="svg" role="presentation" style="float:center;">
        		<div class="grails-logo-container">
            		<asset:image src="surveys-35.png" class="grails-logo" width="900" height="275"/>
            		<!--  <asset:image src="surveys.png" class="grails-logo"/> -->
        	</div>
    		</div>
    		
    	<br><br>	
        <div id="list-answer" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${answerList}" />

            <div class="pagination">
                <g:paginate total="${answerCount ?: 0}" />
            </div>
        </div>
        
        <br>
        <div class="svg" role="presentation" style="float:center;">
        		<div class="grails-logo-container">
            		<asset:image src="surveys-33.png" class="grails-logo" width="900" height="275"/>
            		<!--  <asset:image src="surveys.png" class="grails-logo"/> -->
        	</div>
    		</div>
        </section>
        </div>
    </body>
</html>