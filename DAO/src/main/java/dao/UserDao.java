package dao;

import user.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();
    void update(User user);
    void save(User user);
    User find(int id);
    void delete(int id);
}
