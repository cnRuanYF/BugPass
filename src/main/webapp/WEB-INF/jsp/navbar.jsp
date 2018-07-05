<!--导航栏-->
<header class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
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
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                       role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <c:if test="${currentProject == null}">
                            <i class="fa fa-fw fa-expand mr-2"></i> 选择一个工程项目
                        </c:if>
                        <c:if test="${currentProject != null}">
                            <i class="fa fa-fw fa-project-diagram mr-2"></i>${currentProject.peojectName}
                        </c:if>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <c:if test="${projectList != null}">
                            <c:forEach items="${projectList}" var="proj">
                                <a class="dropdown-item ${proj.projectId == currentProject.projectId ? 'active' : ''}"
                                   href="project/chooseProject/${proj.projectID}">
                                    <i class="fa fa-fw fa-project-diagram mr-2"></i>${proj.projectName}
                                </a>
                            </c:forEach>
                            <div class="dropdown-divider"></div>
                        </c:if>
                        <a class="dropdown-item" href="#">
                            <i class="fa fa-fw fa-plus mr-2"></i>创建／加入工程项目
                        </a>
                    </div>
                </li>
            </ul>
            <ul class="navbar-nav mr-auto">
                <c:if test="${currentProject != null}">
                    <li class="nav-item"><a class="nav-link" href="project/summary">
                        <i class="fa fa-file-alt mr-2"></i>概述</a>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="project/problemList">
                        <i class="fa fa-bug mr-2"></i>问题</a>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="project/statistics">
                        <i class="fa fa-chart-line mr-2"></i>统计</a>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="project/settings">
                        <i class="fa fa-sliders-h mr-2"></i>设置</a>
                    </li>
                </c:if>
            </ul>
            <ul class="navbar-nav mr-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="userNavbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="padding:0">
                        <img class="mr-2" src="../../img/avatar/${currentUser.picture}.png"
                             style="width:40px;height:40px;border-radius:100%"/>
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

