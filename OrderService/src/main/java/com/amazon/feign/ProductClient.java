/*
 😉Author      : Vignesh Arjunan
 💻Role        : Software Engineer
 🐦‍🔥Created On  : 11-03-2026 17:12
 */

package com.amazon.feign;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ProductService", url = "http://localhost:8081")
public interface ProductClient {

    @GetMapping("products/findByProductID/{productID}")
    public Optional<?> findByProductID(@PathVariable Long productID);
}
