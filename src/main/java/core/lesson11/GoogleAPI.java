package core.lesson11;


public class GoogleAPI implements API {

    Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int number = 0;

        for (Room room : rooms) {
            if (room.getPrice() == price && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                number++;
            }
        }

        Room[] foundRooms = new Room[number];
        number = 0;
        for (Room room : rooms) {
            if (room.getPrice() == price && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                foundRooms[number] = room;
                number++;
            }
        }
        return foundRooms;
    }

    public Room[] getAll() {
        return rooms;
    }
}
