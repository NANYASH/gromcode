package core.lesson18.lecture.task2;


public class Converter {

    public static int stringToInt(String input) {
        try {
            return Integer.valueOf(input);
        } catch (Exception e) {
            System.err.println(input + "can not be converted to int");
            return 0;
        }
    }

    public static String intToString(String input) {
        try {
            return String.valueOf(input);
        } catch (Exception e) {
            System.err.println(input + "can not be converted to int");
            return null;
        }
    }

}
