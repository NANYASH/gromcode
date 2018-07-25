package hibernate.lesson4.demo.TestDAO;


import hibernate.lesson4.dao.OrderDAO;
import hibernate.lesson4.entity.Order;
import hibernate.lesson4.entity.Room;
import hibernate.lesson4.entity.User;
import hibernate.lesson4.entity.UserType;
import hibernate.lesson4.exceptions.DBException;

import java.util.Date;

public class OrderDemolDAO {
    public static void main(String[] args) throws DBException {
        OrderDAO orderDAO = new OrderDAO();

        User user = new User();
        user.setId(45);
        user.setUserName("Anastasia");
        user.setPassword("password");
        user.setCountry("Kiev");
        user.setUserType(UserType.ADMIN);



        Room room = new Room();
        room.setId(121);
        room.setNumberOfGuests(2);
        room.setPrice(100);
        room.setBreakfastIncluded(1);
        room.setPetsAllowed(1);
      //  room.setDateAvailableFrom(new Date());
       // room.setHotel(hotel);

        Order order = new Order();

        order.setUserOrdered(user);
        order.setRoom(room);
        order.setDateFrom(new Date());
        order.setDateTo(new Date());
        order.setMoneyPaid(100);


        orderDAO.save(order);
    }
}
