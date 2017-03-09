  <%@page import="org.lanqiao.entity.Schedule"%>
<%@page import="org.lanqiao.biz.impl.ScheduleBizImpl"%>
<%@page import="org.lanqiao.biz.ScheduleBiz"%>
<%@page import="org.lanqiao.entity.Manager"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@page import="org.lanqiao.biz.impl.NoticeBizImpl"%>
  <%@page import="org.lanqiao.biz.NoticeBiz"%>
  <%@page import="org.lanqiao.entity.Notice"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
  + path + "/";
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
  <link rel="stylesheet" type="text/css" href="css/fullcalendar.css">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <link rel="stylesheet" href="css/bootstrap-theme.min.css">
  <style type="text/css">
  #calendar {
  width: 860px;
  margin: 20px auto 10px auto
  }
  </style>
  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-ui-1.10.2.custom.min.js"></script>
  <script src="js/fullcalendar.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
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
  <%
  		NoticeBiz nBiz=(NoticeBiz)ac.getBean("noticeBiz");
  		List<Notice> list1 = nBiz.findAll();
  		pageContext.setAttribute("list", list1);
   %>
  <body>
  <div class="row clearfix">
  <div class="col-md-12" style="padding-right:10px; padding-left:10px">
  <div class="col-md-6" style="padding-right:0px; width:500px">
  <div id="main" style="width:500px">
  <div id="calendar" style="width:500px"></div>
  </div>
  </div>
  <div class="col-md-6" style="padding-left:50px">
  <div class="panel-group" id="accordion" role="tablist"
  aria-multiselectable="true" style="padding-top:20px;">
   
  <c:forEach items="${list }" var="n">
  <div class="panel panel-default">
  <div class="panel-heading" role="tab" id="headingOne"
  style="background: #CD853F ;opacity:0.6">
  <h4 class="panel-title">
	<a role="button" data-toggle="collapse" data-parent="#accordion"
		href="#${n.nTitle }" aria-expanded="true"
		aria-controls="collapseOne">${n.nTitle } </a>
  </h4>
  </div>
  <div id="${n.nTitle }" class="panel-collapse collapse in"
  role="tabpanel" aria-labelledby="headingOne">
  <div class="panel-body">&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;
  	${n.nContent }
  </div>
  </div>
  </div>
  </c:forEach>
  
  </div>
  </div>
  </body>
  </html>