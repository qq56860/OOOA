
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ff.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css">
    <script src="js/bootstrap.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/npm.js"></script>
    <script src="js/jquery.tableedit.js"></script> 
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="../WebRoot (2)/css/styles.css">
<title>Document</title>


<style  type="text/css">
div.info {
	width: 242px;
	border-top: 1px solid #e4e4e4;
}

label {
	color: #333;
	font-size: 14px;
	font-family: Arial;
	text-align: center;
}

a.update {
	font-size: 13px;
	font-family: Arial;
	color: #169BD5;
}

a.update:VISITED {
	font-size: 13px;
	font-family: Arial;
	color: #169BD5;
}

a.update:HOVER {
	color: #9bd41d;
	text-shadow: 0 0 0 #fff;
}

.head {
	position: absolute;
	left: 430px;
	top: 180px;
	width: 140px;
	height: 140px;
	border: 5px solid #f2f2f2;
	border-radius: 150px;
	box-shadow: 0px 2px 5px #949494, inset 0px 2px 5px #949494;
	opacity: 1;
	filter: Alpha(opacity = 100);
}
    .div1{
    background: inherit;
    background-color: rgba(255, 255, 255, 1);
    box-sizing: border-box;
    border-width: 1px;
    border-style: solid;
    border-color: rgba(242, 242, 242, 1);
    border-radius: 5px;
    -moz-box-shadow: 0px 2px 5px rgba(204, 204, 204, 1);
    -webkit-box-shadow: 0px 2px 5px rgba(204, 204, 204, 1);
    box-shadow: 0px 2px 5px rgba(204, 204, 204, 1);
    }
    </style>
    <script src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
    function add(){
    var name = document.getElementById("name").value;
    var password = document.getElementById("password").value;
    var email = document.getElementById("email").value;
    var sex = document.getElementById("sex").value;
    var nation = document.getElementById("nation").value;
    var birth = document.getElementById("birth").value;
    var tel = document.getElementById("tel").value;
    var address = document.getElementById("address").value;
    var department = document.getElementById("department").value;
    var constellation = document.getElementById("constellation").value;
    var introduce = document.getElementById("introduce").value;
    var r = window.confirm("确定添加？");
    if(r == true){
        window.location.href="admin/addA?name="+name+"&password="+password+"&email="+email+"&sex="+sex+"&nation="
        +nation+"&birth="+birth+"&tel="+tel+"&address="+address+"&department="+department+"&constellation="+constellation+"&introduce="
        +introduce;
    }
    }
    $(function(){

	// 变色效果
	$("input").focus(function(){
		$(this).css("background-color","#FFFFCC");
	});
	$("input").blur(function(){
		$(this).css("background-color","#FFFFFF");
	});
	
	// 验证
	$("#password").blur(function(){
		// 获取值
		var password = $(this).val();
		
		$.ajax({
			url:"admin.do",
			data:{"method":"CheckPassword", "password":password},
			type:"GET",		//请求方法
			datatype:"json",	//服务端返回数据格式
			success:function(data){	// data 来自于服务端的数据
				//（{'rs':1}）
				var data=eval("("+data+")");//转换为json对象
			    
				if (data.rs == 0)
				{
					$("#password-error").text("密码长度不能小于8位").css({"color":"red"});
				}
				else if(data.rs == 1){
					$("#password-error").text("正确").css({"color":"green"});
				}
			}
		});
		
	});
$("#email").blur(function(){
		// 获取值
		var email = $(this).val();
		
		$.ajax({
			url:"admin.do",
			data:{"method":"CheckEmail", "email":email},
			type:"GET",		//请求方法
			datatype:"json",	//服务端返回数据格式
			success:function(data){	// data 来自于服务端的数据
				//（{'rs':1}）
				var data=eval("("+data+")");//转换为json对象
			    
				if (data.rs == 0)
				{
					$("#email-error").text("邮箱格式不合法").css({"color":"red"});
				}
				else if(data.rs == 1){
					$("#email-error").text("正确").css({"color":"green"});
				}
			}
		});
		
	});
	$("#tel").blur(function(){
		// 获取值
		var tel = $(this).val();
		
		$.ajax({
			url:"admin.do",
			data:{"method":"CheckTel", "tel":tel},
			type:"GET",		//请求方法
			datatype:"json",	//服务端返回数据格式
			success:function(data){	// data 来自于服务端的数据
				//（{'rs':1}）
				var data=eval("("+data+")");//转换为json对象
			    
				if (data.rs == 0)
				{
					$("#tel-error").text("手机号格式不合法").css({"color":"red"});
				}
				else if(data.rs == 1){
					$("#tel-error").text("正确").css({"color":"green"});
				}
			}
		});
		
	});
});


function doSubmit(){
	alert("sdfsdfsdf");
	
	document.myform.submit();
}
    
    </script>
</head>
  <body  background="1.jpg">
  <div style="padding-left:100px">
         <div class="div1" style="height:830px; width:900px;">
<div style="position:relative;left:-300px;top:-100px">
	<div style="margin-left:100px">
		<!-- 头像层 -->
		<div class="head"></div>
		<!-- 基本信息层 -->
		<div class="personal_info"
			style="position:absolute;left:636px;top:180px;width:300px;height:150px">
			<label style="position:absolute;left:36;top:30px">姓名 ：</label><input
				class="dt" type="text" name="name" id="name" value="" 
				style="position:absolute;left:78px;top:30px; border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;"" >
			<label style="position:absolute;left:36;top:64px">密码 ：</label><input
				class="dt" type="password" name="password" id="password" value=""
				style="position:absolute;left:78px;top:64px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
     <div id='password-error' class="error-tip" style="position:absolute;left:50px;top:100px; color:red">*密码不能为空</div>
		</div>
		<!-- 邮箱 -->
		<div class="personal_info"
			style="position:absolute;left:430px;top:365px;width:506px;height:45px">
			<label style="position: absolute; left: 18px; top: 12px">邮箱 :</label><input
				class="dt" type="text" name="email" id="email" value=""
				style="position:absolute;left:140px;top:11px;width:227px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
     <div id='email-error' class="error-tip" style="position:absolute;left:14px;top:50px;color:red">*邮箱不能为空</div>
		</div>
		<!-- 性别等项 -->
		<div class="personal_info"
			style="position:absolute;left:430px;top:445px;width:506px;height:85px">
			<label style="position:absolute;left:14px;top:16px">性别 ：</label><input
				class="dt" type="text" name="sex" id="sex" value="" 
				style="position:absolute;left:57px;top:16px;width:177px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			<label style="position:absolute;left:264px;top:16px">民族 ：</label><input
				class="dt" type="text" name="nation" id="nation" value="" 
				style="position:absolute;left:307px;top:16px;width:177px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			<label style="position:absolute;left:14px;top:45px">出生日期 ：</label><input
				class="dt" type="text" name="birth" id="birth" value="" 
				style="position:absolute;left:85px;top:45px;width:149px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			<label style="position:absolute;left:264px;top:45px">联系方式 :</label><input
				class="dt" type="text" name="tel" id="tel" value=""
				style="position: absolute; left: 340px; top: 47px; width: 121px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
     <div id='tel-error' class="error-tip" style="position:absolute;left:340px;top:70px;color:red">*联系方式不能为空</div>
		</div>

<!-- 学历等项 -->
		<div class="personal_info"
			style="position: absolute; left: 430px; top: 565px; width: 511px; height: 120px">
			<p>
				<label style="position:absolute;left:14px;top:16px">家庭住址 ：</label> <input
					class="dt" type="text" name="address" id="address" value="" 
					style="position: absolute; left: 100px; top: 16px; width: 325px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			</p>
			<p>
				
				<br> <label style="position:absolute;left:14px;top:45px">部门：
					：</label> <input class="dt" type="text" name="department" id="department" value=""
					style="position:absolute;left:57px;top:45px;width:177px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
				<label style="position:absolute;left:264px;top:45px">星座 ：</label>
			<input
					class="dt" type="text" name="constellation" id="constellation" value="" 
					style="position: absolute; left: 309px; top: 48px; width: 177px; border: none; outline: none;">
			</p>
		</div>
		<!-- 个人简介 -->
		<div class="personal_info"
			style="position: absolute; left: 430px; top: 720px; width: 531px; height: 165px">
			<label style="position:absolute;left:14px;top:22px">个人简介 ：</label>
			<textarea class="dt" name="introduce" id="introduce" rows="10" cols="40"
				style="position:absolute;left:85px;top:18px;width:395px;height:120px;line-height:30px;text-align:left;overflow:hidden ;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;"> </textarea>
		</div>
		<!-- 水平线 -->
		<div class="info" style="position:absolute;left:672px;top:232px;"></div>
		<div class="info" style="position:absolute;left:672px;top:266px;"></div>
		<div class="info"
			style="position:absolute;left:539px;top:398px;width:289px"></div>

		<div class="info"
			style="position:absolute;left:444px;top:483px;width:220px"></div>
		<div class="info"
			style="position:absolute;left:694px;top:483px;width:220px"></div>
		<div class="info"
			style="position:absolute;left:444px;top:512px;width:220px"></div>
		<div class="info"
			style="position:absolute;left:694px;top:512px;width:220px"></div>
		<div class="info"
			style="position:absolute;left:444px;top:603px;width:220px"></div>
		<div class="info"
			style="position:absolute;left:444px;top:632px;width:220px"></div>
		<div class="info"
			style="position:absolute;left:694px;top:632px;width:220px"></div>
		<div class="info"
			style="position:absolute;left:444px;top:766px;width:470px"></div>
		<div class="info"
			style="position:absolute;left:444px;top:796px;width:470px"></div>
		<div class="info"
			style="position:absolute;left:444px;top:826px;width:470px"></div>
		<div class="info"
			style="position:absolute;left:444px;top:856px;width:470px"></div>
		<div class="btn" id="btn"></div>
	</div>
    </div>
    
      <button class="btn btn-info"  style="position:absolute;right:1000px;top:780px" onclick="add()"><i class="glyphicon glyphicon-plus"></i> 添加</button>
    </div>
   
    </div>
</body>

</html>
