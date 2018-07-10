<%--简易权限控制--%>
<c:if test="${currentUser == null}">
    <%
        session.setAttribute("warningMessage", "请先登录！");
        response.sendRedirect(basePath + "index");
    %>
</c:if>

<!--导航栏-->
<header class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <div class="navbar-brand">
            <h3 class="mt-1 mb-1">
                <a href="index" style="color:#FFF;text-decoration:none">
                    <i class="fa fa-bug mr-2"></i>BugPass
                </a>
            </h3>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle ${currentProject != null ? 'active' : ''}" href="#"
                       id="navbarDropdown"
                       role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="line-limit-length" style="display:inline-block;max-width:160px;line-height:100%">
                            <c:if test="${currentProject == null}">
                                <i class="fa fa-fw fa-expand mr-1"></i> 选择一个工程项目
                            </c:if>
                            <c:if test="${currentProject != null}">
                                <i class="fa fa-fw ${currentProjectCreator.id == currentUser.id ? 'fa-crown' : 'fa-cube'} mr-2"></i>${currentProject.projectName}
                            </c:if>
                        </span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <c:if test="${projectList.size() > 0}">
                            <c:forEach items="${projectList}" var="proj">
                                <a class="dropdown-item ${proj.id == currentProject.id ? 'active' : ''}"
                                   href="project/switch/${proj.id}">
                                    <i class="fa fa-fw ${proj.creator.id == currentUser.id ? 'fa-crown' : 'fa-cube'} mr-2"></i>${proj.projectName}
                                </a>
                            </c:forEach>
                        </c:if>
                        <c:if test="${projectList.size() == 0}">
                            <span class="dropdown-item-text text-secondary mt-2 mb-2">你还没有加入项目</span>
                        </c:if>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#modal-container-create-project" data-toggle="modal">
                            <i class="fa fa-fw fa-plus mr-2"></i>创建新的项目
                        </a>
                    </div>
                </li>
            </ul>
            <ul class="navbar-nav mr-auto">
                <c:if test="${currentProject != null}">
                    <li class="nav-item">
                        <a class="nav-link ${navItem == 'summary' ? 'active' : ''}" href="project/summary">
                            <i class="far fa-fw fa-file-alt mr-1"></i>概述
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ${navItem == 'problem' ? 'active' : ''}" href="project/problem">
                            <i class="fas fa-fw fa-exclamation-circle mr-1"></i>问题
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ${navItem == 'statistics' ? 'active' : ''}" href="project/statistics">
                            <i class="fas fa-fw fa-chart-line mr-1"></i>统计
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ${navItem == 'member' ? 'active' : ''}" href="member/list">
                            <i class="fas fa-fw fa-users mr-1"></i>成员
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ${navItem == 'setting' ? 'active' : ''}" href="project/info">
                            <i class="fas fa-fw fa-cog mr-1"></i>设置
                        </a>
                    </li>
                </c:if>
            </ul>
            <ul class="navbar-nav">
                <li id="navMessagePill" class="nav-item mr-3">
                    <a class="nav-link" href="javascript:layer.msg('暂无新消息', {icon: 0});">
                        <i class="far fa-fw fa-envelope mr-1"></i>消息
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="userNavbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="padding:0">
                        <img class="user-head" src="img/avatar/${currentUser.picture}.png"/>
                        <span class="ml-1 d-lg-none d-xl-inline">${currentUser.realname == null ? currentUser.username : currentUser.realname}</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userNavbarDropdown">
                        <a class="dropdown-item" href="index">
                            <i class="fa fa-fw fa-home mr-2"></i>返回首页
                        </a>
                        <div class="dropdown-divider"></div>
                        <span class="dropdown-item-text text-secondary d-none d-lg-block d-xl-none">
                            ${currentUser.realname == null ? currentUser.username : currentUser.realname}
                        </span>
                        <a class="dropdown-item" href="user/updateProfile">
                            <i class="fa fa-fw fa-user-edit mr-2"></i>个人资料
                        </a>
                        <a class="dropdown-item" href="user/changePassword">
                            <i class="fa fa-fw fa-key mr-2"></i>修改密码
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="user/logout">
                            <i class="fa fa-fw fa-sign-out-alt mr-2"></i>退出登录
                        </a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</header>

<!--创建工程模态窗口-->
<div class="modal fade" id="modal-container-create-project" role="dialog" aria-hidden="true"
     aria-labelledby="createProjectModalLabel">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="createProjectModalLabel">
                    <i class="far fa-plus-square mr-2"></i>创建新项目
                </h5>
                <button class="close" type="button" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <form class="mb-0" role="form" id="createProjectForm" action="project/create" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="createProjectName">项目名称</label>
                        <input class="form-control" id="createProjectName" name="projectName" type="text"
                               placeholder="输入项目的名称" required/>
                    </div>
                    <div class="form-group">
                        <label for="createProjectDesc">项目描述</label>
                        <textarea class="form-control" id="createProjectDesc" name="projectDesc"
                                  placeholder="输入项目的介绍或描述"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary btn-block" id="btnCreateProject" type="submit">
                        <i class="fa fa-spinner fa-spin mr-2"></i>确认创建
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

<!--邀请列表模态窗口-->
<div class="modal fade" id="modal-container-invitation-list" role="dialog" aria-hidden="true"
     aria-labelledby="invitationListModalLabel">
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="invitationListModalLabel">
                    <i class="fas fa-cubes mr-2"></i>这些项目邀请你加入
                </h5>
                <button class="close" type="button" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <table id="invitationListTable" class="table table-borderless table-hover">
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<!--新建问题按钮-->
<c:if test="${currentProject != null}">
    <style>
        @media (max-width: 1400px) {
            #btnAddProblem {
                position: fixed;
                top: 25%;
                right: -48px;
                width: 96px;
                height: 96px;
                border-radius: 48px 48px 0 0;
                z-index: 9;
                transform: rotate(-90deg);
                transition: all .2s;
            }

            #btnAddProblem:hover {
                right: -32px;
                padding-top: 1em;
            }
        }

        @media (min-width: 1400px) {
            #btnAddProblem {
                position: fixed;
                top: 96px;
                left: calc(50% + 580px);
                transition: all .2s;
            }
        }
    </style>
    <a id="btnAddProblem" class="btn btn-lg btn-success" href="problem/add" data-toggle="tooltip" data-placement="left"
       title="新建问题">
        <i class="fa fa-fw fa-plus"></i>
    </a>
    <!--启用Tooltips-->
    <script type="text/javascript">
        $('[data-toggle="tooltip"]').tooltip();
    </script>
</c:if>

<!--表单效果-->
<script type="text/javascript">
    $(document).ready(function () {
        // 隐藏提交动画
        $('#btnCreateProject i').hide();

        // 提交时显示动画
        $('#createProjectForm').on('submit', function () {
            $('#btnCreateProject i').show();
        });
    });
</script>

<script type="text/javascript">
    var lastInvitationCount = 0;
    var navMessagePill = $('#navMessagePill');

    // 开局先来一波检查
    checkInvitation();

    // 每隔一定时间检查一次
    setInterval(function () {
        checkInvitation();
    }, 5000);

    /**
     * 检查邀请列表
     */
    function checkInvitation() {
        $.ajax({
            url: 'api/member/getInvitationList',
            type: 'GET',
            success: function (data) {
                // 判断是否有邀请
                if (data.length > 0) {
                    // 模态窗口内容更新
                    var invitationListTable = $('#invitationListTable');
                    invitationListTable.html(
                        '<caption>共收到 ' + data.length + ' 个项目邀请</caption>' +
                        '<thead><tr>' +
                        '  <th class="text-center" width="1px"><i class="fa fa-angle-down"></i></th>' +
                        '  <th>创建者</th>' +
                        '  <th>项目</th>' +
                        '  <th>操作</th>' +
                        '</tr></thead>' +
                        '<tbody>');
                    $.each(data, function (index, proj) {
                        invitationListTable.append(
                            '<tr>' +
                            '<td><img class="user-head mr-2" src="img/avatar/' + proj.creator.picture + '.png"/></td>' +
                            '<td>' + proj.creator.realname +
                            '  <span class="text-secondary">(' + proj.creator.username + ')</span><br>' +
                            '  <span class="text-secondary">' + proj.creator.email + '</span>' +
                            '</td>' +
                            '<td>' + proj.projectName + '<br>' +
                            '  <span class="text-secondary">' + proj.projectDesc + '</span><br>' +
                            '</td>' +
                            '<td class="line-limit-length">' +
                            '  <a class="btn btn-info" href="member/acceptInvitation/' + proj.id + '">加入</a>' +
                            '  <a class="btn btn-outline-secondary" href="javascript:void(0)" onclick="refuseInvitation()">拒绝</a>' +
                            '</td>' +
                            '</tr>');
                    });
                    invitationListTable.append('</tbody>');

                    // 若消息数量有变化
                    if (data.length != lastInvitationCount) {
                        // 导航栏提示更新
                        navMessagePill.fadeOut(500, function () {
                            navMessagePill.html(
                                '<a class="nav-link active" href="#modal-container-invitation-list" data-toggle="modal">' +
                                '  <span class="badge badge-pill badge-danger ">' + data.length + '</span>' +
                                '  <span class="anim-flick">新消息</span>' +
                                '</a>');
                            navMessagePill.fadeIn(500);
                        });

                        // 记录消息数量
                        lastInvitationCount = data.length;
                    }
                } else {
                    // 若消息数量有变化
                    if (data.length != lastInvitationCount) {
                        // 隐藏邀请列表模态框
                        $('#modal-container-invitation-list').modal('hide');

                        // 导航栏提示更新
                        navMessagePill.fadeOut(500, function () {
                            navMessagePill.html(
                                '<a class="nav-link" href="javascript:layer.msg(\'暂无新消息\', {icon: 0});">' +
                                '  <i class="far fa-fw fa-envelope mr-1"></i>消息' +
                                '</a>');
                            navMessagePill.fadeIn(500);
                        });

                        // 记录消息数量
                        lastInvitationCount = data.length;
                    }
                }
            }
        });
    }

    /**
     * 拒绝邀请
     */
    function refuseInvitation() {
        layer.msg('人家好心邀请你，你居然想拒绝？<br>不开心……', {icon: 5});
    }
</script>
