<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
<script type="text/javascript" src="<%=basePath%>assets/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
		
</script>
</head>
<body>
	<jsp:include page="../admin/top.jsp" flush="false"></jsp:include>
	<div id="cl-wrapper" class="fixed-menu">

		<jsp:include page="../admin/left.jsp" flush="false"></jsp:include>
		<div class="container-fluid" id="pcont">
			<div class="page-head">

				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="<%=basePath%>tools/toToolsList">工具管理</a></li>
					<li class="active">工具详情</li>
				</ol>

				<div class="row">
					<div class="col-md-12">
						<div class="block-flat">
							<div class="header">
							</div>
							<div class="content">
								<form action = "<%=basePath%>tools/updateTool" method = "post" class="form-horizontal" role="form" >
									<h4 style="color:red:">${msg }</h4>
									<input type="hidden" name="toolId" value="${softTool.toolId }"/>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-1 control-label">工具名称</label>
										<div class="col-sm-7">
											<input type="text"  name = "toolName" class="form-control"  
												id="toolName" value="${softTool.toolName }">  
										</div>
									</div>
									
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-1 control-label">工具链接</label>
										<div class="col-sm-7">
											<input type="text"  name = "toolLink" class="form-control"  
												id="toolLink" value="${softTool.toolLink }">  
										</div>
									</div>
									
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-1 control-label">链接密码</label>
										<div class="col-sm-7">
											<input type="text"  name = "toolPassword" class="form-control"  
												id="toolPassword" value="${softTool.toolPassword }">  
										</div>
									</div>

									<div class="form-group" >
										<div class="col-sm-offset-1 col-sm-11" style="padding-left:230px">
										<c:if test="${flag eq 'update' }">
											<button type="submit" id="confirm" class="btn btn-primary" onclick="return checkForm()">确认</button>
											<button type="reset"class="btn btn-primary">重置</button>
										</c:if>
										</div>
									</div>
								</form>
										<c:if test="${flag eq 'details' }">
											<a href="<%=basePath%>tools/toToolsList"><button class="btn btn-primary" style="margin-left:350px;">Back</button></a>
										</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>