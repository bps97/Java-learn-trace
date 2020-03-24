<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html class="allow-animation">
<head>
    <meta charset="utf-8">
    <title>手机端演示</title>
    <link rel="stylesheet" href="/css/mobile.css"/>
</head>
<body>
<div class="main-container">
    <div class="inner clearfix">
        <div class="app-container">
            <div class="display-area">
                <div class="mobile-simulator"><h3 class="title ellipse">手机端展示</h3>
                    <iframe id="app-iframe" src="index" class="iframe"></iframe>
                </div>
                <a href="/index" class="enter-editor">返回 PC端</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>

