package core.finalProject.dao;


import core.finalProject.entity.User;
import core.finalProject.exceptions.BadRequestException;

import java.io.IOException;
import java.util.List;

public interface UserDAO {
    public User addUser(User user) throws IOException, BadRequestException;

    public User deleteUser(User user) throws BadRequestException, IOException;

    public List<User> getUsers() throws BadRequestException;

    public User findUserById(long id) throws BadRequestException;
}
