package core.finalProject.utils;


import java.util.Random;

public class IdUtil {
    public static long generateId() {
        int id = new Random().nextInt();
        if (id < 0) {
            id = id * -1;
        }
        return id;
    }
}
