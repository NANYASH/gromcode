package hibernate.lesson4.demo.TesController;



import hibernate.lesson4.controllers.UserController;
import hibernate.lesson4.entity.Hotel;
import hibernate.lesson4.entity.Room;
import hibernate.lesson4.entity.User;
import hibernate.lesson4.entity.UserType;
import hibernate.lesson4.exceptions.AccessDenied;
import hibernate.lesson4.exceptions.BadRequestException;
import hibernate.lesson4.exceptions.Forbidden;

import java.io.IOException;
import java.util.Date;


public class UserDemo {
    public static void main(String[] args) throws Forbidden, BadRequestException, AccessDenied, IOException {
       // UserDAO userDAO = new UserDAO();

        User user = new User();

        user.setId(45);
        user.setUserName("Anastasia");
        user.setPassword("password");
        user.setCountry("Kiev");
        user.setUserType(UserType.ADMIN);

        User user1 = new User();
        user1.setUserName("Lena");
        user1.setPassword("password");
        user1.setCountry("Kiev");
        user1.setUserType(UserType.ADMIN);

       // userDAO.save(user);

        Hotel hotel = new Hotel();
        hotel.setId(81);
        hotel.setName("HOTEL2");
        hotel.setCity("Lviv");
        hotel.setCountry("Ukraine");
        hotel.setStreet("Street2");


        Room room = new Room();
        room.setId(161);
        room.setNumberOfGuests(3);
        room.setPrice(400);
        room.setBreakfastIncluded(0);
        room.setPetsAllowed(1);
        room.setDateAvailableFrom(new Date());
        room.setHotel(hotel);

        UserController userController = new UserController();
        userController.logIn(user);
        //userController.addHotel(user,hotel);
        //userController.deleteHotel(user,121);
        //userController.addRoom(user,room);
        //userController.bookRoom(161,45,81,new Date(),new Date());
        userController.registerUser(user1);


    }
}
