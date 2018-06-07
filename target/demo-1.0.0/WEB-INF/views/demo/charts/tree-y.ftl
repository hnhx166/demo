<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<title>Y轴单树</title>
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
myChart.showLoading();
$.get('/js/echarts/data/flare.json', function (data) {
    myChart.hideLoading();

    myChart.setOption(option = {
        tooltip: {
            trigger: 'item',
            triggerOn: 'mousemove'
        },
        series:[
            {
                type: 'tree',

                data: [data],

                left: '2%',
                right: '2%',
                top: '8%',
                bottom: '20%',

                symbol: 'emptyCircle',

                orient: 'vertical',

                expandAndCollapse: true,

                label: {
                    normal: {
                        position: 'top',
                        rotate: -90,
                        verticalAlign: 'middle',
                        align: 'right',
                        fontSize: 9
                    }
                },

                leaves: {
                    label: {
                        normal: {
                            position: 'bottom',
                            rotate: -90,
                            verticalAlign: 'middle',
                            align: 'left'
                        }
                    }
                },

                animationDurationUpdate: 750
            }
        ]
    });
});



</script>
</html>