<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>


<rapid:block name="head_content">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>付款</title>


    <link href="/css/cartstyle.css" rel="stylesheet" type="text/css"/>
    <link href="/css/jsstyle.css" rel="stylesheet" type="text/css"/>


    <style>
        @media screen and (max-width: 400px) {
            .select-list {
                display: none;
            }
        }
    </style>
</rapid:block>


<rapid:override name="main_content">


    <div class="concent">
        <!--地址 -->
        <div class="paycont">
            <div class="address">
                <h3>确认收货地址 </h3>

                <div class="control">
                    <div class="tc-btn createAddr theme-login mr-btn mr-btn-danger">使用新地址</div>
                </div>
                <div class="clear"></div>
                <ul>
                    <div class="per-border"></div>
                    <li class="user-addresslist defaultAddr">

                        <div class="address-left">
                            <div class="user DefaultAddr">

										<span class="buy-address-detail">
                   <span class="buy-user">李**  </span>
										<span class="buy-phone">15*****5629</span>
										</span>
                            </div>
                            <div class="default-address DefaultAddr">
                                <span class="buy-line-title buy-line-title-type">收货地址：</span>
                                <span class="buy--address-detail">
								   <span class="province">吉林</span>省
										<span class="city">长春</span>市
										<span class="dist">南关区</span>区
										<span class="street">卫星广场财富领域5A16室</span>
										</span>

                                </span>
                            </div>
                            <ins class="deftip">默认地址</ins>
                        </div>
                        <div class="address-right">
                            <a href="/person/address.html">
                                <span class="mr-icon-angle-right mr-icon-lg"></span></a>
                        </div>
                        <div class="clear"></div>

                        <div class="new-addr-btn">
                            <a href="#" class="hidden">设为默认</a>
                            <span class="new-addr-bar hidden">|</span>
                            <a href="#">编辑</a>
                            <span class="new-addr-bar">|</span>
                            <a href="javascript:void(0);" onclick="delClick(this);">删除</a>
                        </div>

                    </li>
                    <div class="per-border"></div>
                    <li class="user-addresslist">
                        <div class="address-left">
                            <div class="user DefaultAddr">

										<span class="buy-address-detail">
                   <span class="buy-user">李**</span>
										<span class="buy-phone">15*****5629</span>
										</span>
                            </div>
                            <div class="default-address DefaultAddr">
                                <span class="buy-line-title buy-line-title-type">收货地址：</span>
                                <span class="buy--address-detail">
								   <span class="province">吉林</span>省
										<span class="city">吉林</span>市
										<span class="dist">船营</span>区
										<span class="street">东湖路75号众环大厦2栋9层902</span>
										</span>
                                </span>
                            </div>
                            <ins class="deftip hidden">默认地址</ins>
                        </div>
                        <div class="address-right">
                            <span class="mr-icon-angle-right mr-icon-lg"></span>
                        </div>
                        <div class="clear"></div>

                        <div class="new-addr-btn">
                            <a href="#">设为默认</a>
                            <span class="new-addr-bar">|</span>
                            <a href="#">编辑</a>
                            <span class="new-addr-bar">|</span>
                            <a href="javascript:void(0);" onclick="delClick(this);">删除</a>
                        </div>

                    </li>

                </ul>

                <div class="clear"></div>
            </div>
            <!--物流 -->
            <div class="logistics">
                <h3>选择物流方式</h3>
                <ul class="op_express_delivery_hot">
                    <li data-value="yuantong" class="OP_LOG_BTN  "><i class="c-gap-right"
                                                                      style="background-position:0px -468px"></i>圆通<span></span>
                    </li>
                    <li data-value="shentong" class="OP_LOG_BTN  "><i class="c-gap-right"
                                                                      style="background-position:0px -1008px"></i>申通<span></span>
                    </li>
                    <li data-value="yunda" class="OP_LOG_BTN  "><i class="c-gap-right"
                                                                   style="background-position:0px -576px"></i>韵达<span></span>
                    </li>
                    <li data-value="zhongtong" class="OP_LOG_BTN op_express_delivery_hot_last "><i class="c-gap-right"
                                                                                                   style="background-position:0px -324px"></i>中通<span></span>
                    </li>
                    <li data-value="shunfeng" class="OP_LOG_BTN  op_express_delivery_hot_bottom"><i class="c-gap-right"
                                                                                                    style="background-position:0px -180px"></i>顺丰<span></span>
                    </li>
                </ul>
            </div>
            <div class="clear"></div>

            <!--支付方式-->
            <div class="logistics">
                <h3>选择支付方式</h3>
                <ul class="pay-list">
                    <li class="pay card"><img src="/img/wangyin.jpg"/>银联<span></span></li>
                    <li class="pay qq"><img src="/img/weizhifu.jpg"/>微信<span></span></li>
                    <li class="pay taobao"><img src="/img/zhifubao.jpg"/>支付宝<span></span></li>
                </ul>
            </div>
            <div class="clear"></div>

            <!--订单 -->
            <div class="concent">
                <div id="payTable">
                    <h3>确认订单信息</h3>

                    <div class="cart-table-th">
                        <div class="wp">

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
                            <div class="th th-oplist">
                                <div class="td-inner">配送方式</div>
                            </div>

                        </div>
                    </div>
                    <div class="clear"></div>

                    <tr class="item-list">
                        <div class="bundle  bundle-last">

                            <div class="bundle-main">
                                <ul class="item-content clearfix">
                                    <div class="pay-phone">
                                        <li class="td td-item">
                                            <div class="item-pic">
                                                <a href="#" class="J_MakePoint">
                                                    <img src="/img/shopcartImg.jpg" width="80px" height="80px"
                                                         class="itempic J_ItemImg"></a>
                                            </div>
                                            <div class="item-info">
                                                <div class="item-basic-info">
                                                    <a href="#" class="item-title J_MakePoint" data-point="tbcart.8.11">华为
                                                        荣耀 畅玩4X 白色 移动4G手机 双卡双待</a>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="td td-info">
                                            <div class="item-props">
                                                <span class="sku-line">颜色：白色</span>
                                                <span class="sku-line">包装：裸装</span>
                                            </div>
                                        </li>
                                        <li class="td td-price">
                                            <div class="item-price price-promo-promo">
                                                <div class="price-content">
                                                    <em class="J_Price price-now">499.00</em>
                                                </div>
                                            </div>
                                        </li>
                                    </div>
                                    <li class="td td-amount">
                                        <div class="amount-wrapper ">
                                            <div class="item-amount ">
                                                <span class="phone-title">购买数量</span>

                                                <div class="sl">
                                                    <input class="min mr-btn" name="" type="button" value="-"/>
                                                    <input class="text_box" name="" type="text" value="1"
                                                           style="width:30px;"/>
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
                                    <li class="td td-oplist">
                                        <div class="td-inner">
                                            <span class="phone-title">配送方式</span>

                                            <div class="pay-logis">
                                                快递<b class="sys_item_freprice">10</b>元
                                            </div>
                                        </div>
                                    </li>

                                </ul>
                                <div class="clear"></div>

                            </div>
                        </div>
                    </tr>
                    <div class="clear"></div>
                </div>

                <tr id="J_BundleList_s_1911116345_1" class="item-list">
                    <div id="J_Bundle_s_1911116345_1_0" class="bundle  bundle-last">
                        <div class="bundle-main">
                            <ul class="item-content clearfix">
                                <div class="pay-phone">
                                    <li class="td td-item">
                                        <div class="item-pic">
                                            <a href="#" class="J_MakePoint">
                                                <img src="/img/shopcartImg.jpg" width="80px" height="80px"
                                                     class="itempic J_ItemImg"></a>
                                        </div>
                                        <div class="item-info">
                                            <div class="item-basic-info">
                                                <a href="#" target="_blank" title="华为 荣耀 畅玩4X 白色 移动4G手机 双卡双待"
                                                   class="item-title J_MakePoint" data-point="tbcart.8.11">华为 荣耀 畅玩4X 白色
                                                    移动4G手机 双卡双待</a>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="td td-info">
                                        <div class="item-props">
                                            <span class="sku-line">颜色：金色</span>
                                            <span class="sku-line">包装：手袋装（送手机盒）</span>
                                        </div>
                                    </li>
                                    <li class="td td-price">
                                        <div class="item-price price-promo-promo">
                                            <div class="price-content">
                                                <em class="J_Price price-now">599.00</em>
                                            </div>
                                        </div>
                                    </li>
                                </div>

                                <li class="td td-amount">
                                    <div class="amount-wrapper ">
                                        <div class="item-amount ">
                                            <span class="phone-title">购买数量</span>

                                            <div class="sl">
                                                <input class="min mr-btn" name="" type="button" value="-"/>
                                                <input class="text_box" name="" type="text" value="1"
                                                       style="width:30px;"/>
                                                <input class="add mr-btn" name="" type="button" value="+"/>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="td td-sum">
                                    <div class="td-inner">
                                        <em tabindex="0" class="J_ItemSum number">599.00</em>
                                    </div>
                                </li>
                                <li class="td td-oplist">
                                    <div class="td-inner">
                                        <span class="phone-title">配送方式</span>

                                        <div class="pay-logis">
                                            包邮
                                        </div>
                                    </div>
                                </li>

                            </ul>
                            <div class="clear"></div>

                        </div>
                    </div>
                </tr>
            </div>
            <div class="clear"></div>
            <div class="pay-total">
                <!--留言-->
                <div class="order-extra">
                    <div class="order-user-info">
                        <div id="holyshit257" class="memo">
                            <label>买家留言：</label>
                            <input type="text" title="选填,对本次交易的说明（建议填写已经和卖家达成一致的说明）" placeholder="选填,建议填写和卖家达成一致的说明"
                                   class="memo-input J_MakePoint c2c-text-default memo-close">

                            <div class="msg hidden J-msg">
                                <p class="error">最多输入500个字符</p>
                            </div>
                        </div>
                    </div>

                </div>
                <!--优惠券 -->
                <div class="buy-agio">
                    <li class="td td-coupon">

                        <span class="coupon-title">优惠券</span>
                        <select data-mr-selected>
                            <option value="a">
                                <div class="c-price">
                                    <strong>￥8</strong>
                                </div>
                                <div class="c-limit">
                                    【消费满95元可用】
                                </div>
                            </option>
                            <option value="b" selected>
                                <div class="c-price">
                                    <strong>￥3</strong>
                                </div>
                                <div class="c-limit">
                                    【无使用门槛】
                                </div>
                            </option>
                        </select>
                    </li>

                    <li class="td td-bonus">

                        <span class="bonus-title">红包</span>
                        <select data-mr-selected>
                            <option value="a">
                                <div class="item-info">
                                    ¥50.00<span>元</span>
                                </div>
                                <div class="item-remainderprice">
                                    <span>还剩</span>10.40<span>元</span>
                                </div>
                            </option>
                            <option value="b" selected>
                                <div class="item-info">
                                    ¥50.00<span>元</span>
                                </div>
                                <div class="item-remainderprice">
                                    <span>还剩</span>50.00<span>元</span>
                                </div>
                            </option>
                        </select>

                    </li>

                </div>
                <div class="clear"></div>
            </div>
            <!--含运费小计 -->
            <div class="buy-point-discharge ">
                <p class="price g_price ">
                    合计（含运费） <span>¥</span><em class="pay-sum">1045.00</em>
                </p>
            </div>

            <!--信息 -->
            <div class="order-go clearfix">
                <div class="pay-confirm clearfix">
                    <div class="box">
                        <div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
                            <span class="price g_price ">
                                    <span>¥</span> <em class="style-large-bold-red " id="J_ActualFee">1045.00</em>
											</span>
                        </div>

                        <div id="holyshit268" class="pay-address">

                            <p class="buy-footer-address">
                                <span class="buy-line-title buy-line-title-type">寄送至：</span>
                                <span class="buy--address-detail">
								   <span class="province">吉林</span>省
												<span class="city">长春</span>市
												<span class="dist">南关</span>区
												<span class="street">卫星广场财富领域5A16室</span>
												</span>
                                </span>
                            </p>

                            <p class="buy-footer-address">
                                <span class="buy-line-title">收货人：</span>
                                <span class="buy-address-detail">
                                         <span class="buy-user">李丹 </span>
												<span class="buy-phone">15871145629</span>
												</span>
                            </p>
                        </div>
                    </div>

                    <div id="holyshit269" class="submitOrder">
                        <div class="go-btn-wrap">
                            <a id="J_Go" href="//index.html" class="btn-go" tabindex="0" title="点击此按钮，提交订单">提交订单</a>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>

        <div class="clear"></div>
    </div>
    </div>


    </div>
    <div class="theme-popover-mask"></div>
    <div class="theme-popover">

        <!--标题 -->
        <div class="mr-cf mr-padding">
            <div class="mr-fl mr-cf"><strong class="mr-text-danger mr-text-lg">新增地址</strong> /
                <small>Add address</small>
            </div>
        </div>
        <hr/>

        <div class="mr-u-md-12">
            <form class="mr-form mr-form-horizontal">

                <div class="mr-form-group">
                    <label for="user-name" class="mr-form-label">收货人</label>

                    <div class="mr-form-content">
                        <input type="text" id="user-name" placeholder="收货人">
                    </div>
                </div>

                <div class="mr-form-group">
                    <label for="user-phone" class="mr-form-label">手机号码</label>

                    <div class="mr-form-content">
                        <input id="user-phone" placeholder="手机号必填" type="email">
                    </div>
                </div>

                <div class="mr-form-group">
                    <label for="user-phone" class="mr-form-label">所在地</label>

                    <div class="mr-form-content address">
                        <select data-mr-selected>
                            <option value="a">浙江省</option>
                            <option value="b">湖北省</option>
                        </select>
                        <select data-mr-selected>
                            <option value="a">温州市</option>
                            <option value="b">武汉市</option>
                        </select>
                        <select data-mr-selected>
                            <option value="a">瑞安区</option>
                            <option value="b">洪山区</option>
                        </select>
                    </div>
                </div>

                <div class="mr-form-group">
                    <label for="user-intro" class="mr-form-label">详细地址</label>

                    <div class="mr-form-content">
                        <textarea class="" rows="3" id="user-intro" placeholder="输入详细地址"></textarea>
                        <small>100字以内写出你的详细地址...</small>
                    </div>
                </div>

                <div class="mr-form-group theme-poptit">
                    <div class="mr-u-sm-9 mr-u-sm-push-3">
                        <div class="mr-btn mr-btn-danger">保存</div>
                        <div class="mr-btn mr-btn-danger close">取消</div>
                    </div>
                </div>
            </form>
        </div>

    </div>

    <div class="clear"></div>
</rapid:override>
<%@ include file="viewBase.jsp" %>

