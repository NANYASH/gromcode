package hibernate.lesson4.demo.TesController;


import hibernate.lesson4.dao.RoomDAO;
import hibernate.lesson4.entity.Hotel;
import hibernate.lesson4.entity.Room;

import java.util.Date;

public class RoomDemo {
    public static void main(String[] args) {
        RoomDAO roomDAO = new RoomDAO();


        Hotel hotel = new Hotel();
        hotel.setId(81);
        hotel.setName("HOTEL1");
        hotel.setCity("Kiev");
        hotel.setCountry("Ukraine");
        hotel.setStreet("Street1");



        Room room = new Room();
        room.setNumberOfGuests(2);
        room.setPrice(100);
        room.setBreakfastIncluded(1);
        room.setPetsAllowed(1);
        room.setDateAvailableFrom(new Date());
        room.setHotel(hotel);

        roomDAO.save(room);

    }
}
