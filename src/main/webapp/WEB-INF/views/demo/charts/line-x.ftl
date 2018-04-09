<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<#include "/common/header.ftl" />
	<script type="text/javascript" src="/js/echarts/echarts.js"></script>
	<script type="text/javascript" src="/js/echarts/echarts-gl.js"></script>
</head>

<body>
		<#include "/common/menu.ftl" />
		<!-- body -->
		<div style="margin-top: 5%">
			<div id="main" style="height:600px;width: 100%;"></div>
		</div>
		<#include "/common/footer.ftl" />
</body>
<script type="text/javascript">
var myChart = echarts.init(document.getElementById('main'));
option = {
	    xAxis: {
	        type: 'category',
	        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
	    },
	    yAxis: {
	        type: 'value'
	    },
	    series: [{
	        data: [820, 932, 901, 934, 1290, 1330, 1320],
	        type: 'line'
	    }]
	};
//为echarts对象加载数据
myChart.setOption(option);








function strToTimestamp (str){
	var date = new Date(str.replace(/-/g,'/')).getTime(); 
		return date;
}

function formatDateTime(tamp) { 
    var time = new Date(tamp); 
    var y = time.getFullYear();  
    var m = time.getMonth() + 1;  
    m = m < 10 ? ('0' + m) : m;  
    var d = time.getDate();  
    d = d < 10 ? ('0' + d) : d;  
    var h = time.getHours();  
    var minute = time.getMinutes();  
    minute = minute < 10 ? ('0' + minute) : minute;
    var seconds = time.getSeconds(); 
    seconds = seconds < 10 ? ('0' + seconds) : seconds; 
    return y + '-' + m + '-' + d+' '+h+':'+minute+':'+seconds;  
}
</script>
</html>