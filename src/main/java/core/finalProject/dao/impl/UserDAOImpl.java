package core.finalProject.dao.impl;

import core.finalProject.dao.UserDAO;
import core.finalProject.entity.*;
import core.finalProject.exceptions.BadRequestException;

import java.io.IOException;
import java.util.List;


public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {
    private static String userDB = "/Users/nanya/Desktop/gromcode/UserDB.txt";



    @Override
    public User parseEntity(String line) throws BadRequestException {
        String[] parameters = line.split(",");
        return new User(Long.parseLong(parameters[0]), parameters[1], parameters[2],
                parameters[3], UserType.valueOf(parameters[4]));
    }

    @Override
    public String getDb() {
        return userDB;
    }

    @Override
    public User addUser(User user) throws IOException, BadRequestException {
        validateEntity(user);
        return super.addEntity(user);
    }

    @Override
    public User deleteUser(User user) throws BadRequestException, IOException {
        return super.deleteEntity(user);
    }

    @Override
    public List<User> getUsers() throws BadRequestException {
        return super.getEntities();
    }

    @Override
    public User findUserById(long id) throws BadRequestException {
        return super.findEntityById(id);
    }
}
