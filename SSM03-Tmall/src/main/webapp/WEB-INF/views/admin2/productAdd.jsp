<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/9/18
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<rapid:override name="main_content">
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading"><h4>添加商品</h4></div>
        <div class="panel-body">
            <form action="/admin/product/add/post" method="post" class="form-horizontal" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="name" class="col-md-2 control-label">主题</label>
                    <div class="col-md-2">
                        <textarea name="name" id="name" cols="40" rows="3">${product.name}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="sub_title" class="col-md-2 control-label">子标题</label>
                    <div class="col-md-2">
                        <textarea name="sub_title" id="sub_title" cols="40" rows="2">${product.sub_title}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="category" class="control-label col-md-2">分类</label>
                    <div class="col-md-2">
                        <select name="category" id="category" class="form-control">
                            <c:forEach items="${categories}" var="category">
                                <option value="${category.id}"
                                        <c:if test="${product.category_id ==category.id}">selected</c:if>><c:out
                                        value="${category.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <c:forEach items="${filterCases}" var="filterCase">
                    <div class="form-group">
                        <label class="control-label col-md-2"><c:out value="${filterCase.name}"/></label>
                        <div class="col-md-6 checkbox" >
                            <c:forEach items="${filterMap.get(filterCase.id)}" var="cFilter">
                                <label>
                                    <input type="checkbox" name="associate_${filterCase.id}" value="${filterCase.id}">
                                    <span class=""><c:out value="${cFilter.value}"/></span>
                                </label>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
                <div class="form-group">
                    <label for="price" class="col-md-2 control-label ">价格</label>
                    <div class="col-md-2">
                        <input id="price" type="text" name="price" class="form-control" placeholder="999.99"
                               value='${product.price}'>
                    </div>
                </div>
                <div class="form-group">
                    <label for="stock" class="col-md-2 control-label ">库存</label>
                    <div class="col-md-2">
                        <input id="stock" type="text" name="stock" class="form-control" placeholder="9999"
                               value='${product.stock}'>
                    </div>
                </div>
                <div class="form-group">
                    <label for="image" class="col-md-2 control-label">图片</label>
                    <div class="col-md-6">
                        <input type="file" id="image" name="image">
                    </div>
                </div>
                <div class="col-md-2 col-md-offset-1">
                    <input type="submit" class="btn btn-primary" value="提交">
                    <input type="reset" class="btn btn-default" value="重置">
                </div>
            </form>
        </div>
        <div class="panel-footer">
            <button class="btn btn-default" onclick="javascript:history.back(-1);">返回</button>
        </div>
    </div>

</div>
</rapid:override>
<%@ include file="base.jsp" %>