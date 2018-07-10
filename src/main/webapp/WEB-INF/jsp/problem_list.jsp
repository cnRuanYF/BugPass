<%@ include file="common_params.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>问题列表 - BugPass</title>

    <%@ include file="common_head.jsp" %>

</head>

<body>

<% request.setAttribute("navItem", "problem"); %>
<%@ include file="navbar.jsp" %>

<div class="container">
    <div class="row">

        <!--筛选问题-->
        <div class="col-md-6 col-lg-4 mb-4">
            <div class="card card-body">
                <h5>筛选问题</h5>
                <div class="dropdown-divider"></div>
                <div class="row">
                    <span class="col-3 text-primary">类型</span>
                    <div class="col-9">
                        <div class="row">
                            <c:forEach items="${problemTypeList}" var="t">
                                <div class="form-check col-6">
                                    <input class="form-check-input" type="checkbox" id="cbType${t.problemTypeId}"
                                           value="${t.problemTypeId}">
                                    <label class="form-check-label"
                                           for="cbType${t.problemTypeId}">${t.problemTypeName}</label>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="dropdown-divider"></div>
                <div class="row">
                    <span class="col-3 text-primary">级别</span>
                    <div class="col-9">
                        <div class="row">
                            <c:forEach items="${problemLevelList}" var="l">
                                <div class="form-check col-6">
                                    <input class="form-check-input" type="checkbox" id="cbLevel${l.problemLevelId}"
                                           value="${l.problemLevelId}">
                                    <label class="form-check-label" for="cbLevel${l.problemLevelId}">
                                            ${l.problemLevelName}
                                    </label>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="dropdown-divider"></div>
                <div class="row">
                    <span class="col-3 text-primary">模块</span>
                    <div class="col-9">
                        <div class="row">
                            <div class="form-check col-6">
                                <input class="form-check-input" type="checkbox" id="cbModuleNull" value="">
                                <label class="form-check-label" for="cbModuleNull">(未指定)</label>
                            </div>
                            <c:forEach items="${moduleList}" var="m">
                                <div class="form-check col-6">
                                    <input class="form-check-input" type="checkbox" id="cbModule${m.moduleId}"
                                           value="${m.moduleId}">
                                    <label class="form-check-label" for="cbModule${m.moduleId}">${m.moduleName}</label>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="dropdown-divider"></div>
                <div class="row">
                    <span class="col-3 text-primary">版本</span>
                    <div class="col-9">
                        <div class="row">
                            <div class="form-check col-6">
                                <input class="form-check-input" type="checkbox" id="cbVersionNull" value="">
                                <label class="form-check-label" for="cbVersionNull">(未指定)</label>
                            </div>
                            <c:forEach items="${versionList}" var="v">
                                <div class="form-check col-6">
                                    <input class="form-check-input" type="checkbox" id="cbVersion${v.versionId}"
                                           value="${v.versionId}">
                                    <label class="form-check-label"
                                           for="cbVersion${v.versionId}">${v.versionName}</label>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <a class="btn btn-primary mt-3" href="javascript:layer.msg('TODO',{icon: 0})">保存筛选条件</a>
            </div>
        </div>

        <!--问题列表-->
        <div class="col-md-6 col-lg-8">
            <div class="card card-body">
                <h5 class="mb-4">问题列表</h5>
                <c:if test="${problemList == null || problemList.size() == 0}">
                    <h1 class="mt-5 mb-5 text-secondary text-center">
                        <i class="fa fa-exclamation-circle mr-3"></i>暂无发布的问题
                    </h1>
                </c:if>
                <c:if test="${problemList != null && problemList.size() > 0}">
                    <div class="list-group list-group-flush">
                        <c:forEach items="${problemList}" var="prob">
                            <a class="list-group-item list-group-item-action" href="problem/${prob.id}">
                                <div>
                                    <span class="text-primary">
                                        ${problemLevelList.get(prob.problemLevel-1).problemLevelName}
                                        的
                                        ${problemTypeList.get(prob.problemType-1).problemTypeName}
                                    </span>
                                    <small class="float-right">
                                        <i class="far fa-clock mr-1"></i>
                                        <fmt:formatDate value="${prob.updateTime}" pattern="yyyy-M-d H:mm:ss"/>
                                    </small>
                                </div>
                                <div class="line-limit-length">${prob.problemTitle}</div>
                                <div class="small text-secondary line-limit-length">${prob.problemDesc}</div>
                                <small>
                                    <i class="fa fa-user mr-2"></i>
                                    <c:forEach items="${memberList}" var="member">
                                        <c:if test="${member.userId == prob.publisher}">${member.user.realname}</c:if>
                                    </c:forEach>
                                </small>
                            </a>
                        </c:forEach>
                    </div>
                    <span class="text-secondary text-right mt-3">找到 ${problemList.size()} 条结果</span>
                </c:if>
            </div>
        </div>

    </div>
</div>

<%@ include file="common_footer.jsp" %>

<!--问题级别按钮效果-->
<script type="text/javascript">
    // 问题级别按钮颜色
    var levelColors = ['danger', 'warning', 'info', 'secondary'];

    // 设置4个按钮的样式
    for (var i = 1; i <= levelColors.length; i++) {
        var lbl = $('#cbLevel' + i).parent().find('label');
        lbl.addClass('badge badge-' + levelColors[i - 1]);
    }
</script>


</body>
</html>