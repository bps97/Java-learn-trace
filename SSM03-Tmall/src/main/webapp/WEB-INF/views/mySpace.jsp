<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>


<rapid:block name="head_content">
	<title>个人中心</title>

	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.slim.min.js"></script>
<%--	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>--%>
<%--	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
<%--	<link href="https://cdn.bootcss.com/font-awesome/5.10.2/css/all.css" rel="stylesheet">--%>
	<link href="/css/login.css" rel="stylesheet" type="text/css">


	<style>
		form label{
			background-color:#0c79b1;
			color: #ffffff;
			border-radius: 14px;
		}
		form input{
			background-color: #f7f7f7;
			border-color: #c8c8c8;
			border-radius: 14px;
			color: #969696;
		}
		.login-box{
			background-color: #ffffff;
		}
	</style>

</rapid:block>



<rapid:override name="main_content">

<%--这里bootstrap会让个人信息窗口显示出来--%>




	<div class="login-banner" style="background-color: #c4dfb8">
		<div class="login-main">
			<div class="login-banner-bg"><span></span><img src="/img/big.png"/></div>
			<div class="login-box" >
				<br>
				<h3 class="title">信息修改</h3>
				<div class="clear"></div>

				<br><br>

				<div class="login-form">
					<form id="userInfoForm" action="/postSubmitInfo" method="post">
						<div class="user-name">
							<label for="name_3"  >昵称</label>
							<input type="text" name="name" id="name_3" placeholder="你的昵称" value="${user.name}" >
						</div>
						<div class="user-name">
							<label for="email_3" >邮箱</label>
							<input type="email" name="email" id="email_3" placeholder="你的邮箱" value="${user.email}" >
						</div>
						<div class="user-name">
							<label for="phone_3" >手机</label>
							<input type="text" name="phone" id="phone_3" placeholder="你的手机号" readonly value="${user.phone}">
						</div>
					</form>
				</div>

				<div class="mr-cf">
					<input type="submit" name="" value="提 交" onclick="submitInfo()" class="mr-btn mr-btn-primary mr-btn-sm " style="border-radius: 14px;">
				</div>




			</div>
		</div>
	</div>

</div>
</rapid:override>


<rapid:override name="script_content">
	<script type="text/javascript">
		var gohome = function () {
			window.location.href='/index';

		}
		var submitInfo = function () {
			$("#userInfoForm").submit();
		}
	</script>
</rapid:override>


<%@ include file="viewBase.jsp" %>