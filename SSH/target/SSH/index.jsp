<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<body>
<h2><a href="${pageContext.request.contextPath}/findAllCustomer">查询所有</a></h2><br>


<form action="${pageContext.request.contextPath}/addCustomer" method="post">

    姓名：<input type="text" name="custName"/><br>
    地址：<input type="text" name="custAddress"/><br>
    电话：<input type="text" name="custPhone"/>
    <input type="submit" value="增加"/>


</form>




</body>
</html>
