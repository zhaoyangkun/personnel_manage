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
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0"> 
	<title>登录界面</title>
    <link href="<%=basePath %>/css/login/default.css" rel="stylesheet" type="text/css" />
	<!--必要样式-->
    <link href="<%=basePath %>/css/login/styles.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath %>/css/login/demo.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath %>/css/login/loaders.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath %>/js/layui/css/layui.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class='login'>
	  <div class='login_title'>
	    <span>登录</span>
	  </div>
	  <div class='login_fields'>
	    <div class='login_fields__user'>
	      <div class='icon'>
	        <img alt="" src='<%=basePath %>/img/login/user_icon_copy.png'>
	      </div>
	      <input name="phone" placeholder='用户名' maxlength="16" type='text' autocomplete="off" value=""/>
	        <div class='validation'>
	          <img alt="" src='<%=basePath %>/img/login/tick.png'>
	        </div>
	    </div>
	    <div class='login_fields__password'>
	      <div class='icon'>
	        <img alt="" src='<%=basePath %>/img/login/lock_icon_copy.png'>
	      </div>
	      <input name="password" placeholder='密码' maxlength="16" type='text' autocomplete="off">
	      <div class='validation'>
	        <img alt="" src='<%=basePath %>/img/login/tick.png'>
	      </div>
	    </div>
	    <div class='login_fields__password'>
	      <div class='icon'>
	        <img alt="" src='<%=basePath %>/img/login/key.png'>
	      </div>
	      <input name="code" placeholder='验证码' maxlength="4" type='text' name="ValidateNum" autocomplete="off">
	      <div class='validation' style="opacity: 1; right: -5px;top: -3px;">
          <canvas class="J_codeimg" id="myCanvas" onclick="Code();">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
	      </div>
	    </div>
	    <div class='login_fields__submit'>
	      <input type='button' value='登录'>
	    </div>
	  </div>
	  <div class='success'>
	  </div>
	  <div class='disclaimer'>
	    <p>欢迎登录后台管理系统 </p>
	  </div>
	</div>
	<div class='authent'>
	  <div class="loader" style="height: 44px;width: 44px;margin-left: 28px;">
        <div class="loader-inner ball-clip-rotate-multiple">
            <div></div>
            <div></div>
            <div></div>
        </div>
        </div>
	  <p>认证中...</p>
	</div>
	<div class="OverWindows"></div>
	
	
	<script type="text/javascript" src="<%=basePath %>/js/login/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>/js/login/jquery-ui.min.js"></script>
	<script type="text/javascript" src='<%=basePath %>/js/login/stopExecutionOnTimeout.js?t=1'></script>
    <script type="text/javascript" src="<%=basePath %>/js/layui/layui.js"></script>
    <script type="text/javascript" src="<%=basePath %>/js/login/Particleground.js"></script>
    <script type="text/javascript" src="<%=basePath %>/js/login/Treatment.js"></script>
    <script type="text/javascript" src="<%=basePath %>/js/login/jquery.mockjax.js"></script>
	<script type="text/javascript">
		var canGetCookie = 0;//是否支持存储Cookie 0 不支持 1 支持
		var ajaxmockjax = 0;//是否启用虚拟Ajax的请求响 0 不启用  1 启用
		
		var CodeVal = 0;
	    Code();
	    function Code() {
			if(canGetCookie == 1){
				createCode("AdminCode");
				var AdminCode = getCookieValue("AdminCode");
				showCheck(AdminCode);
			}else{
				showCheck(createCode(""));
			}
	    }
	    function showCheck(a) {
			CodeVal = a;
	        var c = document.getElementById("myCanvas");
	        var ctx = c.getContext("2d");
	        ctx.clearRect(0, 0, 1000, 1000);
	        ctx.font = "80px 'Hiragino Sans GB'";
	        ctx.fillStyle = "#E8DFE8";
	        ctx.fillText(a, 0, 100);
	    }
	    $(document).keypress(function (e) {
	        // 回车键事件  
	        if (e.which == 13) {
	            $('input[type="button"]').click();
	        }
	    });
	    //粒子背景特效
	    $('body').particleground({
	        dotColor: '#E8DFE8',
	        lineColor: '#133b88'
	    });
	    $('input[name="password"]').focus(function () {
	        $(this).attr('type', 'password');
	    });
	    $('input[type="text"]').focus(function () {
	        $(this).prev().animate({ 'opacity': '1' }, 200);
	    });
	    $('input[type="text"],input[type="password"]').blur(function () {
	        $(this).prev().animate({ 'opacity': '.5' }, 200);
	    });
	    $('input[name="phone"],input[name="password"]').keyup(function () {
	        var Len = $(this).val().length;
	        if (!$(this).val() == '' && Len >= 5) {
	            $(this).next().animate({
	                'opacity': '1',
	                'right': '30'
	            }, 200);
	        } else {
	            $(this).next().animate({
	                'opacity': '0',
	                'right': '20'
	            }, 200);
	        }
	    });
	    var open = 0;
	    layui.use('layer', function () {
	        //非空验证
	        $('input[type="button"]').click(function () {
	            var phone = $('input[name="phone"]').val();
	            var password = $('input[name="password"]').val();
	            var code = $('input[name="code"]').val();
	            if (phone == '') {
	                ErroAlert('请输入您的账号');
	            } else if (password == '') {
	                ErroAlert('请输入密码');
	            } else if (code == '' || code.length != 4) {
	                ErroAlert('输入验证码');
	            } else {
	                
					
	                if(code.toUpperCase() == CodeVal.toUpperCase()){			//验证码转成大写验证
	                	 //1.$.ajax带json数据的异步请求 :登录验证
		                $.ajax( {  
		                  url:"${pageContext.request.contextPath }/basic/login",	                   
		                  type:'post', 
		                  data:{"phone":phone,"password":password}, 
		                  cache:false,  
		                  dataType:'json',  
		                  success:function(data) {  
			               		if(data == 1){    
			                    	layer.msg("登录成功！");  	
			                    	check_wait();
			                    	window.location.href = '${pageContext.request.contextPath }/basic/index';
			                    }else if(data == 2){  
			                    	layer.msg("登录失败！");  	
			                    }else{
			                    	layer.msg("不存在该账号！");
			                    }
		                   },  
		                   error : function() {  
		                   		layer.msg('异常！');  
		                   }  
		                });	             	                
	                } 
	                else{
	                	ErroAlert("验证码错误！");
	                }
	               
	                
	                function check_wait(){
	                    setTimeout(function () {
                            $('.authent').show().animate({ right: 90 }, {
                                easing: 'easeOutQuint',
                                duration: 600,
                                queue: false
                            });
                            $('.authent').animate({ opacity: 0 }, {
                                duration: 200,
                                queue: false
                            }).addClass('visible');
                            $('.login').removeClass('testtwo'); //平移特效
                        }, 2000);
                        setTimeout(function () {
                            $('.authent').hide();
                            $('.login').removeClass('test');
                            if (data.Status == 'ok') {
                                //登录成功
                                $('.login div').fadeOut(100);
                                $('.success').fadeIn(1000);
                                $('.success').html(data.Text);
								//跳转操作												
                            } else {
                                AjaxErro(data);
                            }
                        }, 2400);
	                }
					
								
	                /* AjaxPost
	                (
	                	url, 
	                	JsonData,	                              
	                	function () {
	                                    //ajax加载中
	                    },
	                   function (data) {
	                        //ajax返回 
	                        //认证完成
	                                    setTimeout(function () {
	                                        $('.authent').show().animate({ right: 90 }, {
	                                            easing: 'easeOutQuint',
	                                            duration: 600,
	                                            queue: false
	                                        });
	                                        $('.authent').animate({ opacity: 0 }, {
	                                            duration: 200,
	                                            queue: false
	                                        }).addClass('visible');
	                                        $('.login').removeClass('testtwo'); //平移特效
	                                    }, 2000);
	                                    setTimeout(function () {
	                                        $('.authent').hide();
	                                        $('.login').removeClass('test');
	                                        if (data.Status == 'ok') {
	                                            //登录成功
	                                            $('.login div').fadeOut(100);
	                                            $('.success').fadeIn(1000);
	                                            $('.success').html(data.Text);
												//跳转操作												
	                                        } else {
	                                            AjaxErro(data);
	                                        }
	                                    }, 2400);
	                                }) */
	           	 }
	        })
	    })
    </script>
</body>
</html>