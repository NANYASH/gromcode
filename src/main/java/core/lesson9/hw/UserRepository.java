package core.lesson9.hw;


public class UserRepository {

    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        int number = 0;
        for (User user : users) {
            if (user != null) number++;
        }
        String[] userNames = new String[number];
        int index = 0;
        for (User user : users) {
            if (user != null) {
                userNames[index] = user.getName();
                index++;
            }
        }

        return userNames;
    }

    public long[] getUserIds() {
        int number = 0;
        for (User user : users) {
            if (user != null) number++;
        }
        long[] userIds = new long[number];
        int index = 0;
        for (User user : users) {
            if (user != null) {
                userIds[index] = user.getId();
                index++;
            }
        }
        return userIds;
    }

    public String getUserNameById(long id) {

        String name;

        for (User user : users) {
            if (user != null && user.getId() == id) {
                name = user.getName();
                return name;
            }
        }

        return null;

    }

    public User getUserByName(String name) {

        for (User user : users) {
            if (user != null && name.equals(user.getName()))
                return user;
        }
        return null;
    }

    public User getUserById(long id) {

        for (User user : users) {
            if (user != null && id == user.getId())
                return user;
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {

        for (User user : users) {
            if (user != null && sessionId.equals(user.getSessionId()))
                return user;
        }
        return null;
    }

    public User findById(long id) {
        for (User user : users) {
            if (user != null && id == user.getId())
                return user;
        }
        return null;
    }

    public User save(User user) {
        if (findById(user.getId()) == null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return user;
                }
            }
        }
        return null;
    }

    public User update(User user) {
        if (findById(user.getId()) != null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i].getId() == user.getId())
                    users[i] = user;
                return user;
            }
        }
        return null;
    }

    public User delete(User user) {
        if (findById(user.getId()) != null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i].getId() == user.getId())
                    users[i] = null;
                return user;
            }
        }
        return null;

    }

    public void delete(long id) {
        if (findById(id) != null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i].getId() == id) {
                    users[i] = null;
                    break;
                }
            }
        }

    }

}
