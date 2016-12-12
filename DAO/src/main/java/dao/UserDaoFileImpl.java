package dao;

import user.User;
import java.io.*;
import java.util.*;

public class UserDaoFileImpl implements UserDao {
    private final String FILE = "users/users.txt";
    private List<User> userList = new ArrayList<User>();

    public List<User> findAll() {
        try{
            FileInputStream fileInputStream = new FileInputStream(FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            userList = (List<User>) objectInputStream.readObject();
            return userList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void update(User user) {
        try{
            FileInputStream fileInputStream = new FileInputStream(FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            userList = (List<User>) objectInputStream.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(userList.size());

        for (int i=0; i+1 <= userList.size(); i++) {
            System.out.println("i=" + i + "user i " + userList.get(i).getId() + "user " + user.getId());
            if (userList.get(i).getId() == user.getId()) {
                userList.remove(i);
                userList.add(user);
                System.out.println("Пользователь с id " + userList.get(i).getId() + " успешно обнавлен");
                try {
                    FileOutputStream fileStream = new FileOutputStream(FILE);
                    ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
                    objectStream.writeObject(userList);
                    objectStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }  else {
                System.out.println("Пользователь с id " + user.getId() + " не найден" );
            }
        }
    }

    public void save(User user) {
        userList.add(user);
        try {
            FileOutputStream fileStream = new FileOutputStream(FILE);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(userList);
            System.out.println("Пользователь " + user.getName() + " сохранен в файл " + FILE);
            objectStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public User find(int id) {
        try{
            FileInputStream fileInputStream = new FileInputStream(FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            userList = (List<User>) objectInputStream.readObject();
            for (User currentUser : userList){
                if (currentUser.getId() == id){
                    return currentUser;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void delete(int id) {
        try{
            FileInputStream fileInputStream = new FileInputStream(FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            userList = (List<User>) objectInputStream.readObject();
            for (User currentUser : userList){
                if (currentUser.getId() == id){
                    userList.remove(currentUser);
                    System.out.println("Пользователь успешно удален");
                    ObjectOutputStream objectStream = new ObjectOutputStream(new FileOutputStream(FILE));
                    objectStream.writeObject(userList);
                } else {
                    System.out.println("Пользователь не найден");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
