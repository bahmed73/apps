<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <!--  
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                
            </ul>
        </div>
        -->
         <div id="show-app" class="content scaffold-show" role="main">
            <h1>Product</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="app" property="name" />
        </div>
        
        <div id="show-question" class="content scaffold-show" role="main">
            <h1>Question</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="question" property="name"/>
        </div>
        
        <div id="list-answer" class="content scaffold-list" role="main">
        <h1>Answers</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${answers}" properties="['name', 'createTime']" />
            <div class="pagination">
                <g:paginate total="${answerCount ?: 0}" />
            </div>
        </div>
    </body>
</html>
