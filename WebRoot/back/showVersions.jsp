<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>缺陷管理系统-版本管理</title>

<!-- Bootstrap core CSS -->
<link href="dist/css/bootstrap.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="../../assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">
	
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<link href="css/styles.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="back/dashboard.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">缺陷管理系统-版本管理</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">仪表盘</a></li>
					<li><a href="#">设置</a></li>
					<li><a href="#">个人信息</a></li>
					<li><a href="#">帮助</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" id="searchEmpLike" class="form-control"
						placeholder="Search..."
						value="${empLike==null?'':empLike}"> <input
						type="button" id="btnSearch" class="form-control" value="搜索">
				</form>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				
				<ul class="nav nav-sidebar">
					<li class="active"><a href="UserServlet">版本管理</a></li>
					<!-- <li><a href="back/addVersion.jsp">添加版本</a></li> -->
					<li class="nav-item">
						<a class="nav-link" href="#modal-container-add" data-toggle="modal">添加版本</a>
					</li>
					
				</ul>
				<ul class="nav nav-sidebar hidden">
					<li class="active"><a href="">Nav item again</a></li>
					<li><a href="">One more nav</a></li>
					<li><a href="">Another nav item</a></li>
				</ul>
			</div>

			
<!-- 添加模态窗口 -->
<div class="modal fade" id="modal-container-add" role="dialog" aria-hidden="true" aria-labelledby="registerModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="registerModalLabel">新用户注册</h5> 
				<button class="close" type="button" data-dismiss="modal">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form class="mb-0" role="form" id="registerForm" action="register.do" method="post" onsubmit="return validateReg()">
				<div class="modal-body">
					<div class="form-group">
						<label for="regUsername">用户名</label>
						<input class="form-control lastpassClearHidden" id="regUsername" name="username" type="text" placeholder="4~16位字母或数字，不能以数字开头" required/>
					</div>
					<div class="form-group">
						<div class="text-danger" id="usernameCheck"></div>
					</div>
					<div class="form-group">
						<label for="regPassword">密码</label>
						<input class="form-control lastpassClearHidden" id="regPassword" name="password" type="password" placeholder="4~16位字母或数字" required/>
					</div>
					<div class="form-group">
						<label for="regPassword2">重复密码</label>
						<input class="form-control lastpassClearHidden" id="regPassword2" type="password" placeholder="再次输入密码" required/>
					</div>
					<div class="form-group text-danger" id="regError">
						<i class="fa fa-exclamation-circle mr-2"></i><span id="regErrorMsg"></span>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary btn-block" id="btnRegister" type="submit">
						<i class="fa fa-spinner fa-spin mr-2"></i>注册
					</button> 
					<a class="btn btn-link" href="#modal-container-login" data-dismiss="modal" data-toggle="modal">已有账号？点此登录</a>
				</div>
			</form>
		</div>
	</div>
</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<h2 class="sub-header">版本列表</h2>
				<div class="table-responsive">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>版本号</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${versions!=null}">
								<c:forEach items="${versions}" var="version">
									<tr>
										<td>${version.versionName}</td>
										<td><a
											href="mvc/selectOneArticle.jsp?id=${version.versionId}">修改</a>&nbsp;&nbsp;<a
											href="ArticleServlet?key=delete&id=${version.versionId}">删除</a></td>
									</tr>
								</c:forEach>
							</c:if>


						</tbody>
					</table>

					<!--
            	作者：offline
            	时间：2018-05-10
            	描述：分页的导航
            -->

					<div class="col-md-12 column text-center">
						<ul class="pagination">
							<li><a href="javascript:void(0)" id="prePage">上一页</a></li>
							<%--注意这里   begin="1"  从1开始  end="${pd.totalPage}" 到几结束    var="index" 变量的值 --%>
							<c:forEach begin="1" end="${pd.totalPage}" var="index">
								<%--激活当前页码显示效果 --%>
								<c:if test="${index == pd.page}">
									<li class="active"><a href="javascript:void(0)"
										class="pageNo">${index}</a></li>
								</c:if>
								<c:if test="${index != pd.page}">
									<li><a href="javascript:void(0)" class="pageNo">${index}</a></li>
								</c:if>
							</c:forEach>
							<li><a href="javascript:void(0)" id="nextPage">下一页</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="../../assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

	<script type="text/javascript"
		src="https://cdn.bootcss.com/jquery/2.1.1/jquery.js"></script>
	<script>
	   $(function(){
		   
		   //如果当前页 已经是最后一页了
		   if(${pd.page >= pd.totalPage})
			   {
			   //下一页 样式设置
			   $("#nextPage").css("color","gray");
			   //pointer-events 不能点击了 ,没有测试所有的浏览器
			   $("#nextPage").css("pointer-events","none");
			   }
		   
		 //如果当前页 已经是第一页了
		   if(${pd.page <= 1})
		   {
			     //上一页 样式设置
		   $("#prePage").css("color","gray");
		   $("#prePage").css("pointer-events","none");
		   }
		   
		   
		   //分页页码点击
		   $(".pageNo").click(function(){
			   location.href = "EmpServlet?key=selectAll&page=" + $(this).text()+"&likeStr="+$("#searchEmpLike").val();
		   });
		   
		   //下一页
		   $("#nextPage").click(function(){
			   
			   location.href = "EmpServlet?key=selectAll&page=" + ${pd.page+1}+"&likeStr="+$("#searchEmpLike").val();
		   });
		   
		   //上一页
		   $("#prePage").click(function(){
			   location.href = "EmpServlet?key=selectAll&page=" + ${pd.page-1}+"&likeStr="+$("#searchEmpLike").val();
		   });
		   
		   
		   
		   //处理模糊检索
		   $("#btnSearch").click(function(){
			   
			   //得到用户输入在文本框中的值
			   var empLike = $("#searchEmpLike").val();
			   
			   location.href = "EmpServlet?key=selectAll&likeStr="+empLike;
			   
			   
		   });
		   
	   });
	</script>
</body>

</html>