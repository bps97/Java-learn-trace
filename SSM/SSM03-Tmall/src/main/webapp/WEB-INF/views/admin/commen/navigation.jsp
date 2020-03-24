<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/9/19
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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
            <li class="active"><a href="/admin">首页</a></li>
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


            <!-- 下拉菜单 -->
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">欢迎！<b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="/admin/logout/post">注销</a></li>
                    <li><a href="/admin/switch/post">切换</a></li>
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
                    <a data-parent="#accordion" href="">
                        <i class="fa fa-home fa-lg "></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <span>主页</span>
                    </a>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <a data-parent="#accordion" href="#collapseOne">
                        <i class="fa fa-user fa-lg "></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <span>广告</span>
                    </a>
                </div>
                <div id="collapseOne" class="panel-collapse collapse" aria-disabled="true" style="text-align: center;">
                    <div class="panel-body">
                        <a href="/admin/ad/">广告信息</a>
                    </div>
                    <div class="panel-body">
                        <a href="/admin/ad/add">广告添加</a>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <a data-parent="#accordion" href="#collapseTwo">
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
                    <a data-parent="#accordion" href="#collapseThree">
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
                    <a  data-parent="#accordion" href="#collapseFour">
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