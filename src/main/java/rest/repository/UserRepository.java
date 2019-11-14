package rest.repository;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepository implements IUserContainerRepo, IUserRepo {

    @Autowired
    private IUserJpaRepository jpaRepository;

    @Override
    public void addUser(User user) { jpaRepository.save(user); }

    @Override
    public User fetchUserByUsername(String username) { return jpaRepository.findUserByUsername(username); }

    @Override
    public User fetchUserById(int id) { return jpaRepository.getOne(id); }

    @Override
    public Boolean updateUser(User user) {
        jpaRepository.save(user);
        return true;
    }

    @Override
    public List<User> fetchAllUsers() {
        return jpaRepository.findAll();
    }
}
