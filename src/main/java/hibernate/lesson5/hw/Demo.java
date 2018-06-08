package hibernate.lesson5.hw;


import org.hibernate.Session;

public class Demo {
    public static void save(Product product){
        Session session = new HibernateUtils().createSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(product);
        session.getTransaction().commit();
        session.close();

    }
    public static void main(String[] args) {
        Product product = new Product();
        product.setId(15);
        product.setName("test");
        product.setDescription("grey & blue");
        product.setPrice(100);
        Demo.save(product);



    }
}
