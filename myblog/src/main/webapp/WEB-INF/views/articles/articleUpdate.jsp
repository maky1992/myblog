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
<script type="text/javascript" src="<%=basePath%>assets/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	$(function(){
		CKEDITOR.replace('artContent');
		$("#confirm").click(function(){
			$('#artContent').val(editor.getData());
		});
	});

</script>
<script type="text/javascript">	
function checkFlag(){
	var flag = "";
	flag = "${flag}";
	if(flag == "details"){
		document.getElementById("artId").disabled=true;
		document.getElementById("artTitle").disabled=true;
		document.getElementById("typeId").disabled=true;
		document.getElementById("artIsrecommend").disabled=true;
		document.getElementById("artKeyword").disabled=true;
		document.getElementById("artPicture").disabled=true;
		document.getElementById("artContent").disabled=true;
		document.getElementById("submit").style.display = 'none';
		document.getElementById("artPicture").style.display = 'none';
		}
	 else if(flag == "update"){
	} 
}
//页面返回按钮跳转
function goBack(){
	window.location.href="<%=basePath%>article/toArticleList";
}
//检查提交添加类型是否为空
function checkForm(){
	var artTitle = document.getElementById("artTitle").value;
	var artContent = document.getElementById("artContent").value;
	if(artTitle==""||artTitle==null){
		alert("博文标题不能为空");
		return false;
	}else{
	return true;
	}
}
</script>
</head>
<body onload="checkFlag();">
	<jsp:include page="../admin/top.jsp" flush="false"></jsp:include>
	<div id="cl-wrapper" class="fixed-menu">

		<jsp:include page="../admin/left.jsp" flush="false"></jsp:include>
		<div class="container-fluid" id="pcont">
			<div class="page-head">

				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
					<li><a href="#">文章管理</a></li>
					<li><a href="<%=basePath%>article/toArticleList">博文发布管理</a></li>
					<li class="active">添加博文</li>
				</ol>

				<div class="row">
					<div class="col-md-12">
						<div class="block-flat">
							<div class="header">
							</div>
							<div class="content">
								<form action = "<%=basePath%>article/updateArticles" method = "post" class="form-horizontal" enctype="multipart/form-data" role="form" data-parsley-validate
									novalidate>
									<h4 style="color:red:">${msg }</h4>
									<div class="form-group">
										<div class="col-sm-7">
											<input type="hidden"  name = "artId" class="form-control" value="${article.artId }" 
												id="artId" >  
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-1 control-label">博文标题</label>
										<div class="col-sm-7">
											<input type="text"  name = "artTitle" class="form-control" value="${article.artTitle }" 
												id="artTitle" >  
										</div>
									</div>
									<div class="form-group">
										<label for="inputEmail3" class="col-sm-1 control-label">博文分类</label>
										<div class="col-sm-7">
											<select name = "typeId" id = "typeId" class="form-control">
												<c:forEach items="${typesList }" var="types">
													<c:if test="${types.typeId eq article.typeId }">
														<option value="${types.typeId }" selected="selected">${types.typeName}</option>
													</c:if>
													<option value="${types.typeId }">${types.typeName}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-1 control-label">关键字</label>
										<div class="col-sm-7">
											<input type="text"  name = "artKeyword" class="form-control" value="${article.artKeyword }" 
												id="artKeyword" >  
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-1 control-label">是否推荐</label>
										<div class="col-sm-7">
											<select name = "artIsrecommend" id = "artIsrecommend" class="form-control">
												<c:choose>
													<c:when test="${article.artIsrecommend==\"1\"}">
													<option value="1" selected="selected">推荐</option>
													<option value="0">不推荐</option>		
													</c:when>
													<c:otherwise>
													<option value="1">推荐</option>
													<option value="0" selected="selected">不推荐</option>	
													</c:otherwise>
												</c:choose>
											</select>
											
										</div>
									</div>
									
									
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-1 control-label">封面</label>
										<div class="col-sm-7">
											 <input type="file" id = "artPicture" value = "${article.artPicture}" name="file"/><br>
											<img src="<%=basePath%>picture/${article.artPicture}" width="80" height="50"> 
										</div>
									</div>
									
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-1 control-label">博文内容</label>
										<div class="col-sm-11">
											<textarea  name = "artContent" class="form-control"  cols = "50"
												id="artContent" >${artContent }   
											</textarea>
											
										</div>
									</div>

									<div class="form-group" >
										<div class="col-sm-offset-1 col-sm-11" align = "center">
										<button type="submit" id = "submit" class="btn btn-primary" onclick="return checkForm()">Confirm</button>
										<button type="reset" class="btn btn-default"  onclick="goBack()">Back</button> 
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


</html>