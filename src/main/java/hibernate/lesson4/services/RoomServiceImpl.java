package hibernate.lesson4.services;



import hibernate.lesson4.dao.RoomDAO;
import hibernate.lesson4.entity.Room;
import hibernate.lesson4.exceptions.AccessDenied;
import hibernate.lesson4.exceptions.BadRequestException;
import hibernate.lesson4.exceptions.Forbidden;
import hibernate.lesson4.utils.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class RoomServiceImpl {
    RoomDAO roomDAO = new RoomDAO();

    public Room addRoom(Room room) throws AccessDenied, Forbidden, BadRequestException, IOException {
        return roomDAO.save(room);
    }


    public void deleteRoom(long id) throws BadRequestException, AccessDenied, Forbidden, IOException {
         roomDAO.delete(id);
    }

    public ArrayList<Room> findRooms(Filter filter) throws BadRequestException {
        ArrayList<Room> foundRooms = new ArrayList<>();
        for (Object o : roomDAO.getAll())
            if (filter.findMatches((Room) o))
                foundRooms.add((Room) o);
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
