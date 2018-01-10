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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
<title>添加奖惩记录</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-reward-edit">
	
	<input type="text" id="id" name="id" style="display: none;" value="${reward.id }"/>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>员工号</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${reward.empId }" placeholder="" id="empId" name="empId">
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>姓名</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${reward.name }" placeholder="" id="name" name="name">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>奖/惩</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${reward.reward }" placeholder="" id="reward" name="reward">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>奖惩内容</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${reward.content }" placeholder="" id="content" name="content">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>奖惩原因</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${reward.reason }" placeholder="" id="reason" name="reason">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>奖惩金额</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${reward.amount }" placeholder="" id="amount" name="amount">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>批准部门</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${reward.approvalDep }" placeholder="" id="approvalDep" name="approvalDep">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>负责人</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${reward.head }" placeholder="" id="head" name="head">
		</div>
	</div>
	
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">备注：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<textarea id="remark" name="remark" cols="" rows="" class="textarea"  placeholder="说点什么...100个字符以内" dragonfly="true" onKeyUp="$.Huitextarealength(this,100)">${reward.remark }</textarea>
			<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
		</div>
	</div>
	
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" onclick="edit()" type="button" value="&nbsp;&nbsp;修改&nbsp;&nbsp;">
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
	function edit(){
		var empId = $("#empId").val();
		var name = $("#name").val();
		var reward = $("#reward").val();
		var content = $("#content").val();
		var reason = $("#reason").val();
		var amount = $("#amount").val();
		var approvalDep = $("#approvalDep").val();
		var head = $("#head").val();
		if(empId == ""){ layer.alert("请输入员工号"); return; }
		if(name == ""){ layer.alert("请输入名字"); return; }
		if(reward == ""){ layer.alert("请输入奖/惩"); return; }
		if(content == ""){ layer.alert("请输入奖惩内容"); return; }
		if(reason == ""){ layer.alert("请输入奖惩原因"); return; }
		if(amount == ""){ layer.alert("请输入奖惩金额"); return; }
		if(approvalDep == ""){ layer.alert("请输入批准部门"); return; }
		if(head == ""){ layer.alert("请输入负责人"); return; }
		if( empId != "" && name != "" && reward !="" && content !="" 
				&& reason !="" && amount !="" && approvalDep !="" && head !=""){
			$.ajax({
				type:"POST",
				url:"${pageContext.request.contextPath}/reward/editReward",
				data:$("#form-reward-edit").serialize(),
				dataType:"JSON",
				async:true,
				success:function(data){
					if(data == 1){
						layer.confirm('修改成功', {
				            btn : [ '返回列表', '取消' ]//按钮
				        }, function(index) {
				        	var index = layer.load(1,{shade: [0.7, '#393D49']}, {shadeClose: true}); //0代表加载的风格，支持0-2				            
				            layer_close(index);				            
				        });
					}else{
						layer.alert("修改失败");
					}
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					layer.alert("修改异常！");
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