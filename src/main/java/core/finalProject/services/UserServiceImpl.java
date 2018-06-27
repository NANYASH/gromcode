package core.finalProject.services;


import core.finalProject.Session;
import core.finalProject.dao.UserDAO;
import core.finalProject.dao.impl.UserDAOImpl;
import core.finalProject.entity.User;
import core.finalProject.exceptions.BadRequestException;
import core.finalProject.exceptions.Forbidden;

import java.io.IOException;


public class UserServiceImpl {
    UserDAO userDAO = new UserDAOImpl();


    public User registerUser(User user) throws BadRequestException, IOException {
        return userDAO.addUser(user);
    }

    public void logIn(User user) throws BadRequestException {
        Session.setLoggedInUser(user);
    }


    public void logOut(User user) throws Forbidden {
        Session.setLoggedInUser(null);
    }

    public User findUserById(long id) throws BadRequestException {
        return userDAO.findUserById(id);
    }
}
