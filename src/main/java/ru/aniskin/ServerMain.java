package ru.aniskin;

import org.hibernate.HibernateError;
import ru.aniskin.dao.UserDao;
import ru.aniskin.dao.UserDaoImpl;
import ru.aniskin.models.User;
import ru.aniskin.services.UserService;
import ru.aniskin.services.UserServiceImpl;

public class ServerMain {
    public static void main(String[] args) throws HibernateError {
        System.out.println("Hello");
        try {
            UserService userService = new UserServiceImpl();
            User user = new User("Aniskin","123","aniskin@mail.ru");
            User user1 = new User("Dema","123123","dema@mail.ru");
            User user2 = new User("Max","123654","maxmax@mail.ru");
            User user3 = new User("Dr Ya","222","111222@mail.ru");
            userService.saveUser(user);
            userService.saveUser(user1);
            userService.saveUser(user2);
            userService.saveUser(user3);
            userService.updateUser(user);
            userService.updateUser(user1);
            userService.updateUser(user2);
            userService.updateUser(user3);
            //userService.findAllUsers();
        }
        catch (HibernateError e) {
            System.out.println(e.fillInStackTrace());
        }

    }
}
