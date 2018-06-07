package jdbc.lesson3.hw.task1and2;


import jdbc.lesson4.lecture.Product;
import jdbc.lesson3.lecture.ProductDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    ProductDAO productDAO = new ProductDAO();

    private static final String SELECT_PRODUCT_WITH_EMPTY_DESCRIPTION = "SELECT * FROM PRODUCT WHERE DESCRIPTION IS NULL";
    private static final String SELECT_PRODUCT_BY_NAME = "SELECT * FROM PRODUCT WHERE NAME = ?";
    private static final String SELECT_PRODUCT_BY_PRICE = "SELECT * FROM PRODUCT WHERE PRICE >= ? AND PRICE <= ?";

    public List<Product> findProductsWitEmptyDescription() throws SQLException {
        try (Connection connection = productDAO.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_PRODUCT_WITH_EMPTY_DESCRIPTION);
            return getResult(resultSet);
        }
    }

    public List<Product> findProductsByPrice(int price, int delta) throws SQLException {
        try (Connection connection = productDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_PRICE)) {
            preparedStatement.setInt(1, price - delta);
            preparedStatement.setInt(2, price + delta);
            ResultSet resultSet = preparedStatement.executeQuery();
            return getResult(resultSet);
        }
    }

    public List<Product> findProductsByName(String word) throws Exception {
        validateWord(word);
        try (Connection connection = productDAO.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);
            preparedStatement.setString(1, word);
            ResultSet resultSet = preparedStatement.executeQuery();
            return getResult(resultSet);
        }
    }

    public List<Product> getResult(ResultSet resultSet) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            Product product = new Product(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getInt(4));
            products.add(product);
        }
        return products;
    }

    private void validateWord(String word) throws Exception {
        if (word.length() < 3) throw new Exception("Too short word: " + word);
        for (char ch : word.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) throw new Exception("Only letters and digits are allowed: " + word);
        }
    }

    public void createTable() throws SQLException {
        try (Connection connection = productDAO.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeQuery("CREATE TABLE TEST_SPEED (ID INT PRIMARY KEY, " +
                    "SOME_STRING VARCHAR(45) NOT NULL ," +
                    "SOME_NUMBER INT NOT NULL)");

        }
    }

}
