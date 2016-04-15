<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理</title>
    <link href="<%=path %>/resource/admin/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=path %>/resource/admin/js/jquery.js"></script>
    <script type="text/javascript">
    $(function(){
    	toPage();
    })
    
    function toPage(){
    	
    	//alert($("#searchForm").serialize())
    	$.post("sys/findUserAction.action",$("#searchForm").serialize(),function(pageBean){
    		
    		//alert(JSON.stringify(pageBean))
    		//return false;
    		if(pageBean!=null){
    			var datas = pageBean.datas;
                
                if(datas!=null&&datas.length>0){
                    for(var i=0;i<datas.length;i++){
                        var tr = '<tr><td><input name="user_id" type="radio" value="'+datas[i].user_id+'" /></td><td>'+((i+1)+(pageBean.pageNow-1)*pageBean.pageSize)+'</td><td>'+datas[i].account+'</td><td>'+datas[i].user_name+'</td><td>'+datas[i].sex+'</td><td>'+datas[i].create_date+'</td></tr> ';
                    
                        $(".tablelist tbody").append(tr);
                    }
                }
                
                $("#totalPages").val(pageBean.totalPages);
               
    		}
    	});
    }
    
    function loadMore(){
    	//获取当前页
        var pageNow = $("#pageNow").val();
    	//获取总页数
    	var totalPages = $("#totalPages").val();
    	if(parseInt(pageNow)==parseInt(totalPages)){
    		return false;
    	}else{
    		 $("#pageNow").val(parseInt(pageNow)+1);
    		 
    		 toPage();
    	}
    }
    
    </script>
</head>

<body>

    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
        <li>用户管理</li>
        </ul>
    </div>

     <div class="tools">
        <!--  
          <ul class="seachform">
    
            <li>
                <label>综合查询</label><input name="user_name" id="user_name" type="text" class="scinput" />
                <div class="myauto">

                </div>
            </li>
            <li><label>指派</label>  
            <select class="select_show">
            <option>全部</option>
            <option>其他</option>
            </select>
            </li>
            
            <li><label>重点客户</label>  
            <select class="select_show">
            <option>全部</option>
            <option>其他</option>
            </select>
            </li>
            
            <li><label>客户状态</label>  
            <select class="select_show">
            <option>全部123</option>
            <option>其他123</option>
            </select>
            </li>
            
            <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查询"/></li>
            
            </ul>
        
        
        <ul class="seachform1">
        <li><span><img src="../images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
  -->
    <form id="searchForm">
        <input type="text" name="pageBean.pageNow" id="pageNow" value="${pageBean.pageNow }">
        <input type="text" id="totalPages" >
    </form>
     <div class="pagin" align="center">
        <input  type="button" class="scbtn" value="加载更多" onclick="loadMore()"/>
     </div>
    <table class="tablelist">
        <thead>
        <tr>
        <th>标识</i></th>
        <th>编号</th>
        <th>账号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>创建时间</th>
       
        </tr>
        </thead>
        <tbody>
       
        
      
    
        </tbody>
    </table>
    
    
  
    
 
       

    
    <script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
    </script>
    
    
    
    
    
  


</body>

</html>