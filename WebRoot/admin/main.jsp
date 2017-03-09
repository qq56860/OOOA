<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/clock.css" rel="stylesheet" />

  </head>
  
  <body style="margin:0px;">
 	<div id="clock" class="light">
			<div class="display">
				<div class="weekdays"></div>
				<div class="ampm"></div>
				<div class="alarm"></div>
				<div class="digits"></div>
			</div>
		</div>

		<div class="button-holder">
			<a id="switch-theme" class="button">Switch Theme</a>
			<a class="alarm-button"></a>
		</div>

		<!-- The dialog is hidden with css -->
		<div class="overlay">

			<div id="alarm-dialog">

				<h2>Set alarm after</h2>

				<label class="hours">
					Hours
					<input type="number" value="0" min="0" />
				</label>

				<label class="minutes">
					Minutes
					<input type="number" value="0" min="0" />
				</label>

				<label class="seconds">
					Seconds
					<input type="number" value="0" min="0" />
				</label>

				<div class="button-holder">
					<a id="alarm-set" class="button blue">Set</a>
					<a id="alarm-clear" class="button red">Clear</a>
				</div>

				<a class="close"></a>

			</div>

		</div>

		<div class="overlay">

			<div id="time-is-up">

				<h2>Time's up!</h2>

				<div class="button-holder">
					<a class="button blue">Close</a>
				</div>

			</div>

		</div>

		<audio id="alarm-ring" preload>
			<source src="assets/audio/ticktac.mp3" type="audio/mpeg" />
			<source src="assets/audio/ticktac.ogg" type="audio/ogg" />
		</audio>

        
		<!-- JavaScript Includes -->
		<script src="js/jquery.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.0.0/moment.min.js"></script>
		<script src="js/clock.js"></script>
		
		${msg }
  </body>
</html>
