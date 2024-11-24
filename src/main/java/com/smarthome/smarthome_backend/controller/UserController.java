package com.smarthome.smarthome_backend.controller;

import com.smarthome.smarthome_backend.entity.User;
import com.smarthome.smarthome_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            userService.userLogin(user);
            return ResponseEntity.ok("Đăng nhập thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi đăng nhập");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Người dùng đã được thêm.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi hệ thống: " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        try {
            userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.OK).body("Người dùng đã được cập nhật.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi hệ thống: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        try {
            userService.deleteUser(username);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Người dùng đã được xóa.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi hệ thống: " + e.getMessage());
        }
    }

    @PutMapping("/updateRole/{username}/{role}")
    public ResponseEntity<String> updateRole(@PathVariable String username, @PathVariable String role) {
        try {
            userService.updateRole(username, role);
            return ResponseEntity.status(HttpStatus.OK).body("Vai trò người dùng đã được cập nhật.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi hệ thống: " + e.getMessage());
        }
    }

    @PutMapping("/updatePassword/{username}/{password}")
    public ResponseEntity<String> updatePassword(@PathVariable String username, @PathVariable String password) {
        try {
            userService.updatePassword(username, password);
            return ResponseEntity.status(HttpStatus.OK).body("Mật khẩu người dùng đã được cập nhật.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi hệ thống: " + e.getMessage());
        }
    }

    @PutMapping("/updateEmail/{username}/{email}")
    public ResponseEntity<String> updateEmail(@PathVariable String username, @PathVariable String email) {
        try {
            userService.updateEmail(username, email);
            return ResponseEntity.status(HttpStatus.OK).body("Email người dùng đã được cập nhật.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi hệ thống: " + e.getMessage());
        }
    }

    @PutMapping("/updateFullname/{username}/{fullname}")
    public ResponseEntity<String> updateFullname(@PathVariable String username, @PathVariable String fullname) {
        try {
            userService.updateFullname(username, fullname);
            return ResponseEntity.status(HttpStatus.OK).body("Họ tên người dùng đã được cập nhật.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi hệ thống: " + e.getMessage());
        }
    }

    @GetMapping("/{uid}")
    public ResponseEntity<User> getUserById(@PathVariable String uid) {
        try {
            return ResponseEntity.ok(userService.getUserById(uid));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
