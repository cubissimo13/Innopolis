package dao;

import model.Car;
import java.util.List;

public interface CarDao {
    List<Car> findAll();
    Car find(int id);
    void save(Car car);
    void delete(int id);
    void update(Car car);

}
