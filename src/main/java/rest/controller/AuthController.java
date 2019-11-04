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
import rest.security.model.JwtResponse;
import rest.service.IUserContainerService;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    IUserContainerService userContainerService;

    @PostMapping(value = "/auth", headers = "Accept=application/json")
    public ResponseEntity<?> authorize(@RequestBody User user) {
        try {
            //Authenticate user that wants to log in to application's frontend
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            //Create token if user can be authorized (if user exists)
            JwtResponse response = new JwtResponse(jwtTokenProvider.createToken(user.getUsername()), userContainerService.getUserByUsername(user));

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid username/password supplied", HttpStatus.BAD_REQUEST);
        }
    }
}
