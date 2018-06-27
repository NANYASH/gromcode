package hibernate.lesson2.hw.task1;


public class Demo {

    public static void main(String[] args) {
        Product product = new Product();
        product.setId(7);
        product.setName("TEST1");
        product.setDescription("blue");
        product.setPrice(300);

        //ProductDAO.save(product);
        //ProductDAO.update(product);
        //ProductDAO.delete(product);


        Product product10 = new Product();
        product.setId(7);
        product.setName("TEST2");
        product.setDescription("black color2");
        product.setPrice(300);

        //ProductDAO.save(product10);


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

       // List<Product> products = Arrays.asList(product1, product2, product3);

        //ProductDAO.updateAll(products);
        //ProductDAO.deleteAll(products);
        //ProductDAO.update(product);
        //updateAll(products);
        //ProductDAO.save(product);
        //ProductDAO.saveAll(products);
        //ProductDAO.delete(product);
    }
}
