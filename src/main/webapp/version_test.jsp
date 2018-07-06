<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<button id="bt1" onclick="fun1()">检查版本名是否存在</button>
	</br> 版本名：
	<input type="text" id="versionName">
	</br> 版本id：
	<input type="text" id="versionId">
	</br> 项目ID:
	<input type="text" id="projectId">
	</br>

	<button id="bt2" onclick="fun2()">修改</button>
	<button id="bt3" onclick="fun3()">查询所有版本</button>
	<button id="bt4" onclick="fun4()">模糊查询</button>
	<button id="bt5" onclick="fun5()">添加</button>
	<button id="bt5" onclick="fun6()">删除</button>




	<div>
		<table id="showVersion">
			<tr >
				<td>版本名</td>
				<td>操作</td>
			</tr>
		</table>
	</div>
</body>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
	function fun0() {
		console.log("****测试方法****")
		$("#showVersion").html('<tr ><td>版本名</td><td>操作</td></tr>');
		$.ajax({
			type : "get",
			url : "${pageContext.request.contextPath}/api/selectAllVersion",
			data : {
				"projectId" : 1
			},
			dataType : "JSON",
			success : function(list) {
				$.each(list, function(index, version) {
					console.log(version);
					$("#showVersion").append('<tr ><td>'+version.versionName+'</td>'+
	                          '<td><a  href="#" role="button">'+
			                  '<button  value="'+version.versionId+'">修改</button></a>&nbsp;&nbsp;'+
				              '<button  value="'+version.versionId+'">删除</button></td></tr>');
					});
			}
		});
	}
	/*默认加载方法显示version*/
	$(function() {
		$.ajax({
			type : "get",
			url : "${pageContext.request.contextPath}/api/selectAllVersion",
			data : {
				"projectId" : 1
			},
			dataType : "JSON",
			success : function(list) {
				$.each(list, function(index, version) {
					console.log(version);
					/* $("#showVersion").append('<button >'+version.versionName+'</button></br>'); */
	                /* $("#showVersion").append(version.versionName + '</br>'); */
					$("#showVersion").append('<tr ><td>'+version.versionName+'</td>'+
					                          '<td><a  href="#" role="button">'+
							                  '<button  value="'+version.versionId+'">修改</button></a>&nbsp;&nbsp;'+
								              '<button  value="'+version.versionId+'">删除</button></td></tr>');
				});
			}
		});
	})
	/* 检查版本名 是否存在*/
	function fun1() {
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/api/checkVersionName",
			data : {
				"versionName" : $("#versionName").val(),
				"projectId" : 1
			},
			dataType : "JSON",
			success : function(flag) {
				console.log(flag);
				fun0();
			}
		});
	}
	/* 修改版本名*/
	function fun2() {
		console.log($("#versionName").val());
		$.ajax({
			type : "put",
			url : "${pageContext.request.contextPath}/api/updateVersion",
			data : {
				"versionName" : $("#versionName").val(),
				"versionId" : $("#versionId").val()
			},
			dataType : "JSON",
			success : function(flag) {
				console.log(flag); 
				fun0();
			}
		});

	}
	/*根据项目ID查找所有版本*/
	function fun3() {

		$.ajax({
			type : "get",
			url : "${pageContext.request.contextPath}/api/selectAllVersion",
			data : {
				"projectId" : $("#projectId").val()
			},
			dataType : "JSON",
			success : function(list) {
				$("#showVersion").html('<tr ><td>版本名</td><td>操作</td></tr>');
				$.each(list, function(index, version) {
					$("#showVersion").append('<tr ><td>'+version.versionName+'</td>'+
	                          '<td><a  href="#" role="button">'+
			                  '<button  value="'+version.versionId+'">修改</button></a>&nbsp;&nbsp;'+
				              '<button  value="'+version.versionId+'">删除</button></td></tr>');
				});
			}
		});
	}
	/*模糊查询*/
	function fun4() {
		$
				.ajax({
					type : "get",
					url : "${pageContext.request.contextPath}/api/selectLikeVersionName",
					data : {
						"likeVersionName" : $("#versionName").val(),
						"projectId" : 1
					},
					dataType : "JSON",
					success : function(list) {
						$("#showVersion").html('<tr ><td>版本名</td><td>操作</td></tr>');
						$.each(list, function(index, version) {
							$("#showVersion").append('<tr ><td>'+version.versionName+'</td>'+
			                          '<td><a  href="#" role="button">'+
					                  '<button  value="'+version.versionId+'">修改</button></a>&nbsp;&nbsp;'+
						              '<button  value="'+version.versionId+'">删除</button></td></tr>');
						})
					}
				});
	}
	/*添加版本*/
	function fun5() {
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/api/addVersion",
			data : {
				"versionName" : $("#versionName").val(),
				"projectId" : $("#projectId").val()
			},
			dataType : "JSON",
			success : function(flag) {
				fun0();
				console.log(flag);
			}
		});
	}
	/*删除*/
	function fun6() {
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/api/deleteVersion",
			data : {
				"versionId" : $("#versionId").val()
			},
			dateType : "JSON",
			success : function(flag) {
				console.log(flag);
				fun0();
			}

		});
	}
</script>
</html>