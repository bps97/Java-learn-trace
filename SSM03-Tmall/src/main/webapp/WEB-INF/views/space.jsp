<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head lang="en">
	<meta charset="UTF-8">
	<title>登录</title>


	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<link rel="stylesheet" href="/css/basic.css"/>
	<link href="/css/login.css" rel="stylesheet" type="text/css">


	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		var gohome = function () {
			window.location.href='/index';

		}
		var submitInfo = function () {
			$("#userInfoForm").submit();
		}
	</script>




</head>

<body>

<div class="login-boxtitle">
	<a href="/index"><img alt="logo" src="/img/logobig.png"/></a>
</div>

<div class="login-banner" >
	<div class="login-main">
		<div class="login-banner-bg"><span></span><img src="/img/big.png"/></div>
		<div class="login-box" >
			<h3 class="title">信息修改</h3>
			<div class="clear"></div>

			<div class="login-form">
				<form id="userInfoForm" action="/postSubmitInfo" method="post">
					<div class="user-name">
						<label for="name_3"  ><i class="mr-icon-user"></i></label>
						<input type="text" name="name" id="name_3" placeholder="你的昵称" value="${user.name}" >
					</div>
					<div class="user-phone">
						<label for="phone_3" ><i class="mr-icon-phone"></i></label>
						<input type="text" name="phone" id="phone_3" placeholder="你的手机号" readonly value="${user.phone}">
					</div>
					<div class="user-email">
						<label for="email_3" ><i class="mr-icon-google"></i></label>
						<input type="email" name="email" id="email_3" placeholder="你的邮箱" value="${user.email}" >
					</div>

					<div class="user-pass">
						<label for="birthday_3"><i class="mr-icon-birthday-cake"></i></label>
						<input type="date" name="birthday" id="birthday_3" placeholder="你的生日" value="${user.birthday}">
					</div>

				<%--					<div class="user-name">--%>
<%--						<label for="file_3" ><i class="mr-icon-file"></i> </label>--%>
<%--							   <input type="file" id="file_3" placeholder="你的文件" name="file_3">--%>
<%--					</div>--%>
				</form>
			</div>

			<div class="mr-cf">
				<input type="submit" name="" value="提 交"  onclick="submitInfo()" class="mr-btn mr-btn-primary mr-btn-sm " style="border-radius: 14px;">
			</div>




		</div>
	</div>
</div>


<div class="footer ">
	<div class="footer-hd ">
		<p>
			<a href="http://www.mingrisoft.com/" target="_blank">明日科技</a>
			<b>|</b>
			<a href="//index">商城首页</a>
			<b>|</b>
			<a href="#">支付宝</a>
			<b>|</b>
			<a href="#">物流</a>
		</p>
	</div>
	<div class="footer-bd ">
		<p>
			<a href="http://www.mingrisoft.com/Index/ServiceCenter/aboutus" target="_blank">关于明日</a>
			<a href="#">合作伙伴</a>
			<a href="#">联系我们</a>
			<a href="#">网站地图</a>
			<em>© 2016-2025 mingrisoft.com 版权所有</em>
		</p>
	</div>
</div>
</body>
<%--<script>--%>
<%--	$(document).ready(function () {--%>
<%--		var time = new Date();--%>
<%--		var day = ("0" + time.getDate()).slice(-2);--%>
<%--		var month = ("0" + (time.getMonth() + 1)).slice(-2);--%>
<%--		var today = time.getFullYear() + "-" + (month) + "-" + (day);--%>
<%--		$('#birthday_3').val(today);--%>
<%--	})--%>
<%--</script>--%>

</html>