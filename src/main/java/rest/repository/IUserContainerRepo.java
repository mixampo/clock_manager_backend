package rest.repository;

import models.User;

import java.util.List;

public interface IUserContainerRepo {
    void addUser(User user);
    User fetchUserByUsername(String username);
    User fetchUserById(int id);
    List<User> fetchAllUsers();
}
