<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/8/6
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Post</title>
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
            <form action="/update?id=${student.getId()}" class="form" method="post">
                <div class="form-group">
                    <label for="sname" class="control-label">姓名</label>
                    <input id="sname" name="sname" type="text" class="form-control" value='${student.getStudentName()}'>
                </div>
                <div class="form-group">
                    <label for="sid" class="control-label">学号</label>
                    <input id="sid" name="sid" type="text" class="form-control" value="${student.getStudentId()}">

                </div>
                <div class="form-group">
                    <label for="sage" class="control-label">年龄</label>
                    <input id="sage" name="sage" type="text" class="form-control" value="${student.getStudentAge()}">

                </div>
                <div class="form-group">
                    <label for="sex1" class="control-label" >男</label>
                    <input type="radio" name="ssex"  id="sex1" value="1" ${student.getStudentSex()=='男'?'checked':''} >
                    <label for="sex0" class="control-label" >女</label>
                    <input type="radio" name="ssex"  id="sex0"  value="0" ${student.getStudentSex()=='女'?'checked':''} >


                </div>
                <div class="form-group">
                    <label for="birthday" class="control-label">生日</label>
                    <input id="birthday" name="birthday" type="date" class="form-control" value="${student.getBirthday()!=null?student.getFormatBirthday():''}">
                </div>

                <div class="form-group">
                    <input id="sub" name="sub" type="submit" class="form-control">

                </div>



            </form>
        </div>

        <div class="col col-md-3"></div>

    </div>
</div>


</body>
</html>
