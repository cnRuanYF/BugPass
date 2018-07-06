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
<link href="./css/problem_list.css" rel="stylesheet" 0="frontend\assets\AppAsset">
<link href="./css/webuploader.css" rel="stylesheet" 0="frontend\assets\AppAsset">
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
                                        <a href="http://bugout.testin.cn/add-bug?key=0ca4010a456ddf1ecff9c76341a0f64f#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="iconfont apple-icon" id="nav_project_type">
                                                                                                   
                                                                                        </i>
                        <span id="nav_project_name">
                                                            xxxx                                                    </span>
                        
                        <i id="get_project" class="iconfont arrow-icon"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-left">
                        <ul id="nav_project_ul">

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
                    <a href="http://bugout.testin.cn/add-bug?key=0ca4010a456ddf1ecff9c76341a0f64f#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="user-mail"></span><i class="iconfont arrow-icon"></i>
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


<script async="" src="./js/analytics.js"></script><script>
    var modules = [];
    var versionList = [];
    var uploadUrl = 'http://fs.testin.cn/form.upload';
</script>


<!--模块-->
 <form action="myupload">
<div class="bugmanagement bugmanagement-problem-edit">
    <!--成员左侧-->
    <div class="bugmanagement-left">
        <div class="left-title"><h3>问题属性</h3></div>
        <div class="bugmanagement-problem-attr">
            <div class="form-group">
                <div class="group-label">问题状态</div>
                <div class="group-content btn-group dropdown dropdown-select dropdown-select-default">
                    <button class="dropdown-select-btn btn btn-default" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="dropdown-text">
                            <i class="iconfont icon-circles"></i>
                            
                        </span>
                        <span class="caret"></span>
                    </button>
            
                                             <select name="pstatusid">
                    <xhh:forEach items="${list3}" var="s">
                     <option value="${s.problemStatusId}">${s.problemStatusName}</option>
                    </xhh:forEach>
                                                   
                             </select>        
                </div>
            </div>
            <div class="form-group">
                <div class="group-label">问题类型</div>
                <div class="group-content btn-group dropdown dropdown-select dropdown-select-default">
                    <button class="dropdown-select-btn btn btn-default" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="dropdown-text">
                            
                        </span>
                        <span class="caret"></span>
                    </button>
               <select name="protypeid">
                    <xhh:forEach items="${list}" var="p">
                     <option value="${p.problemTypeId}">${p.problemTypeName}</option>
                    </xhh:forEach>
                                                   
                             </select>              
                </div>
            </div>
            <div class="form-group">
                <div class="group-label">重要级别</div>
                <div class="group-content btn-group dropdown dropdown-select dropdown-select-default">
                    <button class="dropdown-select-btn btn btn-default" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="dropdown-text">
                            <i class="icon-circles bgClr-purple"></i>

                            
                        </span>
                        <span class="caret"></span>
                    </button>
                 <select name="plevelid">
                    <xhh:forEach items="${list2}" var="l">
                     <option value="${l.problemLevelId}">${l.problemLevelName}</option>
                    </xhh:forEach>
                                                   
                             </select>        
                </div>
            </div>
            <div class="form-group">
                <div class="group-label">指派给</div>
                <div class="group-content btn-group dropdown dropdown-select dropdown-select-default">
                    <button class="dropdown-select-btn btn btn-default" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="dropdown-text">
                            <img style="width: 16px;height: 16px;" src="./image/default-portrait.png">
                            <span class="v-middle"></span>
                        </span>
                        <span class="caret"></span>
                    </button>
                    <div class="num-search">
                        <span class="iconfont icon-search"></span>
                        <input name="searchStaffName" type="text" placeholder="请搜索姓名">
                    </div>
                    <ul class="dropdown-menu dropdown-search-menu">
                  
                                                    <li class="appointee-select" value="2000046875">
                                <img style="width: 16px;height: 16px;" src="./image/default-portrait.png">
                            
                            </li>
                           
                                            </ul>
                                            <input type="hidden" name="publisher" value="${publisher}"/>
                                             
                </div>
            </div>

            <div class="form-group">
                <div class="group-label">模块
                    <a data-toggle="modal" data-target="#add-main" class="add-modules-a">添加模块</a>
                </div>
                <div class="group-content btn-group dropdown dropdown-select dropdown-select-module dropdown-select-default">
                    <button class="dropdown-select-btn btn btn-default" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="dropdown-text">-</span>
                        <span class="caret"></span>
                    </button>
                    <div class="num-search">
                        <span class="iconfont icon-search"></span>
                        <input name="searchStaffName" type="text" placeholder="请搜索模块">
                    </div>
                    <ul class="dropdown-menu dropdown-search-menu" id="bug-module-ul-id">
                        <li class="modules-id-select" data-parent="1" value="0">-</li>
                                            </ul>
                </div>

                <div class="group-content btn-group dropdown dropdown-select dropdown-select-module dropdown-select-default">
                    <button class="dropdown-select-btn btn btn-default" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="dropdown-text" id="module_id_text">-</span>
                        <span class="caret"></span>
                    </button>
                    <div class="num-search">
                        <span class="iconfont icon-search"></span>
                        <input name="searchStaffName" type="text" placeholder="请搜索模块">
                    </div>
                    <ul class="dropdown-menu dropdown-search-menu" id="module_id_son">
                        <li class="modules-id-select" value="">-</li>
                    </ul>
                </div>
            </div>

            <div class="form-group">
                <div class="group-label">版本
                    <a data-toggle="modal" class="add-version-a" data-target="#add-version">添加版本</a>
                </div>
                <div class="group-content btn-group dropdown dropdown-select dropdown-select-version dropdown-select-default">
                    <button class="dropdown-select-btn btn btn-default" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="dropdown-text" id="span-dropdown-text">-</span>
                        <span class="caret"></span>
                    </button>
                    <div class="num-search">
                        <span class="iconfont icon-search"></span>
                        <input name="searchStaffName" type="text" placeholder="请搜索版本">
                    </div>
                    <ul class="dropdown-menu dropdown-search-menu" id="bug-version-ul-id">
                        <li class="version-id-select" data-parent="1" value="0">-</li>
                                            </ul>
                </div>

                <div class="group-content btn-group dropdown dropdown-select dropdown-select-version dropdown-select-default">
                    <button class="dropdown-select-btn btn btn-default" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="dropdown-text" id="version_id_text">-</span>
                        <span class="caret"></span>
                    </button>
                    <div class="num-search">
                        <span class="iconfont icon-search"></span>
                        <input name="searchStaffName" type="text" placeholder="请搜索版本">
                    </div>
                    <ul class="dropdown-menu dropdown-search-menu" id="version_id_son">
                        <li class="version-id-select" value="" id="version_li_id_son">-</li>
                    </ul>
                </div>
            </div>


            <div class="form-group">
                <div class="group-label">跟踪 <input type="checkbox" name="istrack" value="1"></div>
                <div class="group-content">
                    
                        <div class="call bug-follow">
                            <label class="checkbox-inline">
                                <input type="checkbox" value="2000046875" class="input-checkbox">
                                <span class="input-checkbox-show" style="margin-bottom: -5px"></span>&nbsp;<span class="dropdown-text">
                                    <img style="width: 16px;height: 16px; border-radius: 50%" src="./image/default-portrait.png">
                                    <span class="v-middle" style="margin-left: 5px;">
                                  
                                    
                                                                           </span>
                                </span>
                            </label>
                        </div>
                                    </div>
            </div>
        </div>
    </div>
    <!--成员左侧 END-->
    <!--成员右侧-->
    <div class="bugmanagement-right problem-info-edit">
        <div class="main-title">
            <div class="layout-fixed">
                <div class="auto-item">新建问题</div>
            </div>
        </div>
        <div class="problem-form">

            
<input type="hidden" name="_csrf" value="YW5XX1dnT0EnXzhsYQ0NGy8UJRcFLHkEWCkQBRUoPhkiBQBuCBYEJw==">            <input type="hidden" class="bug-follow-input" name="bug_follow">            <div class=" field-buginfomodel-bug_status">

 <div class="group-content"><input type="hidden" id="buginfomodel-bug_status" class="bug-status-select-input" name="BugInfoModel[bug_status]" value="0">
<div class="help-block"></div></div>
</div>            <div class=" field-buginfomodel-bug_type">

 <div class="group-content"><input type="hidden" id="buginfomodel-bug_type" class="bug-type-select-input" name="BugInfoModel[bug_type]" value="5">
<div class="help-block"></div></div>
</div>            <div class=" field-buginfomodel-bug_level">

 <div class="group-content"><input type="hidden" id="buginfomodel-bug_level" class="bug-level-select-input" name="BugInfoModel[bug_level]" value="1">
<div class="help-block"></div></div>
</div>                        <div class=" field-buginfomodel-is_lock">

 <div class="group-content"><input type="hidden" id="buginfomodel-is_lock" class="bug-is-lock-input" name="BugInfoModel[is_lock]" value="0">
<div class="help-block"></div></div>
</div>            <div class=" field-buginfomodel-module_id">

 <div class="group-content"><input type="hidden" id="buginfomodel-module_id" class="modules-id-select-input" name="BugInfoModel[module_id]">
<div class="help-block"></div></div>
</div>            <div class=" field-buginfomodel-appointee_user_id">

 <div class="group-content"><input type="hidden" id="buginfomodel-appointee_user_id" class="appointee-select-input" name="BugInfoModel[appointee_user_id]" value="2000046875">
<div class="help-block"></div></div>
</div>            <div class=" field-buginfomodel-screenshot_list">

 <div class="group-content"><input type="hidden" id="buginfomodel-screenshot_list" class="bug_img_src" name="BugInfoModel[screenshot_list]">
<div class="help-block"></div></div>
</div>            <div class=" field-buginfomodel-annex_list">

 <div class="group-content"><input type="hidden" id="buginfomodel-annex_list" class="bug_attachment_src" name="BugInfoModel[annex_list]">
<div class="help-block"></div></div>
</div>
            <div class="form-group field-buginfomodel-bug_title required">
<label class="group-label" for="buginfomodel-bug_title">问题标题</label>
 <div class="group-content"><input type="text" id="buginfomodel-bug_title" class="form-control input-txt problem-full" name="ptitle" value="" maxlength="50" placeholder="请输入问题标题">
<div class="help-block"></div></div>
</div>
            <div class=" field-buginfomodel-version_id">

 <div class="group-content"><input type="hidden" id="buginfomodel-version_id" class="version-id-select-input" name="BugInfoModel[version_id]">
<div class="help-block"></div></div>
</div>
            <div class="form-group field-buginfomodel-bug_detail required">
<label class="group-label" for="buginfomodel-bug_detail">问题描述</label>
 <div class="group-content"><textarea id="buginfomodel-bug_detail" class="form-control" name="pdescripe" rows="5" placeholder="请尽量详细描述问题"></textarea>
<div class="help-block"></div></div>
</div>

            <div class="form-group bug-lock-switch-form">
                <label class="group-label bug-lock-switch-label" for="buginfomodel-is_lock">锁定问题</label>
                <div class="group-content bug-lock-switch-content">
                    <div class="switch-box switch-box-sm">
                        <input class="bug-is-lock" type="checkbox" name="pislock" value="1">
                        <label></label>
                    </div>
                </div>
                <div class="bug-lock-switch-copy">您可以通过设置，来控制您的问题是否允许团队其他成员进行编辑</div>
            </div>
            <div class="form-group">
                <label class="group-label">截图</label>
                <div class="group-content problem-uploader" id="problem-uploader">
                     <input type="file" name="myfile"/>
                </div>
            </div>
            <div class="form-group" style="margin-bottom:0px;">
                <div class="scan-ewm">
                    <div class="phone-click clearfix">
                        <img src="./image/phone-logo.png" alt="">
                        <span>通过手机上传</span>
                    </div>
                    <div class="erm-box">
                        <img src="./image/qrcode">
                        <p>请扫描二维码上传图片</p>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="group-content enclosure-container">
                    <ul class="enclosure-list annex_e" style="display: none"></ul>
                    <span class="text-blue btn-enclosure-add webuploader-container" id="pick_upload"><div class="webuploader-pick">
                        <i class="iconfont icon-add"></i>添加附件
                    </div><div id="rt_rt_1ch3gv2vdsov11sl1ukf1vfd1035" style="position: absolute; top: -10px; left: 0px; width: 74px; height: 37px; bottom: auto; right: auto;"><input type="file" name="file" class="webuploader-element-invisible"><label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label></div></span>
                    <span class="enclosure-tip">(最多上传5个附件，每个不超过20MB)</span>
                </div>
            </div>
       

            <div class="form-group">
                <div class="group-label">&nbsp;</div>
                <div class="group-content">
                   
                     <input type="submit" value="保存" class="btn btn-sure">
                </div>
            </div>

        </div>
    </div>
    <!--成员右侧 END-->


    <!-- 添加主模块 弹框 -->
    <div class="vm_alert">
        <div class="modal fade testin-modal enterprise-tip" id="add-main" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            ×
                        </button>
                        <h4 class="modal-title">添加主模块</h4>
                    </div>
                    <div class="modal-body">
                        <div class="content-form">
                            <span class="form-label">主模块名</span>
                            <input class="adding-name" type="text">
                            <input id="module-project-id" type="hidden" value="1010576">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn testin-btn-primary button-submit" id="bug-add-module-btn">保存
                        </button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 添加版本 弹框 -->
    <div class="vm_alert">
        <div class="modal fade testin-modal enterprise-tip" id="add-version" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            ×
                        </button>
                        <h4 class="modal-title">添加版本</h4>
                    </div>
                    <div class="modal-body">
                        <div class="content-form">
                            <span class="form-label">版本号</span>
                            <input class="adding-name input-version-name" type="text">
                        </div>
                        <div class="content-form">
                            <span class="form-label">Build</span>
                            <input class="adding-name input-build-name" type="text">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn testin-btn-primary button-submit" id="bug-add-version-btn">保存
                        </button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</form>
<script>
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
<script src="./js/add-bug.js" 0="frontend\assets\AppAsset"></script>
<script src="./js/webuploader.js" 0="frontend\assets\AppAsset"></script>
<script src="./js/socket.io.js" 0="frontend\assets\AppAsset"></script>
<script src="./js/chat.js" 0="frontend\assets\AppAsset"></script>
<script src="./js/yii.validation.js"></script>
<script src="./js/yii.activeForm.js"></script>
<script type="text/javascript">    chat.init({
        uuid : '108366742174485169',
        nodeService : 'ws://ws.testin.cn:3000',
        initObj : {
            action: 'create',
            projectInfo: {
                projectName: "xxxx",
            },
            staffInfo: {
                staffName: "xhh",
                staffPortrait: "/images/bug-management/default-portrait.png"
            }
        }
    });

var projectInvitedIds = '';
</script>
<script type="text/javascript">jQuery(document).ready(function () {
jQuery('#bug-form').yiiActiveForm([{"id":"buginfomodel-bug_status","name":"bug_status","container":".field-buginfomodel-bug_status","input":"#buginfomodel-bug_status","validate":function (attribute, value, messages, deferred, $form) {yii.validation.number(value, messages, {"pattern":/^\s*[+-]?\d+\s*$/,"message":"Bug Status必须是整数。","skipOnEmpty":1});}},{"id":"buginfomodel-bug_type","name":"bug_type","container":".field-buginfomodel-bug_type","input":"#buginfomodel-bug_type","validate":function (attribute, value, messages, deferred, $form) {yii.validation.number(value, messages, {"pattern":/^\s*[+-]?\d+\s*$/,"message":"Bug Type必须是整数。","skipOnEmpty":1});}},{"id":"buginfomodel-bug_level","name":"bug_level","container":".field-buginfomodel-bug_level","input":"#buginfomodel-bug_level","validate":function (attribute, value, messages, deferred, $form) {yii.validation.number(value, messages, {"pattern":/^\s*[+-]?\d+\s*$/,"message":"Bug Level必须是整数。","skipOnEmpty":1});}},{"id":"buginfomodel-module_id","name":"module_id","container":".field-buginfomodel-module_id","input":"#buginfomodel-module_id","validate":function (attribute, value, messages, deferred, $form) {yii.validation.number(value, messages, {"pattern":/^\s*[+-]?\d+\s*$/,"message":"Module Id必须是整数。","skipOnEmpty":1});}},{"id":"buginfomodel-appointee_user_id","name":"appointee_user_id","container":".field-buginfomodel-appointee_user_id","input":"#buginfomodel-appointee_user_id","validate":function (attribute, value, messages, deferred, $form) {yii.validation.number(value, messages, {"pattern":/^\s*[+-]?\d+\s*$/,"message":"Appointee User Id必须是整数。","skipOnEmpty":1});}},{"id":"buginfomodel-screenshot_list","name":"screenshot_list","container":".field-buginfomodel-screenshot_list","input":"#buginfomodel-screenshot_list","validate":function (attribute, value, messages, deferred, $form) {yii.validation.string(value, messages, {"message":"Screenshot List必须是一条字符串。","max":5000,"tooLong":"Screenshot List只能包含至多5,000个字符。","skipOnEmpty":1});}},{"id":"buginfomodel-annex_list","name":"annex_list","container":".field-buginfomodel-annex_list","input":"#buginfomodel-annex_list","validate":function (attribute, value, messages, deferred, $form) {yii.validation.string(value, messages, {"message":"Annex List必须是一条字符串。","max":5000,"tooLong":"Annex List只能包含至多5,000个字符。","skipOnEmpty":1});}},{"id":"buginfomodel-bug_title","name":"bug_title","container":".field-buginfomodel-bug_title","input":"#buginfomodel-bug_title","validate":function (attribute, value, messages, deferred, $form) {yii.validation.string(value, messages, {"message":"Bug Title必须是一条字符串。","max":255,"tooLong":"Bug Title只能包含至多255个字符。","skipOnEmpty":1});yii.validation.required(value, messages, {"message":"请输入问题标题"});}},{"id":"buginfomodel-version_id","name":"version_id","container":".field-buginfomodel-version_id","input":"#buginfomodel-version_id","validate":function (attribute, value, messages, deferred, $form) {yii.validation.number(value, messages, {"pattern":/^\s*[+-]?\d+\s*$/,"message":"Version Id必须是整数。","skipOnEmpty":1});}},{"id":"buginfomodel-bug_detail","name":"bug_detail","container":".field-buginfomodel-bug_detail","input":"#buginfomodel-bug_detail","validate":function (attribute, value, messages, deferred, $form) {yii.validation.string(value, messages, {"message":"Bug Detail必须是一条字符串。","max":5000,"tooLong":"Bug Detail只能包含至多5,000个字符。","skipOnEmpty":1});yii.validation.required(value, messages, {"message":"请输入问题描述"});}}], []);
});</script>


</body>
</html>
