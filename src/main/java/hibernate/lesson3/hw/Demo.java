package hibernate.lesson3.hw;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        HotelDAO hotelDAO = new HotelDAO();
        RoomDAO roomDAO = new RoomDAO();

        Hotel hotel1 = new Hotel();
        hotel1.setId(57);
        hotel1.setName("HOTEL1");
        hotel1.setCountry("Ukraine");
        hotel1.setCity("Kiev");
        hotel1.setStreet("Street1");

        //hotelDAO.save(hotel1);

        Room room1 = new Room();
        room1.setHotel(hotel1);
        //room1.setBreakfastIncluded(1);
       // room1.setPetsAllowed(1);
        room1.setId(59);
        room1.setPrice(200);
        room1.setNumberOfGuests(4);
        room1.setDateAvailableFrom(new Date());

        roomDAO.save(room1);

        //roomDAO.update(room1);
       // roomDAO.delete(room1);

    }
}
