<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.07.2018
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<body>
<a href="/">На главную</a>
<%
    //allow access only if session exists
    String user = null;
    if(session.getAttribute("user") == null){
        response.sendRedirect("/login");
    }else user = (String) session.getAttribute("user");
    String userName = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")) userName = cookie.getValue();
            if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
    }
%>
<h3>Hi <%=userName %>, C возвращением. Your Session ID=<%=sessionID %></h3>
<br>
User=<%=user %>
<form action="logout" method="post">
    <input type="submit" value="Logout" >
</form>
<br>
<h3>Login Successful!</h3>
</body>
</html>
