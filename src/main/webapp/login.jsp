<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.07.2018
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Вход</h1>
<a href="/">На главную</a>
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
<form action="login" method="post">
    <p>Логин: <input type="text" name="login"></p>
    <p>Пароль: <input type="password" name="password"></p>
    <input type="submit">
</form>
</body>
</html>
