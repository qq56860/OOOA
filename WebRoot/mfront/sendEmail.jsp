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
					<li>
						<a href="#panel-29299" data-toggle="tab">群邮件</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-627087">
				<div style="padding:10px">
                     <form action="email/sendd?id=${m.mId }" name="myform" method="post">
						<p style="margin-top:10px">
						  <label for="textfield">收件人编号:</label>
                          <input type="text" name="mailReceiveId" id="textfield" >
						</p>
						<p>
						  <label for="textfield2"> 主 题 &nbsp;&nbsp;:</label>
                          <input type="text" name="mailTitle" id="textfield2" >
				
					  <p>
						  <label for="textfield3">正文：</label>
						  <textarea id="editor_id" name="mailContent" style="width:700px;height:300px;"></textarea>
					  </p>
						<p>发件人：${m.mName }</p>
						 <button>发送</button>
						<p>&nbsp;</p>
						<p>&nbsp;</p>
						</form>
					</div>
					
					<div class="tab-pane" id="panel-29299">
						<div style="padding:10px">
                    <form action="email/sendd?id=${m.mId }" name="myform" method="post">
						<p style="margin-top:10px">
						  <label for="textfield">群分组:</label>
                          <input type="text" name="mId" id="textfield">
						</p>
						<p>
						  <label for="textfield2"> 主 题 &nbsp;&nbsp;:</label>
                          <input type="text" name="mailTitle" id="textfield2">
						</p>
						
					  <p>
						  <label for="textfield3">正文：</label>
					
                                
 					<textarea name="mailContent" id="a" style="width:730px; height:430px; margin-top:50px; " ondblclick="show()">111     
 					</textarea> 
 			
  					
					  </p>
						<p>发件人：${m.mName }</p>
						 <button>发送</button>
						
						<p>&nbsp;</p>
						<p>&nbsp;</p>
						 </form> 
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
 <script>
       KindEditor.ready(function(K) {//kindeditor控件调用       
     var editor1=K.create('textarea[name="content"]',{
  //name=form中textarea的name属性           
    cssPath : '/OA/kindeditor/plugins/code/prettify.css',            
    uploadJson : '/OA/kindeditor/php/upload_json.php',           
   fileManagerJson :  '/OA/kindeditor/php/file_manager_json.php',            
   allowFileManager : true,           
   afterCreate : function() {               
    var self = this;                
    K.ctrl(document, 13, function() {                   
    self.sync();                     
    K('form[name=myform]')[0].submit();
     // name=form表单的name属性                
      });                 
      K.ctrl(self.edit.doc, 13, function() { 
                         self.sync();                    
                          K('form[name=myform]')[0].submit(); // name=form表单的name属性            
                               });           
                                }       
                                 });        
                                  prettyPrint();   
                                   }); 
        
    </script>
</body>
</html>
