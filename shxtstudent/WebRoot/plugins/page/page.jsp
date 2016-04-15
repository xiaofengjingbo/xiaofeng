<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<input type="hidden" name="page.index" value="${page.index}" id="index"/>
	<div class="pagin">
		<div class="message">共<i class="blue">${page.rows}</i>条记录，当前显示第&nbsp;<i class="blue">${page.index}&nbsp;</i>页</div>
		<ul class="paginList">
			<li class="paginItem"><a href="javascript:paging('prev');"><span class="pagepre"></span></a></li>
			<li class="paginItem"><a href="javascript:;">1</a></li>
			<li class="paginItem current"><a href="javascript:;">2</a></li>
			<li class="paginItem"><a href="javascript:;">3</a></li>
			<li class="paginItem"><a href="javascript:;">4</a></li>
			<li class="paginItem"><a href="javascript:;">5</a></li>
			<li class="paginItem more"><a href="javascript:;">...</a></li>
			<li class="paginItem"><a href="javascript:;">10</a></li>
			<li class="paginItem"><a href="javascript:paging('next');"><span class="pagenxt"></span></a></li>
		</ul>
	</div>
	
<script type="text/javascript">
	function paging(type) {
		var $input = $("#index");
		var index =  parseInt($input.val());//当前页数
		
		if(type == "prev") {
			index--;
		}else if(type == "next") {
			index++;
		}
		
		$input.val(index);
		$("form[rel='pageForm']").submit();
	}
</script>
