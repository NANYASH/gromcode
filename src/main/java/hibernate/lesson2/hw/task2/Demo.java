package hibernate.lesson2.hw.task2;


public class Demo {

    public static void main(String[] args) throws Exception {
        ProductDAO productDAO = new ProductDAO();
        //System.out.println(productDAO.findById(15));
        //System.out.println(productDAO.findByName("test"));
        //System.out.println(productDAO.findByContainedName("test"));
        //System.out.println(productDAO.findByPrice(200,100));
        //System.out.println(productDAO.findByNameSortedAsc());
        System.out.println(productDAO.findByPriceSortedDesc(200,100));
    }
}
