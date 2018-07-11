package ru.aniskin.servlets;

import ru.aniskin.services.AccountService;
import ru.aniskin.services.AccountServiceImpl;
import ru.aniskin.services.UserService;
import ru.aniskin.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login,password1,password2,email;
        login = req.getParameter("login");
        email = req.getParameter("email");
        password1 = req.getParameter("password1");
        password2 = req.getParameter("password2");
        AccountService accountService= new AccountServiceImpl();

        switch (accountService.testData(login,password1,password2,email)) {
            case 1:
                HttpSession session = req.getSession();
                session.setAttribute("user", login);
                session.setMaxInactiveInterval(30*60);
                Cookie userName = new Cookie("user", login);
                userName.setMaxAge(30*60);
                resp.addCookie(userName);
                resp.sendRedirect("/newuser");
                break;
            case 0:
                session = req.getSession(false);
                session.setAttribute("err", "Неправильно введённые данные для регистрации!");
                resp.sendRedirect("/register");
                break;
            case -1:
                session = req.getSession(false);
                session.setAttribute("err", "Такой пользователь уже существует!!");
                resp.sendRedirect("/register");
                break;
        }
    }
}
