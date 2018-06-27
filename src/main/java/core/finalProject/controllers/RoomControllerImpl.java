package core.finalProject.controllers;


import core.finalProject.Session;
import core.finalProject.dao.impl.UserDAOImpl;
import core.finalProject.entity.Room;
import core.finalProject.entity.User;
import core.finalProject.exceptions.AccessDenied;
import core.finalProject.exceptions.BadRequestException;
import core.finalProject.exceptions.Forbidden;
import core.finalProject.services.RoomServiceImpl;
import core.finalProject.utils.Filter;

import java.io.IOException;
import java.util.ArrayList;

import static core.finalProject.entity.UserType.ADMIN;


public class RoomControllerImpl {
    RoomServiceImpl roomService = new RoomServiceImpl();

    public Room addRoom(User user, Room room) throws BadRequestException, IOException, AccessDenied, Forbidden {
        if (!user.equals(Session.getLoggedInUser()))
            throw new Forbidden("User " + user + " should be logged in to perform such action.");
        if (user.getUserType() != ADMIN)
            throw new AccessDenied("User " + user + " with such type cannot perform administrating.");
        return roomService.addRoom(room);
    }

    public Room deleteRoom(User user, Room room) throws BadRequestException, IOException, AccessDenied, Forbidden {
        if (!user.equals(Session.getLoggedInUser()))
            throw new Forbidden("User " + user + " should be logged in to perform such action.");
        if (user.getUserType() != ADMIN)
            throw new AccessDenied("User " + user + " with such type cannot perform administrating.");
        return roomService.deleteRoom(room);
    }

    public ArrayList<Room> findRooms(Filter filter) throws BadRequestException {
        return roomService.findRooms(filter);
    }
}
