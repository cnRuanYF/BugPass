<%@page import="com.bugpass.entity.Project"%>
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

	

	<%
		Project currentProject=new Project();
		currentProject.setId(1);
		
		session.setAttribute("currentProject",currentProject);//测试用 
		Project project=(Project)session.getAttribute("currentProject");
		
	%>
	<%=project %><br>
	<div>${currentModule}</div>
	
	<form action="${pageContext.request.contextPath}/api/updModule" method="post">
		<table>
			<tr>
				<td>模块名:<input type="text" id="moduleName" value="${currentModule.moduleName}" name="moduleName"></input></td>
			</tr>
			<tr>
				<td><input type="hidden" id="moduleId" value="${currentModule.moduleId}" name="moduleId"></input></td>
			</tr>
			<tr>
				<td><input type="hidden" id="projectId" value="${currentModule.projectId}" name="projectId"></input></td>
			</tr>
			<tr>
				<td><input type="submit" ></td>
			</tr>
		</table>
	</form>
	
</body>
</html>