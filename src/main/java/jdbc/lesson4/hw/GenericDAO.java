package jdbc.lesson4.hw;


import jdbc.lesson4.hw.exception.BadRequestException;

import java.sql.*;

public abstract class GenericDAO<T> {
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.cnrx1jkycv8d.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASS = "asol1998";


    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public T createUpdate(Connection connection, T t, String query) throws SQLException {
        return executeQuery(connection, t, query);
    }

    public void deleteByID(Connection connection, long id, String query) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public T findById(long id, String query) throws SQLException, BadRequestException {
        try (Connection connection = GenericDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return createResult(resultSet);
        }
    }

    abstract T executeQuery(Connection connection, T t, String query) throws SQLException;

    abstract T createResult(ResultSet resultSet) throws SQLException, BadRequestException;

}
