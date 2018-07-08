<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计页面</title>
</head>
<body>
<!--jstl,在prefix处命名c,使用.forEach方法-->
<!--查询项目名，版本号-->
<c:forEach items="${statistics}" var="statistics">
${statistics.project_name},${statistics.version_name},${statistics.bugNumber}
</c:forEach>
</body>
</html>