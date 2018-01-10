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
	<form class="form form-horizontal" id="form-transfer-add">
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>员工：</label>
		<!-- <div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="empId" name="empId">
		</div> -->
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select" name="empId" id="empId" size="1">
				<c:forEach items="${workList }" var="list"> 
					<option value="${list.id }" selected="selected">${list.name }</option>					
				</c:forEach>
			</select>
			</span> 
		</div>
	</div>
	
<!-- 	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>调动前部门：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="beforeDepId" name="beforeDepId">
		</div>
	</div> -->
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色调动前部门：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select" name="beforeDepId" id="beforeDepId" size="1">
				<c:forEach items="${departmentList }" var="list"> 
					<option value="${list.id }" selected="selected">${list.name }</option>					
				</c:forEach>
			</select>
			</span> 
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>调动后部门：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select" name="laterDepId" id="laterDepId" size="1">
				<c:forEach items="${departmentList }" var="list"> 
					<option value="${list.id }" selected="selected">${list.name }</option>					
				</c:forEach>
			</select>
			</span> 
		</div>
	</div>
	
<!-- 	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>调动后部门：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="laterDepId" name="laterDepId">
		</div>
	</div> -->
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>调动前职务：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select" name="beforeJobId" id="beforeJobId" size="1">
				<c:forEach items="${jobList }" var="list"> 
					<option value="${list.id }" selected="selected">${list.name }</option>					
				</c:forEach>
			</select>
			</span>
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>调动后职务：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select" name="laterJobId" id="laterJobId" size="1">
				<c:forEach items="${jobList }" var="list"> 
					<option value="${list.id }" selected="selected">${list.name }</option>					
				</c:forEach>
			</select>
			</span> </div>
	</div>
	
<!-- 	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>调动后职务：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="laterJobId" name="laterJobId">
		</div>
	</div> -->
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>调动理由：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="reason" name="reason">
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>审核结果：</label>
		<!-- <div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="result" name="result">
		</div> -->
		<div class="formControls col-xs-8 col-sm-9"> 
			<span class="select-box" style="width:150px;">
				<select class="select" name="result" id="result" size="1">
					<option value="0">未通过</option>	
					<option value="1">通过</option>	
				</select>
			</span>
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>审核人：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="auditor" name="auditor">
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
<script type="text/javascript" src="<%=basePath %>/H-ui/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="<%=basePath %>/H-ui/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="<%=basePath %>/H-ui/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
	function add(){
		if($("#empId").val == ""){ layer.alert("请选择员工"); return; }
		if($("#beforeDepId").val == ""){layer.alert("请选择调动前部门"); return;  }
		if($("#laterDepId").val == ""){ layer.alert("请选择调动后部门"); return; }
		if($("#beforeJobId").val == ""){ layer.alert("请选择调动前职务"); return; }
		if($("#laterJobId").val == ""){ layer.alert("请选择调动后职务"); return; }
		if($("#result").val == ""){ layer.alert("请选择审核结果"); return; }
		if($("#auditor").val == ""){ layer.alert("请输入审核人"); return; }
			$.ajax({
				type:"POST",
				url:"${pageContext.request.contextPath}/transfer/AddTransfer",
				data:$("#form-transfer-add").serialize(),
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