package hibernate.lesson4;


import hibernate.lesson4.entity.User;

public class Session {
    private static User loggedInUser;

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        Session.loggedInUser = loggedInUser;
    }
}
