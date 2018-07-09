<%@page import="com.bugpass.entity.Problem"%>
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
	<!-- 假装有用户id为2 -->
		<%
			
			User user = new User();
			user.setId(2);
			session.setAttribute("currentUser",user ); 
		%>
	<%=session.getAttribute("currentUser") %><br>
	<%=user %><br>
	<!-- 假装有问题id为1 -->
	<%-- <% 
			Problem currentProblem=new Problem();
			currentProblem.setId(1);
			session.setAttribute("currentProblem", currentProblem);
		%>
		当前问题：<%=currentProblem %><br> --%>
	<%-- <%
		//Problem problem=new Problem();//这里需要问题的id传入
		
			session.setAttribute("problemId",1);//先写死(等问题)
			int problemId=(int)session.getAttribute("problemId");
		%>
	当前问题id：<%=problemId %> --%>
	<form action="${pageContext.request.contextPath }/discuss/add"
		method="post">
		<table>
			<tr>
				<td>讨论:<textarea type="text" id="discussContent" value=""
						name="discussContent"></textarea></td>
			</tr>
			<%--<tr>
				<td><input type="hidden" id="publisherUser" value="${user}" /></td>
			</tr>--%>
			<tr>
				<td><input type="hidden" id="problemId" value="${problemId}"
					name="problemId" /></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>

	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<h4>讨论</h4>
			</tr>
			<tr>
				<td>头像</td>
				<td>发布者</td>
				<!--可以写入隐藏域-->
				<td>用户Id</td>
				<td>讨论id</td>
				<td>问题id</td>
				<!--可以写入隐藏域 -->
				<td>发布时间</td>
				<td>发布内容</td>
				<td>发布者Id</td>
			</tr>
		</thead>
		<tbody>
			<%--<c:if test="${discussList!=null}">--%>
			<c:forEach items="${discussList}" var="discuss">
				<tr style="height: 30px;">
					<td>${discuss.publisherUser.picture}</td>
					<td>${discuss.publisherUser.username}</td>
					<td>${discuss.publisherUser.id}</td>
					<td>${discuss.discussId}</td>
					<td>${discuss.problemId}</td>
					<td>${discuss.publishTime}</td>
					<td>${discuss.discussContent}</td>
					<td>${discuss.publisherId}</td>
					<td>
						<button class="btn btn-success" id="btn01"
							href="javascript:updFunction(${discuss.discussId})">修改</button> <%--						<button class="btn btn-danger" id="btn02" href="javascript:delFunction(${discuss.discussId})">--%>
						<button class="btn btn-danger" id="btn01"
							href="javascript:void(0)"
							onclick="delFunction(${discuss.discussId})">删除</button>
					</td>
				</tr>
			</c:forEach>
			<%--</c:if>--%>
		</tbody>
	</table>
</body>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script>
		/*  function delFunction(discussId) {
			var flag = confirm("是否确定删除文章编号为" + discussId);
			if (flag) {
				
				location.href = "${pageContext.request.contextPath}/api/discuss/"+discussId;
						

			}
		}  */
		//未实现
/* 		function updFunction(discussId) {
	  		
	  		location.href="${pageContext.request.contextPath}/api/discuss="+discussId;
	  	}
		 */
		 
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
					},
					error: function(result) {
						console.log("error :" + result);
					}
				});

			});

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