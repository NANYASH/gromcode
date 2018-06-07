package core.lesson11;


public class Controller {

    API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }


    Room[] requestRooms(int price, int persons, String city, String hotel) {

        int number = 0;
        for (API api : apis) {
            if (api != null) {
                number += api.findRooms(price, persons, city, hotel).length;
            }
        }

        Room[] foundRooms = new Room[number];

        number = 0;
        for (API api : apis) {
            for (Room room : api.findRooms(price, persons, city, hotel)) {
                if (api != null) {
                    foundRooms[number] = room;
                    number++;
                }
            }
        }

        return foundRooms;
    }

    Room[] check(API api1, API api2) {

        int number = 0;

        for (Room room : api1.getAll()) {
            for (Room room1 : api2.getAll()) {
                if (room.getPrice() == room1.getPrice() && room.getPersons() == room1.getPersons()
                        && room.getHotelName().equals(room1.getHotelName()) && room.getCityName().equals(room1.getCityName())) {
                    number++;
                }
            }
        }

        Room[] sameRooms = new Room[number];

        number = 0;
        for (Room room : api1.getAll()) {
            for (Room room1 : api2.getAll()) {
                if (room.getPrice() == room1.getPrice() && room.getPersons() == room1.getPersons()
                        && room.getHotelName().equals(room1.getHotelName()) && room.getCityName().equals(room1.getCityName())) {
                    sameRooms[number] = room;
                    number++;
                }
            }
        }
        return sameRooms;
    }
}
