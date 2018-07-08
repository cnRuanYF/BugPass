<%@ include file="common_params.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>模块管理 - BugPass</title>

    <%@ include file="common_head.jsp" %>

</head>

<body>

<% request.setAttribute("navItem", "setting"); %>
<%@ include file="navbar.jsp" %>

<div class="container">
    <div class="row">

        <% request.setAttribute("sideNavItem", "module"); %>
        <%@ include file="project_sidenav.jsp" %>

        <div class="col-md-9">
            <div class="card card-body">
                <h5 class="mb-4">
                    模块列表
                    <c:if test="${currentProject.creator.id == currentUser.id}">
                        <a class="btn btn-success float-right" data-toggle="modal" href="#modal-container-add-module">
                            <i class="fa fa-plus mr-2"></i>新增模块
                        </a>
                    </c:if>
                </h5>
                <c:if test="${moduleList == null || moduleList.size() == 0}">
                    <h1 class="mt-5 mb-5 text-secondary text-center">
                        <i class="fa fa-exclamation-circle mr-3"></i>暂无模块
                    </h1>
                </c:if>
                <c:if test="${moduleList != null && moduleList.size() > 0}">
                    <table class="table table-borderless table-hover">
                        <thead>
                        <tr>
                            <th>模块</th>
                            <c:if test="${currentProject.creator.id == currentUser.id}">
                                <th width="1px">操作</th>
                            </c:if>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${moduleList}" var="module">
                            <tr id="tableRow${module.moduleId}">
                                <td class="align-middle">${module.moduleName}</td>
                                <c:if test="${currentProject.creator.id == currentUser.id}">
                                    <td class="align-middle">
                                        <button class="btn btn-sm btn-outline-warning"
                                                onclick="editItem(${module.moduleId})">修改
                                        </button>
                                        <button class="btn btn-sm btn-outline-danger"
                                                onclick="deleteItem(${module.moduleId})">删除
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

<!-- 新增模块模态窗口 -->
<div class="modal fade" id="modal-container-add-module" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">
                    <i class="far fa-plus-square mr-2"></i>新增模块
                </h5>
                <button class="close" type="button" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <form class="mb-0" role="form" id="createModuleForm" action="module/add" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="addModuleName">模块名称</label>
                        <input class="form-control" id="addModuleName" name="moduleName" type="text"
                               placeholder="输入模块的名称" required/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button class="btn btn-success" type="submit">确认添加</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- 修改模块模态窗口 -->
<div class="modal fade" id="modal-container-edit-module" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">
                    <i class="far fa-plus-square mr-2"></i>修改模块
                </h5>
                <button class="close" type="button" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <form class="mb-0" role="form" id="editModuleForm" action="module/update" method="post">
                <div class="modal-body">
                    <input name="projectId" value="${currentProject.id}" type="hidden"/>
                    <input id="editModuleId" name="moduleId" type="hidden"/>
                    <div class="form-group">
                        <label for="editModuleName">模块名称</label>
                        <input class="form-control" id="editModuleName" name="moduleName" type="text"
                               placeholder="输入模块的名称" required/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button class="btn btn-warning" type="submit">提交修改</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">s

    /**
     * 修改条目
     */
    function editItem(id) {
        var tableRow = $('#tableRow' + id);
        var moduleName = tableRow.find('td:eq(0)').text();
        $('#editModuleId').val(id);
        $('#editModuleName').val(moduleName);
        $('#modal-container-edit-module').modal('show');
    }

    /**
     * 删除条目
     */
    function deleteItem(id) {
        var tableRow = $('#tableRow' + id);
        var moduleName = tableRow.find('td:eq(0)').text();
        // 确认删除的提示
        layer.open({
            icon: 3,
            title: false,
            content: '真的要删除 ' + moduleName + ' 这个模块吗？',
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
                    url: 'api/module/' + id,
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