<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.07.2018
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<a href="/">На главную</a>
<h1>Регистрация</h1>
<%
    if(session.getAttribute("user") != null){
        response.sendRedirect("/user");
    }
    if(session.getAttribute("err") != null)
    {
        out.println(session.getAttribute("err"));
        session.removeAttribute("err");
    }
%>
<form action="register" method="post">
    <p>Логин: <input type="text" name="login"></p>
    <p>Email: <input type="text" name="email"></p>
    <p>Пароль: <input type="password" name="password1"></p>
    <p>Повторите Пароль: <input type="password" name="password2"></p>
    <input type="submit">
</form>
</body>
</html>
