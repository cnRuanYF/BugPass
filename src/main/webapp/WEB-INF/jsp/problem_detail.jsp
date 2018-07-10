<%@ page import="java.util.Date" %>
<%@ include file="common_params.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>问题详情 - BugPass</title>

    <%@ include file="common_head.jsp" %>

</head>

<body>

<% request.setAttribute("navItem", "problem"); %>
<%@ include file="navbar.jsp" %>

<div class="container">

    <!--问题详情-->
    <div class="card card-body mb-4">
        <h5 class="mb-4">
            问题详情
            <a class="float-right small" href="problem" style="text-decoration:none">
                <i class="fa fa-chevron-left mr-2"></i>返回问题列表
            </a>
        </h5>
        <div class="form-group row">
            <label class="col-md-3 col-form-label text-md-right">发布者</label>
            <div class="col-md-9">
                <img class="user-head mr-2" src="img/avatar/${publisher.picture}.png"/>
                ${publisher.realname}
                <small>(${publisher.username})</small>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-md-3 col-form-label text-md-right">问题类型</label>
            <div class="col-md-3">
                <input class="form-control" type="text" value="${problemType.problemTypeName}" readonly>
            </div>
            <label class="col-md-2 col-form-label text-md-right">重要级别</label>
            <div class="col-md-3">
                <button type="button" id="btnLevel${problemLevel.problemLevelId}"
                        disabled>${problemLevel.problemLevelName}</button>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-md-3 col-form-label text-md-right">所属模块</label>
            <div class="col-md-3">
                <input class="form-control" type="text" value="${module.moduleName == null ?  '（未指定）' : module.moduleName}" readonly>
            </div>
            <label class="col-md-2 col-form-label text-md-right">所属版本</label>
            <div class="col-md-4 col-lg-3">
                <input class="form-control" type="text" value="${version.versionName == null ?  '（未指定）' : version.versionName}" readonly>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-md-3 col-form-label text-md-right">问题标题</label>
            <div class="col-md-9 col-lg-8">
                <input class="form-control" type="text" value="${problem.problemTitle}" readonly>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-md-3 col-form-label text-md-right">问题描述</label>
            <div class="col-md-9 col-lg-8">
                <textarea class="form-control" style="min-height:160px"
                          readonly>${problem.problemDesc}</textarea>
            </div>
        </div>
        <input type="hidden" id="assignedTo" name="assignedTo" value="${problem.assignedTo}">
        <div class="form-group row">
            <label class="col-md-3 col-form-label text-md-right">指派给</label>
            <div class="col-md-6">
                <button id="btnChooseAssignUser" type="button" class="btn btn-outline-secondary border-0"
                        data-toggle="modal" data-target="#modal-choose-assign-user" disabled>
                    <c:if test="${assignedUser != null}">
                        <img class="user-head mr-2" src="img/avatar/${assignedUser.picture}.png"/>
                        ${assignedUser.realname}
                        <small>(${assignedUser.username})</small>
                    </c:if>
                    <c:if test="${assignedUser == null}">
                        <img class="user-head mr-2" src="img/avatar/default.png"/>
                        选择一个用户
                    </c:if>
                </button>
            </div>
            <div class="col col-lg-2">
                <a class="btn btn-warning btn-block" href="problem/edit/${problem.id}">修改问题</a>
            </div>
        </div>
    </div>

    <!--讨论区&操作记录-->
    <div class="card mb-4">
        <!--Tab标签-->
        <div class="card-header">
            <ul class="nav nav-tabs card-header-tabs">
                <li class="nav-item">
                    <a class="nav-link active" data-toggle="tab" href="#discuss-content" role="tab"
                       aria-controls="discuss-content" aria-selected="false">问题讨论</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#operation-log-content" role="tab"
                       aria-controls="operation-log-content" aria-selected="false">操作记录</a>
                </li>
            </ul>
        </div>
        <div class="card-body">
            <div class="tab-content">
                <!--讨论区-->
                <div class="tab-pane fade show active" id="discuss-content" role="tabpanel">
                    <c:if test="${discussList == null || discussList.size() == 0}">
                        <h1 class="mt-5 mb-5 text-secondary text-center">
                            <i class="fa fa-exclamation-circle mr-3"></i>暂无讨论
                        </h1>
                    </c:if>
                    <c:if test="${discussList != null && discussList.size() > 0}">
                        <table class="table table-borderless table-hover">
                            <tbody>
                            <c:forEach items="${discussList}" var="discuss">
                                <tr>
                                    <td class="align-middle pr-0" width="1px">
                                        <img class="user-head" src="img/avatar/${discuss.publisherUser.picture}.png"/>
                                    </td>
                                    <td class="align-middle line-limit-length" width="1px">
                                        <span>${discuss.publisherUser.realname}</span>
                                        <span class="text-secondary"> ${discuss.publisherUser.username}</span><br>
                                        <span class="text-secondary small">
                                            <fmt:formatDate value="${discuss.publishTime}" pattern="yy-M-d H:mm:ss"/>
                                        </span>
                                    </td>
                                    <td class="align-middle">${discuss.discussContent}</td>
                                    <td class="align-middle line-limit-length" width="1px">
                                        <c:if test="${currentUser.id == discuss.publisherUser.id}">
                                            <a class="btn btn-sm btn-outline-warning"
                                               href="javascript:layer.msg('TODO',{icon: 0})">
                                                修改
                                            </a>
                                            <a class="btn btn-sm btn-outline-danger"
                                               href="javascript:layer.msg('TODO',{icon: 0})">
                                                移除
                                            </a>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    <div class="dropdown-divider"></div>
                    <form action="discuss/add" method="post">
                        <input type="hidden" name="problemId" value="${problem.id}">
                        <textarea class="form-control" name="discussContent" placeholder="请输入讨论内容" required></textarea>
                        <span class="align-middle float-left pl-1 mt-2">
                            <img class="user-head mr-2" src="img/avatar/${currentUser.picture}.png"/>
                        </span>
                        <span class="align-middle float-left mt-3">
                            <span>${currentUser.realname}</span>
                            <span class="text-secondary">(${currentUser.username})</span>
                            <span class="text-secondary small ml-4">
                                <fmt:formatDate value="<%=new Date()%>" pattern="yyyy-M-d H:mm:ss"/>
                            </span>
                        </span>
                        <button type="submit" class="btn btn-success float-right mt-3">发表讨论</button>
                    </form>
                </div>

                <!--操作记录-->
                <div class="tab-pane fade" id="operation-log-content" role="tabpanel">
                    <h1 class="mt-5 mb-5 text-secondary text-center">
                        <i class="fa fa-snowflake fa-spin mr-3"></i>功能正在开花中
                    </h1>
                </div>
            </div>
        </div>
    </div>

</div>

<%@ include file="common_footer.jsp" %>

<!--问题级别按钮颜色-->
<script type="text/javascript">
    var btnColors = ['danger', 'warning', 'info', 'secondary'];
    $('#btnLevel' + ${problem.problemLevel}).attr('class', 'btn btn-' + btnColors[${problem.problemLevel} -1]);
</script>

</body>
</html>