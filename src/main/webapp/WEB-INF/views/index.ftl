<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>首页</title>
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
						<fieldset>
							<legend>支付测试</legend>
							<div class="control-group">
								<label class="control-label" for="input01">项目名称</label>
								<div class="controls">
									<input type="button" id="choosePay" name="choosePay" class="input-xlarge" value="支付测试" placeholder="项目名称"/>
									<a href="/wx_pay/choose_pay.vhtml">选择支付方式</a>
								</div>
							</div>
							数据:${t}
						</fieldset>
				</div>
			</div>
		</div>
		<@ftl.js_common_config/>
	</body>
	<script>
		
	</script>
</html>
