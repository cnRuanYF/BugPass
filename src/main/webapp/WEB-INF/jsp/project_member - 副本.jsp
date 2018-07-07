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
                        <th class="text-center" width="1px"><i class="fa fa-angle-down"></i></th>
                        <th>用户</th>
                        <th>联系方式</th>
                        <th>角色</th>
                        <th width="1px">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${memberList}" var="member">
                        <tr>
                            <td>
                                <img class="user-head mr-2" src="img/avatar/${member.user.picture}.png"/>
                            </td>
                            <td>
                                <span>${member.user.realname}</span>
                                <span class="text-secondary">(${member.user.username})</span>
                            </td>
                            <td>
                                <c:if test="${member.user.phone != null}">
                                    <button class="btn btn-sm btn-outline-success mr-1" data-toggle="tooltip"
                                            title="手机号: ${member.user.phone}" style="">
                                        <i class="fa fa-phone"></i>
                                    </button>
                                </c:if>
                                <c:if test="${member.user.email != null}">
                                    <button class="btn btn-sm btn-outline-info mr-1" data-toggle="tooltip"
                                            title="邮箱: ${member.user.email}">
                                        <i class="fa fa-at"></i>
                                    </button>
                                </c:if>
                                <c:if test="${member.user.qq != null}">
                                    <button class="btn btn-sm btn-outline-primary" data-toggle="tooltip"
                                            title="QQ: ${member.user.qq}">
                                        <i class="fab fa-qq"></i>
                                    </button>
                                </c:if>
                            </td>
                            <td>${member.memberRole == 1 ? "创建者" : "成员"}</td>
                            <td>
                                <c:if test="${member.memberRole == 1}">
                                    <a class="btn btn-sm btn-outline-secondary disabled">移除</a>
                                </c:if>
                                <c:if test="${member.memberRole != 1}">
                                    <button class="btn btn-sm btn-outline-danger"
                                            onclick="removeMember(this, '移除', ${member.user.id})">
                                        移除
                                    </button>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <%--待确认列表--%>
            <c:if test="${unconfirmList.size() > 0}">
                <div id="unconfirmListDiv" class="card card-body mt-3">
                    <h5 class="mb-4">待确认</h5>
                    <table class="table table-borderless table-hover">
                        <thead>
                        <tr>
                            <th class="text-center" width="1px"><i class="fa fa-angle-down"></i></th>
                            <th>用户</th>
                            <th>邮箱</th>
                            <th>手机</th>
                            <th width="1px">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${unconfirmList}" var="member">
                            <tr>
                                <td>
                                    <img class="user-head mr-2" src="img/avatar/${member.user.picture}.png"/>
                                </td>
                                <td>
                                    <span>${member.user.realname}</span>
                                    <span class="text-secondary">(${member.user.username})</span>
                                </td>
                                <td>${member.user.email}</td>
                                <td>${member.user.phone}</td>
                                <td>
                                    <button class="btn btn-sm btn-outline-secondary"
                                            onclick="removeMember(this, '取消邀请', ${member.user.id})">
                                        取消邀请
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>

            <%--添加成员--%>
            <div class="card card-body mt-3">
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
                <h1 id="searchingTip" class="text-center text-info mt-3 mb-3">
                    <i class="fa fa-circle-notch fa-spin mr-3"></i>Searching...
                </h1>
                <h3 id="searchNoResultTip" class="text-center text-secondary mt-3 mb-3">
                    <i class="far fa-frown mr-3"></i>No result.
                </h3>
                <h3 id="searchFailedTip" class="text-center text-warning mt-3 mb-3">
                    <i class="fa fa-exclamation-circle mr-3"></i>出现错误，请稍后再试
                </h3>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>

<script type="text/javascript">
    // 待确认列表总数
    var unconfirmCount = ${unconfirmList.size()};

    // 激活页面中的Tooltip
    $(function () {
        $("[data-toggle='tooltip']").tooltip();
    });

    /*
     * 用户搜索相关
     */
    var searchingTip = $('#searchingTip'),
        searchNoResultTip = $('#searchNoResultTip'),
        searchFailedTip = $('#searchFailedTip'),
        searchResultTable = $('#searchResultTable');

    searchingTip.hide();
    searchNoResultTip.hide();
    searchFailedTip.hide();
    searchResultTable.hide();

    var delayTimer;
    var lastSearchKey;

    function searchUser(key) {
        key = key.trim();
        if (key !== '' && key !== lastSearchKey) {
            lastSearchKey = key;

            searchResultTable.hide(200);
            searchNoResultTip.hide(200);
            searchFailedTip.hide(200);
            searchingTip.show(200);

            if (delayTimer !== undefined) {
                clearTimeout(delayTimer);
            }
            delayTimer = setTimeout(function () {
                $.ajax({
                    url: 'api/searchUser/' + key,
                    type: 'GET',
                    dataType: 'json',
                    timeout: 5000,
                    success: function (data) {
                        searchResultTable.hide(200);
                        searchNoResultTip.hide(200);
                        searchFailedTip.hide(200);
                        searchingTip.hide(200);

                        if (data.length === 0) {
                            searchNoResultTip.show(200);
                        } else {
                            searchResultTable.html('<thead><tr>' +
                                '<th class="text-center" width="1px"><i class="fa fa-angle-down"></i></th>' +
                                '<th>用户</th>' +
                                '<th>邮箱</th>' +
                                '<th>手机</th>' +
                                '<th width="1px">操作</th>' +
                                '</tr></thead>' +
                                '<tbody>');
                            $.each(data, function (index, user) {
                                searchResultTable.append('<tr>' +
                                    '<td><img class="user-head mr-2" src="img/avatar/' + user.picture + '.png"/></td>' +
                                    '<td>' + markKeyword(user.realname, key) +
                                    '    <span class="text-secondary">(' + markKeyword(user.username, key) + ')</span>' +
                                    '</td>' +
                                    '<td>' + markKeyword(user.email, key) + '</td>' +
                                    '<td>' + markKeyword(user.phone, key) + '</td>' +
                                    '<td><a id="btnInvite' + user.id + '" class="btn btn-outline-success btn-sm" href="javascript:void(0)" onclick="inviteUser(' + user.id + ')">发送邀请</a></td>' +
                                    '</tr>');
                            });
                            searchResultTable.append('</tbody>');
                            searchResultTable.show(200);
                        }
                    },
                    error: function () {
                        searchResultTable.hide(200);
                        searchNoResultTip.hide(200);
                        searchingTip.hide(200);
                        searchFailedTip.show(200);
                    }
                });

            }, 1000);
        }
    }

    function markKeyword(input, key) {
        if (input !== null) {
            return input.replace(key,
                '<span class="text-danger font-weight-bold">' + key + '</span>');
        }
        return '-';
    }

    /*
     * 邀请用户
     */
    function inviteUser(uid) {
        // $.ajax({
        //     url: 'api/inviteUser/' + uid,
        //     type: 'GET',
        //     dataType: 'json',
        //     timeout: 5000,
        //     success: function (data) {
        //     },
        //     error: function () {
        //     }
        // });

    }

    /*
     * 移除用户
     */
    function removeMember(e, op, uid) {
        // getElements
        var tableRow = $(e.parentNode.parentNode);
        var imgHtml = tableRow.find('td:eq(0)').html();
        var userHtml = tableRow.find('td:eq(1)').html();
        console.log(imgHtml);
        console.log(userHtml);

        layer.confirm(null, {
                title: '真的要' + op + '这个用户吗',
                content: imgHtml + userHtml,
                btn: ['确定', '取消'],
                shadeClose: true
            },
            function () {
                layer.msg(op + '成功', {icon: 1});
                tableRow.hide(500);
                if (op != '移除') {
                    unconfirmCount--;
                    if (unconfirmCount == 0) {
                        $('#unconfirmListDiv').hide(500);
                    }
                }
            }, null);
    }
</script>

</body>
</html>