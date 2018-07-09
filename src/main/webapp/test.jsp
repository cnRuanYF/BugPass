<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<%--cdn 测试用--%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<!-- <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
 
	最新的 Bootstrap 核心 JavaScript 文件
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
	
</head>
<body>
	<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/upLoad/problemattachment" method="post" id="formvalue" enctype="multipart/form-data" onsubmit="return checkFile()">
				
					
					<div class="form-group">
						<label for="file1" class="col-sm-2 control-label">图片1</label>
						<div class="col-sm-8">
							<input type="file" required="required" class="form-control" name="myfiles" id="file1" />
						</div> 
					</div>
					<div class="form-group">
						<label for="file2" class="col-sm-2 control-label">图片2</label>
						<div class="col-sm-8">
							<input type="file" required="required" class="form-control" name="myfiles" id="file2" />
						</div> 
					</div>
					<div class="form-group">
						<label for="file3" class="col-sm-2 control-label">图片3</label>
						<div class="col-sm-8">
							<input type="file" required="required" class="form-control" name="myfiles" id="file3" />
						</div> 
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-danger">提交</button>
							<!-- <button type="button" class="btn btn-success" onclick="actionFrom()">ajax提交</button> -->
						</div>
					</div>
				</form>


			</div>
		</div>
	</div>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
	/* 检测图片是否都添加了 */
       function checkFile(){
    	   var files = $("files");
    	   for( var i =0;i<files.length;i++){
    		   if(files[i].val()==null||files[i].val()==""){
    			   alert("第"+i+"图片未选择");
    			   return false;
    		   }
    	   }
    	   return true;
       }
		/* 提交 */
		/* var actionFrom =function(){
			alert(1);
			var problemattachment =  new FormData(document.getElementById("formvalue"));
			
			
			 $.ajax({
	                url:"${pageContext.request.contextPath}/user/ajaxadd",
	                type:"post",
	               data:JSON.stringify({"name":$("#name").val(),"pwd":$("#pwd").val(),"age":$("#age").val()}),
	               //data:user, 
	               contentType:"application/json",
	                success:function(data){
	                	if(data){
	                		location.href="${pageContext.request.contextPath}/user/list";
	                	}
	                },
	                error:function(e){
	                   
	                }
	            });        
		}
	 */
	</script>
</body>
</html>