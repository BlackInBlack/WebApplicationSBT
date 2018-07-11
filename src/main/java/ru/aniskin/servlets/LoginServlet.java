package ru.aniskin.servlets;
import ru.aniskin.models.User;
import ru.aniskin.services.AccountService;
import ru.aniskin.services.AccountServiceImpl;
import ru.aniskin.services.AccountService;
import ru.aniskin.services.AccountServiceImpl;
import ru.aniskin.services.UserService;
import ru.aniskin.services.UserServiceImpl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.lang.*;
@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login,password;

        login = req.getParameter("login");
        password = req.getParameter("password");

        AccountService loginService = new AccountServiceImpl();
        boolean result = loginService.authenticate(login,password);

        if (result) {
            UserService userService = new UserServiceImpl();
            User user = null;
            try {
                user = userService.findUserByLogin(login);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(user != null && login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                System.out.println("Все ок");
                HttpSession session = req.getSession();
                session.setAttribute("user", login);
                session.setMaxInactiveInterval(30*60);
                Cookie userName = new Cookie("user", login);
                userName.setMaxAge(30*60);
                resp.addCookie(userName);
                resp.sendRedirect("/user");
            }
            else {
                HttpSession session = req.getSession(false);
                session.setAttribute("err", "Неверный логин или пароль!");
                resp.sendRedirect("/login");

            }
        }
        else {
            resp.sendRedirect("/login");
        }

    }
}