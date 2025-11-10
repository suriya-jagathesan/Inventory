package com.example.Inventory_Management.Inventory.Management.DTO;

import lombok.Data;

@Data
public class ApiResponse {
    private String code;
    private String message;

    public ApiResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
