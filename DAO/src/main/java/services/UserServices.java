package services;

import user.User;

public interface UserServices {

    boolean isRegistred(int id);
    void addUser(User user);
    void showAllUsers();
    void removeUsers(int id);
    void updateUser(User user);

}
