<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 	<!-- Bootstrap Core CSS -->
	<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
	<!-- Custom CSS -->
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<!-- Graph CSS -->
	<link href="css/lines.css" rel='stylesheet' type='text/css' />
	<link href="css/font-awesome.css" rel="stylesheet"> 
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script> 
	<!-- Nav CSS -->
	<link href="css/custom.css" rel="stylesheet">
	<!-- Metis Menu Plugin JavaScript -->
	<script src="js/metisMenu.min.js"></script>
	<script src="js/custom.js"></script>
  </head>
  <body>
  <div id="wrapper">
    <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-nav navbar-right">
        
          <li class="dropdown">
              <a href="#" class="dropdown-toggle avatar" data-toggle="dropdown">
               <span style="color: white">你好，管理员：${User.aName }</span>
              <img src="images/1.png"><span class="badge"></span></a>
              <ul class="dropdown-menu">
            <li class="dropdown-menu-header text-center">
              <strong>功能</strong>
            </li>
            <li class="m_2"><a href="#"><i class="fa fa-bell-o"></i> 修改个人资料 <span class="label label-info"></span></a></li>
           
                        <li class="m_2"><a href="/OOOA/login.jsp" target="_top"><i class="fa fa-wrench"></i> 注销</a></li>
              </ul>
            </li>
      </ul>
      <!-- <form class="navbar-form navbar-right">
              <input type="text" class="form-control" value="查询..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '查询...';}">
      </form> -->
            
    </nav>
    </div>
    <iframe src="admin/main.jsp" name="main" width="100%" height="600px" scrolling="auto" style="margin-top:52px;border: 0; "></iframe>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
