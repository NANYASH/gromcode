package core.finalProject.demo;


import core.finalProject.controllers.HotelControllerImpl;
import core.finalProject.controllers.UserControllerImpl;
import core.finalProject.dao.impl.GenericDAOImpl;
import core.finalProject.dao.impl.HotelDAOImpl;
import core.finalProject.entity.Hotel;
import core.finalProject.exceptions.AccessDenied;
import core.finalProject.exceptions.BadRequestException;
import core.finalProject.exceptions.Forbidden;

import java.io.IOException;


public class DemoHotel {
    static Hotel hotel1 = new Hotel(958097817, "Holel1", "Ukraine", "Kiev", "Street1");

    public static void main(String[] args) throws BadRequestException, AccessDenied, IOException, Forbidden {
        HotelControllerImpl hotelController = new HotelControllerImpl();
        HotelDAOImpl hotelDAO = new HotelDAOImpl();
        Hotel hotel1 = new Hotel("Holel7", "Ukraine", "Kiev", "Street1");
        Hotel hotel2 = new Hotel("Holel1", "Ukraine", "Kiev", "Street1");
        //hotelDAO.addHotel(hotel2);
        //System.out.println(hotelDAO.deleteHotel(hotel1));
        UserControllerImpl userController = new UserControllerImpl();
        userController.logIn(DemoUsers.user1);
        GenericDAOImpl genericDAO = new HotelDAOImpl();
        //  hotelController.deleteHotel(DemoUsers.user1,hotel2);
        hotelController.addHotel(DemoUsers.user1, hotel1);
        //System.out.println(hotelDAO.findHotelByName("Holel1"));
        //System.out.println(hotelController.addHotel(hotel1));
        //System.out.println(hotelController.deleteHotel(hotel1));


    }
}
