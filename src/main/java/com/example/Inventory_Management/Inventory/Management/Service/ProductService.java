package com.example.Inventory_Management.Inventory.Management.Service;

import com.example.Inventory_Management.Inventory.Management.Exceptions.DuplicateEntryFoundException;
import com.example.Inventory_Management.Inventory.Management.Repository.ProductRepository;
import com.example.Inventory_Management.Inventory.Management.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Products addProduct(Products prod){
        Optional<Products> product = productRepository.findByName(prod.getName());
        if( !product.isEmpty() ){
            throw new DuplicateEntryFoundException("Product Name already exhist");
        }
        return productRepository.save(prod);
    }
}
