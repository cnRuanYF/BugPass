<%@ page isErrorPage="true" %>

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
    <div class="row">
        <div class="col-md-6 col-lg-4 offset-lg-2 text-center">
            <h3 class="mt-5 text-danger">
                让我将你心儿摘下
            </h3>
            <h1 class="text-danger" style="font-size:96px">
                伍佰
            </h1>
            <h2 class="mt-2 mt-lg-5 mb-4 text-secondary">服务器内部错误</h2>
        </div>
        <div class="col-md-6">
            <img class="img-fluid" src="img/500.png"/>
        </div>
    </div>
    <h4 class="mt-4 mb-3">${pageContext.exception}</h4>
    <p class="mb-5">
        <c:forEach items="${pageContext.exception.stackTrace}" var="trace">
            ${trace}
        </c:forEach>
    </p>
</div>

<%@ include file="jsp/common_footer.jsp" %>

<!--背景-->
<canvas id="bgCanvas"></canvas>
<script type="text/javascript" src="js/bg_animation.js"></script>

</body>
</html>

