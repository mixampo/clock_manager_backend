package rest.controller;

import models.User;
import org.omg.CORBA.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rest.service.IUserContainerService;
import rest.service.IUserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserContainerService userContainerService;

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/signup",
            headers = "Accept=application/json")
    public ResponseEntity<?> addUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
         if (userContainerService.addUser(user)) {
             HttpHeaders headers = new HttpHeaders();
             headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
             return new ResponseEntity<>(user, headers, HttpStatus.CREATED);
         }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin(origins = "http://localhost:4200/profile")
    @PutMapping(value = "/users",
        headers = "Accept=application/json")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        if (userService.updateUser(user)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){return userContainerService.getAllUsers();}
}
