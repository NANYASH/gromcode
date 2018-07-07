package hibernate.lesson4.services;


import hibernate.lesson4.Session;
import hibernate.lesson4.dao.UserDAO;
import hibernate.lesson4.entity.User;
import hibernate.lesson4.exceptions.BadRequestException;
import hibernate.lesson4.exceptions.Forbidden;

import java.io.IOException;


public class UserServiceImpl {
    UserDAO userDAO = new UserDAO();


    public User registerUser(User user) throws BadRequestException, IOException {
        return userDAO.save(user);
    }

    public void logIn(User user) throws BadRequestException {
        Session.setLoggedInUser(user);
    }


    public void logOut(User user) throws Forbidden {
        Session.setLoggedInUser(null);
    }

    public User findUserById(long id) throws BadRequestException {
        return userDAO.findById(User.class,id);
    }
}
