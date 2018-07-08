<%@ include file="common_params.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>BugPass</title>

    <%@ include file="common_head.jsp" %>

    <!--首页样式-->
    <style>
        body {
            padding-top: 2rem;
        }
    </style>
</head>
<body>

<%@ include file="index_navbar.jsp" %>

<div class="container">
    <div class="text-center">
        <h1 class="mt-5 text-primary" style="font-size:64px">
            BugPass
        </h1>
        <h3 class="mt-4">开发团队必备的缺陷管理平台</h3>
        <h4>开源、安全、稳定、高效、易用</h4>
        <div class="mt-5">
            <a class="btn btn-lg btn-outline-primary pl-5 pr-5 btnEnterSys" href="javascript:void(0)">进入系统</a>
        </div>
        <p class="text-muted mt-4">当前版本：v0.1 beta (更新于: 2018-07-06)</p>
    </div>
</div>

<script type="text/javascript">
    $('.btnEnterSys').on('click', function () {
        if (1 == ${currentUser != null ? 1 : 0}) {
            location.href = 'enter';
        } else {
            $('#loginLink').click();
        }
    });
</script>

<%@ include file="common_footer.jsp" %>

<!--背景-->
<canvas id="bgCanvas"></canvas>
<script type="text/javascript" src="js/bg_animation.js"></script>

</body>
</html>

