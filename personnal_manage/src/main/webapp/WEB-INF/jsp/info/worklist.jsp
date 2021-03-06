<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.HashMap" %>
	<%@page import="java.util.Map" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>	
<!DOCTYPE HTML>
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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/H-ui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/H-ui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/H-ui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/H-ui/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/H-ui/lib/laypage/1.3/skin/laypage.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>信息管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 信息管理 <span class="c-gray en">&gt;</span> 入职信息管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
  <div class="text-c"> 部门：
	  <span class="select-box" style="width:150px;">
		  <select id="department" onchange="searchdep()" class="select">
		  	<option value="" selected="selected">全部</option>
		  	<c:forEach items="${listd}" var="dep">
		  		<option value="${dep.id}">${dep.name}	</option>
		  	</c:forEach>
		  </select> 
	  </span>
     职位:
      <span class="select-box" style="width:150px;">
		  <select id="job" onchange="job()" class="select">
		  	<option value="" selected="selected">全部</option>
		  		<c:if test="${not empty listjp}">
		  			<c:forEach items="${listjp}" var="job">
		  				<option value="${job.id}">${job.name}	</option>
		  			</c:forEach>
		  		</c:if>
		  </select> 
	  </span>
    <!-- <input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px;"> -->
    <input type="text" class="input-text" style="width:250px" placeholder="请输入关键字" id="search" name=""><button type="submit" class="btn btn-success" id="" name="" onClick="searchcar()"><i class="icon-search"></i> 搜索</button>
  </div>
  <div class="cl pd-5 bg-1 bk-gray mt-20">
    <span class="l"><a href="javascript:;" onclick="exportExcel()" class="btn btn-danger radius"><i class="icon-trash"></i> 导出到excel</a></span>
    <span><a href="javascript:;" onclick="addInfo('添加信息','addInfoDisp','','510')" class="btn btn-danger radius" style="position:relative; margin-left:5px;"><i class="icon-trash"></i> 添加信息</a></span>
    <span class="r">共有数据：<strong>${page.getTotalCount() }</strong> 条</span>
  </div>
  <table class="table table-border table-bordered table-hover table-bg table-sort">
    <thead>
      <tr class="text-c">
        <th width="25"><input type="checkbox" name="" value=""></th>
        <th width="30">姓名</th>
        <th width="60">部门</th>
        <th width="60">职位</th>
        <th width="60">备注</th>
	    <th width="30">操作</th>
       </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="basic" varStatus="test">
    	<tr class="text-c">
    			<td>${basic.id}</td>
    			<td>${basic.name}</td>
				<td>
				<c:forEach items="${listd}" var="dep">
					<c:if test="${basic.depId eq dep.id}">${dep.name}</c:if>
				</c:forEach>
				</td>
				<td>
				<c:forEach items="${listj }" var="job" >
					<c:if test="${job.id eq basic.depJob }">${job.name}</c:if>
				</c:forEach>
				</td>
				<td>${basic.remark}</td>
				<td class="td-manage">
				  <a style="text-decoration:none" class="ml-5" href="javascript:;" onclick="editcar('修改信息','${pageContext.request.contextPath }/basicInfo/editInfoDisp?id=${basic.id}')" ><i class="Hui-iconfont">&#xe6df;</i></a>
				  <a style="text-decoration:none" class="ml-5" onclick="deletebyid(this,${basic.id})" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
				 </td>
		</tr>
	</c:forEach>	
			</tr>
 
    </tbody>
   
  </table>
  	<div align="center">  
        <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第  
            ${page.pageNow} 页</font> <a href="<%=basePath %>/basicInfo/showInfo?pageNow=1&key=${key}&depId=${depId}&jobId=${jobId}">首页</a>  
        <c:choose>  
            <c:when test="${page.pageNow - 1 > 0}">  
                <a href="<%=basePath %>/basicInfo/showInfo?pageNow=${page.pageNow - 1}&key=${key}&depId=${depId}&jobId=${jobId}">上一页</a>  
            </c:when>  
            <c:when test="${page.pageNow - 1 <= 0}">  
                <a href="<%=basePath %>/basicInfo/showInfo?pageNow=1&key=${key}&depId=${depId}&jobId=${jobId}">上一页</a>  
            </c:when>  
        </c:choose>  
        <c:choose>  
            <c:when test="${page.totalPageCount==0}">  
                <a href="<%=basePath %>/basicInfo/showInfo?pageNow=${page.pageNow}&key=${key}&depId=${depId}&jobId=${jobId}">下一页</a>  
            </c:when>  
            <c:when test="${page.pageNow + 1 < page.totalPageCount}">  
                <a href="<%=basePath %>/basicInfo/showInfo?pageNow=${page.pageNow + 1}&key=${key}&depId=${depId}&jobId=${jobId}">下一页</a>  
            </c:when>  
            <c:when test="${page.pageNow + 1 >= page.totalPageCount}">  
                <a href="<%=basePath %>/basicInfo/showInfo?pageNow=${page.totalPageCount}&key=${key}&depId=${depId}&jobId=${jobId}">下一页</a>  
            </c:when>  
        </c:choose>  
        <c:choose>  
            <c:when test="${page.totalPageCount==0}">  
                <a href="<%=basePath %>/basicInfo/showInfo?pageNow=${page.pageNow}&key=${key}&depId=${depId}&jobId=${jobId}">尾页</a>  
            </c:when>  
            <c:otherwise>  
                <a href="<%=basePath %>/basicInfo/showInfo?pageNow=${page.totalPageCount}&key=${key}&depId=${depId}&jobId=${jobId}">尾页</a>  
            </c:otherwise>  
        </c:choose>  
    </div>  
	 <%-- <div id="pageNav" class="pageNav">
	  		<div style="clear: both; align-items: center; display: -webkit-flex; justify-content: center;">
				<input type="" id="page" value="${page.currentPage}">
				<input type="" id="totalPage" value="${page.totalPage}">
				<input type="" id="condition" value="${page.condition}">
				<div id="Pagination" style=""></div>
			</div>
	  </div> --%>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath }/H-ui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/H-ui/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/H-ui/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/H-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/H-ui/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/H-ui/lib/laypage/1.3/laypage.js"></script>
<script type="text/javascript">

function searchdep() {
	var key = document.getElementById("search").value;
	var depId = document.getElementById("department").value;
	window.location.href="/personnel_manage/basicInfo/showInfo?key="+key+"&depId="+depId;
}

function exportExcel() {
	window.location.href="/personnel_manage/basicInfo/exportExcel";
	<%--  $.ajax({
         type:"POST",
         url:"<%=basePath%>/basicInfo/exportExcel",
         
         datatype:"json",
         success:function(data){
             layer.msg('已导出!',{icon:1,time:1000});
             setTimeout("location.reload()",1000);//页面刷新
         },
         error:function(data){
         	layer.msg('导出失败!',{icon:1,time:1000});
         }
     }); --%>
}

function job() {
	var key = document.getElementById("search").value;
	var depId = document.getElementById("department").value;
	var jobId = document.getElementById("job").value;
	window.location.href="/personnel_manage/basicInfo/showInfo?key="+key+"&depId="+depId+"&jobId=" + jobId;
}


function searchcar() {
	var key = document.getElementById("search").value;
	window.location.href="/personnel_manage/basicInfo/showInfo?key="+key+"&pageNow="+${page.pageNow};
}

function carpictureshow(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

function caraccident(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

function carrepair(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

function deletebyid(obj,id,passId){

	layer.confirm('确认要删除吗？',function(index){
		 $.ajax({
             type:"POST",
             url:"<%=basePath%>/basicInfo/deleteInfo",
             data:{"id":id},
             datatype:"json",
             success:function(data){
                 layer.msg('已删除!',{icon:1,time:1000});
                 setTimeout("location.reload()",1000);//页面刷新
             },
             error:function(data){
             	layer.msg('删除失败!',{icon:1,time:1000});
             }
         });
	});
}

function addInfo(title,url){
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

function editcar(title,url,w,h){
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


window.onload = (function(){
	 $("#search").val("${key}");
	 $("#department").val("${depId}");
	 $("#job").val("${jobId}");
    // optional set
   
});


</script>
</body>
</html>
