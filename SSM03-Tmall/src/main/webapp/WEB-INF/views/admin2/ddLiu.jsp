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
    <!-- <link rel="stylesheet" type="text/css" href="menu1.css"> -->
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
        <a href="#" class="navbar-brand">管理员后台</a>
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
<!-- <div class="container1">
        <div class="link">
          <div class="text">首页</div>
        </div>
        <div class="link">
          <div class="text">产品</div>
        </div>
        <div class="link">
          <div class="text">订单</div>
        </div>
        <div class="link">
          <div class="text">分类</div>
        </div>
      </div> -->

<div class="container">
    <div class="panel panel-default">
            <table class="table table-hover" style="text-align: center;">
                    <thead>
                    <tr><th>订单流量详情</th></tr>
                      <tr>
                        <th>产品</th>
                        <th>付款日期</th>
                        <th>状态</th>
                        <th>操作</th></tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>产品1</td>
                        <td>23/11/2013</td>
                        <td>待发货</td>
                        <td>
                            <a href="./ddEdit.jsp"><button class="btn btn-primary">编辑</button></a>
                            <a href=""><button href="" class="btn btn-primary">删除</button></a>
                        </td>
                      </tr>
                      <tr>
                        <td>产品2</td>
                        <td>10/11/2013</td>
                        <td>发货中</td>
                        <td >
                            <a href="./ddEdit.jsp"><button class="btn btn-primary">编辑</button></a>
                            <a href=""><button href="" class="btn btn-primary">删除</button></a>
                        </td>
                      </tr>
                      <tr>
                        <td>产品3</td>
                        <td>20/10/2013</td>
                        <td>待确认</td>
                        <td >
                            <a href="./ddEdit.jsp"><button class="btn btn-primary">编辑</button></a>
                            <a href=""><button href="" class="btn btn-primary">删除</button></a>
                        </td>
                      </tr>
                      <tr>
                        <td>产品4</td>
                        <td>20/10/2013</td>
                        <td>已退货</td>
                        <td >
                            <a href="./productEdit.jsp"><button class="btn btn-primary">编辑</button></a>
                            <a href=""><button href="" class="btn btn-primary">删除</button></a>
                        </td>
                      </tr>
                    </tbody>
                  </table>
    </div>
    <nav aria-label="Page navigation example" style="text-align: center;">
            <ul class="pagination">
              <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item"><a class="page-link" href="#">2</a></li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                  <span aria-hidden="true">&raquo;</span>
                </a>
              </li>
            </ul>
          </nav>
</div>
</body>
<script>
$(function(){
    $("#xxx_nav li").on("mouseover",function(){
        $('#xxx_nav li').removeClass('active')
        $(this).addClass('active')
    })
})
var links = document.getElementsByClassName('link')
for(var i = 0; i <= links.length; i++)
{
   addClass(i)
}

function addClass(id){
   setTimeout(function(){
      if(id > 0) links[id-1].classList.remove('hover')
      links[id].classList.add('hover')
   }, id*750) 
}
</script>
</html>