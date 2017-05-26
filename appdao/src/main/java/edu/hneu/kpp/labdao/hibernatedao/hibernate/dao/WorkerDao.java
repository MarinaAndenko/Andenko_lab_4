package edu.hneu.kpp.labdao.hibernatedao.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import edu.hneu.kpp.labdao.hibernatedao.hibernate.model.Worker;

import java.util.ArrayList;
import java.util.List;

public class WorkerDao implements WorkerDaoInterface<Worker, Integer> {

    private Session currentSession;

    private Transaction currentTransaction;

    public WorkerDao() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Worker entity) {
      //  this.getCurrentSession().save(entity);
        Session session = null;
        Transaction tx = null;
        try {
            session = DbContext.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update(Worker entity) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DbContext.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Worker findById(Integer integer) {
        Session session = null;
        Worker report = null;
        try {
            session = DbContext.getSessionFactory().openSession();
            report = (Worker) session.get(Worker.class, integer);
        } catch (HibernateException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return report;
    }

    public void delete(Worker entity) {
        Session session = null;
        Transaction tx = null;
        try {
            session = DbContext.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<Worker> findAll() {
        Session session = null;
        List<Worker> reports = new ArrayList<Worker>();
        try {
            session = DbContext.getSessionFactory().openSession();
            reports = session.createCriteria(Worker.class).list();
        } catch (HibernateException e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return reports;
    }
}
