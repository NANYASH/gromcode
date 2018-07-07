package hibernate.lesson4.exceptions;

public class AccessDenied extends Exception {
    public AccessDenied(String message) {
        super(message);
    }
}
