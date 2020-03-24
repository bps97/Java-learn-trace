<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/9/22
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<rapid:override name="main_content">
    <div class="container">


        <div class="panel panel-default">
            <div class="panel-heading text-right">
                <a href="/admin/ad/add" class="btn btn-success">添加</a>
            </div>
        </div>


        <c:forEach items="${categoryMap.keySet()}" var="category">
            <div class="col-md-2">
                <div class="list-group">
                    <a href="#" class="list-group-item active">${category.name}</a>
                    <c:forEach items="${categoryMap.get(category)}" var="subCategory">
                        <a href="#" class="list-group-item">${subCategory.name}</a>
                    </c:forEach>
                </div>
            </div>
        </c:forEach>

    </div>


</rapid:override>
<%@ include file="../base.jsp" %>
