package dao;

import user.User;
import java.util.ArrayList;
import java.util.List;

public class UserDaoListImpl implements UserDao{
    private ArrayList<User> userList = new ArrayList<User>();

    public List<User> findAll() {
        return this.userList;
    }

    public void update(User user) {
        for (int i=0; userList.size()>=i+1; i++  ) {
            if (userList.get(i).getId() == user.getId()) {
                userList.remove(i);
                userList.add(user);
                System.out.println("Пользователь с id " + userList.get(i).getId() + " успешно обнавлен");
            }  else {
                System.out.println("Пользователь с id " + user.getId() + " не найден" );
            }
        }
    }

    public void save(User user) {
        User tempUser = new User (user.getId(), user.getName(), user.getLogin(), user.getPassword());
        userList.add(tempUser);
    }

    public User find(int id) {
      for (User currentUser : userList){
          if (currentUser.getId() == id){
              return currentUser;
          }
      }
      return null;
    }

    public void delete(int id) {
        for (int i = 0; i < userList.size(); i++) {
            if (id == Integer.valueOf(userList.get(i).getId())) {
                userList.remove(i);
                System.out.println("Пользователь " + userList.get(i).getId() + " удален");
            } else {
                System.out.println("Пользователь с ID " + id + " не найден");
            }
        }
    }
}
