package com.bituum.spring.mvc.dao;

import com.bituum.spring.mvc.models.User;
import com.bituum.spring.mvc.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDaoImpl  implements  UserDao{

    @Transactional
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
    public User login(User user){
        String tmpLogin = user.getLogin();
        String tmpPassword = user.getPassword();
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        User check = (User)session.createQuery("from User where login = '"+ tmpLogin +"' AND password = '" + tmpPassword+"'").getSingleResult();

        if((check.getLogin().contains(tmpLogin)) &&(check.getPassword().contains(tmpPassword))){
            return user;
        }else{
            return null;
        }

    }
    
    @Transactional
    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }

    @Transactional
    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();

        session.close();
    }

    @Transactional
    public List<User> showAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("from User", User.class);
        return query.getResultList();
    }
}
