package jdbc.lesson4.hw;


import jdbc.lesson4.hw.exception.BadRequestException;

import java.sql.*;


public class StorageDAO extends GenericDAO<Storage> {
    private static final String CREATE_STORAGE = "INSERT INTO STORAGE VALUES(?, ?, ?, ?)";
    private static final String DELETE_STORAGE = "DELETE FROM STORAGE WHERE ID=?";
    private static final String UPDATE_STORAGE = "UPDATE STORAGE SET ID = ?, FORMATS_SUPPORTED = ?,STORAGE_COUNTRY = ?, STORAGE_SIZE = ? WHERE ID = ?";
    private static final String FIND_STORAGE_BY_ID = "SELECT * FROM STORAGE WHERE ID = ?";

    public Storage save(Connection connection, Storage storage) throws SQLException {
        return super.createUpdate(connection, storage, CREATE_STORAGE);
    }

    public void delete(long id) throws SQLException {
        super.deleteByID(getConnection(), id, DELETE_STORAGE);
    }

    public Storage update(Connection connection, Storage storage) throws SQLException {
        return executeQuery(connection, storage, UPDATE_STORAGE);
    }

    public Storage findById(long id) throws SQLException, BadRequestException {
        return super.findById(id, FIND_STORAGE_BY_ID);
    }

    @Override
    Storage createResult(ResultSet resultSet) throws SQLException, BadRequestException {
        Storage storage = new Storage();
        while (resultSet.next()) {
            storage = new Storage(resultSet.getLong(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getLong(4));
        }
        return storage;
    }

    @Override
    public Storage executeQuery(Connection connection, Storage storage, String query) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, storage.getId());
            preparedStatement.setString(2, storage.getFormatsSupported());
            preparedStatement.setString(3, storage.getStorageCountry());
            preparedStatement.setLong(4, storage.getStorageSize());
            try {
                preparedStatement.setLong(5, storage.getId());
            } catch (SQLException e) {
            }
            preparedStatement.executeUpdate();
        }
        return storage;
    }


}
