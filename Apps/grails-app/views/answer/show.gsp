<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'answer.label', default: 'Answer')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
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
        <div class="nav" role="navigation">
            <ul>
            <!--  
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>  -->
            </ul>
        </div>
        
        
        
    	<div style="float: center; background-color: #ffffff;border:5px solid #ccc;margin:10px;">
         <div id="show-app" class="content scaffold-show" role="main">
            <h1>Answer</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div style="margin:15px;color:#266870;">
            <h2>
            <f:display bean="answer" property="name" />
            </h2>
            </div>
        </div>
        </div>
        
        <!-- 
        <div style="float: center; background-color: #ffffff;border:5px solid #ccc;margin:10px;">
         <div id="show-app" class="content scaffold-show" role="main">
            <h1>Describe (Optional)</h1>
            <div style="margin:15px;color:#266870;">
            <h2>
            <f:display bean="answer" property="description" />
            </h2>
            </div>
        </div>
        </div>
         -->
         
        <div style="float: center; background-color: #ffffff;border:5px solid #ccc;margin:10px;">
         <div id="show-app" class="content scaffold-show" role="main">
            <h1>Create Time</h1>
            <div style="margin:15px;color:#266870;">
            <h2>
            <f:display bean="answer" property="createTime" />
            </h2>
            </div>
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
