package jdbc.lesson3.lecture;


import jdbc.lesson3.hw.task1and2.Solution;
import jdbc.lesson4.lecture.Product;

public class Demo {
    public static void main(String[] args) throws Exception {
        ProductDAO productDAO = new ProductDAO();
        Solution solution = new Solution();

        Product product = new Product(10, "toy", "for children", 90);
        Product product1 = new Product(11, "toy2", "for children", 100);
        Product product2 = new Product(12, "toy3", "for children", 110);
        Product product3 = new Product(13, "toy4", "for children", 120);
        Product product4 = new Product(14, "toy4", "", 120);
        //productDAO.save(product4);
        //System.out.println(productDAO.getProducts());
        //productDAO.delete(11);
        //System.out.println(productDAO.update(product4));
        //System.out.println(solution.findProductsByPrice(100,10));
        //System.out.println(solution.findProdutWithEmptyDescription());
        //System.out.println(solution.findProductsByName("to"));
        solution.createTable();
    }
}
