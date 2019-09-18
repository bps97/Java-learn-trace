<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title></title>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/5.10.2/css/all.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/admin2/menu.css">
    <style>
        .pagination {
            display: inline-block;
            padding-left: 0;
            margin: 0;
            border-radius: 4px;
        }
        .table>tbody>tr>td, .table>tbody>tr>th,
        .table>tfoot>tr>td, .table>tfoot>tr>th,
        .table>thead>tr>td, .table>thead>tr>th{
            padding: 8px;
            line-height: 1.42857143;
            vertical-align: middle;
            width: 30px;
            border-top: 1px solid #ddd;
        }
    </style>
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
            <li><a href="./productList.html">产品管理</a></li>
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
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <form action="FBListServlet" class="form-inline" id="key-form">
                <input type="text" class="form-control" name="key" id="key">
                <input type="submit" class="form-control btn-primary" value="搜索">
                <a href="/admin/product/add" class="btn btn-success">添加</a>
                <ul class="pagination" style="text-align: center; float: right;">
                    <li class="page-item">
                        <a class="page-link" href='?start=<c:if test="${page.start>0}">${page.start-page.step}</c:if>' aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach begin="0" end="${page.getTotalPage()}" varStatus="status">
                        <c:if test="${status.step*page.step-page.start<30 && status.count*page.step-page.start>-20}"><!--只显示最近四个-->
                            <li <c:if test='${status.index*page.step==page.start}'>class="mr-active"</c:if>>  <!--当前页面-->
                                <a href="?start=${status.index*page.step}"<c:if test="${status.index*page.step==page.start}">class="mr-active"</c:if>>${status.count}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                    <li class="page-item">
                        <a class="page-link" href="?start=${page.start+page.step}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <!-- panel-heading -->
    <div class="panel-body panel panel-default">
        <table class="table table-hover table-striped">
            <tr style="text-align: center">
                <th>ID</th>
                <th>图片</th>
                <th>主题</th>
                <th>副标题</th>
                <th>价格</th>
                <th>分类</th>
                <th>&nbsp;&nbsp;&nbsp;&nbsp;操作</th>
            </tr>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td style="width: 5%">
                        <span class="label label-info">${product.id}</span>
                    </td>
                    <td style="width: 8%">
                        <a href="${images.get(product.id)}" class="thumbnail">
                            <img src="${images.get(product.id)}" alt="..." style="width: 50px;height:50px">
                        </a>

                    </td>

                    <td style="width:25%">${product.name}</td>
                    <td style="width:25%">${product.sub_title}</td>
                    <td>${product.price}</td>
                    <td>${categoryMap.get(product.getCategory_id())}</td>
                    <td>
                        <div class="btn btn-group">
                            <a href="/admin/product/info/${product.id}" class="btn btn-default btn-sm" title="查看"><i
                                    class="fa fa-search"></i></a>
                            <a href="/admin/product/edit/${product.id}" class="btn btn-default btn-sm" title="编辑"><i
                                    class="fa fa-edit"></i></a>
                            <a href="/admin/product/del/${product.id}" class="btn btn-default btn-sm" title="删除"><i
                                    class="fa fa-trash"></i></a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
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
           // console.log( $(this).parent().children("div.panel-body"))
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
