package jdbc.lesson4.hw;


import jdbc.lesson4.hw.exception.BadRequestException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Controller {
    FileDAO fileDAO = new FileDAO();

    public File put(Storage storage, File file) throws BadRequestException, SQLException {
        Validator.validateExistence(file.getId());
        file.setStorageID(storage.getId());
        try (Connection connection = GenericDAO.getConnection()) {
            fileDAO.update(connection, file);
        }
        return file;
    }

    public void delete(Storage storage, File file) throws SQLException, BadRequestException {
        Validator.validateExistenceAtStorage(storage, file.getId());
        try (Connection connection = GenericDAO.getConnection()) {
            fileDAO.delete(connection, file.getId());
        }

    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws BadRequestException, SQLException {
        List<Long> ids = FileDAO.getFilesLongParametersByStorageID(FileDAO.FIND_FILES_ID_BY_STORAGE_ID, storageFrom.getId());
        try (Connection connection = GenericDAO.getConnection()) {
            try {
                connection.setAutoCommit(false);
                for (Long id : ids) {
                    Validator.validateExistenceAtStorage(storageFrom, id);
                    File file = fileDAO.findById(id);
                    Validator.validate(storageTo, file);
                    file.setStorageID(storageTo.getId());
                    fileDAO.update(connection, file);
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws BadRequestException, SQLException {
        try (Connection connection = GenericDAO.getConnection()) {
            try {
                File file = fileDAO.findById(id);
                connection.setAutoCommit(false);
                Validator.validateExistenceAtStorage(storageFrom, file.getId());
                Validator.validate(storageTo, file);
                file.setStorageID(storageTo.getId());
                fileDAO.update(connection, file);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new SQLException();
            }
        }
    }
}


