package com.example.backend;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component

public class InMemoryUserRepository implements UserRepository{

    Map<Integer, User> userMap = new HashMap<>();

    public InMemoryUserRepository() {
        User user1 = new User();
        user1.name = "Nimal";
        user1.id = 1;
        user1.age = 30;
        userMap.put(1,user1);

        User user2 = new User();
        user2.name = "Kamal";
        user2.id = 2;
        user2.age = 23;
        userMap.put(2, user2);
    }

    //get the user by id
    public User getUserById(int id){
        //ideally, query the database and fetch user
        return userMap.get(id);


//        User user = new User();
//        user.name = "Nimal";
//        user.id = id;
//        user.age = 35;
//        return user;
    }

    //write a method a new user to the database
    public void save(User user){
        userMap.put(user.id, user);
    }

    @Override
    public void updateUser(User user) {
        userMap.put(user.id, user);

    }
}
//todo:
// how use a post request