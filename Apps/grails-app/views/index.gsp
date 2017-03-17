<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Surveys!</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
<!--
    <content tag="nav">
    	  
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Environment: ${grails.util.Environment.current.name}</a></li>
                <li><a href="#">App profile: ${grailsApplication.config.grails?.profile}</a></li>
                <li><a href="#">App version:
                    <g:meta name="info.app.version"/></a>
                </li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Grails version:
                    <g:meta name="info.app.grailsVersion"/></a>
                </li>
                <li><a href="#">Groovy version: ${GroovySystem.getVersion()}</a></li>
                <li><a href="#">JVM version: ${System.getProperty('java.version')}</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Artefacts <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>
                <li><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>
                <li><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>
                <li><a href="#">Tag Libraries: ${grailsApplication.tagLibClasses.size()}</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Installed Plugins <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                    <li><a href="#">${plugin.name} - ${plugin.version}</a></li>
                </g:each>
            </ul>
        </li>
        
    </content>
-->
    

	<div >
        <section class="row colset-2-its">
        
        <div style="float:left;">
        <div class="svg" role="presentation" style="float:center;">
        		<div class="grails-logo-container">
            		<asset:image src="mytweetmark-v3.png" class="grails-logo" width="900" height="275"/>
            		<!--  <asset:image src="surveys.png" class="grails-logo"/> -->
        	</div>
    		</div>
    		</div>
    	<br>	
            
			
			<!--  <div style="float: left; width: 270px; background-color: #ffffff;font-size:4;margin:10px;">
				<span style="margin-left:30px;"><g:link controller="appType" action="index"> <asset:image src="surveys-types.png" width="200" height="53"/></g:link></span><br>
    		</div>-->
    		<!--  
			<div style="float: left; width:271px; background-color: #ffffff;border:1px solid #ccc;margin:10px;">
    			<span style="margin:35px;"><g:link controller="app" action="index"><asset:image src="surveys-surveys.png" width="200" height="53"/></g:link></span><br>
    			<div style="float: left; background-color: #ffffff;font-size:4;margin:15px;">
    				<span style="margin:50px;">Create a Survey</span><br>
    			</div>
    		</div>
    		-->
    		<!--  
    		<div style="float: left; width: 270px; background-color: #ffffff;font-size:4;margin:10px;">
    			<span style="margin-left:30px;"><g:link controller="campaign" action="index"><asset:image src="surveys-campaigns.png" width="200" height="53"/></g:link></span><br>
    		</div>-->
    		<div id="show-product" class="content scaffold-show" role="main">
    		
    		<div style="float: left; width:400px; background-color: #ffffff;border:5px solid #ccc;margin:20px;">
    			<!--   <span style="margin:100px;"><g:link controller="product" action="index"><asset:image src="surveys-answers.png" width="200" height="53"/></g:link></span><br>-->
    			<div style="float: left; background-color: #ffffff;font-size:4;margin:15px;color:#266870;">
    				<span style="margin:120px;"><g:link controller="product" action="index">Sell a Product</g:link></span><br>
    			</div>
    		</div>
    		
    		<div style="float: left; width:400px; background-color: #ffffff;border:5px solid #ccc;margin:20px;">
    			<!--   <span style="margin:100px;"><g:link controller="campaign" action="index"><asset:image src="surveys-answers.png" width="200" height="53"/></g:link></span><br>-->
    			<div style="float: left; background-color: #ffffff;font-size:4;margin:15px;color:#266870;">
    				<span style="margin:120px;"><g:link controller="campaign" action="index">Start a Campaign</g:link></span><br>
    			</div>
    		</div>
    		
    		<div style="float: left; width:400px; background-color: #ffffff;border:5px solid #ccc;margin:20px;">
    			<!--  <span style="margin:100px;"><g:link controller="question" action="index"><asset:image src="surveys-questions.png" width="200" height="53"/></g:link></span><br>-->
    			<div style="float: left; background-color: #ffffff;font-size:4;margin:15px;color:#266870;">
    				<span style="margin:120px;"><g:link controller="question" action="index">Ask a Question</g:link></span><br>
    			</div>
    		</div>
    		<div style="float: left; width:400px; background-color: #ffffff;border:5px solid #ccc;margin:20px;">
    			<!--   <span style="margin:100px;"><g:link controller="answer" action="index"><asset:image src="surveys-answers.png" width="200" height="53"/></g:link></span><br>-->
    			<div style="float: left; background-color: #ffffff;font-size:4;margin:15px;color:#266870;">
    				<span style="margin:120px;"><g:link controller="answer" action="index">Check Answers</g:link></span><br>
    			</div>
    		</div>
			
			<div style="float: left; width:400px; background-color: #ffffff;border:5px solid #ccc;margin:20px;">
    			<!--   <span style="margin:100px;"><g:link controller="review" action="index"><asset:image src="surveys-answers.png" width="200" height="53"/></g:link></span><br>-->
    			<div style="float: left; background-color: #ffffff;font-size:4;margin:15px;color:#266870;">
    				<span style="margin:120px;"><g:link controller="review" action="index">Check Reviews</g:link></span><br>
    			</div>
    		</div>
    		
    		<div style="float: left; width:400px; background-color: #ffffff;border:5px solid #ccc;margin:20px;">
    			<!--   <span style="margin:100px;"><g:link controller="review" action="index"><asset:image src="surveys-answers.png" width="200" height="53"/></g:link></span><br>-->
    			<div style="float: left; background-color: #ffffff;font-size:4;margin:15px;color:#266870;">
    				<span style="margin:120px;"><g:link controller="discount" action="index">Check Discounts</g:link></span><br>
    			</div>
    		</div>
			</div>
    		
            
            
            <div style="float:left;">
            <div class="svg" role="presentation" style="float:center;">
        		<div class="grails-logo-container">
            		<asset:image src="Discount-2.png" class="grails-logo" width="900" height="275"/>
            		<!--  <asset:image src="surveys.png" class="grails-logo"/> -->
        	</div>
    		</div>
    		</div>
    		<br>

			<!-- 
			
			<h1>
			
			<div style="float: left; width:271px; background-color: #ffffff;border:1px solid #ccc;margin:10px;margin-top:40px;">
    			<span style="margin:35px;"><g:link controller="appType" action="index"><asset:image src="surveys-types.png" width="200" height="53"/></g:link></span><br>
    			<div style="float: left; background-color: #ffffff;font-size:4;margin:15px;">
    				<span style="margin:50px;">Survey Types</span><br>
    			</div>
    		</div>
    		<div style="float: left; width:271px; background-color: #ffffff;border:1px solid #ccc;margin:10px;margin-top:40px;margin-bottom:20px;">
    			<span style="margin:35px;"><g:link controller="campaign" action="index"><asset:image src="surveys-campaigns.png" width="200" height="53"/></g:link></span><br>
    			<div style="float: left; background-color: #ffffff;font-size:4;margin:15px;">
    				<span style="margin:50px;">Run Campaigns</span><br>
    			</div>
    		</div>
    		
            </h1>
             -->
        </section>
    </div>

</body>
</html>
