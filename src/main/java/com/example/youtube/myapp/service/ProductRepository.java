package com.example.youtube.myapp.service;


import com.example.youtube.myapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
