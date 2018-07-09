package ru.aniskin.services;
import ru.*;
import ru.aniskin.dao.UserDaoImpl;
import ru.aniskin.models.User;

import java.util.List;
public class UserService {
    private UserDaoImpl usersDaoImpl = new UserDaoImpl();

    public UserService() {

    }

    public User findUser(int id) throws Exception {
        return usersDaoImpl.findById(id);
    }

    public void saveUser(User user) {
        usersDaoImpl.save(user);
    }

    public void deleteUser(User user) {
        usersDaoImpl.delete(user);
    }

    public void updateUser(User user) {
        usersDaoImpl.update(user);
    }

    public List<User> findAllUsers() {
        return usersDaoImpl.findAll();
    }

}
