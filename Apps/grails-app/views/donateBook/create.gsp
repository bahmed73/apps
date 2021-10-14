<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'donateBook.label', default: 'DonateBook')}" />
        <title>Donate a Book!</title>
        <ckeditor:resources/>
    </head>
    <body>
        <a href="#create-donateBook" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index">List Book Donations</g:link></li>
            </ul>
        </div>
        <div id="create-donateBook" class="content scaffold-create" role="main">
            <h1>Donate a Book!</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.donateBook}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.donateBook}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save" method="post" enctype="multipart/form-data">
                <fieldset class="form">
                    <f:all bean="donateBook" except="imageOne, imageTwo, imageThree, description"/>
                </fieldset>
                
                <fieldset style="margin-left:340px;">
                  <ckeditor:editor name="description" height="400px" width="80%">
					Write book description here.
					</ckeditor:editor>
              </div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Upload Book Front Cover Image (JPG):</h4></div>
                	<br>
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
