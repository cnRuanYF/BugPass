<%@ include file="common_params.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>个人中心 - BugPass</title>

    <%@ include file="common_head.jsp" %>

</head>
<body>

<%@ include file="navbar.jsp" %>

<div class="container">
    <div class="row">

        <% request.setAttribute("sidebarItem", "password");%>
        <%@ include file="user_sidebar.jsp" %>

        <div class="col-md-9">
            <div class="card card-body">
                <h5 class="mb-4">修改密码</h5>
                <form action="user/changePassword" method="post">
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-md-right" for="oldPassword">原密码</label>
                        <div class="col-md-9 col-lg-6">
                            <input type="password" id="oldPassword" class="form-control" name="oldPassword"
                                   placeholder="请输入原密码" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-md-right" for="newPassword">新密码</label>
                        <div class="col-md-9 col-lg-6">
                            <input type="password" id="newPassword" class="form-control" name="newPassword"
                                   placeholder="请输入新密码" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-md-right" for="confirmNewPassword">确认密码</label>
                        <div class="col-md-9 col-lg-6">
                            <input type="password" id="confirmNewPassword" class="form-control"
                                   name="confirmNewPassword" placeholder="请确认新密码" required>
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

<%@ include file="footer.jsp" %>

</body>
</html>
