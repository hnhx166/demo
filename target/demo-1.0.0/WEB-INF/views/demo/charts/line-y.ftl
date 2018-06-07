<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<title>Y轴单条线</title>
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
option = {
	    legend: {
	        data:['高度(km)与气温(°C)变化关系']
	    },
	    tooltip: {
	        trigger: 'axis',
	        formatter: "Temperature : <br/>{b}km : {c}°C"
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis: {
	        type: 'value',
	        axisLabel: {
	            formatter: '{value} °C'
	        }
	    },
	    yAxis: {
	        type: 'category',
	        axisLine: {onZero: false},
	        axisLabel: {
	            formatter: '{value} km'
	        },
	        boundaryGap: false,
	        data: ['0', '10', '20', '30', '40', '50', '60', '70', '80']
	    },
	    series: [
	        {
	            name: '高度(km)与气温(°C)变化关系',
	            type: 'line',
	            smooth: true,
	            lineStyle: {
	                normal: {
	                    width: 3,
	                    shadowColor: 'rgba(0,0,0,0.4)',
	                    shadowBlur: 10,
	                    shadowOffsetY: 10
	                }
	            },
	            data:[15, -50, -56.5, -46.5, -22.1, -2.5, -27.7, -55.7, -76.5]
	        }
	    ]
	};
var myChart = echarts.init(document.getElementById('main'));
myChart.setOption(option);
</script>
</html>