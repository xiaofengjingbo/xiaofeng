<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>授权操作</title>
    <style type="text/css">
        #main{
            width: 500px;
        }
        .demo{width:450px; margin:20px auto}
        .select_side{float:left; width:200px}
         select{width:200px; height:200px;border: 1px solid #404040;font-weight: bold}
        .select_opt{float:left; width:40px; height:15%; padding-top: 80px;padding-left: 10px;}
        .select_opt p{width:26px; height:26px; margin-top:6px; background:url(<%=path%>/resource/admin/images/arr.gif) no-repeat; cursor:pointer; text-indent:-999em}
        .select_opt p#toright{background-position:2px 0}
        .select_opt p#toleft{background-position:2px -22px}
        .sub_btn{clear:both; height:42px; line-height:42px; padding-top:10px; text-align:center}
    </style>
<script type="text/javascript" src="<%=path%>/resource/admin/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
    var leftSel = $("#selectL");
    var rightSel = $("#selectR");
    $("#toright").bind("click",function(){      
        leftSel.find("option:selected").each(function(){
            $(this).remove().appendTo(rightSel);
        });
    });
    $("#toleft").bind("click",function(){       
        rightSel.find("option:selected").each(function(){
            $(this).remove().appendTo(leftSel);
        });
    });
    leftSel.dblclick(function(){
        $(this).find("option:selected").each(function(){
            $(this).remove().appendTo(rightSel);
        });
    });
    rightSel.dblclick(function(){
        $(this).find("option:selected").each(function(){
            $(this).remove().appendTo(leftSel);
        });
    });

});

function toSub(){
	//设置为选中状态
	$("#selectR option").prop("selected",true)
}
</script>
</head>

<body>
    <form action="">
    <div id="main">
      <h2 align="center">【${role.role_name}】进行菜单分配操作</h2>
      <div class="demo">
         <div class="select_side">
         <p align="center">未选菜单</p>
         <s:select list="unSelectedMenuList" id="selectL" listKey="menu_id" listValue="menu_name" multiple="true"></s:select>
         </div>
         <div class="select_opt">
            <p id="toright" title="添加">&gt;</p>
            <p id="toleft" title="移除">&lt;</p>
         </div>
         <div class="select_side">
         <p align="center">已选菜单</p>
         <s:select list="selectedMenuList" id="selectR" name="menuIds" listKey="menu_id" listValue="menu_name" multiple="true"></s:select>

         </div>
         <div class="sub_btn"><input type="button" onclick="toSub()" /></div>
      </div>

    </div>
    <!-- 隐藏域 -->
    <input type="hidden" name="role_id" value="${role.role_id }"/>
    </form>

</body>
</html>