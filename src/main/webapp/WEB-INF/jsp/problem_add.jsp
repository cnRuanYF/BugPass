<%@ include file="common_params.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>发布问题 - BugPass</title>

    <%@ include file="common_head.jsp" %>

</head>

<body>

<% request.setAttribute("navItem", "problem"); %>
<%@ include file="navbar.jsp" %>

<div class="container">
    <div class="card card-body">
        <h5 class="mb-4">发布问题</h5>
        <form action="problem/add" method="post">
            <input type="hidden" name="projectId" value="${currentProject.id}">
            <input type="hidden" name="publisher" value="${currentUser.id}">
            <div class="form-group row">
                <label class="col-md-3 col-form-label text-md-right" for="problemType">问题类型</label>
                <div class="col-md-9 col-lg-6">
                    <select class="form-control" type="text" id="problemType" name="problemType" required>
                        <c:forEach items="${problemTypeList}" var="type">
                            <option value="${type.problemTypeId}">${type.problemTypeName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label text-md-right" for="problemLevel">重要级别</label>
                <div class="col-md-9 col-lg-6">
                    <select class="form-control" type="text" id="problemLevel" name="problemLevel" required>
                        <c:forEach items="${problemLevelList}" var="level">
                            <option value="${level.problemLevelId}">${level.problemLevelName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label text-md-right" for="problemTitle">问题标题</label>
                <div class="col-md-9 col-lg-6">
                    <input class="form-control" type="text" id="problemTitle" name="problemTitle"
                           placeholder="请输入问题标题" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label text-md-right" for="problemDesc">问题描述</label>
                <div class="col-md-9 col-lg-6">
                    <textarea class="form-control" id="problemDesc" name="problemDesc"
                              placeholder="请尽可能详细的描述问题" required></textarea>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-md-3 col-form-label text-md-right">发布者</label>
                <div class="col-md-9 col-lg-6">
                    <img class="user-head mr-2" src="img/avatar/${currentUser.picture}.png"/>
                    ${currentUser.realname}
                    <small class="text-secondary">(${currentUser.username})</small>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-md-9 col-lg-6 offset-md-3">
                    <button type="submit" class="btn btn-primary col-md-4">发布问题</button>
                </div>
            </div>
        </form>
    </div>
</div>

<%@ include file="common_footer.jsp" %>

<!--隐藏发布问题按钮-->
<script type="text/javascript">
    $('#btnAddProblem').hide(500);
</script>

</body>
</html>