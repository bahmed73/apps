<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'customerFeedback.label', default: 'CustomerFeedback')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-customerFeedback" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-customerFeedback" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
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
            <g:form resource="${this.customerFeedback}" method="PUT">
                <g:hiddenField name="version" value="${this.customerFeedback?.version}" />
                <fieldset class="form">
                    <f:all bean="customerFeedback" except="project, customer, customerDevelopment, question1, question2, question3, question4, question5, question6, question7, description"/>
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Description:</h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="description" value="${customerFeedback.description}" rows="10" cols="80"/>
              	</div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Question / Metrics: How would you feel if you no longer used our product?: </h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="question1" value="${customerFeedback.question1}" rows="10" cols="80"/>
              	</div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Question / Recommendation: Have you recommended our product to anyone?: </h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="question2" value="${customerFeedback.question2}" rows="10" cols="80"/>
              	</div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Question / Referrer: How did you discover our product?: </h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="question3" value="${customerFeedback.question3}" rows="10" cols="80"/>
              	</div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Question / Alternatives: What product would you use, if ours is not available?: </h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="question4" value="${customerFeedback.question4}" rows="10" cols="80"/>
              	</div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Question / Benefits: What are the primary benefits, using our product?: </h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="question5" value="${customerFeedback.question5}" rows="10" cols="80"/>
              	</div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Question / Audience: What type of person would be using our product?: </h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="question6" value="${customerFeedback.question6}" rows="10" cols="80"/>
              	</div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Question / Improvement: How can we improve our product to meet your needs?: </h4></div>
                	<br>
              				Write your answer here and use html tags for styling.<br>
              		<div>
                  <g:textArea name="question7" value="${customerFeedback.question7}" rows="10" cols="80"/>
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
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
