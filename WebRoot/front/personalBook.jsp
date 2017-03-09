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
    
    <title>My JSP 'personalBook.jsp' starting page</title>
    
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
</head>
 
</head>

<body><div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column div1" style="padding:20px"> 
 <body  style=margin-top:30px>
 <form class="form-search"  style=margin-top:15px action="personal/findByPageConditions?currentPage=${page.currentPage}&id=${e.eId }" method="post">
				 <input class="input-medium search-query" name="query_text" type="text"  style=margin-left:600px  /> <button type="submit" class="btn btn-primary  btn-sm"><i class="glyphicon glyphicon-search icon-white"></i> 查找</button>

			</form>

                <table class="table" contenteditable="true">
                  <thead>
                    <tr>
                       <th>联系人名称</th>
                       <th>联系人电话</th>
                      <th>联系人地址</th>
                      <!-- <th>操作</th> -->
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${list}" var="P">
                    <c:if test="${P.top==0 }">
                    	<tr>
                      	<%-- <td>${P.pId }</td> --%>
                      	<td>${P.pName }</td>
                      	<td>${P.pTel }</td>
                      	<td>${P.pAddress }</td>
  					  	<td>  
  					  	<%-- <button class="btn btn-info btn-sm" type="button" onclick="window.location.href='personal.do?method=top&pid=${P.pId }&from=0&id=${e.eId }'"><i class="glyphicon glyphicon-arrow-up icon-white"></i> 置顶</button> --%> 
					  	</td>
                  		</tr>
                    </c:if>
                     <c:if test="${P.top==1 }">
                    	<tr class="info">
                      	<%-- <td>${P.pId }</td> --%>
                      	<td>${P.pName }</td>
                      	<td>${P.pTel }</td>
                      	<td>${P.pAddress }</td>
  					  	<td>  
  					  	<button class="btn btn-inverse btn-sm" type="button" onclick="window.location.href='personal.do?method=notop&pid=${P.pId }&from=0&id=${e.eId }'"><i class="glyphicon glyphicon-repeat icon-white"></i> 取消</button> 
					  	</td>
                  		</tr>
                    </c:if>
                  	</c:forEach>
                  </tbody>
                </table>
              <div style="margin-left: 50;">当前为第${page.currentPage}页,共${page.totalPage}页
    
    <c:choose>
		<c:when test="${page.hasPrePage}">
			<a href="<%=path %>/personal/list?id=${e.eId }&currentPage=1&from=0">首页</a> | 
			<a href="<%=path %>/personal/list?id=${e.eId }&currentPage=${page.currentPage -1 }&from=0">上一页</a>
		</c:when>
		<c:otherwise>
			首页 | 上一页
		</c:otherwise>
	</c:choose>	
	<c:choose>
		<c:when test="${page.hasNextPage}">
			<a href="<%=path %>/personal/list?id=${e.eId }&currentPage=${page.currentPage + 1 }&from=0">下一页</a> | 
			<a href="<%=path %>/personal/list?id=${e.eId }&currentPage=${page.totalPage }&from=0">尾页</a>
		</c:when>
		<c:otherwise>
			下一页 | 尾页
		</c:otherwise>
	</c:choose>
	${msg }
  </div>   
              
</body>
</html>
