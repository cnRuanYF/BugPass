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
    
    <title>概述 | Bugout - xxxx</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
 <body>



    



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




    
   
                                        <a href="selectAll?publisher=${publisher}">
                                        <div>
                                          
                                                <h2>${problemCount}</h2>

                                                <div>打开</div>
                                            </div>
                                        </a>
                                    
                           
                                        <a href="getstatus?publisher=${publisher}">
                                           
                                            <div>
                                                <h2>${newBuildCount}</h2>

                                                <div>新建</div>
                                            </div>
                                        </a>
                               
                           
                                        <a href="getstatus2?publisher=${publisher}">
                                          
                                            <div>
                                                <h2>${runningCount}</h2>

                                                <div>进行中</div>
                                            </div>
                                        </a>
                                
                           
                                        <a href="getstatus3?publisher=${publisher}">
                                          
                                            <div>
                                                <h2>${reOpenCount}</h2>

                                                <div>重新打开</div>
                                            </div>
                                        </a>
                                 
                         
                                        <a href="getstatus4?publisher=${publisher}">
                                         
                                            <div>
                                                <h2>${resolvedCount}</h2>

                                                <div>已解决</div>
                                            </div>
                                        </a>
                            
                          
                                        <a href="getstatus5?publisher=${publisher}">
                                           
                                            <div>
                                                <h2>${waitSolveCount}</h2>

                                                <div>留待解决</div>
                                            </div>
                                        </a>
                          
                                            <a href="getstatus6?publisher=${publisher}">
                                             
                                                <div>
                                                    <div>已忽略</div>
                                                    <h2>${ignoredCount}</h2>
                                                </div>
                                            </a>
                                
                                            <a href="getstatus7?publisher=${publisher}">
                                              
                                                <div>
                                                    <div>已关闭</div>
                                                    <h2>${closedCount}</h2>
                                                </div>
                                            </a>
                                 
     
                    <ul class="tab-nav">
                       
                        <li>
                            <a href="#">我提交的</a>
                        </li>
                       
                    </ul>
                 <div>
        <a href="getstatusbypublisher?publisher=${publisher}">
            <h1>${submitNewBuildCount}</h1>

            <div>新建</div>
        </a>
    </div>
    <div>
        <a href="getstatusbypublisher2?publisher=${publisher}">
            <h1>${submitRunningCount}</h1>

            <div>进行中</div>
        </a>
    </div>
    <div>
        <a href="getstatusbypublisher3?publisher=${publisher}">
            <h1>${submitReOpenCount}</h1>

            <div>重新打开</div>
        </a>
    </div>
    <div>
        <a href="getstatusbypublisher4?publisher=${publisher}">
            <h1>${submitResolvedCount}</h1>

            <div>已解决</div>
        </a>
    </div>

</body>
</html>
