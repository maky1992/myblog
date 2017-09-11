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
<!-- Mirrored from condorthemes.com/cleanzone/pages-login.html by HTTrack Website Copier/3.x [XR&CO'2013], Mon, 31 Mar 2014 14:37:32 GMT -->
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="shortcut icon" href="<%=basePath%>assets/images/favicon.png">

	<title>枫叶博客登录页面</title>

	<!-- Bootstrap core CSS -->
	<link href="<%=basePath%>assets/js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">

	<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
	
	<!-- Custom styles for this template -->
	<link href="<%=basePath%>assets/css/style.css" rel="stylesheet" />	

</head>

<body class="texture">

<div id="cl-wrapper" class="login-container">

	<div class="middle-login">
		<div class="block-flat">
			<div class="header">							
				<h3 class="text-center"><img class="logo-img" src="<%=basePath%>assets/images/logo.png" alt="logo"/>枫叶博客后台管理系统</h3>
			</div>
			<div>
				<form style="margin-bottom: 0px !important;" class="form-horizontal" action="<%=basePath%>admin/login" method="post">
					<div class="content">
						<h4 class="title">${error }</h4>
							<div class="form-group">
								<div class="col-sm-12">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input type="text" placeholder="Username" name="adminName" id="username" value="maky" class="form-control">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-lock"></i></span>
										<input type="password" placeholder="Password" name="adminPassword" id="password" class="form-control">
									</div>
								</div>
							</div>
							
					</div>
					<div class="foot">
						<button class="btn btn-default" data-dismiss="modal" type="button">注册</button>
						<button class="btn btn-primary" data-dismiss="modal" type="submit">登录</button>
					</div>
				</form>
			</div>
		</div>
		
	</div> 
	
</div>

<script src="<%=basePath%>assets/js/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath%>assets/js/behaviour/general.js"></script>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
  <script src="<%=basePath%>assets/js/behaviour/voice-commands.js"></script>
  <script src="<%=basePath%>assets/js/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/js/jquery.flot/jquery.flot.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/js/jquery.flot/jquery.flot.pie.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/js/jquery.flot/jquery.flot.resize.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/js/jquery.flot/jquery.flot.labels.js"></script>
</body>

<!-- Mirrored from condorthemes.com/cleanzone/pages-login.html by HTTrack Website Copier/3.x [XR&CO'2013], Mon, 31 Mar 2014 14:37:32 GMT -->
</html>
