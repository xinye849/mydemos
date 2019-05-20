<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: knightx
  Date: 2019/1/12
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>欢迎来到main主页</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/demo1">demo1入口</a><br>
<a href="${pageContext.request.contextPath}/demo2">demo2入口</a><br>
<a href="${pageContext.request.contextPath}/demo3">demo3入口</a><br>
</body>
</html>
