package hibernate.lesson2;


import java.util.Arrays;
import java.util.List;

import static hibernate.lesson2.ProductDAO.save;
import static hibernate.lesson2.ProductDAO.saveProducts;

public class Demo {

    public static void main(String[] args) {
        Product product = new Product();
        product.setName("Plate");
        product.setDescription("red color");
        product.setPrice(100);

        save(product);

        Product product1 = new Product();
        product1.setName("table new111!");
        product1.setDescription("grey & blue");
        product1.setPrice(70);

        Product product2 = new Product();
        product2.setName("table new222!");
        product2.setDescription("grey & blue");
        product2.setPrice(80);

        Product product3 = new Product();
        product3.setName("table new333!");
        product3.setDescription("grey & blue");
        product3.setPrice(90);

        List<Product> products = Arrays.asList(product1, product2, product3);

        saveProducts(products);
    }
}
