<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>客户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
      <script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
      <script>
          $(function () {
              $("ul.pagination li.disabled a").click(function () {
                  return false;
              });
          });
      </script>
	  <style type="text/css">
		  .page {
			  width:  500px;
			  margin: 0 auto;
		  }
		  ul {
			  display: flex;
			  width: 500px;
			  list-style: none;
		  }
		  li{
			  flex: 1;
		  }
	  </style>
  </head>
  
  <body>
<h3 align="center">客户列表</h3>
<table border="1" width="70%" align="center">
	<tr>
		<th>客户姓名</th>
		<th>性别</th>
		<th>生日</th>
		<th>手机</th>
		<th>邮箱</th>
		<th>描述</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${crmsList}"  var="crms">
	<tr>
		<td>${crms.cname}</td>
		<td>${crms.gender}</td>
		<td>${crms.birthday}</td>
		<td>${crms.cellphone}</td>
		<td>${crms.email}</td>
		<td>${crms.description}</td>
		<td>
			<a href="<c:url value='/beforeUpdate?cid=${crms.cid}'/>">编辑</a>
			<a href="<c:url value='/delete?cid=${crms.cid}'/>">删除</a>
		</td>
	</tr>
	</c:forEach>
</table>
	<div class="page">
		<ul class="pagination">
			<li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
				<a href="?start=0">
					<span>首页</span>
				</a>
			</li>

			<li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
				<a href="?start=${page.start-page.count}">
					<span>上一页</span>
				</a>
			</li>

			<c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
				<li>
					<a href="?start=${status.index * page.count}" class="current">${status.count}</a>
				</li>
			</c:forEach>

			<li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
				<a href="?start=${page.start+page.count}">
					<span>下一页</span>
				</a>
			</li>
			<li>
				共${page.totalPage}页
			</li>
		</ul>
	</div>
  </body>
</html>
