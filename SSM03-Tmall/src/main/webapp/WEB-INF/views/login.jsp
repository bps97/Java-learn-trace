<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>登录</title>


    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" href="../css/basic.css"/>
    <link href="../css/login.css" rel="stylesheet" type="text/css">



</head>

<body>

<div class="login-boxtitle">
    <a href="../../index.html"><img alt="logo" src="../img/logobig.png"/></a>
</div>

<div class="login-banner">
    <div class="login-main">
        <div class="login-banner-bg"><span></span><img src="../img/big.png"/></div>
        <div class="login-box">
            <h3 class="title">登录</h3>
            <div class="clear"></div>
            <div class="login-form">
                <form method="post" action="/logining" >
                    <div class="user-name">
                        <label for="loginName"><i class="mr-icon-user"></i></label>
                        <input type="text" name="loginName" id="loginName" placeholder="邮箱/手机" >
                    </div>
                    <div class="user-pass">
                        <label for="password"><i class="mr-icon-lock"></i></label>
                        <input type="password" name="password" id="password" placeholder="请输入密码">
                    </div>


                    <a href="../register.html" class="mr-fr">注册</a>
                    <br/>

                <div class="mr-cf">
                    <input type="submit" name="" value="登 录"  class="mr-btn mr-btn-primary mr-btn-sm">
                </div>
                </form>

            </div>


            <div class="partner">
                <h3>合作账号</h3>
                <div class="mr-btn-group">
                    <li><a href="#"><i class="mr-icon-qq mr-icon-sm"></i><span>QQ登录</span></a></li>
                    <li><a href="#"><i class="mr-icon-weibo mr-icon-sm"></i><span>微博登录</span> </a></li>
                    <li><a href="#"><i class="mr-icon-weixin mr-icon-sm"></i><span>微信登录</span> </a></li>
                </div>
            </div>

        </div>
    </div>
</div>


<div class="footer ">
    <div class="footer-hd ">
        <p>
            <a href="http://www.mingrisoft.com/" target="_blank">明日科技</a>
            <b>|</b>
            <a href="../../index.html">商城首页</a>
            <b>|</b>
            <a href="#">支付宝</a>
            <b>|</b>
            <a href="#">物流</a>
        </p>
    </div>
    <div class="footer-bd ">
        <p>
            <a href="http://www.mingrisoft.com/Index/ServiceCenter/aboutus.html" target="_blank">关于明日</a>
            <a href="#">合作伙伴</a>
            <a href="#">联系我们</a>
            <a href="#">网站地图</a>
            <em>© 2016-2025 mingrisoft.com 版权所有</em>
        </p>
    </div>
</div>
</body>


</html>