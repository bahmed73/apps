<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'donateBook.label', default: 'DonateBook')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
        <ckeditor:resources/>
    </head>
    <body>
        <a href="#edit-donateBook" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-donateBook" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
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
            <g:form resource="${this.donateBook}"  method="POST" enctype="multipart/form-data">
                <g:hiddenField name="version" value="${this.donateBook?.version}" />
                <fieldset class="form">
                    <f:all bean="book" except="imageOne, imageTwo, imageThree, description"/>
                </fieldset>
                <fieldset style="margin-left:340px;">
                <div style="float:left;width:50" class="post"><h4>Name:</h4></div>
                	<br>
              		
                <g:field type="text" name="name" min="5" max="500" required="" value="${donateBook?.name}"/>
                <br>
              		<br>
              		
                <div style="float:left;width:50" class="post"><h4>Subtitle:</h4></div>
                	<br>
              		
                <g:field type="text" name="subtitle" min="5" max="500" required="" value="${donateBook?.subtitle}"/>
                
                <br>
              	<br>
              	<div style="float:left;width:50" class="post"><h4>Author:</h4></div>
                	<br>
              		
                <g:field type="text" name="author" min="5" max="500" required="" value="${donateBook?.author}"/>
                <br>
              		<br>
              	
              		
                	<div style="float:left;width:50" class="post"><h4>Description:</h4></div>
                	<br>
              				
              		<div>
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
              <div style="float:left;width:50" class="post"><h4>Owner Name:</h4></div>
                	<br>
              		
                <g:field type="text" name="ownerName" min="5" max="500" required="" value="${donateBook?.ownerName}"/>
                <br>
              		<br>
              <div style="float:left;width:50" class="post"><h4>Owner Phone:</h4></div>
                	<br>
              		
                <g:field type="text" name="ownerPhone" min="5" max="500" required="" value="${donateBook?.ownerPhone}"/>
                <br>
              		<br>
              		
                
                <div style="float:left;width:50" class="post"><h4>Owner Address:</h4></div>
                	<br>
              		
                <g:field type="text" name="ownerAddress" min="5" max="500" required="" value="${donateBook?.ownerAddress}"/>
                <br>
              		<br>
              <div style="float:left;width:50" class="post"><h4>Owner Email:</h4></div>
                	<br>
              		
                <g:field type="text" name="ownerEmail" min="5" max="500" required="" value="${donateBook?.ownerEmail}"/>
                <br>
              		<br>
              </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
