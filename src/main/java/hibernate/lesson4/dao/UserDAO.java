package hibernate.lesson4.dao;

import hibernate.lesson4.entity.User;
import hibernate.lesson4.exceptions.BadRequestException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import javax.persistence.NoResultException;

public class UserDAO extends GenericDAO<User> {

    private static final String DELETE_USER_BY_ID = "DELETE * FROM USER WHERE ID = ?";
    private static final String FIND_USER_BY_USERNAME = "SELECT * FROM USER_T WHERE USER_NAME = ?";

    @Override
    public User save(User user) {
        return super.save(user);
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
