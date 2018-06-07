package core.finalProject.dao.impl;

import core.finalProject.entity.Entity;
import core.finalProject.exceptions.BadRequestException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static core.finalProject.utils.IdUtil.generateId;


public abstract class GenericDAOImpl<T extends Entity> {

    private String db;

    public static void writeToFile(String fileToPath, String contentToWrite, boolean append) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToPath, append))) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileToPath))) {
                if (br.readLine() != null) {
                    bufferedWriter.append("\n");
                    bufferedWriter.append(contentToWrite);
                } else
                    bufferedWriter.append(contentToWrite);
            }
        } catch (IOException e) {
            throw new IOException("File" + fileToPath + " cannot be edited.");
        }
    }

    public T addEntity(T entity) throws IOException, BadRequestException {
        entity.setId(generateId());
        writeToFile(getDb(), entity.toString(), true);
        return entity;
    }

    public T deleteEntity(T entity) throws BadRequestException, IOException {
        List<T> entities = getEntities();
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).equals(entity)) {
                entity = entities.get(i);
                entities.set(i, null);
                writeToFile(getDb(), String.valueOf(deleteEmptyEntities(entities)), false);
                return entity;
            }
        }
        throw new BadRequestException("Such entity \"" + entity + "\" does not exist.");
    }

    public T findEntityById(long id) throws BadRequestException {
        List<T> hotels = getEntities();
        for (T t : hotels) {
            if (t.getId() == id)
                return t;
        }
        throw new BadRequestException("Entity with such id \"" + id + "\" does not exist.");

    }

    public void validateEntity(T entity) throws BadRequestException {
        for (Object o : getEntities()) {
            if (o.equals(entity))
                throw new BadRequestException("Such entity " + entity + " already exists.");
        }
    }

    public abstract T parseEntity(String line) throws BadRequestException;

    public List<T> getEntities() throws BadRequestException {
        List<T> entities = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(getDb()))) {
            line = br.readLine();
            while (line != null) {
                entities.add(parseEntity(line));
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new BadRequestException("File " + getDb() + " cannot be read.");
        }
        return entities;
    }

    public StringBuffer deleteEmptyEntities(List<T> entities) {
        StringBuffer finalText = new StringBuffer();
        for (T entity : entities) {
            if (entity != null)
                finalText.append(entity.toString() + "\n");
        }
        return finalText;
    }

    public String getDb() {
        return db;
    }
}
