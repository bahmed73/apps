<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'customerFeedback.label', default: 'CustomerFeedback')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-customerFeedback" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-customerFeedback" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.customerFeedback}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.customerFeedback}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save">
                <fieldset class="form">
                    <f:all bean="customerFeedback" except="project, customer, customerDevelopment, question1, question2, question3, question4, question5, question6, question7, description"/>
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Description:</h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="description" value="" rows="10" cols="80"/>
              	</div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Question 1: ${customerFeedback.question1}</h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="question1" value="" rows="10" cols="80"/>
              	</div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Question 2: ${customerFeedback.question2}</h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="question2" value="" rows="10" cols="80"/>
              	</div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Question 3: ${customerFeedback.question3}</h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="question3" value="" rows="10" cols="80"/>
              	</div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Question 4: ${customerFeedback.question4}</h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="question4" value="" rows="10" cols="80"/>
              	</div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Question 5: ${customerFeedback.question5}</h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="question5" value="" rows="10" cols="80"/>
              	</div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Question 6: ${customerFeedback.question6}</h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="question6" value="" rows="10" cols="80"/>
              	</div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Question 7: ${customerFeedback.question7}</h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="question7" value="" rows="10" cols="80"/>
              	</div>	
                </fieldset>
                <fieldset>
                <f:field bean="customerFeedback" property="project" widget-optionValue="name"/>
                </fieldset>
                <fieldset>
                <f:field bean="customerFeedback" property="customer" widget-optionValue="name"/>
                </fieldset>
                <fieldset>
                <f:field bean="customerFeedback" property="customerDevelopment" widget-optionValue="name"/>
                </fieldset>
                
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
