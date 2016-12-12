package dao;

import model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User find(int id);
    void save(User user);
    void delete(int id);
    void update(User user);
}
