<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<title>添加部门</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-department-add">
	<input type="text" class="input-text" value="${work.id}" style="display: none" placeholder="" id="id" name="id">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>姓名：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${work.name}" placeholder="" id="name" name="name">
		</div>
	</div>
	
	<!-- <div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>出生日期：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="date" name="date" class="input-text Wdate" style="width:120px;">
		</div>
	</div> -->
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>部门：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<span class="select-box" style="width:150px;">
				<select id="depId" name="depId" class="select" onchange="searchjob()">
					<c:forEach items="${listd}" var="dep">
					<c:if test="${dep.id eq work.depId }"><option value="${dep.id}" selected="selected">${dep.name}</option></c:if>
					<c:if test="${dep.id != work.depId }"><option value="${dep.id}">${dep.name}</option></c:if>
					</c:forEach>
				</select>
			</span>
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>职位：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<span class="select-box" style="width:150px;">
				<select id="depJob" name="depJob" class="select"">
					<c:forEach items="${listj}" var="job">
					<c:if test="${job.id eq work.depJob }"><option value="${job.id}" selected="selected">${job.name}</option></c:if>
					<c:if test="${job.id != work.depJob }"><option value="${job.id}">${job.name}</option></c:if>
					</c:forEach>
				</select>
			</span>
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">备注：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<textarea id="remark" name="remark" cols="" rows="" class="textarea"  placeholder="" dragonfly="true" onKeyUp="">
			</textarea>
		</div>
	</div>
	
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" onclick="add()" type="button" value="&nbsp;&nbsp;添加&nbsp;&nbsp;">
		</div>
	</div>
	
	</form>
</article>

<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="<%=basePath %>/H-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath %>/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath %>/H-ui/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="<%=basePath %>/H-ui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/H-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/H-ui/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/H-ui/lib/laypage/1.3/laypage.js"></script>
<script type="text/javascript">

/* window.onload = (function(){
	 	$("#depId").val("${depId}");
}); 

function searchjob() {
	var depId = document.getElementById("depId").value;
	window.location.href="/personnel_manage/basicInfo/addInfoDisp?depId="+depId;
} */
	function add(){
		var dep = $("#depId").val();
		var job = $("#depJob").val();
		if(dep == ""){ layer.alert("请输入部门"); return; }
		if(job == ""){ layer.alert("请输入职位"); return; }
			$.ajax({
				type:"POST",
				url:"${pageContext.request.contextPath}/basicInfo/addInfo",
				data:$("#form-department-add").serialize(),
				dataType:"JSON",
				async:true,
				success:function(data){
					if(data == 1){
						layer.confirm('添加成功', {
				            btn : [ '返回列表', '取消' ]//按钮
				        }, function(index) {		            
				            layer_close();
				            var index = layer.load(0,{shade: [0.7, '#393D49']}, {shadeClose: true}); //0代表加载的风格，支持0-2				            
				        });
					}else{
						layer.alert("添加失败");
					}
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					layer.alert("添加异常！");
				}
			});
	}
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
});
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>