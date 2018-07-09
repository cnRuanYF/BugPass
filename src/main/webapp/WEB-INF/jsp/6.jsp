<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="xhh" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新建问题 | Bugout - xxxx</title>
    
  </head>
  
  <body >

  <div>
        <ul>

            <li><a href="summary?publisher=${publisher}"><i></i>概述</a></li>
            <li class="active"><a href="problem?publisher=${publisher}"><i></i>问题</a></li>
            <li><a href="3.jsp"><i></i>统计</a></li>
            <li style="position:relative;"><a href="4.jsp"><i></i>成员 <span></span></a></li>
            <li><a href="5.jsp"><i></i>设置</a></li>
        </ul>
                <a href="newproblem?publisher=${publisher}">新建问题</a>
            </div>


<!--模块-->
 <form action="myupload">
<div>
    <!--成员左侧-->
    <div>
        <div><h3>问题属性</h3></div>
        <div>
            <div>
                <div>问题状态</div>
                <div>
                    
                       
                                             <select name="pstatusid">
                    <xhh:forEach items="${listStatus}" var="s">
                     <option value="${s.problemStatusId}">${s.problemStatusName}</option>
                    </xhh:forEach>
                                                   
                             </select>        
                </div>
            </div>
            <div>
                <div class="group-label">问题类型</div>
         
               <select name="protypeid">
                    <xhh:forEach items="${listType}" var="p">
                     <option value="${p.problemTypeId}">${p.problemTypeName}</option>
                    </xhh:forEach>
                                                   
                             </select>              
                </div>
            </div>
            <div>
                <div>重要级别</div>
           
                          

                            
                      
                 <select name="plevelid">
                    <xhh:forEach items="${listLevel}" var="l">
                     <option value="${l.problemLevelId}">${l.problemLevelName}</option>
                    </xhh:forEach>
                                                   
                             </select>        
                </div>
            </div>

           

            

<label>问题标题</label>
 <div><input type="text" placeholder="请输入问题标题">

</div>
         

 
            
<label>问题描述</label>
 <div><textarea name="pdescripe" rows="5" placeholder="请尽量详细描述问题"></textarea>
<div class="help-block"></div>
</div>

            




</body>
</html>
