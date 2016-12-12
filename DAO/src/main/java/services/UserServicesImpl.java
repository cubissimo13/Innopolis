package services;

import user.User;
import dao.UserDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServicesImpl implements UserServices {
    private UserDao userDao;
    private Scanner scanner = new Scanner(System.in);

    public UserServicesImpl(UserDao userDao) {
        this.userDao = userDao;

    }

    public boolean isRegistred(int id) {
            if ( userDao.find(id)!= null) {
                return true;
            }
        return false;
    }

    public void addUser(User user) {
        userDao.save(user);
        System.out.println("Пользователь " + user.getName() + "успешно добавлен");

    }

    public void showAllUsers() {
        List<User> tempList = new ArrayList<User>(userDao.findAll());
        System.out.println("В базе числится " + tempList.size() + " пользователей");
        for (User currentUser : tempList){
            System.out.println("id - " + currentUser.getId() +
                                " |имя - " + currentUser.getName() +
                                " |логин - " + currentUser.getLogin() +
                                " |пароль - " + currentUser.getPassword());
        }
    }

    public void removeUsers(int id) {
        userDao.delete(id);

    }

    public void updateUser(User newUser) {
        userDao.update(newUser);

    }


}
