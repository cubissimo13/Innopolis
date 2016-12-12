package dao;

import models.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

public class CarDaoJdbcImpl implements CarDao {
    private SessionFactory sessionFactory;

    public CarDaoJdbcImpl() {
    }

    public CarDaoJdbcImpl(SessionFactory session) {
        this.sessionFactory = session;
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public List<Car> findAll() {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Car");
        List<Car> result = query.list();
        session.getTransaction().commit();
        return result;
    }

    public Car find(int id) {
        return null;
    }

    public void save(Car car) {

    }

    public void delete(int id) {

    }

    public void update(Car car) {

    }
}


