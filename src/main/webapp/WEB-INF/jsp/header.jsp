<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<base href="<%=basePath%>">

<!--
<link href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
-->
<link href="../../css/bootstrap.css" rel="stylesheet">
<link href="../../css/fontawesome-all.css" rel="stylesheet">
<script src="../../js/jquery-3.3.1.min.js"></script>
<script src="../../js/bootstrap.js"></script>

<link href="../../css/styles.css" rel="stylesheet">

<!-- 信息显示 -->
<c:if test="${actionErrors != null || actionMessages != null}">
  <div id="msgbox">${actionErrors}${actionMessages}</div>
  <script type="text/javascript" src="../../js/msgbox.js"></script>
  <%
      session.setAttribute("actionErrors", null);
  %>
  <%
      session.setAttribute("actionMessages", null);
  %>
</c:if>

<!--导航栏-->
<header class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
  <div class="container">
    <div class="navbar-brand">
      <h3 class="mt-1 mb-1">
        <i class="fa fa-bug mr-2"></i>BugPass
      </h3>
    </div>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
      data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent" aria-expanded="false"
      aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-4">
        <li class="nav-item dropdown"><a
          class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
          role="button" data-toggle="dropdown" aria-haspopup="true"
          aria-expanded="false"> <i class="fa fa-fw fa-project-diagram mr-2"></i>项目A
        </a>
          <div class="dropdown-menu"
            aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="#"> <i
              class="fa fa-fw fa-project-diagram mr-2"></i>项目A
            </a>
            <a class="dropdown-item" href="#"> <i
              class="fa fa-fw fa-project-diagram mr-2"></i>项目B
            </a> 
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#"> <i
              class="fa fa-fw fa-plus mr-2"></i>创建／加入新项目
            </a>
          </div></li>
      </ul>
      <ul class="navbar-nav mr-auto">
        <li class="nav-item"><a class="nav-link" href="project.jsp">概述</a></li>
        <li class="nav-item"><a class="nav-link"
          href="ProjectServlet?key=findAll">项目</a></li>
        <li class="nav-item"><a class="nav-link"
          href="VersionServlet?key=selectAll">版本</a></li>
        <li class="nav-item"><a class="nav-link"
          href="MemberRelationServlet?key=queryAll">成员</a></li>
        <li class="nav-item"><a class="nav-link"
          href="project_statistics.jsp">统计</a></li>
      </ul>
      <ul class="navbar-nav mr-4">
        <li class="nav-item dropdown"><a
          class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
          role="button" data-toggle="dropdown" aria-haspopup="true"
          aria-expanded="false"> <i class="fa fa-user-circle"></i>
            ${user.realname == null ? user.username : user.realname}
        </a>
          <div class="dropdown-menu dropdown-menu-right"
            aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="index.jsp"> <i
              class="fa fa-fw fa-home mr-2"></i>返回首页
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="user_profile.jsp"> <i
              class="fa fa-fw fa-user-edit mr-2"></i>个人资料
            </a> <a class="dropdown-item" href="user_change_password.jsp">
              <i class="fa fa-fw fa-key mr-2"></i>修改密码
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="logout.do"> <i
              class="fa fa-fw fa-sign-out-alt mr-2"></i>退出登录
            </a>
          </div></li>
      </ul>
    </div>
  </div>
</header>

