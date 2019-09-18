<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/9/17
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<html>
<head>

    <rapid:block name="head_content">

    </rapid:block>

    <meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1.0">

    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>

    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/5.10.2/css/all.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/admin2/menu.css">


    <style>
        .nav navbar-nav .panel-group .panel+.panel {
            margin-top: 0px;
        }
    </style>



</head>
<body>


<nav class="navbar navbar-default" >
    <div class="navbar-header">
        <button data-target="#xxx_nav" data-toggle="collapse" class="navbar-toggle">
            <span class="sr-only"> </span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a href="#" class="navbar-brand">管理员后台</a>
    </div>
    <div id="xxx_nav" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="./base.html">首页</a></li>
            <li><a href="#">用户信息</a></li>
            <li><a href="/admin/product">产品管理</a></li>
            <li><a href="./ddLiu.html">订单管理</a></li>
        </ul>
        <!-- <form action="#" class="navbar-form ">
            <div class="form-group">
                <input type="text" class="form-control">
            </div>
        </form> -->
        <ul class="nav navbar-nav navbar-right">

            <li><a href="" >登录</a></li>

            <!-- 下拉菜单 -->
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">HH<b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>


<nav class="navbar navbar-vertical-left" style="background:#fff">
    <ul class="nav navbar-nav">
        <div class="panel-group" id="accordion">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <a data-toggle="collapse" data-parent="#accordion" href="">
                        <i class="fa fa-home fa-lg "></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <span>主页</span>
                    </a>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                        <i class="fa fa-user fa-lg "></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <span>用户</span>
                    </a>
                </div>
                <div id="collapseOne" class="panel-collapse collapse" aria-disabled="true" style="text-align: center;">
                    <div class="panel-body">
                        <a href="">用户信息</a>
                    </div>
                    <div class="panel-body">
                        <a href="">用户添加</a>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                        <i class="fa fa-gift fa-lg "></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <span>产品</span>
                    </a>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse" style="text-align: center">
                    <div class="panel-body">
                        <a href="/admin/product">产品列表</a>
                    </div>
                    <div class="panel-body">
                        <a href="/admin/product/add">添加产品</a>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                        <i class="fa fa-window-restore fa-lg "></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <span>订单</span>
                    </a>
                </div>
                <div id="collapseThree" class="panel-collapse collapse" style="text-align: center">
                    <div class="panel-body">
                        <a href="./ddLiu.html">订单流量</a>
                    </div>
                    <div class="panel-body">
                        <a href="./ddSelect.html">订单查询</a>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
                        <i class="fa fa-clone fa-lg "></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <span>分类</span>
                    </a>
                </div>
                <div id="collapseFour" class="panel-collapse collapse" style="text-align: center">
                    <div class="panel-body">
                        <a href="">电子产品</a>
                    </div>
                    <div class="panel-body">
                        <a href="">生活用品</a>
                    </div>
                    <div class="panel-body">
                        <a href="">饮食</a>
                    </div>
                </div>
            </div>
        </div>
    </ul>
</nav>
<rapid:block name="main_content">
    <!-- 注意这里是内容 -->
</rapid:block>


</body>
<rapid:block name="script_content">
    <%--  这里是js脚本   --%>
</rapid:block>
<script>
    $(document).ready(function()
    {
        $('.panel-default').on('mouseover',function(){

            $(this).children("div.panel-collapse").removeClass('collapse')
            $(this).children("div.panel-collapse").addClass('collapse in')
        })
        $('.panel-default').on('mouseout',function(){
            $(this).children("div.panel-collapse").removeClass('collapse in')
            $(this).children("div.panel-collapse").addClass('collapse')
        })
    });

    $(function(){
        $("#xxx_nav li").on("mouseover",function(){
            $('#xxx_nav li').removeClass('active')
            $(this).addClass('active')
        })
    })

</script>
</html>

<%--<script src="/js/admin2/indexechart.js" type="text/javascript"></script>--%>
