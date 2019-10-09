package rest.service;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.repository.IUserContainerRepo;

@Component
public class UserContainerService implements IUserContainerService {

    @Autowired
    private IUserContainerRepo repo;

    //TODO add check for username already exists
    @Override
    public Boolean addUser(User user) {
        repo.addUser(user);
        return true;
    }
}
