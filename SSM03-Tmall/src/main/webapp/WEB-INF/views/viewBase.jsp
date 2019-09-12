<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/8/31
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js" type="text/javascript"></script>

    <link rel="stylesheet" type="text/css" href="/css/basic.css"/>
    <link rel="stylesheet" type="text/css" href="/css/demo.css"/>


    <rapid:block name="head_content">
        <%--        这里是叠层样式表等头文件内容--%>
    </rapid:block>

</head>
<body>
<div class="hmtop">
    <!--顶部导航条 -->


    <div class="mr-container header">
        <ul class="message-l">
            <div class="topMessage">
                <div class="menu-hd">
                    <a href="/login" target="_top" class="h" style="color: red"
                       class="a-login">欢迎！${(sessionScope.get("username") != null)?(sessionScope.get("username")):"亲，请登录"}</a>
                    <a href="/register" target="_top" style="color: red" class="a-registor">免费注册</a>
                    <%--                    <a href="/mySpace" target="_top" style="color: deepskyblue">个人中心</a>--%>
                </div>
            </div>
        </ul>
        <ul class="message-r">
            <div class="topMessage home">
                <div class="menu-hd"><a href="/mobile" style="color:red">手机端</a></div>
            </div>
            <div class="topMessage home">
                <div class="menu-hd"><a href="/index" target="_top" class="h" style="color:red">商城首页</a></div>
            </div>
            <div class="topMessage my-shangcheng">
                <div class="menu-hd MyShangcheng"><a href="/space" target="_top"><i
                        class="mr-icon-user mr-icon-fw"></i>个人中心</a>
                </div>
            </div>
            <div class="topMessage mini-cart">
                <div class="menu-hd"><a id="mc-menu-hd" href="/shop" target="_top"><i
                        class="mr-icon-shopping-cart  mr-icon-fw"></i><span style="color:red">购物车</span><strong
                        id="J_MiniCartNum"
                        class="h">0</strong></a>
                </div>
            </div>
            <div class="topMessage favorite">
                <div class="menu-hd"><a href="#" target="_top"><i class="mr-icon-heart mr-icon-fw"></i><span>收藏夹</span></a>
                </div>
            </div>
        </ul>
    </div>

    <!--悬浮搜索框-->
    <div class="nav white">
        <div class="logo"><a href="index.jsp"><img src="/img/logo.png"/></a></div>
        <div class="logoBig">
            <li><img src="/img/logobig.png"/></li>
        </div>
        <div class="search-bar pr">
            <a name="index_none_header" href="#"></a>
            <form action="/good">
                <input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
                <input id="ai-topsearch" class="submit mr-btn" value="搜索" index="1" type="submit">
            </form>
        </div>
    </div>
    <div class="clear"></div>

</div><%--hmtop--%>


<rapid:block name="main_content">
    <!-- 注意这里是内容 -->
</rapid:block>



<%--尾部--%>
<div class="clear"></div>
<div class="footer ">
    <div class="footer-hd ">
        <p>
            <a href="http://www.mingrisoft.com/" target="_blank">bpsCopyright</a>
            <b>|</b>
            <a href="index.jsp">商城首页</a>
            <b>|</b>
            <a href="#">支付宝</a>
            <b>|</b>
            <a href="#">物流</a>
        </p>
    </div>
    <div class="footer-bd ">
        <p>
            <a href="http://www.mingrisoft.com/Index/ServiceCenter/aboutus.jsp" target="_blank">关于明日</a>
            <a href="#">合作伙伴</a>
            <a href="#">联系我们</a>
            <a href="#">网站地图</a>
            <em>© 2016-2025 mingrisoft.com 版权所有</em>
        </p>
    </div>
</div>


<!--引导 mobile底部-->
<div class="navCir">
    <li class="active"><a href="/index"><i class="mr-icon-home "></i>首页</a></li>
    <li><a href="/good"><i class="mr-icon-list"></i>商品</a></li>
    <li><a href="/shop"><i class="mr-icon-shopping-basket"></i>购物车</a></li>
    <li><a href="/space"><i class="mr-icon-user"></i>我的</a></li>
</div>
<!--菜单 -->
<div class="tip">
    <div id="sidebar">
        <div id="wrap">
            <div id="prof" class="item">
                <a href="#"> <span class="setting"></span> </a>
                <input type="hidden" class="userId" value="${sessionScope.get("userId")}"/>
                <div class="ibar_login_box status_login show">
                    <div class="avatar_box">
                        <p class="avatar_imgbox"><img src="/img/no-img_mid_.jpg"/></p>
                        <ul class="user_info">
                            <li>用户名：<strong>mingriSoft</strong></li>
                            <li>级&nbsp;别：<strong>金牌会员</strong></li>
                        </ul>
                    </div>
                    <div class="login_btnbox">
                        <a href="#" class="login_order">我的订单</a>
                        <a href="#" class="login_favorite">我的收藏</a>
                    </div>
                    <i class="icon_arrow_white"></i>
                </div>
            </div>
            <div id="shoppingCart" class="item">
                <a href="/shop"> <span class="message"></span> </a>

                <p> 购物车 </p>

                <p class="cart_num">1</p>
            </div>
            <div id="asset" class="item">
                <a href="#"> <span class="view"></span> </a>

                <div class="mp_tooltip show">
                    我的资产
                    <i class="icon_arrow_right_black"></i>
                </div>
            </div>
            <div id="foot" class="item">
                <a href="#"> <span class="zuji"></span> </a>

                <div class="mp_tooltip show">
                    我的足迹
                    <i class="icon_arrow_right_black"></i>
                </div>
            </div>
            <div id="brand" class="item">
                <a href="#"> <span class="wdsc"><img src="/img/wdsc.png"/></span> </a>

                <div class="mp_tooltip show">
                    我的收藏
                    <i class="icon_arrow_right_black"></i>
                </div>
            </div>
            <div id="broadcast" class="item">
                <a href="#"> <span class="chongzhi"><img src="/img/chongzhi.png"/></span> </a>

                <div class="mp_tooltip show">
                    我要充值
                    <i class="icon_arrow_right_black"></i>
                </div>
            </div>
            <div class="quick_toggle">
                <li class="qtitem" id="kehu"><a href="#"><span class="kfzx"></span></a>

                    <div class="mp_tooltip show">
                        客服中心
                        <i class="icon_arrow_right_black"></i>
                    </div>
                </li>
                <!--二维码 -->
                <li class="qtitem"><a href="#none"><span class="mpbtn_qrcode"></span></a>

                    <div class="mp_qrcode" style="display:none;">
                        <img src="/img/weixincode.png"/>
                        <i class="icon_arrow_white"></i>
                    </div>
                </li>
                <li class="qtitem"><a href="#top" class="return_top"><span class="top"></span></a></li>
            </div>
            <!--回到顶部 -->
            <div id="quick_links_pop" class="quick_links_pop hide"></div>
        </div>
    </div>
    <div id="prof-content" class="nav-content">
        <div class="nav-con-close">
            <i class="mr-icon-angle-right mr-icon-fw"></i>
        </div>
        <div>
            我
        </div>
    </div>
    <div id="shoppingCart-content" class="nav-content">
        <div class="nav-con-close">
            <i class="mr-icon-angle-right mr-icon-fw"></i>
        </div>
        <div>
            购物车
        </div>
    </div>
    <div id="asset-content" class="nav-content">
        <div class="nav-con-close">
            <i class="mr-icon-angle-right mr-icon-fw"></i>
        </div>
        <div>
            资产
        </div>
        <div class="ia-head-list">
            <a href="#" target="_blank" class="pl">
                <div class="num">
                    0
                </div>
                <div class="text">
                    优惠券
                </div>
            </a>
            <a href="#" target="_blank" class="pl">
                <div class="num">
                    0
                </div>
                <div class="text">
                    红包
                </div>
            </a>
            <a href="#" target="_blank" class="pl money">
                <div class="num">
                    ￥0
                </div>
                <div class="text">
                    余额
                </div>
            </a>
        </div>
    </div>
    <div id="foot-content" class="nav-content">
        <div class="nav-con-close">
            <i class="mr-icon-angle-right mr-icon-fw"></i>
        </div>
        <div>
            足迹
        </div>
    </div>
    <div id="brand-content" class="nav-content">
        <div class="nav-con-close">
            <i class="mr-icon-angle-right mr-icon-fw"></i>
        </div>
        <div>
            收藏
        </div>
    </div>
    <div id="broadcast-content" class="nav-content">
        <div class="nav-con-close">
            <i class="mr-icon-angle-right mr-icon-fw"></i>
        </div>
        <div>
            充值
        </div>
    </div>
</div>





</body>
<script type="text/javascript">
    $(document).ready(function () {



        var url = '/userInfo.do';
        var userId = $("input.userId").val();

        // $('#prof').hide();


        if(userId != ""){
            $.ajax({
                url:url,
                type:'get',
                data:{'userId':userId},
                datatype:'json',
                success:function (resp) {
                    var name = resp.name;
                    $('#prof div div ul li:first strong').text(name);
                },
                error:function () {
                    alert("error");
                }
            })

        }

        var temp = $("a[href=\\/login]").text();
        if(temp != '欢迎！亲，请登录'){
            $("a[href=\\/login]").attr('href','/mySpace');
        }


    })
</script>

<rapid:block name="script_content">
    <%--  这里是js脚本   --%>
</rapid:block>


</html>
