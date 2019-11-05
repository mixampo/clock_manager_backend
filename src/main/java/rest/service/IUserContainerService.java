package rest.service;

import models.User;

public interface IUserContainerService {
    Boolean addUser(User user);
    User getUserByUsername(User user);
    Boolean checkUserPwd(User user);
}
