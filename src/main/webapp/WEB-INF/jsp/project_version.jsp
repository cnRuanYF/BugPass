<%@ include file="common_params.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>版本管理 - BugPass</title>

    <%@ include file="common_head.jsp" %>

</head>

<body>

<% request.setAttribute("navItem", "setting"); %>
<%@ include file="navbar.jsp" %>

<div class="container">
    <div class="row">

        <% request.setAttribute("sideNavItem", "version"); %>
        <%@ include file="project_sidenav.jsp" %>

        <div class="col-md-9">
            <div class="card card-body">
                <h5 class="mb-4">
                    版本列表
                    <c:if test="${currentProject.creator.id == currentUser.id}">
                        <a class="btn btn-success float-right" data-toggle="modal" href="#modal-container-add-version">
                            <i class="fa fa-plus mr-2"></i>新增版本
                        </a>
                    </c:if>
                </h5>
                <c:if test="${versionList == null || versionList.size() == 0}">
                    <h1 class="mt-5 mb-5 text-secondary text-center">
                        <i class="fa fa-exclamation-circle mr-3"></i>暂无版本
                    </h1>
                </c:if>
                <c:if test="${versionList != null && versionList.size() > 0}">
                    <table class="table table-borderless table-hover">
                        <thead>
                        <tr>
                            <th>版本</th>
                            <c:if test="${currentProject.creator.id == currentUser.id}">
                                <th width="1px">操作</th>
                            </c:if>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${versionList}" var="version">
                            <tr id="tableRow${version.versionId}">
                                <td class="align-middle">${version.versionName}</td>
                                <c:if test="${currentProject.creator.id == currentUser.id}">
                                    <td class="align-middle line-limit-length" >
                                        <button class="btn btn-sm btn-outline-warning"
                                                onclick="editItem(${version.versionId})">修改
                                        </button>
                                        <button class="btn btn-sm btn-outline-danger"
                                                onclick="deleteItem(${version.versionId})">删除
                                        </button>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>
    </div>
</div>

<!--新增版本模态窗口-->
<div class="modal fade" id="modal-container-add-version" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">
                    <i class="far fa-plus-square mr-2"></i>新增版本
                </h5>
                <button class="close" type="button" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <form class="mb-0" role="form" id="addVersionForm" action="version/add" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="addVersionName">版本名称</label>
                        <input name="projectId" type="hidden" value="${currentProject.id}">
                        <input class="form-control" id="addVersionName" name="versionName" type="text"
                               placeholder="输入版本的名称" required  onkeyup="checkAdd()"/>
                        <h5 id="checkAddMessage"></h5>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button class="btn btn-success btn_add" type="submit" >确认添加</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!--修改版本模态窗口-->
<div class="modal fade" id="modal-container-edit-version" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">
                    <i class="far fa-plus-square mr-2"></i>修改版本
                </h5>
                <button class="close" type="button" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <form class="mb-0" role="form" id="editVersionForm" action="version/update" method="post">
                <div class="modal-body">
                    <input name="projectId" value="${currentProject.id}" type="hidden"/>
                    <input id="editVersionId" name="versionId" type="hidden"/>
                    <div class="form-group">
                        <label for="editVersionName">版本名称</label>
                        <input class="form-control" id="editVersionName" name="versionName" type="text"
                               placeholder="输入版本的名称" required onkeyup="checkUpdate()"/>
                        <h5 id="checkUpdateMessage"></h5>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button class="btn btn-warning btn_update" type="submit" >提交修改</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">
    function checkAdd() {
        var val=$("#addVersionName").val();
        if (val=="") {
            $("#checkAddMessage").html('<span style=" color: #18720e">版本名不能为空</span>');
            $(".btn_add").attr("disabled", true);
        }else{
            $.ajax({
                type : "post",
                url : "${pageContext.request.contextPath}/api/checkVersionName",
                data : {
                    "versionName" :  $("#addVersionName").val(),
                    "projectId" : "${currentProject.id}"
                },
                dataType : "JSON",
                success : function(flag) {
                    if (flag){
                        $("#checkAddMessage").html('<span style=" color: #18720e">版本名已存在，不可使用</span>');
                        $(".btn_submit").attr("disabled", true);
                    }else {
                        $("#checkAddMessage").html('<span style="color: #1E9FFF">版本名可用</span>');
                        $(".btn_add").attr("disabled", false);
                    }

                },

            });
        }

    }
    function checkUpdate() {
        var val=$("#editVersionName").val();
        if (val=="") {
            $("#checkUpdateMessage").html('<span style=" color: #18720e">版本名不能为空</span>');
            $(".btn_update").attr("disabled", true);
        }else{
            $.ajax({
                type : "post",
                url : "${pageContext.request.contextPath}/api/checkVersionName",
                data : {
                    "versionName" :  $("#editVersionName").val(),
                    "projectId" : "${currentProject.id}"
                },
                dataType : "JSON",
                success : function(flag) {
                    if (flag){
                        $("#checkUpdateMessage").html('<span style=" color: #18720e">版本名已存在，不可使用</span>');
                        $(".btn_update").attr("disabled", true);
                    }else {
                        $("#checkUpdateMessage").html('<span style="color: #1E9FFF">版本名可用</span>');
                        $(".btn_update").attr("disabled", false);
                    }

                },

            });
        }

    }

    /**
     * 修改条目
     */
    function editItem(id) {
        var tableRow = $('#tableRow' + id);
        var versionName = tableRow.find('td:eq(0)').text();
        $('#editVersionId').val(id);
        $('#editVersionName').val(versionName);
        $('#modal-container-edit-version').modal('show');
    }

    /**
     * 删除条目
     */
    function deleteItem(id) {
        var tableRow = $('#tableRow' + id);
        var versionName = tableRow.find('td:eq(0)').text();
        // 确认删除的提示
        layer.open({
            icon: 3,
            title: false,
            content: '真的要删除 ' + versionName + ' 这个版本吗？',
            shadeClose: true,
            closeBtn: false,
            btn: ['确定', '取消'],

            // 弹窗成功时改变按钮样式（解决Bootstrap样式冲突）
            success: function () {
                $('.layui-layer-btn > .layui-layer-btn0').css('color', '#FFF');
            },
            // 点击确定按钮时执行
            yes: function () {
                $.ajax({
                    url: 'version/delete/' + id,
                    type: 'DELETE',
                    timeout: 5000,
                    success: function (data) {
                        if (data === 'true') {
                            layer.msg(data, {icon: 2});
                        } else {
                            // 移除表格行元素
                            tableRow.hide(500);

                            layer.msg('删除成功', {icon: 1});
                        }
                    },
                    error: function () {
                        layer.msg('操作失败，请稍后重试', {icon: 2});
                    }
                });
            }
        });
    }
</script>

<%@ include file="common_footer.jsp" %>

</body>
</html>