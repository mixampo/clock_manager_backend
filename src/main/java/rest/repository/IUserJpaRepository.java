package rest.repository;

import models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJpaRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}
