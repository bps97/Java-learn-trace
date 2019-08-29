<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>首页</title>
    <script type="text/javascript" src="js/ready.js" />
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        //鼠标滑出事件

        var mouseOver = function(obj){
            obj.className="appliance js_toggle relative hover";     //设置当前事件对象样式
            var menu=obj.childNodes;                                   //寻找该事件子节点（商品子类别）
            menu[3].style.display='block';                            //设置子节点显示


            var url = "LoadSubCategory.do";
            $.post(url,{'phone':phone},function (responseDate,status,xhr) {
                if(status == 'success'){
                    if(responseDate == "0"){
                        alert("该电话已经注册过账号");
                    }else{
                        console.log(responseDate);
                    }
                }
            })


        }

        //鼠标滑入事件
        function mouseOut(obj){
            obj.className="appliance js_toggle relative";           //设置当前事件对象样式
            var menu=obj.childNodes;                                  //寻找该事件子节点（商品子类别）
            menu[3].style.display='none';                            //设置子节点隐藏
        }
    </script>

    <style type="text/css">
        #box {
            position: relative;
            width: 100%;
            height: 455px;
            background: #fff;
            border-radius: 5px;
        }

        #box .list {
            position: relative;
            height: 455px;
        }
        @media only screen and (min-width: 1450px){
            #box .list li {
                width: 50%;
                height: 50%;
                margin: auto;
                margin-top: 0px;
                position: absolute;
                top: 0; left: 0; bottom: 0; right: 0;
            }
            #box .count {
                position: absolute;
                left: 900px;
                bottom: 5px;
            }

        }

        @media  screen and (min-width: 800px) and (max-width: 1450px){
            #box .list li {
                width: 50%;
                height: 50%;
                margin: auto;
                margin-top: 0px;
                position: absolute;
                top: 0; left: -100px; bottom: 0; right: 0;
            }
            #box .list li img{
                width: 120%;
            }
            #box .count {
                position: absolute;
                left: 700px;
                bottom: 5px;
            }
        }

        @media  screen and (max-width: 400px){
            #box{
                display: none;
            }

        }

        #box .list li.current {
            opacity: 1;
        }

        #box .count li {
            color: #fff;
            float: left;
            width: 20px;
            height: 20px;
            cursor: pointer;
            margin-right: 5px;
            overflow: hidden;
            background: #6D6B6A;
            opacity: 0.7;
            border-radius: 20px;
            padding-left:5px;
        }

        #box .count li.current {
            color: #fff;
            opacity: 0.7;
            font-weight: 700;
            background: #f60
        }

    </style>

    <link rel="stylesheet" type="text/css" href="css/basic.css"/>
    <link rel="stylesheet" type="text/css" href="css/admin.css"/>
    <link rel="stylesheet" type="text/css" href="css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="css/hmstyle.css"/>
</head>

<body>
<div class="hmtop">
    <!--顶部导航条 -->
    <div class="mr-container header">
        <ul class="message-l">
            <div class="topMessage">
                <div class="menu-hd">
                    <a href="/login" target="_top" class="h" style="color: red">亲，请登录</a>
                    <a href="/register" target="_top" style="color: red">免费注册</a>
                </div>
            </div>
        </ul>
        <ul class="message-r">
            <div class="topMessage home">
                <div class="menu-hd"><a href="views/mobile.jsp" style="color:red">手机端</a></div>
            </div>
            <div class="topMessage home">
                <div class="menu-hd"><a href="index.jsp" target="_top" class="h" style="color:red">商城首页</a></div>
            </div>
            <div class="topMessage my-shangcheng">
                <div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="mr-icon-user mr-icon-fw"></i>个人中心</a>
                </div>
            </div>
            <div class="topMessage mini-cart">
                <div class="menu-hd"><a id="mc-menu-hd" href="views/shopCart.jsp" target="_top"><i
                        class="mr-icon-shopping-cart  mr-icon-fw" ></i><span style="color:red">购物车</span><strong id="J_MiniCartNum"
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
        <div class="logo"><a href="index.jsp"><img src="img/logo.png"/></a></div>
        <div class="logoBig">
            <li><img src="img/logobig.png"/></li>
        </div>
        <div class="search-bar pr">
            <a name="index_none_header_sysc" href="#"></a>
            <form>
                <input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
                <input id="ai-topsearch" class="submit mr-btn" value="搜索" index="1" type="submit">
            </form>
        </div>
    </div>
    <div class="clear"></div>
</div>


<div class="banner">

        <!--轮播 -->
    <div class="mr-slider mr-slider-default scoll" data-mr-flexslider id="demo-slider-0">
        <div id="box">
            <ul id="imagesUI" class="list">
                <li class="current" style="opacity: 1;">
                    <img src="img/ad01.png">
                </li>
                <li style="opacity: 0;"><img src="img/ad02.png" ></li>
                <li style="opacity: 0;"><img src="img/ad03.png" ></li>
                <li style="opacity: 0;"><img src="img/ad04.png" ></li>
            </ul>
            <ul id="btnUI" class="count">
                <li class="current">1</li>
                <li class="">2</li>
                <li class="">3</li>
                <li class="">4</li>
            </ul>
        </div>
    </div>
    <div class="clear"></div>
</div>


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
            <li class="appliance js_toggle relative " onmouseover="mouseOver(this)" onmouseout="mouseOut(this)" >
                <div class="category-info">
                    <h3 class="category-name b-category-name">
                        <i><img src="img/cake.png"></i>
                        <a class="ml-22" title="家用电器">
                            <c:forEach items="${categories}" var="category"><c:out value="${category.getName()}"/></c:forEach>
                        </a>
                    </h3>
                </div>
                <div class="menu-item menu-in top" >
                    <div class="area-in">
                        <div class="area-bg">
                            <div class="menu-srot">
                                <div class="sort-side">
                                    <c:forEach items="${categories}" var="category">
                                        <dl class="dl-sort">
                                        <dt><span>${category.getName()}</span></dt>
                                        <c:forEach items="${categoryDict.get(category.getId())}" var="categoryDemo">
                                        <dd><a  href="views/shopInfo.jsp"><span><c:out value="${categoryDemo.getName()}"/></span></a></dd>
                                        </c:forEach>
                                        </dl>
                                    </c:forEach>




                                </div>
                                <div class="brand-side">
                                    <dl class="dl-sort">
                                        <dt><span>实力商家</span></dt>
                                        <dd><a rel="nofollow" title="海尔" target="_blank" href="#" rel="nofollow">
                                            <span class="red">海尔</span></a></dd>
                                        <dd><a rel="nofollow" title="三星" target="_blank" href="#" rel="nofollow">
                                            <span >三星</span></a></dd>
                                        <dd><a rel="nofollow" title="飞利浦" target="_blank" href="#" rel="nofollow">
                                            <span class="red">飞利浦</span></a></dd>
                                        <dd><a rel="nofollow" title="九阳" target="_blank" href="#" rel="nofollow">
                                            <span>九阳</span></a></dd>
                                        <dd><a rel="nofollow" title="海信" target="_blank" href="#" rel="nofollow">
                                            <span class="red">海信</span></a></dd>

                                    </dl>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <b class="arrow"></b>
            </li>
1
        </c:forEach>
        </ul>
    </div>
</div>

</div>
</div>

<!--小导航
<div class="mr-g mr-g-fixed smallnav">
    <div class="mr-u-sm-3">
        <a href="views/shopList.jsp"><img src="img/navsmall.jpg"/>
            <div class="title">商品分类</div>
        </a>
    </div>
    <div class="mr-u-sm-3">
        <a href="views/shopList.jsp"><img src="img/huismall.jpg"/>
            <div class="title">大聚惠</div>
        </a>
    </div>
    <div class="mr-u-sm-3">
        <a href="views/shopList.jsp"><img src="img/mansmall.jpg"/>

            <div class="title">个人中心</div>
        </a>
    </div>
    <div class="mr-u-sm-3">
        <a href="views/shopList.jsp"><img src="img/moneysmall.jpg"/>
            <div class="title">投资理财</div>
        </a>
    </div>
</div>
-->
<!--走马灯

<div class="marqueen">
    <span class="marqueen-title">商城头条</span>
    <div class="demo">
        <ul>
            <li class="title-first"><a  href="views/shopInfo.jsp">
                <img src="img/TJ2.jpg"></img>
                <span>[特惠]</span>商城爆品1分秒
            </a></li>
            <li class="title-first"><a target="_blank" href="#">
                <span>[公告]</span>商城与长春市签署战略合作协议
                <img src="img/TJ.jpg"></img>
                <p>XXXXXXXXXXXXXXXXXX</p>
            </a></li>

            <div class="mod-vip">
                <div class="m-baseinfo">
                    <a href="../person/index.jsp">
                        <img src="img/getAvatar.do.jpg">
                    </a>
                    <em>
                        Hi,<span class="s-name">小叮当</span>
                        <a href="#"><p>点击更多优惠活动</p></a>
                    </em>
                </div>
                <div class="member-logout">
                    <a class="mr-btn-warning btn" href="views/login.jsp">登录</a>
                    <a class="mr-btn-warning btn" href="views/register.jsp">注册</a>
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
        <div class="advTip"><img src="img/advTip.jpg"/></div>
    </div>
</div>
<div class="clear"></div>
</div>

</div>
<div class="shopMainbg">
<div class="shopMain" id="shopmain">
 -->
<!--今日推荐
<div class="mr-g mr-g-fixed recommendation">
    <div class="clock mr-u-sm-3">
        <img src="img/2016.png "></img>

        <p>今日<br>推荐</p>
    </div>
    <div class="mr-u-sm-4 mr-u-lg-3 ">
        <div class="info ">
            <h3>真的有鱼</h3>
            <h4>开年福利篇</h4>
        </div>
        <div class="recommendationMain one">
            <a href="views/shopList.jsp"><img src="img/tj.png "></a>
        </div>
    </div>
    <div class="mr-u-sm-4 mr-u-lg-3 ">
        <div class="info ">
            <h3>囤货过冬</h3>
            <h4>让爱早回家</h4>
        </div>
        <div class="recommendationMain two">
            <a href="views/shopList.jsp"><img src="img/tj1.png "></a>
        </div>
    </div>
    <div class="mr-u-sm-4 mr-u-lg-3 ">
        <div class="info ">
            <h3>浪漫情人节</h3>
            <h4>甜甜蜜蜜</h4>
        </div>
        <div class="recommendationMain three ">
            <a href="views/shopList.jsp"><img src="img/tj2.png "></a>
        </div>
    </div>

</div>
<div class="clear "></div>
-->
<!--热门活动
<div class="mr-container activity ">
    <div class="shopTitle ">
        <h4>活动</h4>
        <h3>每期活动 优惠享不停 </h3>
							<span class="more ">
                               <a href="views/shopInfo.jsp">全部活动<i class="mr-icon-angle-right" style="padding-left:10px ;"></i></a>
                            </span>
    </div>

    <div class="mr-g mr-g-fixed ">
        <div class="mr-u-sm-3 ">
            <div class="icon-sale one "></div>
            <h4>秒杀</h4>

            <div class="activityMain ">
                <a href="views/shopInfo.jsp"><img src="img/activity1.jpg "/></a>
            </div>
            <div class="info ">
                <h3><a href="views/shopInfo.jsp">春节送礼优选</a></h3>
            </div>
        </div>

        <div class="mr-u-sm-3 ">
            <div class="icon-sale two "></div>
            <h4>特惠</h4>

            <div class="activityMain ">
                <a href="views/shopInfo.jsp"><img src="img/activity2.jpg "></a>
            </div>
            <div class="info ">
                <a href="views/shopInfo.jsp"><h3>春节送礼优选</h3></a>
            </div>
        </div>

        <div class="mr-u-sm-3 ">
            <div class="icon-sale three "></div>
            <h4>团购</h4>
            <div class="activityMain ">
                <a href="views/shopInfo.jsp"><img src="img/activity3.jpg "></a>
            </div>
            <div class="info ">
                <a href="views/shopInfo.jsp"><h3>春节送礼优选</h3></a>
            </div>
        </div>

        <div class="mr-u-sm-3 last ">
            <div class="icon-sale "></div>
            <h4>超值</h4>
            <div class="activityMain ">
                <img src="img/activity.jpg "></img>
            </div>
            <div class="info ">
                <h3>春节送礼优选</h3>
            </div>
        </div>

    </div>
</div>
<div class="clear "></div>
-->
<!--手机
<div id="f1">
    <div class="mr-container ">
        <div class="shopTitle ">
            <h4>手机</h4>

            <h3>手机风暴</h3>

            <div class="today-brands ">
                <a href="# ">小米</a>
                <a href="# ">荣耀</a>
                <a href="# ">乐视 </a>
                <a href="# ">魅族</a>
                <a href="# ">联想</a>
                <a href="# ">OPPO</a>
            </div>
							<span class="more ">
                                 <a href="# ">更多手机<i class="mr-icon-angle-right" style="padding-left:10px ;"></i></a>
                            </span>
        </div>
    </div>

    <div class="mr-g mr-g-fixed floodFive ">

        <div class="mr-u-sm-5 mr-u-md-3 text-one list">
            <div class="word">
                <a class="outer" href="#"><span class="inner"><b class="text">十核</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">八核</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">双四核</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">四核</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">双核</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">单核</b></span></a>
            </div>
            <a href="# ">
                <img src="img/tel.png " width="100px" height="170px"/>

                <div class="outer-con ">
                    <div class="title ">
                        免费领30天碎屏脸
                    </div>
                    <div class="sub-title ">
                        颜值之星，双摄之星
                    </div>
                </div>
            </a>

            <div class="triangle-topright"></div>
        </div>
        <div class="mr-u-sm-7 mr-u-md-5 mr-u-lg-2 text-two">
            <div class="outer-con ">
                <div class="title ">
                    荣耀8
                </div>
                <div class="sub-title ">
                    ¥5888.00
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp "><img src="img/phone1.jpg "/></a>
        </div>

        <div class="mr-u-md-2 mr-u-lg-2 text-three sug">
            <div class="outer-con ">
                <div class="title ">
                    一加手机
                </div>
                <div class="sub-title ">
                    ¥2499.00
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp"><img src="img/phone2.jpg"/></a>
        </div>
        <div class="mr-u-md-2 mr-u-lg-2 text-three big">
            <div class="outer-con ">
                <div class="title ">
                    红米
                </div>
                <div class="sub-title ">
                    ¥1199.00
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp "><img src="img/phone5.jpg"/></a>
        </div>
        <div class="mr-u-sm-4 mr-u-md-5 mr-u-lg-4 text-five">
            <div class="outer-con ">
                <div class="title ">
                    LG G5
                </div>
                <div class="sub-title ">
                    ¥2999.00
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp "><img src="img/phone3.jpg"/></a>
        </div>
        <div class="mr-u-sm-4 mr-u-md-2 mr-u-lg-2 text-six">
            <div class="outer-con ">
                <div class="title ">
                    苹果4s手机
                </div>
                <div class="sub-title ">
                    ¥2099.00
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp"><img src="img/phone4.jpg"/></a>
        </div>
        <div class="mr-u-sm-4 mr-u-md-2 mr-u-lg-4 text-six big">
            <div class="outer-con ">
                <div class="title ">
                    魅族 魅蓝
                </div>
                <div class="sub-title ">
                    ¥999.00
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp"><img src="img/phone5.jpg"/></a>
        </div>
    </div>
    <div class="clear "></div>
</div>
-->
<!--电脑
<div id="f2">
    <div class="mr-container ">
        <div class="shopTitle ">
            <h4>电脑</h4>

            <h3>新年换新机</h3>

            <div class="today-brands ">
                <a href="# ">戴尔</a>
                <a href="# ">清华同方</a>
                <a href="# ">小米 </a>
                <a href="# ">联想</a>
                <a href="# ">惠普</a>
                <a href="# ">三星</a>
            </div>
							<span class="more ">
                                <a href="views/shopList.jsp ">更多电脑<i class="mr-icon-angle-right" style="padding-left:10px ;"></i></a>
                            </span>
        </div>
    </div>
    <div class="mr-g mr-g-fixed floodFour">
        <div class="mr-u-sm-5 mr-u-md-4 text-one list ">
            <div class="word">
                <a class="outer" href="#"><span class="inner"><b class="text">CPU</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">显卡</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">机箱</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">键盘</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">鼠标</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">U盘</b></span></a>
            </div>
            <a href="views/shopList.jsp">
                <div class="outer-con ">
                    <div class="title ">
                        致敬2016
                    </div>
                    <div class="sub-title ">
                        新春大礼包
                    </div>
                </div>
                <img src="img/computerArt.png" width="120px" height="200px">
            </a>

            <div class="triangle-topright"></div>
        </div>

        <div class="mr-u-sm-7 mr-u-md-4 text-two sug">
            <div class="outer-con ">
                <div class="title ">
                    惠普（HP）笔记本
                </div>
                <div class="sub-title ">
                    ¥4999.00
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopList.jsp"><img src="img/computer1.jpg"/></a>
        </div>

        <div class="mr-u-sm-7 mr-u-md-4 text-two">
            <div class="outer-con ">
                <div class="title ">
                    罗技蓝牙键盘
                </div>
                <div class="sub-title ">
                    ¥179.90
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopList.jsp"><img src="img/computer2.jpg"/></a>
        </div>


        <div class="mr-u-sm-3 mr-u-md-2 text-three big">
            <div class="outer-con ">
                <div class="title ">
                    米奇优盘
                </div>
                <div class="sub-title ">
                    ¥39.90
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopList.jsp "><img src="img/computer3.jpg"/></a>
        </div>

        <div class="mr-u-sm-3 mr-u-md-2 text-three sug">
            <div class="outer-con ">
                <div class="title ">
                    优派液晶显示器
                </div>
                <div class="sub-title ">
                    ¥699.00
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopList.jsp"><img src="img/computer4.jpg"/></a>
        </div>

        <div class="mr-u-sm-3 mr-u-md-2 text-three ">
            <div class="outer-con ">
                <div class="title ">
                    联想笔记本
                </div>
                <div class="sub-title ">
                    ¥6599.00
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopList.jsp"><img src="img/computer5.jpg"/></a>
        </div>

        <div class="mr-u-sm-3 mr-u-md-2 text-three last big ">
            <div class="outer-con ">
                <div class="title ">
                    LG 航拍器
                </div>
                <div class="sub-title ">
                    ¥699.00
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopList.jsp"><img src="img/computer6.jpg"/></a>
        </div>

    </div>
    <div class="clear "></div>
</div>
-->
<!--甜点
<div id="f3">
    <div class="mr-container ">
        <div class="shopTitle ">
            <h4>甜品</h4>

            <h3>每一道甜品都有一个故事</h3>

            <div class="today-brands ">
                <a href="# ">桂花糕</a>
                <a href="# ">奶皮酥</a>
                <a href="# ">栗子糕 </a>
                <a href="# ">马卡龙</a>
                <a href="# ">铜锣烧</a>
                <a href="# ">豌豆黄</a>
            </div>
				<span class="more ">
                      <a href="# ">更多美味<i class="mr-icon-angle-right" style="padding-left:10px ;"></i></a>
                </span>
        </div>
    </div>

    <div class="mr-g mr-g-fixed floodFive ">

        <div class="mr-u-sm-5 mr-u-md-3 text-one list">
            <div class="word">
                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
            </div>
            <a href="views/shopInfo.jsp ">
                <img src="img/act1.png "/>

                <div class="outer-con ">
                    <div class="title ">
                        零食大礼包开抢啦
                    </div>
                    <div class="sub-title ">
                        当小鱼儿恋上软豆腐
                    </div>
                </div>
            </a>

            <div class="triangle-topright"></div>
        </div>
        <div class="mr-u-sm-7 mr-u-md-5 mr-u-lg-2 text-two">
            <div class="outer-con ">
                <div class="title ">
                    雪之恋和风大福
                </div>
                <div class="sub-title ">
                    ¥13.8
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp"><img src="img/1.jpg "/></a>
        </div>

        <div class="mr-u-md-2 mr-u-lg-2 text-three sug">
            <div class="outer-con ">
                <div class="title ">
                    小优布丁
                </div>
                <div class="sub-title ">
                    ¥4.8
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp"><img src="img/2.jpg"/></a>
        </div>
        <div class="mr-u-md-2 mr-u-lg-2 text-three big">
            <div class="outer-con ">
                <div class="title ">
                    小优布丁
                </div>
                <div class="sub-title ">
                    ¥4.8
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp"><img src="img/5.jpg"/></a>
        </div>
        <div class="mr-u-sm-4 mr-u-md-5 mr-u-lg-4 text-five">
            <div class="outer-con ">
                <div class="title ">
                    小优布丁
                </div>
                <div class="sub-title ">
                    ¥4.8
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp "><img src="img/3.jpg"/></a>
        </div>
        <div class="mr-u-sm-4 mr-u-md-2 mr-u-lg-2 text-six">
            <div class="outer-con ">
                <div class="title ">
                    小优布丁
                </div>
                <div class="sub-title ">
                    ¥4.8
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp"><img src="img/4.jpg"/></a>
        </div>
        <div class="mr-u-sm-4 mr-u-md-2 mr-u-lg-4 text-six big">
            <div class="outer-con ">
                <div class="title ">
                    小优布丁
                </div>
                <div class="sub-title ">
                    ¥4.8
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp"><img src="img/5.jpg"/></a>
        </div>
    </div>

    <div class="clear "></div>
</div>
-->
<!--坚果
<div id="f4">

    <div class="mr-container ">
        <div class="shopTitle ">
            <h4>坚果</h4>

            <h3>酥酥脆脆，回味无穷</h3>

            <div class="today-brands ">
                <a href="# ">腰果</a>
                <a href="# ">松子</a>
                <a href="# ">夏威夷果 </a>
                <a href="# ">碧根果</a>
                <a href="# ">开心果</a>
                <a href="# ">核桃仁</a>
            </div>
				<span class="more ">
                         <a href="# ">更多美味<i class="mr-icon-angle-right" style="padding-left:10px ;"></i></a>
                </span>
        </div>
    </div>
    <div class="mr-g mr-g-fixed floodFour">
        <div class="mr-u-sm-5 mr-u-md-4 text-one list ">
            <div class="word">
                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
            </div>
            <a href="views/shopInfo.jsp ">
                <div class="outer-con ">
                    <div class="title ">
                        开抢啦！
                    </div>
                    <div class="sub-title ">
                        零食大礼包
                    </div>
                </div>
                <img src="img/act1.png "/>
            </a>

            <div class="triangle-topright"></div>
        </div>

        <div class="mr-u-sm-7 mr-u-md-4 text-two sug">
            <div class="outer-con ">
                <div class="title ">
                    雪之恋和风大福
                </div>
                <div class="sub-title ">
                    ¥13.8
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp"><img src="img/6.jpg"/></a>
        </div>

        <div class="mr-u-sm-7 mr-u-md-4 text-two">
            <div class="outer-con ">
                <div class="title ">
                    雪之恋和风大福
                </div>
                <div class="sub-title ">
                    ¥13.8
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp"><img src="img/7.jpg"/></a>
        </div>


        <div class="mr-u-sm-3 mr-u-md-2 text-three big">
            <div class="outer-con ">
                <div class="title ">
                    小优布丁
                </div>
                <div class="sub-title ">
                    ¥4.8
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp"><img src="img/10.jpg"/></a>
        </div>

        <div class="mr-u-sm-3 mr-u-md-2 text-three sug">
            <div class="outer-con ">
                <div class="title ">
                    小优布丁
                </div>
                <div class="sub-title ">
                    ¥4.8
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp"><img src="img/9.jpg"/></a>
        </div>

        <div class="mr-u-sm-3 mr-u-md-2 text-three ">
            <div class="outer-con ">
                <div class="title ">
                    小优布丁
                </div>
                <div class="sub-title ">
                    ¥4.8
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp "><img src="img/8.jpg"/></a>
        </div>

        <div class="mr-u-sm-3 mr-u-md-2 text-three last big ">
            <div class="outer-con ">
                <div class="title ">
                    小优布丁
                </div>
                <div class="sub-title ">
                    ¥4.8
                </div>
                <i class="mr-icon-shopping-basket mr-icon-md  seprate"></i>
            </div>
            <a href="views/shopInfo.jsp "><img src="img/10.jpg"/></a>
        </div>

    </div>
    <div class="clear "></div>
</div>
-->

    <div class="footer ">
        <div class="footer-hd ">
            <p>
                <a href="http://www.mingrisoft.com/" target="_blank">明日科技</a>
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


</div>
</div>
</div>
</div>
<!--引导-->
<div class="navCir">
    <li class="active"><a href="index.jsp"><i class="mr-icon-home "></i>首页</a></li>
    <li><a href="views/shopList.jsp"><i class="mr-icon-list"></i>商品</a></li>
    <li><a href="shopcart.jsp"><i class="mr-icon-shopping-basket"></i>购物车</a></li>
    <li><a href="views/login.jsp"><i class="mr-icon-user"></i>我的</a></li>
</div>

<!--菜单 -->
<div class="tip">
    <div id="sidebar">
        <div id="wrap">
            <div id="prof" class="item">
                <a href="#"> <span class="setting"></span> </a>

                <div class="ibar_login_box status_login show">
                    <div class="avatar_box">
                        <p class="avatar_imgbox"><img src="img/no-img_mid_.jpg"/></p>
                        <ul class="user_info">
                            <li>用户名：mingriSoft</li>
                            <li>级&nbsp;别：金牌会员</li>
                        </ul>
                    </div>
                    <div class="login_btnbox">
                        <a href="#" class="login_order">我的订单</a>
                        <a href="#" class="login_favorite">我的收藏</a>
                    </div>
                    <i class="icon_arrow_white"></i>
                </div>
            </div>
            <div id="shopCart" class="item">
                <a href="#"> <span class="message"></span> </a>

                <p> 购物车 </p>

                <p class="cart_num">0</p>
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
                <a href="#"> <span class="wdsc"><img src="img/wdsc.png"/></span> </a>

                <div class="mp_tooltip show">
                    我的收藏
                    <i class="icon_arrow_right_black"></i>
                </div>
            </div>
            <div id="broadcast" class="item">
                <a href="#"> <span class="chongzhi"><img src="img/chongzhi.png"/></span> </a>

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
                        <img src="img/weixincode.png"/>
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
    <div id="shopCart-content" class="nav-content">
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


</html>