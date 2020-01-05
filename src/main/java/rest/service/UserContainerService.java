package rest.service;

import com.sun.deploy.security.SelectableSecurityManager;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import rest.repository.IUserContainerRepo;
import shared.PasswordHasher;

import java.util.List;

@Component
public class UserContainerService implements IUserContainerService {
    private PasswordHasher pwdHasher = new PasswordHasher();

    @Autowired
    private IUserContainerRepo repo;

    @Override
    public Boolean addUser(User user) {
        if (repo.fetchUserByUsername(user.getUsername()) == null) {
            user.setPassword(pwdHasher.getPasswordHash(user.getPassword()));
            repo.addUser(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean checkUserPwd(User user) {
        User fetchedUser = getUserByUsername(user);

        if (fetchedUser == null) {
            return false;
        } else {
            return pwdHasher.getPasswordCheckStatus(user.getPassword(), fetchedUser.getPassword());
        }
    }

    @Override
    public User getUserByUsername(User user) {
        return repo.fetchUserByUsername(user.getUsername());
    }

    @Override
    public List<User> getAllUsers() {
        return repo.fetchAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return repo.fetchUserById(id);
    }
}
