package ru.aniskin.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.aniskin.dao.UserDao;
import ru.aniskin.models.User;
import utils.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findById(int id) throws Exception {
            return HibernateSessionFactoryUtil.getSessionFactory(User.class).openSession().get(User.class, id);

    }

    @Override
    public void save(User user) {
        try {
            SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory(User.class);
            Session session = sessionFactory.openSession();
            session.save(user);


            sessionFactory.close();
//            Transaction tx1 = session.beginTransaction();
//            session.save(user);
//            tx1.commit();
//            session.close();
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

    }

    @Override
    public void update(User user) {
        Session session = null;
        session = this.sessionFactory.getCurrentSession();
        session.update(user);
//        try {
//            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Transaction tx1 = session.beginTransaction();
//        session.update(user);
//        tx1.commit();
//        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory(User.class).openSession();
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
            users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory(User.class).openSession().createQuery("From User").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
