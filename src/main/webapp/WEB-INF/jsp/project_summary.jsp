<%@ include file="common_params.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>项目概述 - BugPass</title>

    <%@ include file="common_head.jsp" %>

    <script type="text/javascript">
        $(window).ready(function () {
            var date = new Date();
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var day = date.getDay();
            $('#currentDate').text(year + '年 ' + month + '月 ' + day + '日');
            var h = date.getHours();
            var m = date.getMinutes();
            var s = date.getSeconds();
            m = m < 10 ? '0' + m : m;
            s = s < 10 ? '0' + s : s;
            $('#currentTime').text(h + ':' + m + ':' + s);

            setInterval(function () {
                var date = new Date();
                var h = date.getHours();
                var m = date.getMinutes();
                var s = date.getSeconds();
                m = m < 10 ? '0' + m : m;
                s = s < 10 ? '0' + s : s;
                $('#currentTime').text(h + ':' + m + ':' + s);
            }, 1000);
        });
    </script>
</head>

<body>

<% request.setAttribute("navItem", "summary"); %>
<%@ include file="navbar.jsp" %>

<div class="container">
    <div class="row">

        <!-- 左侧栏 -->
        <div class="col-md-3">
            <!-- 时间 -->
            <div class="card bg-light text-center mb-4">
                <div class="card-header" id="currentDate"></div>
                <div class="card-body">
                    <h1 class="card-title mb-0" id="currentTime">0:00:00</h1>
                </div>
            </div>
            <!-- 项目信息 -->
            <div class="card card-body">
                <h5 class="mb-4">项目信息</h5>
                <div class="form-group">
                    <label>项目ID</label>
                    <input type="text" class="form-control-plaintext" value="${currentProject.displayID}" readonly>
                </div>
                <div class="form-group">
                    <label>项目名称</label>
                    <input type="text" class="form-control-plaintext" value="${currentProject.projectName}" readonly>
                </div>
                <div class="form-group">
                    <label>项目描述</label>
                    <input type="text" class="form-control-plaintext" value="${projectDesc.displayID}" readonly>
                </div>
                <div class="form-group">
                    <label>创建时间</label>
                    <input type="text" class="form-control-plaintext"
                           value="<fmt:formatDate value="${currentProject.createTime}" pattern="yyyy年M月d日 H:mm"/>"
                           readonly>
                </div>
                <div class="form-group">
                    <label>创建人</label>
                    <img class="mr-2" src="img/avatar/${currentProjectCreator.picture}.png"
                         style="width:40px;height:40px;border-radius:100%"/>
                    ${currentProjectCreator.realname == null ? currentProjectCreator.username : currentProjectCreator.realname}
                </div>
            </div>
        </div>

        <!-- 主区域 -->
        <div class="col-md-9">

            <!-- 统计信息 -->
            <div class="col-sm-6 col-md-4 col-lg-3 col-xl-2 mb-4">
                <div class="card bg-primary text-white text-center">
                    <div class="card-body">
                        <h1 class="card-title mb-0">TODO</h1>
                    </div>
                    <div class="card-footer">TODO</div>
                </div>
            </div>

            <div class="col-sm-6 col-md-4 col-lg-3 col-xl-2 mb-4">
                <div class="card bg-success text-white text-center">
                    <div class="card-body">
                        <h1 class="card-title mb-0">TODO</h1>
                    </div>
                    <div class="card-footer">TODO</div>
                </div>
            </div>

            <div class="col-sm-6 col-md-4 col-lg-3 col-xl-2 mb-4">
                <div class="card bg-warning text-white text-center">
                    <div class="card-body">
                        <h1 class="card-title mb-0">TODO</h1>
                    </div>
                    <div class="card-footer">TODO</div>
                </div>
            </div>

            <div class="col-sm-6 col-md-4 col-lg-3 col-xl-2 mb-4">
                <div class="card bg-danger text-white text-center">
                    <div class="card-body">
                        <h1 class="card-title mb-0">TODO</h1>
                    </div>
                    <div class="card-footer">TODO</div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>

</body>
</html>
