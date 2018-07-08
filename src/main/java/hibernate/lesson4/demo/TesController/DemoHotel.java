package hibernate.lesson4.demo.TesController;


import hibernate.lesson4.dao.HotelDAO;
import hibernate.lesson4.entity.Hotel;

public class DemoHotel {
    public static void main(String[] args) throws Exception {
        HotelDAO hotelDAO = new HotelDAO();
       // System.out.println(hotelDAO.findById(Hotel.class,57));

        Hotel hotel = new Hotel();
        hotel.setName("HOTEL1");
        hotel.setCity("Kiev");
        hotel.setCountry("Ukraine");
        hotel.setStreet("Street1");

        System.out.println(hotelDAO.findByCity("Kiev"));;
        //hotelDAO.save(hotel);

    }
}
