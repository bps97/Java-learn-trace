<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>


<rapid:override name="head_content">
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
</rapid:override>


<rapid:override name="main_content">


    <div class="concent">
        <!--地址 -->
        <div class="paycont">
            <div class="address">
                <h3>确认收货地址 </h3>

                <div class="control">
                    <div class="tc-btn createAddr theme-login mr-btn mr-btn-danger" onclick="addAddress()">使用新地址</div>
                </div>
                <div class="clear"></div>
                <ul>
                    <c:if test="${defaultAddress != null}">
                        <div class="per-border"></div>
                        <li class="user-addresslist defaultAddr">

                            <div class="address-left">
                                <div class="user DefaultAddr">

                                <span class="buy-address-detail">
                                    <span class="buy-user">${defaultAddress.receiver}</span>
                                    <span class="buy-phone">${defaultAddress.mobile}</span>
                                </span>
                                </div>
                                <div class="default-address DefaultAddr">
                                    <span class="buy-line-title buy-line-title-type">收货地址：</span>
                                    <span class="buy--address-detail">
								   <span class="province">${defaultAddress.province}</span>
										<span class="city">${defaultAddress.province}</span>
										<span class="dist">${defaultAddress.county}</span>
										<span class="street">${defaultAddress.address}</span>
                                    </span>
                                    </span>
                                </div>
                                <ins class="deftip">默认地址</ins>
                            </div>
                            <div class="address-right">
                                <a href="../person/address.html">
                                    <span class="mr-icon-angle-right mr-icon-lg"></span></a>
                            </div>
                            <div class="clear"></div>

                            <div class="new-addr-btn">
                                <a href="#" class="hidden">设为默认</a>
                                <span class="new-addr-bar hidden">|</span>
                                <a href="#">编辑</a>
                                <span class="new-addr-bar">|</span>
                                <a href="javascript:void(0);" onclick="delClick(this);" value="${defaultAddress.id}">删除</a>
                            </div>

                        </li>
                    </c:if>
                    <c:forEach items="${addresses}" var="address">

                        <div class="per-border"></div>
                        <li class="user-addresslist">
                            <div class="address-left">
                                <div class="user DefaultAddr">

                                    <span class="buy-address-detail">
                                        <span class="buy-user">${address.receiver}</span>
										<span class="buy-phone">${address.mobile}</span>
                                    </span>
                                </div>
                                <div class="default-address DefaultAddr">
                                    <span class="buy-line-title buy-line-title-type">收货地址：</span>
                                    <span class="buy--address-detail">
                                    <span class="province">${address.province}</span>
                                    <span class="city">${address.prefecture}</span>
                                    <span class="dist">${address.county}</span>
                                    <span class="street">${address.address}</span>
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
                                <a href="javascript:void(0);" onclick="setDefaultClick(this);" value="${address.id}">设为默认</a>
                                <span class="new-addr-bar">|</span>
                                <a href="javascript:void(0);" onclick="editClick(this);" value="${address.id}">编辑</a>
                                <span class="new-addr-bar">|</span>
                                <a href="javascript:void(0);" onclick="delClick(this);" value="${address.id}">删除</a>
                            </div>

                        </li>
                    </c:forEach>

                </ul>

                <div class="clear"></div>
            </div>
            <!--物流 -->

            <div class="clear"></div>


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

                </div>

                <tr id="J_BundleList_s_1911116345_1" class="item-list">

                    <div id="J_Bundle_s_1911116345_1_0" class="bundle  bundle-last">
                        <div class="bundle-main">

                            <c:forEach items="${productItems}" var="productItem">
                                <ul class="item-content clearfix">
                                    <div class="pay-phone">
                                        <li class="td td-item">
                                            <div class="item-pic">
                                                <a href="#" class="J_MakePoint">
                                                    <img src="${images.get(productItem.product_id)}" width="80px"
                                                         height="80px"
                                                         class="itempic J_ItemImg"></a>
                                            </div>
                                            <div class="item-info">
                                                <div class="item-basic-info">
                                                    <a href="#" target="_blank"
                                                       title="${productMap.get(productItem.product_id).name}"
                                                       class="item-title J_MakePoint"
                                                       data-point="tbcart.8.11">${productMap.get(productItem.product_id).name}</a>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="td td-info">
                                            <div class="item-props">
                                                <br>
                                                <br>
                                                <span class="sku-line">颜色：金色</span>
                                                <span class="sku-line">包装：手袋装（送手机盒）</span>
                                            </div>
                                        </li>
                                        <li class="td td-price">
                                            <div class="item-price price-promo-promo">
                                                <br>
                                                <div class="price-content">

                                                    <em class="J_Price price-now">${productMap.get(productItem.product_id).price}</em>
                                                </div>
                                            </div>
                                        </li>
                                    </div>
                                    <br>
                                    <li class="td td-amount">
                                        <div class="td-inner">
                                            <em tabindex="0" class="J_ItemSum number">${productItem.quality}</em>
                                        </div>

                                    </li>
                                    <li class="td td-sum">
                                        <div class="td-inner">
                                            <em tabindex="0"
                                                class="J_ItemSum number">${productItem.quality*productMap.get(productItem.product_id).price}</em>
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
                            </c:forEach>
                            <div class="clear"></div>

                        </div>
                    </div>


                </tr>
            </div>
            <div class="clear"></div>
            <div class="pay-total">
                <!--留言-->
                <form action="/order/submit" method="post" id="form-order">

                    <div class="order-extra">
                        <div class="order-user-info">
                            <div id="holyshit257" class="memo">
                                <label>买家留言：</label>
                                <input type="hidden" name="addressId" value="${defaultAddress.id}">
                                <input type="hidden" name="orderCode" value="${orderCode}">
                                <input type="text" title="选填,对本次交易的说明（建议填写已经和卖家达成一致的说明）" placeholder="选填,建议填写和卖家达成一致的说明"
                                       class="memo-input J_MakePoint c2c-text-default memo-close" name="message">
                                <input type="hidden" name="payment" value="${totalPrice}">
                                <div class="msg hidden J-msg">
                                    <p class="error">最多输入500个字符</p>
                                </div>
                            </div>
                        </div>

                    </div>
                </form>

            </div>
            <!--含运费小计 -->
            <div class="buy-point-discharge ">
                <p class="price g_price ">
                    合计（含运费） <span>¥</span><em class="pay-sum">${totalPrice}</em>
                </p>
            </div>

            <!--信息 -->
            <div class="order-go clearfix">
                <div class="pay-confirm clearfix">
                    <div class="box">
                        <div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
                            <span class="price g_price ">
                                    <span>¥</span> <em class="style-large-bold-red " id="J_ActualFee">${totalCost}</em>
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
                            <a id="J_Go" href="javascript:submitOrder(this)" class="btn-go" tabindex="0"
                               title="点击此按钮，提交订单">提交订单</a>
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
            <form class="mr-form mr-form-horizontal" id="form-address">

                <div class="mr-form-group">
                    <label for="user-name" class="mr-form-label">收货人</label>
                    <div class="mr-form-content">
                        <input type="text" id="user-name" placeholder="收货人" name="receiver">
                    </div>
                </div>

                <div class="mr-form-group">
                    <label for="user-phone" class="mr-form-label">手机号码</label>
                    <div class="mr-form-content">
                        <input id="user-phone" placeholder="手机号必填" type="email" name="mobile">
                    </div>
                </div>

                <div class="mr-form-group">
                    <label for="user-phone" class="mr-form-label">所在地</label>
                    <div class="mr-form-content address">
                        <select data-mr-selected class="selected-city selected-province" onchange="selectFun1()"
                                name="province">
                            <c:forEach items="${province}" var="province">
                                <option value="${province.code}">${province.name}</option>
                            </c:forEach>
                        </select>
                        <select data-mr-selected class="selected-city selected-prefecture" onchange="selectFun2()"
                                name="prefecture">
                            <c:forEach items="${prefectures}" var="prefecture">
                                <option value="${prefecture.code}">${prefecture.name}</option>
                            </c:forEach>
                        </select>
                        <select data-mr-selected class="selected-city selected-county" name="county">

                            <c:forEach items="${counties}" var="county">
                                <option value="${county.code}">${county.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="mr-form-group">
                    <label for="user-intro" class="mr-form-label">详细地址</label>

                    <div class="mr-form-content">
                        <textarea class="" rows="3" id="user-intro" placeholder="输入详细地址" name="address"></textarea>
                        <small>100字以内写出你的详细地址...</small>
                    </div>
                </div>

                <div class="mr-form-group theme-poptit">
                    <div class="mr-u-sm-9 mr-u-sm-push-4">
                        <div class="mr-btn mr-btn-danger">保存</div>
                        <div class="mr-btn mr-btn-danger close">取消</div>
                    </div>
                </div>
            </form>
        </div>

    </div>

    <div class="clear"></div>


</rapid:override>
<rapid:override name="script_content">

    <script>

        var submitOrder = function () {
            // console.log( $('#form-order input[name=addressId]').attr('value'));
            if($('#form-order input[name=addressId]').attr('value') == ""){
                addAddress();
            }else{
                $('#form-order').submit();
            }


        }


        var addAddress = function () {

            $blackGround = $("div.theme-popover-mask");
            $addressTable = $("div.theme-popover");
            console.log();
            if ($blackGround.css('display') == 'none') {
                $blackGround.css('display', "inline");
                $addressTable.css('display', 'table');
            }



        }

        $(document).ready(function () {

            $("div.theme-poptit div div").click(function () {
                $blackGround = $("div.theme-popover-mask");
                $addressTable = $("div.theme-popover");

                $blackGround.css('display', "none");
                $addressTable.css('display', 'none');

            })

            $("div.theme-poptit div div:first").click(function () {
                var url = "/order/postAddress";
                $.ajax({
                    url: url,
                    data: $('#form-address').serialize(),
                    datatype: 'json',
                    method: 'get',
                    success: function (resp) {
                        console.log(resp);
                        window.location.reload();
                    }
                })
            })


        })




        var selectFun1 = function () {
            var parentCode = $("select.selected-province option:selected").val();

            var url = "/order/addArea.do";
            $.ajax({
                method: "get",
                url: url,
                data: {"parentCode": parentCode},
                datatype: 'json',
                success: function (resp) {

                    var $prefecture = $('select.selected-prefecture');
                    var $county = $('select.selected-county');
                    $prefecture.empty();
                    $county.empty();
                    $prefecture.append('<option value="0" selected="selected" style="display: none;">请选择</option>');
                    for (var i in resp) {
                        $prefecture.append("<option value='" + i + "'>" + resp[i] + "</option>");
                    }


                }
            })

        }

        var selectFun2 = function () {
            var parentCode = $("select.selected-prefecture option:selected").val();

            var url = "/order/addArea.do";
            $.ajax({
                method: "get",
                url: url,
                data: {"parentCode": parentCode},
                datatype: 'json',
                success: function (resp) {

                    var $county = $('select.selected-county');
                    $county.empty();
                    $county.append('<option value="0" selected="selected" style="display: none;">请选择</option>');
                    for (var i in resp) {
                        $county.append("<option value='" + i + "'>" + resp[i] + "</option>");
                    }


                }
            })

        }


        var delClick = function (del) {
            var addressId = $(del).attr('value');
            var url = '/order/delAddress';
            $.ajax({
                url: url,
                data: {"addressId": addressId},
                datatype: 'json',
                method: 'get',
                success: function (resp) {
                    window.location.reload();
                },
                error:function () {
                    alert("你已经订单使用该地址，暂时不能删除");
                }
            })
        }

        var EditClick = function (del) {
            var addressId = $(del).attr('value');
            //再写吧
        }

        var setDefaultClick = function (set) {
            var addressId = $(set).attr('value');
            var url = '/order/setDefaultAddress';
            $.ajax({
                url: url,
                data: {"addressId": addressId},
                datatype: 'json',
                method: 'get',
                success: function (resp) {
                    window.location.reload();
                }
            })
        }
    </script>

</rapid:override>

<%@ include file="viewBase.jsp" %>

