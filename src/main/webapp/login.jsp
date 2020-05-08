<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>欢迎登陆！</title>
		<link   rel="stylesheet"   href="${cpath}/static/userdefined/login.css">
		<script type="text/javascript" src="${cpath}/static/js/jquery-1.8.1.min.js"></script>
</head>
<body>

	<div class="gcs-login">

		<div class="login-title">
			<h1>乐语通信服务平台</h1>
		</div>
		<form role="form" action="userLogin" method="post" class="login-form" id="loginform">

		<div id="errormsg" style="color:red;height:15px">${errormsg}</div>
		<div class="gcs-login-container">
			<input type="text" id="username" name="username"  class="input" οnclick="handlefocus()"  placeholder="请输入用户名" />
		</div>

		<div class="gcs-login-container">
			<input type="password" id= "password" name="password"  class="input" placeholder="请输入密码"/>
		</div>

		<div class="gcs-login-container">

			<div class="gcs-login-validation">
				<input type="text" id="captcha"  name="captcha" class="input validation-input" placeholder="请输入验证码"/>
				<img id="captchaimg" class="validation-img" src="${pageContext.request.contextPath}/getCapcha?yz=&time=-1111" title="看不清楚？点击换一张">
			</div>

		</div>

		<br/>
		<br/>

		<div class="gcs-login-container">
			<input type="button" value="立即登录" class="btn-login"  id="login" />
		</div>
		</form>
	</div>
	<script type="text/javascript">

        jQuery(function ($) {

            $("#login").click(function () {


                var pwd = $("#password").val();
                if($("#username").val() == '') {

                    $("#errormsg").html("用户名不能为空");
                    return;
                }
                if( $("#password").val() == '') {

                    $("#errormsg").html("密码不能为空");
                    return;
                }
                if($("#captcha").val() == '') {

                    $("#errormsg").html("验证码不能为空");
                    return;
                }

				$("#loginform")[0].submit();
            });

            $("#captchaimg").on('click',function() {
                $(this).attr("src", "${pageContext.request.contextPath}/getCapcha?yz=&time="+Math.random());
            });
        });



	</script>

</body>

</html>