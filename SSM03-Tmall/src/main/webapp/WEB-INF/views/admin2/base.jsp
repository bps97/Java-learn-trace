<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/9/16
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1.0">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    <script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
    <!-- <script src="./roma.js"></script> -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/5.10.2/css/all.css" rel="stylesheet">
    <!-- <link href="font-awesome.css" rel="stylesheet"> -->

    <!-- <link rel="stylesheet" type="text/css" href="menu1.css"> -->
    <!-- <link rel="stylesheet" type="text/css" href="menu.css"> -->
    <link rel="stylesheet" type="text/css" href="/css/admin2/menu.css">
</head>
<body>
<div class="container">
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
                        </div>
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
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div class="container-fluid" id="main" style="height:450px; width:45%; left: 20%"></div>
</div>




<!-- ECharts单文件引入 -->
<script src="/js/admin2/indexechart.js" type="text/javascript"></script>

<div class="container" id="main1" style="height:450px; width:60%; left: 20%"></div>
<!-- ECharts单文件引入 -->
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts图表 #4ad2ff青色
    var myChart = echarts.init(document.getElementById('main1'));
    var option1 = {
        title : {
            text: '销售额和综合好评度占比图',
            // subtext: '纯属虚构',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            x : 'center',
            y : 'bottom',
            data:['电子类','生活用品类','饮食类']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel']
                },
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        series : [
            {
                name:'产品销售额',
                type:'pie',
                radius : [20, 110],
                center : ['25%', '50%'],
                roseType : 'radius',
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                lableLine: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                data:[
                    {value:45, name:'电子类'},
                    {value:20, name:'生活用品类'},
                    {value:35, name:'饮食类'}
                ]
            },
            {
                name:'综合好评度',
                type:'pie',
                radius : [30, 110],
                center : ['75%', '50%'],
                roseType : 'area',
                data:[
                    {value:40, name:'电子类'},
                    {value:45, name:'生活用品类'},
                    {value:15, name:'饮食类'}
                ]
            }
        ]
    };



    // 为echarts对象加载数据
    myChart.setOption(option1);
</script>
</body>
<script>
    $(document).ready(function()
    {
        $("#myMenu ul li").next("ul").hide();
        $("#myMenu ul li").click(function()
        {
            $(this).next("ul").toggle();
// console.log($(this))
        });
    });

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

    function hideAll() {
        for(i=0;i<odiv.length;i++) {
            odiv[i].style.display="none";
        }
    }

    function showObj(num) {

        if (odiv[num].style.display=="none") {
            hideAll();
            odiv[num].style.display="inline";
        }
        else {
            odiv[num].style.display="none";
        }

// console.log(123)
    }
</script>
</html>
