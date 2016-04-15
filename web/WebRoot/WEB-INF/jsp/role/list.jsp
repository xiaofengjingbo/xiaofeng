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
    
     <title>角色管理</title>
    <link href="<%=path %>/resource/admin/css/style.css" rel="stylesheet" type="text/css"/>
    <!-- 引入JQuery支持的库 -->
    <script type="text/javascript" src="<%=path %>/resource/admin/js/jquery.js"></script>
    <!-- 引入artDailog支持的库 -->
    <link rel="stylesheet" href="<%=path %>/resource/admin/artDialog/css/ui-dialog.css">
    <script src="<%=path %>/resource/admin/artDialog/dist/dialog-plus.js"></script>

    <script language="javascript">
        $(function () {
            //导航切换
            $(".imglist li").click(function () {
                $(".imglist li.selected").removeClass("selected")
                $(this).addClass("selected");
            })
        })
    </script>

    <!-- 关于功能测试代码 -->
    <script type="text/javascript">
        function toAddDialog(){
            //测试artDialog是否成功
            //成功需要注意jquery的版本必须是1.7+以上
            var d = top.dialog({
                id:"rightFrame",
                width:700,
                height:500,
                title: '欢迎',
                url:'shxt/add.html',//可以是一个访问路径Action|Servlet等或者jsp页面资源
                onclose: function () {
                if (this.returnValue) {
                    alert(this.returnValue);
                }

            }
            });
            d.showModal();
        }


        //变更状态方法
        function toChangeStatus(){
            var d = dialog({
                title: '提示',
                content: '按钮回调函数返回 false 则不许关闭',
                okValue: '确定',
                ok: function () {
                    this.title('提交中…');
                    return false;
                },
                cancelValue: '取消',
                cancel: function () {}
            });
            d.show();
        }
        /*
           <p><a href="javascript:void(0)" onclick="toUpdateLock('<s:property value="#role.role_id"/>','<s:property value="#role.role_status"/>')">
                <s:if test="#role.role_status==1">锁定</s:if><s:else>解锁</s:else></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)">授权</a></p>
                
                
                <!-- 获取当前登录用户的角色ID
                <input type="text" id="session_role_id" value="${session_user.role.role_id }">
                 -->
                <input type="hidden" id="session_role_id" value="<s:property value="#session.session_user.role.role_id"/>">
        */
        function toUpdateLock(role_id,role_status){
        	//需要把数据传递到后台 -->使用Ajax技术
        	var txt = "";
        	
        	var session_role_id = $("#session_role_id").val();
        	if(session_role_id==role_id){
        		alert("该角色无法进行锁定,正在使用!");
        		return false;
        	}
        	
        	if(role_status=="1"){
        		txt = "[锁定]操作?\n无法进行授权和注销操作，请慎用!";
        	}else{
        		txt = "[解锁]操作?";
        	}
        	
        	
        	if(window.confirm("您是否对该角色进行"+txt)){
        		//-->使用Ajax技术
        		$.post("sys/updateStatusRoleAction.action", {role_id:role_id}, function(data){
        			if(data.flag=="success"){
        				//刷新页面
        				window.location.href = window.location.href;
        			}else{
        				alert(data.message);
        				return false;
        			}
        		})
        	}
        	
        }
        
       
        
        //-->彻底删除操作
       function toDelete(obj,role_id){
    	   var session_role_id = $("#session_role_id").val();
           if(session_role_id==role_id){
               alert("该角色无法进行注销,正在使用!");
               return false;
           }
           
           if(window.confirm("您决定要彻底删除该角色吗?")){
        	   //使用Ajax进行删除操作
               $.post("sys/deleteRoleAction.action", {role_id:role_id}, function(data){
                   if(data.flag=="success"){
                       //刷新页面
                       window.location.href = window.location.href;
                   }else{
                       alert(data.message);
                       return false;
                   }
               })
           }
            
        }
        
       function toAuthorization(obj,role_id){
           //alert(obj.role_status)
           //obj是js对象 -- js对象转换为Jquery
          var role_status = $(obj).attr("role_status");
           if(role_status=="2"){
               alert("该角色已近被锁定，请解锁以后进行该操作");
               return false;
           }
           
           
           var d = top.dialog({
               width:700,
               height:500,
               title: '角色授权操作',
               url:'sys/toAuthorizationRoleAction.action?role_id='+role_id,//可以是一个访问路径Action|Servlet等或者jsp页面资源
               onclose: function () {
               if (this.returnValue) {
                   alert(this.returnValue);
               }

           }
           });
           d.showModal();
           
           
       }



    </script>

</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li>角色管理</li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">
        <ul class="toolbar">

            <li class="click" onclick="toAddDialog()"><span><img src="<%=path %>/resource/admin/images/t01.png"/></span>新建角色</li>
        </ul>

    </div>


    <ul class="imglist">
        <!-- 循环开始 -->
        <s:iterator value="roleList" var="role">

        <li class="selected">
            <span><img src="<%=path %>/resource/admin/images/img01.png"/></span>

            <h2><s:property value="#role.role_name"/></h2>
            
            <p><a href="javascript:void(0)" role_status="<s:property value="#role.role_status"/>"  onclick="toUpdate(this,'<s:property value="#role.role_id"/>')">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" role_status="<s:property value="#role.role_status"/>" onclick="toDelete(this,'<s:property value="#role.role_id"/>')">注销</a></p>

            <p><a href="javascript:void(0)" onclick="toUpdateLock('<s:property value="#role.role_id"/>','<s:property value="#role.role_status"/>')">
                <s:if test="#role.role_status==1">锁定</s:if><s:else>解锁</s:else></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)"  role_status="<s:property value="#role.role_status"/>" onclick="toAuthorization(this,'<s:property value="#role.role_id"/>')">授权</a></p>
        </li>
        </s:iterator>
        <!-- 循环结束-->
      

    </ul>


</div>

        <!-- 获取当前登录用户的角色ID
        <input type="text" id="session_role_id" value="${session_user.role.role_id }">
         -->
        <input type="hidden" id="session_role_id" value="<s:property value="#session.session_user.role.role_id"/>">
</body>

</html>

