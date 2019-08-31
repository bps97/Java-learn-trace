<%@ page contentType="text/html;charset=UTF-8"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8" />
    <title></title>

    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/5.10.2/css/all.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="css/menu.css" >

</head>
<body>

<nav class="navbar navbar-default">
    <div class="navbar-header">
        <button data-target="#xxx_nav" data-toggle="collapse" class="navbar-toggle" >
            <span class="sr-only"> </span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a href="#" class="navbar-brand">XX后台</a>
    </div>
    <div id="xxx_nav" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li  class="active"><a href="#">首页</a></li>
            <li><a href="#">电力</a></li>
            <li><a href="#">水力</a></li>
            <li><a href="#">道路</a></li>
        </ul>
        <!-- <form action="#" class="navbar-form ">
            <div class="form-group">
                <input type="text" class="form-control">
            </div>
        </form> -->
        <ul class="nav navbar-nav navbar-right">

            <li><a href="#">登陆</a></li>
            <!-- 下拉菜单 -->
            <li class="dropdown" >
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

<div class="container-fluid">
    <nav class="navbar navbar-vertical-left">
        <ul class="nav navbar-nav">
            <li>
                <a href select>
                    <i class="fa fa-fw fa-lg fa-home"></i>
                    <span>主页</span>
                </a>
            </li>
            <li>
                <a href>
                    <i class="fa fa-fw fa-lg fa-download "></i>
                    <span>Menu 2</span>
                </a>
            </li>
            <li>
                <a href>
                    <i class="fa fa-fw fa-lg fa-comments-o"></i>
                    <span>Menu 3</span>
                </a>
            </li>
            <li>
                <a href>
                    <i class="fa fa-fw fa-lg fa-desktop"></i>
                    <span>Menu 4</span>
                </a>
            </li>
            <li>
                <a href>
                    <i class="fa fa-fw fa-lg fa-tablet"></i>
                    <span>Menu 5</span>
                </a>
            </li>
            <li>
                <a href>
                    <i class="fa fa-fw fa-lg fa-laptop"></i>
                    <span>Menu 6</span>
                </a>
            </li>
        </ul>
    </nav>



    <div class=" col-xs-offset-2 col-md-offset-2 col-sm-offset-2 col-xs-8">
    </div>

    <div class=" col-xs-offset-2 col-md-offset-2 col-sm-offset-2 col-xs-8">

                <rapid:block name="main_content">
                    <!-- 注意 -->
                </rapid:block>

    </div>

</div>




</body>
</html>
