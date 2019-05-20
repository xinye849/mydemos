<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<%--
  Created by IntelliJ IDEA.
  User: knightx
  Date: 2019/1/13
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>meun</title>
</head>
<body>
<table border="1" >
    <tr>
        <td>ID</td>
        <td>姓名</td>
        <td>信息源</td>
        <td>水平</td>
        <td>公司</td>
        <td>地址</td>
        <td>电话</td>

    </tr>

    <s:iterator var="c" value="#request.customerList">

        <tr>
            <td><s:property value="#c.custId"/> </td>
            <td><c:out value="${c.custName}"/></td>
            <td><c:out value="${c.custSource}"/></td>
            <td><c:out value="${c.custLevel}"/></td>
            <td><c:out value="${c.custIndustry}"/></td>
            <td><c:out value="${c.custAddress}"/></td>
            <td><c:out value="${c.custPhone}"/></td>
        </tr>




    </s:iterator>
</table>
<s:debug/>
</body>
</html>
