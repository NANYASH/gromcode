package hibernate.lesson4.dao;

import hibernate.lesson2.hw.task2.Product;
import hibernate.lesson4.entity.User;
import hibernate.lesson4.entity.UserType;
import hibernate.lesson4.exceptions.BadRequestException;
import hibernate.lesson4.exceptions.DBException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.jws.soap.SOAPBinding;
import javax.persistence.NoResultException;
import java.sql.ResultSet;

public class UserDAO extends GenericDAO<User> {

    private static final String DELETE_USER_BY_ID = "DELETE * FROM USER_T WHERE ID = ?";
    private static final String FIND_USER_BY_USERNAME = "SELECT * FROM USER_T WHERE USER_NAME = ?";
    private static final String SAVE_USER = "INSERT INTO USER_T (ID,USER_NAME, PASSWORD, COUNTRY, USER_TYPE) " +
            "SELECT USER_SEQ.nextval,?,?,?,? " +
            "FROM dual " +
            "WHERE NOT EXISTS (SELECT 1 FROM USER_T WHERE USER_NAME = ?)";

    @Override
    public User save(User user) throws DBException {
        try( Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(SAVE_USER);
            query.addEntity(User.class);
            query.setParameter(1,"\'"+user.getUserName()+"\'");
            query.setParameter(2,"\'"+user.getPassword()+"\'");
            query.setParameter(3,"\'"+user.getCountry()+"\'");
            query.setParameter(4,"\'"+user.getUserType()+"\'");
            query.setParameter(5,"\'"+user.getUserName()+"\'");

            Transaction transaction = session.beginTransaction();
            if (query.executeUpdate() == 0){
                throw new DBException("User with name \'"+user.getUserName()+"\' cannot be added.");
            }
            transaction.commit();
        }catch (HibernateException e){
            System.err.println(e.getMessage());
            throw e;
        }
        return user;
    }


    @Override
    public User update(User user) {
        return super.update(user);
    }

    @Override
    public void delete(long id) throws BadRequestException {
        try( Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(DELETE_USER_BY_ID);
            query.addEntity(User.class);
            query.setParameter(1,id);
            query.executeUpdate();
        }catch (HibernateException e){
            System.err.println(e.getMessage());
            throw e;
        }
    }
    public User findByUserName(String userName){
        try(Session session = createSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery(FIND_USER_BY_USERNAME);
            query.addEntity(User.class);
            query.setParameter(1,userName);
            return (User) query.getSingleResult();
        }catch (HibernateException e){
            System.err.println(e.getMessage());
            throw e;
        }catch (NoResultException e){
            throw new NoResultException();
        }
    }

    @Override
    public User findById(Class<User> c, long id) throws BadRequestException {
        return super.findById(c, id);
    }
}
