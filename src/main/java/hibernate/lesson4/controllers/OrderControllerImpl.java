package hibernate.lesson4.controllers;

import core.finalProject.Session;
import core.finalProject.entity.User;
import core.finalProject.exceptions.BadRequestException;
import core.finalProject.exceptions.Forbidden;
import core.finalProject.services.OrderServiceImpl;
import core.finalProject.services.UserServiceImpl;

import java.io.IOException;
import java.util.Date;


public class OrderControllerImpl {
    OrderServiceImpl orderService = new OrderServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    public void addOrder(long roomId, long userId, long hotelId, Date from, Date to) throws BadRequestException, IOException, Forbidden {
        User user = userService.findUserById(userId);
        if (!user.equals(Session.getLoggedInUser()))
            throw new Forbidden("User " + user + " should be logged in to perform such action.");
        orderService.addOrder(roomId, user, hotelId, from, to);
    }

    public void cancelOrder(long roomId, long userId) throws BadRequestException, IOException, Forbidden {
        User user = userService.findUserById(userId);
        if (!user.equals(Session.getLoggedInUser()))
            throw new Forbidden("User " + user + " should be logged in to perform such action.");
        orderService.cancelOrder(roomId);
    }
}
