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
	<table>
		<c:forEach items="${listPro }" var="project">
			<tr>
				<td>项目id:${project.id }</td>
				<td>项目名称:${project.projectName }</td>
				<td>项目描述:${project.projectDesc }</td>
				<td>创建时间:${project.createTime }</td>
				<td>显示id:${project.displayId }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>