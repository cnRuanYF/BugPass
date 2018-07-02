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


<!-- Custom styles for this template -->
<link href="../../css/dashboard.css" rel="stylesheet">

<!-- 模态窗口连接 -->
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<style type="text/css">

}
</style>

</head>

<body>

	
		<%@ include file="header.jsp"%>


	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar" >

				<ul class="nav nav-sidebar">
					
					<li class="nav-item"><a class="nav-link"
						href="#modal-container-add" data-toggle="modal" ><h4>添加版本</h4> </a></li>

				</ul>
				<form class="navbar-form ">
					<input type="text" id="searchVersionLike" class="form-control"
						placeholder="Search..." value="${versionLike==null?'':versionLike}">
					<input type="button" id="btnSearch" class="form-control" value="搜索">
				</form>
			</div>


			<!-- 添加模态窗口 -->
			<div class="modal fade" id="modal-container-add" role="dialog"
				aria-hidden="true" aria-labelledby="registerModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="registerModalLabel">新增版本</h5>
							<button class="close" type="button" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<form class="mb-0" role="form" id="registerForm"
							action="register.do" method="post"
							onsubmit="return validateReg()">
							<div class="modal-body">
								<div class="form-group">
									<label for="projectName">项目名称</label> <input type="text"
										class="form-control" name="projectName" id="projectName"
										value="project01">
								</div>
								<div class="form-group">
									<label for="versionName">版本号</label> <input type="text"
										class="form-control" name="versionName" id="versionName"
										placeholder="1.0.1">
									<div id="versionNameMsg"
										style="color: crimson; display: inline;"></div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" id="button" class="btn btn-info">确认</button>
								&nbsp;&nbsp;
								<button type="reset" class="btn btn-info">重置</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- 修改模态窗口 -->
			<div class="modal fade" id="modal-container-update" role="dialog"
				aria-hidden="true" aria-labelledby="registerModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="registerModalLabel">修改版本号:</h5>
							<!-- 隐藏域存放版本ID -->
							<input  type="hidden" class="modal-title " id="updateVersionId"></input>
							<button class="close" type="button" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<form class="mb-0" role="form" id="registerForm"
							action="register.do" method="post"
							onsubmit="return validateReg()">
							<div class="modal-body">
								<div class="form-group">
									<label for="versiomNowName">当前版本号</label> 
									<h4  id="versiomNowName">第1.1版</h4>
									<!-- <p name="versiomNowName" id="versiomNowName">第1.1版</p> -->
									<!-- <input type="text"
										class="form-control" name="versiomNowName" id="versiomNowName"
										value="第1.1版"> -->
								</div>
								<div class="form-group">
									<label for="versionNewName">新版本号</label> <input type="text"
										class="form-control" name="versionNewName" id="versionNewName"
										placeholder="1.0.1">
									<div id="versionNewNameMsg"
										style="color: crimson; display: inline;"></div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" id="updatebutton" class="btn btn-info">确认</button>
								&nbsp;&nbsp;
								<button type="reset" class="btn btn-info">重置</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<h2 class="sub-header"> </h2>
				<div class="table-responsive">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<h4>版本列表</h4> 
							</tr>
						</thead>
						<tbody>
							<c:if test="${versions!=null}">
								<c:forEach items="${versions}" var="version">
									<tr style="height:30px;">
										<td>${version.versionName}</td>
										<td><a  href="#modal-container-update" 
										role="button"  data-toggle="modal" style="height:30px;">
										<button class="btn btn-info btnUpdate" value="${version.versionId}" style="height:35px;">修改</button></a>&nbsp;&nbsp;
											<button class="btn btn-danger btnDel"
												value="${version.versionId}"style="height:35px;">删除</button></td>
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

					<%-- <div class="col-md-12 column text-center">
						<ul class="pagination">
							<li><a href="javascript:void(0)" id="prePage">上一页</a></li>
							注意这里   begin="1"  从1开始  end="${pd.totalPage}" 到几结束    var="index" 变量的值
							<c:forEach begin="1" end="${pd.totalPage}" var="index">
								激活当前页码显示效果
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
					</div> --%>
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
			   var versionLike = $("#searchVersionLike").val();
			   
			   location.href = "${pageContext.request.contextPath}/VersionServlet?key=selectByLike&versionLike="+versionLike;
			   
			   
		   });
		   
	   });
	</script>
	<script src="${pageContext.request.contextPath}/js/layer.js"></script>
	<script type="text/javascript">
	$(function(){
		$(".btnDel").click(function(){
			
			var btn=$(this);
			//console.log($(btn).val());
			layer.confirm('是否确定删除？', {
  			  btn: ['确定','取消'] //按钮
  			}, function(){
  				//这里就是点击确定的时候执行的代码 ,执行ajax请求${pageContext.request.contextPath}
  				
  				
  			$.post("${pageContext.request.contextPath}/VersionServlet",{"key":"dele","versionId":$(btn).val()},function(data,status){
  				
  				//尝试获取status data
  				//console.log("status"+status+",data :"+data);
  				
  				if(data)
  					{
  					  // layer.msg('删除成功', {icon: 1,time: 2000});
  					   
  					   //将这个样式调整一下
  					   layer.msg('删除成功', {
  						    time: 2000, //2s后自动关闭
  						    btn: ['确定']
  					   //下面一个函数的功能应该是等  msg的窗口消失后再执行
  						  },function(){
  							  
  							  //重新刷新页面
 	    					      location.reload(); 
  						  });
  					}
  				     else
  					{
  				    	layer.msg('删除失败', {icon: 1});
  					}
  			}); 
  				
  			});
  		
  	}); 
  }); 

	</script>
	
	<script type="text/javascript">
	$(function() {
		//添加版本
		$("#button").click(function () {
			var versionNameMsg=$("#versionNameMsg").html();
			if (versionNameMsg=="版本号已存在，请勿重复创建"||versionNameMsg=="版本号不能为空") {
				//$("#button").addClass("disabled");
				alert(versionNameMsg);
			} else {
				$.get("${pageContext.request.contextPath}/VersionServlet?key=add",{"projectId":"1","versionName":$("#versionName").val()},function (data,status) {
					if (data) {
						//alert("添加成功");
						 //将这个样式调整一下
	  					   layer.msg('添加成功', {
	  						    time: 2000, //2s后自动关闭
	  						    btn: ['确定']
	  					   //下面一个函数的功能应该是等  msg的窗口消失后再执行
	  						  },function(){
	  							  
	  							  //重新刷新页面
	  							location.href="${pageContext.request.contextPath}/VersionServlet?key=selectAll";
	  						  });
						
					}else {
						layer.msg('添加失败', {icon: 1});
					}				
				});
			}
			
		})
			//添加时的版本验证
			$("#versionName").blur(function () {
				$.get("${pageContext.request.contextPath}/VersionServlet?key=selectVersionName&versionName="+$("#versionName").val(),function (data,status) {
					$("#versionNameMsg").html(data);
				})
				
			})
			
		//修改版本按钮点击事件
		$(".btnUpdate").click(function () {
			var btn=$(this);
			//location.href="#modal-container-update";
			//console.log($(btn).val());
			$("#updateVersionId").val($(btn).val())
			$.post("${pageContext.request.contextPath}/VersionServlet",
					{"key":"selectOne","versionId":$(btn).val()},function(data,status){
						$("#versiomNowName").html(data);
					});
			
			
		})
		//修改时的版本验证
			$("#versionNewName").blur(function () {
				$.get("${pageContext.request.contextPath}/VersionServlet?key=selectVersionName&versionName="+$("#versionNewName").val(),function (data,status) {
					$("#versionNewNameMsg").html(data);
				})
				
			})
		//确认修改按钮点击事件
		$("#updatebutton").click(function () {
			var versionNewNameMsg=$("#versionNewNameMsg").html();
			if (versionNewNameMsg=="版本号已存在，请勿重复创建"||versionNewNameMsg=="版本号不能为空") {
				//$("#button").addClass("disabled");
				alert(versionNewNameMsg);
			} else {
				$.get("${pageContext.request.contextPath}/VersionServlet?key=update",{"versionId":$("#updateVersionId").val(),"versionNewName":$("#versionNewName").val()},function (data,status) {
					if (data) {
						layer.msg('修改成功', {
  						    time: 2000, //2s后自动关闭
  						    btn: ['确定']
  					   //下面一个函数的功能应该是等  msg的窗口消失后再执行
  						  },function(){
  							  
  							  //重新刷新页面
  							location.href="${pageContext.request.contextPath}/VersionServlet?key=selectAll";
  						  });
						//alert("修改成功");
						//location.href="${pageContext.request.contextPath}/VersionServlet?key=selectAll";
					}else {
						alert("修改失败");
					}				
				});
			}
			
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
</body>

</html>