<%@page import="org.lanqiao.entity.Employee"%>
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
    
    <title>My JSP 'ff.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery-1.7.2.js"></script>
	<link href="css/top.css" rel='stylesheet' type='text/css' />
	<script type="text/javascript">
		function show(zan,nid,nSummary,issuer,date,nContent,state) {
			if(zan==0){
				$("#notice_zan a").attr("href","notice/updatezan?id="+nid+"&state="+state);
				$("#notice_zan a img").attr("src","images/no.png")
			}else{
				$("#notice_zan a img").attr("src","images/zan.png")
			}
			$("#notice_top h2").text(nSummary);
			$("#notice_mid h4").text(issuer+'    '+date)
			$("#notice_bottom").html(nContent);
			$(".notice").show();
		}
		$(function() {
			$(".notice").click(function(e) {
			e?e.stopPropagation():event.cancelBubble = true;
			});
			$(".title").click(function(e) {
			e?e.stopPropagation():event.cancelBubble = true;
			});
			$(document).click(function() {
			$(".notice").fadeOut();
			});
		});
	</script>
  </head>
  	<%
  		Employee em = (Employee)session.getAttribute("User");
  		List<Notice> list = (List<Notice>)request.getAttribute("list");
  	 %>
  <body>
  	<div style="margin:20px auto 80px 20px;"><h1>最新公告</h1></div>
  	<%
  		for(Notice N:list){
  			int flag=0;
  			String zan = N.getZan();
  			String ids[] = new String[100];
			ids = zan.split("，|,");
			for(String id : ids){
			if(em.geteId()==Integer.parseInt(id)){
				flag=1;
			}
			}
			if(flag==0){
		%>
				<div style="margin-bottom:20px;margin-left:50px;height:50px;border-bottom: 2px solid #d6d6d6;">
  				<h4><img alt="" src="images/no.png" width="38px" height="20px"><span style="color:red">（未赞）	</span><a class="title" href="javascript:void(0)" onclick="show(0,<%=N.getnId() %>,'<%=N.getnTitle() %>','<%=N.getIssuer() %>','<%=N.getDate() %>','<%=N.getnContent() %>','<%=N.getState() %>')"><%=N.getnSummary() %></a></h4>
  				</div>
  		<%
			}else{
		%>		
				<div style="margin-bottom:20px;margin-left:50px;height:50px;border-bottom: 2px solid #d6d6d6;">
  				<h4><img alt="" src="images/zan.png" width="38px" height="20px"><span style="color:red">（已赞）	</span><a class="title" href="javascript:void(0)" onclick="show(1,<%=N.getnId() %>,'<%=N.getnTitle() %>','<%=N.getIssuer() %>','<%=N.getDate() %>','<%=N.getnContent() %>','<%=N.getState() %>')"><%=N.getnSummary() %></a></h4>
  				</div>
		<%
			}
		}
  	 %>
  	
  	<div style="margin-left:50;margin-top:50px;">当前为第${page.currentPage}页,共${page.totalPage}页
    
    <c:choose>
		<c:when test="${page.hasPrePage}">
			<a href="<%=path %>/notice/findByPageE?currentPage=1">首页</a> | 
			<a href="<%=path %>/notice/findByPageE?currentPage=${page.currentPage-1}">上一页</a>
		</c:when>
		<c:otherwise>
			首页 | 上一页
		</c:otherwise>
	</c:choose>	
	<c:choose>
		<c:when test="${page.hasNextPage}">
			<a href="<%=path %>/notice/findByPageE?currentPage=${page.currentPage+1}">下一页</a> | 
			<a href="<%=path %>/notice/findByPageE?currentPage=${page.totalPage }">尾页</a>
		</c:when>
		<c:otherwise>
			下一页 | 尾页
		</c:otherwise>
	</c:choose>
  </div> 
  <div class="notice">
  	<div id="notice_zan"  style="margin-left:10px;margin-top:10px;">
  		<a style="width:100px;height:60px;"><img src="images/noticebg.jpg" width="100px" height="60px"></a>
  	</div>
  	<div id="notice_top" align="center">
  		<h2></h2>
 	</div>
 	<div id="notice_mid" align="center">
 		<h4></h4>
 	</div>
 	<div id="notice_bottom" style="margin:20px 60px;">
 	</div>
  </div>
  </body>
</html>
