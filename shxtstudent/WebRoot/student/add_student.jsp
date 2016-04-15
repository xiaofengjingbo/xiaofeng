<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="#">首页</a></li>
		<li><a href="#">学生管理</a></li>
	</ul>
</div>

<form action="stu_add.action" method="post" enctype="multipart/form-data" class="validate" onsubmit="return validateForm(this);" >
	<div class="formbody">
		<div class="formtitle"><span>添加学生</span></div>
		<ul class="forminfo">
			<li>
				<label>姓名</label>
				<input name="stu.name" type="text" class="dfinput required" />
				<i>标题不能超过30个字符</i>
			</li>
			<li>
				<label>密码</label>
				<input name="stu.password" type="text" class="dfinput" />
				<i>标题不能超过30个字符</i>
			</li>
			<li>
				<label>地址</label>
				<input name="stu.address" type="text" class="dfinput" />
				<i>标题不能超过30个字符</i>
			</li>
			<li>
				<label>生日</label>
				<input name="stu.birthday" type="text" class="dfinput date" style="width: 100px;"/>
				<i>标题不能超过30个字符</i>
			</li>
			<li>
				<label>头像</label>
				<input name="photo" type="file" onchange="preview(this,'preview','imghead',150,200)"/>
				
				<div id="preview">
					<img id="imghead" width="202" height="111"/>
				</div>
			</li>
			<li>
				<label>&nbsp;</label>
				<input name="" type="submit" class="btn" value="确认保存"/>
			</li>
		</ul>
	</div>
</form>


<script type="text/javascript" src="<%=basePath %>plugins/jQuery/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate.js"></script>
<script type="text/javascript" src="<%=path%>plugins/My97DatePicker/WdatePicker.js"></script> 	<!-- 日期时间控件 -->
<script type="text/javascript" src="<%=path %>plugins/imagePreview/imagePreview.js"></script>
</body>
</html>
	