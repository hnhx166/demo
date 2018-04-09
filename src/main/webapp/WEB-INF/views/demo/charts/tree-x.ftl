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
myChart.showLoading();
$.get('/js/echarts/data/flare.json', function (data) {
    myChart.hideLoading();

    echarts.util.each(data.children, function (datum, index) {
        index % 2 === 0 && (datum.collapsed = true);
    });

    myChart.setOption(option = {
        tooltip: {
            trigger: 'item',
            triggerOn: 'mousemove'
        },
        series: [
            {
                type: 'tree',

                data: [data],

                top: '1%',
                left: '7%',
                bottom: '1%',
                right: '20%',

                symbolSize: 7,

                label: {
                    normal: {
                        position: 'left',
                        verticalAlign: 'middle',
                        align: 'right',
                        fontSize: 9
                    }
                },

                leaves: {
                    label: {
                        normal: {
                            position: 'right',
                            verticalAlign: 'middle',
                            align: 'left'
                        }
                    }
                },

                expandAndCollapse: true,
                animationDuration: 550,
                animationDurationUpdate: 750
            }
        ]
    });
});


</script>
</html>