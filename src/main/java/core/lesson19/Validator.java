package core.lesson19;


public class Validator {
    public static boolean validateAll(Storage storage, File file) throws Exception {
        validateId(storage, file);
        validateFormat(storage, file);
        validateStorageSize(storage, file);
        return true;
    }

    public static void validateId(Storage storage, File file) throws Exception {
        if (DAO.findFileById(storage, file.getId()) != null)
            throw new Exception("File with such id=" + file.getId() + " already exists at storage with id=" + storage.getId());
    }

    public static void validateFormat(Storage storage, File file) throws Exception {
        for (String format : storage.getFormatsSupported()) {
            if (format.equals(file.getFormat()))
                return;
        }
        throw new Exception("Unsupported file format id=" + file.getId() + ", file cannot be added to the storage with id=" + storage.getId());
    }

    public static void validateStorageSize(Storage storage, File file) throws Exception {
        checkStorageForFreeFields(storage);
        if (storage.getStorageSize() - checkSize(storage) < file.getSize())
            throw new Exception("Storage with id=" + storage.getId() + " is overloaded and file with id=" + file.getId() + " cannot be added.");
    }

    public static void validateStorageSize(Storage storageFrom, Storage storageTo) throws Exception {
        checkStorageForFreeFields(storageFrom, storageTo);
        if (storageTo.getStorageSize() - checkSize(storageTo) < checkSize(storageFrom))
            throw new Exception("Not enough place in storage id=" + storageTo.getId());
    }

    public static long checkSize(Storage storage) {
        long unavailableStorage = 0;
        for (File file1 : storage.getFiles()) {
            if (file1 != null)
                unavailableStorage += file1.getSize();
        }
        return unavailableStorage;
    }

    public static void checkStorageForFreeFields(Storage storage) throws Exception {
        for (File file1 : storage.getFiles()) {
            if (file1 == null)
                return;
        }
        throw new Exception("Not enough place in storage id=" + storage.getId());
    }

    public static void checkStorageForFreeFields(Storage storageFrom, Storage storageTo) throws Exception {
        int numberOfFreeFields = 0;
        for (File file1 : storageTo.getFiles()) {
            if (file1 == null)
                numberOfFreeFields++;
        }
        if (numberOfFreeFields < storageFrom.getFiles().length)
            throw new Exception("Not enough place in storage id=" + storageTo.getId());
    }

}
