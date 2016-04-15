<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    

  </head>
  
  <body>
    <form action="sys/loginLoginAction.action" method="post" name="loginForm">
        账号:<input name="user.account" id="account"><br/>
        密码:<input name="user.password" id="password"><br/>
    <input type="submit" value="登录">
    
    <font color="red">${message }</font>
    </form>
  </body>
</html>
