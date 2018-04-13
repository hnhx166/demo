<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>navigator.mediaDevices实现调用相机</title>
<#include "/common/header.ftl" />
<style>
.booth {
	width: 400px;
	background: #ccc;
	border: 10px solid #ddd;
	margin: 0 auto
}
</style>
</head>
<body>
	<#include "/common/menu.ftl" />
	<article>
		<section>
			<video id="video"></video>
		</section>
		<section>
			<audio id="audio"></audio>
		</section>
		<button id="btn">拍照</button>
		<section>
			<canvas id="canvas"></canvas>
		</section>
		<section>
			<img src="" alt="" id="img">
		</section>
	</article>
	<!-- <article>
		<header>相关知识</header>
		<h2>获取用户媒体:</h2>
		<p>
			<code>navigator.mediaDevices.getUserMedia({video: true, audio:
				true}) // 异步操作</code>
		</p>
		<h2>枚举媒体数:video,audio输入输出设备</h2>
		<p>
			<code>navigator.mediaDevices.enumerateDevices() // 异步操作</code>
		</p>
	</article> -->

	<#include "/common/footer.ftl" />
</body>
<script>
    let convas = document.querySelector("#canvas"); //
    let video = document.querySelector("#video");
    let audio = document.querySelector("audio");
    let img = document.querySelector("#img");
    let btn = document.querySelector("button");
    let context = canvas.getContext('2d');
    let width = 320; //视频和canvas的宽度
    let height = 0; //
    let streaming = false; // 是否开始捕获媒体
    
    // 获取用户媒体,包含视频和音频
    navigator.mediaDevices.getUserMedia({video: true, audio: false})
      .then(stream => {
       video.srcObject = stream; // 将捕获的视频流传递给video  放弃window.URL.createObjectURL(stream)的使用
      video.play(); //  播放视频 
       audio.srcObject = stream;
      audio.play(); 
    });
    
    
    function tackcapture() {
      // 需要判断媒体流是否就绪
      if(streaming){
          context.drawImage(video, 0, 0, 350, 200);// 将视频画面捕捉后绘制到canvas里面
          img.src = canvas.toDataURL('image/png');// 将canvas的数据传送到img里
      }
    
    }
    
    btn.addEventListener('click',tackcapture,false); // 按钮点击事件
    
    // 监听视频流就位事件,即视频可以播放了
    video.addEventListener('canplay', function(ev){
          if (!streaming) {
            height = video.videoHeight / (video.videoWidth/width);
          
            video.setAttribute('width', width);
            video.setAttribute('height', height);
            canvas.setAttribute('width', width);
            canvas.setAttribute('height', height);
            streaming = true;
          }
        }, false); 
  </script>
</html>