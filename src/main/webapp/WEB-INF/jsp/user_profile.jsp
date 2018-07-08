<%@ include file="common_params.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>个人中心 - BugPass</title>

    <%@ include file="common_head.jsp" %>

    <style>
        #userPictureImg {
            width: 128px;
            height: 128px;
            border-radius: 100%;
            cursor: pointer;
            transition: all 0.5s;
        }

        #userPictureImg:hover {
            transform: rotate(360deg);
        }
    </style>
</head>

<body>

<%@ include file="navbar.jsp" %>

<div class="container">
    <div class="row">

        <% request.setAttribute("sideNavItem", "profile");%>
        <%@ include file="user_sidebar.jsp" %>

        <div class="col-md-9">
            <div class="card card-body">
                <h5 class="mb-4">个人资料</h5>
                <form action="user/updateProfile" method="post">
                    <input type="hidden" name="id" value="${currentUser.id}">
                    <input type="hidden" id="userPictureValue" name="picture" value="${currentUser.picture}">
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-md-right" for="realname">头像</label>
                        <div class="col-md-9 col-lg-6">
                            <img id="userPictureImg" src="img/avatar/${currentUser.picture}.png"/>
                            <span class="text-secondary ml-2"><i class="far fa-hand-point-left mr-2"></i>点击换一张</span>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-md-right" for="realname">姓名</label>
                        <div class="col-md-9 col-lg-6">
                            <input type="text" id="realname" class="form-control" name="realname"
                                   value="${currentUser.realname}" placeholder="请输入姓名" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-md-right" for="email">E-mail</label>
                        <div class="col-md-9 col-lg-6">
                            <input type="email" id="email" class="form-control" name="email"
                                   value="${currentUser.email}" placeholder="请输入电子邮箱" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-md-right" for="phone">手机</label>
                        <div class="col-md-9 col-lg-6">
                            <input type="text" id="phone" class="form-control" name="phone"
                                   value="${currentUser.phone}" placeholder="请输入手机号码">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label text-md-right" for="qq">QQ</label>
                        <div class="col-md-9 col-lg-6">
                            <input type="text" id="qq" class="form-control" name="qq"
                                   value="${currentUser.qq}" maxlength="11" placeholder="请输入QQ">
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
