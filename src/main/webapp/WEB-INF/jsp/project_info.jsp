<%@ include file="common_params.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>项目设置 - BugPass</title>

    <%@ include file="common_head.jsp" %>

</head>

<body>

<% request.setAttribute("navItem", "setting"); %>
<%@ include file="navbar.jsp" %>

<div class="container">
    <div class="row">

        <% request.setAttribute("sideNavItem", "info"); %>
        <%@ include file="project_sidebar.jsp" %>

        <div class="col-md-9">
            <div class="card card-body">
                <h5 class="mb-4">项目信息</h5>
                <form action="project/updateInfo" method="post">
                    <input type="hidden" name="id" value="${currentProject.id}">
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-md-right">项目ID</label>
                        <div class="col-md-9 col-lg-6">
                            <input type="text" class="form-control" value="${currentProject.displayID}" readonly>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-md-right" for="projectName">项目名称</label>
                        <div class="col-md-9 col-lg-6">
                            <input type="text" id="projectName" class="form-control" name="projectName"
                                   value="${currentProject.projectName}" placeholder="请输入项目名称" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-md-right" for="projectDesc">项目描述</label>
                        <div class="col-md-9 col-lg-6">
                            <textarea id="projectDesc" class="form-control" name="projectDesc" placeholder="请输入项目描述">
                                ${currentProject.projectDesc}
                            </textarea>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-md-right">创建时间</label>
                        <div class="col-md-9 col-lg-6">
                            <input type="text" class="form-control"
                                   value="<fmt:formatDate value="${currentProject.createTime}" pattern="yyyy年M月d日 H:mm"/>"
                                   readonly>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-md-right">创建人</label>
                        <div class="col-md-9 col-lg-6">
                            <img class="mr-2" src="img/avatar/${projectCreator.picture}.png"
                                 style="width:40px;height:40px;border-radius:100%"/>
                            ${projectCreator.realname == null ? projectCreator.username : projectCreator.realname}
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-9 col-lg-6 offset-md-3">
                            <button type="submit" class="btn btn-primary col-md-6">保存</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $('#userPictureImg').click(function () {
        var random = Math.floor(Math.random() * 189);
        $('#userPictureImg').attr('src', 'img/avatar/' + random + '.png');
        $('#userPictureValue').attr('value', random);
    });
</script>

<%@ include file="footer.jsp" %>

</body>
</html>