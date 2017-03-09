<%@page import="javax.mail.internet.MimeMessage"%>
<!--%@page import="com.oa.email.ShowMail"%-->
<%@page import="javax.mail.Message"%>
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
    
    <title>My JSP 'emaildetil.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%
		Message msg = (Message)request.getAttribute("list");
		String I = (String)request.getAttribute("I");
		int i = Integer.parseInt(I);
		System.out.println("i="+I);
		String ff = (String)session.getAttribute("FF"); 
		System.out.println("f="+ff);
		//String p[] = (String [])session.getAttribute("file"); 
		//System.out.println("leeength="+p.length);
		//System.out.println("p="+p[i]);
		//Part part = msg;
		ShowMail re = new ShowMail((MimeMessage)msg);
		
	
	 %>
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
    				<%=re.getSubject() %>
    			</td>
    		</tr>
    		<tr>
    			<td>发件人：</td>
    			<td>
    				<%=re.getFrom() %>
    			</td>
    		</tr>
    		<tr>
    			<td>时间：</td>
    			<td><%=re.getSentDate() %></td>
    		</tr>
    		<tr>
    			
    			
    			<c:choose>
    				<c:when test="${have=='1' }">
    				<td>
    					附件：
    							</td>	
    							<td><a href="<%=path %>/EmailFile/罗长章  计科  流年，情似水.rar" style="text-decoration: none"></a>
    						<img alt="模板下载" src="<%=path%>/img/excel.png">下载标准模板<br></td>
    				</c:when>
    				<c:otherwise>
    					<td>无附件</td>
    				</c:otherwise>
    			</c:choose>
    			
    			
    		</tr>
    		<tr>
    			<td>内容：</td>
    			<td>${content }<%=re.getBodyText() %></td>
    		</tr>
    	</table>
    </div>
  </body>
</html>
