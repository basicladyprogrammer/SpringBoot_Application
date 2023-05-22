package com.example.backend;

public interface UserRepository {
    User getUserById(int id);
    void save(User user);

    void updateUser(User user);
}
