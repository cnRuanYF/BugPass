<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计页面</title>
</head>
<body>
	<!--jstl,在prefix处命名c,使用.forEach方法-->
	<!--查询项目名，版本号-->
	<c:forEach items="${statistics}" var="statistics">
${statistics.project_name},${statistics.version_name},${statistics.bugNumber}
</c:forEach>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="main" style="height: 400px"></div>
	<!-- ECharts单文件引入 -->
	<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
	<script type="text/javascript" items="${statistics}" var="statistics">
		// 路径配置
		require.config({
			paths : {
				echarts : 'http://echarts.baidu.com/build/dist'
			}
		});

		// 使用
		require([ 'echarts', 'echarts/chart/bar', 'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
		], function(ec) {
			// 基于准备好的dom，初始化echarts图表
			var myChart = ec.init(document.getElementById('main'));

			var option = {
				title : {
					text : '疯聊统计'
				},
				tooltip : {
					trigger : 'axis'
				},
				legend : {
					data : [ 'BUG数']
				},
				toolbox : {
					show : true,
					feature : {
						dataView : {
							show : true,
							readOnly : false
						},
						magicType : {
							show : true,
							type : [ 'line', 'bar' ]
						},
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
				calculable : true,
				xAxis : [ {
					type : 'category',
					data : [ '版本1', '版本2', '版本3', '版本4', '版本5', '版本6', '版本7', '版本8',
							'版本9', '版本10', '版本11', '版本12' ]
				} ],
				yAxis : [ {
					type : 'value'
				} ],
				series : [
						{
							name : 'BUG数',
							type : 'bar',
							data : [ 2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6,
									162.2, 32.6, 20.0, 6.4, 3.3 ],
							markPoint : {
								data : [ {
									type : 'max',
									name : '最大值'
								}, {
									type : 'min',
									name : '最小值'
								} ]
							},
							markLine : {
								data : [ {
									type : 'average',
									name : '平均值'
								} ]
							}
						},

				]
			};

			// 为echarts对象加载数据 
			myChart.setOption(option);
		}

		);
	</script>
</body>
</html>