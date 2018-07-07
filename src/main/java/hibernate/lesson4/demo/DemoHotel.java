package hibernate.lesson4.demo;


import hibernate.lesson4.dao.HotelDAO;
import hibernate.lesson4.entity.Hotel;

public class DemoHotel {
    public static void main(String[] args) throws Exception {
        HotelDAO hotelDAO = new HotelDAO();
        System.out.println(hotelDAO.findById(Hotel.class,57));

    }
}
