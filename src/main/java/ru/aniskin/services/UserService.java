package ru.aniskin.services;
import org.hibernate.SessionFactory;
import ru.*;
import ru.aniskin.dao.UserDaoImpl;
import ru.aniskin.models.User;

import java.util.List;
public interface UserService {

    public User findUserById(int id) throws Exception;

    public User findUserByLogin(String login) throws Exception;

    public void saveUser(User user);

    public void deleteUser(int id);

    public void updateUser(User user);

    public List<User> findAllUsers();
}
