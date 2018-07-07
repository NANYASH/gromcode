package hibernate.lesson4.dao;


import hibernate.lesson4.entity.Order;
import hibernate.lesson4.exceptions.BadRequestException;

public class OrderDAO extends GenericDAO<Order> {
    @Override
    public Order save(Order order) {
        return super.save(order);
    }

    @Override
    public Order update(Order order) {
        return super.update(order);
    }

    @Override
    public void delete(Class<Order> c, long id) throws BadRequestException {
        super.delete(c, id);
    }

    @Override
    public Order findById(Class<Order> c, long id) throws BadRequestException {
        return super.findById(c, id);
    }
}
