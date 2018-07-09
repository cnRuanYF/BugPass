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
    <table border="1px" cellpadding="0" cellspacing="0">
    <tr>
        <th>问题Id</th>
    	<th>图片索引</th>
    	<th>类型type</th>
    	<th>img</th>
    	<th>地址</th>
    	
    </tr>
    <c:forEach items="${imglist}" var="img" >
   <tr>
       <td>${img.problemId}</td>
       <td>${img.attachIndex}</td>
       <td>${img.attachType}</td>
       <td>  <img alt="" src="${img.attachPath }" height="200" width="200"></td>
        <td>${img.attachPath}</td>
     </tr>
    </c:forEach>
    </table>
  
</body>
</html>