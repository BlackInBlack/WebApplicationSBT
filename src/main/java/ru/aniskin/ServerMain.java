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
            userService.saveUser(user);
            userService.updateUser(user);

        }
        catch (HibernateError e) {
            System.out.println(e.fillInStackTrace());
        }

    }
}
