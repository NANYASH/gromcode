package hibernate.lesson5.hw;


import org.hibernate.Session;


public class ProductRepository {
    void save(Product product){
        try(Session session = new HibernateUtils().createSessionFactory().openSession()){
            session.getTransaction().begin();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    void update(Product product){
        try(Session session = new HibernateUtils().createSessionFactory().openSession()){
            session.getTransaction().begin();
            session.update(product);
            session.getTransaction().commit();
        }
    }

    void detele(long id){
        try (Session session = new HibernateUtils().createSessionFactory().openSession()){
            session.getTransaction().begin();
            session.delete(session.get(Product.class, id));
            session.getTransaction().commit();
        }catch (IllegalArgumentException e){
            System.err.print("Delete cannot be performed");
        }
    }

}
