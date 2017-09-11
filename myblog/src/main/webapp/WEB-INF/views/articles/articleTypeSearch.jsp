<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


</head>
<body>
	<jsp:include page="../admin/top.jsp" flush="false"></jsp:include>
	<div id="cl-wrapper" class="fixed-menu">

		<jsp:include page="../admin/left.jsp" flush="false"></jsp:include>
		<div class="container-fluid" id="pcont">
			<div class="page-head">

				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="#">文章管理</a></li>
					<li class="active">博文分类管理</li>
				</ol>

				<div class="row">
					<div class="col-md-12">
						<div class="block-flat">
							<div class="header">
								<h3>Horizontal Form</h3>
							</div>
							<div class="content">
								<form action = "<%=basePath%>type/toTypeList" class="form-horizontal" role="form" data-parsley-validate
									novalidate>
									<div class="form-group">
										<label for="inputEmail3" class="col-sm-3 control-label">TypeId</label>
										<div class="col-sm-7">
											<input type="test" required parsley-type="email" value="${type.typeId}" readonly
												class="form-control" id="inputEmail3" >
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-3 control-label">TypeName</label>
										<div class="col-sm-7">
											<input type="test" required class="form-control" value="${type.typeName}" readonly
												id="inputPassword3" >  
										</div>
									</div>

									<div class="form-group" >
										<div class="col-sm-offset-2 col-sm-10" align = "center">
											<button type="submit" class="btn btn-primary">Back</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>

<script type="text/javascript">
	
</script>
</html>