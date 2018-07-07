package hibernate.lesson4.dao;



import hibernate.lesson4.exceptions.BadRequestException;
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

    public void delete(Class<T> c,long id) throws BadRequestException {
        Transaction tr = null;
        try(Session session = createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.delete(findById(c,id));
            tr.commit();
        }catch (HibernateException e) {
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        }
        System.out.println("Delete is done");
    }

    public T findById(Class<T> c,long id) throws BadRequestException {
        try(Session session = createSessionFactory().openSession()) {
            return c.cast(session.get(c, id));
        }catch (HibernateException e) {
            System.err.println(c.getName()+" with such id \"" + id + "\" does not exist.");
            System.err.println(e.getMessage());
        }
        throw new BadRequestException("Unexpected exception");
    }


    public static SessionFactory createSessionFactory(){
        if (sessionFactory == null) {
            return new Configuration().configure().buildSessionFactory();}
        return sessionFactory;
    }



}
