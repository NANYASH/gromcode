package core.lesson30;


import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static List<Customer> customers = new ArrayList<>();

    public static Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customers.get(customers.indexOf(customer));
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(List<Customer> customers) {
        CustomerDAO.customers = customers;
    }


}
