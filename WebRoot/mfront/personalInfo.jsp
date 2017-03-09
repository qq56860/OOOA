<%@page import="org.lanqiao.biz.impl.ManagerBizImpl"%>
<%@page import="org.lanqiao.biz.ManagerBiz"%>
<%@page import="org.lanqiao.entity.Manager"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="../WebRoot (2)/css/styles.css">
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

<%	
	ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	ManagerBiz ebiz = (ManagerBiz)ac.getBean("managerBiz");
	/* ManagerBiz ebiz = new ManagerBizImpl(); */
	Manager manager = (Manager)session.getAttribute("User");
	Manager u  = (Manager)request.getAttribute("user");
	Manager m = ebiz.getOne(manager.getmId());
	if(u==null)
	{
			
		if(m.getImg()==null){
			String img = "";;
			if(m.getmSex().equals("男")){img = "/OA/images/3.png";}
			else{ img = "/OA/images/1.png";}
			m.setImg(img);
			pageContext.setAttribute("uu", m);
		}else{
			pageContext.setAttribute("uu", m);
		}
	}else{
		pageContext.setAttribute("uu", u);
	}
	System.out.println(m);
	
 %>
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
	
	function updatepass(id){
		var pass = document.getElementById("pass").value;
		var checkpass = document.getElementById("checkpass").value;
		if(pass==checkpass){
			window.location.href="manager/updatepass?id="+id+"&pass="+pass;
		}
		else{
			alert("前后密码不一致！");return;
		}
	}
	function updateinfo(id){
		var email = document.getElementById("email").value;
		var sex = document.getElementById("sex").value;
		var nation = document.getElementById("nation").value;
		var birth = document.getElementById("birth").value;
		var tel = document.getElementById("tel").value;
		var zhiwei = document.getElementById("zhiwei").value;
		var xinzuo = document.getElementById("xinzuo").value;
		var address = document.getElementById("address").value;
		if(email==null||sex==null||nation==null||birth==null||tel==null||zhiwei==null||xinzuo==null||address==null){
			alert("请将信息填写完整！");
		}
		window.location.href="manager/updateinfo?id="+id+"&email="+email+"&sex="+sex+"&nation="+nation+"&birth="+birth+"&tel="+tel+"&zhiwei="+zhiwei+"&xinzuo="+xinzuo+"&address="+address;
	}
	function updateindroce(id){
		var indroce = document.getElementById("indroce").value;
		if(indroce==null){
			alert("信息为空");
		}else{
			window.location.href="manager/updateindroce?id="+id+"&indroce="+indroce;
		}
	}
</script>



<body>
<div style="padding-left:100px;padding-top:20px">	
<div class="div1" style="height:830px;width:900px;z-index:0;">
<div style="position:relative;left:-300px;top:-100px">
	<div style="margin-left:100px">
		<!-- 头像层 -->
		<div class="head"><img src="${uu.getImg() }" style="width: 100%;height: 100%;"/>
			<div style="margin-left: 35px;">
				<form  style="margin-top: 150px;" action="manager/photo?eid=<%=manager.getmId() %>" enctype="multipart/form-data" method="post"> 
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
				class="dt" type="text" name="name" value="${uu.getmName()}" 	
				style="position:absolute;left:78px;top:30px; border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;" readonly="readonly" >
			<label style="position:absolute;left:36;top:64px">密码 ：</label><input id="pass"
				class="dt" type="password" name="password" value="${uu.getmPassword()}"
				style="position:absolute;left:78px;top:64px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
     		<label style="position:absolute;left:30;top:93px">确认密码 ：</label><input id="checkpass"
				class="dt" type="password" name="password1" value="${uu.getmPassword()}"
				style="position:absolute;left:99px;top:93px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			<a class="update" style="position: absolute; left: 265px; top: 95px"
				href="javaScript:updatepass('<%=manager.getmId() %>')">修改</a>
		</div>

		<!-- 邮箱 -->
		<div class="personal_info"
			style="position: absolute; left: 430px; top: 422px; width: 506px; height: 45px">
		  <label style="position: absolute; left: 14px; top: 12px">邮箱 ：</label><input
				class="dt" type="text" name="password" id="email" value="${uu.getmEmail()}"
				style="position: absolute; left: 69px; top: 13px; width: 227px; border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: none;">
			
		</div>
		<!-- 性别等项 -->
		<div class="personal_info"
			style="position:absolute;left:430px;top:475px;width:506px;height:85px">
			<label style="position:absolute;left:14px;top:16px">性别 ：</label><input
				class="dt" type="text" name="sex" id="sex" value="${uu.getmSex()}" 
				style="position:absolute;left:57px;top:16px;width:177px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			<label style="position:absolute;left:264px;top:16px">民族 ：</label><input
				class="dt" type="text" name="nation" id="nation" value="${uu.getmNation()}"
				style="position:absolute;left:307px;top:16px;width:177px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			<label style="position:absolute;left:14px;top:45px">出生日期 ：</label><input
				class="dt" type="text" name="birth" value="${uu.getmBirth()}" id="birth"
				style="position:absolute;left:85px;top:45px;width:149px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			<label style="position:absolute;left:264px;top:45px">联系方式 ：</label><input
				class="dt" type="text" name="tel" value="${uu.getmTel()}" id="tel"
				style="position: absolute; left: 340px; top: 47px; width: 121px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			
		</div>
		<!-- 学历等项 -->
		<div class="personal_info"
			style="position: absolute; left: 430px; top: 565px; width: 511px; height: 120px">
		  <p>
				<label style="position:absolute;left:14px;top:16px">家庭住址 ：</label> <input
					class="dt" type="text" name="diploma" value="${uu.getmAddress()}" id="address"
					style="position: absolute; left: 88px; top: 19px; width: 264px; border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: none;">
				</p>
		  <p>
				
				<br> <label style="position:absolute;left:14px;top:45px">职位
					：</label> <input class="dt" type="text" name="college" value="${uu.getDepartment()}" id="zhiwei"
					style="position:absolute;left:57px;top:45px;width:177px;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">
			<label style="position:absolute;left:264px;top:45px">星座 ：</label>
			<input
					class="dt" type="text" name="college2" value="${uu.getmConstellation()}"  id="xinzuo"
					style="position: absolute; left: 309px; top: 48px; width: 177px; border: none; outline: none;">
		  </p>
		</div>
		<!-- 个人简介 -->
		<div class="personal_info"
			style="position: absolute; left: 430px; top: 720px; width: 531px; height: 165px">
			<label style="position:absolute;left:14px;top:22px">个人简介 ：</label>
			<textarea class="dt" rows="10" cols="40" id="indroce"
				style="position:absolute;left:85px;top:18px;width:395px;height:120px;line-height:30px;text-align:left;overflow:hidden ;border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;">${uu.introduce} </textarea>
			
			<a class="update" style="position: absolute; left: 484px; top: 143px"
				href="javaScript:updateindroce('<%=manager.getmId() %>')">修改</a>
		</div>
		<!-- 水平线 -->
		<div class="info" style="position:absolute;left:672px;top:232px;"></div>
		<div class="info" style="position:absolute;left:672px;top:266px;"></div>
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
	</div>
	<p>${msg }</p>
    <a class="update" style="position: absolute; left: 681px; top: 549px; width: 45px;" href="javaScript:updateinfo('<%=manager.getmId() %>')">修改</a></div>
</body>
</html>
