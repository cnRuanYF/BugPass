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
			<h1 class="mt-4 text-primary" style="font-size:64px">
				BugPass
			</h1>
			<h3 class="mt-4">开发团队必备的缺陷管理平台</h3>
			<h4>开源、安全、稳定、高效、易用</h4>
			<div class="mt-4">
				<a id="btnStart" href="javascript:void(0)" class="btn btn-lg btn-outline-primary">
				&emsp;进入系统&emsp;
				</a>
			</div>
			<p class="text-muted mt-4">当前版本：v0.1 beta (更新于: 2018-06-07)</p>
		</div>
	</div>

	<script type="text/javascript">
		$('#btnStart').on('click', function(){
			if(1 == ${user != null ? 1 : 0}){
				alert('user != null'); // TODO TEST
				location.href = 'project.jsp';
			} else {
				$('#loginLink').click();
			}
		});
	</script>

		<jsp:include page="footer.htm"></jsp:include>
       
</body>
</html>

