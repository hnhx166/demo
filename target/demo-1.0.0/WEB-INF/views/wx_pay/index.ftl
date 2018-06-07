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
							<legend>支付测试</legend>
							<div class="control-group">
								<label class="control-label" for="input01">项目名称</label>
								<div class="controls">
									<input type="button" id="choosePay" name="choosePay" class="input-xlarge" value="支付测试" placeholder="项目名称"/>
									<a href="/wx_pay/choose_pay.vhtml">选择支付方式</a>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="input01">订单查询</label>
								<div class="controls">
									<input type="button" id="queryOrder" name="queryOrder" class="input-xlarge"  value="订单查询" placeholder="主域名"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="input01">关闭订单</label>
								<div class="controls">
									<input type="button" id="closeOrder" name="closeOrder" class="input-xlarge" value="关闭订单" placeholder="二级域名" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="input01">申请退款</label>
								<div class="controls">
									<input type="button" id="groupType" name="groupType" class="input-xlarge" value="申请退款" placeholder="请输入域名分组" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="input01">查询退款</label>
								<div class="controls">
									<input type="button" id="groupType" name="groupType" class="input-xlarge" value="查询退款" placeholder="请输入域名分组" />
								</div>
							</div>
							
							<#--
							<div class="control-group">
								<label class="control-label" for="input01">使用状态</label>
								<div class="controls">
									<input id="otherTwo_1" type="radio" style="float:left;" name="otherTwo" <#if domain?exists><#if domain.otherTwo?exists && domain.otherTwo=="0">checked<#elseif !(domain.otherTwo?exists)>checked</#if><#else>checked</#if> value="0"/>&nbsp;&nbsp;&nbsp;&nbsp;<label style="width:40px;float:left;" for="otherTwo_1">激活</label>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input id="otherTwo_2" type="radio" style="float:left;" name="otherTwo" <#if domain?exists><#if domain.otherTwo?exists && (domain.otherTwo=="1")>checked</#if></#if> value="1"/>&nbsp;&nbsp;&nbsp;&nbsp;<label style="width:40px;float:left;" for="otherTwo_2">禁止</label>
								</div>
							</div>
							
							<div class="form-actions">
								<input type="submit" value="保存" class="btn btn-primary" /> <input type="button" class="btn" value="取消" onclick="javascript:window.location.href='/domain/list.vhtml<#if k?exists>?${k}=${v}</#if>';" />
							</div>
							-->
						</fieldset>
				</div>
			</div>
		</div>
		<@ftl.js_common_config/>
	</body>
	<script>
		
	</script>
</html>
