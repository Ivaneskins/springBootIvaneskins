package com.ivaneskins.springboot.my_spring_boot.service;



import com.ivaneskins.springboot.my_spring_boot.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User getUser(int id);
}
