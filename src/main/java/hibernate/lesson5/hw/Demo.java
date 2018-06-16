package hibernate.lesson5.hw;


import hibernate.lesson5.lecture.HibernateUtils;
import org.hibernate.Session;

public class Demo {

    public static void main(String[] args) {
        Product product = new Product();
        product.setId(156);
        product.setName("test");
        product.setDescription("pink");
        ProductRepository productRepository = new ProductRepository();
        //productRepository.save(product);
        productRepository.update(product);
        //productRepository.detele(product.getId());



    }
}
