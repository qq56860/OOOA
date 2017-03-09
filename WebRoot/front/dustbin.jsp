<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  </head>
  
  <body>
   <table class = "table1" width="1000" border="1" cellspacing="0">
  <tr class = "special">
    <td width="43"><form id="form1" name="form1" method="post" action="">
      <input type="checkbox" name="0" id="0" />
      <label for="0"></label>
    </form></td>
    <td width="109"><div align="left">发件人</div></td>
    <td width="661">主题</td>
    <td width="159">时间</td>
    <td width="50">操作</td>
  </tr>
  <c:forEach items="${list }" var="i">
  <tr>
  	
    <td><form id="form4" name="form4" method="post" action="">
      <input type="checkbox" name="3" id="3" />
      <label for="3"></label>
    </form></td>
    <td>${e.eName }</td>
    <td width="661">${i.mailTitle }</td>
    <td>${i.mailDate }</td>
    <td><a href="email/Aedelete?mailid=${i.mailId }&&id=${e.eId}">删除</a></td>
  </tr>
  </c:forEach>
  <tr>
    <td><form id="form2" name="form2" method="post" action="">
      <input type="checkbox" name="1" id="1" />
      <label for="1"></label>
    </form></td>
    <td>&nbsp;</td>
    <td width="661">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><form id="form3" name="form3" method="post" action="">
      <input type="checkbox" name="2" id="2" />
      <label for="2"></label>
    </form></td>
    <td>&nbsp;</td>
    <td width="661">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  
  
  
  <tr>
    <td><form id="form5" name="form5" method="post" action="">
      <input type="checkbox" name="4" id="4" />
      <label for="4"></label>
    </form></td>
    <td>&nbsp;</td>
    <td width="661">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
    <tr>
    <td colspan="4"><form id="form5" name="form5" method="post" action="">
      <label for="4"></label>
      <button class="btn btn-info btn-sm" type="button"  ><i class="glyphicon glyphicon-plus icon-white"></i> 全选</button>
     <button class="btn btn-info btn-sm" type="button"  ><i class="glyphicon glyphicon-plus icon-white"></i> 彻底删除</button>
      <button class="btn btn-info btn-sm" type="button"  ><i class="glyphicon glyphicon-plus icon-white"></i> 这不是垃圾邮件</button>
      <button class="btn btn-info btn-sm" type="button"  ><i class="glyphicon glyphicon-plus icon-white"></i> 转发</button>
     
    </form></td>
  </tr>
</table>
  </body>
</html>
