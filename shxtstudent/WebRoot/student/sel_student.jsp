<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>无标题文档</title>
	<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="#">首页</a></li>
		<li><a href="#">学生管理</a></li>
		<li><a href="#">查看学生</a></li>
	</ul>
</div>

<form action="stu_sel.action" method="post" rel="pageForm">
<div class="rightinfo">

	<div class="tools">
		<ul class="toolbar">
			<li class="click"><span><img src="images/t01.png"/></span>添加</li>
			<li class="click"><span><img src="images/t02.png"/></span>修改</li>
			<li><span><img src="images/t03.png"/></span>删除</li>
			<li><span><img src="images/t04.png"/></span>统计</li>
		</ul>
		<ul class="toolbar1">
			<li><span><img src="images/t05.png"/></span>设置</li>
		</ul>
	</div>

	<table class="imgtable">
		<thead>
			<tr>
				<th width="100px;">缩略图</th>
				<th>ID</th>
				<th>姓名</th>
				<th>地址</th>
				<th>生日</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="stuList">
			<tr>
				<td class="imgtd"><img src="<%=basePath %>upload/${photo}" width="50"/></td>
				<td>${id }</td>
				<td>${name }</td>
				<td>${address }</td>
				<td>
					<s:date name="birthday" format="yyyy年MM月dd日"/>
				</td>
				<td>
					<a href="stu_updateShow.action?id=${id }">修改</a>				
					<a href="stu_delete.action?id=${id }">删除</a>		
				</td>
			</tr>
			</s:iterator>
		</tbody>
	</table>
	
	<jsp:include page="/plugins/page/page.jsp"></jsp:include>

</div>
</form>



<script type="text/javascript" src="<%=basePath %>plugins/jQuery/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$('.imgtable tbody tr:odd').addClass('odd');
	});
    
</script>

</body>

</html>

