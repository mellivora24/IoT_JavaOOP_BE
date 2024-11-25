package com.smarthome.smarthome_backend.entity;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

public class Device {
    private String id;
    private String port;
    private String deviceId;
    private String deviceType;
    /* Thiet bi bat tat
    deviceType: digitalDevice
    deviceData: false -> tat, true -> bat
    */
    /* Thiet bi do
    deviceType: analogDevice
    deviceData: 0 -> 100
     */
    private String deviceName;
    private String deviceData;

    // Constructor mặc định
    public Device() {
    }

    // Constructor có tham số
    public Device(String id, String port, String deviceId, String deviceType, String deviceName, String deviceData) {
        this.id = id;
        this.port = port;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.deviceName = deviceName;
        this.deviceData = deviceData;
    }

    // Getters và setters
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceData() {
        return deviceData;
    }

    public void setDeviceData(String deviceData) {
        this.deviceData = deviceData;
    }

    // Lưu trữ vào Firestore
    public void saveToFirestore() {
        Firestore db = FirestoreClient.getFirestore(); // Lấy Firestore instance
        DocumentReference deviceRef = db.collection("devices").document(this.id);
        deviceRef.set(this); // Lưu trữ đối tượng này vào Firestore
    }

    // Phương thức withId
    public Device withId(String id) {
        this.id = id;
        return this;
    }
}
