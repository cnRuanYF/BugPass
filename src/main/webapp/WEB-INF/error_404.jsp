<%@ include file="jsp/common_params.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>错误 - BugPass</title>

    <%@ include file="jsp/common_head.jsp" %>

    <!--首页样式-->
    <style>
        body {
            padding-top: 2rem;
        }
    </style>
</head>
<body>

<!--导航栏-->
<header class="navbar navbar-light">
    <div class="container">
        <div class="navbar-brand">
            <h3 class="mt-1 mb-1">
                <i class="fa fa-bug mr-2"></i>BugPass
            </h3>
        </div>
        <a class="btn btn-outline-primary" href="index">返回首页</a>
    </div>
</header>

<div class="container">
    <div class="text-center">
        <h1 class="mt-5 mb-5 text-warning" style="font-size:96px">
            <i class="far fa-meh mr-4"></i>404
        </h1>
        <h4 class="mb-3">
            想访问
            <%=request.getAttribute("javax.servlet.error.message")%>
            这个页面吗？
        </h4>
        <h2>不存在的</h2>
        <h4 class="mb-5">不要在地址栏瞎输入好不好</h4>
        <h5 class="mb-5 text-secondary">
            <i class="fa fa-hourglass-start fa-spin mr-2"></i>
            <span id="timerProgress">
                <span id="timer"></span>
                秒后自动
                <a href="index">跳转到首页</a>
            </span>
        </h5>
    </div>
</div>

<!--自动跳转-->
<script type="text/javascript">
    var timeSec = 10;
    $('#timer').html(timeSec);

    var redirectTimer = setInterval(function () {
        timeSec--;
        if (timeSec > 0) {
            $('#timer').html(timeSec);
        } else {
            $('#timerProgress').html('自动跳转中...');
            location.href = "index";
            clearInterval(redirectTimer);
        }
    }, 1000);
</script>

<%@ include file="jsp/common_footer.jsp" %>

<!--背景-->
<canvas id="bgCanvas"></canvas>
<script type="text/javascript" src="js/bg_animation.js"></script>

</body>
</html>

