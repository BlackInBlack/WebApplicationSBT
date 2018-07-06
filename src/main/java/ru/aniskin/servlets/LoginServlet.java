package ru.aniskin.servlets;
import ru.aniskin.service.LoginService;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); //Задаем заголовок ответа
        PrintWriter out = response.getWriter();
        out.println("<form action=\"login\" method=\"post\">\n" +
                "    <p>Логин: <input type=\"text\" name=\"login\"></p>\n" +
                "    <p>Пароль: <input type=\"password\" name=\"password\"></p>\n" +
                "    <input type='submit'>Войти</input>\n" +
                "</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login,password;

        login = req.getParameter("login");
        password = req.getParameter("password");

        LoginService loginService = new LoginService();
        boolean result = loginService.authenticate(login,password);

        if (result) {
            resp.sendRedirect("success");
            return;
        }
        else {
            resp.sendRedirect("login");
        }

    }
}