package core.lesson10;


import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Customer customer = new Customer("Настя", "Киев", "Женский");
        Order order1 = new ElectronicsOrder("iPhone7", new Date(), "Одесса", "Киев",
                500, customer, 12);
        Order order2 = new ElectronicsOrder("Pixel2", new Date(), "Харьков", "Киев",
                300, customer, 12);

        Order order3 = new FurnitureOrder("Sofa", new Date(), "Одесса", "Киев",
                300, customer, "12345");
        Order order4 = new FurnitureOrder("Table", new Date(), "Львов", "Киев",
                300, customer, "54321");

        order1.validateOrder();
        order1.calculatePrice();
        order1.confirmShipping();

        order2.validateOrder();
        order2.calculatePrice();
        order2.confirmShipping();

        order3.validateOrder();
        order3.calculatePrice();
        order3.confirmShipping();

        order4.validateOrder();
        order4.calculatePrice();
        order4.confirmShipping();


    }
}
