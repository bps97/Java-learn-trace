<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/9/6
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>

<rapid:override name="main_content">

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

    </rapid:override>


    <%@ include file="../base.jsp" %>