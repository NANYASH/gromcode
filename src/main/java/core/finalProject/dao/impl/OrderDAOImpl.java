package core.finalProject.dao.impl;

import core.finalProject.dao.OrderDAO;
import core.finalProject.entity.Order;
import core.finalProject.entity.Room;
import core.finalProject.entity.User;
import core.finalProject.exceptions.BadRequestException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public class OrderDAOImpl extends GenericDAOImpl<Order> implements OrderDAO {
    private static String orderDB = "/Users/nanya/Desktop/gromcode/OrderDB.txt";

    @Override
    public Order parseEntity(String line) throws BadRequestException {
        String[] parameters = line.split(",");
        return new Order(Long.parseLong(parameters[0]), (User) new UserDAOImpl().findEntityById(Long.parseLong(parameters[1])), (Room) new RoomDAOImpl().findEntityById(Long.parseLong(parameters[2])),
                LocalDate.parse(parameters[3]), LocalDate.parse(parameters[4]), Double.parseDouble(parameters[5]));
    }

    @Override
    public String getDb() {
        return orderDB;
    }


    @Override
    public Order addOrder(Order order) throws IOException, BadRequestException {
        return super.addEntity(order);
    }

    @Override
    public Order deleteOrder(Order order) throws IOException, BadRequestException {
        return super.deleteEntity(order);
    }

    @Override
    public List<Order> getOrders() throws BadRequestException {
        return super.getEntities();
    }
}
