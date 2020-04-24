<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'blog.label', default: 'Blog')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
        <ckeditor:resources/>
    </head>
    <body>
        <a href="#edit-blog" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-blog" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.blog}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.blog}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.blog}" method="POST" enctype="multipart/form-data">
                <g:hiddenField name="version" value="${this.blog?.version}" />
                <fieldset class="form">
                    <f:all bean="blog" except="imageOne, imageTwo, imageThree, description, blogCategory"/>
                </fieldset>
                <fieldset>
                <f:field bean="blog" property="blogCategory" widget-optionValue="name"/>
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Description:</h4></div>
                	<br>              				
              		<div>
                  <ckeditor:editor name="description" height="400px" width="80%">
					${blog.description}
					</ckeditor:editor>
              </div>	
                </fieldset>
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Upload Blog Image (JPG):</h4></div>
                	<br>
              				Please be patient while the file uploads.<br>
              		<div>
                  <input type="file" name="myFile" />
              </div>	
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
