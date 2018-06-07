package core.lesson19;


public class DAO {

    public static File findFileById(Storage storage, long id) throws Exception {
        for (File file : storage.getFiles()) {
            if (file != null && file.getId() == id)
                return file;
        }
        return null;
    }
}
