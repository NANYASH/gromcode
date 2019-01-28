package jdbc.lesson4.lecture;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDemo {

    private static final String DB_URL = "";
    private static final String USER = "";
    private static final String PASS = "";
    private static final String CREATE_PRODUCT = "INSERT INTO PRODUCT VALUES(?, ?, ?, ?)";

    public static void main(String[] args) throws SQLException {
        Product product1 = new Product(55, "!!!", "!!!", 777);
        Product product2 = new Product(66, "!!!", "!!!", 777);
        Product product3 = new Product(66, "!!!", "!!!", 777);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        saveList(products);
    }


    private static void saveList(List<Product> products) throws SQLException {
        try(Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT)) {

                connection.setAutoCommit(false);

                for (Product product : products) {
                    preparedStatement.setLong(1, product.getId());
                    preparedStatement.setString(2, product.getName());
                    preparedStatement.setString(3, product.getDescription());
                    preparedStatement.setInt(4, product.getPrice());

                    int res = preparedStatement.executeUpdate();

                    System.out.println("save was finished with result " + res);
                }

                connection.commit();

            } catch (SQLException e) {
                connection.rollback();
                System.err.println("Something went wrong");
                throw e;
            }
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
