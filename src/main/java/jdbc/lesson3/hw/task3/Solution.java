package jdbc.lesson3.hw.task3;


import java.sql.*;

public class Solution {
    private static final String DB_URL = "";
    private static final String USER = "";
    private static final String PASS = "";


    public long testSavePerformance() throws SQLException {//159337
        long start = System.currentTimeMillis();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO TEST_SPEED VALUES (?,?,?)")) {
            int id = 1;
            String string = "test";
            int number = 100;
            for (int i = 0; i < 1000; i++) {
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, string);
                preparedStatement.setInt(3, number);
                preparedStatement.execute();
                id++;
                number++;
            }

            long end = System.currentTimeMillis();
            return end - start;
        }
    }

    public long testDeletePerformance() throws SQLException {//2543
        long start = System.currentTimeMillis();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM TEST_SPEED");
            long end = System.currentTimeMillis();
            return end - start;
        }
    }

    public long testSelectByIdPerformance() throws SQLException {//196260
        long start = System.currentTimeMillis();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TEST_SPEED WHERE ID = ?")) {
            int id = 1;
            for (int i = 0; i < 1000; i++) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
                id++;
            }
            long end = System.currentTimeMillis();
            return end - start;
        }
    }

    public long testSelectPerformance() throws SQLException {//2641
        long start = System.currentTimeMillis();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("SELECT 1000 FROM TEST_SPEED");

            long end = System.currentTimeMillis();
            return end - start;
        }
    }

    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

}
