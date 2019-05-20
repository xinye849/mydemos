<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>customerList</title>



</head>
<body>
<%--
<c:forEach items="${customerList}" var="customer">
    <c:out value="${customer.custId}"/>
    <c:out value="${customer.custName}"/>
</c:forEach>
--%>
<%--
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

<c:forEach var="c" items="${requestScope.customerList}">
    <tr>
        <td><c:out value="${c.custId}"/></td>
        <td><c:out value="${c.custName}"/></td>
        <td><c:out value="${c.custSource}"/></td>
        <td><c:out value="${c.custLevel}"/></td>
        <td><c:out value="${c.custIndustry}"/></td>
        <td><c:out value="${c.custAddress}"/></td>
        <td><c:out value="${c.custPhone}"/></td>
    </tr>


</c:forEach>
</table>
--%>

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
