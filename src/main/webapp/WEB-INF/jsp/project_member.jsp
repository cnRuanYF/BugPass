<%@ include file="common_params.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>项目成员 - BugPass</title>

    <%@ include file="common_head.jsp" %>

</head>

<body>

<% request.setAttribute("navItem", "member"); %>
<%@ include file="navbar.jsp" %>

<div class="container">
    <div class="row">

        <%--侧边栏--%>
        <% request.setAttribute("sideNavItem", "member"); %>
        <%@ include file="project_sidenav.jsp" %>

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
                        <c:if test="${currentProject.creator.id == currentUser.id}">
                            <th width="1px">操作</th>
                        </c:if>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${memberList}" var="member">
                        <tr>
                            <td class="align-middle">
                                <img class="user-head mr-2" src="img/avatar/${member.user.picture}.png"/>
                            </td>
                            <td class="align-middle">
                                <span>${member.user.realname}</span>
                                <span class="text-secondary">(${member.user.username})</span>
                            </td>
                            <td class="align-middle">
                                <c:if test="${member.user.phone != null}">
                                    <button class="btn btn-sm btn-outline-success mr-1" data-toggle="tooltip"
                                            title="手机号: ${member.user.phone}" style="">
                                        <i class="fa fa-fw fa-phone"></i>
                                    </button>
                                </c:if>
                                <c:if test="${member.user.email != null}">
                                    <button class="btn btn-sm btn-outline-info mr-1" data-toggle="tooltip"
                                            title="邮箱: ${member.user.email}">
                                        <i class="fa fa-fw fa-at"></i>
                                    </button>
                                </c:if>
                                <c:if test="${member.user.qq != null}">
                                    <button class="btn btn-sm btn-outline-primary" data-toggle="tooltip"
                                            title="QQ: ${member.user.qq}">
                                        <i class="fab fa-fw fa-qq"></i>
                                    </button>
                                </c:if>
                            </td>
                            <td class="align-middle">${member.memberRole == 1 ? "创建者" : "成员"}</td>
                            <c:if test="${currentProject.creator.id == currentUser.id}">
                                <td class="align-middle">
                                    <c:if test="${member.memberRole == 1}">
                                        <button class="btn btn-sm btn-outline-secondary disabled")">移除</button>
                                    </c:if>
                                    <c:if test="${member.memberRole != 1}">
                                        <button class="btn btn-sm btn-outline-danger"
                                                onclick="removeMember(this, '移除', ${member.user.id})">
                                            移除
                                        </button>
                                    </c:if>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <%--待确认列表--%>
            <div id="unconfirmListDiv" class="card card-body mt-3">
                <h5 class="mb-4">待确认</h5>
                <table class="table table-borderless table-hover">
                    <thead>
                    <tr>
                        <th class="text-center" width="1px"><i class="fa fa-angle-down"></i></th>
                        <th>用户</th>
                        <th>邮箱</th>
                        <th>手机</th>
                        <c:if test="${currentProject.creator.id == currentUser.id}">
                            <th width="1px">操作</th>
                        </c:if>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${unconfirmList}" var="member">
                        <tr>
                            <td class="align-middle">
                                <img class="user-head mr-2" src="img/avatar/${member.user.picture}.png"/>
                            </td>
                            <td class="align-middle">
                                <span>${member.user.realname}</span>
                                <span class="text-secondary">(${member.user.username})</span>
                            </td>
                            <td class="align-middle">${member.user.email}</td>
                            <td class="align-middle">${member.user.phone}</td>
                            <c:if test="${currentProject.creator.id == currentUser.id}">
                                <td class="align-middle">
                                    <button class="btn btn-sm btn-outline-warning"
                                            onclick="removeMember(this, '取消邀请', ${member.user.id})">
                                        取消邀请
                                    </button>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <%--添加成员--%>
            <c:if test="${currentProject.creator.id == currentUser.id}">
                <div class="card card-body mt-3">
                    <h5 class="mb-4">添加成员</h5>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-search"></i></span>
                        </div>
                        <input type="text" class="form-control" id="searchKeyword" placeholder="输入关键字"
                               oninput="searchUser(this.value)">
                    </div>
                    <table id="searchResultTable"
                           class="table table-borderless table-hover ml-auto mr-auto align-self-center">
                    </table>
                    <h3 id="searchingTip" class="align-self-center text-info mt-3 mb-3">
                        <i class="fa fa-circle-notch fa-spin mr-3"></i>Searching...
                    </h3>
                    <h3 id="searchNoResultTip" class="align-self-center text-secondary mt-3 mb-3">
                        <i class="far fa-frown mr-3"></i>No result.
                    </h3>
                    <h3 id="searchFailedTip" class="align-self-center text-warning mt-3 mb-3">
                        <i class="fa fa-exclamation-circle mr-3"></i>出现错误，请稍后再试
                    </h3>
                </div>
            </c:if>
        </div>
    </div>
</div>

<%@ include file="common_footer.jsp" %>

<script type="text/javascript">

    // 待确认列表用户数
    var unconfirmCount = ${unconfirmList.size()};
    if (unconfirmCount == 0) {
        $('#unconfirmListDiv').hide();
    }

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

    /**
     * 搜索用户 (关键字)
     */
    function searchUser(key) {
        // 关键字不为空&&与上次不同才触发搜索（避免多次输入空格）
        key = key.trim();
        if (key !== '' && key !== lastSearchKey) {
            lastSearchKey = key;

            // 显示正在搜索提示
            searchResultTable.hide(200);
            searchNoResultTip.hide(200);
            searchFailedTip.hide(200);
            searchingTip.show(200);

            // 清除上次定时任务重新延时1秒（避免每次输入频繁请求）
            if (delayTimer !== undefined) {
                clearTimeout(delayTimer);
            }
            delayTimer = setTimeout(function () {
                $.ajax({
                    url: 'api/member/searchUserWithoutProjectMemberByKeyword/' + key,
                    type: 'GET',
                    dataType: 'json',
                    timeout: 5000,
                    // 请求成功的回调
                    success: function (data) {
                        // 先隐藏所有提示
                        searchResultTable.hide(200);
                        searchNoResultTip.hide(200);
                        searchFailedTip.hide(200);
                        searchingTip.hide(200);

                        // 判断有无结果
                        if (data.length === 0) {
                            searchNoResultTip.show(200);
                        } else {
                            searchResultTable.html('<caption>找到 ' + data.length + ' 个用户</caption>' +
                                '<thead><tr>' +
                                '<th class="text-center" width="1px"><i class="fa fa-angle-down"></i></th>' +
                                '<th>用户</th>' +
                                '<th>邮箱</th>' +
                                '<th>手机</th>' +
                                '<th width="1px">操作</th>' +
                                '</tr></thead>' +
                                '<tbody>');
                            $.each(data, function (index, user) {
                                searchResultTable.append('<tr>' +
                                    '<td class="align-middle"><img class="user-head mr-2" src="img/avatar/' + user.picture + '.png"/></td>' +
                                    '<td class="align-middle">' + markKeyword(user.realname, key) +
                                    '    <span class="text-secondary">(' + markKeyword(user.username, key) + ')</span>' +
                                    '</td>' +
                                    '<td class="align-middle">' + markKeyword(user.email, key) + '</td>' +
                                    '<td class="align-middle">' + markKeyword(user.phone, key) + '</td>' +
                                    '<td class="align-middle"><a class="btn btn-outline-success btn-sm" href="javascript:void(0)" onclick="inviteUser(this, ' + user.id + ')">发送邀请</a></td>' +
                                    '</tr>');
                            });
                            searchResultTable.append('</tbody>');
                            searchResultTable.show(200);
                        }
                    },
                    // 请求错误的回调：显示错误提示
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

    /**
     * 将关键字标红返回（用于搜索结果展示）
     */
    function markKeyword(input, key) {
        if (input !== null) {
            return input
                .replace(key, '<span class="text-danger font-weight-bold">' + key + '</span>');
        }
        return '--';
    }

    /**
     * 将标红的关键字复原（用于邀请成功后元素转移）
     */
    function unmarkKeyword(input) {
        return input
            .replace('<span class="text-danger font-weight-bold">', '')
            .replace('</span>', '');
    }

    /**
     * 邀请用户 (按钮元素, 用户ID)
     */
    function inviteUser(e, uid) {
        $.ajax({
            url: 'api/member/invite/' + uid,
            type: 'GET',
            timeout: 5000,
            success: function (data) {
                if (data !== 'success') {
                    layer.msg(data, {icon: 2});
                } else {
                    // 获取表格行元素&转移目标元素
                    var tableRow = $(e.parentNode.parentNode);
                    $(e.parentNode).html('<button class="btn btn-sm btn-outline-warning" onclick="removeMember(this, \'取消邀请\', ' + uid + ')">取消邀请</button>');
                    var lastUnconfirmTableBody = $('#unconfirmListDiv > table > tbody');

                    // 表格行转移
                    tableRow.hide(500, function () {
                        tableRow.html(unmarkKeyword(unmarkKeyword(unmarkKeyword(unmarkKeyword(tableRow.html())))));
                        lastUnconfirmTableBody.append(tableRow);
                        tableRow.show(500);
                        // 源表为空则隐藏
                        if ($('#searchResultTable > tbody > tr').length === 0) {
                            $('#searchResultTable').hide(200);
                        }
                    });

                    // 待确认表格显示
                    unconfirmCount++;
                    $('#unconfirmListDiv').show(200);

                    layer.msg('邀请成功', {icon: 1});
                }
            },
            error: function () {
                layer.msg('操作失败，请稍后重试', {icon: 2});
            }
        });
    }

    /**
     * 移除用户 (按钮元素, 操作类型, 用户ID)
     */
    function removeMember(e, op, uid) {
        // 获取表格行元素
        var tableRow = $(e.parentNode.parentNode);
        var imgHtml = tableRow.find('td:eq(0)').html();
        var userHtml = tableRow.find('td:eq(1)').html();

        // 确认删除的提示
        layer.open({
            title: false,
            content: '真的要' + op + '这个用户吗？<br><br>' + imgHtml + userHtml,
            shadeClose: true,
            closeBtn: false,
            btn: ['确定', '取消'],

            // 弹窗成功时改变按钮样式（解决Bootstrap样式冲突）
            success: function () {
                $('.layui-layer-btn > .layui-layer-btn0').css('color', '#FFF');
            },

            // 点击确定按钮时执行
            yes: function () {
                $.ajax({
                    url: op === '移除' ? 'api/member/remove/' + uid : 'api/member/cancelInvitation/' + uid,
                    type: 'GET',
                    timeout: 5000,
                    success: function (data) {
                        if (data !== 'success') {
                            layer.msg(data, {icon: 2});
                        } else {
                            // 移除表格行元素
                            tableRow.hide(500);

                            // 如果操作是取消邀请&待确认列表为空则隐藏
                            if (op !== '移除') {
                                unconfirmCount--;
                                if (unconfirmCount === 0) {
                                    $('#unconfirmListDiv').hide(500);
                                }
                            }

                            layer.msg(op + '成功', {icon: 1});
                        }
                    },
                    error: function () {
                        layer.msg('操作失败，请稍后重试', {icon: 2});
                    }
                });
            }
        });
    }
</script>

</body>
</html>