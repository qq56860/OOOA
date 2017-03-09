<%@page import="org.lanqiao.entity.Admin"%>

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
    	function show(comId,comName,managername,comTel) {	
    		$(".addCommon").hide();
    		$("#comid").val(comId);
    		$("#comname").val(comName);
    		$("#managername").val(managername);
    		$("#comtel").val(comTel);
			$(".common").show();
		}
		function hide(){
			$(".common").hide();
		}
		function addCommon() {
			$(".commom").hide();
			$(".addCommon").show();
		}
		function hideCommon(){
			$(".addCommon").hide();
		}
    function deleteuser(comId){
		       
			var result = window.confirm("确认删除？");
			if(result == true){
				//决定删除
				window.location.href="common/delete?comId="+comId;
			}
	
	}	
    
    </script>
</head>
 
</head>
<body><div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column div1" style="padding:20px"> 
 <body  style=margin-top:30px>
 <form class="form-search"  style=margin-top:15px action="common/findByPageConditions2?currentPage=${page.currentPage}&id=${a.aId }" method="post">
				 <input class="input-medium search-query" name="query_text" type="text"  style=margin-left:600px  /> <button type="submit" class="btn btn-primary btn-sm"><i class="glyphicon glyphicon-search icon-white"></i> 查找</button>

			</form>

                <table class="table" contenteditable="true">
                  <thead>
                    <tr>
                        <th>编号</th>
                       <th>部门名称</th>
                       <th>经理姓名</th>
                      <th>联系电话</th>
                      <th>操作</th>
                    </tr>
                  </thead>
                  <tbody>
                 <c:forEach items="${list }" var="C">
                    <tr>
                      <td>${C.comId }</td>
                      <td><input type="text" name="cName" id="cName" style="border-top-style: none; border-right-style: none;border-left-style: none;border-bottom-style: none;"
							            value = "${C.comName }"></td>
                      <td><input type="text" name="cmName" id="cmName" style="border-top-style: none; border-right-style: none; border-left-style: none;border-bottom-style: none;"
							            value = "${C.managername }"></td>
                      <td><input type="text" name="cTel" id="cTel" style="border-top-style: none;border-right-style: none; border-left-style: none;border-bottom-style: none;"
							            value = "${C.comTel }"></td>
<td>  <button class="btn btn-danger btn-sm"  type="button" onclick="javascript:deleteuser(${C.comId })"><i class="glyphicon glyphicon-trash icon-white"></i>删除</button>
									</td>
                    </tr>
                   </c:forEach>
                  </tbody>
                </table>
              <div style="margin-left: 50;">当前为第${page.currentPage}页,共${page.totalPage}页
    
      <c:choose>
		<c:when test="${page.hasPrePage}">
			<a href="<%=path %>/common/list2?currentPage=1">首页</a> | 
			<a href="<%=path %>/common/list2?currentPage=${page.currentPage -1 }">上一页</a>
		</c:when>
		<c:otherwise>
			首页 | 上一页
		</c:otherwise>
	</c:choose>	
	<c:choose>
		<c:when test="${page.hasNextPage}">
			<a href="<%=path %>/common/list2?currentPage=${page.currentPage + 1 }">下一页</a> | 
			<a href="<%=path %>/common/list2?currentPage=${page.totalPage }">尾页</a>
		</c:when>
		<c:otherwise>
			下一页 | 尾页
		</c:otherwise>
	</c:choose>
	${msg }
  </div> 
 
  </div>
  </div>      
</body>
</html>
