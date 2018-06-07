package core.lesson19;


public class Controller {

    public static void put(Storage storage, File file) throws Exception {
        if (Validator.validateAll(storage, file)) {
            for (int i = 0; i < storage.getFiles().length; i++) {
                if (storage.getFiles()[i] == null) {
                    storage.getFiles()[i] = file;
                    return;
                }
            }
        }
    }

    public static File transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        File file;
        file = DAO.findFileById(storageFrom, id);
        if (Validator.validateAll(storageTo, file)) {
            for (int i = 0; i < storageTo.getFiles().length; i++) {
                if (storageTo.getFiles()[i] == null) {
                    storageTo.getFiles()[i] = file;
                    delete(storageFrom, file);
                    return storageTo.getFiles()[i];
                }
            }
        }
        throw new Exception("Not enough place in storage id=" + storageTo.getId());
    }

    public static File delete(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].getId() == file.getId()) {
                storage.getFiles()[i] = null;
                return file;
            }
        }
        throw new Exception("File does not exist");
    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        int index = 0;
        Validator.validateStorageSize(storageFrom, storageTo);
        for (File file : storageFrom.getFiles()) {
            Validator.validateAll(storageTo, file);
        }
        for (int i = 0; i < storageTo.getFiles().length; i++) {
            if (storageTo.getFiles()[i] == null) {
                storageTo.getFiles()[i] = storageFrom.getFiles()[index];
                storageFrom.getFiles()[index] = null;
                index++;
            }
            if (index == storageFrom.getFiles().length) return;
        }
    }

}
