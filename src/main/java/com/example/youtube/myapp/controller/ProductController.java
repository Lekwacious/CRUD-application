package com.example.youtube.myapp.controller;

import com.example.youtube.myapp.entities.Product;

import com.example.youtube.myapp.service.ProductRepository;
import org.hibernate.annotations.OnDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/welcome")
    public String sayHi(){
        return "welcome to the product page";
    }
//jackson converts POJO's to JSON
    @GetMapping("/product")
    public Product getProduct(){
        Product myProduct = new Product(1, "orange", 200.00);
        return myProduct;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){

        return productRepository.findAll();
    }
    @GetMapping("products/{id}")
    public Product getaProduct(@PathVariable int id){
        return productRepository.findById(id).get();
    }
    @DeleteMapping("products/{id}")
    public String deleteproduct(@PathVariable int id){
      productRepository.deleteById(id);

        return "product deleted";
    }
    @PostMapping("/products")
    public String addnewProduct(@RequestBody Product product ){
        productRepository.save(product);

        return "New product added successfully";

    }
}
