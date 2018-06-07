<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<title>X轴单条线</title>
	<#include "/common/header.ftl" />
	<style>
        #myChart {
            width: 420px;
            height: 480px;
        }
    </style>
	<script type="text/javascript" src="/js/echarts/echarts.js"></script>
	<script type="text/javascript" src="/js/echarts/echarts-gl.js"></script>
</head>

<body>


<div id="myChart"></div>
<img id="bg" src="/images/tz/48特朗普.jpg" style="display:none;"/>
<img id="qc" width="200" height="200" src="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQFg8TwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyRHFZUzVOcmhkSWkxMDAwMHcwN0YAAgSPYZZaAwQAAAAA" style="display:none;"/>
<img id="star" />
<canvas id="myCanvas" width="750" height="1334">

</canvas>


</body>
<script type="text/javascript">
jQuery(function () {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('myChart'));
        // 指定图表的配置项和数据
        var option = {
            title: {
                //text: '体质'
            },
            tooltip: {
                trigger: 'axis',
                fontSize:30
            },
            radar: [
                {
                    indicator: [
                    {text: '阴虚', max: 60},
                    {text: '阳虚', max: 60},
                    {text: '邪毒', max: 60},
                    {text: '湿滞', max: 60},
                    {text: '血瘀', max: 60},
                    {text: '气郁', max: 60}
                    ],
                    center: ['50%', '60%'],//控制七芒星的位置
                    splitArea: {
                        show: false
                    },
                     radius: 150,//控制七芒星的大小
                    name: {
                        textStyle: {
                            fontSize:30,//控制字体大小
                            color:'#000'//控制字体颜色
                        }
                    },
                    axisLine: {
                        lineStyle: {
                            color: 'rgba(0,0,0,0.5)',//控制线的颜色
                            width:1 //控制线的宽度
                        }
                    },
                    splitLine: {
                        lineStyle: {
                            color: 'rgba(0,0,0,0.5)',//控制线的颜色
                            width:1 //控制线的宽度
                        }
                    }
                }
            ],
            series: [
                {
                    type: 'radar',
                    tooltip: {
                        trigger: 'item'
                    },
                    itemStyle: {
                        normal: {
                            areaStyle: {
                                type: 'default',
                                color: "#FF7F66"
                            }
                        }
                    },
                    data: [
                        {
                            value: [30, 20, 50, 10, 0, 0],//用户体质的数据
                            name: '您的体质',
                        }
                    ]
                },
                {
                    type: 'radar',
                    tooltip: {
                        trigger: 'item'
                    },
                    itemStyle: {
                        normal: {
                            areaStyle: {
                                type: 'default',
                                color: "#66E6FF"
                            }
                        }
                    },
                    data: [
                        {
                            value: [15, 15, 15, 20, 10, 10],//正常体质的数据
                            name: '正常体质',
                        }
                    ]
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        
        window.onload=function(){
        	
        	setTimeout(function () {
	    	    var myImage=document.getElementById("myCanvas");
	    	    var cxt=myImage.getContext("2d");
	    	    
	    	    
	    	    var bg = document.getElementById("bg");
	    	    cxt.drawImage(bg, 0, 0);
	    	    
	    		var qc = document.getElementById("qc");
	    		qc.width="200";
	    		qc.height="200";
	    	    cxt.drawImage(qc, 400, 880);
    	    
    		    var i = myChart.getDataURL({
    		        type: 'jpg',  //导出图片的格式
    		    });
    		    var star = document.getElementById("star");
    		    star.src=i;
    		    cxt.drawImage(star, 0, 880);
    		}, 800);
    	    
    	    
        }
		
    });
    
    
</script>
</html>