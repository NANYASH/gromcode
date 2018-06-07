package core.lesson11;


public class TripAdvisorAPI implements API {

    Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int number = 0;

        for (Room room : rooms) {
            if (room.getPrice() == price && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                if (room.getPersons() >= persons - 1 && room.getPersons() <= price + 1) {
                    number++;
                }
            }
        }

        Room[] foundRooms = new Room[number];
        number = 0;
        for (Room room : rooms) {
            if (room.getPrice() == price && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                if (room.getPersons() >= persons - 1 && room.getPersons() <= price + 1) {
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
