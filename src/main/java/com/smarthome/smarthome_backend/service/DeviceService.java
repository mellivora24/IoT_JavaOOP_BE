package com.smarthome.smarthome_backend.service;

import com.smarthome.smarthome_backend.entity.Device;

import java.util.List;

public interface DeviceService {
    public List<Device> getAllDevices();
    public Device getDevice(String deviceID);
    public void addDevice(Device device);
    public void updateDevice(Device device);
    public void deleteDevice(String deviceID);
    public void updateDeviceStatus(String deviceID, Boolean status);
}
