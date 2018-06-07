package core.finalProject.dao;


import core.finalProject.entity.Room;
import core.finalProject.exceptions.BadRequestException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface RoomDAO {
    public Room addRoom(Room room) throws IOException, BadRequestException;

    public Room deleteRoom(Room room) throws BadRequestException, IOException;

    public List<Room> getRooms() throws BadRequestException;

    public Room findRoomById(long id) throws BadRequestException;

    public Room updateRoomAvailableDate(Room room, LocalDate localDate) throws IOException, BadRequestException;
}
