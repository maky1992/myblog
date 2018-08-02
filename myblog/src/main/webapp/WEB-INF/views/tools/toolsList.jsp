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
					  <li class="active">工具管理</li>
					</ol> 
				</div>		
			    
			    <div class="row">
					<div class="col-md-12">
						<div class="block-flat">
							<div class="header">							
								<h3>工具管理</h3>
							</div>
							<div class="content">
								<a href="<%=basePath%>tools/toAddTools"><button class="btn btn-primary">添加工具</button></a>	
								<div class="table-responsive">
									<table class="table table-bordered" id="datatable-icons" >
										<thead>
											<tr>
												<th>工具ID</th>
												<th>工具名称</th>
												<th>工具连接</th>
												<th>工具密码</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${toolList }" var="tool">
												<tr class="even gradeC">
												<td class="center">${tool.toolId }</td>
												<td>${tool.toolName }</td>
												<td>${tool.toolLink }</td>
												<td>${tool.toolPassword }</td>
												<td class="center">
													<a class="btn btn-default btn-xs" href="<%=basePath%>tools/searchTool?toolId=${tool.toolId}&flag=details" data-original-title="Open" data-toggle="tooltip"><i class="fa fa-file"></i></a>
													<a class="btn btn-primary btn-xs" href="<%=basePath%>tools/searchTool?toolId=${tool.toolId}&flag=update" data-original-title="Edit" data-toggle="tooltip"><i class="fa fa-pencil"></i></a>
													<a class="btn btn-danger btn-xs" href="<%=basePath%>tools/deleteTool?toolId=${tool.toolId}"  data-original-title="Remove" data-toggle="tooltip"><i class="fa fa-times"></i></a>
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

	
	$(document).ready(function(){
	  //initialize the javascript
	  
	  App.dataTables();
	  	
	  //Horizontal Icons dataTable
	  $('#datatable-icons').dataTable();
	});
	
	
	  
</script>
</html>