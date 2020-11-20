<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
	<title><f:display bean="book" property="name"/></title>
	</head>
	<body class="homepage">
	
		<!-- Header Wrapper -->
			<div id="header-wrapper">
				<div class="container">
					
						
							<!-- Intro -->
														<div class="row">
						<div class="12u">
								<section>
									<div>
										<div class="row">
											<div class="12u">
													<section class="box">
													<!-- <a href="http://www.mytweetmark.com" class="image image-full"><asset:image src="foodal-homepage-16.png"/></a> -->
													<header>
														<p><span style="font-size:35px;color:#000000"><f:display bean="book" property="name"/></span></p>
													</header>
													<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Subtitle: <f:display bean="book" property="subtitle"/></span></p>
													<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Author: <f:display bean="book" property="author"/></span></p>
													<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Copyright: <f:display bean="book" property="copyright"/></span></p>
													<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;"><f:display bean="book" property="description"/></span></p>
													<g:if test="${book.imageThree}">
													<div style="border: 2px solid #e5e1e1;">
													<img src="data:image/png;base64,${book.imageThree?.encodeBase64()}" width="250px"/>
													</div>
													</g:if>
													<g:if test="${book.chapters}">
														<g:each in="${book.chapters}" status="j" var="chapterInstance">
														<p><span style="color:#000000;font-size:30px;">Chapter: ${chapterInstance.name}</span></p>
														<p><span style="color:#000000;font-size:18px;">${chapterInstance.description}</span></p>
														<div style="border: 2px solid #e5e1e1;">
													    <img src="data:image/png;base64,${chapterInstance.imageThree?.encodeBase64()}" width="100" height="100"/>
														</div>
														
														</g:each>
														</g:if>
														
													</section>
											</div>
											
										</div>
									</div>
								</section>

						</div>
					</div>
					</div>
					</div>
					
		

	</body>
</html>