package core.finalProject.dao.impl;

import core.finalProject.dao.RoomDAO;
import core.finalProject.entity.Room;
import core.finalProject.exceptions.BadRequestException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public class RoomDAOImpl extends GenericDAOImpl<Room> implements RoomDAO {
    private static String roomDB = "/Users/nanya/Desktop/gromcode/RoomDB.txt";


    @Override
    public Room parseEntity(String line) throws BadRequestException {
        String[] parameters = line.split(",");
        return new Room((Long.parseLong(parameters[0])), (Integer.parseInt(parameters[1])),
                Double.parseDouble(parameters[2]), Boolean.parseBoolean(parameters[3]),
                Boolean.parseBoolean(parameters[4]), LocalDate.parse(parameters[5]),
                new HotelDAOImpl().findEntityById(Long.parseLong(parameters[6])));
    }

    @Override
    public String getDb() {
        return roomDB;
    }

    @Override
    public Room updateRoomAvailableDate(Room room, LocalDate localDate) throws IOException, BadRequestException {
        List<Room> rooms = getEntities();
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getId() == room.getId()) {
                rooms.get(i).setDateAvailableFrom(localDate);
            }
        }
        writeToFile(roomDB, String.valueOf(deleteEmptyEntities(rooms)), false);
        return room;
    }

    @Override
    public Room addRoom(Room room) throws IOException, BadRequestException {
        return super.addEntity(room);
    }

    @Override
    public Room deleteRoom(Room room) throws BadRequestException, IOException {
        return super.deleteEntity(room);
    }

    @Override
    public List<Room> getRooms() throws BadRequestException {
        return super.getEntities();
    }

    @Override
    public Room findRoomById(long id) throws BadRequestException {
        return super.findEntityById(id);
    }

}
