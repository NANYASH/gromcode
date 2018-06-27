package hibernate.lesson2.hw.task3;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class ProductDAO {

    private static SessionFactory sessionFactory;
    private static final String PRODUCT_BY_ID = "SELECT * FROM PRODUCT WHERE ID = ?";
    private static final String PRODUCT_BY_NAME = "SELECT * FROM PRODUCT WHERE NAME = ?";
    private static final String PRODUCT_BY_CONTAINED_NAME = "SELECT * FROM PRODUCT WHERE NAME LIKE ? ";
    private static final String PRODUCT_BY_PRICE = "SELECT * FROM PRODUCT WHERE PRICE BETWEEN ? AND ?";
    private static final String PRODUCT_SORT_BY_NAME_ASC = "SELECT * FROM PRODUCT ORDER BY NAME ASC";
    private static final String PRODUCT_SORT_BY_NAME_DESC = "SELECT * FROM PRODUCT ORDER BY NAME DESC";
    private static final String PRODUCT_SORTED_BY_PRICE_WITH_DELTA_DESC = "SELECT * FROM PRODUCT WHERE PRICE BETWEEN ? AND ? ORDER BY PRICE DESC";

    public Product findById(int id) throws Exception {
        try( Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(PRODUCT_BY_ID);
            query.addEntity(Product.class);
            query.setParameter(1,id);
            return (Product) query.getSingleResult();
        }catch (HibernateException e){
            System.err.println("No products with such id.");
            System.err.println(e.getMessage());
            throw e;
        }
    }



    public List<Product> findByName(String name){
        try(Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(PRODUCT_BY_NAME);
            query.addEntity(Product.class);
            query.setParameter(1,name);
            return query.getResultList();
        }catch (HibernateException e){
            System.err.println("No products with such name.");
            System.err.println(e.getMessage());
            throw e;
        }
    }
    public List<Product> findByContainedName(String name){
        try( Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(PRODUCT_BY_CONTAINED_NAME);
            query.addEntity(Product.class);
            query.setParameter(1,name+"%");
            return query.getResultList();
        }catch (HibernateException e){
            System.err.println("No products with such string.");
            System.err.println(e.getMessage());
            throw e;
        }
    }
    public List<Product> findByPrice(int price, int delta){
        try( Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(PRODUCT_BY_PRICE);
            query.addEntity(Product.class);
            query.setParameter(1,price-delta);
            query.setParameter(2,price+delta);
            return query.getResultList();
        }catch (HibernateException e){
            System.err.println(e.getMessage());
            throw e;
        }
    }
    public List<Product> findByNameSortedAsc(){
        try( Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(PRODUCT_SORT_BY_NAME_ASC);
            query.addEntity(Product.class);
            return query.getResultList();
        }catch (HibernateException e){
            System.err.println(e.getMessage());
            throw e;
        }

    }
    public List<Product> findByNameSortedDesc(String name){
        try( Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(PRODUCT_SORT_BY_NAME_DESC);
            query.addEntity(Product.class);
            return query.getResultList();
        }catch (HibernateException e){
            System.err.println(e.getMessage());
            throw e;
        }
    }
    public List<Product> findByPriceSortedDesc(int price, int delta) {
        try( Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(PRODUCT_SORTED_BY_PRICE_WITH_DELTA_DESC);
            query.addEntity(Product.class);
            query.setParameter(1,price-delta);
            query.setParameter(2,price+delta);
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
