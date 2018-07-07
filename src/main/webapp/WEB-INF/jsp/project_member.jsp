<%@ include file="common_params.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>项目成员 - BugPass</title>

    <%@ include file="common_head.jsp" %>

</head>

<body>

<% request.setAttribute("navItem", "setting"); %>
<%@ include file="navbar.jsp" %>

<div class="container">
    <div class="row">

        <%--侧边栏--%>
        <% request.setAttribute("sideNavItem", "member"); %>
        <%@ include file="project_sidebar.jsp" %>

        <%--主区域--%>
        <div class="col-md-9">

            <%--成员列表--%>
            <div class="card card-body">
                <h5 class="mb-4">项目成员</h5>
                <table class="table table-borderless table-hover">
                    <thead>
                    <tr>
                        <th width="1px"></th>
                        <th>姓名</th>
                        <th>角色</th>
                        <th width="2px">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${memberList}" var="member">
                        <tr>
                            <td>
                                <img class="user-head mr-2" src="img/avatar/${member.user.picture}.png"/>
                            </td>
                            <td>${member.user.realname == null ? member.user.username : member.user.realname}</td>
                            <td>${member.memberRole == 1 ? "创建者" : "成员"}</td>
                            <td>
                                <c:if test="${member.memberRole != 1}">
                                    <a class="btn btn-sm btn-outline-danger" href="member/remove/${member.user.id}">移除</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <%--待确认列表--%>
            <c:if test="${unconfirmList.size() > 0}">
                <div class="card card-body mt-4">
                    <h5 class="mb-4">待确认</h5>
                    <table class="table table-borderless table-hover">
                        <thead>
                        <tr>
                            <th width="1px"></th>
                            <th>姓名</th>
                            <th width="1px">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${unconfirmList}" var="member">
                            <tr>
                                <td>
                                    <img class="user-head mr-2" src="img/avatar/${member.user.picture}.png"/>
                                </td>
                                <td>${member.user.realname == null ? member.user.username : member.user.realname}</td>
                                <td>
                                    <c:if test="${member.memberRole != 1}">
                                        <a class="btn btn-sm btn-outline-secondary" href="member/remove/${member.user.id}">取消邀请</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>

            <%--添加成员--%>
            <div class="card card-body mt-4">
                <h5 class="mb-4">添加成员</h5>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fa fa-search"></i></span>
                    </div>
                    <input type="text" class="form-control" id="searchKeyword" placeholder="输入关键字"
                           oninput="searchUser(this.value)">
                </div>
                <table id="searchResultTable" class="table table-borderless table-hover">
                </table>
                <h1 id="searching" class="text-center text-secondary mt-3 mb-3">
                    <i class="fa fa-circle-notch fa-spin mr-3"></i>Searching...
                </h1>
                <h3 id="searchNoResult" class="text-center text-secondary mt-3 mb-3">
                    <i class="far fa-frown mr-3"></i>No result.
                </h3>
                <h3 id="searchFailed" class="text-center text-secondary mt-3 mb-3">
                    <i class="fa fa-exclamation-circle mr-3"></i>出现错误，请稍后再试
                </h3>
            </div>

            <br/>
            (情况1：登录账号是该项目的创建者)假设在项目ID为1中，登录账号ID是1，项目创建者是1.<br/>
            (情况2：登录账号是该项目的组成员)假设在项目ID为1中，登录账号ID是2，项目创建者是1.<br/>

        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>

<script type="text/javascript">


    $('#searching').hide();
    $('#searchNoResult').hide();
    $('#searchFailed').hide();

    function searchUser(key) {
        key = key.trim();
        if (key != '') {
            $('#searchResultTable').fadeOut();
            $('#searchNoResult').fadeOut();
            $('#searchFailed').fadeOut();
            $('#searching').fadeIn();

            $.get('api/userWithoutProject/' + key, function (data, status) {
                $('#searchResultTable').fadeOut();
                $('#searchNoResult').fadeOut();
                $('#searchFailed').fadeOut();
                $('#searching').fadeOut();
                if (status != 'success') {
                    $('#searchFailed').fadeIn();
                } else if (data.length == 0) {
                    $('#searchNoResult').fadeIn();
                } else {
                    $('#searchResultTable').html('<tbody>');
                    $.each(data, function (index, user) {
                        $('#searchResultTable').append('<tr>' +
                            '<td><img class="user-head mr-2" src="img/avatar/' + user.picture + '.png"/><td>' +
                            '<td>' + user.username.replace(key, '<span class="text-danger font-weight-bold">' + key + '</span>') + '<td>' +
                            '<td>' + user.realname.replace(key, '<span class="text-danger font-weight-bold">' + key + '</span>') + '<td>' +
                            '<td>' + user.email.replace(key, '<span class="text-danger font-weight-bold">' + key + '</span>') + '<td>' +
                            '<td>' + user.phone.replace(key, '<span class="text-danger font-weight-bold">' + key + '</span>') + '<td>' +
                            '</tr>');
                    })
                    $('#searchResultTable').append('</tbody>');
                    $('#searchResultTable').fadeIn();
                }
            });
        }
    }
</script>

</body>
</html>