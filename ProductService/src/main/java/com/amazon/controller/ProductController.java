/*
 😉Author      : Vignesh Arjunan
 💻Role        : Software Engineer
 🐦‍🔥Created On  : 11-03-2026 17:16
 */

package com.amazon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.entity.Product;
import com.amazon.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService prodSvc;

    @GetMapping("/allproducts")
    public List<Product> getAllProducts() {
        return prodSvc.getAllProducts();
    }

    @PostMapping("/saveproducts")
    public ResponseEntity<?> saveProducts(@RequestBody Product product) {
        System.out.println("Received Product = " + product.getProductName());
        return ResponseEntity.ok(prodSvc.saveProducts(product));
    }

    @GetMapping("/findByProductID/{productID}")
    public Optional<?> findByProductID(@PathVariable Long productID) {
        return prodSvc.findByProductID(productID);
    }

}
