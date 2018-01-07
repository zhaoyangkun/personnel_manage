<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.Map" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="<%=basePath %>/H-ui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/H-ui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/H-ui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/H-ui/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>部门列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 部门管理 <span class="c-gray en">&gt;</span> 部门列表  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray"> 
		<span class="l"> <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" href="javascript:;" onclick="department_add('添加部门','<%=basePath%>/department/departmentAddDisp','','510')"><i class="Hui-iconfont">&#xe600;</i> 添加部门</a> </span>
		<input type="text" class="input-text" style="width:250px" placeholder="请输入关键字" id="search" name="" value="" />
    	<button type="button" class="btn btn-success" id="search" name="search" onclick="search()"><i class="icon-search"></i> 搜索</button> 
		<span class="r">共有数据：<strong>${totalNumber }</strong> 条</span> 
	</div>
	
	<table class="table table-border table-bordered table-hover table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="6">部门管理</th>
			</tr>
			<tr class="text-c">
				<th width="25"><input type="checkbox" value="" name=""></th>
				<th width="60">部门名称</th>
				<th width="60">经理</th>
				<th width="40">部门人数</th>
				<th width="60">备注</th>
				<th width="70">操作</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${departmentList}" var="list" varStatus="state">
				<tr class="text-c">
					<td><input type="checkbox" value="${list.id }" name="id"></td>
					<td>${list.name }</td>
					<td>${list.manager }</td>
					<td>${list.number }</td>
					<td>${list.remark }</td>
					<td class="f-14">
						<a title="编辑" href="javascript:;" onclick="department_edit('部门编辑','<%=basePath%>/department/editDepartmentDisp?id=${list.id }','','510')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> 
						<a title="删除" href="javascript:;" onclick="department_del(this,${list.id })" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath %>/H-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath %>/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath %>/H-ui/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="<%=basePath %>/H-ui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=basePath %>/H-ui/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript">

/*部门-添加*/
function department_add(title,url,w,h){
	var index = layer.open({
		type:2,
		title:title,
		content:url,
		end: function () {
			location.reload();
		}
	})
	layer.full(index);
}

/*部门编辑*/
function department_edit(title,url,id,w,h){
	var index = layer.open({
		type:2,
		title:title,
		content:url,
		end: function () {
			location.reload();
		}
	})
	layer.full(index);
}

/*部门删除*/
function department_del(obj,id){
	layer.confirm('确认要删除部门吗？',function(index){
		$.ajax({
			type:'POST',
			url:'${pageContext.request.contextPath}/department/deleteDepartment',
			data:{"id":id},
			dataType:'json',
			success: function(data){
				if(data == 1){
					$(obj).parents("tr").remove();
					layer.msg('已删除!',{icon:6,time:1000});
				}else{
					layer.msg('删除失败!',{icon:5,time:1000});
				}
				
			},
			error:function(data) {
				layer.msg("删除异常！",{icon:5,time:1000});
			},
		});		
	});
}

/*查询*/
function search(){
	var key = $("#search").val();
	window.location.href="${pageContext.request.contextPath}/department/search?key=" + key; 
}

</script>
</body>
</html>