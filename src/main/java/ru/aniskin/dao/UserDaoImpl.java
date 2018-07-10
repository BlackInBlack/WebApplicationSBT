package ru.aniskin.dao;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.aniskin.dao.UserDao;
import ru.aniskin.models.User;
import utils.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;
import java.util.logging.Logger;


@Repository
public class UserDaoImpl implements UserDao {
    //private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl);
    private SessionFactory sessionFactory;
    private final org.jboss.logging.Logger logger = LoggerFactory.logger(UserDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findById(int id) throws Exception {
//        return HibernateSessionFactoryUtil.getSessionFactory(User.class).openSession().get(User.class, id);
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User success load. User details" + user);
        return user;
    }

    @Override
    public void addUser(User user) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(user);
//            SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory(User.class);
//            Session session = sessionFactory.openSession();
//            session.persist(user);
//            sessionFactory.close();
//            Transaction tx1 = session.beginTransaction();
//            session.save(user);
//            tx1.commit();
//            session.close();
            logger.info("User success add.");
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            logger.info("User add error." + e.fillInStackTrace().getMessage());
        }

    }

    @Override
    public void updateUser(User user) {
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
        logger.info("User success update.");
    }

    @Override
    public void deleteUser(int id) {
//        Session session = null;
//        try {
//            session = HibernateSessionFactoryUtil.getSessionFactory(User.class).openSession();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Transaction tx1 = session.beginTransaction();
//        session.delete(user);
//        tx1.commit();
//        session.close();
       Session session = this.sessionFactory.getCurrentSession();
       User user = (User) session.load(User.class, new Integer(id));

       if(user != null) {
           session.delete(user);
           logger.info("User success delete. User details: " + user);
       }
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<User> findAllUser() {
//        List<User> users = null;
//        try {
//            users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory(User.class).openSession().createQuery("From User").list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return users;
        Session session = this.sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from Users").list();
        for(User user:users) {
            logger.info("User success delete. User details: " + user);
        }
        return users;
    }
}
