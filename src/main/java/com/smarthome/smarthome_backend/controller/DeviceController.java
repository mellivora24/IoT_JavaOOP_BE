package com.smarthome.smarthome_backend.controller;

import com.smarthome.smarthome_backend.entity.Device;
import com.smarthome.smarthome_backend.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping("/all")
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devices = deviceService.getAllDevices();
        if (devices != null && !devices.isEmpty()) {
            return ResponseEntity.ok(devices);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDevice(@RequestBody Device device) {
        try {
            deviceService.addDevice(device);
            return ResponseEntity.status(HttpStatus.CREATED).body("Thiết bị đã được thêm.");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi hệ thống: " + ex.getMessage());
        }
    }

    @DeleteMapping("/delete/{deviceId}")
    public ResponseEntity<String> deleteDevice(@PathVariable String deviceId) {
        try {
            deviceService.deleteDevice(deviceId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Thiết bị đã được xóa.");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi hệ thống: " + ex.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateDevice(@RequestBody Device device) {
        try {
            deviceService.updateDevice(device);
            return ResponseEntity.status(HttpStatus.OK).body("Thiết bị đã được cập nhật.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi hệ thống: " + ex.getMessage());
        }
    }

    @PutMapping("/updateStatus/{deviceId}")
    public ResponseEntity<String> updateDeviceStatus(@PathVariable String deviceId, @RequestBody Boolean status) {
        try {
            deviceService.updateDeviceStatus(deviceId, status);
            return ResponseEntity.status(HttpStatus.OK).body("Trạng thái thiết bị đã được cập nhật.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi hệ thống: " + ex.getMessage());
        }
    }
}
