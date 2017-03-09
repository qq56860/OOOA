
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link rel="stylesheet" type="text/css" href="../css/styles.css">
<meta charset="UTF-8">
<title>Document</title>
 <style type="text/css">
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
body{
	background-repeat:no-repeat;
	background-size:cover;
	}

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
  
  
img{
	position: absolute;
	width: 140px;
	height: 140px;
	border-radius: 150px;	
}
</style>

</head>
<script src="/OA/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	$("#upload").hide();
	$("#reset").hide();
	$("#updatephoto").click(function(){
		
		$("#upload").show();
		$("#reset").show();
		});
	});
</script>



<body>
<div style="padding-left:100px;padding-top:20px">	
<div class="div1" style="height:930px;width:900px; z-index:0">
<div style="position:relative;left:-300px;top:-100px">
	<div style="margin-left:100px">
		<!-- 头像层 -->
		<div class="head"><img src="${user.getImg() }" style="width: 100%;height: 100%;"/>
			<div style="margin-left: 35px;">
				<form  style="margin-top: 150px;" action="admin/photo?aid=${User.aId}" enctype="multipart/form-data" method="post"> 
          	 	<input type="button" id="updatephoto" value="修改头像">
          	 	<input id="upload" type="file" name="file" value="">    
            	<input type="submit" id="reset" value="确认上传"> 
      			</form>
			</div>
		</div>
		<!-- 基本信息层 -->
		<div class="personal_info"
			style="position:absolute;left:636px;top:180px;width:300px;height:150px">
			<label style="position:absolute;left:36;top:30px">姓名 ：</label><input
				class="dt" type="text" name="name" value="${user.aName}" 	
				style="position:absolute;left:78px;top:30px; border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;" >
			<label style="position:absolute;left:36;top:64px">密码 ：</label><input
				class="dt" type="text" name="password" value="${user.aPassword}"
				style="position:absolute;left:78px;top:64px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			<a class="update" style="position: absolute; left: 265px; top: 65px"
				href="#">修改</a>
		</div>

		<!-- 邮箱 -->
		<div class="personal_info"
			style="position: absolute; left: 430px; top: 422px; width: 506px; height: 45px">
		  <label style="position: absolute; left: 14px; top: 12px">邮箱 ：</label><input
				class="dt" type="text" name="email" value="${user.aEmail}"
				style="position: absolute; left: 69px; top: 13px; width: 227px; border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: none;">
			<a class="update" style="position: absolute; left: 328px; top: 13px"
				href="#">修改</a>
		</div>
		<!-- 性别等项 -->
		<div class="personal_info"
			style="position:absolute;left:430px;top:475px;width:506px;height:85px">
			<label style="position:absolute;left:14px;top:16px">性别 ：</label><input
				class="dt" type="text" name="sex" value="${user.aSex}"
				style="position:absolute;left:57px;top:16px;width:177px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			<label style="position:absolute;left:264px;top:16px">民族 ：</label><input
				class="dt" type="text" name="nation" value="${user.aNation}"
				style="position:absolute;left:307px;top:16px;width:177px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			<label style="position:absolute;left:14px;top:45px">出生日期 ：</label><input
				class="dt" type="text" name="birth" value="${user.aBirth}"
				style="position:absolute;left:85px;top:45px;width:149px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			<label style="position:absolute;left:264px;top:45px">联系方式 ：</label><input
				class="dt" type="text" name="tel" value="${user.aTel}"
				style="position: absolute; left: 340px; top: 47px; width: 121px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			<a class="update" style="position: absolute; left: 478px; top: 47px"
				href="#">修改</a>
		</div>
		<!-- 学历等项 -->
		<div class="personal_info"
			style="position: absolute; left: 430px; top: 565px; width: 511px; height: 120px">
		  <p>
				<label style="position:absolute;left:14px;top:16px">家庭住址 ：</label> <input
					class="dt" type="text" name="diploma" value="${user.aAddress}"
					style="position: absolute; left: 88px; top: 19px; width: 264px; border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: none;">
				<a class="update"
					style="position: absolute; left: 358px; top: 20px; width: 45px;"
					href="#">修改</a></p>
		  <p>
				
				<br> <label style="position:absolute;left:14px;top:45px">职位
					：</label> <input class="dt" type="text" name="college" value="${user.aDepartment}"
					style="position:absolute;left:57px;top:45px;width:177px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			<label style="position:absolute;left:264px;top:45px">星座 ：</label>
			<input
					class="dt" type="text" name="college2" value="${user.aConstellation}"
					style="position: absolute; left: 309px; top: 48px; width: 177px; border: none; outline: none;">
		  </p>
		</div>
		<!-- 个人简介 -->
		<div class="personal_info"
			style="position: absolute; left: 428px; top: 644px; width: 514px; height: 265px">
			<label style="position:absolute;left:14px;top:22px">个人简介 ：</label>
			<textarea class="dt" rows="10" cols="40"
				style="position:absolute;left:85px;top:18px;width:395px;height:120px;line-height:30px;text-align:left;overflow:hidden ;border:none;">${user.aIntroduce}</textarea>		
			<a class="update" style="position: absolute; left: 448px; top: 22px"
				href="#">修改</a>
		</div>
		<!-- 水平线 -->
		<div class="info" style="position:absolute;left:672px;top:232px;"></div>
		<div class="info" style="position: absolute; left: 671px; top: 267px;"></div>
		<div class="info" style="position: absolute; left: 448px; top: 461px; width: 289px"></div>

		<div class="info"
			style="position: absolute; left: 445px; top: 512px; width: 220px"></div>
		<div class="info"
			style="position: absolute; left: 695px; top: 512px; width: 220px"></div>
		<div class="info"
			style="position: absolute; left: 445px; top: 539px; width: 220px"></div>
		<div class="info"
			style="position: absolute; left: 695px; top: 541px; width: 220px"></div>

		<div class="info"
			style="position: absolute; left: 442px; top: 604px; width: 399px; height: 0px;"></div>
		<div class="info"
			style="position:absolute;left:444px;top:632px;width:220px"></div>
		<div class="info"
			style="position:absolute;left:694px;top:632px;width:220px"></div>
		<div class="info"
			style="position: absolute; left: 445px; top: 689px; width: 470px"></div>
		<div class="info"
			style="position: absolute; left: 443px; top: 711px; width: 470px"></div>
		<div class="info"
			style="position: absolute; left: 444px; top: 737px; width: 470px"></div>
		<div class="info"
			style="position: absolute; left: 444px; top: 763px; width: 470px"></div>
	  <div class="btn" id="btn"></div>     </div>
	</div>
	</div>
    <a class="update"
					style="position: absolute; left: 681px; top: 549px; width: 45px;"
					href="#">修改</a></div>

</body>
</html>
