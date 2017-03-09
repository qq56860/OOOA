<%@page import="org.lanqiao.entity.Schedule"%>
<%@page import="org.lanqiao.biz.impl.ScheduleBizImpl"%>
<%@page import="org.lanqiao.biz.ScheduleBiz"%>
<%@page import="org.lanqiao.entity.Manager"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
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
    
    <title>My JSP 'calendarMa.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.simple-dtpicker.js"></script>
	<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link href="css/top.css" rel='stylesheet' type='text/css' />
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/npm.js"></script> 
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
    	function deletesch(schid){
			var result = window.confirm("确认删除？");
			if(result == true){
				//决定删除
				window.location.href="delete2?schid="+schid;
			}
		}
    </script>
  </head>
  <%	
 		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ScheduleBiz cBiz = (ScheduleBiz)ac.getBean("scheduleBiz");
		Manager ma = (Manager)request.getSession().getAttribute("User");
		List<Schedule> list = cBiz.queryAll(ma.getmId());
		pageContext.setAttribute("slist", list);
  %>
  
  <body>
  <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column div1" style="padding:20px"> 

  	<div style="margin-top:30px;margin-left:50px;">
  		<form method="post" action="read2"	>
  			<label>日程安排：</label>
  			<input type="text" name="schContent"><br><br>
  			<label for='startdt'> 开始时间： </label>
			<input type="text" class="dtpicker" name="startdt" id="startdt" value="">
			<label for='enddt'> 结束时间：</label>
			<input type="text" class="dtpicker" name="enddt" id="enddt" value=""><br><br>
             <button class="btn  btn-success btn-sm" type="submit" name="submit" ><i class="glyphicon glyphicon-ok-sign icon-white"></i>提交</button>
            <button class="btn  btn-inverse btn-sm" type="submit" name="reset" ><i class="glyphicon glyphicon-repeat icon-white"></i>重置</button>
  		</form>
  		</div>
  		<table class="table" contenteditable="true" style=margin-top:100px;width:900px;margin-left:50px;>
                  <thead>
                    <tr>
                      <th>事务内容</th>
                       <th>开始时间</th>
                       <th>结束时间</th>
                       <th>操作</th>
                    </tr>
                  </thead>
                  <tbody>
                   <c:forEach items="${slist }" var="s">
                    <tr>
                      <td>${s.schContent }</td>
                      <td>${s.startdt }</td>
                      <td>${s.enddt }</td>
                      <td>
                      <button class="btn btn-danger btn-sm" type="button" onclick="javascript:deletesch(${s.schId })"><i class="glyphicon glyphicon-trash icon-white"></i> 删除</button> 
                      </td>
                    </tr>
                    </c:forEach>
                  </tbody>
        </table>
		<script type="text/javascript">
			$(function(){
			 	// -- append by class just for lower strings count --
				$('.dtpicker').appendDtpicker({"minuteInterval": 15, "calendarMouseScroll": true, "futureOnly": true, "autodateOnStart": false});

				$('#startdt').change(function() {
				     $('#enddt').handleDtpicker('setMinDate', $('#startdt').val()); //set end datetime not lower then start datetime
				});
			});
		</script>
		${msg }
  </body>
</html>
