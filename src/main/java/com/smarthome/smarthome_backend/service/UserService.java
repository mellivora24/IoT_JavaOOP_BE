package com.smarthome.smarthome_backend.service;

import com.smarthome.smarthome_backend.entity.User;

public interface UserService {
    void userLogin(User user);

    void addUser(User user);
    void updateUser(User user);
    public void addUser(String username, String password);
    public void deleteUser(String username);
    public void updateUser(String username, String password);
    public void updateRole(String username, String role);
    public void updatePassword(String username, String password);
    public void updateEmail(String username, String email);
    public void updateFullname(String username, String fullname);
    User getUserById(String uid);
}
