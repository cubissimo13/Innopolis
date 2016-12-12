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
        List<User> tempList = userDao.findAll();
        return tempList;
    }

    public boolean isRegistred(String name) {
        return false;
    }

    public void addUser(User user) {
        userDao.save(user);
    }

    public void delUser(int id) {
        userDao.delete(id);
    }

    public List<User> findUser(int id) {
        List<User> users = userDao.find(id);
        return users;
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public List<Car> showAllCars() {
        List<Car> tmpList = carDao.findAll();
        return tmpList;
    }

    public void addCar(Car car) {
        carDao.save(car);
    }

    public void delCar(int id) {
        carDao.delete(id);
    }

    public Car findCar(int id) {
        Car car = carDao.find(id);
        return car;
    }

    public void updateCar(Car car) {
        carDao.update(car);
    }
}
