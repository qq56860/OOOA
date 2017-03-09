<%@page import="org.lanqiao.entity.Manager"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
<%@page import="java.util.Calendar"%>
<%@page import="org.lanqiao.entity.Schedule"%>
<%@page import="org.lanqiao.biz.impl.ScheduleBizImpl"%>
<%@page import="org.lanqiao.biz.ScheduleBiz"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'calendar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/fullcalendar.css">
	<style type="text/css">
	#calendar{width:960px; margin:20px auto 10px auto}
	</style>
	<script src='js/jquery.min.js'></script>
	<script src='js/jquery-ui-1.10.2.custom.min.js'></script>
	<script src='js/fullcalendar.min.js'></script>
	<script type="text/javascript">
	<%	
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ScheduleBiz cBiz = (ScheduleBiz)ac.getBean("scheduleBiz");
		Manager ma = (Manager)request.getSession().getAttribute("User");
		
		List<Schedule> list = cBiz.queryAll(ma.getmId());%>
	$(function() {
	
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		//alert(m+" "+d+" "+y);
		
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			firstDay:1,
			editable: true,
			timeFormat: 'H:mm',
			axisFormat: 'H:mm',
			events: [
				
				<%
				for(Schedule s : list){
					Calendar sdate=Calendar.getInstance();
					Calendar edate=Calendar.getInstance();
					sdate.setTime(s.getStartdt());
					if(s.getEnddt()==null){
				%>
						{
						title: '<%=s.getSchContent() %>',
						start: new Date(<%=sdate.get(Calendar.YEAR)%>,<%=sdate.get(Calendar.MONTH)%>,<%=sdate.get(Calendar.DATE)%>)
						
						},	
				<%	
					}else{
						edate.setTime(s.getEnddt());
						if(sdate.get(Calendar.MONTH)==edate.get(Calendar.MONTH)&&sdate.get(Calendar.DATE)==edate.get(Calendar.DATE)){
				%>					
						{
						title: '<%=s.getSchContent() %>',
						start: new Date(<%=sdate.get(Calendar.YEAR)%>,<%=sdate.get(Calendar.MONTH)%>,<%=sdate.get(Calendar.DATE)%>,<%=sdate.get(Calendar.HOUR)%>,<%=sdate.get(Calendar.MINUTE)%>),
						end: new Date(<%=edate.get(Calendar.YEAR)%>,<%=edate.get(Calendar.MONTH)%>,<%=edate.get(Calendar.DATE)%>,<%=edate.get(Calendar.HOUR)%>,<%=edate.get(Calendar.MINUTE)%>),
						allDay: false
						},	
				<%
						}else{
				%>
						{
						title: '<%=s.getSchContent() %>',
						start: new Date(<%=sdate.get(Calendar.YEAR)%>,<%=sdate.get(Calendar.MONTH)%>,<%=sdate.get(Calendar.DATE)%>),
						end: new Date(<%=edate.get(Calendar.YEAR)%>,<%=edate.get(Calendar.MONTH)%>,<%=edate.get(Calendar.DATE)%>)
						},	
				<%
				}
				}
				}
				%>
			]
			});
		
		});
	</script>
</head>

<body>
<div id="main" style="width:1060px">
   <div id='calendar'></div>
</div>

</body>
</html>