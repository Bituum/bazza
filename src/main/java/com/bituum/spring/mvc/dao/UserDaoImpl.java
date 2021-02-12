package com.bituum.spring.mvc.dao;

import com.bituum.spring.mvc.models.User;
import com.bituum.spring.mvc.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDaoImpl  implements  UserDao{
    
    public User showById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }
    @Transactional
    public void add(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(user);
        session.close();
    }
    
    @Transactional
    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.update(user);
        session.close();
    }

    @Transactional
    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.delete(user);
        session.close();
    }

    @Override
    public void delete(User user, int id) {

    }

    @Override
    public void update(User user, int id) {

    }
    public List<User> showAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }
}
