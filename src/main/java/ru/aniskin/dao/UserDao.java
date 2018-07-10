package ru.aniskin.dao;

import ru.aniskin.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import java.util.List;

public interface UserDao {
    User findById(int id) throws Exception;
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    List<User> findAllUser();
}
