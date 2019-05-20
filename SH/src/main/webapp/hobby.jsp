<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: knightx
  Date: 2019/1/9
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>hobby</title>
</head>
<body>
<!--把这个打开就是完整的ognl方式封装表单
<form action="${pageContext.request.contextPath}/hobby3" method="post">

这个是ognl表达式的表单，如果不是自己写的根本不知道这个user就是action类中的user对象，弊端很大
    姓名：<input type="text" name="user.name"/><br/>
    年龄：<input type="text" name="user.age"/><br/>
    生日：<input type="text" name="user.birth"/>
    爱好：<input type="checkbox" name="user.hobby" value="吃饭"/>
    <input type="checkbox" name="user.hobby" value="睡觉"/>
    <input type="checkbox" name="user.hobby" value="写代码"/><br/>
    &nbsp<input type="submit" value="提交"/>

</form>
-->



<form action="${pageContext.request.contextPath}/hobby4" method="post">


    姓名：<input type="text" name="name"/><s:fielderror fieldName="name"/> <br/>
    年龄：<input type="text" name="age"/><br/><s:fielderror fieldName="age"/>
    生日：<input type="text" name="birth"/><s:fielderror fieldName="birth"/>
    爱好：<input type="checkbox" name="hobby" value="吃饭"/>吃饭
    <input type="checkbox" name="hobby" value="睡觉"/>睡觉
    <input type="checkbox" name="hobby" value="写代码"/>写代码<br/>
    &nbsp<input type="submit" value="提交"/>

</form>
</body>
</html>
