package hibernate.lesson4.services;



import hibernate.lesson4.dao.HotelDAO;
import hibernate.lesson4.entity.Hotel;
import hibernate.lesson4.exceptions.AccessDenied;
import hibernate.lesson4.exceptions.BadRequestException;
import hibernate.lesson4.exceptions.Forbidden;

import java.io.IOException;
import java.util.List;


public class HotelServiceImpl {
    HotelDAO hotelDAO = new HotelDAO();

    public List<Hotel> findHotelByName(String name) throws BadRequestException {
        List<Hotel> hotels = hotelDAO.findByName(name);
        if (hotels != null) return hotels;
        throw new BadRequestException("Hotels with such name \"" + name + "\" does not exist.");
    }

    public List<Hotel> findHotelByCity(String city) throws BadRequestException {
        List<Hotel> hotels = hotelDAO.findByCity(city);
        if (hotels != null) return hotels;
        throw new BadRequestException("Hotels with such city \"" + city + "\" does not exist.");
    }

    public Hotel addHotel(Hotel hotel) throws BadRequestException, AccessDenied, Forbidden, IOException {
        return hotelDAO.save(hotel);
    }

    public void deleteHotel(long id) throws AccessDenied, Forbidden, IOException, BadRequestException {
        hotelDAO.delete(id);
    }

    public Hotel findHotelById(long id) throws BadRequestException {
        return hotelDAO.findById(Hotel.class,id);
    }
}
