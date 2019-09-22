<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>


<rapid:override name="head_content">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="/css/box.css"/>
    <link rel="stylesheet" type="text/css" href="/css/admin.css"/>
    <link rel="stylesheet" type="text/css" href="/css/hmstyle.css"/>

</rapid:override>


<rapid:override name="main_content">

    <div class="banner">

        <!--轮播 -->
        <div class="mr-slider mr-slider-default scoll" data-mr-flexslider id="demo-slider-0">
            <div id="box">
                <ul id="imagesUI" class="list">
                    <c:forEach items="${ads}" var="ad" varStatus="status">
                        <li style="opacity: 0;"><img  src="${ad.toString()}"/></li>
                    </c:forEach>
                </ul>
                <ul id="btnUI" class="step">


                    <c:forEach items="${ads}" varStatus="status">
                        <li class="">${status.index}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="clear"></div>

    </div><!--结束banner-->


    <div class="shopNav">

        <div class="slideall">

            <div class="long-title"><span class="all-goods">全部分类</span></div>

            <div class="nav-cont">
                <ul>
                    <li class="index"><a href="#">首页</a></li>
                    <li class="qc"><a href="#">闪购</a></li>
                    <li class="qc"><a href="#">生鲜</a></li>
                    <li class="qc"><a href="#">团购</a></li>
                    <li class="qc last"><a href="#">全球购</a></li>
                </ul>
                <div class="nav-extra">
                    <i class="mr-icon-user-secret mr-icon-md nav-user"></i><b></b>我的福利
                    <i class="mr-icon-angle-right" style="padding-left: 10px;"></i>
                </div>
            </div>

            <!--侧边导航 -->
            <div id="nav" class="navfull">
                <div class="area clearfix">
                    <div class="category-content" id="guide_2">
                        <div class="category">
                            <ul class="category-list" id="js_climit_li">

                                <c:forEach items="${categoryGroup}" var="categories">
                                    <li class="appliance js_toggle relative " onmouseover="mouseOver(this)"
                                        onmouseout="mouseOut(this)">
                                        <div class="category-info">
                                            <h3 class="category-name b-category-name">
                                                <i><img src="/img/cake.png"></i>
                                                <a class="ml-22">
                                                    <c:forEach items="${categories}" var="category"><c:out
                                                            value="${category.getName()} "/></c:forEach>
                                                </a>
                                            </h3>
                                        </div>
                                        <div class="menu-item menu-in top">
                                            <div class="area-in">
                                                <div class="area-bg">
                                                    <div class="menu-srot">
                                                        <div class="sort-side">
                                                            <c:forEach items="${categories}" var="category">
                                                                <dl class="dl-sort">
                                                                    <dt><span>${category.getName()}</span></dt>
                                                                    <c:forEach
                                                                            items="${categoryDict.get(category.getId())}"
                                                                            var="categoryDemo">
                                                                        <dd><a href="/good?key=${categoryDemo.getName()}"><span><c:out
                                                                                value="${categoryDemo.getName()}"/></span></a>
                                                                        </dd>
                                                                    </c:forEach>
                                                                </dl>
                                                            </c:forEach>


                                                        </div>


                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <b class="arrow"></b>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <!--小导航   mobile -->
            <div class="mr-g mr-g-fixed smallnav">
                <div class="mr-u-sm-3">
                    <a href="views/shopList.jsp"><img src="/img/navsmall.jpg"/>
                        <div class="title">商品分类</div>
                    </a>
                </div>
                <div class="mr-u-sm-3">
                    <a href="views/shopList.jsp"><img src="/img/huismall.jpg"/>
                        <div class="title">大聚惠</div>
                    </a>
                </div>
                <div class="mr-u-sm-3">
                    <a href="views/shopList.jsp"><img src="/img/mansmall.jpg"/>

                        <div class="title">个人中心</div>
                    </a>
                </div>
                <div class="mr-u-sm-3">
                    <a href="views/shopList.jsp"><img src="/img/moneysmall.jpg"/>
                        <div class="title">投资理财</div>
                    </a>
                </div>
            </div>

            <!--走马灯-->

            <div class="marqueen">
                <div class="demo">
                    <ul>


                        <div class="mod-vip">
                            <div class="m-baseinfo">
                                <a href="/index">
                                    <img src="/img/getAvatar.do.jpg">
                                </a>
                                <em>
                                    Hi,<span class="s-name">${(sessionScope.get("username") != null)?(sessionScope.get("username")):"请登录"}</span>
                                    <a href="#"><p>点击更多优惠活动</p></a>
                                </em>
                            </div>
                            <div class="member-logout">
                                <a class="mr-btn-warning btn" href="/login">登录</a>
                                <a class="mr-btn-warning btn" href="/register">注册</a>
                            </div>
                            <div class="member-login">
                                <a href="#"><strong>0</strong>待收货</a>
                                <a href="#"><strong>0</strong>待发货</a>
                                <a href="#"><strong>0</strong>待付款</a>
                                <a href="#"><strong>0</strong>待评价</a>
                            </div>
                            <div class="clear"></div>
                        </div>

                        <li><a target="_blank" href="#"><span>[特惠]</span>洋河年末大促，低至两件五折</a></li>
                        <li><a target="_blank" href="#"><span>[公告]</span>华北、华中部分地区配送延迟</a></li>
                        <li><a target="_blank" href="#"><span>[特惠]</span>家电狂欢千亿礼券 买1送1！</a></li>

                    </ul>
                    <div class="advTip"><img src="/img/advTip.jpg"/></div>
                </div>
            </div>

            <div class="clear"></div>
        </div><!--slideall-->

    </div><!--结束shopNav-->

    <div class="shopMainbg">
        <div class="shopMain" id="shopmain">
            <!--今日推荐 -->
            <div class="mr-g mr-g-fixed recommendation">
                <div class="clock mr-u-sm-3">
                    <img src="/img/2016.png "></img>

                    <p>今日<br>推荐</p>
                </div>
                <div class="mr-u-sm-4 mr-u-lg-3 ">
                    <div class="info ">
                        <h3>真的有鱼</h3>
                        <h4>开年福利篇</h4>
                    </div>
                    <div class="recommendationMain one">
                        <a href="shopList.html"><img src="/img/tj.png "></a>
                    </div>
                </div>
                <div class="mr-u-sm-4 mr-u-lg-3 ">
                    <div class="info ">
                        <h3>囤货过冬</h3>
                        <h4>让爱早回家</h4>
                    </div>
                    <div class="recommendationMain two">
                        <a href="shopList.html"><img src="/img/tj1.png "></a>
                    </div>
                </div>
                <div class="mr-u-sm-4 mr-u-lg-3 ">
                    <div class="info ">
                        <h3>浪漫情人节</h3>
                        <h4>甜甜蜜蜜</h4>
                    </div>
                    <div class="recommendationMain three ">
                        <a href="shopList.html"><img src="/img/tj2.png "></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="clear "></div>

</rapid:override>

<rapid:override name="script_content">

    <script type="text/javascript">
        //鼠标滑出事件


        var mouseOver = function (obj) {
            obj.className = "appliance js_toggle relative hover";     //设置当前事件对象样式
            var menu = obj.childNodes;                                   //寻找该事件子节点（商品子类别）
            menu[3].style.display = 'block';                            //设置子节点显示


        }

        // 鼠标滑入事件
        function mouseOut(obj) {
            obj.className = "appliance js_toggle relative";           //设置当前事件对象样式
            var menu = obj.childNodes;                                  //寻找该事件子节点（商品子类别）
            menu[3].style.display = 'none';                            //设置子节点隐藏
        }


        $(document).ready(function () {
            if($("div.mod-vip em span").text() != "请登录"){
                $("div.mod-vip div.member-logout:first").hide();
                $("div.mod-vip div.member-login:first").show();
            }

        })

    </script>
    <script type="text/javascript" src="js/ready.js"></script>

</rapid:override>

<%@ include file="base.jsp" %>
