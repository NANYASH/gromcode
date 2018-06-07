package core.finalProject.dao;


import core.finalProject.exceptions.BadRequestException;

import java.io.File;


public class Validator {
    public static void validate(String fileToPath) throws BadRequestException {
        File fileTo = new File(fileToPath);
        if (!fileTo.exists()) {
            throw new BadRequestException("DB is not found" + fileTo);
        }
        if (!fileTo.canWrite()) {
            throw new BadRequestException("DB is not writable" + fileTo);
        }
    }

}