package hibernate.lesson4.demo.TesController;


import hibernate.lesson4.controllers.UserController;
import hibernate.lesson4.dao.RoomDAO;
import hibernate.lesson4.entity.Hotel;
import hibernate.lesson4.entity.Room;
import hibernate.lesson4.entity.User;
import hibernate.lesson4.entity.UserType;
import hibernate.lesson4.exceptions.BadRequestException;
import hibernate.lesson4.exceptions.DBException;
import hibernate.lesson4.services.RoomServiceImpl;
import hibernate.lesson4.utils.Filter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class RoomDemo {
    public static void main(String[] args) throws DBException, BadRequestException {
        RoomDAO roomDAO = new RoomDAO();
        RoomServiceImpl roomService = new RoomServiceImpl();
        RoomDAO roomDAO1 = new RoomDAO();


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
       // room.setDateAvailableFrom(new Date());
        room.setHotel(hotel);



        User user = new User();

        user.setId(275);
        user.setUserName("Anna");
        user.setPassword("password");
        user.setCountry("Kiev");
        user.setUserType(UserType.ADMIN);

        UserController userController = new UserController();
        userController.logIn(user);


        Filter filter = new Filter();
        filter.setName("HOTEL1");
        filter.setCountry("Ukraine");
        filter.setCity("Kiev");
        filter.setStreet("Street1");
        filter.setNumberOfGuests(2);
        filter.setPrice(100);
        filter.setBreakfastIncluded(1);
        filter.setPetsAllowed(1);

        System.out.println(roomService.findRooms(filter));

        //System.out.println(roomDAO.getAll().get(1).toString());
        //roomDAO.save(room);

    }
}
