<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<#include "/common/header.ftl" />
	<script src="/js/socket/sockjs-0.3.min.js"></script>  
	<script type="text/javascript" src="/js/demo/socket/socket.js"></script>
</head>

<body>
		<#include "/common/menu.ftl" />
		<!-- body -->
		<div style="margin-top: 5%">
			<input type="hidden" id="userName" value="${userName }">
			<div id="show_messages">
				
			</div>
			<div>
				<input id="msg" type="text"/>
			</div>
		</div>
		<#include "/common/footer.ftl" />
</body>
</html>