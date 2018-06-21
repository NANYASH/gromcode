package hibernate.lesson1.hw;


public class Demo {

    public static void main(String[] args) {
        Product product = new Product();
        product.setId(15);
        product.setName("test");
        product.setDescription("pink");
        ProductRepository productRepository = new ProductRepository();
        productRepository.save(product);
        //productRepository.update(product);
        //productRepository.detele(product.getId());



    }
}
