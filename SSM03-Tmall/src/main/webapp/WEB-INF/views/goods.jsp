<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>


<rapid:block name="head_content">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>商品列表</title>

    <link href="/css/seastyle.css" rel="stylesheet" type="text/css" />


    <style>
        @media  screen and (max-width: 400px){
            .select-list{
                display: none;
            }
        }

    </style>
</rapid:block>


<rapid:override name="main_content">





<b class="line"></b>
<div class="search">
<div class="search-list">
<div class="nav-table">
    <div class="long-title">
        <span class="all-goods">全部分类</span>
    </div>
    <div class="nav-cont">
        <ul>
            <li class="index"><a href="#">首页</a></li>
            <li class="qc"><a href="#">闪购</a></li>
            <li class="qc"><a href="#">生鲜</a></li>
            <li class="qc"><a href="#">团购</a></li>
            <li class="qc last"><a href="#">全球购</a></li>
        </ul>
        <div class="nav-extra">
            <i class="mr-icon-user-secret mr-icon-md nav-user"></i>
            <b></b>我的福利
            <i class="mr-icon-angle-right" style="padding-left: 10px;"></i>
        </div>
    </div>
</div>
<div class="mr-g mr-g-fixed">
<div class="mr-u-sm-12 mr-u-md-12">
<div class="theme-popover">
    <div class="searchAbout">
        <span class="font-pale">相关搜索：</span>
        <a title="坚果" href="#">坚果</a>
        <a title="瓜子" href="#">瓜子</a>
        <a title="鸡腿" href="#">豆干</a>
    </div>
    <ul class="select">
        <p class="title font-normal"> <span class="fl">手机</span> <span class="total fl">搜索到<strong class="num">997</strong>件相关商品</span> </p>
        <div class="clear"></div>
        <li class="select-result">
            <dl>
                <dt>
                    已选
                </dt>
                <dd class="select-no"></dd>
                <p class="eliminateCriteria">清除</p>
            </dl>
        </li>
        <div class="clear"></div>




        <c:forEach items="${filterCase}" var="fCase">
        <li class="select-list">
            <dl id="select1">
                <dt class=" mr-round"><c:out value="${fCase.getName()}" /></dt>
                <div class="dd-conent">

                    <dd class="select-all selected">
                        <a href="#">全部</a>
                    </dd>


                    <c:forEach items="${filterMap.get(fCase.getId())}" var="concreteFilter">
                    <dd>
                        <a href="#"><c:out value="${concreteFilter.getValue()}"/></a>
                    </dd>
                    </c:forEach>
<%--                    <dd>--%>
<%--                        <a href="#">3GB</a>--%>
<%--                    </dd>--%>
<%--                    <dd>--%>
<%--                        <a href="#">4GB</a>--%>
<%--                    </dd>--%>
<%--                    <dd>--%>
<%--                        <a href="#">6GB</a>--%>
<%--                    </dd>--%>
<%--                    <dd>--%>
<%--                        <a href="#">无</a>--%>
<%--                    </dd>--%>
<%--                    <dd>--%>
<%--                        <a href="#">其他</a>--%>
<%--                    </dd>--%>
                </div>
            </dl>
        </li>
        </c:forEach>




















    </ul>
    <div class="clear"></div>
</div>
<div class="search-content">
    <div class="sort">
        <li class="first"><a title="综合">综合排序</a></li>
        <li><a title="销量">销量排序</a></li>
        <li><a title="价格">价格优先</a></li>
        <li class="big"><a title="评价" href="#">评价为主</a></li>
    </div>
    <div class="clear"></div>
    <ul class="mr-avg-sm-2 mr-avg-md-3 mr-avg-lg-4 boxes">
        <c:forEach items="${products}" var="product">

        <li>
            <div class="i-pic limit">
                <a href="shopInfo.jsp"><img src="../img/shopcartImg.jpg" /></a>
                <p class="title fl"><c:out value="${product.getName()}"/></p>
                <p class="price fl"> <b>&yen;</b> <strong><c:out value="${product.getPrice()}"/></strong> </p>
                <p class="number fl"> 销量<span><c:out value="${product.getSale()}"/></span> </p>
            </div>
        </li>

        </c:forEach>


    </ul>
</div>
<div class="search-side">
    <div class="side-title">
        经典搭配
    </div>
    <li>
        <div class="i-pic check">
            <a href="shopInfo.jsp"><img src="../img/shopcartImg-01.jpg" /></a>
            <p class="check-title">送耳机+送手机壳</p>
            <p class="price fl"> <b>&yen;</b> <strong>299.00</strong> </p>
            <p class="number fl"> 销量<span>1110</span> </p>
        </div> </li>
    <li>
        <div class="i-pic check">
            <a href="shopInfo.jsp"><img src="../img/shopcartImg-01.jpg" /></a>
            <p class="check-title">送耳机+送手机壳</p>
            <p class="price fl"> <b>&yen;</b> <strong>299.00</strong> </p>
            <p class="number fl"> 销量<span>1110</span> </p>
        </div> </li>
    <li>
        <div class="i-pic check">
            <a href="shopInfo.jsp"><img src="../img/shopcartImg-01.jpg" /></a>
            <p class="check-title">送耳机+送手机壳</p>
            <p class="price fl"> <b>&yen;</b> <strong>299.00</strong> </p>
            <p class="number fl"> 销量<span>1110</span> </p>
        </div> </li>

</div>
<div class="clear"></div>
<!--分页 -->
<ul class="mr-pagination mr-pagination-right">
    <li class="mr-disabled"><a href="#">&laquo;</a></li>
    <li class="mr-active"><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">&raquo;</a></li>
</ul>
</div>
</div>
</div>
</div>

<div class="theme-popover-mask"></div>
</rapid:override>

<%@ include file="viewBase.jsp" %>
