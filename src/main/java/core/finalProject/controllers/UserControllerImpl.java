package core.finalProject.controllers;

import core.finalProject.Session;
import core.finalProject.dao.impl.UserDAOImpl;
import core.finalProject.entity.Hotel;
import core.finalProject.entity.Room;

import core.finalProject.entity.User;
import core.finalProject.exceptions.AccessDenied;
import core.finalProject.exceptions.BadRequestException;
import core.finalProject.exceptions.Forbidden;
import core.finalProject.services.UserServiceImpl;
import core.finalProject.utils.Filter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class UserControllerImpl {

    UserServiceImpl userService = new UserServiceImpl();
    HotelControllerImpl hotelController = new HotelControllerImpl();
    RoomControllerImpl roomController = new RoomControllerImpl();
    OrderControllerImpl orderController = new OrderControllerImpl();

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


    public Hotel findHotelByName(String name) throws BadRequestException {
        return hotelController.findHotelByName(name);
    }


    public Hotel findHotelByCity(String city) throws BadRequestException {
        return hotelController.findHotelByCity(city);
    }

    public ArrayList<Room> findRooms(Filter filter) throws BadRequestException {
        return roomController.findRooms(filter);
    }

    public void bookRoom(long roomId, long userId, long hotelId, LocalDate from, LocalDate to) throws BadRequestException, IOException, Forbidden {
        orderController.addOrder(roomId, userId, hotelId, from, to);
    }


    public void cancelReservation(long roomId, long userId) throws BadRequestException, IOException, Forbidden {
        orderController.cancelOrder(roomId, userId);
    }


    public Hotel addHotel(User user, Hotel hotel) throws BadRequestException, AccessDenied, IOException, Forbidden {
        return hotelController.addHotel(user, hotel);
    }


    public Hotel deleteHotel(User user, Hotel hotel) throws BadRequestException, AccessDenied, IOException, Forbidden {
        return hotelController.deleteHotel(user, hotel);
    }


    public Room addRoom(User user, Room room) throws BadRequestException, AccessDenied, IOException, Forbidden {
        return roomController.addRoom(user, room);
    }


    public Room deleteRoom(User user, Room room) throws BadRequestException, AccessDenied, IOException, Forbidden {
        return roomController.deleteRoom(user, room);
    }

}
