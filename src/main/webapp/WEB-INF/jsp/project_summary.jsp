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
            var day = date.getDate();
            $('#currentDate').text(year + '年' + month + '月' + day + '日');
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

        <!--主区域-->
        <div class="col-md-8">

            <!--项目统计-->
            <div class="row">
                <div class="col-6 col-lg-3 mb-4">
                    <a class="card border-0" href="selectAll?publisher=${publisher}" style="text-decoration:none">
                        <div class="btn btn-primary p-0">
                            <div class="card-body">
                                <h1 class="mb-0">${openedProblem}</h1>
                            </div>
                            <div class="card-footer">打开</div>
                        </div>
                    </a>
                </div>
                <div class="col-6 col-lg-3 mb-4">
                    <a class="card border-0" href="problem/list" style="text-decoration:none">
                        <div class="btn btn-danger p-0">
                            <div class="card-body">
                                <h1 class="mb-0">${newProblem}</h1>
                            </div>
                            <div class="card-footer">新问题</div>
                        </div>
                    </a>
                </div>
                <div class="col-6 col-lg-3 mb-4">
                    <a class="card border-0" href="problem/list" style="text-decoration:none">
                        <div class="btn btn-info p-0">
                            <div class="card-body">
                                <h1 class="mb-0">${doingProblem}</h1>
                            </div>
                            <div class="card-footer">进行中</div>
                        </div>
                    </a>
                </div>
                <div class="col-6 col-lg-3 mb-4">
                    <a class="card border-0" href="problem/list" style="text-decoration:none">
                        <div class="btn btn-success p-0">
                            <div class="card-body">
                                <h1 class="mb-0">${resolvedProblem}</h1>
                            </div>
                            <div class="card-footer">已解决</div>
                        </div>
                    </a>
                </div>
            </div>

            <!--个人统计-->
            <div class="card mb-4">
                <!--Tab标签-->
                <div class="card-header">
                    <ul class="nav nav-tabs card-header-tabs">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="tab" href="#my-assign-content" role="tab"
                               aria-controls="my-assign-content" aria-selected="true">指派给我的</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#my-submit-content" role="tab"
                               aria-controls="my-submit-content" aria-selected="false">我提交的</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#my-track-content" role="tab"
                               aria-controls="my-track-content" aria-selected="false">我跟踪的</a>
                        </li>
                    </ul>
                </div>
                <div class="card-body">
                    <div class="tab-content">
                        <!--指派给我的-->
                        <div class="tab-pane fade show active" id="my-assign-content" role="tabpanel">
                            <div class="row">
                                <div class="col-6 col-lg-3 mb-4">
                                    <a href="problem/list" style="text-decoration:none">
                                        <div class="card border-0">
                                            <div class="card-body btn btn-outline-primary p-2">
                                                <h1 class="mb-0">${openedProblemToMe}</h1>
                                                打开
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-6 col-lg-3 mb-4">
                                    <a href="problem/list" style="text-decoration:none">
                                        <div class="card border-0">
                                            <div class="card-body btn btn-outline-danger p-2">
                                                <h1 class="mb-0">${newProblemToMe}</h1>
                                                新问题
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-6 col-lg-3 mb-4">
                                    <a href="problem/list" style="text-decoration:none">
                                        <div class="card border-0">
                                            <div class="card-body btn btn-outline-info p-2">
                                                <h1 class="mb-0">${doingProblemToMe}</h1>
                                                进行中
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-6 col-lg-3 mb-4">
                                    <a href="problem/list" style="text-decoration:none">
                                        <div class="card border-0">
                                            <div class="card-body btn btn-outline-success p-2">
                                                <h1 class="mb-0">${resolvedProblemToMe}</h1>
                                                已解决
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </div>
                            <c:if test="${problemToMeList == null || problemToMeList.size() == 0}">
                                <h1 class="text-secondary text-center mt-5 mb-5">
                                    <i class="fa fa-exclamation-circle mr-3"></i>暂时没有任务指派给你
                                </h1>
                            </c:if>
                            <c:if test="${problemToMeList != null && problemToMeList.size() > 0}">
                                <h5>最近指派给我的
                                    <a class="small float-right" href="problem/list"
                                       style="text-decoration:none">
                                        <i class="far fa-eye mr-1"></i>查看全部
                                    </a>
                                </h5>
                                <div class="dropdown-divider"></div>
                                <div class="list-group list-group-flush">
                                    <c:forEach items="${problemToMeList}" var="prob">
                                        <a class="list-group-item list-group-item-action border-0"
                                           href="problem/${prob.id}">
                                                ${prob.problemTitle}
                                            <small class="float-right"><fmt:formatDate value="${prob.updateTime}" pattern="yyyy年M月d日 H:mm"/></small>
                                        </a>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </div>
                        <!--我提交的-->
                        <div class="tab-pane fade" id="my-submit-content" role="tabpanel">
                            <div class="row">
                                <div class="col-6 col-lg-3 mb-4">
                                    <a href="problem/list" style="text-decoration:none">
                                        <div class="card border-0">
                                            <div class="card-body btn btn-outline-primary p-2">
                                                <h1 class="mb-0">${openedProblemFromMe}</h1>
                                                打开
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-6 col-lg-3 mb-4">
                                    <a href="problem/list" style="text-decoration:none">
                                        <div class="card border-0">
                                            <div class="card-body btn btn-outline-danger p-2">
                                                <h1 class="mb-0">${newProblemFromMe}</h1>
                                                新问题
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-6 col-lg-3 mb-4">
                                    <a href="problem/list" style="text-decoration:none">
                                        <div class="card border-0">
                                            <div class="card-body btn btn-outline-info p-2">
                                                <h1 class="mb-0">${doingProblemFromMe}</h1>
                                                进行中
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-6 col-lg-3 mb-4">
                                    <a href="problem/list" style="text-decoration:none">
                                        <div class="card border-0">
                                            <div class="card-body btn btn-outline-success p-2">
                                                <h1 class="mb-0">${resolvedProblemFromMe}</h1>
                                                已解决
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </div>

                            <c:if test="${problemFromMeList == null || problemFromMeList.size() == 0}">
                                <h1 class="text-secondary text-center mt-5 mb-5">
                                    <i class="fa fa-exclamation-circle mr-3"></i>暂时没有提交的问题
                                </h1>
                            </c:if>

                            <c:if test="${problemFromMeList != null && problemFromMeList.size() > 0}">
                            <h5>最近提交的
                                <a class="small float-right" href="problem/list"
                                   style="text-decoration:none">
                                    <i class="far fa-eye mr-1"></i>查看全部
                                </a>
                            </h5>
                            <div class="dropdown-divider"></div>
                            <div class="list-group list-group-flush">
                                <c:forEach items="${problemFromMeList}" var="prob">
                                    <a class="list-group-item list-group-item-action border-0"
                                       href="problem/${prob.id}">
                                            ${prob.problemTitle}
                                        <small class="float-right"><fmt:formatDate value="${prob.updateTime}" pattern="yyyy年M月d日 H:mm"/></small>
                                    </a>
                                </c:forEach>
                            </div>
                            </c:if>
                        </div>

                        <!--我跟踪的-->
                        <div class="tab-pane fade" id="my-track-content" role="tabpanel">
                            <h1 class="mt-5 mb-5 text-secondary text-center">
                                <i class="fa fa-snowflake fa-spin mr-3"></i>功能正在开花中
                            </h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--侧边栏-->
        <div class="col-md-4">
            <!--时间-->
            <div class="card bg-light text-center mb-4">
                <div class="card-header" id="currentDate"></div>
                <div class="card-body">
                    <h1 class="mb-0" id="currentTime">0:00:00</h1>
                </div>
            </div>
            <!--项目信息-->
            <div class="card card-body">
                <h5 class="mb-3">
                    项目信息
                    <c:if test="${currentProject.creator.id == currentUser.id}">
                        <a class="btn p-1 btn-outline-secondary border-0 float-right" href="project/info">
                            <i class="fa fa-fw fa-pencil-alt"></i>
                        </a>
                    </c:if>
                </h5>
                <div class="form-group">
                    <label class="small text-secondary">项目ID</label>
                    <input type="text" class="form-control-plaintext" value="${currentProject.displayId}" readonly>
                </div>
                <div class="form-group">
                    <label class="small text-secondary">项目名称</label>
                    <input type="text" class="form-control-plaintext" value="${currentProject.projectName}" readonly>
                </div>
                <div class="form-group">
                    <label class="small text-secondary">项目描述</label>
                    <input type="text" class="form-control-plaintext"
                           value="${currentProject.projectDesc == '' ? '（暂无）' : currentProject.projectDesc}" readonly>
                </div>
                <div class="form-group">
                    <label class="small text-secondary">创建时间</label>
                    <input type="text" class="form-control-plaintext"
                           value="<fmt:formatDate value="${currentProject.createTime}" pattern="yyyy年M月d日 H:mm"/>"
                           readonly>
                </div>
                <div class="form-group">
                    <label class="small text-secondary">创建人</label>
                    <div>
                        <img class="user-head mr-2" src="img/avatar/${currentProjectCreator.picture}.png"/>
                        ${currentProjectCreator.realname == null ? currentProjectCreator.username : currentProjectCreator.realname}
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<%@ include file="common_footer.jsp" %>

</body>
</html>
