package core.finalProject.demo;


import core.finalProject.controllers.UserControllerImpl;
import core.finalProject.dao.impl.RoomDAOImpl;
import core.finalProject.entity.Room;
import core.finalProject.exceptions.BadRequestException;
import core.finalProject.services.RoomServiceImpl;
import core.finalProject.utils.Filter;

import java.time.LocalDate;

public class DemoRoom {
    static Room room1 = new Room(1699745860, 4, 1500, true, true, LocalDate.now(), DemoHotel.hotel1);

    public static void main(String[] args) throws BadRequestException {
        DemoHotel demoHotel = new DemoHotel();
        //Room room1 = new Room(4, 1500, true, true, LocalDate.now(), demoHotel.hotel1);
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        RoomServiceImpl roomService = new RoomServiceImpl();
        Filter filter = new Filter();
        //filter.setNumberOfGuests(4);
        //filter.setCity("Kiev");
        UserControllerImpl userController = new UserControllerImpl();
        userController.logIn(DemoUsers.user1);
        //System.out.println(roomService.findRooms(filter));
        //roomService.addRoom(DemoUsers.user1,room1);
        //System.out.println(roomService.findRooms(filter));
        //roomDAO.deleteRoom(room1);
        System.out.println(roomDAO.getRooms());
    }
}