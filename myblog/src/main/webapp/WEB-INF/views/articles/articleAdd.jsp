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
<script type="text/javascript">
		 $(function() {
		       /*  var frm=$('#itemForm').form(); */
		        <!--超链接绑定鼠标单击事件 -->
		        $("#confirm").click(function() {
		            <!--获取编辑器中输入的内容赋值给textarea标签 -->
		            $('#artContent').val(editor.getData());
		            /* frm.setData();
		            frm.ajaxForm(options); */
		           /*  if(frm.valid()){
		                form.submit();
		            } */
		        });
		        <!--这句就替代了下面的js :CKEDITOR.replace('opinion') -->
		        editor=ckeditor('artContent');
		    });
			
		 
	</script>
	<script type="text/javascript" src="<%=basePath%>assets/js/ckeditor/ckeditor.js"></script>
	<link href="<%=basePath%>assets/js/ckeditor/plugins/codesnippet/lib/highlight/styles/default.css" rel="stylesheet">
	<script src="<%=basePath%>assets/js/ckeditor/plugins/codesnippet/lib/highlight/highlight.pack.js"></script>
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
					<li><a href="<%=basePath%>article/toArticleList">博文发布管理</a></li>
					<li class="active">添加博文</li>
				</ol>

				<div class="row">
					<div class="col-md-12">
						<div class="block-flat">
							<div class="header">
							</div>
							<div class="content">
								<form action = "<%=basePath%>article/addArticle" method = "post" class="form-horizontal" role="form" data-parsley-validate
									novalidate>
									<h4 style="color:red:">${msg }</h4>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-1 control-label">博文标题</label>
										<div class="col-sm-7">
											<input type="text"  name = "artTitle" class="form-control" value="" 
												id="artTitle" >  
										</div>
									</div>
									<div class="form-group">
										<label for="inputEmail3" class="col-sm-1 control-label">博文分类</label>
										<div class="col-sm-7">
											<select name = "typeId" id = "typeId" class="form-control">
											<c:forEach items="${typesList }" var="types">
											<option value="${types.typeId }" >${types.typeName}</option>
											</c:forEach>
											</select>
										</div>
									</div>
									
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-1 control-label">是否推荐</label>
										<div class="col-sm-7">
											<select name = "artIsrecommend" id = "artIsrecommend" class="form-control">
											<option value="0">不推荐</option>
											<option value="1">推荐</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-1 control-label">关键字</label>
										<div class="col-sm-7">
											<input type="text"  name = "artKeyword" class="form-control" value="" 
												id="artKeyword" >  
										</div>
									</div>
									
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-1 control-label">封面</label>
										<div class="col-sm-7">
											 <input type="file"name="artPicture"/><br>
										</div>
									</div>
									
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-1 control-label">博文内容</label>
										<div class="col-sm-11">
											<textarea  name = "artContent" class="form-control"  cols = "50"
												id="artContent" >   
											</textarea>
											<script type="text/javascript">CKEDITOR.replace('artContent')</script>  
										</div>
									</div>

									<div class="form-group" >
										<div class="col-sm-offset-1 col-sm-11" align = "center">
										<button type="submit" class="btn btn-primary" onclick="return checkForm()">Confirm</button>
										<button type="reset" class="btn btn-default" >Reset</button> 
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