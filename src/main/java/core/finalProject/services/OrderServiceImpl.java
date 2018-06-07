package core.finalProject.services;

import core.finalProject.dao.OrderDAO;
import core.finalProject.dao.impl.OrderDAOImpl;
import core.finalProject.entity.Hotel;
import core.finalProject.entity.Order;
import core.finalProject.entity.Room;
import core.finalProject.entity.User;
import core.finalProject.exceptions.BadRequestException;
import core.finalProject.exceptions.Forbidden;

import java.io.IOException;
import java.time.LocalDate;


public class OrderServiceImpl {
    OrderDAO orderDAO = new OrderDAOImpl();
    HotelServiceImpl hotelService = new HotelServiceImpl();
    RoomServiceImpl roomService = new RoomServiceImpl();


    public void addOrder(long roomId, User user, long hotelId, LocalDate from, LocalDate to) throws BadRequestException, Forbidden, IOException {
        Room room = roomService.findRoomById(roomId);
        if (!room.getDateAvailableFrom().isBefore(LocalDate.now()))
            throw new BadRequestException("Such room " + room + " is not available.");

        Hotel hotel = hotelService.findHotelById(hotelId);
        if (room.getHotel().getId() != hotel.getId())
            throw new BadRequestException("Such room " + room + " does not exist at such hotel " + hotel);

        roomService.updateRoom(room, to);
        orderDAO.addOrder(new Order(user, room, from, to, 0));
    }

    public void cancelOrder(long roomId) throws BadRequestException, Forbidden, IOException {
        Room room = roomService.findRoomById(roomId);
        roomService.updateRoom(room, LocalDate.now());
    }
}
