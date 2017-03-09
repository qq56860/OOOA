<%@page import="org.lanqiao.entity.Manager"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  	Manager m = (Manager)session.getAttribute("User");
  	session.setAttribute("m", m);
   %>
  
  <body style="background-color: #000">
    	<div class="navbar-default sidebar" role="navigation">
    	<div style="background-color: #B22222;height:51px;width:100%;"><a class="navbar-brand" href="mfront/index.jsp" target="_top">OOOA</a></div>
                <div class="sidebar-nav navbar-collapse" style="margin: 2em 0 0 0;">
                    <ul class="nav" id="side-menu" style="border-top:1px solid transparent;border-top-color: #000;">
                        <li>
                            <a href="mfront/index.jsp" target="_top"><i class="fa fa-dashboard nav_icon"></i>首页</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-pencil-square nav_icon"></i>信息维护<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="mfront/personalInfo.jsp" target="main">个人资料维护</a>
                                </li>
                                <li>
                                    <a href="employee/findByDe" target="main">员工维护</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-calendar nav_icon"></i>个人日程<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="mfront/schedule.jsp" target="main">显示日程</a>
                                </li>
                                <li>
                                    <a href="mfront/scheduleMa.jsp" target="main">日程管理</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-phone-square nav_icon"></i>通讯录<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="common/list" target="main">查看公共通讯录</a>
                                </li>
                            	<li>
                                    <a href="personal/list2?id=${m.mId }&from=0"target="main">显示个人通信录</a>
                                </li>
                                <li>
                                    <a href="personal/list3?id=${m.mId}&from=1" target="main">个人通信录管理</a>
                                </li>
                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="widgets.html"><i class="fa fa-envelope nav_icon"></i>邮件中心<span class="fa arrow"></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="mfront/sendEmail.jsp" target="main">发邮件</a>
                                </li>
                                <li>
                                    <a href="email/msend?id=${m.mId }" target="main">收件箱</a>
                                </li>
                                
                                <%-- <li>
                                    <a href="email/AddRubbis?id=${m.mId }" target="main">垃圾箱</a>
                                </li> --%>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-file-text nav_icon"></i>公告中心<span class="fa arrow"></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="mfront/addNotice.jsp" target="main">公告管理</a>
                                </li>
                                <li>
                                    <a href="notice/findByPageM" target="main">查看公告</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                </div>
  <script src="js/bootstrap.min.js"></script>
  </body>
</html>
