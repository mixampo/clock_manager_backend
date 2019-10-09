package rest.controller;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import rest.service.IUserContainerService;

@RestController
public class UserController {

    @Autowired
    private IUserContainerService userContainerService;

    @PostMapping(value = "/register",
            headers = "Accept=application/json")
    public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
         if (userContainerService.addUser(user)) {
             HttpHeaders headers = new HttpHeaders();
             headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
             return new ResponseEntity<>(headers, HttpStatus.CREATED);
         }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
