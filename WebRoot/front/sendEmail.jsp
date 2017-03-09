<%@page import="org.lanqiao.entity.Employee"%>
<%@page import="org.lanqiao.biz.impl.EmployeeBizImpl"%>
<%@page import="org.lanqiao.biz.EmployeeBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	
  <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
	<title>Document</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/OA/kindeditor/themes/default/default.css" /> 
    <link rel="stylesheet" href="/OA/kindeditor/plugins/code/prettify.css" /> 
    
    <link href="utf8-jsp/themes/default/css/ueditor.css" rel="stylesheet">
    <script src="js/bootstrap.js"></script>
    <script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
    
    <script src="js/bootstrap.min.js"></script>
   
    <script charset="utf-8" src="/OA/kindeditor/kindeditor-all.js"></script> 
   <script charset="utf-8" src="/OA/kindeditor/lang/zh_CN.js"></script> 
	<script charset="utf-8" src="/OA/kindeditor/plugins/code/prettify.js"></script>
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
    </style>
</head>
  <body><div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column div1" style="padding:20px">
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="tabbable" id="tabs-825041">
				<ul class="nav nav-tabs">
					<li class="active">
						<a href="#panel-627087" data-toggle="tab">普通邮件</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-627087">
				<div style="padding:10px">
                    
						<form action="email/sendd1?id=${e.eId}" method="post" enctype="multipart/form-data">
						<input type="submit" value="发送"> 
						<p style="margin-top:10px">
						收件人编号:<input type="text" name="mailReceiveId" id="pass" value="3">
						  收件人:
                          <input type="text" name="eEmail" id="eEmail" value="903559163@qq.com">
						</p>
						<p>
						  主 题 &nbsp;&nbsp;:
                          <input type="text" name="mailTitle" id="mailTitle">
				
					  <p>
						   <label for="textfield3">正文：</label><br>
						  <!--<script type="text/plain" id="editor"  style="width: 100%;height: 8rem;"></script>	 -->					  
						 <input type="text" id="textfield3" style="width: 100%;height: 8rem;" name="mailContent" >
						 <!--  附件： 
						  <input type="text" id="mailContent" name="mailContent" value="55">
						  <input type="file" name="file"> -->
						  
						  
					  </p>
					  
						<p>发件人：${e.eName }</p>
						 
						 </form>
						<p>&nbsp;</p>
						<p>&nbsp;</p>
					</div>
					<div class="tab-pane" id="panel-29299">
					
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div>${msg }</div>
	<script charset="utf-8" src="utf8-jsp/ueditor.config.js"></script>
  	<script charset="utf-8" src="utf8-jsp/ueditor.all.min.js"></script>
  	<script src="utf8-jsp/lang/zh-cn/zh-cn.js"></script>
 <script>
 var ue = null;
 var ue2 = null;
 $(function(){
	 $("#content").hide();
 ue = UE.getEditor('editor');
 ue2 = UE.getEditor('editor2');
 	$("#send").click(function(){
 		var content = ue.getContent();
 		$("#content").val(content);
 	});
 }); 
        
    </script>
</body>
</html>
