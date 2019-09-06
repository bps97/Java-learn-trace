<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>


<rapid:override name="head_content">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>购物车</title>

    <link href="/css/cartstyle.css" rel="stylesheet" type="text/css"/>
    <link href="/css/optstyle.css" rel="stylesheet" type="text/css"/>


</rapid:override>


<rapid:override name="main_content">


    <!--购物车 -->
    <div class="concent">
        <div id="cartTable">
            <div class="cart-table-th">
                <div class="wp">
                    <div class="th th-chk">
                        <div id="J_SelectAll1" class="select-all J_SelectAll">

                        </div>
                    </div>
                    <div class="th th-item">
                        <div class="td-inner">商品信息</div>
                    </div>
                    <div class="th th-price">
                        <div class="td-inner">单价</div>
                    </div>
                    <div class="th th-amount">
                        <div class="td-inner">数量</div>
                    </div>
                    <div class="th th-sum">
                        <div class="td-inner">金额</div>
                    </div>
                    <div class="th th-op">
                        <div class="td-inner">操作</div>
                    </div>
                </div>
            </div>
            <div class="clear"></div>

            <tr class="item-list">
                <div class="bundle  bundle-last ">
                    <div class="bundle-hd">
                        <div class="bd-promos">
                            <div class="bd-has-promo">已享优惠:<span class="bd-has-promo-content">省￥200.00</span>&nbsp;&nbsp;
                            </div>
                            <span class="list-change theme-login">编辑</span>
                        </div>
                    </div>
                    <div class="clear"></div>
                    <div class="bundle-main">
                        <ul class="item-content clearfix">
                            <li class="td td-chk">
                                <div class="cart-checkbox ">
                                    <input class="check" id="" name="items[]"
                                           value="170037950254" type="checkbox">
                                    <label for="J_CheckBox_170037950254"></label>
                                </div>
                            </li>
                            <li class="td td-item">
                                <div class="item-pic">
                                    <a href="#" target="_blank" data-title="华为 荣耀 畅玩4X 白色 移动4G手机 双卡双待"
                                       class="J_MakePoint" data-point="tbcart.8.12">
                                        <img src="/img/shopcartImg.jpg" width="80px" height="80px"
                                             class="itempic J_ItemImg"></a>
                                </div>
                                <div class="item-info">
                                    <div class="item-basic-info">
                                        <a href="#" target="_blank" title="华为 荣耀 畅玩4X 白色 移动4G手机 双卡双待"
                                           class="item-title J_MakePoint" data-point="tbcart.8.11">华为 荣耀 畅玩4X 白色 移动4G手机
                                            双卡双待</a>
                                    </div>
                                </div>
                            </li>
                            <li class="td td-info">
                                <div class="item-props item-props-can">
                                    <span class="sku-line">颜色：白色</span>
                                    <span class="sku-line">包装：裸装</span>
                                    <span tabindex="0" class="btn-edit-sku theme-login">修改</span>
                                    <i class="theme-login mr-icon-sort-desc"></i>
                                </div>
                            </li>
                            <li class="td td-price">
                                <div class="item-price price-promo-promo">
                                    <div class="price-content">
                                        <div class="price-line">
                                            <em class="price-original">499.00</em>
                                        </div>
                                        <div class="price-line">
                                            <em class="J_Price price-now" tabindex="0">399.00</em>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="td td-amount">
                                <div class="amount-wrapper ">
                                    <div class="item-amount ">
                                        <div class="sl">
                                            <input class="min mr-btn" name="" type="button" value="-"/>
                                            <input class="text_box" name="" type="text" value="1" style="width:30px;"/>
                                            <input class="add mr-btn" name="" type="button" value="+"/>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="td td-sum">
                                <div class="td-inner">
                                    <em tabindex="0" class="J_ItemSum number">399.00</em>
                                </div>
                            </li>
                            <li class="td td-op">
                                <div class="td-inner">
                                    <a title="移入收藏夹" class="btn-fav" href="#">
                                        移入收藏夹</a>
                                    <a href="javascript:;" data-point-url="#" class="delete">
                                        删除</a>
                                </div>
                            </li>
                        </ul>


                        <ul class="item-content clearfix">
                            <li class="td td-chk">
                                <div class="cart-checkbox ">
                                    <input class="check" id="J_CheckBox_170037950254" name="items[]"
                                           value="170037950254" type="checkbox">
                                    <label for="J_CheckBox_170037950254"></label>
                                </div>
                            </li>
                            <li class="td td-item">
                                <div class="item-pic">
                                    <a href="#" target="_blank" data-title="华为 荣耀 畅玩4X 白色 移动4G手机 双卡双待"
                                       class="J_MakePoint" data-point="tbcart.8.12">
                                        <img src="/img/shopcartImg.jpg" width="80px" height="80px"
                                             class="itempic J_ItemImg"></a>
                                </div>
                                <div class="item-info">
                                    <div class="item-basic-info">
                                        <a href="#" target="_blank" title="华为 荣耀 畅玩4X 白色 移动4G手机 双卡双待"
                                           class="item-title J_MakePoint" data-point="tbcart.8.11">华为 荣耀 畅玩4X 白色 移动4G手机
                                            双卡双待</a>
                                    </div>
                                </div>
                            </li>
                            <li class="td td-info">
                                <div class="item-props item-props-can">
                                    <span class="sku-line">颜色：白色</span>
                                    <span class="sku-line">包装：裸装</span>
                                    <span tabindex="0" class="btn-edit-sku theme-login">修改</span>
                                    <i class="theme-login mr-icon-sort-desc"></i>
                                </div>
                            </li>
                            <li class="td td-price">
                                <div class="item-price price-promo-promo">
                                    <div class="price-content">
                                        <div class="price-line">
                                            <em class="price-original">499.00</em>
                                        </div>
                                        <div class="price-line">
                                            <em class="J_Price price-now" tabindex="0">399.00</em>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="td td-amount">
                                <div class="amount-wrapper ">
                                    <div class="item-amount ">
                                        <div class="sl">
                                            <input class="min mr-btn" name="" type="button" value="-"/>
                                            <input class="text_box" name="" type="text" value="1" style="width:30px;"/>
                                            <input class="add mr-btn" name="" type="button" value="+"/>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="td td-sum">
                                <div class="td-inner">
                                    <em tabindex="0" class="J_ItemSum number">399.00</em>
                                </div>
                            </li>
                            <li class="td td-op">
                                <div class="td-inner">
                                    <a title="移入收藏夹" class="btn-fav" href="#">
                                        移入收藏夹</a>
                                    <a href="javascript:;" data-point-url="#" class="delete">
                                        删除</a>
                                </div>
                            </li>
                        </ul>


                    </div>
                </div>
            </tr>
            <div class="clear"></div>

            <tr class="item-list">
                <div class="bundle  bundle-last ">
                    <div class="bundle-hd">
                        <div class="bd-promos">
                            <div class="bd-has-promo">已享优惠:<span class="bd-has-promo-content">省￥100.00</span>&nbsp;&nbsp;
                            </div>
                            <span class="list-change theme-login">编辑</span>
                        </div>
                    </div>
                    <div class="clear"></div>
                    <div class="bundle-main">
                        <ul class="item-content clearfix">
                            <li class="td td-chk">
                                <div class="cart-checkbox ">
                                    <input class="check" id="J_CheckBox_170769542747" name="items[]"
                                           value="170769542747" type="checkbox">
                                    <label for="J_CheckBox_170769542747"></label>
                                </div>
                            </li>
                            <li class="td td-item">
                                <div class="item-pic">
                                    <a href="#" target="_blank" data-title="美康粉黛醉美东方唇膏口红正品 持久保湿滋润防水不掉色护唇彩妆"
                                       class="J_MakePoint" data-point="tbcart.8.12">
                                        <img src="/img/shopcartImg.jpg" width="80px" height="80px"
                                             class="itempic J_ItemImg"></a>
                                </div>
                                <div class="item-info">
                                    <div class="item-basic-info">
                                        <a href="#" target="_blank" title="美康粉黛醉美唇膏 持久保湿滋润防水不掉色"
                                           class="item-title J_MakePoint" data-point="tbcart.8.11">华为 荣耀 畅玩4X 白色 移动4G手机
                                            双卡双待</a>
                                    </div>
                                </div>
                            </li>
                            <li class="td td-info">
                                <div class="item-props item-props-can">
                                    <span class="sku-line">颜色：金色</span>
                                    <span class="sku-line">包装：手袋装（送手机盒）</span>
                                    <span tabindex="0" class="btn-edit-sku theme-login">修改</span>
                                    <i class="theme-login mr-icon-sort-desc"></i>
                                </div>
                            </li>
                            <li class="td td-price">
                                <div class="item-price price-promo-promo">
                                    <div class="price-content">
                                        <div class="price-line">
                                            <em class="price-original">599.00</em>
                                        </div>
                                        <div class="price-line">
                                            <em class="J_Price price-now" tabindex="0">499.00</em>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="td td-amount">
                                <div class="amount-wrapper ">
                                    <div class="item-amount ">
                                        <div class="sl">
                                            <input class="min mr-btn" name="" type="button" value="-"/>
                                            <input class="text_box" name="" type="text" value="1" style="width:30px;"/>
                                            <input class="add mr-btn" name="" type="button" value="+"/>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="td td-sum">
                                <div class="td-inner">
                                    <em tabindex="0" class="J_ItemSum number">499.00</em>
                                </div>
                            </li>
                            <li class="td td-op">
                                <div class="td-inner">
                                    <a title="移入收藏夹" class="btn-fav" href="#">
                                        移入收藏夹</a>
                                    <a href="javascript:;" data-point-url="#" class="delete">
                                        删除</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </tr>
        </div>
        <div class="clear"></div>

        <div class="float-bar-wrapper">
            <div id="J_SelectAll2" class="select-all J_SelectAll">
                <div class="cart-checkbox">
                    <input class="check-all check" id="J_SelectAllCbx2" name="select-all" value="true" type="checkbox">
                    <label for="J_SelectAllCbx2"></label>
                </div>
                <span>全选</span>
            </div>
            <div class="operations">
                <a href="#" hidefocus="true" class="deleteAll">删除</a>
                <a href="#" hidefocus="true" class="J_BatchFav">移入收藏夹</a>
            </div>
            <div class="float-bar-right">
                <div class="amount-sum">
                    <span class="txt">已选商品</span>
                    <em id="J_SelectedItemsCount">0</em><span class="txt">件</span>
                    <div class="arrow-box">
                        <span class="selected-items-arrow"></span>
                        <span class="arrow"></span>
                    </div>
                </div>
                <div class="price-sum">
                    <span class="txt">合计:</span>
                    <strong class="price">¥<em id="J_Total">0.00</em></strong>
                </div>
                <div class="btn-area">
                    <a href="/pay" id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
                        <span>结&nbsp;算</span></a>
                </div>
            </div>
        </div>


    </div>

    <!--操作页面-->

    <div class="theme-popover-mask"></div>

    <div class="theme-popover">
        <div class="theme-span"></div>
        <div class="theme-poptit h-title">
            <a href="javascript:;" title="关闭" class="close">×</a>
        </div>
        <div class="theme-popbod dform">
            <form class="theme-signin" name="loginform" action="" method="post">

                <div class="theme-signin-left">

                    <li class="theme-options">
                        <div class="cart-title">颜色：</div>
                        <ul>
                            <li class="sku-line selected">12#川南玛瑙<i></i></li>
                            <li class="sku-line">10#蜜橘色+17#樱花粉<i></i></li>
                        </ul>
                    </li>
                    <li class="theme-options">
                        <div class="cart-title">包装：</div>
                        <ul>
                            <li class="sku-line selected">包装：裸装<i></i></li>
                            <li class="sku-line">两支手袋装（送彩带）<i></i></li>
                        </ul>
                    </li>
                    <div class="theme-options">
                        <div class="cart-title number">数量</div>
                        <dd>
                            <input class="min mr-btn mr-btn-default" name="" type="button" value="-"/>
                            <input class="text_box" name="" type="text" value="1" style="width:30px;"/>
                            <input class="add mr-btn mr-btn-default" name="" type="button" value="+"/>
                            <span class="tb-hidden">库存<span class="stock">1000</span>件</span>
                        </dd>

                    </div>
                    <div class="clear"></div>
                    <div class="btn-op">
                        <div class="btn mr-btn mr-btn-warning">确认</div>
                        <div class="btn close mr-btn mr-btn-warning">取消</div>
                    </div>

                </div>
                <div class="theme-signin-right">
                    <div class="img-info">
                        <img src="/img/kouhong.jpg_80x80.jpg"/>
                    </div>
                    <div class="text-info">
                        <span class="J_Price price-now">¥39.00</span>
                        <span id="Stock" class="tb-hidden">库存<span class="stock">1000</span>件</span>
                    </div>
                </div>

            </form>
        </div>
    </div>


</rapid:override>

<%@ include file="viewBase.jsp" %>
