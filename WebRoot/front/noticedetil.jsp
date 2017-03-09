<%@page import="org.lanqiao.entity.Notice"%>
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
    
    <title>My JSP 'noticedetil.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  	Notice notice = (Notice)request.getAttribute("notice");
  	pageContext.setAttribute("n", notice);
  	   %>
  <body>
  	
    <div style="text-align: center; ">
    	
    		<h3>${n.nSummary }</h3>
    		<p>作者：${n.issuer } 时间：${n.date }</p>
    		<p>${n.nContent }</p>
    	
    </div>
  </body>
</html>
