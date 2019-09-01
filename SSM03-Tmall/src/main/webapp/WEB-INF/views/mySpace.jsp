<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>


<rapid:block name="head_content">
	<title>个人中心</title>

	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.slim.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.bootcss.com/font-awesome/5.10.2/css/all.css" rel="stylesheet">


	<style>

	</style>

</rapid:block>



<rapid:override name="main_content">

<%--这里bootstrap会让个人信息窗口显示出来--%>






<div class="container">
	<div class="row">
		<div class="col-md-1">&nbsp;</div>
	</div>
	<div class="row">

		<div class="col-md-4 col-md-offset-4">

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>用户信息修改</h4>
				</div>
				<div class="panel-body" >

					<form action="/postSubmitInfo" class="form-horizontal">
						<div class="form-group ">
							<lable for="name_3" class="control_label" class="col-md-2">昵称</lable>
							<div class="col-md-10" >
								<input type="text" class="form-control" id="name_3" name="name" placeholder="昵称" value="${user.name}">
							</div>
						</div>
						<div class="form-group ">
							<lable for="email_3" class="control_label" class="col-md-2">邮箱</lable>
							<div class="col-md-10">
								<input type="email" class="form-control" id="email_3" name="email" placeholder="邮箱" value="${user.email}">
							</div>
						</div>
						<div class="form-group ">
							<lable for="email_3" class="control_label" class="col-md-2">电话</lable>
							<div class="col-md-10">
								<input type="text" class="form-control" id="phone_3" name="phone" placeholder="电话号码" value="${user.phone}" readonly>
							</div>
						</div>
						<div class="form-group " >
							<div class="btn btn-group col-md-offset-1"></div>
								<input type="submit" class="btn btn-primary" value="提交修改" >
								<a  class="btn btn-success" href="/index">点击返回</a>
						</div>
					</form>

				</div>
			</div>
		</div>

	</div>
</div>

<div class="container">


</div>
</rapid:override>


<rapid:override name="script_content">
	<script type="text/javascript">
		var gohome = function () {
			window.location.href='/index';

		}
	</script>
</rapid:override>


<%@ include file="viewBase.jsp" %>