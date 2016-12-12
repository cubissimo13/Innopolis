package service;

import dao.CarDao;
import dao.UserDao;
import models.Car;
import models.User;
import java.util.List;

public class UserServicesImpl implements UserServices {
    private UserDao userDao;
    private CarDao carDao;

    public UserServicesImpl(UserDao userDao, CarDao carDao) {
        this.userDao = userDao;
        this.carDao = carDao;
    }


    public List<User> showAllUsers() {
        return userDao.findAll();
    }

    public boolean isRegistred(String name) {
        return false;
    }

    public void addUser(User user) {
        userDao.write(user);
    }

    public void delUser(int id) {
        userDao.delete(id);
    }

    public List<User> findUser(int id) {
        return userDao.find(id);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public List<Car> showAllCars() {
        return carDao.findAll();
    }

    public void addCar(Car car) {
        carDao.save(car);
    }

    public void delCar(int id) {
        carDao.delete(id);
    }

    public Car findCar(int id) {
        return carDao.find(id);
    }

    public void updateCar(Car car) {
        carDao.update(car);
    }
}
