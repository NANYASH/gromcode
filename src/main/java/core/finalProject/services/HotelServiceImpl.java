package core.finalProject.services;

import core.finalProject.dao.HotelDAO;
import core.finalProject.dao.impl.HotelDAOImpl;
import core.finalProject.entity.Hotel;
import core.finalProject.exceptions.AccessDenied;
import core.finalProject.exceptions.BadRequestException;
import core.finalProject.exceptions.Forbidden;


import java.io.IOException;
import java.util.List;


public class HotelServiceImpl {
    HotelDAO hotelDAO = new HotelDAOImpl();

    public Hotel findHotelByName(String name) throws BadRequestException {
        List<Hotel> hotels = hotelDAO.getHotels();
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(name))
                return hotel;
        }
        throw new BadRequestException("Hotel with such name \"" + name + "\" does not exist.");
    }

    public Hotel findHotelByCity(String city) throws BadRequestException {
        List<Hotel> hotels = hotelDAO.getHotels();
        for (Hotel hotel : hotels) {
            if (hotel.getCity().equals(city))
                return hotel;
        }
        throw new BadRequestException("Hotel with such name \"" + city + "\" does not exist.");

    }

    public Hotel addHotel(Hotel hotel) throws BadRequestException, AccessDenied, Forbidden, IOException {
        return hotelDAO.addHotel(hotel);
    }

    public Hotel deleteHotel(Hotel hotel) throws BadRequestException, AccessDenied, Forbidden, IOException {
        return hotelDAO.deleteHotel(hotel);
    }

    public Hotel findHotelById(long id) throws BadRequestException {
        return hotelDAO.findHotelById(id);
    }
}
