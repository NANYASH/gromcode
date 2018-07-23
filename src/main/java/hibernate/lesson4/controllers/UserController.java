package hibernate.lesson4.controllers;


import hibernate.lesson4.Session;
import hibernate.lesson4.entity.Hotel;
import hibernate.lesson4.entity.Room;
import hibernate.lesson4.entity.User;
import hibernate.lesson4.exceptions.AccessDenied;
import hibernate.lesson4.exceptions.BadRequestException;
import hibernate.lesson4.exceptions.Forbidden;
import hibernate.lesson4.services.UserServiceImpl;
import hibernate.lesson4.utils.Filter;

import javax.persistence.NoResultException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserController {

    UserServiceImpl userService = new UserServiceImpl();

    public User registerUser(User user) throws BadRequestException, IOException {
            return userService.registerUser(user);
    }

    public void logIn(User user) throws BadRequestException {
        if (Session.getLoggedInUser() != null)
            throw new BadRequestException("User" + Session.getLoggedInUser() + "is still logged in.");
        userService.logIn(user);
    }

    public void logOut(User user) throws BadRequestException, Forbidden {
        if (!user.equals(Session.getLoggedInUser()))
            throw new Forbidden("User " + user + " should be logged in to perform such action.");
        userService.logOut(user);
    }






}
