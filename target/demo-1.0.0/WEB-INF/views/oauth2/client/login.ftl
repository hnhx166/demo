<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>用户登录</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/css/layout/bootstrap.min.css" rel="stylesheet">
		<link href="/css/layout/bootstrap-responsive.min.css" rel="stylesheet">
		<link href="/css/layout/site.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<@ftl.top_menu 1/>
			<div class="row">
				<@ftl.left_menu 8/>
				<div class="span9">
						<form action="/signin" method="POST">
						    客户端</br>
						    <input type="text" name="name" value="Irving" /> </br>
						    <input type="password" name="pwd" value="123456"/></br>
						    <a href="/oauth2/authorize?client_id=fbed1d1b4b1449daa4bc49397cbe2350&response_type=code&redirect_uri=http://localhost:8080/oauth_callback">
						        OAuth2登录
						    </a></br>
						    <input type="submit" value="登录"/>
						</form>
				</div>
			</div>
		</div>
		<@ftl.js_common_config/>
	</body>
	<script>
		
	</script>
</html>
