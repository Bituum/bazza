package com.bituum.spring.mvc.dao;

import com.bituum.spring.mvc.models.Contract;
import com.bituum.spring.mvc.models.Deliver;
import com.bituum.spring.mvc.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractDaoImpl implements ContractDao{
    @Override
    public List<Contract> showAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Contract> query = session.createQuery("from Contract ", Contract.class);
        return query.getResultList();
    }

    @Override
    public Contract showById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Contract.class, id);
    }

    @Override
    public void add(Contract contract) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.save(contract);
        session.close();
    }

    @Override
    public void delete(Contract contract) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(contract);
        tx.commit();

        session.close();
    }

    @Override
    public void update(Contract contract) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(contract);
        tx.commit();
        session.close();
    }
}
