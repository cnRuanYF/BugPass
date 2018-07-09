<%@ include file="common_params.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>项目设置 - BugPass</title>

<%@ include file="common_head.jsp"%>

</head>

<body>

	<%
	    request.setAttribute("navItem", "setting");
	%>
	<%@ include file="navbar.jsp"%>

	<div class="container">
		<div class="row">

			<%
			    request.setAttribute("sideNavItem", "info");
			%>
			<%@ include file="project_sidenav.jsp"%>

			<div class="col-md-9">
				<div class="card card-body">
					<h5 class="mb-4">项目信息</h5>
					<form action="project/info" method="post">
						<c:if test="${projectCreator.id == currentUser.id}">
							<input type="hidden" name="id" value="${currentProject.id}">
							<div class="form-group row">
								<label class="col-md-3 col-form-label text-md-right">项目ID</label>
								<div class="col-md-9 col-lg-6">
									<input type="text" class="form-control"
										value="${currentProject.displayId}" readonly>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 col-form-label text-md-right"
									for="projectName">项目名称</label>
								<div class="col-md-9 col-lg-6">
									<input type="text" id="projectName" class="form-control"
										name="projectName" value="${currentProject.projectName}"
										placeholder="请输入项目名称" required>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 col-form-label text-md-right"
									for="projectDesc">项目描述</label>
								<div class="col-md-9 col-lg-6">
									<textarea id="projectDesc" class="form-control"
										name="projectDesc" placeholder="请输入项目描述">${currentProject.projectDesc}</textarea>
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
									<img class="user-head mr-2"
										src="img/avatar/${projectCreator.picture}.png" />
									${projectCreator.realname == null ? projectCreator.username : projectCreator.realname}
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-9 col-lg-6 offset-md-3">
									<button type="submit" class="btn btn-primary col-md-4">保存</button>
									<a href="project/delete/${currentProject.id}"
										class="btn btn-danger col-md-4">删除项目</a>
								</div>
							</div>
						</c:if>

						<c:if test="${projectCreator.id != currentUser.id}">
							<input type="hidden" name="id" value="${currentProject.id}">
							<div class="form-group row">
								<label class="col-md-3 col-form-label text-md-right">项目ID</label>
								<div class="col-md-9 col-lg-6">
									<input type="text" class="form-control"
										value="${currentProject.displayId}" readonly>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 col-form-label text-md-right"
									for="projectName">项目名称</label>
								<div class="col-md-9 col-lg-6">
									<input type="text" id="projectName" class="form-control"
										name="projectName" value="${currentProject.projectName}"
										placeholder="请输入项目名称" readonly>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-md-3 col-form-label text-md-right"
									for="projectDesc">项目描述</label>
								<div class="col-md-9 col-lg-6">
									<textarea id="projectDesc" class="form-control"
										name="projectDesc" placeholder="请输入项目描述" readonly>${currentProject.projectDesc}</textarea>
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
									<img class="user-head mr-2"
										src="img/avatar/${projectCreator.picture}.png" />
									${projectCreator.realname == null ? projectCreator.username : projectCreator.realname}
								</div>
							</div>
						</c:if>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$('#userPictureImg').click(function() {
			var random = Math.floor(Math.random() * 189);
			$('#userPictureImg').attr('src', 'img/avatar/' + random + '.png');
			$('#userPictureValue').attr('value', random);
		});
	</script>

	<%@ include file="common_footer.jsp"%>

</body>
</html>