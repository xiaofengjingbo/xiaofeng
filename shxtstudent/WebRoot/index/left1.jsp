<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>" target="rightFrame"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
</head>

<body style="background:#f0f9fd;">

<div class="lefttop"><span></span>通讯录</div>
<dl class="leftmenu">
	
	<!-- 一个模块开始 -->
	<dd>
		<div class="title">
			<span><img src="<%=basePath %>images/leftico01.png" /></span>管理信息
		</div>
		<ul class="menuson">
			<li><cite></cite><a href="index.html" >首页模版</a><i></i></li>
			<li class="active"><cite></cite><a href="right.html" >数据列表</a><i></i></li>
			<li><cite></cite><a href="imgtable.html" >图片数据表</a><i></i></li>
			<li><cite></cite><a href="form.html" >添加编辑</a><i></i></li>
			<li><cite></cite><a href="imglist.html" >图片列表</a><i></i></li>
			<li><cite></cite><a href="imglist1.html" >自定义</a><i></i></li>
			<li><cite></cite><a href="tools.html" >常用工具</a><i></i></li>
			<li><cite></cite><a href="filelist.html" >信息管理</a><i></i></li>
			<li><cite></cite><a href="tab.html" >Tab页</a><i></i></li>
			<li><cite></cite><a href="error.html" >404页面</a><i></i></li>
		</ul>    
	</dd>
	<!-- 一个模块结束 -->
	
	<dd>
		<div class="title"><span><img src="<%=basePath %>images/leftico04.png" /></span>日期管理</div>
		<ul class="menuson">
			<li><cite></cite><a href="#">自定义</a><i></i></li>
			<li><cite></cite><a href="#">常用资料</a><i></i></li>
			<li><cite></cite><a href="#">信息列表</a><i></i></li>
			<li><cite></cite><a href="#">其他</a><i></i></li>
		</ul>
	</dd>   
</dl>


<script type="text/javascript" src="<%=basePath %>plugins/jQuery/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
</body>
</html>
