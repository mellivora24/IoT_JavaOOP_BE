package com.smarthome.smarthome_backend.entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User {

    private String username;  // Tên đăng nhập (ID của người dùng)
    private String password;   // Mật khẩu (sẽ được mã hóa)
    private String email;      // Email
    private String role;       // Vai trò (admin, user, etc.)
    private Boolean status;    // Trạng thái người dùng (Active/Inactive)
    private String fullname;   // Họ và tên

    // Constructor mặc định (có thể sử dụng để chuyển đổi từ Firestore)
    public User() {}

    // Constructor với các tham số
    public User(String username, String password) {
        this.username = username;
        this.setPassword(password); // Mã hóa mật khẩu khi khởi tạo
    }

    // Getters và Setters cho các thuộc tính
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    // Mã hóa mật khẩu trước khi set
    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password); // Mã hóa mật khẩu
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                ", fullname='" + fullname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
