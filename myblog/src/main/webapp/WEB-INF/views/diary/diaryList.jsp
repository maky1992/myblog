<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
  
<!-- Mirrored from condorthemes.com/cleanzone/ by HTTrack Website Copier/3.x [XR&CO'2013], Mon, 31 Mar 2014 14:31:31 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>博客后台管理系统</title>

  
</head>
<body>
	<jsp:include page="../admin/top.jsp" flush="false"></jsp:include>
		<div id="cl-wrapper" class="fixed-menu">
		 
			<jsp:include page="../admin/left.jsp" flush="false"></jsp:include>
			<div class="container-fluid" id="pcont">
				<div class="page-head">
					
					<ol class="breadcrumb">
					  <li><a href="#">首页</a></li>
					  <li><a href="#">日记管理</a></li>
					  <li class="active">日记发布管理</li>
					</ol> 
				</div>		
			    
			    <div class="row">
					<div class="col-md-12">
						<div class="block-flat">
							<div class="header">							
								<h3>日记管理</h3>
							</div>
							<div class="content">
									<button class="btn btn-primary"  id = "submit" >添加日记</button>
								<div class="table-responsive">
									<table class="table table-bordered" id="datatable-icons" >
										<thead>
											<tr>
												<th>日记ID</th>
												<th>日记标题</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${typesList }" var="types">
												<tr class="even gradeC">
												<td class="center">${types.diaryId }</td>
												<td>${types.diaryTitle }</td>
												<td class="center">
													<a class="btn btn-default btn-xs" href="<%=basePath%>type/openType?diaryId=${types.diaryId}" data-original-title="Open" data-toggle="tooltip"><i class="fa fa-file"></i></a>
													<a class="btn btn-primary btn-xs" href="<%=basePath%>type/updateTypeGet?diaryId=${types.diaryId}" data-original-title="Edit" data-toggle="tooltip"><i class="fa fa-pencil"></i></a>
													<a class="btn btn-danger btn-xs" href="<%=basePath%>type/deleteType?diaryId=${types.diaryId}"  data-original-title="Remove" data-toggle="tooltip"><i class="fa fa-times"></i></a>
												</td>
											</tr>
											</c:forEach>
										</tbody>
									</table>							
								</div>
							</div>
						</div>				
					</div>
				</div>
			  </div>
			</div> 
</body>

<script type="text/javascript">
	$(".sub-menu .type").addClass('active');
	
</script>
<script type="text/javascript">

	
	$(document).ready(function(){
	  //initialize the javascript
	  App.init();
	  App.dataTables();
	  	
	  //Horizontal Icons dataTable
	  $('#datatable-icons').dataTable();
	});
	
	
	//提示信息
	  var msg = "";
	  msg="${msg}";
	   if(msg != null && msg != ""){
	  	alert(msg);
	  	window.location.href="<%=basePath%>type/toTypeList";
	  } 
	// 检查提交添加类型是否为空
	/* function checkForm(){
		var typeName = document.getElementById("typeName").value;
		if(typeName==""||typeName==null){
			alert("类型名不能为空");
			return false;
		}else{
			return true;
		}
	} */
	$(document).ready(function(){
	$("#submit").click(function(){
		window.location.href="<%=basePath%>diary/toDiaryAdd";
	});
	  });
</script>
</html>