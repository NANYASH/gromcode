package core.lesson20.lecture.exception;


public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}
