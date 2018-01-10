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
<title>添加员工工资信息</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-wages-add">
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>员工号：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="empId" name="empId">
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>姓名：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="name" name="name">
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>部门号：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="depId" name="depId">
		</div>
	</div>

	
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>公积金：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="gjj" name="gjj">
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>养老金：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="ylj" name="ylj">
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>所得税：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="" placeholder="" id="sds" name="sds">
		</div>
	</div>
	
	
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">备注：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<textarea id="remark" name="remark" cols="" rows="" class="textarea"  placeholder="说点什么...100个字符以内" dragonfly="true" onKeyUp="$.Huitextarealength(this,100)">
			</textarea>
			<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
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
		var empId = $("#empId").val();
		var name = $("#name").val();
		var depId = $("#depId").val();
		var basepay = $("#basepay").val();
		var jbbt = $("#jbbt").val();
		var gjj = $("#gjj").val();
		var ylj = $("#ylj").val();
		var sds = $("#sds").val();
		var yfgz = $("#yfgz").val();
		var sjgz = $("#sjgz").val();
		
		
		if(empId == ""){ layer.alert("请输入员工号"); return; }
		if(name == ""){ layer.alert("请输入姓名"); return; }
		if(depId == ""){ layer.alert("请输入部门号"); return; }
		if(basepay == ""){ layer.alert("请输入基本工资"); return; }
		if(jbbt == ""){ layer.alert("请输入加班补贴"); return; }
		if(gjj == ""){ layer.alert("请输入公积金"); return; }
		if(ylj == ""){ layer.alert("请输入养老金"); return; }
		if(sds == ""){ layer.alert("请输入所得税"); return; }
		if(yfgz == ""){ layer.alert("请输入应发工资"); return; }
		if(sjgz == ""){ layer.alert("请输入实际工资"); return; }
		
		
		if( empId != "" && name != "" && depId != "" && basepay != "" && jbbt != "" &&  gjj != "" && ylj != "" && sds != "" && yfgz != "" && sjgz != ""){
			$.ajax({
				type:"POST",
				url:"${pageContext.request.contextPath}/wages/wagesAdd",
				data:$("#form-wages-add").serialize(),
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