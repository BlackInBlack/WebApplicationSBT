package ru.aniskin;

import ru.aniskin.models.User;
import ru.aniskin.services.UserService;

public class ServerMain {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello");
        try {
            UserService userService = new UserService();
            User user = new User("Aniskin","123","aniskin@mail.ru");
            userService.saveUser(user);
            userService.updateUser(user);
        }
        catch (Exception e)
        {
            System.out.println(e.fillInStackTrace());
        }

    }
}
