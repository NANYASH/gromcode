package hibernate.lesson4.controllers;




import hibernate.lesson4.Session;
import hibernate.lesson4.entity.Room;
import hibernate.lesson4.entity.User;
import hibernate.lesson4.exceptions.AccessDenied;
import hibernate.lesson4.exceptions.BadRequestException;
import hibernate.lesson4.exceptions.Forbidden;
import hibernate.lesson4.services.RoomServiceImpl;
import hibernate.lesson4.utils.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static hibernate.lesson4.entity.UserType.ADMIN;


public class RoomController {
    RoomServiceImpl roomService = new RoomServiceImpl();

    OrderController orderController = new OrderController();

    public Room addRoom(User user, Room room) throws BadRequestException, IOException, AccessDenied, Forbidden {
        if (!user.equals(Session.getLoggedInUser()))
            throw new Forbidden("User " + user + " should be logged in to perform such action.");
        if (user.getUserType() != ADMIN)
            throw new AccessDenied("User " + user + " with such type cannot perform administrating.");
        return roomService.addRoom(room);
    }

    public void deleteRoom(User user, long id) throws BadRequestException, IOException, AccessDenied, Forbidden {
        if (!user.equals(Session.getLoggedInUser()))
            throw new Forbidden("User " + user + " should be logged in to perform such action.");
        if (user.getUserType() != ADMIN)
            throw new AccessDenied("User " + user + " with such type cannot perform administrating.");
        roomService.deleteRoom(id);
    }

    public ArrayList<Room> findRooms(Filter filter) throws BadRequestException {
        return roomService.findRooms(filter);
    }

    public void bookRoom(long roomId, long userId, long hotelId, Date from, Date to) throws BadRequestException, IOException, Forbidden {
        orderController.addOrder(roomId, userId, hotelId, from, to);
    }


    public void cancelReservation(long roomId, long userId) throws BadRequestException, IOException, Forbidden {
        orderController.cancelOrder(roomId, userId);
    }

}
