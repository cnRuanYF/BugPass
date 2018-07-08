<%@page import="org.springframework.beans.factory.parsing.Problem"%>
<%@page import="com.bugpass.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--讨论:<textarea type="text" id="discussContent" value="" ></textarea><br/>
		<!--用户id--><input type="hidden" id="publisherUser" value="${publisherUser.id}" /><br/>
		<!--用户id--><input type="hidden" id="publisherId" value="${discuss.publisherId}" /><br/>
		<!--讨论id--><input type="hidden" id="discussId" value="${discuss.discussId}" /><br/>
		<!--问题id:--><input type="hidden" id="problemId" value="${discuss.problemId}" /><br/>
		<!--<input type="button" id="btn01" value="Ajax请求(get)" />-->
		<input type="button" id="btn02" value="增加讨论" />--%>

	<%
	
	User user = new User();
	user.setId(2);
	session.setAttribute("currentUser",user ); %>
	<%=session.getAttribute("currentUser") %><br>
	<%=user %><br>
	
	<%
		//Problem problem=new Problem();//这里需要问题的id传入
		
		session.setAttribute("problemId",1 );//先写死(等问题)
		int problemId=(int)session.getAttribute("problemId");
	%>
	<%=problemId %><br>
	
	<form action="${pageContext.request.contextPath }/api/discuss" method="post">
		<table>
			<tr>
				<td>讨论:<textarea type="text" id="discussContent" value="" name="discussContent"></textarea></td>
			</tr>
			<%--<tr>
				<td><input type="hidden" id="publisherUser" value="${user}" /></td>
			</tr>--%>
			<tr>
				<td><input type="hidden" id="problemId" value="${problemId}" name="problemId"/></td>
			</tr>
			<tr>
				<td><input type="submit" ></td>
			</tr>
		</table>
	</form>
	
</body>
</html>