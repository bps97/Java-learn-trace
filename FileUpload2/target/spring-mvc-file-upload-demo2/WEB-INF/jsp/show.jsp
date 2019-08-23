<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<%--
  Created by IntelliJ IDEA.
  User: bps
  Date: 2019/8/23
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img src='<c:url value="/file/"/>${loadedFile.originalFilename}'/>

</body>
</html>
