<%@page import="org.lanqiao.entity.Personal"%>

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
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
	<title>Document</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link href="css/top.css" rel='stylesheet' type='text/css' />
    <script src="js/bootstrap.js"></script>
    <script src="js/jquery.min.js"></script>
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
    	function show(pId,pName,pTel,pAddress,id) {	
    		$(".addPersonal").hide();
    		$("#pid").val(pId);
    		$("#pname").val(pName);
    		$("#ptel").val(pTel);
    		$("#paddress").val(pAddress);
    		$("#id").val(id);
			$(".personal").show();
		}
		function hide(){
			$(".personal").hide();
		}
		function addPersonal() {
			$(".personal").hide();
			$(".addPersonal").show();
		}
		function hidePersonal(){
			$(".addPersonal").hide();
		}
		function deleteuser(pId,id){
		       
			var result = window.confirm("确认删除？");
			if(result == true){
				//决定删除
				window.location.href="personal/delete?pId="+pId+"&id="+id;
			}
		}
    </script>
</head>
 <%
	List <Personal> p = (List <Personal>)request.getAttribute("list");
 %>
  
</head>

  
<body><div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column div1" style="padding:20px"> 
 <body  style=margin-top:30px>
 <button type="submit" class="btn btn-info " onclick="addPersonal()"><i class="glyphicon glyphicon-plus icon-white"></i> 新建联系人</button>
 <form class="form-search"  style=margin-top:15px action="personal/findByPageConditions1?currentPage=${page.currentPage}&id=${e.eId }" method="post">
				 <input class="input-medium search-query" name="query_text" type="text"  style=margin-left:600px  /> <button type="submit" class="btn btn-primary btn-sm"><i class="glyphicon glyphicon-search icon-white"></i> 查找</button>

			</form>

                <table class="table" contenteditable="true">
                  <thead>
                    <tr>
                       <th>联系人名称</th>
                       <th>联系人电话</th>
                      <th>联系人地址</th>
                      <th>操作</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${list }" var="P">
                    <tr>
                     <%--  <td>${P.pId }</td> --%>
                      <td>${P.pName }</td>
                      <td>${P.pTel }</td>
                      <td>${P.pAddress }</td>
  					  <td>  
  					  <button class="btn btn-danger btn-sm" type="button" onclick="javascript:deleteuser('${P.pId }','${P.id }')"><i class="glyphicon glyphicon-trash icon-white"></i> 删除</button> 
  					  <button class="btn btn-info btn-sm" type="button" onclick="show('${P.pId}','${P.pName}','${P.pTel}','${P.pAddress}',${P.id })"><i class="glyphicon glyphicon-edit icon-white"></i> 修改</button>
					  </td>
                  	</tr>
                  	</c:forEach>
                  </tbody>
                </table>
              <div style="margin-left: 50;">当前为第${page.currentPage}页,共${page.totalPage}页
    
    <c:choose>
		<c:when test="${page.hasPrePage}">
			<a href="<%=path %>/personal/list1?id=${e.eId }&currentPage=1&from=1">首页</a> | 
			<a href="<%=path %>/personal/list1?id=${e.eId }&currentPage=${page.currentPage -1 }&from=1">上一页</a>
		</c:when>
		<c:otherwise>
			首页 | 上一页
		</c:otherwise>
	</c:choose>	
	<c:choose>
		<c:when test="${page.hasNextPage}">
			<a href="<%=path %>/personal/list1?id=${e.eId }&currentPage=${page.currentPage + 1 }&from=1">下一页</a> | 
			<a href="<%=path %>/personal/list1?id=${e.eId }&currentPage=${page.totalPage }&from=1">尾页</a>
		</c:when>
		<c:otherwise>
			下一页 | 尾页
		</c:otherwise>
	</c:choose>
	${msg }
  </div> 
  <div class="personal" align="center">
  		<form method="post" action="personal/update?currentPage=${page.currentPage}&id=${e.eId }&pId=${p.pId}">
  			<div><input id="pid" type="text" name="pid" style="display:none"></div>
  			<div style="margin-top:80px;">联系人姓名：<input id="pname" type="text" name="pname"></div>
  			<div style="margin-top:30px;">联系人电话：<input id="ptel" type="text" name="ptel"></div>
  			<div style="margin-top:30px;">联系人地址：<input id="paddress" type="text" name="paddress"></div>
  			<div style="margin-top:50px;">
  				<input class="btn" type="submit" value="修改" style="margin-right:55px;">
  				<input class="btn" type="button" value="关闭" onclick="hide()">
  			</div>
  		</form>		
  </div>
  <div class="addPersonal" align="center">
  		<form method="post" action="personal/add?currentPage=${page.currentPage}&id=${e.eId }">
  			<div style="margin-top:80px;">联系人姓名：<input id="pname" type="text" name="pname"></div>
  			<div style="margin-top:30px;">联系人电话：<input id="ptel" type="text" name="ptel"></div>
  			<div style="margin-top:30px;">联系人地址：<input id="paddress" type="text" name="paddress"></div>
  			<div style="margin-top:50px;">
  				<input class="btn" type="submit" value="增加" style="margin-right:55px;">
  				<input class="btn" type="button" value="关闭" onclick="hidePersonal()">
  			</div>
  		</form>		
  </div>
  </div>      
</body>
</html>
