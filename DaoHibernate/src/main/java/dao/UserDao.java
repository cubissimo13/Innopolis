package dao;

import models.User;
import java.util.List;

public interface UserDao {
    List<User> findAll();
    List<User> find(int id);
    void save(User user);
    void delete(int id);
    void update(User user);
}
