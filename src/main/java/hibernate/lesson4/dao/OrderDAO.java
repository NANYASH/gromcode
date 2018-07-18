package hibernate.lesson4.dao;


import hibernate.lesson4.entity.Order;
import hibernate.lesson4.exceptions.BadRequestException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class OrderDAO extends GenericDAO<Order> {

    private static final String DELETE_ORDER_BY_ID = "DELETE * FROM ORDER_T WHERE ID = ?";

    @Override
    public Order save(Order order) {
        return super.save(order);
    }

    @Override
    public Order update(Order order) {
        return super.update(order);
    }

    @Override
    public void delete(long id) throws BadRequestException {
        try( Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(DELETE_ORDER_BY_ID);
            query.addEntity(Order.class);
            query.setParameter(1,id);
            query.executeUpdate();
        }catch (HibernateException e){
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public Order findById(Class<Order> c, long id) throws BadRequestException {
        return super.findById(c, id);
    }
}
