package com.example.Inventory_Management.Inventory.Management.Exceptions;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String message){
        super(message);
    }
}
