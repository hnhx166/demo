<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>微信支付</title>
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
						<h1>
							微信支付
						</h1>
						<fieldset>
							<legend>H5支付</legend>
							<div class="control-group">
								<img src="/images/wechat/icon64_wx_logo.png" onclick="pay()" />
							</div>
						</fieldset>
						<fieldset>
							<legend>扫码支付</legend>
							<div class="control-group">
								<img src="/images/wechat/icon64_wx_logo.png" onclick="pay()" />
							</div>
						</fieldset>
						<fieldset>
							<legend>APP支付</legend>
							<div class="control-group">
								<img src="/images/wechat/icon64_wx_logo.png" onclick="pay()" />
							</div>
						</fieldset>
				</div>
			</div>
		</div>
		<@ftl.js_common_config/>
	</body>
	<script>
		
	</script>
</html>
