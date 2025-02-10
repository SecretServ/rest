package spring.rest.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import spring.rest.model.MyUser;
import spring.rest.service.UserService;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody MyUser myUser) {
        userService.create(myUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping (value = "/users")
    public ResponseEntity<List<MyUser>> read() {
        final List<MyUser> users = userService.readAll();

        return users != null &&  !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
