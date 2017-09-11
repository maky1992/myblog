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

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath%>assets/js/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <![endif]-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/js/jquery.gritter/css/jquery.gritter.css" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/js/jquery.nanoscroller/nanoscroller.css" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/js/jquery.easypiechart/jquery.easy-pie-chart.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/js/bootstrap.switch/bootstrap-switch.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/js/bootstrap.datetimepicker/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/js/jquery.select2/select2.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/js/bootstrap.slider/css/slider.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/css/xcConfirm.css"/>
	<!-- Custom styles for this template -->
	<link href="<%=basePath%>assets/css/style.css" rel="stylesheet" />

</head>
<body>

  <!-- Fixed navbar -->
  <div id="head-nav" class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="fa fa-gear"></span>
        </button>
        <a class="navbar-brand" href="#"><span>Clean Zone</span></a>
      </div>
      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">Home</a></li>
          <li><a href="#about">About</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Contact <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
              <li><a href="#">Something else here</a></li>
		      <li class="dropdown-submenu"><a href="#">Sub menu</a>
		        <ul class="dropdown-menu">
		          <li><a href="#">Action</a></li>
		          <li><a href="#">Another action</a></li>
		          <li><a href="#">Something else here</a></li>
		          </ul>
		      </li>              
      		</ul>
          </li>
          <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Large menu <b class="caret"></b></a>
		      <ul class="dropdown-menu col-menu-2">
		        <li class="col-sm-6 no-padding">
		          <ul>
		          <li class="dropdown-header"><i class="fa fa-group"></i>Users</li>
		          <li><a href="#">Action</a></li>
		          <li><a href="#">Another action</a></li>
		          <li><a href="#">Something else here</a></li>
		          <li class="dropdown-header"><i class="fa fa-gear"></i>Config</li>
		          <li><a href="#">Action</a></li>
		          <li><a href="#">Another action</a></li>
		          <li><a href="#">Something else here</a></li> 
		          </ul>
		        </li>
		        <li  class="col-sm-6 no-padding">
		          <ul>
			          <li class="dropdown-header"><i class="fa fa-legal"></i>Sales</li>
			          <li><a href="#">New sale</a></li>
			          <li><a href="#">Register a product</a></li>
			          <li><a href="#">Register a client</a></li> 
			          <li><a href="#">Month sales</a></li>
			          <li><a href="#">Delivered orders</a></li>
		          </ul>
		        </li>
		      </ul>
          </li>
        </ul>
	    <ul class="nav navbar-nav navbar-right user-nav">
	      <li class="dropdown profile_menu">
	        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img alt="Avatar" src="<%=basePath%>assets/images/avatar2.jpg" /><span>${admin.adminName}</span> <b class="caret"></b></a>
	        <ul class="dropdown-menu">
	          <li><a href="#">My Account</a></li>
	          <li><a href="#">Profile</a></li>
	          <li><a href="#">Messages</a></li>
	          <li class="divider"></li>
	          <li><a href="<%=basePath%>admin/toLogin">Sign Out</a></li>
	          <li><a href="<%=basePath%>admin/toModifyPassword">Modify password</a></li>
	        </ul>
	      </li>
	    </ul>			
      </div><!--/.nav-collapse animate-collapse -->
    </div>
  </div>

  	<script src="<%=basePath%>assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>assets/js/jquery.gritter/js/jquery.gritter.js"></script>
 	<script type="text/javascript" src="<%=basePath%>assets/js/jquery.nanoscroller/jquery.nanoscroller.js"></script>
	<script type="text/javascript" src="<%=basePath%>assets/js/behaviour/general.js"></script>
 	<script src="<%=basePath%>assets/js/jquery.ui/jquery-ui.js" type="text/javascript"></script>
	<script type="text/javascript" src="<%=basePath%>assets/js/jquery.sparkline/jquery.sparkline.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>assets/js/jquery.easypiechart/jquery.easy-pie-chart.js"></script>
	<script type="text/javascript" src="<%=basePath%>assets/js/jquery.nestable/jquery.nestable.js"></script>
	<script type="text/javascript" src="<%=basePath%>assets/js/bootstrap.switch/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>assets/js/bootstrap.datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
  	<script src="<%=basePath%>assets/js/jquery.select2/select2.min.js" type="text/javascript"></script>
  	<script src="<%=basePath%>assets/js/skycons/skycons.js" type="text/javascript"></script>
  	<script src="<%=basePath%>assets/js/bootstrap.slider/js/bootstrap-slider.js" type="text/javascript"></script>
  	<script type="text/javascript" src="<%=basePath%>assets/js/jquery.datatables/jquery.datatables.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>assets/js/jquery.datatables/bootstrap-adapter/js/datatables.js"></script>



  <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript">
      $(document).ready(function(){
        //initialize the javascript
        App.init();
        App.dashBoard();        
      });
    </script>
    <script src="<%=basePath%>assets/js/behaviour/voice-commands.js"></script>
  	<script src="<%=basePath%>assets/js/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>assets/js/jquery.flot/jquery.flot.js"></script>
	<script type="text/javascript" src="<%=basePath%>assets/js/jquery.flot/jquery.flot.pie.js"></script>
	<script type="text/javascript" src="<%=basePath%>assets/js/jquery.flot/jquery.flot.resize.js"></script>
	<script type="text/javascript" src="<%=basePath%>assets/js/jquery.flot/jquery.flot.labels.js"></script>
	<script type="text/javascript" src="<%=basePath%>assets/js/alert/xcConfirm.js"></script>
  </body>

</html>
