package ru.aniskin.dao;

import com.sun.org.apache.xpath.internal.operations.String;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.query.Query;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Repository;
import ru.aniskin.dao.UserDao;
import ru.aniskin.models.User;
import utils.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import java.util.List;
import java.util.logging.Logger;
import java.lang.*;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;
    private final org.jboss.logging.Logger logger = LoggerFactory.logger(UserDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findById(int id) throws ServiceException {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User success load. User details" + user);
        return user;
    }

    @Override
    public User findByLogin(java.lang.String login) throws ServiceException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //User user = (User) session.createQuery("from User where login=:login").setParameter("login",login);
        Query query = session.createQuery("from User where login = :paramName");
        query.setParameter("paramName", login);
        List list = query.list();
        User user =(User) list.get(0);
        logger.info("User success load. User details" + user);
        return user;
    }

    @Override
    public void addUser(User user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(user);
            tx1.commit();
            session.close();
            logger.info("User success add.");
        }
        catch (ServiceException e) {
            System.out.println(e.fillInStackTrace());
            logger.info("User add error." + e.fillInStackTrace().getMessage());
        }

    }

    @Override
    public void updateUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
        logger.info("User success update.");
    }

    @Override
    public void deleteUser(int id) {
       Session session = this.sessionFactory.getCurrentSession();
       User user = (User) session.load(User.class, new Integer(id));

       if(user != null) {
           session.delete(user);
           logger.info("User success delete. User details: " + user);
       }
    }

    @Override
    public List<User> findAllUser() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<User> users = session.createQuery("from Users").list();
        tx1.commit();
        session.close();
        for(User user:users) {
            logger.info("User success delete. User details: " + user);
        }
        return users;
    }
}
