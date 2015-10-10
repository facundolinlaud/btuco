<#macro frame head="">
	<!DOCTYPE html>
	<html>
		<head>
			<#include "/commons/partials/scripts.ftl">
			<title>btuco</title>
			${head}
		</head>
		
		<body>
			<#nested>
		</body>
	</html>
</#macro>