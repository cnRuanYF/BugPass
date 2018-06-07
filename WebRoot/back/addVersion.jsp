<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link
	href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.3/css/bootstrap.css"
	rel="stylesheet">
</head>

<body>
	<div class="container">
		<form action="../AddEmpServlet?key=add" method="post">
			<div class="form-group">
				<label for="projectName">项目名称</label> 
				<input type="text"
					class="form-control" name="projectName" id="projectName" placeholder="员工编号">
			</div>
			<div class="form-group">
				<label for="versionName">版本号</label>
				 <input type="text"
					class="form-control" name="versionName" id="versionName" placeholder="1.0.1">
					<div id="versionNameMsg" style="color: crimson;  display: inline;"></div>
			</div>
			
			<button type="button" id="button" class="btn btn-info">确认</button>
			&nbsp;&nbsp;
			<button type="reset" class="btn btn-info">重置</button>
			&nbsp;&nbsp; <a class="btn btn-info" href="../VersionServlet?key=selectAll">查看用户列表</a>
		</form>
	</div>
</body>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#button").click(function () {
			var versionNameMsg=$("#versionNameMsg").html();
			if (versionNameMsg=="版本号已存在，请勿重复创建"||versionNameMsg=="版本号不能为空") {
				//$("#button").addClass("disabled");
				alert(versionNameMsg);
			} else {
				$.get("../VersionServlet?key=add",{"projectId":"1","versionName":$("#versionName").val()},function (data,status) {
					if (data) {
						alert("添加成功");
						location.href="../VersionServlet?key=selectAll";
					}else {
						alert("添加失败");
					}				
				});
			}
			
		})
			$("#versionName").blur(function () {
				$.get("../VersionServlet?key=selectVersionName&versionName="+$("#versionName").val(),function (data,status) {
					$("#versionNameMsg").html(data);
				})
				
			})
		$.get("../AddEmpServlet?key=dept", function(data, status) {
			array = JSON.parse(data);
			$.each(array, function(index, dept) {
				console.log(dept.deptNo + "," + dept.dName);
				$("#deptno").append("<option value="+dept.deptNo+">"+ dept.dName + "</option>")
			})
		})
		
		
	})
</script>
</html>
