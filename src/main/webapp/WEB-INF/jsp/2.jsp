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
<link rel="shortcut icon" href="./image/testin.png">
    <link href="./css/bootstrap.css" rel="stylesheet">
<link href="./css/normalize.css" rel="stylesheet">
<link href="./css/iconfont.css" rel="stylesheet">
<link href="./css/style.css" rel="stylesheet">
<link href="./css/moudle.css" rel="stylesheet">
<link href="./css/nav.css" rel="stylesheet">
<link href="./css/mod.css" rel="stylesheet">
<link href="./css/mod(1).css" rel="stylesheet" 0="frontend\assets\AppAsset">
<link href="./css/problem_list.css" rel="stylesheet" 0="frontend\assets\AppAsset">
<link href="./css/prettyPhoto.css" rel="stylesheet" 0="frontend\assets\AppAsset">
<link rel="stylesheet" type="text/css" href="css/table4.css"/>

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
                                        <a href="http://bugout.testin.cn/buglist?key=0ca4010a456ddf1ecff9c76341a0f64f#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="iconfont apple-icon" id="nav_project_type">
                                                                                                   
                                                                                        </i>
                        <span id="nav_project_name">
                                                            xxxx                                                    </span>
                        
                        <i id="get_project" class="iconfont arrow-icon"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-left">
                        <ul id="nav_project_ul">            <li class="clearfix">
                            <a href="http://bugout.testin.cn/buglist?key=0ca4010a456ddf1ecff9c76341a0f64f">
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
                    <a href="http://bugout.testin.cn/buglist?key=0ca4010a456ddf1ecff9c76341a0f64f#" class="dropdown-toggle" data-toggle="dropdown">
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


<div class="bugmanagement">
    <!--成员左侧-->
    <div class="bugmanagement-left problem-search-form">
        <div id="bug-filter-bar" class="left-title left-title-filter clearfix">
            <h3>筛选问题</h3>
            <div class="reset-filter-condition" id="btn_resetForm" value=""><i title="清空筛选" style="line-height: 50px;" class="iconfont"></i></div>

            <div class="btn-group dropdown-select filter-dropdown-select">
                <span class="dropdown-select-btn filter-dropdown-select-btn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <input type="hidden" value=""><span class="dropdown-text filter-dropdown-text">未设置</span>
                    <span class="caret"></span>
                </span>

                <ul class="dropdown-menu filter-dropdown-menu" style="min-height: 40px;">
                                            <li class="clearfix" data-empty="true">无筛选条件</li>
                                    </ul>

            </div>
        </div>
       
            <div class="form-group">
                <div class="group-label">类型</div>
                <div class="group-content">
   <xhh:forEach items="${list}" var="p">
                      <div class="cell50">
                        
                        <a href="checktype?protypeid=${p.problemTypeId}&publisher=${publisher}">${p.problemTypeName}</a>
                        
                           
                           
                      </div>
                    </xhh:forEach>
                   
                                      
                                   </div>
            </div>

            <div class="form-group form-group-bug-level">
                <div class="group-label">级别</div>
                <div class="group-content">

                                       <xhh:forEach items="${list2}" var="l">
                      <div class="cell50">
                           
                           <a href="checklevel?plevelid=${l.problemLevelId}&publisher=${publisher}">${l.problemLevelName}</a>
                      </div>
                    </xhh:forEach>
                                   </div>
            </div>

            <div class="form-group">
                <div class="group-label">状态</div>
                <div class="group-content">
                                        <xhh:forEach items="${list3}" var="s">
                      <div class="cell50">
                       
                        
                            <a href="checkstatus?pstatusid=${s.problemStatusId}&publisher=${publisher}">${s.problemStatusName}</a>
                      </div>
                    </xhh:forEach>
                                   </div>
            </div>
            
            <div class="form-group">
                <div class="group-label">版本</div>
                <div class="group-content version-container">
                    <div class="version-list">

                        <div class="cell50">
                            <div class="dropdown dropdown-multi">

                                <div class="dropdown-multi-btn" data-toggle="dropdown">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" name="version_id" value="0" class="input-checkbox"><span class="input-checkbox-show"></span>&nbsp;未归属
                                    </label>
                                </div>

                            </div>
                        </div>

                                            </div>

                                    </div>
            </div>


            
                        
            <div class="form-group" id="form_member">
                <div class="group-label">成员</div>
                <div class="group-content layout-table">
                    <ul>
                        <li>人员</li>
                        <li>指派人</li>
                        <li>提交人</li>
                        <li>跟踪人</li>
                    </ul>
                                                                        <ul>
                                <li class="wd-80" title="郭朝晖"><span class="user-head"><img src="./image/default-portrait.png"></span>郭朝晖</li>
                                <li>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" class="input-checkbox" name="appointee_user_id" value="2000046875"><span class="input-checkbox-show"></span>
                                    </label>
                                </li>
                                <li>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" class="input-checkbox" name="create_user_id" value="2000046875"><span class="input-checkbox-show"></span>
                                    </label>
                                </li>
                                <li>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" class="input-checkbox" name="followers" value="2000046875"><span class="input-checkbox-show"></span>
                                    </label>
                                </li>
                            </ul>
                                            
                </div>
            </div>
            
               <div>
               <button type="button" class="saveFilterButton2 saveFilterCondition" onclick="javascript:location.href='checkAll?uid=${uid}'">查询</button>
               </div>

        <!--保存筛选条件-->
     
        <!--增加保存条件-->
    </div>
    <!--成员左侧 END-->
    
    <!--成员右侧-->
    <div class="bugmanagement-right">
        <div class="main-title batch_problem_list_title">
            <div class="layout-fixed">
                <div class="auto-item">
                    <div class="btn-group text-label">
                        <span>
                            <span class="dropdown-text"><span class="v-middle"><label style="font-weight:normal;margin-bottom:0px;">问题列表</label></span></span>
                        </span>
                    </div>
                </div>

                <div class="fixed-item"><input type="text" name="search" class="input-search" placeholder="请输入问题名称中的关键词或 #ID"><span class="iconfont icon-search"></span></div>
                <i id="bug_export_id" class="iconfont exportBtn" title="导出" style="display:none"></i>
            </div>
        </div>

        <div id="bug_list">
<div class="page-pagination">
    <div class="layout-fixed">
        <div id="bug-batch-options" class="auto-item" style="position: relative;">

            <div id="bug-batch-update"><div class="btn-group text-label">
        <span class="dropdown-text">
            <span class="v-middle">
                <input id="bug-select-all" type="checkbox" value="1">&nbsp;
                <label style="font-weight:normal;margin-bottom:0px;" for="bug-select-all">全选</label>
            </span>
        </span>
    </div><div class="select-all-list">
        <div class="btn-group dropdown-select text-label bug-item-select">
            <span class="dropdown-select-btn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <input type="hidden" value="0"><span class="dropdown-text">
                <span class="v-middle">修改重要级别</span><span class="caret"></span></span>
            </span>

            <ul class="dropdown-menu" data-field="bug_level">

                            <li data-value="3" data-selected="span-selected-red" data-type="bug_level" value="非常重要"><i class="icon-circles bgClr-red"></i><span class="v-middle">非常重要</span></li>
                            <li data-value="2" data-selected="span-selected-yellow" data-type="bug_level" value="重要"><i class="icon-circles bgClr-yellow"></i><span class="v-middle">重要</span></li>
                            <li data-value="1" data-selected="span-selected-purple" data-type="bug_level" value="一般"><i class="icon-circles bgClr-purple"></i><span class="v-middle">一般</span></li>
                            <li data-value="0" data-selected="span-selected-gray" data-type="bug_level" value="不重要"><i class="icon-circles bgClr-gray"></i><span class="v-middle">不重要</span></li>
                        </ul>
        </div>

        <div class="btn-group dropdown-select text-label bug-item-select">
            <span class="dropdown-select-btn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <input type="hidden" value="0"><span class="dropdown-text w66"><span class="v-middle">修改状态</span><span class="caret"></span></span>
            </span>

            <ul class="dropdown-menu" data-field="bug_status">
                                    <li data-value="0" data-type="bug_status" data-id="" value="新建"><i class="iconfont"></i><span class="v-middle">新建</span></li>
                                    <li data-value="1" data-type="bug_status" data-id="" value="进行中"><i class="iconfont"></i><span class="v-middle">进行中</span></li>
                                    <li data-value="2" data-type="bug_status" data-id="" value="重新打开"><i class="iconfont"></i><span class="v-middle">重新打开</span></li>
                                    <li data-value="3" data-type="bug_status" data-id="" value="已解决"><i class="iconfont"></i><span class="v-middle">已解决</span></li>
                                    <li data-value="4" data-type="bug_status" data-id="" value="留待解决"><i class="iconfont"></i><span class="v-middle">留待解决</span></li>
                                    <li data-value="5" data-type="bug_status" data-id="" value="已忽略"><i class="iconfont"></i><span class="v-middle">已忽略</span></li>
                                    <li data-value="6" data-type="bug_status" data-id="" value="已关闭"><i class="iconfont"></i><span class="v-middle">已关闭</span></li>
                            </ul>
        </div>

        <div class="btn-group dropdown-select text-label bug-item-select">
            <span class="dropdown-select-btn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <input type="hidden" value="0"><span class="dropdown-text"><span class="v-middle">修改指派人</span><span class="caret"></span></span>
            </span>
            <div class="num-search">
                <span class="iconfont icon-search"></span>
                <input name="searchStaffName" type="text" placeholder="请搜索姓名">
            </div>
            <ul class="dropdown-menu dropdown-search-menu" data-field="appointee_user_id">
                           <li data-value="2000046875" data-type="appointee_user_id" value="郭朝晖"><img height="16" width="16" src="./image/default-portrait.png"><span class="v-middle">郭朝晖</span></li>
                        </ul>
        </div>

            </div></div>
            
            <div class="btn-group dropdown-select dropdown-select-default select-sort-list" style="position:absolute;top:3px;left:68px;">
                <span class="dropdown-select-btn" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <input id="sort" type="hidden" value=""><span class="dropdown-text">默认排序</span> <span class="caret"></span>
                </span>
                <ul class="dropdown-menu">
                    <li value="">默认排序</li>
                    <li value="bug_status">按状态排序</li>
                    <li value="bug_level">按重要级别排序</li>
                    <li value="create_time">按提交时间排序</li>
                </ul>
            </div>
          
            
            
       
        </div>
        <div class="fixed-item">共 0 条
                                </div>
    </div>
</div>

<div class="problem-list">
             <div class="empty-item">
            <span class="v-middle">
            <xhh:if test="${all!=null}">
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
	
	  <xhh:forEach items="${all}" var="a">
            
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
             
                                   
                            </span>
            <span class="h-middle"></span>
        </div>
      </div>

</div>
    </div>
    <!--成员右侧 END-->
</div>

<!--弹窗-->
<div class="modal fade testin-modal enterprise-tip" id="dele" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    ×
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    保存筛选条件
                </h4>
            </div>
            <div class="modal-body">
                <div class="content-form">
                    <span class="form-label">名称:</span>
                    <input class="adding-name filterName" type="text" value="">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn testin-btn-primary saveFilterButton">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>




<script async="" src="./js/analytics.js"></script><script>
    var _currentFilterId = '';
    var _lastFilters = '{"filter_name":"未设置","page":1,"limit":20,"order":"","where":{"bug_status":["3"]},"followers":[]}';
    var _filter_condition = [];
    var _filter_md5 = [];
</script>

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
<script src="./js/jquery.prettyphoto.js" 0="frontend\assets\AppAsset"></script>
<script src="./js/problem_list.js" 0="frontend\assets\AppAsset"></script>
<script src="./js/edit.js" 0="frontend\assets\AppAsset"></script>
<script src="./js/buglist.js" 0="frontend\assets\AppAsset"></script>
<script src="./js/jquery.md5.js" 0="frontend\assets\AppAsset"></script>
<script type="text/javascript">var projectInvitedIds = '';
</script>


</body>
</html>
