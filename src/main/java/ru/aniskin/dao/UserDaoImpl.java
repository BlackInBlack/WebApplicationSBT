package ru.aniskin.dao;

import ru.aniskin.dao.UserDao;
import ru.aniskin.models.User;
import utils.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User findById(int id) throws Exception {
            return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);

    }

    @Override
    public void save(User user) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(user);
            tx1.commit();
            session.close();
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

    }

    @Override
    public void update(User user) {
        Session session = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    @Override
    public List<User> findAll() {
        List<User> users = null;
        try {
            users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
