
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
    function find(){
		var con = document.getElementById("condition").value;	
		if(con==""){
			alert("请输入需要查询的信息！");
		}
		else{
			window.location.href="/OA/admin.do?method=findE&con="+con;
		}
		
	}
	function deleteemployee(id){
	var r = window.confirm("你是否要删除该信息？");
	if(r==true){
		window.location.href="admin/deleteEmp?id="+id;
	}
	
	}
	function updateemployee(id){
    var etel = document.getElementById("eTel").value;
    alert(etel);
    var eemail = document.getElementById("eEmail").value;
    var r = window.confirm("确定修改？");
    if(r == true){
        window.location.href="admin/updateEmp?id="+id+"&etel="+etel+"&eemail="+eemail;
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
		<div class="col-md-12 column div1" style="padding:20px"> 
					<div class="container-fluid">
	<div class="row-fluid"> 
		<div class="span12">
			<form class="form-search">		
				<!-- <input class="input-medium search-query" type="text" id="condition" name="condition"/> <button  class="btn btn-sm" type="submit" onclick="find()"><i class="glyphicon glyphicon-search icon-white"></i> 查找</button>	 -->	
				&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
				&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
				&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
				&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
				<a href = "admin/addemployee.jsp" style=margin-left:500px>添加员工信息</a>
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
						               操作
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${e }" var="E">
					<tr>
						<td>
							${E.eId }
						</td>
						<td>
							${E.eName }
						</td>
						<td>
							<input type="text" name="eTel" id="eTel" style="border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;"
							            value = "${E.eTel }">
						</td>
						<td>
							<input type="text" name="eEmail" id="eEmail" style="border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;"
							            value = "${E.eEmail }">
						</td>
							    
						<td>
						<button  class="btn btn-danger btn-sm" onclick="deleteemployee(${E.eId})"><i class="glyphicon glyphicon-trash icon-white"></i> 删除</button>   
						 <button  class="btn btn-info btn-sm" onclick="updateemployee(${E.eId})"><i class="glyphicon glyphicon-edit icon-white"></i> 修改</button>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			
			</table>
				
			<div>
			<table width="461" height="24" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td width="199">当前为第${page.currentPage}页,共${page.totalPage}页</td>
    <td width="256">
    <c:choose>
		<c:when test="${page.hasPrePage}">
<<<<<<< .mine
			<a href="admin/findEall?currentPage=1">首页</a> | 
	<a href="admin/findEall?currentPage=${page.currentPage -1 }">上一页</a>
=======
			<a href="<%=path %>/admin/findEall?currentPage=1">首页</a> | 
	<a href="<%=path %>/admin/findEall?currentPage=${page.currentPage -1 }">上一页</a>
>>>>>>> .r139
		</c:when>
		<c:otherwise>
			首页 | 上一页
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${page.hasNextPage}">
<<<<<<< .mine
			<a href="admin/findEall?currentPage=${page.currentPage + 1 }">下一页</a> | 
	<a href="admin/findEall?currentPage=${page.totalPage }">尾页</a>
=======
			<a href="<%=path %>/admin/findEall?currentPage=${page.currentPage + 1 }">下一页</a> | 
	<a href="<%=path %>/admin/findEall?currentPage=${page.totalPage }">尾页</a>
>>>>>>> .r139
		</c:when>
		<c:otherwise>
			下一页 | 尾页
		</c:otherwise>
	</c:choose>
	
</td>
  </tr>
</table>
		</div>
	</div>
</div>

</div>
<<<<<<< .mine
<!-- <div style="padding:20px"><a href="export/admin">导出员工信息</a></div> -->

=======
>>>>>>> .r139
  </body>
</html>
