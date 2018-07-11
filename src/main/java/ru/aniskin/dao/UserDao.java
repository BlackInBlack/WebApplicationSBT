package ru.aniskin.dao;

import com.sun.org.apache.xpath.internal.operations.String;
import org.hibernate.service.spi.ServiceException;
import ru.aniskin.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import java.util.List;

public interface UserDao {
    User findById(int id) throws Exception;
    User findByLogin(java.lang.String login) throws ServiceException;
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    List<User> findAllUser();

}
