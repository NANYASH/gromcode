package core.finalProject.demo;


import core.finalProject.dao.impl.UserDAOImpl;

import core.finalProject.entity.User;
import core.finalProject.exceptions.BadRequestException;
import core.finalProject.services.UserServiceImpl;


import java.io.IOException;

import static core.finalProject.entity.UserType.ADMIN;
import static core.finalProject.entity.UserType.USERS;

public class DemoUsers {
    static User user1 = new User(329702590, "Anastasia", "password", "Ukraine", ADMIN);

    public static void main(String[] args) throws BadRequestException, IOException {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user1 = new User("Anastasia", "password", "Ukraine", ADMIN);
        User user2 = new User("Anton", "password2", "Poland", USERS);
        User user3 = new User("Liza", "password3", "Germany", USERS);

        //userDAO.registerUser(user1);
        //userDAO.registerUser(user2);
        UserServiceImpl userService = new UserServiceImpl();
        userService.registerUser(user3);


    }
}
