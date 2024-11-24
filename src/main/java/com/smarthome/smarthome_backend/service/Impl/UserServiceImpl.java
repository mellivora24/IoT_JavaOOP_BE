package com.smarthome.smarthome_backend.service.Impl;

import com.smarthome.smarthome_backend.entity.User;
import com.smarthome.smarthome_backend.repository.UserRepository;
import com.smarthome.smarthome_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void userLogin(User user) {
        userRepository.userLogin(user);
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public void addUser(String username, String password) {
        User user = new User(username, password);
        userRepository.addUser(user);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteUser(username);
    }

    @Override
    public void updateUser(String username, String password) {
        User user = new User(username, password);
        userRepository.updateUser(user);
    }

    @Override
    public void updateRole(String username, String role) {
        userRepository.updateRole(username, role);
    }

    @Override
    public void updatePassword(String username, String password) {
        userRepository.updatePassword(username, password);
    }

    @Override
    public void updateEmail(String username, String email) {
        userRepository.updateEmail(username, email);
    }

    @Override
    public void updateFullname(String username, String fullname) {
        userRepository.updateFullname(username, fullname);
    }

    @Override
    public User getUserById(String uid) {
        return userRepository.getUserById(uid);
    }
}
