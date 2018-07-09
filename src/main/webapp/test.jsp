<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%--cdn 测试用--%>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<!-- <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
 
	最新的 Bootstrap 核心 JavaScript 文件
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

</head>
<body>
	<form class="form-horizontal" role="form"
		action="${pageContext.request.contextPath}/upLoad/problemattachment"
		method="post" id="formvalue" enctype="multipart/form-data"
		onsubmit="return checkFile()">


		<div class="form-group">
			<label for="file1" class="col-sm-2 control-label">图片1</label>
			<div class="col-sm-8">
				<input type="file"  required="required" class="form-control"
					name="myfiles" id="file1" accept="upLoad/*"
					onchange="imgChange1(this);" />
				<!--文件上传选择按钮-->
			</div>
			<!-- 图片显示位置 -->
			<div id="preview1">
				<img id="imghead1" src="/img/avatar/0.png" width="200"
					height="200" />
				
			</div>
		</div>
		<div class="form-group">
			<label for="file2" class="col-sm-2 control-label">图片2</label>
			<div class="col-sm-8">
				<input type="file"  required="required" class="form-control"
					name="myfiles" id="file2" accept="upLoad/*"
					 onchange="imgChange2(this);"/>
				<!--文件上传选择按钮-->
			</div>
			<!-- 图片显示位置 -->
			<div id="preview2">
				<img id="imghead2" src="/img/avatar/0.png" width="200"
					height="200" />
				
			</div>
		</div>
		<div class="form-group">
			<label for="file3" class="col-sm-2 control-label">图片3</label>
			<div class="col-sm-8">
				<input type="file"  required="required" class="form-control"
					name="myfiles" id="file3" accept="upLoad/*"
					 onchange="imgChange3(this);"/>
				<!--文件上传选择按钮-->
			</div>
			<!-- 图片显示位置 -->
			<div id="preview3">
				<img id="imghead3" src="/img/avatar/0.png" width="200"
					height="200" />
				
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-danger">提交</button>
			</div>
		</div>
	</form>


	</div>
	</div>
	</div>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script type="text/javascript">
		/* 检测图片是否都添加了 */
		function checkFile() {
			var files = $("files");
			for (var i = 0; i < files.length; i++) {
				if (files[i].val() == null || files[i].val() == "") {
					alert("第" + i + "图片未选择");
					return false;
				}
			}
			return true;
		}
	 
		// 选择图片显示
		function imgChange1(obj) {
			//获取点击的文本框
			var file = document.getElementById("file1");
			var imgUrl = window.URL.createObjectURL(file.files[0]);//取图片地址
			var img = document.getElementById('imghead1');//吧图片的元素取出来
			img.setAttribute('src', imgUrl); // 修改img标签src属性值
		}
		// 选择图片显示
		function imgChange2(obj) {
			//获取点击的文本框
			var file = document.getElementById("file2");
			var imgUrl = window.URL.createObjectURL(file.files[0]);//取图片地址
			var img = document.getElementById('imghead2');//吧图片的元素取出来
			img.setAttribute('src', imgUrl); // 修改img标签src属性值
		}
		// 选择图片显示
		function imgChange3(obj) {
			//获取点击的文本框
			var file = document.getElementById("file3");
			var imgUrl = window.URL.createObjectURL(file.files[0]);//取图片地址
			var img = document.getElementById('imghead3');//吧图片的元素取出来
			img.setAttribute('src', imgUrl); // 修改img标签src属性值
		}
	
	</script>


</body>
</html>