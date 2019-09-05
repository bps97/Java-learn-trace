<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<head lang="en">
    <meta charset="UTF-8">
    <title>注册</title>

    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>

    <script type="text/javascript">

        function checkPhone() {
            var phone = $('#tel').val();
            console.log(phone);
            var url = "checkPhone.do";
            $.post(url, {'phone': phone}, function (responseDate, status, xhr) {
                if (status == 'success') {
                    if (responseDate == 0) {
                        alert("该电话已经注册过账号");
                    } else {
                        console.log(responseDate);
                    }
                }
            })

        }

    </script>

    <script type="text/javascript">
        function mr_verify() {

            //获取表单对象
            var regPassword = $("#regPassword").val();
            var passwordRepeat = $("#passwordRepeat").val();
            var tel = $("#tel").val();

            console.log(regPassword);
            console.log(passwordRepeat);
            console.log(tel);

            //验证项目是否为空
            if (regPassword === '' || regPassword === null) {
                alert("密码不能为空！");
                return;
            }
            if (passwordRepeat === '' || passwordRepeat === null) {
                alert("确认密码不能为空！");
                return;
            }
            if (tel === '' || tel === null) {
                alert("手机号码不能为空！");
                return;
            }

            if (regPassword !== passwordRepeat) {
                alert("密码设置前后不一致！");
                return;
            }

            //验证手机号格式
            if (isNaN(tel)) {
                alert("手机号请输入数字！");
                return;
            }
            if (tel.length !== 11) {
                alert("手机号是11个数字！");
                return;
            }

            var url = "postReg.do";
            var data = {"phone": tel, "password": regPassword};
            $.post(url, data, function (responseBody, status, xhr) {
                if (status == "success") {
                    if (responseBody == '1') {
                        window.location.href = '/index';
                    } else {
                        alert("注册失败");
                    }
                }
            })


        }
    </script>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" href="/css/basic.css"/>
    <link href="/css/login.css" rel="stylesheet" type="text/css">
</head>


<div class="login-boxtitle">
    <a href="/index.html"><img alt="" src="/img/logobig.png"/></a>
</div>

<div class="res-banner">
    <div class="res-main">
        <div class="login-banner-bg"><span></span><img src="/img/big.png"/></div>
        <div class="login-box">


            <h3 class="title">注册</h3>
            <div class="clear"></div>


            <div class="login-form">
                <form id="loginForm" action="/postLogin" method="post">
                    <div class="user-pass">
                        <label for="tel"><i class="mr-icon-mobile"></i></label>
                        <input type="text" name="phone" id="tel" placeholder="请输入手机号" onblur="checkPhone()">
                    </div>
                    <div id="regBlock" style="color: red;display: block">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                    <div class="user-pass">
                        <label for="regPassword"><i class="mr-icon-lock"></i></label>
                        <input type="password" name="password" id="regPassword" placeholder="设置密码">
                    </div>
                    <div class="user-pass">
                        <label for="passwordRepeat"><i class="mr-icon-lock"></i></label>
                        <input type="password" name="password2" id="passwordRepeat" placeholder="确认密码">
                    </div>
                </form>
            </div>

            <div class="login-links">
                <label for="reader-me">
                    <input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》

                </label>
                <a href="/login" class="mr-fr">登录</a>
            </div>
            <div class="mr-cf">
                <input type="submit" name="" onclick="mr_verify()" value="注册"
                       class="mr-btn mr-btn-primary mr-btn-sm mr-fl" style="background-color: #3db922
">
            </div>

        </div>
    </div>

    <div class="footer ">
        <div class="footer-hd ">
            <p>
                <a href="http://www.mingrisoft.com/" target="_blank">明日科技</a>
                <b>|</b>
                <a href="//index.html">商城首页</a>
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
</div>
</body>
</html>