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

    <script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>

</rapid:override>

<rapid:override name="main_content">




    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div class="container-fluid" id="main" style="height:450px; width:45%; left: 20%"></div>
    <!-- ECharts单文件引入 -->
    <div class="container" id="main1" style="height:450px; width:60%; left: 20%"></div>

    <script type="text/javascript" src="/js/admin/indexEChart.js"></script>


</rapid:override>

<rapid:override name="scriot_content">


</rapid:override>

<%@ include file="base.jsp" %>