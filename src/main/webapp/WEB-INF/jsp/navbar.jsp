<%-- 简易权限控制 --%>
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
                <i class="fa fa-bug mr-2"></i>BugPass
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
                        <c:if test="${currentProject == null}">
                            <i class="fa fa-fw fa-expand mr-2"></i> 选择一个工程项目
                        </c:if>
                        <c:if test="${currentProject != null}">
                            <i class="fa fa-fw ${currentProjectCreator.id == currentUser.id ? 'fa-crown' : 'fa-cube'} mr-2"></i>${currentProject.projectName}
                        </c:if>
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
                            <i class="fa fa-file-alt mr-2"></i>概述
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ${navItem == 'problem' ? 'active' : ''}" href="project/problemList">
                            <i class="fa fa-bug mr-2"></i>问题
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ${navItem == 'statistics' ? 'active' : ''}" href="project/statistics">
                            <i class="fa fa-chart-line mr-2"></i>统计
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link ${navItem == 'setting' ? 'active' : ''}" href="project/info">
                            <i class="fa fa-sliders-h mr-2"></i>设置
                        </a>
                    </li>
                </c:if>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item mr-3">
                    <a class="nav-link"  href="#modal-container-invitation-list" data-toggle="modal">
                        <span class="badge badge-pill badge-danger mr-1">6</span>有新消息
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="userNavbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="padding:0">
                        <img class="user-head mr-2" src="img/avatar/${currentUser.picture}.png"/>
                        ${currentUser.realname == null ? currentUser.username : currentUser.realname}
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userNavbarDropdown">
                        <a class="dropdown-item" href="index">
                            <i class="fa fa-fw fa-home mr-2"></i>返回首页
                        </a>
                        <div class="dropdown-divider"></div>
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

<!-- 创建工程模态窗口 -->
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

<!-- 邀请列表模态窗口 -->
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
        </div>
    </div>
</div>

<!-- 表单效果 -->
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
    // 开局先来一波检查
    setTimeout(function () {
        checkInvitation();
    },3000);

    // 每隔一定时间检查一次
    setInterval(function () {
        checkInvitation();
    }, 10000);

    /**
     * 检查邀请列表
     */
    function checkInvitation() {
        $.ajax({
            url: 'api/member/getInvitationList',
            type: 'GET',
            success: function (data) {
                console.log(data)
                if (data.length > 0) {
                    var invitationListTable = $('#invitationListTable');
                    invitationListTable.html('<caption>共收到 ' + data.length + ' 个项目邀请</caption>' +
                        '<thead><tr>' +
                        '<th class="text-center" width="1px"><i class="fa fa-angle-down"></i></th>' +
                        '<th>创建者</th>' +
                        '<th>工程名</th>' +
                        '<th width="1px">操作</th>' +
                        '</tr></thead>' +
                        '<tbody>');
                    $.each(data, function (index, proj) {
                        invitationListTable.append('<tr>' +
                            '<td class="align-middle"><img class="user-head mr-2" src="img/avatar/' + proj.creator.picture + '.png"/></td>' +
                            '<td class="align-middle">' + proj.creator.realname +
                            '    <span class="text-secondary">(' + proj.creator.username + ')</span>' +
                            '</td>' +
                            '<td class="align-middle">' + proj.projectName + '</td>' +
                            '<td class="align-middle"><a class="btn btn-info" href="member/acceptInvitation/' + proj.id + '">加入</a></td>' +
                            '</tr>');
                    });
                    invitationListTable.append('</tbody>');
                } else {

                }
            }
        });
    }
</script>
