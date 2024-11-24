package com.smarthome.smarthome_backend.service.Impl;

import com.smarthome.smarthome_backend.entity.Device;
import com.smarthome.smarthome_backend.repository.DeviceRepository;
import com.smarthome.smarthome_backend.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.getAllDevices();
    }

    @Override
    public Device getDevice(String deviceID) {
        return deviceRepository.getDeviceById(deviceID);
    }

    @Override
    public void addDevice(Device device) {
        if (deviceRepository.isPortTaken(device.getPort())) {
            throw new IllegalArgumentException("Port already in use.");
        }
        deviceRepository.addDevice(device);
    }

    @Override
    public void updateDevice(Device device) {
        deviceRepository.updateDevice(device);
    }

    @Override
    public void deleteDevice(String deviceID) {
        deviceRepository.deleteDevice(deviceID);
    }

    @Override
    public void updateDeviceStatus(String deviceID, Boolean status) {
        deviceRepository.updateDeviceStatus(deviceID, status);
    }
}
