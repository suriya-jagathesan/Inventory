package com.example.Inventory_Management.Inventory.Management.Exceptions;

public class DuplicateEntryFoundException extends RuntimeException{
    public DuplicateEntryFoundException(String message){
        super(message);
    }
}
