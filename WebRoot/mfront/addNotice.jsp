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
	
  <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
	<title>Document</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/OA/kindeditor/themes/default/default.css" /> 
    <link rel="stylesheet" href="/OA/kindeditor/plugins/code/prettify.css" /> 
    <script src="js/bootstrap.js"></script>
    <script src="js/jquery.min.js"></script>
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
    <script type="text/javascript">
    var ue = null;
	$(function(){
	ue = UE.getEditor('editor');});
    function add(){
    
    var title = document.getElementById("title").value;
    
    var summary = document.getElementById("summary").value;
    
    var contents = ue.getContent();
   	
    var nissuer = document.getElementById("issuer").value;
    
    var r = window.confirm("确定添加？");
    if(r == true){
        window.location.href="notice/addN?title="+title+"&summary="+summary+"&contents="+contents+"&nissuer="+nissuer;
    }
    }
    </script>
</head>
  <body><div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column div1" style="padding:20px">
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="tabbable" id="tabs-825041">
						<a href="#panel-627087" data-toggle="tab">发布公告</a>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-627087">
				<div style="padding:10px">
						<p style="margin-top:10px">
						  <label for="textfield">标题:</label>
                          <input type="text" name="title" id="title">
						</p>
						<p>
						  <label for="textfield2">摘要 :</label>
                          <input type="text" name="summary" id="summary">
				
					  <p>
						  <label for="textfield3">正文：</label>
						  <script type="text/plain" id="editor" style="width: 100%;height: 8rem;"></script>
					  </p>
					  <p>
						<label for="textfield">发布人:</label>
						<input type="text" name="issuer" id="issuer">
						</p>
						 <button onclick="add()">发布</button>
						<p>&nbsp;</p>
						<p>&nbsp;</p>
					</div>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script charset="utf-8" src="utf8-jsp/ueditor.config.js"></script>
  	<script charset="utf-8" src="utf8-jsp/ueditor.all.min.js"></script>
  	<script src="utf8-jsp/lang/zh-cn/zh-cn.js"></script>
  	${msg }
</body>
</html>
