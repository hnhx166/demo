<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>qq登录demo</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/css/layout/bootstrap.min.css" rel="stylesheet">
		<link href="/css/layout/bootstrap-responsive.min.css" rel="stylesheet">
		<link href="/css/layout/site.css" rel="stylesheet">
		
		<script type="text/javascript" src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" charset="utf-8" data-callback="true"></script>
	</head>
	<body>
		<div class="container">
			<@ftl.top_menu 1/>
			<div class="row">
				<@ftl.left_menu 8/>
				<div class="span9">
					<h1>
						qq登录demo
					</h1>
						<fieldset>
							登录成功页面
							
							
						</fieldset>
				</div>
			</div>
		</div>
		<@ftl.js_common_config/>
	</body>
	<script>
		
		<script type="text/javascript">
		    QC.Login({
		       btnId:"qqLoginBtn"	//插入按钮的节点id
		
		});
		
		</script>
		
		
	</script>
</html>
