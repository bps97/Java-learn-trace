<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/8/21
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${product.images}" var="image">
        <li>${image.originalFilename}</li>
        <img src='<c:url value="/images/"/>${image.originalFilename}'/>
    </c:forEach>
</body>
</html>
