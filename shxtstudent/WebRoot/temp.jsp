<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<base href="<%=basePath%>"/>
    
		<title>My JSP 'add_student.jsp' starting page</title>
    
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
		<meta http-equiv="expires" content="0"/>    
		<!--
		<link rel="stylesheet" type="text/css" href="styles.css"/>
		-->

	</head>
  
	<body>
		<h1>修改</h1>
		<form action="stu_update.action" method="post">
			<input type="hidden" name="stu.id" value="${stu.id }"/>
			姓名:<input name="stu.name" value="${stu.name }"/><br/>
			地址：<input name="stu.address" value="${stu.address }"/><br/>
			<input type="submit" value="修改"/>
		</form>
	</body>
</html>
