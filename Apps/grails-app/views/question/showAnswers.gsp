<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
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
    	<div style="float: center; background-color: #ffffff;border:5px solid #ccc;margin:10px;">
         <div id="show-app" class="content scaffold-show" role="main">
            <h1>Product Views: ${viewCounter} </h1>
            <div style="margin:15px;color:#266870;">
            <h2>
            <f:display bean="app" property="name" />
            </h2>
            </div>
        </div>
        </div>
        
        <div style="float: center; background-color: #ffffff;border:5px solid #ccc;margin:10px;">
        <div id="show-question" class="content scaffold-show" role="main">
            <h1>Question</h1>
            <div style="margin:15px;color:#266870;">
            <h2>
            <f:display bean="question" property="name"/>
            </h2>
            </div>
        </div>
        </div>
        
        <div style="float: center; background-color: #ffffff;border:5px solid #77777c;margin:10px;">
        <div id="create-answer" class="content scaffold-create" role="main">
            <h1>Answer this Question</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:form action="answerQuestion" controller="question">
            <g:hiddenField name="question" value="${question.id}" />
            <g:field type="text" size="55" name="answer" value="Answer this question here and then click on 'Save my answer' below..."/>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="Save my answer" />
                </fieldset>
            </g:form>
        </div>
        </div>
        
        <div style="float: center; background-color: #ffffff;border:5px solid #ccc;margin:10px;">
        <div id="list-answer" class="content scaffold-list" role="main">
        <h1>Answers</h1>
            <f:table collection="${answers}" properties="['name', 'createTime']" />
            <!-- 
            <div class="pagination">
                <g:paginate total="${answerCount ?: 0}" params="[questionId: question.id]" />
            </div>
             -->
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
    </body>
</html>
