<%@ include file="common_params.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>${isEdit ? '修改问题' : '发布问题'} - BugPass</title>

    <%@ include file="common_head.jsp" %>

</head>

<body>

<% request.setAttribute("navItem", "problem"); %>
<%@ include file="navbar.jsp" %>

<div class="container">
    <div class="card card-body">
        <c:if test="${isEdit}">
            <h5 class="mb-4">
                修改问题
                <a class="float-right small" href="problem/${problem.id}" style="text-decoration:none">
                    <i class="fa fa-chevron-left mr-2"></i>返回问题页
                </a>
            </h5>
        </c:if>
        <c:if test="${!isEdit}">
            <h5 class="mb-4">
                发布问题
                <a class="float-right small" href="problem" style="text-decoration:none">
                    <i class="fa fa-chevron-left mr-2"></i>返回问题列表
                </a>
            </h5>
        </c:if>
        <form action="problem/add" method="post">
            <input type="hidden" name="id" value="${problem.id}">
            <input type="hidden" name="projectId" value="${currentProject.id}">
            <input type="hidden" name="publisher" value="${currentUser.id}">
            <c:if test="${isEdit}">
                <div class="form-group row">
                    <label class="col-md-3 col-form-label text-md-right">发布者</label>
                    <div class="col-md-9 col-lg-6">
                        <img class="user-head mr-2" src="img/avatar/${publisher.picture}.png"/>
                        ${publisher.realname}<small>(${publisher.username})</small>
                    </div>
                </div>
            </c:if>
            <div class="form-group row">
                <label class="col-md-3 col-form-label text-md-right" for="problemType">问题类型</label>
                <div class="col-md-6 col-lg-4">
                    <select class="form-control" type="text" id="problemType" name="problemType" required>
                        <c:forEach items="${problemTypeList}" var="t">
                            <option value="${t.problemTypeId}" ${t.problemTypeId == problem.problemType ? 'selected' : ''}>${t.problemTypeName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <input type="hidden" id="problemLevel" name="problemLevel">
            <div class="form-group row">
                <label class="col-md-3 col-form-label text-md-right" for="problemLevel">重要级别</label>
                <div class="col-md-9 col-lg-6">
                    <c:forEach items="${problemLevelList}" var="l">
                        <button type="button" id="btnLevel${l.problemLevelId}"
                                onclick="changeLevel(${l.problemLevelId},'${l.problemLevelName}')"></button>
                    </c:forEach>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label text-md-right" for="moduleId">所属模块</label>
                <div class="col-md-6 col-lg-4">
                    <select class="form-control" type="text" id="moduleId" name="moduleId">
                        <option>（${moduleList == null || moduleList.size() == 0 ? '该项目还未添加模块信息' : '不指定'}）</option>
                        <c:forEach items="${moduleList}" var="m">
                            <option value="${m.moduleId}" ${m.moduleId == problem.moduleId ? 'selected' : ''}>${m.moduleName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label text-md-right" for="versionId">所属版本</label>
                <div class="col-md-6 col-lg-4">
                    <select class="form-control" type="text" id="versionId" name="versionId">
                        <option>（${versionList == null || versionList.size() == 0 ? '该项目还未添加版本信息' : '不指定'}）</option>
                        <c:forEach items="${versionList}" var="v">
                            <option value="${v.versionId}" ${v.versionId == problem.versionId ? 'selected' : ''}>${v.versionName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label text-md-right" for="problemTitle">问题标题</label>
                <div class="col-md-9 col-lg-8">
                    <input class="form-control" type="text" id="problemTitle" name="problemTitle"
                           value="${problem.problemTitle}" placeholder="请简要的概述问题" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label text-md-right" for="problemDesc">问题描述</label>
                <div class="col-md-9 col-lg-8">
                    <textarea class="form-control" id="problemDesc" name="problemDesc"
                              placeholder="请尽可能详细的描述问题" style="min-height:240px"
                              required>${problem.problemDesc}</textarea>
                </div>
            </div>
            <c:if test="${currentUser.id == currentProject.creator.id}">
                <input type="hidden" id="assignedTo" name="assignedTo" value="${problem.assignedTo}">
                <div class="form-group row">
                    <label class="col-md-3 col-form-label text-md-right">指派给</label>
                    <div class="col-md-9 col-lg-6">
                        <button id="btnChooseAssignUser" type="button" class="btn btn-outline-secondary border-0"
                                data-toggle="modal" data-target="#modal-choose-assign-user">
                            <c:if test="${assignedUser != null}">
                                <img class="user-head mr-2" src="img/avatar/${assignedUser.picture}.png"/>
                                ${assignedUser.realname}<small>(${assignedUser.username})</small>
                            </c:if>
                            <c:if test="${assignedUser == null}">
                                <img class="user-head mr-2" src="img/avatar/default.png"/>
                                选择一个用户
                            </c:if>
                        </button>
                    </div>
                </div>
            </c:if>
            <c:if test="${currentUser.id != currentProject.creator.id && isEdit}">
                <input type="hidden" id="assignedTo" name="assignedTo" value="${problem.assignedTo}">
                <div class="form-group row">
                    <label class="col-md-3 col-form-label text-md-right">指派给</label>
                    <div class="col-md-9 col-lg-6">
                        <c:if test="${assignedUser != null}">
                            <img class="user-head mr-2" src="img/avatar/${assignedUser.picture}.png"/>
                            ${assignedUser.realname}<small>(${assignedUser.username})</small>
                        </c:if>
                        <c:if test="${assignedUser == null}">
                            <img class="user-head mr-2" src="img/avatar/default.png"/>
                            暂未指派
                        </c:if>
                    </div>
                </div>
            </c:if>
            <div class="form-group row">
                <div class="col-md-9 col-lg-6 offset-md-3">
                    <button type="submit" class="btn btn-primary col-md-6">${isEdit ? '保存修改' : '发布问题'}</button>
                </div>
            </div>
        </form>
    </div>
</div>

<!--选择指派对象模态窗口-->
<c:if test="${currentUser.id == currentProject.creator.id}">
    <div class="modal fade" id="modal-choose-assign-user" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="row">
                        <c:forEach items="${memberList}" var="member">
                            <div class="col-6">
                                <button type="button" class="btn btn-block btn-outline-secondary border-0 text-left"
                                        data-dismiss="modal"
                                        onclick="selectAssignUser(this, ${member.user.id})">
                                    <img class="user-head mr-2" src="img/avatar/${member.user.picture}.png"/>
                                        ${member.user.realname}
                                    <small>(${member.user.username})</small>
                                </button>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>

<%@ include file="common_footer.jsp" %>

<!--隐藏发布问题按钮-->
<c:if test="${!isEdit}">
    <script type="text/javascript">
        $('#btnAddProblem').hide(500);
    </script>
</c:if>

<!--问题级别按钮效果-->
<script type="text/javascript">
    // 问题级别按钮颜色
    var btnColors = ['danger', 'warning', 'info', 'secondary'];

    /**
     * 切换问题级别
     */
    function
    changeLevel(id, name) {
        // 重置4个按钮的样式
        for (var i = 1; i <= btnColors.length; i++) {
            var btn = $('#btnLevel' + i);
            btn.attr('class', 'mr-1 btn btn-' + btnColors[i - 1]);
            btn.html('&emsp;');
        }

        // 激活选中的按钮
        var btn = $('#btnLevel' + id);
        btn.attr('class', 'mr-1 btn btn-' + btnColors[id - 1]);
        btn.html('<i class="fa fa-check mr-2"></i>' + name);

        // 改变表单值
        $('#problemLevel').val(id);
    }

    <c:if test="${isEdit}">
    changeLevel(${problem.problemLevel}, '${problemLevelList.get(problem.problemLevel - 1).problemLevelName}');
    </c:if>
    <c:if test="${!isEdit}">
    // 默认激活第三个
    changeLevel(${problemLevelList.get(2).problemLevelId}, '${problemLevelList.get(2).problemLevelName}');
    </c:if>
</script>

<!--选择指派的用户-->
<script type="text/javascript">
    function selectAssignUser(e, id) {
        $('#assignedTo').val(id);
        $('#btnChooseAssignUser').html(e.innerHTML);
    }
</script>

</body>
</html>