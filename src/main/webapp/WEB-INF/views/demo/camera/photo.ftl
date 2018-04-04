<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<#include "/common/header.ftl" />
	<style>
        * {
            margin: 0;
            padding: 0;
        }
        /*蓝色按钮,绝对定位*/
        .blueButton {
            position: absolute;
            display: block;
            width: 60px;
            height: 36px;
            background-color: #269C77;
            color: #fff;
            text-decoration: none;
            text-align: center;
            cursor: pointer;
            border-radius: 4px;
        }
        .blueButton img{
            margin-top: 1px;
        }

        .blueButton:hover {
            text-decoration: none;
        }
        /*自定义上传,位置大小都和a完全一样,而且完全透明*/
        .myFileUpload {
            position: absolute;
            display: block;
            width: 100px;
            height: 40px;
            opacity: 0;
        }
    </style>
</head>
<body style="overflow-y: hidden">
		<#include "/common/menu.ftl" />
<body>
	<a href='javascript:void(0);' class="blueButton"><img src="/images/photo.png" alt="png" width="30"></a>
	<input type="file" id="file" class="myFileUpload" capture="camera" accept="image/*">
		<#include "/common/footer.ftl" />
</body>

<script type="text/javascript" src="/js/localResizeIMG/lrz.all.bundle.js"></script>
<script type="text/javascript">
	document.getElementById('file').addEventListener('change', function() {
		var fileObj = this.files[0];
		if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
            return;
        }
		//图片压缩并上传
        lrz(this.files[0]).then(function(data){
        	var xhr = new XMLHttpRequest();
            xhr.open("post", "/upload/uploadImg.vhtml", true);
            xhr.send(data.formData);
        })
        /* var xhr = new XMLHttpRequest();
        xhr.open("post", "/wx/upload.vhtml", true);
        xhr.onload = function () {
            alert("上传完成!");
        };
        xhr.send(formFile); */
		
	}, false);
</script>

</html>