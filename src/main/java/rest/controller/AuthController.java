package rest.controller;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rest.repository.IUserContainerRepo;
import rest.security.JwtTokenProvider;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    IUserContainerRepo userContainerRepo;

    @PostMapping(value = "/auth", headers = "Accept=application/json")
    public ResponseEntity<String> authorize(@RequestBody User user) {

        try {
            String username = user.getUsername();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, user.getPassword()));

            int uId = userContainerRepo.fetchUserByUsername(username).getId();
            String token = jwtTokenProvider.createToken(username) + "-Uid-" + uId;

            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid username/password supplied", HttpStatus.BAD_REQUEST);
        }
    }

}
