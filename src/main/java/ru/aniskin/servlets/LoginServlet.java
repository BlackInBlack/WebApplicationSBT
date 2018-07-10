package ru.aniskin.servlets;
import ru.aniskin.models.User;
import ru.aniskin.services.LoginService;
import ru.aniskin.services.LoginServiceImpl;
import ru.aniskin.services.UserService;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
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

        LoginService loginService = new LoginServiceImpl();
        boolean result = loginService.authenticate(login,password);

        if (result) {
            resp.sendRedirect("success");

//            UserService userService = new UserService();
//            User user = new User(login,password,"aniskin@mail.ru");
//            userService.saveUser(user);
//            userService.updateUser(user);

            return;
        }
        else {
            resp.sendRedirect("login");
        }

    }
}