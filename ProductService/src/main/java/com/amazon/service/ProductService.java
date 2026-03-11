/*
 😉Author      : Vignesh Arjunan
 💻Role        : Software Engineer
 🐦‍🔥Created On  : 11-03-2026 17:44
 */

package com.amazon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.entity.Product;
import com.amazon.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository prodRepo;

    public List<Product> getAllProducts() {
        return prodRepo.findAll();
    }

    public Product saveProducts(Product product) {
        return prodRepo.save(product);
    }

    public Optional<?> findByProductID(Long productID) {
        return prodRepo.findById(productID);
    }
}
