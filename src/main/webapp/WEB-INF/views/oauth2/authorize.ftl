<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>确认授权</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="/css/layout/bootstrap.min.css" rel="stylesheet">
		<link href="/css/layout/bootstrap-responsive.min.css" rel="stylesheet">
		<link href="/css/layout/site.css" rel="stylesheet">
		<link href="https://api.weibo.com/oauth2/css/oauthV3/oauth_web.css?version=20140625" rel="stylesheet"/>
    <script type="text/javascript">
        window.onload=function(){
            window.login=function(){
                var authForm= document.getElementById("authZForm");
                authForm.submit();
            }
        }
    </script>
	</head>
	<body class="WB_UIbody WB_widgets">
    <div class="WB_xline1 oauth_xline" id="outer">
        <div class="oauth_wrap">
            <!-- 带头像  -->
            <div class="WB_panel oauth_main">
                <form id="authZForm" name="authZForm" action="/oauth2/authorize" method="post" node-type="form">
                    <div class="oauth_content" node-type="commonlogin">
                        <p class="oauth_main_info">使用你的微博帐号访问  <a href="http://app.weibo.com/t/feed/37xdvD"  target="_blank" class="app_name">${clientName}</a>
                            ，并同时登录微博</p>
                        <div class="oauth_login clearfix">
                            <input type="hidden" name="action"  id="action" value="authorize"/>
                            <input type="hidden" name="response_type" value="${response_type}"/>
                            <input type="hidden" name="redirect_uri" value="${redirect_uri}"/>
                            <input type="hidden" name="client_id" value="${client_id}"/>
                            <input type="hidden" name="scope" id="scope" value="${scope}"/>
                            <div class="tips WB_tips_yls WB_oauth_tips" node-type="tipBox" style="display:none">
                                <span class="WB_tipS_err"></span><span class="WB_sp_txt" node-type="tipContent" ></span>
                                <span class="arr" node-type="tipArrow"></span>
                                <a href="javascript:;" class="close" node-type="tipClose"></a>
                            </div>
                        </div>
                        <div class="oauth_login_box01 clearfix">
                            <div class="oauth_login_submit">
                                <p class="oauth_formbtn"><a class="WB_btn_link formbtn_01" action-type="submit" onclick="return login();" href="javascript:void(0)" node-type="submit"></a><a class="WB_btn_cancel" action-type="cancel" href="javascript:;" node-type="cancel"></a></p>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </body>
</html>
