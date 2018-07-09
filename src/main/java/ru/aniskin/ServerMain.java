package ru.aniskin;

import ru.aniskin.models.User;
import ru.aniskin.services.UserService;
import ru.aniskin.services.UserServiceImpl;

public class ServerMain {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello");
        try {
            UserServiceImpl userServiceImpl = new UserServiceImpl();
            User user = new User("Aniskin","123","aniskin@mail.ru");
            userServiceImpl.saveUser(user);
            userServiceImpl.updateUser(user);
        }
        catch (Exception e)
        {
            System.out.println(e.fillInStackTrace());
        }

    }
}
