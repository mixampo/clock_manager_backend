package rest.service;

import models.User;

import java.util.List;

public interface IUserContainerService {
    Boolean addUser(User user);
    User getUserByUsername(User user);
    Boolean checkUserPwd(User user);
    List<User> getAllUsers();
    User getUserById(int id);
}
