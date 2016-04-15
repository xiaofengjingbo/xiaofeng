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
	<style type="text/css">
		.forminfo li label {
		    width: 120px;
		}
	</style>
</head>

<body>

<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="#">首页</a></li>
		<li><a href="#">表单</a></li>
	</ul>
</div>

<form action="">
	<div class="formbody">
		<div class="formtitle"><span>日历控件</span></div>
		<ul class="forminfo">
			<li>
				<label>默认：</label>
				<input name="" type="text" style="width: 100px;" class="dfinput date" />
				<i>yyyy-MM-dd</i>
			</li>
			
			<li>
				<label>定义日期范围：</label>
				<input name="" type="text" style="width: 100px;" class="dfinput date"  minDate="2014-04-15" maxDate="2014-06-15"/>
				<i></i>
			</li>
			<li>
				<label>动态参数minDate：</label>
				<input name="" type="text" style="width: 100px;" class="dfinput date"  dateFmt="dd/MM/yy" minDate="{%y-10}-%M-%d" maxDate="{%y}-%M-{%d+1}"/>
				<i>dd/MM/yy</i>
			</li>
			<li>
				<label>自定义日期格式：</label>
				<input name="" type="text" style="width: 100px;" class="dfinput date"  dateFmt="yyyy/MM/dd"/>
				<i>dd/MM/yyyy</i>
			</li>
			<li>
				<label>自定义日期格式：</label>
				<input name="" type="text" style="width: 100px;" class="dfinput date"  dateFmt="yyyyMMdd"/>
				<i>yyyyMMdd</i>
			</li>
			<li>
				<label>自定义日期格式：</label>
				<input name="" type="text" style="width: 100px;" class="dfinput date"  dateFmt="yyyy年MM月dd日"/>
				<i>yyyy年MM月dd日</i>
			</li>
			<li>
				<label>自定义日期格式：</label>
				<input name="" type="text" style="width: 100px;" class="dfinput date"  dateFmt="y年M月d日"/>
				<i>y年M月d日</i>
			</li>
			<li>
				<label>自定义日期范围：</label>
				<input name="" type="text" style="width: 100px;" class="dfinput date"  maxId="dateMax" id="dateMin"/> -
				<input name="" type="text" style="width: 100px;" class="dfinput date"   minId="dateMin" id="dateMax"/>
				<i>这两个日期控件需要成对出现</i>
			</li>
		</ul>
		
		<div class="formtitle"><span>日期 + 时间</span></div>
		<ul class="forminfo">
			<li>
				<label>自定义日期格式：</label>
				<input name="" type="text" style="width: 150px;" class="dfinput date" dateFmt="yyyy-MM-dd HH:mm:ss"/>
				<i>yyyy-MM-dd HH:mm:ss</i>
			</li>
			<li>
				<label>自定义日期格式：</label>
				<input name="" type="text" style="width: 150px;" class="dfinput date" dateFmt="yyyy-MM-dd HH:mm"/>
				<i>yyyy-MM-dd HH:mm</i>
			</li>
			<li>
				<label>自定义日期格式：</label>
				<input name="" type="text" style="width: 150px;" class="dfinput date" dateFmt="yyyy-MM-dd HH:ss"/>
				<i>yyyy-MM-dd HH:ss</i>
			</li>
			<li>
				<label>自定义日期格式：</label>
				<input name="" type="text" style="width: 150px;" class="dfinput date" dateFmt="y年M月d日 H点"/>
				<i>y年M月d日 H点</i>
			</li>
			<li>
				<label>自定义日期格式：</label>
				<input name="" type="text" style="width: 150px;" class="dfinput date" dateFmt="EEE HH:mm:ss"/>
				<i>EEE HH:mm:ss</i>
			</li>
			<li>
				<label>自定义只有时间：</label>
				<input name="" type="text" style="width: 100px;" class="dfinput date" dateFmt="HH:mm:ss" />
				<i>HH:mm:ss</i>
			</li>
			<li>
				<label>自定义时间：</label>
				<input name="" type="text" style="width: 100px;" class="dfinput date" dateFmt="HH:mm"/>
				<i>HH:mm</i>
			</li>
		</ul>
	</div>
</form>


<script type="text/javascript"  src="<%=basePath %>plugins/jQuery/jquery.js"></script>
<script type="text/javascript" src="<%=path%>plugins/My97DatePicker/WdatePicker.js"></script> 	<!-- 日期时间控件 -->
</body>
</html>
	