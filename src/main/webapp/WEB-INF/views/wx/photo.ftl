<!DOCTYPE html>
<html>
<head>
<meta charset="gbk">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>html5调用摄像头实现拍照本地保存</title>
<script type="text/javascript" src="/js/layout/jquery.min.js"></script>
<script type="text/javascript" src="/js/localResizeIMG/lrz.all.bundle.js"></script>

</head>
<body>
	<form action="/wx/upload.vhtml" method="post" enctype="multipart/form-data" >
		<input type="file" id="file" capture="camera" accept="image/*">
		
	</form>
</body>
<script type="text/javascript">
	document.getElementById('file').addEventListener('change', function() {
		/* var reader = new FileReader();
		reader.onload = function(e) {
			//compress(this.result);
		};
		reader.readAsDataURL(this.files[0]); */
		
		var fileObj = this.files[0];
		if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
           /*  alert("请选择图片"); */
            return;
        }
		
		
        
        lrz(this.files[0]).then(function(data){
        	/* if(){
        		var formFile = new FormData();
                formFile.append("action", "/wx/upload.vhtml");  
                formFile.append("file", fileObj); //加入文件对象
        	} */
        	
        	var xhr = new XMLHttpRequest();
            xhr.open("post", "/wx/upload.vhtml", true);
            /* xhr.onload = function () {
                alert("上传完成!");
            }; */
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