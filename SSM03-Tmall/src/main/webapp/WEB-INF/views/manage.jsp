<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>

<rapid:override name="main_content">

    <div class="panel panel-default">
        <div class="panel-heading">
            <form action="FBListServlet" class="form-inline" id="key-form">

                <input type="text" class="form-control" name="key" id="key">
                <input type="submit" class="form-control btn-primary" value="搜索">

                <a href="/manage/add" class="btn btn-success">添加</a>
            </form>

        </div><!-- panel-heading -->

        <div class="panel-body">
            <table class="table table-hover table-striped">
                <tr>
                    <th>ID</th>

                    <th>主题</th>
                    <th>副标题</th>
                    <th>价格</th>
                    <th>分类</th>

                    <th>&nbsp;&nbsp;&nbsp;&nbsp;操作</th>

                </tr>
                <c:forEach items="${products}" var="product" varStatus="status">
                    <tr>

                        <td>

                            <span class="label label-info"><c:out value="${status.count+page.start}"/></span>

                        </td>

                        <td style="width: 25%"><c:out value="${product.name}"/></td>
                        <td style="width: 25%"><c:out value="${product.sub_title}"/></td>
                        <td ><c:out value="${product.price}"/></td>


                        <td><c:out value="${categoryMap.get(product.getCategory_id())}"/></td>



                        <td>


                            <div class="btn btn-group">
                                <a href="/manage/info/${product.id}" class="btn btn-default btn-sm" title="查看"><i
                                        class="fa fa-search"></i></a>
                                <a href="/manage/edit/${product.id}" class="btn btn-default btn-sm" title="编辑"><i
                                        class="fa fa-edit"></i></a>
                                <a href="/manage/del/${product.id}" class="btn btn-default btn-sm" title="删除"><i
                                        class="fa fa-trash"></i></a>
                            </div>

                        </td>
<%--                        <div class="col-xs-6 col-md-4">--%>
<%--                            <a href="#" class="thumbnail">--%>
<%--                                <img src="${images.get(product.id)}" alt="...">--%>
<%--                            </a>--%>
<%--                        </div>--%>


                    </tr>
                </c:forEach>
            </table>
        </div><!-- panel-body -->

        <div class="panel-footer">
            <div class="btn-group col-md-offset-6 col-sm-offset-6" role="group" aria-label="...">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                <c:forEach begin="0" end="${page.getTotalPage()-1}" varStatus="status">
                    <c:if test="${status.step*page.step-page.start<=30 && status.count*page.step-page.start>=-20}"><!--只显示最近四个-->
                        <li <c:if test='${status.index*page.step==page.start}'>class="mr-active"</c:if>>  <!--当前页面-->
                            <a href="?start=${status.index*page.step}"<c:if test="${status.index*page.step==page.start}">class="mr-active"</c:if>>${status.count}</a>
                        </li>
                    </c:if>
                </c:forEach>
                    </ul>
                </nav>
            </div>
        </div>
        <!--panel-footer-->




    </div>
    <!-- panel panel-default -->

</rapid:override>


<%@ include file="base.jsp" %>