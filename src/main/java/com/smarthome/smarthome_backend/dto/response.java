package com.smarthome.smarthome_backend.dto;

import java.util.List;

public class response<T> {
    private List<T> data;
    private String status;
    private String message;
}
