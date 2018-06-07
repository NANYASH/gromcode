package core.lesson11;


public class BookingComAPI implements API {

    Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int number = 0;

        for (Room room : rooms) {
            if (room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                if (room.getPrice() >= price - 100 && room.getPrice() <= price + 100) {
                    number++;
                }
            }
        }

        Room[] foundRooms = new Room[number];
        number = 0;
        for (Room room : rooms) {
            if (room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                if (room.getPrice() >= price - 100 && room.getPrice() <= price + 100) {
                    foundRooms[number] = room;
                    number++;
                }
            }
        }
        return foundRooms;
    }

    public Room[] getAll() {
        return rooms;
    }
}
