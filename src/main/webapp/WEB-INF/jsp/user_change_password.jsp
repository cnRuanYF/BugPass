<%@ include file="common_params.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>个人中心 - BugPass</title>

    <%@ include file="common_html_head.jsp" %>

</head>
<body>

<%@ include file="navbar.jsp" %>

<div class="container">
    <div class="row">

        <div class="col-md-3 mb-4">
            <div class="list-group">
                <h5 class="list-group-item">个人中心</h5>
                <a href="user/updateProfile" class="list-group-item list-group-item-action">
                    <i class="fa fa-fw fa-user-edit mr-2"></i>个人资料
                </a>
                <a href="user/changePassword" class="list-group-item list-group-item-action active">
                    <i class="fa fa-fw fa-key mr-2"></i>修改密码
                </a>
            </div>
        </div>

        <div class="col-md-9">
            <div class="card card-body">
                <h5 class="mb-4">修改密码</h5>
                <form action="user/changePassword" method="post">
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-right" for="oldPassword">原密码</label>
                        <div class="col-md-9 col-lg-6">
                            <input type="password" id="oldPassword" class="form-control" name="oldPassword"
                                   placeholder="请输入原密码" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-right" for="newPassword">新密码</label>
                        <div class="col-md-9 col-lg-6">
                            <input type="password" id="newPassword" class="form-control" name="newPassword"
                                   placeholder="请输入新密码" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-right" for="confirmNewPassword">确认密码</label>
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
