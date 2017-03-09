<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
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
	<link href="css/font-awesome.css" rel="stylesheet"> 
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!---//webfonts--->  
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
  </head>
 
  <body id="login">
  <div class="login-logo">
    <a href="index.html"><img src="images/logo.png" alt=""/></a>
  </div>
  <h2 class="form-heading">login</h2>
  <div class="app-cam">
	  <form method="post" action="login">
		<input type="text" class="text" name="id" id="id1" placeholder="请输入账号"  onfocus="this.value = '';">
		<input type="password"  name="password" id="password" placeholder="请输入密码" onfocus="this.value = '';">
        <div align="center">
		  <label style="margin-left:30px;">
		    <input type="radio" name="RadioGroup" id="iden" value="employee" checked="checked">
		    员工</label>
		  <label style="margin-left:30px;">
		    <input type="radio" name="RadioGroup" id="iden" value="manager">
		    经理</label>
		  <label style="margin-left:30px;">
		    <input type="radio" name="RadioGroup" id="iden" value="admin">
		    管理员</label>
            </div>
<div class="submit"><input type="submit" onclick="myFunction()" value="登录"></div>
		<div class="reset"><input type="reset"  value="重置"></div>
		<ul class="new">
			<li class="new_left"><p><a href="#">忘记密码？</a></p></li>
			<li class="new_right"><p class="sign">新用户？<a href="register.html">注册</a></p></li>
			<div class="clearfix"></div>
		</ul>
	</form>
  </div>
  <div>${msg }</div>
   <div class="copy_layout login">
      <p>Copyright &copy; 2016.Company name All rights reserved.By <a href="" target="_blank" title="三组">基地十一班6组</a></p>
   </div>
   <script type="text/javascript">
   $(function(){
   		$("#id").focus();
   });
   		function myFunction(){
   			var id = document.getElementsByName("id").value;
   			var pass = document.getElementsByName("password").value;
   			var iden = document.getElementsByName("RadioGroup").value;
   			var id = document.getElementById("id1").value;
   			var pass = document.getElementById("password").value;
   		
   		
   			if(id.length()==0 || pass.length()==0)
   			{
   				alert("请将信息输入完整再登录！");
   				return;
   			}
   			
   		}
   </script>
</body>
</html>
