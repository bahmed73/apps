<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'photos.label', default: 'Photos')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-photos" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-photos" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.photos}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.photos}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.photos}" method="POST" enctype="multipart/form-data">
                <g:hiddenField name="version" value="${this.photos?.version}" />
                <fieldset class="form">
                    <f:all bean="photos" except="imageOne, imageTwo, imageThree, category, blog, products"/>
                </fieldset>
                <fieldset>
                <f:field bean="photos" property="category" widget-optionValue="name"/>
                </fieldset>
                <fieldset>
                <f:field bean="photos" property="blog" widget-optionValue="name"/>
                </fieldset>
                <fieldset>
                <f:field bean="photos" property="products" widget-optionValue="name"/>
                </fieldset>
                <fieldset>
                	<div style="float:left;width:50" class="post"><h4>Upload Photo Image (JPG):</h4></div>
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
