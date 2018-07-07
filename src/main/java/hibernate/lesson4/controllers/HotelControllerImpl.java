package hibernate.lesson4.controllers;


import core.finalProject.Session;
import core.finalProject.entity.Hotel;
import core.finalProject.entity.User;
import core.finalProject.exceptions.AccessDenied;
import core.finalProject.exceptions.BadRequestException;
import core.finalProject.exceptions.Forbidden;
import core.finalProject.services.HotelServiceImpl;

import java.io.IOException;

import static core.finalProject.entity.UserType.ADMIN;


public class HotelControllerImpl {
    HotelServiceImpl hotelService = new HotelServiceImpl();

    public Hotel findHotelByName(String name) throws BadRequestException {
        return hotelService.findHotelByName(name);
    }

    public Hotel findHotelByCity(String city) throws BadRequestException {
        return hotelService.findHotelByCity(city);
    }

    public Hotel addHotel(User user, Hotel hotel) throws BadRequestException, IOException, AccessDenied, Forbidden {
        if (!user.equals(Session.getLoggedInUser()))
            throw new Forbidden("User " + user + " should be logged in to perform such action.");
        if (user.getUserType() != ADMIN)
            throw new AccessDenied("User " + user + " with such type cannot perform administrating.");
        return hotelService.addHotel(hotel);
    }

    public Hotel deleteHotel(User user, Hotel hotel) throws BadRequestException, IOException, AccessDenied, Forbidden {
        if (!user.equals(Session.getLoggedInUser()))
            throw new Forbidden("User " + user + " should be logged in to perform such action.");
        if (user.getUserType() != ADMIN)
            throw new AccessDenied("User " + user + " with such type cannot perform administrating.");
        return hotelService.deleteHotel(hotel);
    }
}
