package hibernate.lesson4.services;



import hibernate.lesson4.dao.RoomDAO;
import hibernate.lesson4.entity.Room;
import hibernate.lesson4.exceptions.AccessDenied;
import hibernate.lesson4.exceptions.BadRequestException;
import hibernate.lesson4.exceptions.DBException;
import hibernate.lesson4.exceptions.Forbidden;
import hibernate.lesson4.utils.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RoomServiceImpl {
    RoomDAO roomDAO = new RoomDAO();

    public Room addRoom(Room room) throws AccessDenied, Forbidden, BadRequestException, IOException, DBException {
        return roomDAO.save(room);
    }


    public void deleteRoom(long id) throws BadRequestException, AccessDenied, Forbidden, IOException {
         roomDAO.delete(id);
    }

    public List<Room> findRooms(Filter filter) throws BadRequestException {
        List<Room> foundRooms =
        roomDAO.findRoomsByParameters(filter);
        return foundRooms;
    }

    public Room findRoomById(long id) throws BadRequestException {
        return roomDAO.findById(Room.class,id);
    }

    public Room updateRoom(Room room, Date date) throws BadRequestException, IOException {
        room.setDateAvailableFrom(date);
        return roomDAO.update(room);
    }
}
