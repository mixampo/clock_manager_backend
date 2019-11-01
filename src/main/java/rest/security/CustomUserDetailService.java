package rest.security;

import models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import rest.repository.UserRepository;

@Component
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository repo;

    public CustomUserDetailService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.fetchUserByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User with username : " + username + " could not be found");
        }
        return new User(user.getId(), user.getUsername(), user.getPassword());
    }
}
