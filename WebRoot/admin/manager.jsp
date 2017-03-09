
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
    
    <title>My JSP 'manager.jsp' starting page</title>
    
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
    <script type="text/javascript">
	function deletem(id){
	var r = window.confirm("你是否要删除该信息？");
	if(r==true){
		window.location.href="admin/deleteM?id="+id;
	}
	
	}
	function update(id){
    var mtel = document.getElementById("mTel").value;
    var memail = document.getElementById("mEmail").value;
    var maddress = document.getElementById("mAddress").value;
    var r = window.confirm("确定修改？");
    if(r == true){
        window.location.href="admin/updateM?id="+id+"&mtel="+mtel+"&memail="+memail+"&maddress="+maddress;
    }
    }
	</script>
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
  </head>

  <body style="background-image:url()">
   <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column div1" style="padding:10px"> 
					<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<form class="form-search">		
				<a href = "admin/addmanager.jsp" style=margin-left:750px>添加总经理信息</a>
			</form>
			<table class="table">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							姓名
						</th>
						<th>
							电话
						</th>
						<th>
							邮箱
						</th>
						<th>
						              地址
						</th>
						<th>
						               操作
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${m }" var="M">
					<tr>
						<td>
							${M.mId }
						</td>
						<td>
							${M.mName }
						</td>
						<td>
							<input type="text" name="mTel" id="mTel" style="border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;"
							            value = "${M.mTel }">
						</td>
						<td>
							<input type="text" name="mEmail" id="mEmail" style="border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;"
							            value = "${M.mEmail }">
						</td>
							<td>
							<input type="text" name="mAddress" id="mAddress" style="border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;"
							            value = "${M.mAddress }">
							</td>    
						<td>
						<button  class="btn btn-danger btn-sm" onclick="deletem(${M.mId})"><i class="glyphicon glyphicon-trash icon-white"></i> 删除</button> 
						 <button  class="btn btn-info btn-sm" onclick="update(${M.mId})"> <i class="glyphicon glyphicon-edit icon-white"></i> 修改</button>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
  </body>
</html>
