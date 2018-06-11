<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="header_index.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>BugPass</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/fontawesome-all.css" rel="stylesheet">
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.js"></script>
-->

</head>

<body>
	<div class="container">
		<div class="text-center">
			<h1 class="mt-5 text-primary" style="font-size:64px">
				BugPass
			</h1>
			<h3 class="mt-4">开发团队必备的缺陷管理平台</h3>
			<h4>开源、安全、稳定、高效、易用</h4>
			<div class="mt-5">
				<a class="btn btn-lg btn-outline-primary btnEnterSys" href="javascript:void(0)">
				&emsp;进入系统&emsp;
				</a>
			</div>
			<p class="text-muted mt-4">当前版本：v0.1 beta (更新于: 2018-06-07)</p>
		</div>
	</div>

	<script type="text/javascript">
		$('.btnEnterSys').on('click', function(){
			if(1 == ${user != null ? 1 : 0}){
				location.href = 'project.jsp';
			} else {
				$('#loginLink').click();
			}
		});
	</script>

	<jsp:include page="footer.htm"></jsp:include>
	
	<!-- 背景 -->
	<canvas id="bgCanvas" style="width:100%;height:100%;position:absolute;top:0;z-index:-1"></canvas>
	<script>
		//定义画布宽高和生成点的个数
		var WIDTH = window.innerWidth, HEIGHT = window.innerHeight, POINT = 35;
		
		var canvas = document.getElementById('bgCanvas');
		canvas.width = WIDTH,
		canvas.height = HEIGHT;
		var context = canvas.getContext('2d');
		context.strokeStyle = 'rgba(0,0,0,0.02)',
		context.strokeWidth = 1,
		context.fillStyle = 'rgba(0,0,0,0.05)';
		var circleArr = [];
	
		//线条：开始xy坐标，结束xy坐标，线条透明度
		function Line (x, y, _x, _y, o) {
			this.beginX = x,
			this.beginY = y,
			this.closeX = _x,
			this.closeY = _y,
			this.o = o;
		}
		//点：圆心xy坐标，半径，每帧移动xy的距离
		function Circle (x, y, r, moveX, moveY) {
			this.x = x,
			this.y = y,
			this.r = r,
			this.moveX = moveX,
			this.moveY = moveY;
		}
		//生成max和min之间的随机数
		function num (max, _min) {
			var min = arguments[1] || 0;
			return Math.floor(Math.random()*(max-min+1)+min);
		}
		// 绘制原点
		function drawCricle (cxt, x, y, r, moveX, moveY) {
			var circle = new Circle(x, y, r, moveX, moveY)
			cxt.beginPath()
			cxt.arc(circle.x, circle.y, circle.r, 0, 2*Math.PI)
			cxt.closePath()
			cxt.fill();
			return circle;
		}
		//绘制线条
		function drawLine (cxt, x, y, _x, _y, o) {
			var line = new Line(x, y, _x, _y, o)
			cxt.beginPath()
			cxt.strokeStyle = 'rgba(0,0,0,'+ o +')'
			cxt.moveTo(line.beginX, line.beginY)
			cxt.lineTo(line.closeX, line.closeY)
			cxt.closePath()
			cxt.stroke();
	
		}
		//初始化生成原点
		function init () {
			circleArr = [];
			for (var i = 0; i < POINT; i++) {
				circleArr.push(drawCricle(context, num(WIDTH), num(HEIGHT), num(15, 2), num(10, -10)/40, num(10, -10)/40));
			}
			draw();
		}
	
		//每帧绘制
		function draw () {
			context.clearRect(0,0,canvas.width, canvas.height);
			for (var i = 0; i < POINT; i++) {
				drawCricle(context, circleArr[i].x, circleArr[i].y, circleArr[i].r);
			}
			for (var i = 0; i < POINT; i++) {
				for (var j = 0; j < POINT; j++) {
					if (i + j < POINT) {
						var A = Math.abs(circleArr[i+j].x - circleArr[i].x),
							B = Math.abs(circleArr[i+j].y - circleArr[i].y);
						var lineLength = Math.sqrt(A*A + B*B);
						var C = 1/lineLength*7-0.009;
						var lineOpacity = C > 0.03 ? 0.03 : C;
						if (lineOpacity > 0) {
							drawLine(context, circleArr[i].x, circleArr[i].y, circleArr[i+j].x, circleArr[i+j].y, lineOpacity);
						}
					}
				}
			}
		}
	
		//调用执行
		window.onload = function () {
			init();
			setInterval(function () {
				for (var i = 0; i < POINT; i++) {
					var cir = circleArr[i];
					cir.x += cir.moveX;
					cir.y += cir.moveY;
					if (cir.x > WIDTH) cir.x = 0;
					else if (cir.x < 0) cir.x = WIDTH;
					if (cir.y > HEIGHT) cir.y = 0;
					else if (cir.y < 0) cir.y = HEIGHT;
				}
				draw();
			}, 16);
		}
	</script>
       
</body>
</html>

