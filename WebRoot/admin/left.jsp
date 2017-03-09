<%@page import="org.lanqiao.entity.Admin"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
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
  
    <%
  	Admin a = (Admin)session.getAttribute("User");
  	session.setAttribute("a", a);
  
   %> 
  <body style="background-color: #000">
    	<div class="navbar-default sidebar" role="navigation">
    	<div style="background-color: #B22222;height:51px;width:100%;"><a class="navbar-brand" href="admin/index.jsp" target="_top">OOOA</a></div>
                <div class="sidebar-nav navbar-collapse" style="margin: 2em 0 0 0;">
                    <ul class="nav" id="side-menu" style="border-top:1px solid transparent;border-top-color: #000;">
                        <li>
                            <a href="admin/main.jsp" target="main"><i class="fa fa-dashboard nav_icon"></i>首页</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-pencil-square nav_icon"></i>管理中心<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=path %>/admin/ppp" target="main">个人资料维护</a>
                                </li>
                                 <li>
                                    <a href="<%=path %>/admin/managerfff" target="main">总经理信息维护</a>
                                </li>
                                <li>
                                    <a href="<%=path %>/admin/findEall" target="main">员工信息维护</a>
                                </li>
                                <li>
                                    <a href="admin/addAdmin.jsp" target="main">新增管理员</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                       
                        <li>
                            <a href="#"><i class="fa fa-phone-square nav_icon"></i>通讯录管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="common/list2" target="main">公共通讯录管理</a>
                                </li>
                                
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="front/noticeList.jsp" target="main"><i class="fa fa-file-text nav_icon"></i>公告管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                             	<li>
                                    <a href="notice/findall" target="main">公告信息维护</a>
                                </li>
                                <li>
                                    <a href="admin/addnotice.jsp" target="main">新增公告</a>
                                </li>
                                </ul>
                        </li>
                    </ul>
                </div>
                </div>
  <script src="js/bootstrap.min.js"></script>
  </body>
</html>
