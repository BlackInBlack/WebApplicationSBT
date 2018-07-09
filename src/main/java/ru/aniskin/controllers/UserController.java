package ru.aniskin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.aniskin.services.UserService;

@Controller
public class UserController {
    private UserService userService;

//    @Autowired(required = true)
//    @Qualifier(value = "userService")
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @RequestMapping(value = "users",method = RequestMethod.GET);
//    public String listBook(Model model) {
//
//    }


}
