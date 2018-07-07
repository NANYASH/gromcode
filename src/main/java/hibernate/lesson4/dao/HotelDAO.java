package hibernate.lesson4.dao;


import hibernate.lesson4.entity.Hotel;
import hibernate.lesson4.exceptions.BadRequestException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class HotelDAO extends GenericDAO<Hotel> {

    private static final String HOTELS_BY_NAME = "SELECT * FROM HOTEL WHERE HOTEL_NAME = ?";
    private static final String HOTELS_BY_CITY = "SELECT * FROM HOTEL WHERE CITY = ?";

    @Override
    public Hotel save(Hotel hotel) {
        return super.save(hotel);
    }

    @Override
    public Hotel update(Hotel hotel) {
        return super.update(hotel);
    }

    @Override
    public void delete(Class<Hotel> c, long id) throws BadRequestException {
        super.delete(c, id);
    }

    @Override
    public Hotel findById(Class<Hotel> c, long id) throws BadRequestException {
        return super.findById(c, id);
    }

    public List<Hotel> findByName(String name){
        try(Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(HOTELS_BY_NAME);
            query.addEntity(Hotel.class);
            query.setParameter(1,name);
            return query.getResultList();
        }catch (HibernateException e){
            System.err.println("No hotels with such name.");
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public List<Hotel> findByCity(String name){
        try(Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(HOTELS_BY_CITY);
            query.addEntity(Hotel.class);
            query.setParameter(1,name);
            return query.getResultList();
        }catch (HibernateException e){
            System.err.println("No hotel with such city.");
            System.err.println(e.getMessage());
            throw e;
        }
    }
}
