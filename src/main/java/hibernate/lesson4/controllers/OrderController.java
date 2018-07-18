package hibernate.lesson4.controllers;



import hibernate.lesson4.Session;
import hibernate.lesson4.entity.User;
import hibernate.lesson4.exceptions.BadRequestException;
import hibernate.lesson4.exceptions.Forbidden;
import hibernate.lesson4.services.OrderServiceImpl;
import hibernate.lesson4.services.UserServiceImpl;

import java.io.IOException;
import java.util.Date;


public class OrderController {
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
