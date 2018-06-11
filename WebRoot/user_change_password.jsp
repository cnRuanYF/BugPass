<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0033)http://bugout.testin.cn/user-info -->
<html lang="zh-CN" style="font-size: 100px;"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="csrf-param" content="_csrf">
    <meta name="csrf-token" content="MTZXeW9lREJhRxYQBVM1MAcBOUxXDwMQeVk0Gj4EEythBAAePicPew==">
    <title>个人设置 | Bugout</title>
    <link rel="shortcut icon" href="http://bugout.testin.cn/images/bug-management/testin.png">
    <link href="./css/personal.css" rel="stylesheet">
<link href="./css/bootstrap.css" rel="stylesheet">
<link href="./css/normalize.css" rel="stylesheet">
<link href="./css/iconfont.css" rel="stylesheet">
<link href="./css/style.css" rel="stylesheet">
<link href="./css/moudle.css" rel="stylesheet">
<link href="./css/nav.css" rel="stylesheet">
<link href="./css/mod.css" rel="stylesheet"></head>
<body key="">


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
            <a class="navbar-brand clearfix" href="http://bugout.testin.cn/">
                <img src="./img/Bugout_logo2.png">
            </a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-nav-right">
                <li><a href="http://bugout.testin.cn/bug" class="dropdown-toggle">缺陷管理</a></li>
                <li><a href="http://docs.testin.cn/" target="_blank" class="dropdown-toggle">帮助中心</a></li>
                                    <li class="dropdown">
                        <a href="http://bugout.testin.cn/user-info#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="user-mail">Lee</span><i class="iconfont arrow-icon"></i>
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


<div class="bugmanagement">
    <div class="bugmanagement-personal clearfix">
        <!--成员左侧-->
        
<!--成员左侧-->
<div class="bugmanagement-staff-left">
    <div class="bugmanagement-left">
        <h3><span>个人中心</span></h3>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath }/personalCenter.jsp">
                    <i class="iconfont"></i>
                    <span>个人设置</span>
                </a>
            </li>
            <li class="active">
                <a href="${pageContext.request.contextPath }/password.jsp">
                    <i class="iconfont"></i>
                    <span>修改密码</span>
                </a>
            </li>
        </ul>
    </div>
</div>
<!--成员左侧 END-->
        <!--成员右侧-->
        <div class="bugmanagement-staff-right">
            <!--默认指派与跟踪-->
            <div class="bugmanagement-right">
                <h3 class="cygl yjtx"><span>修改密码</span></h3>
                <div class="change-password-box">
                    <form id="change-password-form" class="form-horizontal testin-form-horizontal" action="${pageContext.request.contextPath }/changePassword.do" method="post">
<input type="hidden" name="_csrf" value="cHppbmtHVEUgLiVYGwsQGjsyAgFSCx0qFT0fACI2GiE/OwsnXhgwGg==">                    <div class="form-group field-changepasswordformmodel-password required">
<label class="col-sm-3 control-label" for="oldPassword">原密码</label>
<div class="col-sm-6"><input type="password" id="oldPassword" class="form-control" name="oldPassword" placeholder="请输入原密码"></div>
<div class="help-block"></div>
</div>                    <div class="form-group field-changepasswordformmodel-newpassword required">
<label class="col-sm-3 control-label" for="newPassword">新密码</label>
<div class="col-sm-6"><input type="password" id="newPassword" class="form-control" name="newPassword" placeholder="请输入新密码"></div>
<div class="help-block"></div>
</div>                    <div class="form-group field-changepasswordformmodel-newrepassword required">
<label class="col-sm-3 control-label" for="confirmNewPassword">确认新密码</label>
<div class="col-sm-6"><input type="password" id="confirmNewPassword" class="form-control" name="confirmNewPassword" placeholder="请确认新密码"></div>
<div class="help-block"></div>
</div>                    <a id="change-password-save" class="save-btn">保存</a>
                    </form>                    <!--<form class="form-horizontal testin-form-horizontal" role="form">
                        <div class="form-group">
                            <label for="firstname" class="col-sm-3 control-label">原密码</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="firstname" placeholder="请输入原密码">
                            </div>
                            <div class="help-block">请输入原密码</div>
                        </div>
                        <div class="form-group">
                            <label for="firstname" class="col-sm-3 control-label">新密码</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="firstname" placeholder="请输入新密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="firstname" class="col-sm-3 control-label">确认新密码</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="firstname" placeholder="请确认新密码">
                            </div>
                        </div>
                    </form>
                    <a href="#" class="save-btn">保存</a>-->
                </div>
            </div>
            <!--成员右侧 END-->
        </div>
    </div>

        
        
<script async="" src="./js/analytics.js"></script><script>
    var uid = 2000023524;
    var service = 'http://fs.testin.cn/form.upload';
    var staff_phone = '13012832916';
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
<script src="./js/index.js"></script>
<script src="./js/util.min.js" 0="frontend\assets\AppAsset"></script>
<script src="./js/webuploader.min.js" 0="frontend\assets\AppAsset"></script>
<script src="./js/T_Countdown.js" 0="frontend\assets\PublicAsset"></script>
<script src="./js/yii.validation.js"></script>
<script src="./js/yii.activeForm.js"></script>
<script type="text/javascript">var projectInvitedIds = '';
</script>
<script type="text/javascript">jQuery(document).ready(function () {
jQuery('#user-info-form').yiiActiveForm([{"id":"enterprisemanagemodel-staff_name","name":"staff_name","container":".field-enterprisemanagemodel-staff_name","input":"#enterprisemanagemodel-staff_name","validate":function (attribute, value, messages, deferred, $form) {yii.validation.required(value, messages, {"message":"姓名不能为空"});}},{"id":"enterprisemanagemodel-staff_phone","name":"staff_phone","container":".field-enterprisemanagemodel-staff_phone","input":"#enterprisemanagemodel-staff_phone","validate":function (attribute, value, messages, deferred, $form) {yii.validation.required(value, messages, {"message":"请输入您的手机号码"});yii.validation.regularExpression(value, messages, {"pattern":/^(1[3|4|5|7|8][0-9])\d{8}$/,"not":false,"message":"您输入的手机号码有误，请检查重新输入","skipOnEmpty":1});}},{"id":"enterprisemanagemodel-staff_qq","name":"staff_qq","container":".field-enterprisemanagemodel-staff_qq","input":"#enterprisemanagemodel-staff_qq","validate":function (attribute, value, messages, deferred, $form) {yii.validation.number(value, messages, {"pattern":/^\s*[+-]?\d+\s*$/,"message":"QQ号码只能是数字","skipOnEmpty":1});yii.validation.required(value, messages, {"message":"请输入您常用的QQ"});}}], []);
});</script>


</div></body></html>