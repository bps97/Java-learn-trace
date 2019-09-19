<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title></title>


<%@ include file="../commen/navigationHead.jsp" %>

</head>
<body>

<%@ include file="../commen/navigation.jsp" %>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <form action="/admin/product" class="form-inline" id="key-form" method="get">
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
                <th>状态</th>
                <th>&nbsp;&nbsp;&nbsp;&nbsp;操作</th>
            </tr>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td style="width: 5%">
                        <span class="label label-info">${product.id}</span>
                    </td>
                    <td style="width: 8%">
                        <a href="${images.get(product.id)}" class="thumbnail">
                            <img src="${images.get(product.id)}" alt="..." style="width: 50px;height:60px">
                        </a>

                    </td>

                    <td style="width:25%">${product.name}</td>
                    <td style="width:25%">${product.sub_title}</td>
                    <td>${product.price}</td>
                    <td>${categoryMap.get(product.getCategory_id())}</td>
                    <td><c:if test="${product.undercarriage==0}">在售</c:if><c:if test="${product.undercarriage==1}">下架</c:if></td>
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
    <%@ include file="../commen/navigationScript.jsp" %>
</html>
