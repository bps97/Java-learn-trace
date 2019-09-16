
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title></title>

    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/5.10.2/css/all.css" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="../../static/css/admin2/menu.css">

</head>
<body>


<nav class="navbar navbar-default">
    <div class="navbar-header">
        <button data-target="#xxx_nav" data-toggle="collapse" class="navbar-toggle">
            <span class="sr-only"> </span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a href="#" class="navbar-brand">XX后台</a>
    </div>
    <div id="xxx_nav" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="./base.jsp">首页</a></li>
            <li><a href="#">用户信息</a></li>
            <li><a href="./productList.jsp">产品管理</a></li>
            <li><a href="./ddLiu.jsp">订单管理</a></li>
        </ul>
        <!-- <form action="#" class="navbar-form ">
            <div class="form-group">
                <input type="text" class="form-control">
            </div>
        </form> -->
        <ul class="nav navbar-nav navbar-right">

            <li><a href="#">登陆</a></li>
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


<nav class="navbar navbar-vertical-left">
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
                        <li class="panel-heading">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                <i class="fa fa-user fa-lg "></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              <span>用户</span>
                            </a>
                        </li>
                        <li id="collapseOne" class="panel-collapse collapse" style="text-align: center">
                                <div class="panel-body">
                                 <a href="">用户信息</a>
                                </div>
                                <div class="panel-body">
                                 <a href="">用户添加</a>
                                </div>
                        </li>
            </div>
            <div class="panel panel-default">
                    <li class="panel-heading">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                            <i class="fa fa-gift fa-lg "></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          <span>产品</span>
                        </a>
                    </li>
                    <li id="collapseTwo" class="panel-collapse collapse" style="text-align: center">
                            <div class="panel-body">
                             <a href="./productList.jsp">产品列表</a>
                            </div>
                            <div class="panel-body">
                             <a href="./addProduct.jsp">添加产品</a>
                    </li>
            </div>
            <div class="panel panel-default">
                    <li class="panel-heading">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                            <i class="fa fa-window-restore fa-lg "></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          <span>订单</span>
                        </a>
                    </li>
                    <li id="collapseThree" class="panel-collapse collapse" style="text-align: center">
                            <div class="panel-body">
                             <a href="./ddLiu.jsp">订单流量</a>
                            </div>
                            <div class="panel-body">
                             <a href="./ddSelect.jsp">订单查询</a>
                            </div>
                    </li>
            </div>
            <div class="panel panel-default">
                    <li class="panel-heading">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
                            <i class="fa fa-clone fa-lg "></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          <span>分类</span>
                        </a>
                    </li>   
                    <li id="collapseFour" class="panel-collapse collapse" style="text-align: center">
                            <div class="panel-body">
                                    <a href="">电子产品</a>
                                   </div>
                                   <div class="panel-body">
                                    <a href="">生活用品</a>
                                   </div>
                                   <div class="panel-body">
                                    <a href="">饮食</a>
                                   </div>
                    </li>
            </div>
         </div>
        </ul>
        </nav>
<div class="container">
<div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4>详细内容</h4>

            </div>
            <div class="panel-body">
                <form action="/post_feedback/" method="post" class="form-horizontal">
                    <div class="media ">
                        <div class="media-left">


                            <img src="${image}" style="width:100px;height:100px;" alt="" class="media-object">
                        </div>
                        <div class="media-body ">
                            <span class="meadia.heading"><c:out value="${product.name}"/></span>
                        </div>
                    </div>


                </form>
            </div>
            <div class="panel-footer">
                <button class="btn btn-default" onclick="javascript:history.back(-1);">返回</button>

            </div>
        </div>

    </div>
</div>




</body>
</html>
