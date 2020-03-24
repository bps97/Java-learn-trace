<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/8/5
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>


<html>
  <head>
    <title>$Title$</title>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  </head>
  <body>
  <div class="container">
    <div class="row">
      <div class="col col-md-3"></div>
      <div class="col col-md-6">
        <table  class="table table-striped table-bordered table-hover">
          <thead>
          <tr>
            <td>序号</td>
            <td>学号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>出生日期</td>
            <td>编辑</td>
            <td>删除</td>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${students.toArray()}" var="student">
            <tr>
              <td><c:out value="${student.getId()}"/></td>
              <td><c:out value="${student.getStudentId()}"/></td>
              <td><c:out value="${student.getStudentName()}"/></td>
              <td><c:out value="${student.getStudentAge()}"/></td>
              <td><c:out value="${student.getStudentSex()}"/></td>
              <td><c:out value="${student.getBirthday()!=null?student.getFormatBirthday().substring(5):''}"/></td>

              <td><a href='/edit?id=${student.getId()}'><i class='fa fa-edit'/></a></td>
              <td><a href='/del?id=${student.getId()}'><i class='fa fa-trash'/></a></td>

            </tr>
<%--              out.print("<td><a href='EditServlet?id="+student.getId()+"'><i class='fa fa-edit'></a</td>");--%>
<%--              out.print("<td><a href='DelServlet?id="+student.getId()+"'><i class='fa fa-trash'></a></td>");--%>
          </c:forEach>

          </tbody>
          <troot>
            <text class="lead">学生列表：共${count}人</text>
          </troot>
        </table>
      </div>
    </div>
    <div class="row">
      <div class="container">
        <div class="row"  >
          <div class="col col-md-3"></div>
          <div class="col col-md-6">
            <ul class="pagination">
              <li id="pgpre"><a href="#"><</a></li>
              <li id="pg1"><a href="list?pg=1">1</a></li>
              <li id="pg2"><a href="list?pg=2">2</a></li>
              <li id="pg3"><a href="list?pg=3">3</a></li>
              <li id="pg4"><a href="list?pg=4">4</a></li>
              <li id="pg5"><a href="list?pg=5">5</a></li>
              <li id="pg6"><a href="list?pg=6">6</a></li>
              <li id="pg7"><a href="list?pg=7">7</a></li>
              <li id="pgnext"><a href="list">></a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
  </body>
  <script>

    $(document).ready(function ($) {
      var pg = GetQueryString("pg");
      p = $("#pg"+pg);
      console.log(p.text());
        p.attr('class','active');

      if(pg > 1) {
        $("#pgpre").children().attr("href","list?pg="+parseInt(pg-1));
        $("#pgnext").children().attr("href","list?pg="+parseInt(pg-1*-1));
      }
      if(pg<1){
        pg=1;
        alert("已到顶端");
      }


    })
    function GetQueryString(name)
    {
      var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
      // 匹配地址栏参数
      var r = window.location.search.substr(1).match(reg);
      if(r!=null)return  unescape(r[2]); return null;
    }

  </script>
</html>
