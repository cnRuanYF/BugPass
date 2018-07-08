<%@page import="com.bugpass.entity.User"%>
<%@ page import="com.bugpass.entity.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%--cdn 测试用--%>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<%
		//Problem problem=new Problem();//这里需要问题的id传入
            Project currentProject=new Project();
            currentProject.setId(1);
            session.setAttribute("currentProject",currentProject);//测试用
 
            //Project currentProject=(Project)session.getAttribute("currentProject");

//		session.setAttribute("projectId",1);//测试用
//		int projectId=(int)session.getAttribute("projectId");
	%>

		<table>
			<thead>
				<tr>
					<h4>模块</h4>
				</tr>
				<tr>
					<!-- 可以写入隐藏域 -->
					<td>模块id</td>
					<td>模块名</td>
					<td>项目id</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<%-- <c:if test="${discussList!=null}"> --%>
				<c:forEach items="${moduleList}" var="module">
					<form action="${pageContext.request.contextPath}/module/update/"
						method="post">
					<tr style="height: 30px;">
						<td><input type="hidden" id="moduleId"
							value="${module.moduleId}" name="moduleId"></input></td>
						<td><input type="text" id="moduleName"
							value="${module.moduleName}" name="moduleName"></input></td>
						<td><input type="hidden" id="projectId"
							value="${module.projectId}" name="projectId"></input></td>
						<td>
						<td><input type="submit" value="修改"> </inpput></td>
						</form>
						<td><button id="btn02" href="javascript:void(0)"
								onclick="delFunction(${module.moduleId})">删除</button></td>
						</td>
					</tr>
				</c:forEach>
				<%-- </c:if> --%>
			</tbody>
		</table>
		<%-- 添加模块遮罩层--%>

		<div class="row clearfix">
			<div class="col-md-12 column">
				<a id="modal-879477" href="#modal-container-879477" role="button"
					class="btn" data-toggle="modal">添加模块</a>

				<div class="modal fade" id="modal-container-879477" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">添加模块</h4>
							</div>
							<div class="modal-body">
								<%--添加模块--%>
								<form action="${pageContext.request.contextPath}/module/add"
									method="post">
									<table>
										<tr>
											<td>模块名:<input type="text" id="moduleName" value=""
												name="moduleName"></input>
										</tr>
									</table>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="submit" class="btn btn-primary">保存</button>
							</div>
							</form>
						</div>

					</div>

				</div>

			</div>
		</div>


		<%-- 弃用修改模块遮罩层--%>

		<div class="row clearfix">
			<div class="col-md-12 column">
				<a id="modal-879471" href="#modal-container-879471" role="button"
					class="btn" data-toggle="modal">修改模块</a>

				<div class="modal fade" id="modal-container-879471/${module}"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">修改</h4>
							</div>
							<div class="modal-body">
								<%--修改模块--%>
								<form action="${pageContext.request.contextPath}/module/update"
									method="post">
									<table>
										<tr>
											<td>模块名:<input type="text" id="moduleName"
												value="${module.moduleName}" name="moduleName"></input></td>
										</tr>
										<tr>
											<td><input type="text" id="moduleId"
												value="${module.moduleId}" name="moduleId"></input></td>
										</tr>
										<tr>
											<td><input type="text" id="projectId"
												value="${module.projectId}" name="projectId"></input></td>
										</tr>
										<tr>
											<td><input type="submit">提交</td>
										</tr>
									</table>
								</form>

							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary">保存</button>
							</div>
						</div>

					</div>

				</div>

			</div>
		</div>
	</div>


</body>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script>
		  function delFunction(moduleId) {
			var flag = confirm("是否确定删除文章编号为" + moduleId);
			if (flag) {
				
				location.href = "${pageContext.request.contextPath}/module/remove/"+moduleId;
						

			}
		}  
		//更新
		function updFunction(moduleId) {
	  		
	  		location.href="${pageContext.request.contextPath}/module/update/"+moduleId;
	  	}
		 
		 //用ajax实现局部添加和删除,未实现
		/* $(function() {

			$("#btn01").click(function() {
				$.ajax({
					//key1 : value1,
					//key2 : value2 
					url: "api/discuss/${discuss.discussId}", //请求url地址
					type: "DELETE", //请求方式
					dataType: "json", //从服务器返回的数据格式
					success: function(result) {
						console.log("success :" + result);
						console.log(${discussId});
						/* $.each(result, function(index, dept) {
							console.log(dept.dName);
						}); */
					/* },
					error: function(result) {
						console.log("error :" + result);
					}
				});

			}); */

		/*	$("#btn02").click(function() {
				$.ajax({
					type: "post", //请求方法
					url: "http://localhost:9090/BugPass/api/discuss", //请求地址
					contentType: "application/json", //发送到服务器的数据类型
					data: JSON.stringify({
						"problemId":$("#problemId").val(),
						/* "publisherUser": $("#publisherUser").val(), *///这他妈又是个对象
						/*"publisherId":  $("#publisherId").val(),
						"discussContent": $("#discussContent").val()
					}),//data表示的是传递给服务器一侧的数据
					success: function(result) {
						console.log(result);
					}
				});

			});

		}); */
	</script>
</html>