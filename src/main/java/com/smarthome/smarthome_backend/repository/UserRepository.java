package com.smarthome.smarthome_backend.repository;

import com.google.cloud.firestore.*;
import com.smarthome.smarthome_backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.firebase.auth.ActionCodeSettings;
import org.springframework.stereotype.Repository;
import com.smarthome.smarthome_backend.config.FirebaseConfig;

import java.net.http.HttpClient;
import java.util.concurrent.ExecutionException;

@Repository
public class UserRepository {

    @Autowired
    private Firestore firestore;

    private final String COLLECTION_NAME = "users";

    // Thêm người dùng
    public void addUser(User user) {
        firestore.collection(COLLECTION_NAME).document(user.getUsername()).set(user);
    }

    // Cập nhật người dùng
    public void updateUser(User user) {
        firestore.collection(COLLECTION_NAME).document(user.getUsername()).set(user);
    }

    // Xóa người dùng
    public void deleteUser(String username) {
        firestore.collection(COLLECTION_NAME).document(username).delete();
    }

    // Cập nhật vai trò của người dùng
    public void updateRole(String username, String role) {
        try {
            firestore.collection(COLLECTION_NAME).document(username).update("role", role).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật trạng thái của người dùng
    public void updateStatus(String username, Boolean status) {
        try {
            firestore.collection(COLLECTION_NAME).document(username).update("status", status).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật mật khẩu của người dùng
    public void updatePassword(String username, String password) {
        try {
            firestore.collection(COLLECTION_NAME).document(username).update("password", password).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật email của người dùng
    public void updateEmail(String username, String email) {
        try {
            firestore.collection(COLLECTION_NAME).document(username).update("email", email).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật họ tên của người dùng
    public void updateFullname(String username, String fullname) {
        try {
            firestore.collection(COLLECTION_NAME).document(username).update("fullname", fullname).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Lấy thông tin người dùng theo ID
    public User getUserById(String uid) {
        try {
            DocumentSnapshot document = firestore.collection(COLLECTION_NAME).document(uid).get().get();
            if (document.exists()) {
                return document.toObject(User.class);
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void userLogin(User user) {
        try {
            FirebaseConfig firebaseConfig = new FirebaseConfig();
            HttpClient ActionCodeSettings = null;
            firebaseConfig.firebaseAuth().generateSignInWithEmailLink(user.getEmail(), ActionCodeSettings);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

