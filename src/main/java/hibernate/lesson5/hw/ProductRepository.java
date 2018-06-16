package hibernate.lesson5.hw;


import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.PersistenceException;
import java.sql.SQLIntegrityConstraintViolationException;


public class ProductRepository {
    void save(Product product){
        try(Session session = new HibernateUtils().createSessionFactory().openSession()){
            session.getTransaction().begin();
            session.save(product);
            session.getTransaction().commit();
        }catch (PersistenceException e){
            System.err.print("Entry with id: "+product.getId()+" cannot be save");
        }
    }

    void update(Product product){
        try(Session session = new HibernateUtils().createSessionFactory().openSession()){
            session.getTransaction().begin();
            session.update(product);
            session.getTransaction().commit();
        }catch (StaleObjectStateException e){
            System.err.print("Entry with id: "+product.getId()+" cannot be found");
        }
    }

    void detele(long id){
        try (Session session = new HibernateUtils().createSessionFactory().openSession()){
            session.getTransaction().begin();
            session.delete(session.get(Product.class, id));
            session.getTransaction().commit();
        }catch (IllegalArgumentException e){
            System.err.print("Entry with id: "+id+" cannot be found");
        }
    }

}
