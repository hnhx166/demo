<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>微信支付</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/css/layout/bootstrap.min.css" rel="stylesheet">
<link href="/css/layout/bootstrap-responsive.min.css" rel="stylesheet">
<link href="/css/layout/site.css" rel="stylesheet">

<script type="text/javascript" src="/js/layout/jquery.min.js"></script>
<script type="text/javascript"
	src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
	

<script type="text/javascript">
	$(function(){
		alert((location.href.split('#')[0]));
			wx.config({
			    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
			    appId: '${appId}', // 必填，公众号的唯一标识
			    timestamp: ${timestamp}, // 必填，生成签名的时间戳
			    nonceStr: '${noncestr}', // 必填，生成签名的随机串
			    signature: '${signature}',// 必填，签名
			    jsApiList: ['chooseImage', 'previewImage' , 'uploadImage', 'downloadImage'] // 必填，需要使用的JS接口列表
			});
			
			wx.ready(function(){
			    // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
			    
			    var images = {  
			            localId: [],  
			            serverId: []  
			    };
			    $("#chooseImage").on("click", function(){
			    	wx.chooseImage({
			              success: function (res) {
			                images.localId = res.localIds;
			                alert('已选择 ' + res.localIds.length + ' 张图片');  
			              }  
			         });
			    });
			});
			
			wx.error(function(res){
				alert(res);
			    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
			});
		
			/* //拍照或从手机相册中选图接口
			wx.chooseImage({
				count: 1, // 默认9
				sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
				sourceType: ['album', 'camera'], //可以指定来源是相册还是相机，默认二者都有
				success: function (res) {
					var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
				}
			});
			
			//预览图片接口
			wx.previewImage({
				current: '', // 当前显示图片的http链接
				urls: [] // 需要预览的图片http链接列表
				});
			
			//上传图片接口
			wx.uploadImage({
				localId: '', // 需要上传的图片的本地ID，由chooseImage接口获得
				isShowProgressTips: 1, // 默认为1，显示进度提示
				success: function (res) {
				var serverId = res.serverId; // 返回图片的服务器端ID
				}
			});
			
			//下载图片接口
			wx.downloadImage({
				serverId: '', // 需要下载的图片的服务器端ID，由uploadImage接口获得
				isShowProgressTips: 1, // 默认为1，显示进度提示
				success: function (res) {
				var localId = res.localId; // 返回图片下载后的本地ID
				}
			}); */
			
				/* $("#chooseImage").on("click", function(){
			    	alert("你好");
			    }); */
			})
			
		</script>
</head>
<body>
	<div class="container">
		<@ftl.top_menu 1/>
		<div class="row">
			<@ftl.left_menu 8/>
			<div class="span9">
				<h1>微信支付</h1>
				<fieldset>
					<legend>拍照或从手机相册中选图接口</legend>
					<div class="control-group">
						<input type="button" id="chooseImage" value="chooseImage" />
					</div>
				</fieldset>
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
</body>
<script>
		
	</script>
</html>
