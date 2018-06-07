package core.finalProject.entity;


public class User extends Entity {
    private String userName;
    private String password;
    private String country;
    private UserType userType;

    public User() {
    }

    public User(String userName, String password, String country, UserType userType) {
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    public User(long id, String userName, String password, String country, UserType userType) {
        super.setId(id);
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return userName != null ? userName.equals(user.userName) : user.userName == null;
    }

    @Override
    public int hashCode() {
        return userName != null ? userName.hashCode() : 0;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }


    @Override
    public String toString() {
        return super.getId() + "," +
                userName + "," +
                password + "," +
                country + "," +
                userType;
    }
}
