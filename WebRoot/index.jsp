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
		<div class="row align-items-center">
			<div class="col-6 mx-auto col-md-6 order-md-2">
				<i class="fa fa-bug" style="fontsize:128px"></i>
			</div>
			<div class="col-md-6 order-md-1 text-center text-md-left pr-md-5">
				<h1 class="mb-3 bd-text-purple-bright">BugPass</h1>
				<h2>
					一款基于 JavaEE 编写的开源缺陷管理平台。
				</h2>
				<h3>
					软件项目开发团队必备<br>安全、稳定、高效、易用。
				</h3>
				<div class="d-flex flex-column flex-md-row lead mb-3">
					<a id="btnStart" href="javascript:void(0)" class="btn btn-lg btn-outline-primary">
						进入系统
					</a>
				</div>
				<p class="text-muted">
					当前版本：v0.1 beta (更新于：2018-06-07)
				</p>
			</div>
		</div>
	</div>
		
	<script type="text/javascript">
		$('#btnStart').on('click', function(){
			if(${user != null}){
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

