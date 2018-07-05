<%@page import="com.bugpass.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
		//Problem problem=new Problem();//这里需要问题的id传入
		
		session.setAttribute("projectId",1);//测试用 
		int projectId=(int)session.getAttribute("projectId");
	%>
	<%=projectId %><br>
		<!-- 用ajax实现添加,废弃用discuss_add.jsp -->
		讨论:<textarea type="text" id="discussContent" value="" ></textarea><br/>
		<!-- 用户id --><%-- <input type="hidden" id="publisherUser" value="${publisherUser.id}" /><br/> --%>
		<!-- 用户id --><input type="hidden" id="moduleId" value="${module.moduleId}" /><br/>
		<!-- 讨论id --><input type="text" id="moduleName" value="${module.moduleName}" /><br/>
		<!-- 问题id: --><input type="hidden" id="projectId" value="${module.projectId}" /><br/>
		<input type="button" id="btn01" value="添加" />
		<input type="button" id="btn02" value="更新" />
		<input type="button" id="btn03" value="删除" />
		
		<a href="${pageContext.request.contextPath}/api/module">添加</a>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<h4>讨论</h4>
			</tr>
			<tr>
				<!-- 可以写入隐藏域 -->
				<td>模块id</td>				
				<td>模块名</td>
				<td>项目id</td>
			</tr>
		</thead>
		<tbody>
			<%-- <c:if test="${discussList!=null}"> --%>
				<c:forEach items="${moduleList}" var="module">
					<tr style="height: 30px;">
						<td>${module.moduleId}</td>
						<td>${module.moduleName}</td>
						<td>${module.projectId}</td>
						<td>
							<button class="btn btn-success" id="btn01" href="javascript:void(0)" onclick="updFunction(${module.moduleId})">
									修改
							</button> 
							<button  class="btn btn-danger" id="btn02" href="javascript:void(0)" onclick="delFunction(${module.moduleId})">
									删除
							</button>	
						</td>
					</tr>
				</c:forEach>
			<%-- </c:if> --%>
		</tbody>
	</table>
</body>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script>
		  function delFunction(moduleId) {
			var flag = confirm("是否确定删除文章编号为" + moduleId);
			if (flag) {
				
				location.href = "${pageContext.request.contextPath}/api/delModule/"+moduleId;
						

			}
		}  
		//更新
		function updFunction(moduleId) {
	  		
	  		location.href="${pageContext.request.contextPath}/api/toUpdModule/"+moduleId;
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