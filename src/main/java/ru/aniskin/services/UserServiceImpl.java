package ru.aniskin.services;

import org.springframework.stereotype.Service;
import ru.aniskin.dao.UserDao;
import ru.aniskin.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public User findUser(int id) throws Exception {
        return this.userDao.findById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        this.userDao.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        this.userDao.delete(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDao.update(user);
    }

    @Override
    @Transactional
    public List<User> findAllUsers() {
        return this.userDao.findAll();
    }
}
