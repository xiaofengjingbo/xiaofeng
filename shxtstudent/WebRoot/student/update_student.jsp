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

<form action="stu_update.action" method="post" enctype="multipart/form-data" class="validate" onsubmit="return validateForm(this);" >
	<input type="hidden" name="stu.id" value="${stu.id }"/>
	<input type="hidden" name="stu.password" value="${stu.password }"/>
	
	<div class="formbody">
		<div class="formtitle"><span>修改学生</span></div>
		<ul class="forminfo">
			<li>
				<label>姓名</label>
				<input name="stu.name" value="${stu.name }" type="text" class="dfinput required" />
				<i>标题不能超过30个字符</i>
			</li>
			<li>
				<label>地址</label>
				<input name="stu.address"  value="${stu.address }" type="text" class="dfinput" />
				<i>标题不能超过30个字符</i>
			</li>
			<li>
				<label>生日</label>
				
				<input name="stu.birthday" value="<s:date name="stu.birthday" format="yyyy-MM-dd"/>" type="text" class="dfinput date" style="width: 100px;"/>
				<i>标题不能超过30个字符</i>
			</li>
			
			<li>
				<label>类别</label>
				<s:select list="stuTypeList" name="stu.stuType.id" listKey="id" listValue="name"></s:select>
			</li>
			
			<li>
				<label>类别2</label>
				<select name="ddd" id="type"> <!-- stu.stuType.id -->
					<s:iterator value="stuTypeList">
					<option value="${id}">${name}</option>
					</s:iterator>
				</select>
			</li>
			
			<li>
				<label>爱好</label>
				<s:iterator value="hobbyList">
				<input type="checkbox" name="keys" value="${id }"/>${name }
				</s:iterator>
			</li>
			<li>
				<label>头像</label>
				<input type="hidden" name="stu.photo" value="${stu.photo }"/>
				<input name="photo" type="file" onchange="preview(this,'preview','imghead',150,200)"/>
				
				<div id="preview">
					<img id="imghead" width="150" height="200" src="<%=basePath %>upload/${stu.photo}"/>
				</div>
			</li>
			<li>
				<label>&nbsp;</label>
				<input name="" type="submit" class="btn" value="确认修改"/>
			</li>
		</ul>
	</div>
</form>


<script type="text/javascript" src="<%=basePath %>plugins/jQuery/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate.js"></script>
<script type="text/javascript" src="<%=path%>plugins/My97DatePicker/WdatePicker.js"></script> 	<!-- 日期时间控件 -->
<script type="text/javascript" src="<%=path %>plugins/imagePreview/imagePreview.js"></script>

<script type="text/javascript">
$(function() {
	$(":checkbox[name='keys']").val([${keys}]);//多选框回显
	
	$("#type").val(${stu.stuType.id});
	
});
</script>
</body>
</html>
	