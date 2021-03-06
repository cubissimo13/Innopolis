package service;

import models.Car;
import models.User;

import java.util.List;

public interface UserServices {
    List<User> showAllUsers();
    boolean isRegistred(String name);
    void addUser(User user);
    void delUser(int id);
    List<User> findUser(int id);
    void updateUser(User user);

    List<Car> showAllCars();
    void addCar(Car car);
    void delCar(int id);
    Car findCar(int id);
    void updateCar(Car car);

}

