
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
    function deletenotice(id){
	var r = window.confirm("你是否要删除该信息？");
	if(r==true){
		window.location.href="notice/delete?nid="+id;
	}
	
	}
	function updatenotice(id){	
        window.location.href="notice/getbyid?nid="+id
    }
    </script>
</head>

 <body><div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column div1" style="padding:0px">
   <body  style=margin-top:30px>
  <input class="input-medium search-query" type="text"  style=margin-left:560px  /> <button type="submit" class="btn btn-primary btn-sm"><i class="glyphicon glyphicon-search icon-white"></i>查找</button>

                <table width="863" class="table" style=margin-top:20px contenteditable="true">
                  <thead>
                    <tr>
                      <th width="168">标题</th>
                       <th width="168">摘要</th>
                       <th width="168">内容</th>
                      <th width="69">发布时间</th>
                      <th width="168">发布人</th>      
                      <th width="81">操作</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${notice }" var="N">
                    <tr>
                      <td><input type="text" name="ntitle" id="ntitle" style="border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;"
							            value = "${N.nTitle }"></td>
                      <td><input type="text" name="nsummary" id="nsummary" style="border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;"
							            value = "${N.nSummary }"></td>
                      <td><input type="text" name="ncontent" id="ncontent" style="border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;"
							            value = "${N.nContent }"></td>
                      <td>${N.date }</td>
							            <td>
									<input type="text" name="issuer" id="issuer" style="border-top-style: none;
     border-right-style: none;
     border-left-style: none;
     border-bottom-style: none;"
							            value = "${N.issuer }">
									</td>
<td>  <button class="btn btn-danger btn-sm" type="button" onclick="deletenotice(${N.nId})"><i class="glyphicon glyphicon-trash icon-white"></i> 删除</button> 
<button  class="btn btn-info btn-sm" type="button" onclick="updatenotice(${N.nId})"><i class="glyphicon glyphicon-edit icon-white"></i> 修改</button>
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
