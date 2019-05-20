<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
  Created by IntelliJ IDEA.
  User: knightx
  Date: 2019/4/12
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>

    <title>入门</title>
</head>
<body>
<a href="hello">点击即可入门springmvc</a></br>
<a href="testParame?username=xiong&pswd=123">请求参数的绑定</a></br>
<h3>表单提交</h3>
<form action="user" method="post">
    <input type="text" name="name"/>
    <input type="text" name="age">
    <input type="text" name="gender">
    <input type="text" name="account">
    <input type="text" name="girlFriend.gname">
    <input type="text" name="girlFriend.gage">
    <input type="text" name="girlFriendList[0].gname">
    <input type="text" name="girlFriendList[0].gage">
    <input type="text" name="girlFriendList[1].gname">
    <input type="text" name="girlFriendList[1].gage">
    <input type="text" name="girlFriendMap['xiao'].gname">
    <input type="text" name="girlFriendMap['xiao'].gage">
    <input type="text" name="girlFriendMap['hong'].gname">
    <input type="text" name="girlFriendMap['hong'].gage">
    <input type="submit" value="提交">
</form>
<hr/>
<%--文件上传--%>
<form action="fileupload1" name="fm" method="post" enctype="multipart/form-data">
    姓名：<input type="text" name="uname" /><br/>
    选择文件：<input type="file" name="file" /><br/>
    <input type="submit" value="上传"/>
</form>


<hr/>
<%--springmvc方式文件上传--%>
<form action="fileupload2" name="fm" method="post" enctype="multipart/form-data">
    姓名：<input type="text" name="uname" /><br/>
    选择文件：<input type="file" name="file" /><br/>
    <input type="submit" value="上传"/>
</form>


<hr>
<a href="testException">异常处理</a>
</body>
</html>