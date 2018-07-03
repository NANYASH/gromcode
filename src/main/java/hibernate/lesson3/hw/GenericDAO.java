package hibernate.lesson3.hw;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GenericDAO<T> {
    private static SessionFactory sessionFactory;

    public T save(T t){
        Transaction tr = null;
        try(Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.save(t);
            tr.commit();
        }catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        }
        System.out.println("Save is done");
        return t;

    }

    public T update(T t){
        Transaction tr = null;
        try (Session session = createSessionFactory().openSession()){
            tr = session.getTransaction();
            tr.begin();
            session.update(t);
            tr.commit();
        }catch (HibernateException e) {
            System.err.println("Update is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        }
        System.out.println("Update is done");
        return t;
    }

    public T delete(T t){
        Transaction tr = null;
        try(Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.delete(t);
            tr.commit();
        }catch (HibernateException e) {
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        }
        System.out.println("Delete is done");
        return t;
    }

    public static SessionFactory createSessionFactory(){
        if (sessionFactory == null) {
            return new Configuration().configure().buildSessionFactory();}
        return sessionFactory;
    }

}
