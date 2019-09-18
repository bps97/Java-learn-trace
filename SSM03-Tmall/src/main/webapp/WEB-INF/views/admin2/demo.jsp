<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/9/18
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/9/18
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>

<rapid:override name="head_content">
    <title>主页</title>

<%--    <script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>--%>

</rapid:override>

<rapid:override name="main_content">




    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading">
                <form action="FBListServlet" class="form-inline" id="key-form">
                    <input type="text" class="form-control" name="key" id="key">
                    <input type="submit" class="form-control btn-primary" value="搜索">
                    <a href="/manage/add" class="btn btn-success">添加</a>
                    <ul class="pagination" style="text-align: center; float: right;">
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
                </form>
            </div>
        </div><!-- panel-heading -->
        <div class="panel-body panel panel-default">
            <table class="table table-hover table-striped">
                <tr  style="text-align: center">
                    <th>ID</th>
                    <th>图片</th>
                    <th>主题</th>
                    <th>副标题</th>
                    <th>价格</th>
                    <th>分类</th>
                    <th>&nbsp;&nbsp;&nbsp;&nbsp;操作</th>
                </tr>
                <tr>
                    <td style="width: 5%">
                        <span class="label label-info">1</span>
                    </td>
                    <td style="width: 5%">
                        <img src="./img/1.jpg" alt="..." style="width: 90%;height:50px">
                    </td>
                    <td style="width:25%">Huawei/华为P30 Pro曲面屏超感光徕卡四摄变焦双景录像980智能手机p30pro</td>
                    <td style="width:25%">4000万超感光徕卡四摄</td>
                    <td >988.0</td>
                    <td>手机</td>
                    <td>
                        <div class="btn btn-group">
                            <a href="/manage/info/1" class="btn btn-default btn-sm" title="查看"><i
                                    class="fa fa-search"></i></a>
                            <a href="/manage/edit/1" class="btn btn-default btn-sm" title="编辑"><i
                                    class="fa fa-edit"></i></a>
                            <a href="/manage/del/1" class="btn btn-default btn-sm" title="删除"><i
                                    class="fa fa-trash"></i></a>
                        </div>
                    </td>
                <tr>
                    <td>
                        <span class="label label-info">1</span>
                    </td>
                    <td>
                        <img src="./img/1.jpg" alt="..." style="width: 90%;height:50px">
                    </td>
                    <td style="width: 25%">Huawei/华为P30 Pro曲面屏超感光徕卡四摄变焦双景录像980智能手机p30pro</td>
                    <td style="width: 25%">4000万超感光徕卡四摄</td>
                    <td >988.0</td>

                    <td>手机</td>

                    <td>

                        <div class="btn btn-group">
                            <a href="/manage/info/1" class="btn btn-default btn-sm" title="查看"><i
                                    class="fa fa-search"></i></a>
                            <a href="/manage/edit/1" class="btn btn-default btn-sm" title="编辑"><i
                                    class="fa fa-edit"></i></a>
                            <a href="/manage/del/1" class="btn btn-default btn-sm" title="删除"><i
                                    class="fa fa-trash"></i></a>
                        </div>
                    </td>



                </tr>
                </tr>

            </table>
        </div>
    </div>


</rapid:override>

<rapid:override name="scriot_content">


</rapid:override>

<%@ include file="base.jsp" %>