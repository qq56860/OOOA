<%@page import="org.lanqiao.entity.Email"%>
<%@page import="org.lanqiao.entity.Employee"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	
	<!-- <script type="text/javascript">
	function deletecell() {
		var tabb=document.getElementById("tab");
		var dcell=document.getElementById("cell");
		tabb.removeAttribute(dcell)
	}
	
	
	</script> -->
	

  </head>
  
  <body>
  
  <form action="email/delete" method="post" name = "form" onsubmit="checkForm()	">
  <table id="tab" class = "table1" width="1000" border="1" cellspacing="0">
  <tr class = "special">
    <td width="80">
      <input type="checkbox" name="chkall" id="chkall" onclick="setChecked('chk_id');"/>全选
      <label for="0"></label>
    </td>
    <td width="109"><div align="left">发件人</div></td>
    <td width="661">主题</td>
    <td width="159">时间</td>
    <td width="50">操作</td>
  </tr>
  <c:forEach items="${list }" var="i">
 	<tr class = "special" >
 	
 		<td width="80">
 		<input type="checkbox" name="cell" id="cell" onclick="setChecked('chk_id');"/>
 		</td>
 		<td width="109"><div align="left">${emp.eName }</div></td>
 		<td width="661"><a href="email/showemail?eid=${emp.eId }&&id=${i.mailSendId}&&title=${i.mailTitle }">${i.mailTitle }</a></td>
 		<td width="159">${i.mailDate }</td>
 		<td><a href="email/edelete?mailid=${i.mailId }&&id=${e.eId}">删除</a></td>
 
 	</tr>
 	</c:forEach>
  <tr>
    <td>
      <%-- <input type="checkbox" name="chk_id" id="chk_id1" value="ff"/><img alt="" src="<%=img %>" style="width: 25px;height: 20px;margin-left: 17px;"> --%>
    </td>
    <td>
    	
    </td>
    <td width="661">
    <a href="#">
   </a>
    </td>
    <td></td>
  </tr>
 
    <tr>
    <td colspan="4">
    
      <label for="4"></label>
      
      <input type="button" value="删除" onclick="deletecell()" action="">
      <input type="button" value="彻底删除" onclick="form.onsubmit();form.action='/OA/email.do?method=delete&flag=1&id=${e.eId }';form.submit()">
      <input type="button" value="标记为已读" onclick="form.onsubmit();form.action='/OA/email.do?method=read&id=${e.eId }';form.submit()">
    </td>
  </tr>
</table>
</form>
   
<script type="text/javascript">
	function setChecked(boxname) 
	{
	
	var boxs =document.getElementsByName(boxname);
	var chkbox = document.getElementById("chkall");
	
	if(chkbox.checked == true){
		for(var i=0 ; i<boxs.length ; i++) {
			boxs[i].checked = true;
		}
	}else{
		for(var i=0 ; i<boxs.length ; i++) {
			boxs[i].checked = false;
			}
		}
	}
	function checkForm()
	{
	var boxs =document.getElementsByName("chk_id");
	for(var i=0 ; i<boxs.length ; i++) 
	{
		if(boxs[i].checked==true)
		{
			if(confirm("确定批量处理这些数据吗？"))
			{
				return true;
			}else
			{
				return false;
			}
		}
	}
	alert("至少选中一条数据……");
	return false;
}
	
	
</script>
<div>${msg }</div>
  </body>
</html>
