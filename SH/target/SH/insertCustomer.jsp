<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: knightx
  Date: 2019/1/10
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>添加用户</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/insertCustomer" method="post">


    姓名：<input type="text" name="custName"/><br/>
    资源：<input type="text" name="custSource"/><br/>
    水平：<input type="text" name="custLevel"/><br/>
    公司：<input type="text" name="custIndustry" /><br/>
    地址 <input type="text" name="custAddress" /><br/>
    电话<input type="text" name="custPhone" /><br/>
    &nbsp<input type="submit" value="提交"/><br/>

</form>
</body>
</html>
