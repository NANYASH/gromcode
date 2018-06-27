package hibernate.lesson2.hw.task2;


import org.hibernate.HibernateException;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDAO {

    private static SessionFactory sessionFactory;
    private static final String PRODUCT_BY_ID = "FROM Product WHERE ID = :idParam";
    private static final String PRODUCT_BY_NAME = "FROM Product WHERE NAME = :nameParam";
    private static final String PRODUCT_BY_CONTAINED_NAME = "FROM Product WHERE name lIKE :nameParam ";
    private static final String PRODUCT_BY_PRICE = "FROM Product WHERE PRICE BETWEEN (:priceParam - :deltaParam) AND (:priceParam + :deltaParam)";
    private static final String PRODUCT_SORT_BY_NAME_ASC = "FROM Product ORDER BY NAME ASC";
    private static final String PRODUCT_SORT_BY_NAME_DESC = "FROM Product ORDER BY NAME DESC";
    private static final String PRODUCT_SORTED_BY_PRICE_WITH_DELTA_DESC = "FROM Product WHERE PRICE BETWEEN (:priceParam - :deltaParam) AND (:priceParam + :deltaParam) ORDER BY PRICE DESC";

    public Product findById(int id) throws Exception {
        try( Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery(PRODUCT_BY_ID);
            query.setParameter("idParam", id);
            return (Product) query.getSingleResult();
        }catch (HibernateException e){
            System.err.println("No products with such id.");
            System.err.println(e.getMessage());
            throw e;
        }
    }
    public List<Product> findByName(String name){
        try( Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery(PRODUCT_BY_NAME);
            query.setParameter("nameParam", name);
            return query.getResultList();
        }catch (HibernateException e){
            System.err.println("No products with such name.");
            System.err.println(e.getMessage());
            throw e;
        }
    }
    public List<Product> findByContainedName(String name){
        try( Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery(PRODUCT_BY_CONTAINED_NAME);
            query.setParameter("nameParam", name+"%");
            return query.getResultList();
        }catch (HibernateException e){
            System.err.println("No products with such string.");
            System.err.println(e.getMessage());
            throw e;
        }
    }
    public List<Product> findByPrice(int price, int delta){
        try( Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery(PRODUCT_BY_PRICE);
            query.setParameter("priceParam",price);
            query.setParameter("deltaParam",delta);
            return query.getResultList();
        }catch (HibernateException e){
            System.err.println(e.getMessage());
            throw e;
        }
    }
    public List<Product> findByNameSortedAsc(){
        try( Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery(PRODUCT_SORT_BY_NAME_ASC);
            return query.getResultList();
        }catch (HibernateException e){
            System.err.println(e.getMessage());
            throw e;
        }

    }
    public List<Product> findByNameSortedDesc(String name){
        try( Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery(PRODUCT_SORT_BY_NAME_DESC);
            return query.getResultList();
        }catch (HibernateException e){
            System.err.println(e.getMessage());
            throw e;
        }
    }
    public List<Product> findByPriceSortedDesc(int price,int delta) {
        try( Session session = createSessionFactory().openSession()) {
            Query query = session.createQuery(PRODUCT_SORTED_BY_PRICE_WITH_DELTA_DESC);
            query.setParameter("priceParam",price);
            query.setParameter("deltaParam",delta);
            return query.getResultList();
        }catch (HibernateException e){
            System.err.println(e.getMessage());
            throw e;
        }
    }
    public static SessionFactory createSessionFactory(){
        return new Configuration().configure().buildSessionFactory();
    }
}
