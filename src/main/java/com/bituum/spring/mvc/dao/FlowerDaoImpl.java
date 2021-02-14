package com.bituum.spring.mvc.dao;

import com.bituum.spring.mvc.models.Flower;
import com.bituum.spring.mvc.models.User;
import com.bituum.spring.mvc.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class FlowerDaoImpl implements FlowerDao{

    @Transactional
    public Flower showById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Flower.class, id);
    }
    @Transactional
    public void add(Flower flower) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(flower);
        session.close();
    }

    @Transactional
    public void update(Flower flower) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(flower);
        tx.commit();
        session.close();
    }

    @Transactional
    public void delete(Flower flower) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(flower);
        tx.commit();

        session.close();
    }

    @Transactional
    public List<Flower> showAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Flower> query = session.createQuery("from Flower", Flower.class);
        return query.getResultList();
    }
}
