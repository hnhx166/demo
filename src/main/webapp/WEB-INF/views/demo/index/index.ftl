<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<title>首页</title>
	<#include "/common/header.ftl" />
	<style type="text/css">
		.ul .li{
			padding:5px;
		}
	</style>
</head>

<body>
		<#include "/common/menu.ftl" />
		<!-- body -->
		<div style="margin-top: 5%">
			<ul class="ul">
				<li>1、websocket 实现多人实时聊天</li>
				<li>2、实现视频播放弹幕</li>
				<li>3、实现每月账单统计</li>
				<li>4、实现单词收集</li>
				<li>5、实现文章收集</li>
				<li>6、</li>
				<li>redis 后台启动：设置redis.config 中 daemonize为yes</li>
				<li>sqlite下载、使用： https://bitbucket.org/xerial/sqlite-jdbc</li>
				<li>爬虫技术</li>
				<li>elk , bi </li>
				<li>hadoop， habase，es,resume 编程</li>
				<li>vue，react</li>
			</ul>
			
		</div>
		<#include "/common/footer.ftl" />
</body>
</html>