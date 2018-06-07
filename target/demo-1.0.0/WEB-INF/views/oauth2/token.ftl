<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>首页</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/css/layout/bootstrap.min.css" rel="stylesheet">
		<link href="/css/layout/bootstrap-responsive.min.css" rel="stylesheet">
		<link href="/css/layout/site.css" rel="stylesheet">
		<link type="text/css" href="https://api.weibo.com/oauth2/css/oauth/oauth_web.css" rel="stylesheet" />
	</head>
	<body class="WB_widgets">
<!-- 内容区 -->
<div class="oauth_wrap">
    <div class="oauth_header clearfix">
        <!--  <h1 class="WB_logo" title="微博">微博</h1>-->
         <p class="login_account"></p>
     </div>
     <!-- 无头像  -->
    <div class="WB_panel oauth_main">
        <div class="oauth_error">
            <div class="oauth_error_content clearfix">
                <dl class="error_content">
                    <dt>令牌与资源信息</dt>
                    <dd>
                     ${accessToken}
                        </br>
                    </dd>
                </dl>
            </div>
            <div class="oauth_copyright"><a href="#">OAUTH2</a>版权所有</div>
        </div>
    </div>
</div>
</body>
</html>
