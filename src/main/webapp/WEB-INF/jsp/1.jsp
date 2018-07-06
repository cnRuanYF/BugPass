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
<link rel="shortcut icon" href="./image/testin.png">
<link href="./css/bootstrap.css" rel="stylesheet">
<link href="./css/normalize.css" rel="stylesheet">
<link href="./css/iconfont.css" rel="stylesheet">
<link href="./css/style.css" rel="stylesheet">
<link href="./css/moudle.css" rel="stylesheet">
<link href="./css/nav.css" rel="stylesheet">
<link href="./css/mod.css" rel="stylesheet">
<link href="./css/problem_statistics.css" rel="stylesheet" 0="frontend\assets\AppAsset">
  </head>
  
 <body key="0ca4010a456ddf1ecff9c76341a0f64f" style="">


<div class="ebms-tip ebms-success-tip"><i class="iconfont"></i><span class="tip-content"></span></div>
<div class="ebms-tip ebms-warning-tip"><i class="iconfont"></i><span class="tip-content"></span></div>
<div class="ebms-tip ebms-failed-tip"><i class="iconfont"></i><span class="tip-content"></span></div>

    <div class="bugmanagement-nav">
    <nav class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand bugout-navbar-brand" href="http://bugout.testin.cn/"><img src="./image/Bugout_logo2.png" alt=""> </a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active dropdown">
                                        <a href="http://bugout.testin.cn/bug?key=0ca4010a456ddf1ecff9c76341a0f64f#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="iconfont apple-icon" id="nav_project_type">
                                                                                                   
                                                                                        </i>
                        <span id="nav_project_name">
                                                            xxxx                                                    </span>
                        
                        <i id="get_project" class="iconfont arrow-icon"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-left">
                        <ul id="nav_project_ul">            <li class="clearfix">
                            <a href="http://bugout.testin.cn/bug?key=0ca4010a456ddf1ecff9c76341a0f64f">
                            <img src="./image/defaulticon" alt="">
                <span class="app-name" title="xxxx">xxxx</span>
                <i class="iconfont">
                                               
                                        </i>
            </a>
        </li>
    </ul>
                        <div class="add-app">
                            <a href="http://bugout.testin.cn/create-project">
                                <img src="./image/add-app.png" alt="">
                                添加项目
                            </a>
                        </div>
                    </div>

                </li>
            </ul>

            <ul class="nav navbar-nav navbar-nav-right">
                <li><a href="http://docs.testin.cn/" target="_blank" class="dropdown-toggle">帮助中心</a></li>
                                <li class="dropdown">
                    <a href="http://bugout.testin.cn/bug?key=0ca4010a456ddf1ecff9c76341a0f64f#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="user-mail">${user.username}</span><i class="iconfont arrow-icon"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <ul>
                            <li class="clearfix">
                                <a href="http://bugout.testin.cn/user-info">
                                    个人中心
                                </a>
                            </li>
                            <li class="clearfix">
                                <a href="http://bugout.testin.cn/logout">
                                    退出
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>
                            </ul>
        </div>
    </nav>
</div>
    
<style type="text/css" media="screen">
.red_point{display:block; width: 7px; height: 7px;border-radius:50%; position:absolute; right:0px; top:10px; color:#f44336;background-color:#f44336;}
</style>


<!--二级导航-->
<div class="bugmanagement-nav-second">
    <div class="personal-nav clearfix">
        <ul class="clearfix">

            <li><a href="summary?publisher=${publisher}"><i class="icon iconfont"></i>概述</a></li>
            <li class="active"><a href="problem?publisher=${publisher}"><i class="icon iconfont"></i>问题</a></li>
            <li><a href="3.jsp"><i class="icon iconfont"></i>统计</a></li>
            <li style="position:relative;"><a href="4.jsp"><i class="icon iconfont"></i>成员 <span class="apply_join_count"></span></a></li>
            <li><a href="5.jsp"><i class="icon iconfont"></i>设置</a></li>
        </ul>
                <a href="newproblem?publisher=${publisher}" class="new-create">新建问题</a>
            </div>
</div>


<div class="bugmanagement">
    
    <div class="row p-side10-out">
        <div class="col-md-6 m-b-30 p-side10">
            <div class="listview wbg z-depth-1" id="project_status">
                <div class="lv-header">问题统计</div>
                <div class="lv-body">
                    <div class="mini-charts">
                        <div class="row">
                            <div class="col-sm-6 col-xs-6 chart-item">
                                <div class="issue-charts-item chart-flag-100">
                                    <div class="clearfix">
                                        <a href="selectAll?publisher=${publisher}">
                                            <div class="chart tag-flag-100 bgm-flag-100" style="width: 262px; height: 117px; padding: 0px; display: none; -webkit-tap-highlight-color: transparent; user-select: none; background: transparent;" id="open_count" data-title="2018-06-17,2018-06-18,2018-06-19,2018-06-20,2018-06-21,2018-06-22,2018-06-23,2018-06-24,2018-06-25,2018-06-26,2018-06-27" data-val="0,0,0,0,0,0,0,0,0,0,0" _echarts_instance_="ec_1530197671941"></div>
                                            <div class="count">
                                                <h2>${pcount}</h2>

                                                <div>打开</div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 col-xs-6 chart-item">
                                <div class="issue-charts-item chart-flag-0">
                                    <div class="clearfix">
                                        <a href="getstatus?publisher=${publisher}">
                                            <div class="chart tag-flag-100 bgm-flag-0" style="width: 122px;height: 117px;" id="unsolved" data-title="2018-06-17,2018-06-18,2018-06-19,2018-06-20,2018-06-21,2018-06-22,2018-06-23,2018-06-24,2018-06-25,2018-06-26,2018-06-27" data-val="0,0,0,0,0,0,0,0,0,0,0"></div>
                                            <div class="count">
                                                <h2>${scount}</h2>

                                                <div>新建</div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 col-xs-6 chart-item">
                                <div class="issue-charts-item chart-flag-1">
                                    <div class="clearfix">
                                        <a href="getstatus2?publisher=${publisher}">
                                            <div class="chart tag-flag-100 bgm-flag-1" style="width: 122px;height: 117px;" id="solving" data-title="2018-06-17,2018-06-18,2018-06-19,2018-06-20,2018-06-21,2018-06-22,2018-06-23,2018-06-24,2018-06-25,2018-06-26,2018-06-27" data-val="0,0,0,0,0,0,0,0,0,0,0"></div>
                                            <div class="count">
                                                <h2>${scount2}</h2>

                                                <div>进行中</div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 col-xs-6 chart-item">
                                <div class="issue-charts-item chart-flag-4">
                                    <div class="clearfix">
                                        <a href="getstatus3?publisher=${publisher}">
                                            <div class="chart tag-flag-100 bgm-flag-4" style="width: 122px;height: 117px;" id="reopen" data-title="2018-06-17,2018-06-18,2018-06-19,2018-06-20,2018-06-21,2018-06-22,2018-06-23,2018-06-24,2018-06-25,2018-06-26,2018-06-27" data-val="0,0,0,0,0,0,0,0,0,0,0"></div>
                                            <div class="count">
                                                <h2>${scount3}</h2>

                                                <div>重新打开</div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 col-xs-6 chart-item">
                                <div class="issue-charts-item chart-flag-2">
                                    <div class="clearfix">
                                        <a href="getstatus4?publisher=${publisher}">
                                            <div class="chart tag-flag-100 bgm-flag-2" style="width: 122px; height: 117px; display: none; -webkit-tap-highlight-color: transparent; user-select: none; background: transparent;" id="solved" data-title="2018-06-17,2018-06-18,2018-06-19,2018-06-20,2018-06-21,2018-06-22,2018-06-23,2018-06-24,2018-06-25,2018-06-26,2018-06-27" data-val="0,0,0,0,0,0,0,0,0,0,0" _echarts_instance_="ec_1530197671942"></div>
                                            <div class="count">
                                                <h2>${scount4}</h2>

                                                <div>已解决</div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 col-xs-6 chart-item">
                                <div class="issue-charts-item chart-flag-6">
                                    <div class="clearfix">
                                        <a href="getstatus5?publisher=${publisher}">
                                            <div class="chart tag-flag-100 bgm-flag-6" style="width: 122px; height: 117px; display: block; -webkit-tap-highlight-color: transparent; user-select: none; background: transparent;" id="wait_to_solve" data-title="2018-06-17,2018-06-18,2018-06-19,2018-06-20,2018-06-21,2018-06-22,2018-06-23,2018-06-24,2018-06-25,2018-06-26,2018-06-27" data-val="0,0,0,0,0,0,0,0,0,0,0" _echarts_instance_="ec_1530197671944"><div style="position: relative; overflow: hidden; width: 102px; height: 97px;"><canvas width="102" height="97" data-zr-dom-id="zr_0" style="position: absolute; left: 0px; top: 0px; width: 102px; height: 97px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></canvas></div><div></div></div>
                                            <div class="count">
                                                <h2>${scount5}</h2>

                                                <div>留待解决</div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3 col-xs-6 chart-item have2">
                                <div class="col-sm-12 chart-item">
                                    <div class="issue-charts-item chart-flag-5">
                                        <div class="clearfix">
                                            <a href="getstatus6?publisher=${publisher}">
                                                <div class="chart tag-flag-100 bgm-flag-5" style="width: 122px;height: 45px;" id="ignore" data-title="2018-06-17,2018-06-18,2018-06-19,2018-06-20,2018-06-21,2018-06-22,2018-06-23,2018-06-24,2018-06-25,2018-06-26,2018-06-27" data-val="0,0,0,0,0,0,0,0,0,0,0"></div>
                                                <div class="count">
                                                    <div>已忽略</div>
                                                    <h2>${scount6}</h2>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-12 chart-item">
                                    <div class="issue-charts-item chart-flag-3">
                                        <div class="clearfix">
                                            <a href="getstatus7?publisher=${publisher}">
                                                <div class="chart tag-flag-100 bgm-flag-3" style="width: 122px;height: 45px;" id="closed" data-title="2018-06-17,2018-06-18,2018-06-19,2018-06-20,2018-06-21,2018-06-22,2018-06-23,2018-06-24,2018-06-25,2018-06-26,2018-06-27" data-val="0,0,0,0,0,0,0,0,0,0,0"></div>
                                                <div class="count">
                                                    <div>已关闭</div>
                                                    <h2>${scount7}</h2>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="listview wbg z-depth-1 zh-cn" id="project_info">
                <div class="lv-header">项目信息</div>
                <div class="lv-body">
                    <div class="lv-item media">
                        <div class="pull-left">
                            <b>项目名称</b>：
                        </div>
                        <div class="media-body">
                            <div class="lv-title"><a href="#">xxxx</a></div>
                        </div>
                    </div>
                    <div class="lv-item media">
                        <div class="pull-left">
                            <b>系统平台</b>：
                        </div>
                        <div class="media-body">
                            <div class="lv-title">
                                <i class="fa icon-apple"></i>
                                Web                            </div>
                        </div>
                    </div>
                    
                    <div class="lv-item media">
                        <div class="pull-left">
                            <b>创建时间</b>：
                        </div>
                        <div class="media-body">
                            <div class="lv-title wsp8">2018-06-28 12:09:55</div>
                        </div>
                    </div>
                    
                                        
                    <div class="lv-item media">
                        <div class="pull-left">
                            <b>项目 ID</b>：
                        </div>
                        <div class="media-body">
                            <div class="lv-title">
                                0ca4010a456ddf1ecff9c76341a0f64f                                <i class="iconfont testin_copy_key" data-clipboard-text="0ca4010a456ddf1ecff9c76341a0f64f" title="复制项目ID"></i>
                            </div>
                        </div>
                    </div>
                    <div class="lv-item media">
                        <div class="pull-left p-t-4"><b>项目成员</b>：</div>
                        <div class="media-body">
                            <div class="ul-container">
                                <div class="row members">
                                                                            <div class="col-sm-4 col-xs-4 m-b-15">
                                            <img class="logo-md" src="./image/default-portrait.png">
                                            <span></span>
                                        </div>
                                                                                                        </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="col-md-6 m-b-30 p-side10">
            <div class="listview wbg z-depth-1" id="project_my">
                <div class="lv-body">
                    <ul class="tab-nav">
                       
                        <li>
                            <a href="#" id="tab_report" aria-controls="my-report-layout" role="tab" data-toggle="tab" aria-expanded="true" data-action="my-create-problem">我提交的</a>
                        </li>
                       
                    </ul>
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="my-assign-layout"><div class="row">
    <div class="col-xs-3">
        <a class="info-block-default" href="getstatusbypublisher?publisher=${publisher}">
            <h1 class="c-flag-0">${countUid}</h1>

            <div>新建</div>
        </a>
    </div>
    <div class="col-xs-3">
        <a class="info-block-default" href="getstatusbypublisher2?publisher=${publisher}">
            <h1 class="c-flag-1">${countUid2}</h1>

            <div>进行中</div>
        </a>
    </div>
    <div class="col-xs-3">
        <a class="info-block-default" href="getstatusbypublisher3?publisher=${publisher}">
            <h1 class="c-flag-4">${countUid3}</h1>

            <div>重新打开</div>
        </a>
    </div>
    <div class="col-xs-3">
        <a class="info-block-default" href="getstatusbypublisher4?publisher=${publisher}">
            <h1 class="c-flag-2">${countUid4}</h1>

            <div>已解决</div>
        </a>
    </div>
</div>


</div>

                        <div role="tabpanel" class="tab-pane" id="my-report-layout">

                        </div>
                        <div role="tabpanel" class="tab-pane" id="my-track-layout">

                        </div>
                    </div>
                </div>
            </div>
            
                        <div class="listview wbg z-depth-1" id="project_my">
                <div class="lv-body">
                    <ul class="tab-nav">
                       
                        <li>
                            <a href="#" id="tab_report" aria-controls="my-report-layout" role="tab" data-toggle="tab" aria-expanded="true" data-action="my-create-problem">指派给我的</a>
                        </li>
                       
                    </ul>
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="my-assign-layout"><div class="row">
    <div class="col-xs-3">
        <a class="info-block-default" href="">
            <h1 class="c-flag-0">0</h1>

            <div>新建</div>
        </a>
    </div>
    <div class="col-xs-3">
        <a class="info-block-default" href="">
            <h1 class="c-flag-1">0</h1>

            <div>进行中</div>
        </a>
    </div>
    <div class="col-xs-3">
        <a class="info-block-default" href="">
            <h1 class="c-flag-4">0</h1>

            <div>重新打开</div>
        </a>
    </div>
    <div class="col-xs-3">
        <a class="info-block-default" href="">
            <h1 class="c-flag-2">0</h1>

            <div>已解决</div>
        </a>
    </div>
</div>


</div>

                        <div role="tabpanel" class="tab-pane" id="my-report-layout">

                        </div>
                        <div role="tabpanel" class="tab-pane" id="my-track-layout">

                        </div>
                    </div>
                </div>
            </div>
            
                        <div class="listview wbg z-depth-1" id="project_my">
                <div class="lv-body">
                    <ul class="tab-nav">
                       
                        <li>
                            <a href="#" id="tab_report" aria-controls="my-report-layout" role="tab" data-toggle="tab" aria-expanded="true" data-action="my-create-problem">我跟踪的</a>
                        </li>
                       
                    </ul>
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="my-assign-layout"><div class="row">
    <div class="col-xs-3">
        <a class="info-block-default" href="">
            <h1 class="c-flag-0">0</h1>

            <div>新建</div>
        </a>
    </div>
    <div class="col-xs-3">
        <a class="info-block-default" href="">
            <h1 class="c-flag-1">0</h1>

            <div>进行中</div>
        </a>
    </div>
    <div class="col-xs-3">
        <a class="info-block-default" href="">
            <h1 class="c-flag-4">0</h1>

            <div>重新打开</div>
        </a>
    </div>
    <div class="col-xs-3">
        <a class="info-block-default" href="">
            <h1 class="c-flag-2">0</h1>

            <div>已解决</div>
        </a>
    </div>
</div>


</div>

                        <div role="tabpanel" class="tab-pane" id="my-report-layout">

                        </div>
                        <div role="tabpanel" class="tab-pane" id="my-track-layout">

                        </div>
                    </div>
                </div>
            </div>
            
            
        </div>
    </div>
</div>

<script async="" src="./js/analytics.js"></script><script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-83522830-1', 'auto');
  ga('send', 'pageview');

</script>



<script src="./js/jquery.js"></script>
<script src="./js/yii.js"></script>
<script src="./js/bootstrap.js"></script>
<script src="./js/jquery.cookie.js"></script>
<script src="./js/jquery.tip.js"></script>
<script src="./js/main.js"></script>
<script src="./js/clipboard.min.js"></script>
<script src="./js/testinBS_norely.js"></script>
<script src="./js/index.js"></script>
<script src="./js/echarts.min.js" 0="frontend\assets\AppAsset"></script>
<script type="text/javascript">var projectInvitedIds = '';
</script>


</body>
</html>
