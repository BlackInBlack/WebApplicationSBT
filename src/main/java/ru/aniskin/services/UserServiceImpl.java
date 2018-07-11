package ru.aniskin.services;

import org.springframework.stereotype.Service;
import ru.aniskin.dao.UserDao;
import ru.aniskin.dao.UserDaoImpl;
import ru.aniskin.models.User;
import java.lang.*;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao =  new UserDaoImpl();;

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public User findUserById(int id) {
        return this.userDao.findById(id);
    }

    @Override
    @Transactional
    public User findUserByLogin(String login) {
        return this.userDao.findByLogin(login);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        this.userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    @Transactional
    public List<User> findAllUsers() {
        return this.userDao.findAllUser();
    }
}
