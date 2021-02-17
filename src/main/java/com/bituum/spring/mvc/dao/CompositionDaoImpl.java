package com.bituum.spring.mvc.dao;

import com.bituum.spring.mvc.models.Composition;
import com.bituum.spring.mvc.models.Deliver;
import com.bituum.spring.mvc.models.Flower;
import com.bituum.spring.mvc.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.hibernate.Transaction;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CompositionDaoImpl implements CompositionDao{
    @Override
    @Transactional
    public List<Composition> showAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return session.createQuery("from Composition ", Composition.class).list();

    }
    @Transactional
    @Override
    public Composition showById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Composition.class, id);
    }

    @Transactional
    @Override
    public void add(Composition composition) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.saveOrUpdate(composition);
    }

    @Override
    @Transactional
    public void delete(Composition composition) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(composition);
        tx.commit();

        session.close();
    }

    @Override
    @Transactional
    public void update(Composition composition) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(composition);
        tx.commit();
    }
}
