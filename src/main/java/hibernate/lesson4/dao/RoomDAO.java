package hibernate.lesson4.dao;


import hibernate.lesson4.entity.Room;
import hibernate.lesson4.exceptions.BadRequestException;
import hibernate.lesson4.exceptions.DBException;
import hibernate.lesson4.utils.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public class RoomDAO extends GenericDAO<Room> {
    private static final String ALL_ROOMS = "SELECT * FROM ROOM";
    private static final String DELETE_ROOM_BY_ID = "DELETE * FROM ROOM WHERE ID = ?";
    private static final String FIND_ROOM_BY_PARAMETERS = "SELECT ROOM.* FROM ROOM " +
            "JOIN HOTEL ON ROOM.ID_HOTEL = HOTEL.ID WHERE ROOM.BREAKFAST_INCLUDED = ?" +
            " AND ROOM.PETS_ALLOWED = ? ";

    // AND ROOM.DATE_AVAILABLE_FROM = COALESCE(?,ROOM.DATE_AVAILABLE_FROM)

    @Override
    public Room save(Room room) throws DBException {
        return super.save(room);
    }

    @Override
    public Room update(Room room) {
        return super.update(room);
    }

    @Override
    public void delete(long id) throws BadRequestException {
        try( Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(DELETE_ROOM_BY_ID);
            query.addEntity(Room.class);
            query.setParameter(1,id);
            query.executeUpdate();
        }catch (HibernateException e){
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public Room findById(Class<Room> c, long id) throws BadRequestException {
        return super.findById(c, id);
    }

    public List<Room> findRoomsByParameters(Filter filter){
        try (Session session = createSessionFactory().openSession()) {
            String queryString = FIND_ROOM_BY_PARAMETERS;
            if (filter.getName() != null) queryString +=" AND HOTEL.HOTEL_NAME = \'"+filter.getName()+"\'";
            if (filter.getCountry() != null) queryString +=" AND HOTEL.COUNTRY = \'"+filter.getCountry()+"\'";
            if (filter.getCity() != null) queryString +=" AND HOTEL.CITY = \'"+filter.getCity()+"\'";
            if (filter.getStreet() != null) queryString +=" AND HOTEL.STREET = \'"+filter.getStreet()+"\'";
            if (filter.getNumberOfGuests() != 0) queryString +=" AND ROOM.NUMBER_OF_GUESTS = "+filter.getNumberOfGuests();
            if (filter.getPrice() != 0) queryString +=" AND ROOM.PRICE = "+filter.getPrice();
            if (filter.getDateAvailableFrom() != null) queryString +=" AND ROOM.DATE_AVAILABLE_FROM= "+filter.getDateAvailableFrom();
            NativeQuery query = session.createNativeQuery(queryString);
            query.addEntity(Room.class);
            query.setParameter(1,filter.getBreakfastIncluded());
            query.setParameter(2,filter.getPetsAllowed());
            List<Room> resultSet = query.getResultList();
            return resultSet;
        } catch (HibernateException e) {
            System.err.println("No rooms.");
            System.err.println(e.getMessage());
            throw e;
        }
    }


    public List<Room> getAll() {
        try (Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(ALL_ROOMS);
            query.addEntity(Room.class);
            List<Room> objects = query.getResultList();
            return objects;
        } catch (HibernateException e) {
            System.err.println("No rooms.");
            System.err.println(e.getMessage());
            throw e;
        }
    }

}
