package core.finalProject.dao;


import core.finalProject.entity.Order;
import core.finalProject.exceptions.BadRequestException;

import java.io.IOException;
import java.util.List;

public interface OrderDAO {
    public Order addOrder(Order order) throws IOException, BadRequestException;

    public Order deleteOrder(Order order) throws IOException, BadRequestException;

    public List<Order> getOrders() throws BadRequestException;
}
