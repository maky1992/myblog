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
<html>
<!-- Mirrored from condorthemes.com/cleanzone/ by HTTrack Website Copier/3.x [XR&CO'2013], Mon, 31 Mar 2014 14:31:31 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<%=basePath%>assets/images/favicon.png">

    <title>博客后台管理系统</title>
	
</head>
<body>

		<div class="cl-sidebar" data-position="right" data-step="1" data-intro="<strong>Fixed Sidebar</strong> <br/> It adjust to your needs." >
				<div class="cl-navblock">
			        <div class="menu-space">
			          <div class="content">
			            <div class="side-user">
			              <div class="avatar"><img src="<%=basePath%>assets/images/avatar1_50.jpg" alt="Avatar" /></div>
			              <div class="info">
			                <a href="#">${admin.adminName}</a>
			                <img src="<%=basePath%>assets/images/state_online.png" alt="Status" /> <span>Online</span>
			              </div>
			            </div>
			            <ul class="cl-vnavigation">
			              <li><a href="#" ><i class="fa fa-home"></i><span>文章管理</span></a>
			                <ul class="sub-menu">
			                  <li><a href="<%=basePath%>article/toArticleList">博文发布管理</a></li>
			                  <li class="type"><a href="<%=basePath%>type/toTypeList">博文分类管理</a></li>
			                </ul>
			              </li>
			              <li><a href="#"><i class="fa fa-smile-o" ></i><span>日记管理</span></a>
			              	<ul class="sub-menu">
			                  <li class="type"><a href="<%=basePath%>diary/toDiaryList">日记发布管理</a></li>
			                </ul>
			              </li>
			              <li><a href="<%=basePath%>type/toTypeList"><i class="fa fa-text-height" ></i><span>工具管理</span></a>
			              </li>
			              <li><a href="#"><i class="fa fa-table" ></i><span>评论管理</span></a>
			              </li>              
			              <li><a href="#"><i class="fa fa-list-alt  " ></i><span>留言管理</span></a></li>
			            </ul>
			          </div>
			        </div>
				</div>
	</div>




  </body>

</html>
