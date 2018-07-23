package hibernate.lesson4.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER_T")
public class User {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;
    List<Order> orders;

    public User() {
    }

    @SequenceGenerator(name = "US_SEQ", sequenceName = "USER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "US_SEQ")
    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE")
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @OneToMany( targetEntity = Order.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userOrdered")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (country != null ? !country.equals(user.country) : user.country != null) return false;
        return userType == user.userType;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", userType=" + userType +
                ", orders=" + orders +
                '}';
    }
}
