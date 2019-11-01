package rest.repository;

import models.User;

public interface IUserContainerRepo {
    void addUser(User user);
    User fetchUserByUsername(String username);
    User fetchUserById(int id);
}
