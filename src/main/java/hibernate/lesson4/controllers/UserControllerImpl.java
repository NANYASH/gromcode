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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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


    public List<Hotel> findHotelByName(String name) throws BadRequestException {
        return hotelController.findHotelByName(name);
    }


    public List<Hotel> findHotelByCity(String city) throws BadRequestException {
        return hotelController.findHotelByCity(city);
    }

    public ArrayList<Room> findRooms(Filter filter) throws BadRequestException {
        return roomController.findRooms(filter);
    }

    public void bookRoom(long roomId, long userId, long hotelId, Date from, Date to) throws BadRequestException, IOException, Forbidden {
        orderController.addOrder(roomId, userId, hotelId, from, to);
    }


    public void cancelReservation(long roomId, long userId) throws BadRequestException, IOException, Forbidden {
        orderController.cancelOrder(roomId, userId);
    }


    public Hotel addHotel(User user, Hotel hotel) throws BadRequestException, AccessDenied, IOException, Forbidden {
        return hotelController.addHotel(user, hotel);
    }


    public void deleteHotel(User user, long id) throws BadRequestException, AccessDenied, IOException, Forbidden {
         hotelController.deleteHotel(user, id);
    }


    public Room addRoom(User user, Room room) throws BadRequestException, AccessDenied, IOException, Forbidden {
        return roomController.addRoom(user, room);
    }


    public void deleteRoom(User user, long id) throws BadRequestException, AccessDenied, IOException, Forbidden {
         roomController.deleteRoom(user, id);
    }

}
