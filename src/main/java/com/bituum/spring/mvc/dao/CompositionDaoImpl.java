package com.bituum.spring.mvc.dao;

import com.bituum.spring.mvc.models.Composition;
import com.bituum.spring.mvc.models.Deliver;
import com.bituum.spring.mvc.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompositionDaoImpl implements CompositionDao{
    @Override
    public List<Composition> showAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Composition> query = session.createQuery("from Composition ", Composition.class);
        return query.getResultList();
    }

    @Override
    public Composition showById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Composition.class, id);
    }

    @Override
    public void add(Composition composition) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(composition);
        session.close();
    }

    @Override
    public void delete(Composition composition) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(composition);
        tx.commit();

        session.close();
    }

    @Override
    public void update(Composition composition) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(composition);
        tx.commit();
        session.close();
    }
}
