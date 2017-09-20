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
<body onload = "msgConfirm()">
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
			    <div class="cl-mcont" align = "center">
			    <h4 class="text-center">修改用户密码</h4>
			      <form class="text-center" action = "<%=basePath%>admin/modifyPassword" method = "post">
			   &nbsp&nbsp
			      新密码  ：<input id= "password" type = "password" name = "adminPassword" ><br><br>
			      密码确认  ：<input id= "passwordconfirm" type = "password" name = "passwordconfirm" ><br><br>
			      <input type = "submit" value = "提交" onclick = "return chenkPassword()" >
			      &nbsp&nbsp&nbsp&nbsp&nbsp
			      <input type = "reset" value = "重置">
			      </form>
			    </div>
			</div> 
		
		</div>
</body>
<script type="text/javascript">
	function msgConfirm(){
		var msg = "";
		  msg="${msg}";
		if(msg != null && msg != ""){
			alert(msg);
			window.location.href="<%=basePath%>admin/toLogin";
		}
	}
 	function chenkPassword(){
		var password = document.getElementById("password").value;
		var passwordconfirm = document.getElementById("passwordconfirm").value;
		if(password == "" ||passwordconfirm == ""){
			alert("输入密码不能为空！");
			return false;
		}else if(password !=passwordconfirm){
			alert("两次输入密码不一致！");
			return false;
		} else{
			return true;
		}
 	}
</script>
</html>