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
	<jsp:include page="top.jsp" flush="false" />
		<div id="cl-wrapper" class="fixed-menu">
			<jsp:include page="left.jsp" flush="false" />
			<div class="container-fluid" id="pcont">
				<div class="page-head">
					
					<ol class="breadcrumb">
					  <li><a href="#">Home</a></li>
					 <!--  <li><a href="#">Category</a></li>
					  <li class="active">Sub Category</li> -->
					</ol> 
				</div>		
			    <div class="cl-mcont">
			      <h3 class="text-center">欢迎进博客后台管理系统！</h3>
			    </div>
			</div> 
		
		</div>
</body>

</html>