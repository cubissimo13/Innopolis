package services;

import dao.CarDao;
import dao.UserDao;
import model.Car;
import model.User;

import java.util.List;

public class UserServicesImpl implements UserServices {
    private UserDao userDao;
    private CarDao carDao;

    public UserServicesImpl(UserDao userDao, CarDao carDao) {
        this.userDao = userDao;
        this.carDao = carDao;
    }

    public boolean isRegistred(String name) {
        List<User> tempUserList;
        tempUserList = userDao.findAll();
        for (User currentUser : tempUserList){
            if(currentUser.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public List<User> showAllUsers() {
        List<User> tempUserList;
        tempUserList = userDao.findAll();
        return tempUserList;
    }

    public void addUser(User user) {
        userDao.save(user);
    }

    public void delUser(int id){
        userDao.delete(id);
    }

    public User findUser(int id){
        return userDao.find(id);
    }

    public void updateUser(User user){
        userDao.update(user);
    }

//////////////////////////////////////////////////////////////////////////

    public List<Car> showAllCars() {
        List<Car> tempCarsList = carDao.findAll();
        return tempCarsList;
    }

    public void addCar (Car car){
        carDao.save(car);
    }

    public void delCar (int id) {
        carDao.delete(id);
    }

    public Car findCar (int id) {
        return carDao.find(id);
    }

    public void updateCar(Car car){
        carDao.update(car);
    }

    public List<Car> showAllCarsByOwner(int userId) {
        return carDao.findByOwner(userId);
    }
}
