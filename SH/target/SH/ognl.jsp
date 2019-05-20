<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<%--
  Created by IntelliJ IDEA.
  User: knightx
  Date: 2019/1/10
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>ognl的用法</title>
</head>
<body>
<%--ognl需要和Struts2标签库一起使用
<s:property标签的作用是把value的值输出到浏览器上，
而value里装的是ognl表达式
如果value你不想装ognl表达式，就想装字符串，这个时候你要用"''"引起来--%>

ognl的最基本用法，无输出<s:property value="ognlexpress"/></br>
ognl转成字符串<s:property value="'ognlexpress'"/><br>
字符串转成ognl<s:textfield value="%{ognlexpress}"/><br>
ognl可以访问类的静态成员,规则是：@包名.类名@静态属性名<s:property value="%{@java.lang.Integer@MAX_VALUE}"/><br>
ognl可以访问类的静态方法,规则跟访问静态成员一样：@包名.类名@静态属性名<s:property value="%{@java.lang.Math@random()}"/>
<br>
html的单选按钮：<input type="radio" name="gender1" value="男"/>男
<input type="radio" name="gender1" value="女"/>女<br>

ognl可以操作list集合,{}表示一个集合：例<br>
ognl的单选按钮：<s:radio list="%{{'男','女'}}" name="gender2"/><br>

<br>
<%--ognl可以操作map,#{}表示一个map，虽然idea这里map会报错，但是能用--%>
ognl的map案例按钮：<s:radio list="%{#{'男':'male','女':'female'}}" name="gender3"/><br>

<%-- el表达式中有11大隐式对象可以直接使用
ognl表达式有如下但不局限于如下对象可以使用，这些对象统称为contextMap：
1.application：
2.session：
3.value stack：是一个list对象，
4.action：当前正在运行的action对象
5.request：
6：parameters：拿到的是request.getParameterMap()里的数据（全部的request域中的数据封装到map中）
7：attr：相当于el中的四大scope对象（pageScope，requestScope，sessionScope,applicationScope）
可以使用contextMap.get("request")直接得到request对象，但是这样的到的是request对象里的所有的值，
而request里的值是一些map，处理map很麻烦
所以我们让一个工具类帮我们去操作contextMap，这个工具类是ActionContext。ActionContext这个类放在核心过滤器中，
当一发起请求时，ActionContext对象就被创建，而此对象被绑定到了当前线程中，所以，可以直接ActionContext的方法getcontext
得到actioncontext对象（struts2自己定义的一个域对象），ActionContext对象也是一个域对象，也可以往里存数据，也可以通过此对象获得上面的七个对象。--%>

<hr  color="red"/>
<%--通过ognl表达式取域中的数据。#后面跟的是域名，ognl跟el一样直接用“·”键名拿到值--%>
<s:property value="%{#context1}"/><%--这个比较特殊，因为标准中没有这个域，所以直接用key就可以把值取出来，其他的必须用域对象来取--%>
<s:property value="%{#request.requestattr}"/>
<s:property value="%{#session.session1}"/>
el表达式<c:out value="${context1}"/>
<%--通过ognl表达式取valuestack的值,因为valuestack是栈结构，取出来的值永远是第一个，所以，
不用通过对象名.属性名来拿到值，直接用属性名就可以拿到值了。ognl跟s标签是配套的，el不能在s中使用，el跟c也是配套的，同样的，ognl也不能在c中使用，
但是，jsp永远只能指向后台的同一份数据，所以，ognl能取到的东西，el也能通过同样的方式得到--%>
<s:property value="%{custName}"/>
<s:property value="[0].custName"/>
<c:out value="${custName}"/>
<s:property /><%--默认的如果不写value，得到的是栈顶对象--%>
<s:property /><%--默认的如果不写value，且没有往值栈中压入对象，得到的是当前action对象--%>
${requestScope.requestattr}

<%System.out.println("我是jsp页面");%>
<s:debug/>
</body>
</html>