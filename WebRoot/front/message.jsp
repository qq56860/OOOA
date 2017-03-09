<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'message.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	 <style type="text/css">
	 	.email{
	left:350px;
	top:150px;
	-webkit-border-radius:8px;
	 -moz-border-radius: 8px;
	 border-radius: 8px;
	 -webkit-box-shadow: #000000 0px 0px 10px;
	 -moz-box-shadow: #000000 0px 0px 10px;
	box-shadow: #000000 0px 0px 10px;
	
	width:600;
	height:550px;
}
	 </style>

  </head>
  
  <body>
   
    <div class="email">
    	<table>
    	
    		<tr>
    		<td>主题：</td>
    		
    			
    			<td>
    				${em.mailTitle }
    			</td>
    			
    		</tr>
    	
    	
    		<tr>
    			<td>发件人：</td>
    			
    			<td>
    				${emp.eName }
    			</td>
    			
    		</tr>
    		
    		<tr>
    			<td>时间：</td>
    			<td>${em.mailDate }</td>
    		</tr>
    		<tr>
    			
    			
    			
    				<td>
    					附件：
    							</td>	
    							<td>
    						</td>
    				
    				
    					<td>无附件</td>
   			
    		</tr>
    		<tr>
    			<td>内容：</td>
    			<td>${em.mailContent }</td>
    		</tr>
    		
    	</table>
    </div>
  </body>
  </body>
</html>
