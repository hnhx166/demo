<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<#include "/common/header.ftl" />
</head>

<body style="overflow-y: hidden">
		<#include "/common/menu.ftl" />
		<!-- body -->
		<div style="margin-top: 5%" th:include="this :: content">
			
		
		</div>
		<#include "/common/header.ftl" />
</body>
</html>