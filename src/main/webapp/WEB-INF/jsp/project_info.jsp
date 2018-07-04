<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
项目ID:${project.projectId }
</br>
项目名称:${project.projectName }
</br>
项目描述:${project.projectDesc }
</br>
创建时间:${project.projectDate }
</br>
所有者:
</br>
</br>
</br>
</br>
</br>
<a href="${pageContext.request.contextPath }/toAddProject">跳转到添加项目页面</a>

</body>
</html>