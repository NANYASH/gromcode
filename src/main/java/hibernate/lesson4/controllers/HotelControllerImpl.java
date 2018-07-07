package hibernate.lesson4.controllers;



import hibernate.lesson4.Session;
import hibernate.lesson4.entity.Hotel;
import hibernate.lesson4.entity.User;
import hibernate.lesson4.exceptions.AccessDenied;
import hibernate.lesson4.exceptions.BadRequestException;
import hibernate.lesson4.exceptions.Forbidden;
import hibernate.lesson4.services.HotelServiceImpl;

import java.io.IOException;
import java.util.List;

import static hibernate.lesson4.entity.UserType.ADMIN;


public class HotelControllerImpl {
    HotelServiceImpl hotelService = new HotelServiceImpl();

    public List<Hotel> findHotelByName(String name) throws BadRequestException {
        return hotelService.findHotelByName(name);
    }

    public List<Hotel> findHotelByCity(String city) throws BadRequestException {
        return hotelService.findHotelByCity(city);
    }

    public Hotel addHotel(User user, Hotel hotel) throws BadRequestException, IOException, AccessDenied, Forbidden {
        if (!user.equals(Session.getLoggedInUser()))
            throw new Forbidden("User " + user + " should be logged in to perform such action.");
        if (user.getUserType() != ADMIN)
            throw new AccessDenied("User " + user + " with such type cannot perform administrating.");
        return hotelService.addHotel(hotel);
    }

    public void deleteHotel(User user, long id) throws BadRequestException, IOException, AccessDenied, Forbidden {
        if (!user.equals(Session.getLoggedInUser()))
            throw new Forbidden("User " + user + " should be logged in to perform such action.");
        if (user.getUserType() != ADMIN)
            throw new AccessDenied("User " + user + " with such type cannot perform administrating.");
        hotelService.deleteHotel(id);
    }
}
