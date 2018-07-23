package hibernate.lesson4.demo.TestDAO;



import hibernate.lesson4.dao.UserDAO;
import hibernate.lesson4.entity.User;
import hibernate.lesson4.entity.UserType;
import hibernate.lesson4.exceptions.DBException;

public class UserDemolDAO {
    public static void main(String[] args) throws DBException {
        UserDAO userDAO = new UserDAO();

        User user = new User();


        user.setUserName("Rita");
        user.setPassword("password");
        user.setCountry("Kiev");
        user.setUserType(UserType.USER);


        userDAO.save(user);
        //System.out.println(userDAO.findByUserName("Anastasiia"));

    }
}
