package jdbc.lesson4.hw;


import jdbc.lesson4.hw.exception.BadRequestException;

import java.sql.SQLException;

public class Validator {
    public static void validate(Storage storage, File file) throws BadRequestException, SQLException {
        validateID(storage, file);
        validateFormat(storage, file);
        validateStorageSize(storage, file);
    }

    private static void validateID(Storage storage, File file) throws BadRequestException, SQLException {
        for (Long id : FileDAO.getFilesLongParametersByStorageID(FileDAO.FIND_FILES_ID_BY_STORAGE_ID, storage.getId())) {
            if (id == file.getId())
                throw new BadRequestException("Duplicate file id=" + file.getId() + ", file cannot be added to the storage with id=" + storage.getId());
        }

    }

    private static void validateStorageSize(Storage storage, File file) throws BadRequestException, SQLException {
        long unavailableStorage = 0;
        for (Long size : FileDAO.getFilesLongParametersByStorageID(FileDAO.FIND_FILES_SIZE_BY_STORAGE_ID, storage.getId())) {
            unavailableStorage += size;
        }
        if (storage.getStorageSize() - unavailableStorage < file.getSize())
            throw new BadRequestException("Storage with id=" + storage.getId() + " is overloaded and file with id=" + file.getId() + " cannot be added.");
    }

    private static void validateFormat(Storage storage, File file) throws BadRequestException {
        String[] supportedFormats = storage.getFormatsSupported().split(",");
        for (String format : supportedFormats) {
            if (format.equals(file.getFormat()))
                return;
        }
        throw new BadRequestException("Unsupported file format id=" + file.getId() + ", file cannot be added to the storage with id=" + storage.getId());
    }

    public static void validateExistenceAtStorage(Storage storage, long id) throws BadRequestException, SQLException {
        File file = new FileDAO().findById(id);
        if (storage.getId() != file.getStorageID())
            throw new BadRequestException("File with such id= " + file.getId() + " does not exist at storage with id= " + storage.getId());
    }

    public static void validateExistence(long id) throws SQLException, BadRequestException {
        File file = null;
        try {
            file = new FileDAO().findById(id);
        } catch (BadRequestException e) {
            throw new BadRequestException("File with such id= " + file.getId() + " does not exist. ");
        }

    }
}
