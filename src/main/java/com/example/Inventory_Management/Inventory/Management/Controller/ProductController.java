package com.example.Inventory_Management.Inventory.Management.Controller;

import com.example.Inventory_Management.Inventory.Management.Service.ProductService;
import com.example.Inventory_Management.Inventory.Management.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/addProduct")
    public ResponseEntity<Products> addProducts(@RequestBody Products prod){
        Products added_prod = productService.addProduct(prod);
        return new ResponseEntity<>(added_prod, HttpStatus.OK);

    }
}
