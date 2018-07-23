package hibernate.lesson4.dao;


import hibernate.lesson4.entity.Room;
import hibernate.lesson4.exceptions.BadRequestException;
import hibernate.lesson4.exceptions.DBException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import java.util.List;

public class RoomDAO extends GenericDAO<Room> {

    private static final String ALL_ROOMS = "SELECT * FROM ROOM";
    private static final String DELETE_ROOM_BY_ID = "DELETE * FROM ROOM WHERE ID = ?";

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

    public List<Room> getAll() {
        try (Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(ALL_ROOMS);
            return query.getResultList();
        } catch (HibernateException e) {
            System.err.println("No rooms.");
            System.err.println(e.getMessage());
            throw e;
        }
    }

}
