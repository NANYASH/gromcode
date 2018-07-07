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

import static hibernate.lesson4.entity.UserType.ADMIN;


public class RoomControllerImpl {
    RoomServiceImpl roomService = new RoomServiceImpl();

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
}
