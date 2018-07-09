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
    <table border="2px" cellpadding="0" cellspacing="0">
    <tr>
        <th>序号</th>
    	<th>图片</th>
    	<th>uri</th>
    	
    </tr>
    <c:forEach items="${imglist}" var="imgs" varStatus="num">
   <tr>
       <td>${num.count}</td>
       <td>${imgs.problem_id}</td>
       <td>  <img alt="" src="${imgs.attach_path }"></td>
       <td>${imgs.attach_type}</td>
       <td>${imgs.attach_index}</td>
       
     </tr>
    </c:forEach>
    </table>
  
</body>
</html>