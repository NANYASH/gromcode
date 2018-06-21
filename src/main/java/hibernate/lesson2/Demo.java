package hibernate.lesson2;


import java.util.Arrays;
import java.util.List;

import static hibernate.lesson2.ProductDAO.*;

public class Demo {

    public static void main(String[] args) {
        Product product = new Product();
        product.setId(11);
        product.setName("NEW TEST");
        product.setDescription("black color");
        product.setPrice(200);

        //save(product);

        Product product1 = new Product();
        product.setId(12);
        product1.setName("test11");
        product1.setDescription("grey & blue");
        product1.setPrice(100);

        Product product2 = new Product();
        product.setId(13);
        product2.setName("test22");
        product2.setDescription("grey & blue");
        product2.setPrice(200);

        Product product3 = new Product();
        product.setId(14);
        product3.setName("test33");
        product3.setDescription("grey & blue");
        product3.setPrice(300);

        List<Product> products = Arrays.asList(product1, product2, product3);

        updateAll(products);
        //update(product);
        //updateAll(products);
        //save(product);
        //saveAll(products);
    }
}
