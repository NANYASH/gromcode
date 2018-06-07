package core.lesson34.hw;

import java.io.File;
import java.io.FileNotFoundException;


public class Validator {
    public static void validateAdd(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File is not found" + fileFrom);
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File is not found" + fileTo);
        }
        if (!fileFrom.canRead()) {
            throw new Exception("File is not readable" + fileFrom);
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File is not writable" + fileTo);
        }
        if (fileFrom.length() == 0) {
            throw new Exception("File is empty" + fileFrom);
        }
    }
}
