<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/9/26
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<rapid:override name="head_content">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>购物车</title>



    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<%--    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>--%>
<%--    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="https://cdn.bootcss.com/font-awesome/5.10.2/css/all.css" rel="stylesheet">


    <link rel="stylesheet" type="text/css" href="/css/cartstyle.css"/>
    <link rel="stylesheet" type="text/css" href="/css/optstyle.css"/>
    <link rel="stylesheet" type="text/css" href="/css/favorite.css"/>

    <style type="text/css">
        input.text{text-align:center;}
    </style>


</rapid:override>


<rapid:override name="main_content">

    <!-- 商品区 -->
    <div id="shop-list" class="container">
        <ul class=".img-item-list J_FavList">
            <li class="shop-item g-i-item">
                <div class="controller-box  J_FavImgController">
                    <div class="controller-img-box">
                        <img src="./1.jpg" alt="" style="width: 100%;height:100%">
                        <div class="delete-box hide"><a href="" style="color: white"><i
                                class="mr-icon-trash-o mr-icon-fw"></i></a></div>
                        <!-- <div class="btn-delete-bg"></div>
                        <div class="delete-btn J_DeleteItem" title="删除宝贝"></div> -->
                        <div class="shop-box hide"><a href="" style="color: white">加入购物车</a></div>
                    </div>
                </div>
                <div class="item-card g-il-l-item">
                    <div class="item-title">
                        <img src="../img/logo.png" alt="" style="width: 24px;height:18px">
                        <a href="" style="font-family: Microsoft YaHei;
                        font-size: 12px;">手机大促销</a>

                    </div>
                    <div class="price-container">
                        <div class="g_price-box">
                            <div class="g_price">
                                <span style="font-size: 12px">¥</span>
                                <strong style="font-size: 12px">69.00</strong>
                            </div>
                            <div class="g_price g_price-original">

                                <span style="font-size: 12px">¥</span>
                                <span style="font-size: 12px">158.00</span>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="J_ItemListBox item-list-box -select">
                    <div class="item-list-box-tools" style="height: 51px">
                        <div class="item-list-box-tab">
                            <div class="findSimilar disabled">找相似</div>
                        </div>

                        <a href="" class="item-list-more-btn">查看更多</a>

                    </div>
                    <div class="item-list">
                        <ul class="item-list-findSimilar-ul">
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </li>
            <li class="shop-item g-i-item">
                <div class="controller-box  J_FavImgController">
                    <div class="controller-img-box">
                        <img src="./1.jpg" alt="" style="width: 100%;height:100%">
                        <div class="delete-box hide"><a href="" style="color: white"><i
                                class="mr-icon-trash-o mr-icon-fw"></i></a></div>
                        <!-- <div class="btn-delete-bg"></div>
                        <div class="delete-btn J_DeleteItem" title="删除宝贝"></div> -->
                        <div class="shop-box hide"><a href="" style="color: white">加入购物车</a></div>
                    </div>
                </div>
                <div class="item-card g-il-l-item">
                    <div class="item-title">
                        <img src="../img/logo.png" alt="" style="width: 24px;height:18px">
                        <a href="" style="font-family: Microsoft YaHei;
                        font-size: 12px;">手机大促销</a>

                    </div>
                    <div class="price-container">
                        <div class="g_price-box">
                            <div class="g_price">
                                <span style="font-size: 12px">¥</span>
                                <strong style="font-size: 12px">69.00</strong>
                            </div>
                            <div class="g_price g_price-original">

                                <span style="font-size: 12px">¥</span>
                                <span style="font-size: 12px">158.00</span>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="J_ItemListBox item-list-box -select">
                    <div class="item-list-box-tools" style="height: 51px">
                        <div class="item-list-box-tab">
                            <div class="findSimilar disabled">找相似</div>
                        </div>

                        <a href="" class="item-list-more-btn">查看更多</a>

                    </div>
                    <div class="item-list">
                        <ul class="item-list-findSimilar-ul">
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                            <li class="item-box g-il-r-item">
                                <div class="item item-price-box">
                                    <img src="./1.jpg" alt="" style="width:100%;height:100%">
                                    <a href=""></a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </li>
            <li class="shop-item g-i-item">

            </li>
            <li class="shop-item g-i-item">

            </li>
        </ul>
    </div>


</rapid:override>

<rapid:override name="script_content">
    <script>
        $(document).ready(function () {
            $('.shop-item').on('mouseover',function () {
                $(this).find('.delete-box').removeClass('hide')
                $(this).find('.shop-box').removeClass('hide')
                $('a').addClass('a:hover')
            })

            $('.shop-item').on('mouseout',function () {
                $(this).find('.delete-box').addClass('hide')
                $(this).find('.shop-box').addClass('hide')
                $('a').addClass('a:hover')
            })
            // $('.shop-box').on('mouseover',function () {
            //     $(this).style.background='#f40'
            //   })
        })
    </script>


</rapid:override>

<%@ include file="base.jsp" %>
