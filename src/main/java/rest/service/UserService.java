package rest.service;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IUserRepo;
import shared.PasswordHasher;

@Component
public class UserService implements IUserService {
    private PasswordHasher pwdHasher = new PasswordHasher();

    @Autowired
    private IUserContainerService userContainerService;

    @Autowired
    private IUserRepo repo;

    @Override
    public Boolean updateUser(User user) {
        if (user.getPassword().isEmpty()) {
            user.setPassword(userContainerService.getUserById(user.getId()).getPassword());
        }
        else {
            user.setPassword(pwdHasher.getPasswordHash(user.getPassword()));
        }
        return repo.updateUser(user);
    }
}
