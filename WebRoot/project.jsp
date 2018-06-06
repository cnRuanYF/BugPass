<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<c:if test="${hotList == null}">
    <% response.sendRedirect(basePath + "index.action"); %>
</c:if>

<!DOCTYPE html>
<html>
	<head>
		<title>锋云租房</title>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

        <!--
    	<link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/fontawesome-all.css" rel="stylesheet">
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.js"></script> -->
    </head>
    
	<body>
	    <div class="container">
			<div class="carousel slide mb-4" id="carousel-index">
				<ol class="carousel-indicators">
					<c:forEach items="${hotList}" varStatus="i">
						<li class="${i.count == 1 ? 'active' : ''}"  data-target="#carousel-index" data-slide-to="${i.count - 1}"></li>
					</c:forEach>
				</ol>
				<div class="carousel-inner">
				    <c:forEach items="${latestList}" var="h" varStatus="i">
						<div class="carousel-item ${i.count == 1 ? 'active' : ''}" onclick="location.href='house.show.action?id=${h.id}'" style="cursor:pointer">
    						<img class="d-block w-100 rounded" alt="${h.title}" src="upload/${h.pictures[0]}" style="max-height:32rem;" onerror="this.src='img/img_error.png'"/>
    						<div class="carousel-caption">
    							<h4>${h.title}</h4>
    							<p>${h.intro}</p>
    						</div>
    					</div>
    				</c:forEach>
				</div>
				<a class="carousel-control-prev" href="#carousel-index" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                    <span class="sr-only">Previous</span>
				</a>
				<a class="carousel-control-next" href="#carousel-index" data-slide="next">
				    <span class="carousel-control-next-icon"></span>
				    <span class="sr-only">Next</span>
				</a>
			</div>
			
        	<div class="row">
        		<div class="col mb-4">
					<h3>最新发布</h3>
					<div class="card-columns">
                        <c:forEach items="${latestList}" var="h">
   							<div class="card" onclick="location.href='house.show.action?id=${h.id}'" style="cursor:pointer">
   								<img class="card-img-top" alt="${h.title}" src="upload/${h.pictures[0]}" onerror="this.src='img/img_error.png'" style="max-height:16rem"/>
   								<div class="card-block p-2">
   									<p class="card-text line-limit-length">
   										${h.title}<br>
   										<small class="text-muted" style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis">
   											<i class="fa fa-map-marker-alt mr-2"></i>${h.city}${h.county}${h.address}<br>
   										</small>
   									</p>
   									<h5 class="card-title text-primary">￥${h.price}<small> 元/月</small></h5>
   									<p class="card-text">
   										<small class="text-muted">
   											<i class="fa fa-clock mr-2"></i><fmt:formatDate value="${h.publishTime}" pattern="yyyy年M月d日 H:mm"/> 发布
   										</small>
   									</p>
   								</div>
   							</div>
                        </c:forEach>
        			</div>
        		</div>
        		<div class="col">
					<h3>最多人看</h3>
					<div class="card-columns">
                        <c:forEach items="${hotList}" var="h">
   							<div class="card" onclick="location.href='house.show.action?id=${h.id}'" style="cursor:pointer">
   								<img class="card-img-top" alt="${h.title}" src="upload/${h.pictures[0]}" onerror="this.src='img/img_error.png'" style="max-height:16rem"/>
   								<div class="card-block p-2">
   									<p class="card-text line-limit-length">
   										${h.title}<br>
   										<small class="text-muted">
   											<i class="fa fa-map-marker-alt mr-2"></i>${h.city}${h.county}${h.address}<br>
   										</small>
   									</p>
   									<h5 class="card-title text-primary">￥${h.price}<small> 元/月</small></h5>
   									<p class="card-text">
   										<small class="text-muted">
   											<i class="fa fa-fire mr-2"></i>${h.visitCount} 次浏览
   										</small>
   									</p>
   								</div>
   							</div>
                        </c:forEach>
        			</div>
        		</div>
        		<!--
        		<div class="col-md-4">
					<h3>公告栏</h3>
					<ul>
                        <c:forEach items="${userList}" var="u">
    						<li class="list-item">
    							<a href="#">${u.id} - ${u.username}</a>
    						</li>
                        </c:forEach>
					</ul>
        		</div>
        		-->
        	</div>
        </div>

        <jsp:include page="footer.htm"></jsp:include>
        
        <style></style>
	</body>
</html>

