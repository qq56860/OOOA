<%@page import="org.lanqiao.entity.Manager"%>
<%@page import="org.lanqiao.biz.impl.ManagerBizImpl"%>
<%@page import="org.lanqiao.biz.ManagerBiz"%>
<%@page import="org.lanqiao.entity.Employee"%>
<%@page import="org.lanqiao.biz.impl.EmployeeBizImpl"%>
<%@page import="org.lanqiao.biz.EmployeeBiz"%>
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
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 	<!-- Bootstrap Core CSS -->
	<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<!-- Custom CSS -->
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<!-- Graph CSS -->
	<link href="css/lines.css" rel='stylesheet' type='text/css' />
	<link href="css/top.css" rel='stylesheet' type='text/css' />
	<link href="css/font-awesome.css" rel="stylesheet"> 
	<!-- jQuery -->
	<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
	<!-- Nav CSS -->
	<link href="css/custom.css" rel="stylesheet">
	<!-- Metis Menu Plugin JavaScript -->
	<script src="js/metisMenu.min.js"></script>
	<script src="js/custom.js"></script>
	<link rel="alternate icon" href="assets/i/favicon.ico">
	<link rel="stylesheet" href="css/amazeui.css">
	<link href="utf8-jsp/themes/default/css/ueditor.css" rel="stylesheet">
	<script src="js/top.js"></script>
</head>

<script type="text/javascript">
var ue = null;
$(function(){
ue = UE.getEditor('editor');});
var ws = null;
function startWebSocket() {
	
    if ('WebSocket' in window)
        ws = new WebSocket("ws://localhost:8080/OOOA/mywebsocket.do");
    else if ('MozWebSocket' in window)
        ws = new MozWebSocket("ws://localhost:8080/OOOA/mywebsocket.do");
    else
        alert("not support");
    
    
    ws.onmessage = function(evt) {
        //alert(evt.data);
        console.log(evt);
        var a = $("#xiaoxi").val()+'\n';
        $("#xiaoxi").val(a+evt.data);
        $(evt.data).appendTo("#message-list");
        // 清空消息输入框
					ue.setContent('');
		// 消息输入框获取焦点
					ue.focus();
    };
    
    ws.onclose = function(evt) {
        //alert("close");
        document.getElementById('denglu').innerHTML="离线";
    };
    
    ws.onopen = function(evt) {
        //alert("open");
        document.getElementById('denglu').innerHTML="在线";
        //document.getElementById('userName').innerHTML='小化';
    };
}

function sendMsg() {
    var fromName = "${mm.mName}";
    var toName = $("#chatName").text().replace(/[\r\n\t' ']/g,"");//;  //发给谁
    var content = ue.getContent(); //发送内容
    ws.send(fromName+","+toName+","+content);
   	//alert(toName);
    // addMessage(message);
    /* var messageItem = fromName+":"+content;
    $(messageItem).appendTo('#message-list'); */
   }
function closeit(){
	ws.onclose(0);
	$("#success").text("");
	$("#fail").text("✔");
}

function openit(){
	ws.onopen(1);
	$("#success").text("✔");
	$("#fail").text("");
}
</script>
  
  <body onload="startWebSocket();"><div id="onner" style="position:fixed; width:100%; height:100%;top:0;left:0; z-index:500;background:rgba(0,0,0,0.8); display:none"></div>
  <div id="wrapper">
    <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-nav navbar-right">
       
          <li class="dropdown">
              <a href="#" class="dropdown-toggle avatar" data-toggle="dropdown">
              <span style="color: white">你好，经理：${User.mName }</span>
              <img src=${mm.img }><span class="badge"></span></a>
              <ul class="dropdown-menu">
            <li class="dropdown-menu-header text-center">
              <strong>状态</strong>
            </li>
            <li class="m_2"><a onclick="openit();"><i class="fa fa-check"></i>在线<span class="label label-success" id="success">✔</span></a></li>
            <li class="m_2"><a onclick="closeit();"><i class="fa fa-times"></i>离线 <span class="label label-success" id="fail"></span></a></li>
            <li class="dropdown-menu-header text-center">
              <strong>功能</strong>
            </li>
            <li class="m_2"><a href="mfront/personalInfo.jsp" target="main"><i class="fa fa-bell-o"></i> 修改个人资料 <span class="label label-info"></span></a></li>
           
                        <li class="m_2"><a href="/OOOA/login.jsp" target="_top"><i class="fa fa-sign-out"></i> 注销</a></li>
              </ul>
            </li>
      </ul>
      <!-- <form class="navbar-form navbar-right">
              <input type="text" class="form-control" value="查询..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '查询...';}">
      </form> -->
            
    </nav>
    </div>
    <iframe src="mfront/main.jsp" name="main" width="100%" height="600px" scrolling="auto" style="margin-top:52px;border: 0; "></iframe>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		
    		$("#see").click(function(){
    			$("#list").animate({ 
				marginLeft:parseInt($("#list").css('marginLeft'),10)==0 ? $("#list").outerWidth() : 0 
				}); 

    		});
    		$("#list div").dblclick(function(){
    			$("#chatUI").show();
    			$("#onner").show();
    			var chatName = $(this).text();
    			//alert(chatName);
    			$("#chatName").text(chatName);
    			$("#ueditor_0").text("");
    			$("#message-list").text("");
    			

    		});
    		$("#close").click(function(){
    			$("#chatUI").hide();
    			$("#onner").hide();
    		});
    		$("#quick").click(function(){
    			$("#chatUI").hide();
    			$("#onner").hide();
    		});
    		
    	});
    	
    </script>
    <div id="right_side">
    	<div id="see"></div>
    	<div id="list" style="cursor: pointer;border: 1px solid #696;padding: 6px 0; -webkit-border-radius: 8px;-moz-border-radius: 8px;border-radius: 8px;-webkit-box-shadow: #000033 0px 0px 10px;-moz-box-shadow: #000033 0px 0px 10px;box-shadow: #000033 0px 0px 10px;">
    		<div style="width:100%;height:30px;text-align: center;color: white;">
    			<img src="images/people.gif" width="50" height="30">
    		</div>
    		<br>
    		<c:forEach items="${M }" var="MM">
    		<div class="move" id="move">
    			<h6>${MM.mName }</h6>
    			<hr>
    		</div>
    		</c:forEach>
    		<c:forEach items="${E }" var="EE">
    		<div class="move" id="move">
    			<h6>${EE.eName }</h6>
    			<hr>
    		</div>
    		</c:forEach>
    	<div class="move" id="move">
    			<h6>群聊</h6>
    			<hr>
    	</div>
    	</div>
    </div>
    <div id="chatUI" style="border: 1px solid #696;padding: 6px 0; -webkit-border-radius: 8px;-moz-border-radius: 8px;border-radius: 8px;-webkit-box-shadow: #000033 0px 0px 10px;-moz-box-shadow: #000033 0px 0px 10px;box-shadow: #000033 0px 0px 10px;	">
    	<div id="chatTop">
    		<div id="chatName" style="text-align: center;float: left;margin-left: 255px;"></div>
    		<div style="float:right;"><i id="close" class="fa fa-times" style="cursor:pointer;margin-right:5px;"></i></div>
    	</div>
    	<div class="chat-content">
    		<div class="am-g am-g-fixed chat-content-container" style="height: 270px;">
     		<div class="am-u-sm-12">
        		<ul id="message-list" class="am-comments-list am-comments-list-flip"></ul>
			</div>
			</div>
		</div>
		<script type="text/plain" id="editor" style="width: 100%;height: 8rem;"></script>
		<div style="float:right;margin-right:20px;margin-top:10px;">
			<input type="button" id="quick" value="关闭">
			<input type="button" value="发送" onclick="sendMsg()"></input>
		</div>
		<div>
			登录状态：
			<span id="denglu" style="color:red;">...</span>
			<br>
		</div>
    </div>
    
    <script charset="utf-8" src="utf8-jsp/ueditor.config.js"></script>
  	<script charset="utf-8" src="utf8-jsp/ueditor.all.min.js"></script>
  	<script src="utf8-jsp/lang/zh-cn/zh-cn.js"></script>
  </body>
</html>
