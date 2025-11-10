package com.example.Inventory_Management.Inventory.Management.Repository;

import com.example.Inventory_Management.Inventory.Management.entity.Products;
import com.example.Inventory_Management.Inventory.Management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {
    Optional<Products> findByName(String username);
}
