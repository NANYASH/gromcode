package hibernate.lesson4.services;



import hibernate.lesson4.dao.OrderDAO;
import hibernate.lesson4.entity.Hotel;
import hibernate.lesson4.entity.Order;
import hibernate.lesson4.entity.Room;
import hibernate.lesson4.entity.User;
import hibernate.lesson4.exceptions.BadRequestException;
import hibernate.lesson4.exceptions.DBException;
import hibernate.lesson4.exceptions.Forbidden;

import java.io.IOException;
import java.util.Date;


public class OrderServiceImpl {
    OrderDAO orderDAO = new OrderDAO();
    HotelServiceImpl hotelService = new HotelServiceImpl();
    RoomServiceImpl roomService = new RoomServiceImpl();


    public void addOrder(long roomId, User user, long hotelId, Date from, Date to) throws BadRequestException, Forbidden, IOException, DBException {
        Room room = roomService.findRoomById(roomId);
        if (!room.getDateAvailableFrom().before(new Date()))
            throw new BadRequestException("Such room " + room + " is not available.");

        Hotel hotel = hotelService.findHotelById(hotelId);
        if (room.getHotel().getId() != hotel.getId())
            throw new BadRequestException("Such room " + room + " does not exist at such hotel " + hotel);

        roomService.updateRoom(room, to);
        orderDAO.save(new Order(user, room, from, to, 0));
    }

    public void cancelOrder(long roomId) throws BadRequestException, Forbidden, IOException {
        Room room = roomService.findRoomById(roomId);
        roomService.updateRoom(room, new Date());
    }
}
