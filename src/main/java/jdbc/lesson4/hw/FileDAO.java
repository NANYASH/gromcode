package jdbc.lesson4.hw;


import jdbc.lesson4.hw.exception.BadRequestException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FileDAO extends GenericDAO<File> {

    private static final String CREATE_FILE = "INSERT INTO С_FILE VALUES (?,?,?,?,?)";
    private static final String DELETE_FILE = "DELETE FROM С_FILE WHERE ID=?";
    private static final String UPDATE_FILE = "UPDATE С_FILE SET ID = ?, FILE_NAME = ?,FILE_FORMAT = ?, FILE_SIZE = ?, ID_STORAGE = ? WHERE ID = ?";
    private static final String FIND_FILE_BY_ID = "SELECT * FROM С_FILE WHERE ID = ?";
    public static final String FIND_FILES_SIZE_BY_STORAGE_ID = "SELECT FILE_SIZE FROM С_FILE WHERE ID_STORAGE = ?";
    public static final String FIND_FILES_ID_BY_STORAGE_ID = "SELECT ID FROM С_FILE WHERE ID_STORAGE = ?";

    public File save(Connection connection, File file) throws SQLException {
        return super.createUpdate(connection, file, CREATE_FILE);
    }

    public void delete(Connection connection, long id) throws SQLException {
        super.deleteByID(connection, id, DELETE_FILE);
    }

    public File update(Connection connection, File file) throws SQLException {
        return super.createUpdate(connection, file, UPDATE_FILE);
    }

    public File findById(long id) throws SQLException, BadRequestException {
        return super.findById(id, FIND_FILE_BY_ID);
    }

    public static List<Long> getFilesLongParametersByStorageID(String query, long id) throws SQLException {
        try (Connection connection = GenericDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Long> param = new ArrayList<>();
            while (resultSet.next()) {
                param.add(resultSet.getLong(1));
            }
            return param;
        }
    }

    @Override
    File createResult(ResultSet resultSet) throws SQLException, BadRequestException {
        File file = new File();
        while (resultSet.next()) {
            file = new File(resultSet.getLong(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getLong(4),
                    resultSet.getLong(5));
        }
        return file;
    }

    @Override
    public File executeQuery(Connection connection, File file, String query) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, file.getId());
            preparedStatement.setString(2, file.getName());
            preparedStatement.setString(3, file.getFormat());
            preparedStatement.setLong(4, file.getSize());
            preparedStatement.setLong(5, file.getStorageID());
            try {
                preparedStatement.setLong(6, file.getId());
            } catch (SQLException e) {
            }
            preparedStatement.executeUpdate();
        }
        return file;
    }

}
