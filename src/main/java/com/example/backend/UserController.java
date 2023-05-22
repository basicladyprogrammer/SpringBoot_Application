package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    //get user endpoint
    //todo: change the return type

    //todo: use Dependency injection for this
    UserRepository userRepository;
    @Autowired//using Dependency Injection
    UserController(UserRepository repository){
        this.userRepository = repository;
    }

    @GetMapping("/user") //HTTP GET method
    public User getUser(@RequestParam int id) {

        //get the user from the database

        return userRepository.getUserById(id);
        //and return

//        User user = new User();
//            user.name = "Nimal";
//            user.age = 20;
//            user.id = id;
//            return user;
    }
    //todo:
    // how use a post request

    //add user endpoint (user registration)
    @PostMapping("/user")
    public void addUser(@RequestBody User user) {
        //do validations
        //ex: check whether this user is already registered
        user.emailVerified = false;
        // send an email to the user - call an external email service for this
        userRepository.save(user);
    }

    //update the user
    @PatchMapping("/user")
    public void updateUser(@RequestBody User user){
        userRepository.updateUser(user);
    }

    //delete user
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam int id){
        userRepository.deleteUser(id);
    }
}
