package dao;

import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    private SessionFactory sessionFactory;

    public UserDaoJdbcImpl() {
    }

    public UserDaoJdbcImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public List<User> findAll() {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM User");
        List<User> result = query.list();
        session.getTransaction().commit();
        return result;

    }

    public List<User> find(int id) {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM User U WHERE U.id = :userId");
        query.setParameter("userId", id);
        List<User> result = query.list();
        session.getTransaction().commit();
        return result;
    }

    public void save(User user) {

    }

    public void delete(int id) {

    }

    public void update(User user) {

    }
}
