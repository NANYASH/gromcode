package core.finalProject.dao.impl;

import core.finalProject.dao.HotelDAO;
import core.finalProject.entity.Hotel;
import core.finalProject.exceptions.BadRequestException;

import java.io.IOException;
import java.util.List;


public class HotelDAOImpl extends GenericDAOImpl<Hotel> implements HotelDAO {
    private static String hotelDB = "/Users/nanya/Desktop/gromcode/HotelDB.txt";

    @Override
    public Hotel parseEntity(String line) {
        String[] parameters = line.split(",");
        return new Hotel((Long.parseLong(parameters[0])), parameters[1], parameters[2], parameters[3], parameters[4]);
    }

    @Override
    public String getDb() {
        return hotelDB;
    }

    @Override
    public Hotel addHotel(Hotel hotel) throws IOException, BadRequestException {
        return super.addEntity(hotel);
    }

    @Override
    public Hotel deleteHotel(Hotel hotel) throws BadRequestException, IOException {
        return super.deleteEntity(hotel);
    }

    @Override
    public List<Hotel> getHotels() throws BadRequestException {
        return super.getEntities();
    }

    @Override
    public Hotel findHotelById(long id) throws BadRequestException {
        return super.findEntityById(id);
    }
}
