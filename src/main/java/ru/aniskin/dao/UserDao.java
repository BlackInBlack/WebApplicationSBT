package ru.aniskin.dao;

import ru.aniskin.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public interface UserDao {
    User findById(int id) throws Exception;
    void save(User user);
    void update(User user);
    void delete(User user);
    List<User> findAll();
}
