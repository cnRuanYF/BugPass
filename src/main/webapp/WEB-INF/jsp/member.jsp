<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
(情况1：登录账号是该项目的创建者)假设在项目ID为1中，登录账号ID是1，项目创建者是1.<br/>
项目成员：<br/>
<table>
	<tr><td>姓名</td><td>角色</td><td>操作</td></tr>
	<c:forEach items="${memberList}" var="member">
		<tr>
			<td>${member.user.realname}</td>
			<td>${member.memberRole == 1 ? "创建者" : "成员"}</td>
			<td><c:if test="${member.memberRole != 1}"><a href="api/deleteMember">移除</a></c:if></td>
		</tr>
	</c:forEach>
</table>









(情况2：登录账号是该项目的组成员)假设在项目ID为1中，登录账号ID是2，项目创建者是1.<br/>








</body>
</html>