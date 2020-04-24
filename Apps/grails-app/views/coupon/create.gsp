<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="Event" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <ckeditor:resources/>
    </head>
    <body>
        <a href="#create-coupon" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index">Event List</g:link></li>
            </ul>
        </div>
        <div id="create-coupon" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.coupon}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.coupon}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save" method="post" enctype="multipart/form-data">
                <fieldset class="form">
                    <f:all bean="coupon" except="imageOne, imageTwo, imageThree, description"/>
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Description:</h4></div>
                	<br>
              				
              		<div>
                  <ckeditor:editor name="description" height="400px" width="80%">
                  Write your event description here.
					</ckeditor:editor>
              </div>	
                </fieldset>
                <fieldset>
                	<div style="float:left;width:50" class="post"><h4>Upload Event Image (JPG):</h4></div>
              				Please be patient while the file uploads.<br>
              		<div>
                  <input type="file" name="myFile" />
              </div>	
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
