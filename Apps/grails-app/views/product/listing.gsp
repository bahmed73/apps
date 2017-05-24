<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'appType.label', default: 'AppType')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
        google.charts.load('current', {'packages':['corechart']});
      	google.setOnLoadCallback(drawChart);
      	function drawChart() {
        var data = new google.visualization.DataTable();

        data.addColumn('string', 'Referrer');
        data.addColumn('number', 'Amount(Count)');
        data.addRows(${productRefererInstanceTotal});

        <g:each in="${productRefererMap}" status="i" var="productRefererMapInstance">
        data.setValue(${i}, 0, '${productRefererMapInstance.key}');
        data.setValue(${i}, 1, ${productRefererMapInstance.value});
        </g:each>

        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, {width: 400, height: 240, title: 'Referrer Distribution Chart'});
      	}
    </script>
    </head>
    <body>
        <a href="#list-appType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create" controller="app">App</g:link></li>
            </ul>
        </div>
        <div id="list-appType" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div id="chart_div"></div>
        </div>
    </body>
</html>