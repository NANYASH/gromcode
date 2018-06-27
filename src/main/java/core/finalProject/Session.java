package core.finalProject;


import core.finalProject.entity.User;

public class Session {
    private static User loggedInUser;

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        Session.loggedInUser = loggedInUser;
    }
}
