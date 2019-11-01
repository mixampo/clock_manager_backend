package rest.repository;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepository implements IUserContainerRepo {

    @Autowired
    private IUserJpaRepository jpaRepository;

    @Override
    public void addUser(User user) { jpaRepository.save(user); }

    @Override
    public User fetchUserByUsername(String username) { return jpaRepository.findUserByUsername(username); }

    @Override
    public User fetchUserById(int id) { return jpaRepository.getOne(id); }
}
