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
    
    <title>问题列表 | Bugout - xxxx</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css" href="css/table4.css"/>

  </head>
  
 <body>
    <!--成员左侧-->
   
       
            <div>
                <div>类型</div>
                <div>
   <xhh:forEach items="${listType}" var="p">
                      <div class="cell50">
                        
                        <a href="checktype?protypeid=${p.problemTypeId}&publisher=${publisher}">${p.problemTypeName}</a>
                        
                           
                           
                      </div>
                    </xhh:forEach>
                   
                                      
                                   </div>
            </div>

            <div>
                <div>级别</div>
                <div>

                                       <xhh:forEach items="${listLevel}" var="l">
                      <div class="cell50">
                           
                           <a href="checklevel?plevelid=${l.problemLevelId}&publisher=${publisher}">${l.problemLevelName}</a>
                      </div>
                    </xhh:forEach>
                                   </div>
            </div>

            <div>
                <div>状态</div>
                <div>
                                        <xhh:forEach items="${listStatus}" var="s">
                      <div class="cell50">
                       
                        
                            <a href="checkstatus?pstatusid=${s.problemStatusId}&publisher=${publisher}">${s.problemStatusName}</a>
                      </div>
                    </xhh:forEach>
                                   </div>
            </div>
            
         
            
               <div>
               <button type="button" onclick="javascript:location.href='checkAll?publisher=${publisher}'">查询</button>
               </div>

     
          
      


<div>
             <div>

            <xhh:if test="${allProblem!=null}">
                       <table>
	<tr id="tr1">
	<td>问题编号</td>	
	<td>问题标题</td>		
	<td>问题描述</td>	
	<td>问题类型</td>
	<td>问题级别</td>
	<td>问题状态</td>
	<td>问题操作</td>
	
	</tr>
	
	  <xhh:forEach items="${allProblem}" var="a">
            
	 <tr>
	<td>${a.problemId}</td>	
	<td>${a.problemTitle}</td>	
	<td>${a.problemDesc}</td>
	<td>${a.problemTypeName}</td>
	<td>${a.problemLevelName}</td>
	<td>${a.problemStatusName}</td>
	<td>
	<button type="button" onclick="javascript:location.href='deleteproblem?pid=${a.problemId}&publisher=${publisher}'">删除问题</button>
	</td>

	</tr>
	 </xhh:forEach>  
		</table> 
            </xhh:if>
            
            
            
                   <xhh:if test="${problem!=null}">    
                   
                   <table>
	<tr id="tr1">
	<td>问题编号</td>	
	<td>问题标题</td>		
	<td>问题描述</td>	
	<td>问题操作</td>
	
	</tr>
	
	  <xhh:forEach items="${problem}" var="p"><br/>
            
	 <tr>
	<td>${p.problemId}</td>	
	<td>${p.problemTitle}</td>	
	<td>${p.problemDesc}</td>
	<td>
	<button type="button" onclick="javascript:location.href='deleteproblem?pid=${p.problemId}&publisher=${publisher}'">删除问题</button>
	</td>

	</tr>
	 </xhh:forEach>  
		</table> 
            
            
             </xhh:if>  
             
                                   
                         

</body>
</html>
