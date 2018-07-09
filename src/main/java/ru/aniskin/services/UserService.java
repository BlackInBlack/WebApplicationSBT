package ru.aniskin.services;
import org.hibernate.SessionFactory;
import ru.*;
import ru.aniskin.dao.UserDaoImpl;
import ru.aniskin.models.User;

import java.util.List;
public interface UserService {

    public User findUser(int id) throws Exception;

    public void saveUser(User user);

    public void deleteUser(User user);

    public void updateUser(User user);

    public List<User> findAllUsers();
}
