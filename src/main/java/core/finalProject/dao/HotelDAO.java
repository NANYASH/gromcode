package core.finalProject.dao;


import core.finalProject.entity.Hotel;
import core.finalProject.exceptions.BadRequestException;

import java.io.IOException;
import java.util.List;

public interface HotelDAO {
    public Hotel addHotel(Hotel hotel) throws IOException, BadRequestException;

    public Hotel deleteHotel(Hotel hotel) throws BadRequestException, IOException;

    public List<Hotel> getHotels() throws BadRequestException;

    public Hotel findHotelById(long id) throws BadRequestException;
}
