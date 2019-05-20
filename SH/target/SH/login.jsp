<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: knightx
  Date: 2019/1/12
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>login页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/userLogin" method="post">
    请登录：<input type="text" name="login">
    <input type="submit" value="登录">

</form>
</body>
</html>
