package BugTrackerSystem.User.controllers;

import BugTrackerSystem.User.exceptions.UserNotFoundException;
import BugTrackerSystem.User.models.User;
import BugTrackerSystem.User.repos.UserRepo;
import BugTrackerSystem.User.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;
    private UserRepo userRepo;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/createUser")
    public ResponseEntity<User> createUserRequest(@RequestBody User user) {
        User createUser = userService.createUser(user);
        ResponseEntity<User> response = new ResponseEntity<>(createUser, HttpStatus.CREATED);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> changeUser(@PathVariable Long id, @RequestBody User user){
        try{
            User changeUser = userService.changeUser(id, user);
            ResponseEntity<User> response = new ResponseEntity<>(changeUser, HttpStatus.OK);
            return response;
        } catch (UserNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) throws UserNotFoundException {
        userService.deleteUser(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
}

@GetMapping("/{id}")
    public ResponseEntity<?> showUserInfo(@PathVariable Long id){
        try{
            User user = userService.showUserInfo(id);
            ResponseEntity<?> response = new ResponseEntity<>(user, HttpStatus.OK);
            return response;
        } catch (UserNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
}
}
