package core.finalProject.services;

import core.finalProject.dao.RoomDAO;
import core.finalProject.dao.impl.RoomDAOImpl;
import core.finalProject.entity.Room;
import core.finalProject.exceptions.AccessDenied;
import core.finalProject.exceptions.BadRequestException;
import core.finalProject.exceptions.Forbidden;
import core.finalProject.utils.Filter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class RoomServiceImpl {
    RoomDAO roomDAO = new RoomDAOImpl();

    public Room addRoom(Room room) throws AccessDenied, Forbidden, BadRequestException, IOException {
        return roomDAO.addRoom(room);
    }


    public Room deleteRoom(Room room) throws BadRequestException, AccessDenied, Forbidden, IOException {
        return roomDAO.deleteRoom(room);
    }

    public ArrayList<Room> findRooms(Filter filter) throws BadRequestException {
        ArrayList<Room> foundedRooms = new ArrayList<>();
        for (Object o : roomDAO.getRooms())
            if (filter.findMatches((Room) o))
                foundedRooms.add((Room) o);
        return foundedRooms;
    }

    public Room findRoomById(long id) throws BadRequestException {
        return roomDAO.findRoomById(id);
    }

    public Room updateRoom(Room room, LocalDate localDate) throws BadRequestException, IOException {
        return roomDAO.updateRoomAvailableDate(room, localDate);
    }
}
