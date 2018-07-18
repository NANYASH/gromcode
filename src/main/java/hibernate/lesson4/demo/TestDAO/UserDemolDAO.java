package hibernate.lesson4.demo.TestDAO;



import hibernate.lesson4.dao.UserDAO;
import hibernate.lesson4.entity.User;
import hibernate.lesson4.entity.UserType;

public class UserDemolDAO {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        User user = new User();


        user.setUserName("Anastasia");
        user.setPassword("password");
        user.setCountry("Kiev");
        user.setUserType(UserType.ADMIN);

        userDAO.save(user);
        //System.out.println(userDAO.findByUserName("Anastasiia"));

    }
}
