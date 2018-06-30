<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>

  <head>
    <title>个人中心 - BugPass</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../../css/bootstrap.css" rel="stylesheet">
<link href="../../css/fontawesome-all.css" rel="stylesheet">
<script src="../../js/jquery-3.3.1.min.js"></script>
<script src="../../js/bootstrap.js"></script>
  </head>

  <body>

    <div class="container">
      <div class="row">

        <div class="col-md-3 mb-4">
          <div class="list-group">
            <h5 class="list-group-item">个人中心</h5>
            <a href="user_profile.jsp" class="list-group-item list-group-item-action active">
              <i class="fa fa-fw fa-user-edit mr-2"></i>个人资料
            </a>
            <a href="user_change_password.jsp" class="list-group-item list-group-item-action">
              <i class="fa fa-fw fa-key mr-2"></i>修改密码
            </a>
          </div>
        </div>

        <div class="col-md-9">
          <div class="card card-body">
            <h5 class="mb-4">个人资料</h5>
            <form action="updateUserProfile.do" method="post">
              <input type="hidden" name="id" value="${user.id}">
              <div class="form-group row">
                <label class="col-md-3 col-form-label text-right" for="realname">姓名</label>
                <div class="col-md-9 col-lg-6">
                  <input type="text" id="realname" class="form-control" name="realname" value="${user.realname}" placeholder="请输入姓名" required>
                </div>
              </div>
              <div class="form-group row">
                <label class="col-md-3 col-form-label text-right" for="phone">手机</label>
                <div class="col-md-9 col-lg-6">
                  <input type="text" id="phone" class="form-control" name="phone" value="${user.phone}" placeholder="请输入手机号码" required>
                </div>
              </div>
              <div class="form-group row">
                <label class="col-md-3 col-form-label text-right" for="qq">QQ</label>
                <div class="col-md-9 col-lg-6">
                  <input type="text" id="qq" class="form-control" name="qq" value="${user.qq}" maxlength="11" placeholder="请输入QQ" required>
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

    <jsp:include page="footer.htm"></jsp:include>

  </body>

</html>