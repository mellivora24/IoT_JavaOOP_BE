package com.smarthome.smarthome_backend.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.smarthome.smarthome_backend.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class DeviceRepository {
    @Autowired
    private Firestore firestore;
    private final String COLLECTION_NAME = "devices";

    // Lấy tất cả các thiết bị
    public List<Device> getAllDevices() {
        List<Device> devices = new ArrayList<>();
        try {
            ApiFuture<QuerySnapshot> querySnapshot = firestore.collection(COLLECTION_NAME).get();
            for (DocumentSnapshot doc : querySnapshot.get().getDocuments()) {
                devices.add(doc.toObject(Device.class));
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return devices;
    }

    // Lấy thiết bị theo ID
    public Device getDeviceById(String deviceID) {
        try {
            DocumentSnapshot document = firestore.collection(COLLECTION_NAME).document(deviceID).get().get();
            if (document.exists()) {
                return document.toObject(Device.class);
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Kiểm tra thiết bị đã tồn tại dựa trên port
    public boolean isPortTaken(String port) {
        try {
            ApiFuture<QuerySnapshot> querySnapshot = firestore.collection(COLLECTION_NAME)
                    .whereEqualTo("port", port)
                    .get();
            return !querySnapshot.get().getDocuments().isEmpty();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Thêm thiết bị mới
    public void addDevice(Device device) {
        firestore.collection(COLLECTION_NAME).document(device.getId()).set(device);
    }

    // Cập nhật thiết bị
    public void updateDevice(Device device) {
        firestore.collection(COLLECTION_NAME).document(device.getId()).set(device);
    }

    // Xóa thiết bị
    public void deleteDevice(String deviceID) {
        firestore.collection(COLLECTION_NAME).document(deviceID).delete();
    }

    // Cập nhật trạng thái thiết bị
    public void updateDeviceStatus(String deviceID, Boolean status) {
        try {
            firestore.collection(COLLECTION_NAME).document(deviceID).update("status", status).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
