<%@ page import="com.bugpass.constant.MessageType" %>

<!-- 信息显示 -->
<c:if test="${warningMessage != null}">
    <script type="text/javascript">
        layer.msg('${warningMessage}', {icon: 0, offset:'200px'});
    </script>
    <% session.setAttribute(MessageType.WARNING, null); %>
</c:if>
<c:if test="${successMessage != null}">
    <script type="text/javascript">
        layer.msg('${successMessage}', {icon: 1, offset:'200px'});
    </script>
    <%session.setAttribute(MessageType.SUCCESS, null); %>
</c:if>
<c:if test="${errorMessage != null}">
    <script type="text/javascript">
        layer.msg('${errorMessage}', {icon: 2, offset:'200px'});
    </script>
    <% session.setAttribute(MessageType.ERROR, null); %>
</c:if>

<!-- 底栏 -->
<footer class="footer mt-4 bg-light text-muted">
    <div class="container p-3">
        <ul class="list-unstyled">
            <li class="list-item list-inline-item"><a href="index">首页</a></li>
            <li class="list-item list-inline-item"><a href="#modal-container-about" data-toggle="modal">关于</a></li>
            <li class="list-item list-inline-item"><a href="mailto:me@ryf.space">联系我们</a></li>
        </ul>
        <p id="copyrightInfo">
            Copyright &copy; 2018 <a href="index.jsp" target="_blank" rel="noopener">BugPass</a> 版权所有
            <br>
            A defect management system.
            <br>
            Server-side powered by
            <a target="_blank" href="https://spring.io">Spring</a>,
            <a target="_blank" href="https://spring.io">SpringMVC</a>,
            <a target="_blank" href="http://www.mybatis.org">Mybatis</a>,
            based on
            <a target="_blank" href="https://www.java.com">Java</a>;
            Front-end powered by
            <a target="_blank" href="https://jquery.com">jQuery</a>,
            <a target="_blank" href="https://getbootstrap.com" target="_blank">Bootstrap</a>,
            <a target="_blank" href="http://layer.layui.com" target="_blank">Layer</a>;
            Database powered by
            <a target="_blank" href="https://www.mysql.com">MySQL</a>.
            <br>
            Designed and built with all the love in the world by
            <a href="#modal-container-team" data-toggle="modal">TeamXHH</a>
            in
            <a href="http://www.etcxm.com" target="_blank">XMETC</a>
            .
        </p>
    </div>
</footer>

<!-- 关于模态窗口 -->
<div class="modal fade" id="modal-container-about" role="dialog" aria-hidden="true" aria-labelledby="aboutModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="aboutModalLabel">
                    <i class="fa fa-info-circle mr-2"></i>关于
                </h5>
                <button class="close" type="button" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="copyrightModal"></p>
            </div>
            <div class="modal-footer">
                <a class="btn btn-primary" href="#modal-container-about" data-toggle="modal">知道啦</a>
            </div>
        </div>
    </div>
</div>

<!-- 成员模态窗口 -->
<div class="modal fade" id="modal-container-team" role="dialog" aria-hidden="true" aria-labelledby="teamModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="teamModalLabel">
                    <i class="fa fa-users mr-2"></i>团队
                </h5>
                <button class="close" type="button" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <img alt="Team members" src="../../img/team_member.png">
            </div>
            <div class="modal-footer">
                <a class="btn btn-primary" href="#modal-container-team" data-toggle="modal">厉害了</a>
            </div>
        </div>
    </div>
</div>

<!-- 复制关于信息 -->
<script type="text/javascript">
    $(document).ready(function () {
        $('#copyrightModal').html($('#copyrightInfo').html());
    });
</script>

<!-- 社会主义核心价值观 -->
<script type="text/javascript" src="../../js/csv.js"></script>
