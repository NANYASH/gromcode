package core.finalProject.demo;


import core.finalProject.controllers.OrderControllerImpl;
import core.finalProject.controllers.UserControllerImpl;
import core.finalProject.dao.impl.OrderDAOImpl;
import core.finalProject.entity.Order;
import core.finalProject.exceptions.BadRequestException;

import java.time.LocalDate;

public class DemoOrder {
    public static void main(String[] args) throws BadRequestException {
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        Order order = new Order(DemoUsers.user1, DemoRoom.room1, DemoRoom.room1.getDateAvailableFrom(), LocalDate.now(), 2500);

        OrderControllerImpl controller = new OrderControllerImpl();
        UserControllerImpl userController = new UserControllerImpl();
        userController.logIn(DemoUsers.user1);
        //controller.addOrder(1699745860,329702590,958097817,LocalDate.parse("2018-05-12"),LocalDate.parse("2018-05-15"));
        //controller.cancelOrder(1699745860,329702590);
        //orderDAO.addOrder(order);
        //System.out.println(OrderDAOImpl.getOrders());
    }
}
