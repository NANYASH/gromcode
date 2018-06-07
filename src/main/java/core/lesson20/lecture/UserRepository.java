package core.lesson20.lecture;


import core.lesson20.lecture.exception.BadRequestException;
import core.lesson20.lecture.exception.InternalServerException;
import core.lesson20.lecture.exception.UserNotFoundException;

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

    public User findById(long id) throws UserNotFoundException {
        for (User user : users) {
            if (user != null && id == user.getId())
                return user;
        }
        throw new UserNotFoundException("User with id:" + id + " not found.");
    }

    public User save(User user) throws UserNotFoundException, BadRequestException, InternalServerException {
        try {
            findById(user.getId());
            throw new BadRequestException("User with id:" + user.getId() + "already exists");
        } catch (UserNotFoundException e) {
            System.out.println("User with id:" + user.getId() + "not found. Will be saved");
        }
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return user;
            }
        }
        throw new InternalServerException("Not enough space to save user with id:" + user.getId());
    }

    public User update(User user) throws UserNotFoundException, InternalServerException {
        findById(user.getId());
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == user.getId()) {
                users[i] = user;
                return users[i];
            }
        }
        throw new InternalServerException("Unexpected error");
    }

    public void delete(long id) throws UserNotFoundException {
        findById(id);
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == id) {
                users[i] = null;
                break;
            }
        }
    }

}
