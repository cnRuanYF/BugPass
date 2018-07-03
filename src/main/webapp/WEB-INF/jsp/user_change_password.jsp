<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <title>个人中心 - BugPass</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>

<div class="container">
    <div class="row">

		<div class="col-md-3 mb-4">
			<div class="list-group">
				<h5 class="list-group-item">个人中心</h5>
			  <a href="user_profile.jsp" class="list-group-item list-group-item-action">
			    <i class="fa fa-fw fa-user-edit mr-2"></i>个人资料
			  </a>
			  <a href="user_change_password.jsp" class="list-group-item list-group-item-action active">
			    <i class="fa fa-fw fa-key mr-2"></i>修改密码
			  </a>
			</div>
		</div>

		<div class="col-md-9">
			<div class="card card-body">
                <h5 class="mb-4">修改密码</h5>
                <form action="updateUserPassword.do" method="post">
	                <div class="form-group row">
						<label class="col-md-3 col-form-label text-right" for="oldPassword">原密码</label>
						<div class="col-md-9 col-lg-6">
							<input type="password" id="oldPassword" class="form-control" name="oldPassword" placeholder="请输入原密码" required>
						</div>
					</div>
	                <div class="form-group row">
						<label class="col-md-3 col-form-label text-right" for="newPassword">新密码</label>
						<div class="col-md-9 col-lg-6">
							<input type="password" id="newPassword" class="form-control" name="newPassword" placeholder="请输入新密码" required>
						</div>
					</div>
	                <div class="form-group row">
						<label class="col-md-3 col-form-label text-right" for="confirmNewPassword">确认密码</label>
						<div class="col-md-9 col-lg-6">
							<input type="password" id="confirmNewPassword" class="form-control" name="confirmNewPassword" placeholder="请确认新密码" required>
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

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
