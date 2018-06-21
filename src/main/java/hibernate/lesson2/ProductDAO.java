package hibernate.lesson2;


import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ProductDAO {

    private static SessionFactory sessionFactory;

    public static void save(Product product){
        //create session/tr
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.save(product);

            //close session/tr
            tr.commit();
        }catch (HibernateException e){
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        }finally {
            if (session != null){
                session.close();
            }
        }
        System.out.println("Save is done");
    }

    public static void saveProducts(List<Product> products){
        //create session/tr
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            for (Product product : products){
                session.save(product);
            }

            //close session/tr
            tr.commit();
        }catch (HibernateException e){
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        }finally {
            if (session != null){
                session.close();
            }
        }
        System.out.println("Save is done");
    }


    public static SessionFactory createSessionFactory(){
        //singleton pattern
        if (sessionFactory == null){
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
