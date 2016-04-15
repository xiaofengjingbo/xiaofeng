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
		<li><a href="#">表单</a></li>
	</ul>
</div>

<form action="" class="validate" onsubmit="return validateForm(this);" >
	<div class="formbody">
		<div class="formtitle"><span>验证</span></div>
		<ul class="forminfo">
			<li>
				<label><font color="red">*</font>必填</label>
				<input class="dfinput required"/>
				<i>class="required"</i>
			</li>
			<li>
				<label><font color="red">*</font>必填+邮箱</label>
				<input class="dfinput required email" placeholder="请输入您的邮箱"/>
				<i>class="required email"</i>
			</li>
			<li>
				<label>电话</label>
				<input class="dfinput phone" placeholder="请输入您的电话"/>
				<i>class="phone"</i>
			</li>
			<li>
				<label>整数</label>
				<input class="dfinput digits"/>
				<i>class="digits"</i>
			</li>
			<li>
				<label>浮点数</label>
				<input class="dfinput number"/>
				<i>class="number"</i>
			</li>
			<li>
				<label>最小值</label>
				<input class="dfinput" min="5"/>
				<i>min="5"</i>
			</li>
			<li>
				<label>最大值</label>
				<input class="dfinput" max="10"/>
				<i>max="10"</i>
			</li>
			<li>
				<label>最小值-最大值</label>
				<input class="dfinput" min="1" max="10"/>
				<i>min="1" max="10"</i>
			</li>
			<li>
				<label>最小长度</label>
				<input class="dfinput" minlength="6"/>
				<i>minlength="6"</i>
			</li>
			<li>
				<label>最大长度</label>
				<input class="dfinput" maxlength="10"/>
				<i>maxlength="10"</i>
			</li>
			<li>
				<label>最小长度-最大长度</label>
				<input class="dfinput" minlength="6" maxlength="20"/>
				<i>minlength="6" maxlength="20"</i>
			</li>
			<li>
				<label>信用卡</label>
				<input class="dfinput creditcard"/>
				<i>class="creditcard"</i>
			</li>
			<li>
				<label>字母、数字、下划线</label>
				<input class="dfinput alphanumeric"/>
				<i>class="alphanumeric"</i>
			</li>
			<li>
				<label>字母</label>
				<input class="dfinput lettersonly"/>
				<i>class="lettersonly"</i>
			</li>
			<li>
				<label>网址</label>
				<input class="dfinput url"/>
				<i>class="url"</i>
			</li>
			<li>
				<label>&nbsp;</label>
				<input type="submit" class="btn" value="提交"/>
			</li>
		</ul>
	</div>
</form>


<script type="text/javascript" src="<%=basePath %>plugins/jQuery/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate.js"></script>
</body>
</html>
	