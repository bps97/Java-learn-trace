<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/9/22
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/5.10.2/css/all.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/admin/loginForm.css">
</head>
<body>

<div class="main">
    <div class="header">
        <%--            <a href="/">--%>
        <%--                <img src="/img/1.jpg" alt="">--%>
        <%--            </a>--%>
        <h1>广告添加</h1>
    </div>

    <form:form commandName="scrollAd" action="/admin/ad/add/post" method="post" id="login_form" enctype="multipart/form-data">

        <div class="form-group">
            <label for="text">标题</label>
            <form:input type="text" class="form-control" id="text" name="text" placeholder="Title" path="text" value="${scrollAd2.text}"
                        autofocus=""/>
        </div>

        <div class="form-group">
            <label for="link">链接</label>
            <a class="pull-right text-warning active"  href="javascript:image.click()">
                <i class="fa fa-file fa-lg"  ></i>
            </a>

            <form:input type="text" class="form-control" id="link" name="link" placeholder="Link" path="link" value="${scrollAd2.link}" />
        </div>

        <input type="file" id="image" name="image" style="display:none;">
        <button type="submit" class="btn btn-primary btn-block ">提交信息</button>
    </form:form>

</div>
</body>
</html>

