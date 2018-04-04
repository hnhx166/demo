<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<#include "/common/header.ftl" />
</head>
<body style="overflow-y: hidden">
		<#include "/common/menu.ftl" />
	<div>
		<!-- 自己的内容 -->
		<div class="container">
			<link href="/js/videojs/css/video-js.css" rel="stylesheet">	
			<style>
				body{background-color: #191919}
				.m{ width: 740px; height: 400px; margin-left: auto; margin-right: auto; margin-top: 100px; }
			</style>
			<video id="my-video" class="video-js" controls preload="auto" width="740" height="400"
			  poster="m.png" data-setup="{}">
				<source src="/js/videojs/js/462693daff750d91eba229f95e21f61b.mp4" type="video/mp4">
				<p class="vjs-no-js">
				  To view this video please enable JavaScript, and consider upgrading to a web browser that
				  <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
				</p>
			  </video>
			  <script src="/js/videojs/js/video.min.js"></script>
			  <script type="text/javascript">
					var myPlayer = videojs('my-video');
					videojs("my-video").ready(function(){
						var myPlayer = this;
						myPlayer.play();
					});
				</script>
		</div>
	</div>
	
	
		<#include "/common/footer.ftl" />
</body>
</html>