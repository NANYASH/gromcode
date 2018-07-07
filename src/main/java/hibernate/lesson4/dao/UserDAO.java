package hibernate.lesson4.dao;

import hibernate.lesson4.entity.User;
import hibernate.lesson4.exceptions.BadRequestException;

public class UserDAO extends GenericDAO<User> {
    @Override
    public User save(User user) {
        return super.save(user);
    }

    @Override
    public User update(User user) {
        return super.update(user);
    }

    @Override
    public void delete(Class<User> c, long id) throws BadRequestException {
        super.delete(c, id);
    }

    @Override
    public User findById(Class<User> c, long id) throws BadRequestException {
        return super.findById(c, id);
    }
}
