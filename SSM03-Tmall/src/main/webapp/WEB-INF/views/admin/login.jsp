<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/9/20
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="/css/admin/loginForm.css">
</head>

<body>

<div class="main">
    <div class="header">
        <h1>管理员登录</h1>
    </div>

    <form:form commandName="administrator" action="/admin/login/post" method="post" id="login_form">

        <div class="form-group">
            <label for="admin-username">账号</label>
            <form:input type="username" path="username" id="admin-username" placeholder="Username"
                        class="form-control" value="${username}" />
        </div>

        <div class="form-group">
            <label for="admin-password">密码</label>
            <a class="pull-right text-warning active"  href="">${message}</a>
            <form:input type="password" path="password" id="admin-password" placeholder="Password"
                        class="form-control"/>
        </div>

        <button type="submit" class="btn btn-success btn-block">登录</button>
    </form:form>

</div>
</body>
</html>
